package qf.com.android_aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class PlusService extends Service {
    private static final String DESCRIPTOR = "CalcPlusService";
    public PlusService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }
    private MyBinder myBinder = new MyBinder();
    private class MyBinder extends Binder{
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 0x110: {
                    data.enforceInterface(DESCRIPTOR);
                    int arg0;
                    arg0 = data.readInt();
                    int arg1;
                    arg1 = data.readInt();
                    int result = arg0 + arg1;
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
                case 0x111: {
                    data.enforceInterface(DESCRIPTOR);
                    int arg0;
                    arg0 = data.readInt();
                    int arg1;
                    arg1 = data.readInt();
                    int result = arg0 * arg1;
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
}
