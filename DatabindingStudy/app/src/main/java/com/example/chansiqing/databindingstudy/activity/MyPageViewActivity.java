package com.example.chansiqing.databindingstudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.floor.listAdapter.MyViewPagerAdapter;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.AutoWrapContentHeightViewPager;
import com.example.chansiqing.databindingstudy.view.GridEachView;

import java.util.ArrayList;
import java.util.List;

/**
 * pageView测试
 *
 * @author: chansiqing
 * @date: 2018-12-11 14:52
 */
public class MyPageViewActivity extends AppCompatActivity {
    private AutoWrapContentHeightViewPager mViewPager;
    private Button btn;
    private MyViewPagerAdapter adapter;
    private List<GridEachView> list1, list2, list3;
    private int listNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_view);
        mViewPager = findViewById(R.id.view_pager);
        btn = findViewById(R.id.btn);
        initData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null) {
                    listNum++;
                    if (listNum % 3 == 0) {
                        listNum = 0;
                        adapter.setViews(list2);
                    } else if (listNum % 3 == 1) {
                        adapter.setViews(list3);
                    } else {
                        adapter.setViews(list1);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        adapter = new MyViewPagerAdapter();
        adapter.setViews(list1);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.requestLayout();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        list1 = initFirstDemoView();
        list2 = initSecondDemoView();
        list3 = initThirdDemoView();
    }

    private List<GridEachView> initFirstDemoView() {
        List<GridEachView.GridEntity> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softBlue);
            list1.add(entity);
        }
        List<GridEachView> list = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(3 + 50 * 2));
        GridEachView view1 = new GridEachView(this);
        view1.setData(list1);
        view1.addItemDecoration(new GridEachView.SpaceItemDecoration(UIUtil.dp2px(3), 5, R.color.softYellow));
        view1.setLayoutParams(params);

        List<GridEachView.GridEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softRed);
            list2.add(entity);
        }
        GridEachView view2 = new GridEachView(this);
        view2.setLayoutParams(params);
        view2.addItemDecoration(new GridEachView.SpaceItemDecoration(UIUtil.dp2px(3), 5, R.color.colorPrimary));
        view2.setData(list2);

        List<GridEachView.GridEntity> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softGreen);
            list3.add(entity);
        }
        GridEachView view3 = new GridEachView(this);
        view3.setLayoutParams(params);
        view3.addItemDecoration(new GridEachView.SpaceItemDecoration(3, 5, R.color.colorAccent));
        view3.setData(list3);

        list.add(view1);
        list.add(view2);
        list.add(view3);
        return list;
    }

    private List<GridEachView> initSecondDemoView() {
        List<GridEachView.GridEntity> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softGreen);
            list1.add(entity);
        }
        List<GridEachView> list = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(10 + 50 * 2));
        GridEachView view1 = new GridEachView(this);
        view1.setData(list1);
        view1.addItemDecoration(new GridEachView.SpaceItemDecoration(10, 5, R.color.colorAccent));
        view1.setLayoutParams(params);

        List<GridEachView.GridEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softRed);
            list2.add(entity);
        }
        GridEachView view2 = new GridEachView(this);
        view2.setLayoutParams(params);
        view2.addItemDecoration(new GridEachView.SpaceItemDecoration(10, 5, R.color.colorPrimary));
        view2.setData(list2);

        List<GridEachView.GridEntity> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softBlue);
            list3.add(entity);
        }
        GridEachView view3 = new GridEachView(this);
        view3.setLayoutParams(params);
        view3.addItemDecoration(new GridEachView.SpaceItemDecoration(10, 5, R.color.softYellow));
        view3.setData(list3);

        list.add(view1);
        list.add(view2);
        list.add(view3);
        return list;
    }

    private List<GridEachView> initThirdDemoView() {
        List<GridEachView.GridEntity> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.colorAccent);
            list1.add(entity);
        }
        List<GridEachView> list = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(5 + 50 * 2));
        GridEachView view1 = new GridEachView(this);
        view1.setData(list1);
        view1.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.colorPrimaryDark));
        view1.setLayoutParams(params);

        List<GridEachView.GridEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softRed);
            list2.add(entity);
        }
        GridEachView view2 = new GridEachView(this);
        view2.setLayoutParams(params);
        view2.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.colorPrimary));
        view2.setData(list2);

        List<GridEachView.GridEntity> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softBlue);
            list3.add(entity);
        }
        GridEachView view3 = new GridEachView(this);
        view3.setLayoutParams(params);
        view3.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.softYellow));
        view3.setData(list3);

        List<GridEachView.GridEntity> list4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.colorPrimary);
            list4.add(entity);
        }
        GridEachView view4 = new GridEachView(this);
        view4.setLayoutParams(params);
        view4.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.softYellow));
        view4.setData(list4);

        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        return list;
    }
}