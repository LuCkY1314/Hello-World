package siqingchan.transic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button secondBtn, thirdBtn;
    private TextView textView;
    private ServiceConnection serviceConn;
    private Messenger messenger;
    private Messenger replyMessenger;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secondBtn = findViewById(R.id.second_btn);
        thirdBtn = findViewById(R.id.third_btn);
        secondBtn.setOnClickListener(this);
        thirdBtn.setOnClickListener(this);
        textView = findViewById(R.id.text);
        User.count++;
        textView.setText("hollow world" + User.count);
        replyMessenger = new Messenger(new ReplyMessengerHandler());
        serviceConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                messenger = new Messenger(service);
                Message message = Message.obtain(null, MyConstance.MSG_FROM_CLIENT);
                Bundle data = new Bundle();
                data.putString("msg", "进程间通信");
                message.setData(data);
                //很关键，用来告知service要用哪个Messenger去回复
                message.replyTo = replyMessenger;
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConn, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.second_btn:
                Intent intent = new Intent();
                intent.setClass(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.third_btn:
                Intent intent2 = new Intent();
                intent2.setClass(this, ThirdActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConn);
        super.onDestroy();
    }

    private static class ReplyMessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MyConstance.MSG_FROM_SERVICE:
                    Log.d(TAG, "has received from service" + msg.getData().getString("msg"));
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }
}
