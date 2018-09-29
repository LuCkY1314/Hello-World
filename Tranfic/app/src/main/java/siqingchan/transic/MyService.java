package siqingchan.transic;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by siqingchan on 2018/4/9.
 * mail:gonejobfindme@163.com
 */

public class MyService extends Service {
    private static final String TAG = "myService";
    private final Messenger messenger = new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    public static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MyConstance.MSG_FROM_CLIENT:
                    Log.d(TAG, "has received from client" + msg.getData().getString("msg"));
                    Messenger clientMessenger = msg.replyTo;
                    Message replyMessage = Message.obtain(null, MyConstance.MSG_FROM_SERVICE);
                    Bundle data = new Bundle();
                    data.putString("msg", "收到");
                    replyMessage.setData(data);
                    try {
                        clientMessenger.send(replyMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }
}
