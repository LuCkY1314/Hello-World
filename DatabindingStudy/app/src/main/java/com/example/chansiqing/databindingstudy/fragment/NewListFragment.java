package com.example.chansiqing.databindingstudy.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.databinding.ActivityMixListBinding;
import com.example.chansiqing.databindingstudy.floors.listAdapter.MixFloorListNormalAdapter;
import com.example.chansiqing.databindingstudy.utils.BaseEvent;
import com.example.chansiqing.databindingstudy.utils.FloorTypeUtil;
import com.example.chansiqing.databindingstudy.utils.JsonResource;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通楼层列表fragment
 *
 * @author: chansiqing
 * @date: 2019-02-13 15:35
 */
public class NewListFragment extends BaseFragment {
    private static ActivityMixListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_mix_list, container, false);
        initView(binding);
        return binding.getRoot();
    }

    private void initView(ActivityMixListBinding binding) {
        binding.recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        MixFloorListNormalAdapter adapter = new MixFloorListNormalAdapter();
        adapter.setData(initData());
        binding.recycleView.setAdapter(adapter);
        binding.recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    EventBus.getDefault().post(new BaseEvent(BaseEvent.ON_SCROLL_STOP));
                } else {
                    EventBus.getDefault().post(new BaseEvent(BaseEvent.ON_SCROLL));
                }
            }
        });
    }

    private List<FloorData> initData() {
        List<FloorData> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FloorData item = new FloorData();
            item.setType(FloorTypeUtil.FLOOR_SINGLE_ANNOUNCEMENT + "");
            item.setFloorJson(JsonResource.singleAnnouncementFloorJson);
            list.add(item);
        }
        for (int i = 0; i < 7; i++) {
            FloorData data = new FloorData();
            data.setFloorJson(JsonResource.listNew[i % JsonResource.listNew.length]);
            data.setType((10001 + i % JsonResource.listNew.length) + "");
            list.add(data);
        }
        return list;
    }

    public static float getRecycleViewHeight() {
        return binding.recycleView.getY();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().post(new BaseEvent(BaseEvent.ON_PAUSE));
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().post(new BaseEvent(BaseEvent.ON_RESUME));
    }
}
