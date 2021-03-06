package com.example.chansiqing.databindingstudy.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.AnnouncementData;
import com.example.chansiqing.databindingstudy.floors.floor.BabelNewsRightsView;
import com.example.chansiqing.databindingstudy.floors.listAdapter.MyViewPagerAdapter;
import com.example.chansiqing.databindingstudy.utils.JsonResource;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.AutoWrapContentHeightViewPager;
import com.example.chansiqing.databindingstudy.view.BabelSingleFlipperView;
import com.example.chansiqing.databindingstudy.view.GridEachView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * gridView测试fragment
 *
 * @author: chansiqing
 * @date: 2019-02-13 19:42
 */
public class PageViewFragment extends BaseFragment {
    private AutoWrapContentHeightViewPager mViewPager;
    private Button btn;
    private MyViewPagerAdapter adapter;
    private List<GridEachView> list1, list2, list3;
    private int listNum;
    private BabelNewsRightsView babelNewsRightsView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_page_view, container, false);
        mViewPager = view.findViewById(R.id.view_pager);
        btn = view.findViewById(R.id.btn);
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
        babelNewsRightsView = view.findViewById(R.id.babel);
        AnnouncementData[] listAnnouncementData = new Gson().fromJson(JsonResource.singleAnnouncementFloorJson, AnnouncementData[].class);
        final List<AnnouncementData> data = new ArrayList<>(Arrays.asList(listAnnouncementData));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                babelNewsRightsView.adapterData(data);
            }
        },500);
        return view;
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
        GridEachView view1 = new GridEachView(getContext());
        view1.setData(list1);
        view1.addItemDecoration(new GridEachView.SpaceItemDecoration(UIUtil.dp2px(3), 5, R.color.softYellow));
        view1.setLayoutParams(params);

        List<GridEachView.GridEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softRed);
            list2.add(entity);
        }
        GridEachView view2 = new GridEachView(getContext());
        view2.setLayoutParams(params);
        view2.addItemDecoration(new GridEachView.SpaceItemDecoration(UIUtil.dp2px(3), 5, R.color.colorPrimary));
        view2.setData(list2);

        List<GridEachView.GridEntity> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softGreen);
            list3.add(entity);
        }
        GridEachView view3 = new GridEachView(getContext());
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
        GridEachView view1 = new GridEachView(getContext());
        view1.setData(list1);
        view1.addItemDecoration(new GridEachView.SpaceItemDecoration(10, 5, R.color.colorAccent));
        view1.setLayoutParams(params);

        List<GridEachView.GridEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softRed);
            list2.add(entity);
        }
        GridEachView view2 = new GridEachView(getContext());
        view2.setLayoutParams(params);
        view2.addItemDecoration(new GridEachView.SpaceItemDecoration(10, 5, R.color.colorPrimary));
        view2.setData(list2);

        List<GridEachView.GridEntity> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softBlue);
            list3.add(entity);
        }
        GridEachView view3 = new GridEachView(getContext());
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
        GridEachView view1 = new GridEachView(getContext());
        view1.setData(list1);
        view1.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.colorPrimaryDark));
        view1.setLayoutParams(params);

        List<GridEachView.GridEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softRed);
            list2.add(entity);
        }
        GridEachView view2 = new GridEachView(getContext());
        view2.setLayoutParams(params);
        view2.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.colorPrimary));
        view2.setData(list2);

        List<GridEachView.GridEntity> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.softBlue);
            list3.add(entity);
        }
        GridEachView view3 = new GridEachView(getContext());
        view3.setLayoutParams(params);
        view3.addItemDecoration(new GridEachView.SpaceItemDecoration(5, 5, R.color.softYellow));
        view3.setData(list3);

        List<GridEachView.GridEntity> list4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GridEachView.GridEntity entity = new GridEachView.GridEntity();
            entity.setColor(R.color.colorPrimary);
            list4.add(entity);
        }
        GridEachView view4 = new GridEachView(getContext());
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
