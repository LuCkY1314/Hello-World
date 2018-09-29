package transic.scrollinterceptsample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import siqingchan.transic.aidl.Book;
import siqingchan.transic.aidl.IBookManager;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BaseFragment fragment1, fragment2, fragment3;
    private ServiceConnection connection;
    private static final String TAG = "MainActivity";
    private IBookManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        TextView textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (manager!=null){
                    Log.d(TAG,manager.toString());
                }
            }
        });
        fragment1 = new BaseFragment();
        fragment2 = new BaseFragment();
        fragment3 = new BaseFragment();
        fragment3.setTag(R.color.color3);
        fragment2.setTag(R.color.color2);
        fragment1.setTag(R.color.color1);
        List<Fragment> list = new ArrayList<>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setRotation(90);
        viewPager.setCurrentItem(0);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                manager = IBookManager.Stub.asInterface(service);
                Log.d(TAG, "serviceConnected");
                try {
                    List<Book> list = manager.getBookList();
                    Log.d(TAG, "service bookList" + list.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG,"connectionService failed");
            }
        };
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("siqingchan.transic", "siqingchan.transic.BookManagerService"));
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }
}
