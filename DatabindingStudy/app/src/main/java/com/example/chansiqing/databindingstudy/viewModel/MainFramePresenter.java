/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.viewModel;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.activity.ComplexFloorActivity;
import com.example.chansiqing.databindingstudy.activity.MixListActivity;
import com.example.chansiqing.databindingstudy.data.MainFrameData;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-09-30 19:15
 */
public class MainFramePresenter {

    public int isVisible(boolean flag) {
        return flag ? View.VISIBLE : View.GONE;
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn1:
                Toast.makeText(view.getContext(), "btn1 fuck click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), ComplexFloorActivity.class);
                view.getContext().startActivity(intent);
                break;
            case R.id.btn2:
                Toast.makeText(view.getContext(), "btn2 fuck click", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(view.getContext(), MixListActivity.class);
                view.getContext().startActivity(intent2);
                break;
            case R.id.btn3:
                Toast.makeText(view.getContext(), "btn3 fuck click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                Toast.makeText(view.getContext(), "btn4 fuck click", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onClick(View view, MainFrameData.ItemBtnData data) {
        Toast.makeText(view.getContext(), data.getSimpleBtnName() + " has been clicked", Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(view.getContext(), MixListActivity.class);
        view.getContext().startActivity(intent2);
    }
}
