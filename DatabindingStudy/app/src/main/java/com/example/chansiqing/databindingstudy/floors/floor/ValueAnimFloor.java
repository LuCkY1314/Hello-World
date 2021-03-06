package com.example.chansiqing.databindingstudy.floors.floor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chansiqing.databindingstudy.data.ValueAnimFloorData;
import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.AttachAndDetachInterface;
import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;
import com.example.chansiqing.databindingstudy.utils.BaseEvent;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.MyFlipperView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 属性动画楼层
 *
 * @author: chansiqing
 * @date: 2019-01-25 18:36
 */
public class ValueAnimFloor extends RelativeLayout implements FloorMatchDataInterface, AttachAndDetachInterface {
    private Context context;
    private static final int MARGIN_WIDTH = UIUtil.dp2px(15);
    private static final int FLOOR_HEIGHT = UIUtil.dp2px(100);
    private static final int LINEAR_HEIGHT = UIUtil.dp2px(80);
    private static final int ITEM_SIZE = UIUtil.dp2px(40);
    private MyFlipperView myFlipperView;
    private List<ValueAnimFloorData.ItemData> data;

    public ValueAnimFloor(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ValueAnimFloor(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }


    /**
     * 初始化
     */
    private void init() {
        EventBus.getDefault().register(this);
        myFlipperView = new MyFlipperView(getContext(), MyFlipperView.VERTICAL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LINEAR_HEIGHT);
        myFlipperView.setEachLineHeight(LINEAR_HEIGHT);
        myFlipperView.addA_Layout(generateEachLinearLayout(MyFlipperView.FIRST_LAYOUT_ID));
        myFlipperView.addB_Layout(generateEachLinearLayout(MyFlipperView.SECOND_LAYOUT_ID));
        myFlipperView.setMaidianListener(new MyFlipperView.MaidianForFlipperSKU() {
            @Override
            public void onBothSideShow(boolean ifHasShowA, boolean ifHasShowB) {
                if (ifHasShowA) {
                    Toast.makeText(getContext(), "A_SIDE_SHOW", Toast.LENGTH_SHORT).show();
                    if (ifHasShowB)
                        Toast.makeText(getContext(), "AB_SIDE_SHOW", Toast.LENGTH_SHORT).show();
                } else if (ifHasShowB)
                    Toast.makeText(getContext(), "B_SIDE_SHOW", Toast.LENGTH_SHORT).show();
            }
        });
        addView(myFlipperView, params);
    }

    /**
     * 生成每一行布局（含有三个坑）
     */
    private LinearLayout generateEachLinearLayout(final int position) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(position);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(CENTER_VERTICAL);
        int screenWidth = UIUtil.getScreenWidth();
        int itemWidth = (screenWidth - MARGIN_WIDTH * 4) / 3;
        for (int i = 0; i < 3; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(itemWidth, ViewGroup.LayoutParams.MATCH_PARENT);
            int leftMargin = 0;
            LinearLayout eachLayout = generateEachLayout(i + 1, position);
            final int finalI = i;
            eachLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 1) {
                        myFlipperView.pauseAnimWhenScroll();
                    } else {
                        myFlipperView.initStart();
                    }
                    if (finalI + (position - 1) * 3 == 3) {
                        Toast.makeText(getContext(), "高性能启用", Toast.LENGTH_SHORT).show();
                        myFlipperView.setNeedSlowlyScroll(true);
                    } else if (finalI + (position - 1) * 3 == 5) {
                        Toast.makeText(getContext(), "低性能启用", Toast.LENGTH_SHORT).show();
                        myFlipperView.setNeedSlowlyScroll(false);
                    }
                    Toast.makeText(getContext(), "点你" + (finalI + (position - 1) * 3) + "爹作甚", Toast.LENGTH_SHORT).show();
                }
            });
            if (i == 0) {
                leftMargin = MARGIN_WIDTH;
            }
            params.setMargins(leftMargin, 0, MARGIN_WIDTH, 0);
            linearLayout.addView(eachLayout, params);
        }
        return linearLayout;
    }

    /**
     * 生成每个坑的布局
     *
     * @return
     */
    private LinearLayout generateEachLayout(int id, int position) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(ITEM_SIZE, ITEM_SIZE);
        imageParams.setMargins(0, MARGIN_WIDTH, 0, 0);
        SimpleDraweeView image = new SimpleDraweeView(context);
        image.setId(id * 10 + position);
        linearLayout.addView(image, imageParams);

        TextView text = new TextView(context);
        text.setId(id * 100 + position);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(text, textParams);
        return linearLayout;
    }

    @Override
    public void adapterData(Object data) {
        if (data instanceof ValueAnimFloorData) {
            updateUI((ValueAnimFloorData) data);
        }
    }

    @Override
    public int getFloorHeight() {
        return FLOOR_HEIGHT;
    }

    private void updateUI(ValueAnimFloorData data) {
        if (data == null) return;
        updateMargin(data.getMargin());
        updateItemData(data.getItems());
        this.data = data.getItems();
        myFlipperView.setCanPlay(UIUtil.isDisplayed(myFlipperView, 50));
        myFlipperView.initStartAnim();
    }

    /**
     * 用下发的margin值代替默认值
     *
     * @param margin
     */
    private void updateMargin(int margin) {
        LinearLayout linearLayout = findViewById(myFlipperView.FIRST_LAYOUT_ID);
        int itemWidth = (UIUtil.getScreenWidth() - margin * 4) / 3;
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            int marginLeft = 0;
            if (i == 0 || i == 3) {
                marginLeft = margin;
            }
            LinearLayout child = (LinearLayout) linearLayout.getChildAt(i);
            if (child != null) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) child.getLayoutParams();
                if (params != null) {
                    params.setMargins(marginLeft, 0, margin, 0);
                    params.width = itemWidth;
                }
            }
        }
    }

    /**
     * 更新每个坑里具体的展示数据
     *
     * @param list
     */
    public void updateItemData(List<ValueAnimFloorData.ItemData> list) {
        if (list == null || list.size() == 0) return;
        for (int i = 0; i < 6; i++) {
            ValueAnimFloorData.ItemData data = list.get(i);
            int id = i % 3;
            int position = i / 3 + 1;
            SimpleDraweeView image = findViewById((id + 1) * 10 + position);
            TextView textView = findViewById((id + 1) * 100 + position);
            if (data == null) continue;
            if (textView != null) {
                textView.setText(data.getText());
            }
            if (image != null) {
                image.setImageURI(data.getUrl());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(BaseEvent messageEvent) {
        String id = messageEvent.getId();
        switch (id) {
            case BaseEvent.ON_PAUSE:
                myFlipperView.checkMaidian();
                myFlipperView.pauseAnimWhenChangePage();
                myFlipperView.removeAllCallback();
                break;
            case BaseEvent.ON_RESUME:
                myFlipperView.checkMaidian();
                myFlipperView.setCanPlay(UIUtil.isDisplayed(myFlipperView, 50));
                myFlipperView.restartAnimWhenChangePage();
                break;
            case BaseEvent.ON_SCROLL:
                myFlipperView.pauseAnimWhenScroll();
                break;
            case BaseEvent.ON_SCROLL_STOP:
                myFlipperView.setCanPlay(UIUtil.isDisplayed(myFlipperView, 50));
                myFlipperView.restartAnimWhenScroll();
                break;
        }
    }

    @Override
    public void attachToRecycleView() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void detachToRecycleView() {
        EventBus.getDefault().unregister(this);
    }
}
