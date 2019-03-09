package com.example.chansiqing.databindingstudy.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.databinding.ActivityMixListBinding;
import com.example.chansiqing.databindingstudy.floors.listAdapter.MixFloorListAdapter;
import com.example.chansiqing.databindingstudy.utils.JsonResource;

import java.util.ArrayList;
import java.util.List;

import static com.example.chansiqing.databindingstudy.utils.FloorTypeUtil.FLOOR_LIST_TEST;

/**
 * dataBinding列表fragment
 *
 * @author: chansiqing
 * @date: 2019-02-13 19:39
 */
public class ListFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ActivityMixListBinding binding = DataBindingUtil.inflate(inflater, R.layout.activity_mix_list, container, false);
        initView(binding);
        return binding.getRoot();
    }

    private void initView(ActivityMixListBinding binding) {
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        MixFloorListAdapter adapter = new MixFloorListAdapter();
        adapter.setData(initData());
        binding.recycleView.setAdapter(adapter);
    }

    private List<FloorData> initData() {
        List<FloorData> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FloorData data = new FloorData();
            data.setFloorJson(JsonResource.list[i % 2]);
            data.setType((10001 + i % 2) + "");
            list.add(data);
        }
        FloorData data = new FloorData();
        data.setFloorJson(JsonResource.listTestJson);
        data.setType(FLOOR_LIST_TEST + "");
        list.add(data);
        return list;
    }

}
