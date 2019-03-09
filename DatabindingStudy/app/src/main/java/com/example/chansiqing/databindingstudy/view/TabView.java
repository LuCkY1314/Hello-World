package com.example.chansiqing.databindingstudy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.TabData;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 底部的导航栏
 *
 * @author: chansiqing
 * @date: 2019-02-13 14:31
 */
public class TabView extends RelativeLayout {
    private SimpleDraweeView image;
    private TextView text;
    private SimpleDraweeView redPoint;

    public TabView(Context context) {
        super(context);
        init();
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_tab_view, this);
        image = view.findViewById(R.id.tab_image);
        text = view.findViewById(R.id.tab_text);
        redPoint = view.findViewById(R.id.tab_point);
    }

    /**
     * 更新底部导航栏的状态
     *
     * @param data
     */
    public void adapterData(TabData data) {
        image.setImageURI(data.getImage());
        text.setText(data.getText());
        redPoint.setVisibility(data.isHasPoint() ? VISIBLE : GONE);
    }
}
