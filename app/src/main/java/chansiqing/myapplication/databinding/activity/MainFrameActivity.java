package chansiqing.myapplication.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import chansiqing.myapplication.R;

/**
 * 启动页面
 *
 * @author: chansiqing
 * @date: 2018-09-30 14:29
 */
public class MainFrameActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_main_frame);
    }

}
