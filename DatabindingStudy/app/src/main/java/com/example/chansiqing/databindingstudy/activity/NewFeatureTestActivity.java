package com.example.chansiqing.databindingstudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.chansiqing.databindingstudy.R;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2019-05-14 15:54
 */
public class NewFeatureTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(this).inflate(R.layout.fragment_new_feature_test, null, false);
        setContentView(view);
        super.onCreate(savedInstanceState);
    }

    private void initData(){

    }

}
