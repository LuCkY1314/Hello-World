package siqingchan.transic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private ServiceConnection connection;
    private static final String TAG = "SecondActivity";
    private static final int MESSAGE_NEW_BOOK_ARRIVED = 1;
    private IBookManager rootManager;
    private IOnNewBookArrivedListener listener;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.text);
        textView.setText("second" + User.count);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MESSAGE_NEW_BOOK_ARRIVED:
                        Log.d(TAG, "received new book" + msg.obj);
                        break;
                    default:
                        super.handleMessage(msg);
                        break;
                }
            }
        };
        listener = new IOnNewBookArrivedListener.Stub() {
            @Override
            public void onNewBookArrived(Book newBook) throws RemoteException {
                handler.obtainMessage(MESSAGE_NEW_BOOK_ARRIVED, newBook).sendToTarget();
            }
        };
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IBookManager manager = IBookManager.Stub.asInterface(service);
                try {
                    rootManager = manager;
                    List<Book> list = manager.getBookList();
                    Log.d(TAG, "query list type" + list.getClass().getCanonicalName());
                    Log.d(TAG, "query list content" + list.toString());
                    Book newBook = new Book(3, "android 进阶");
                    manager.addBook(newBook);
                    List<Book> newList = manager.getBookList();
                    Log.d(TAG, "query new list content" + newList.toString());
                    manager.registerListener(listener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                rootManager = null;
                Log.d(TAG, "binder died");
            }
        };
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        if (rootManager != null && rootManager.asBinder().isBinderAlive()) {
            try {
                Log.d(TAG, "unregister listener:" + listener);
                rootManager.unregisterListener(listener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        unbindService(connection);
        super.onDestroy();
    }
}
