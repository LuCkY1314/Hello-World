package chansiqing.myapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-08-21 18:15
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        Fresco.initialize(this);
    }
}
