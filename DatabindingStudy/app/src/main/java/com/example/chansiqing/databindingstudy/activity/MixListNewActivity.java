package com.example.chansiqing.databindingstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.FloorData;
import com.example.chansiqing.databindingstudy.databinding.ActivityMixListBinding;
import com.example.chansiqing.databindingstudy.floor.listAdapter.MixFloorListNormalAdapter;
import com.example.chansiqing.databindingstudy.utils.JsonResource;

import java.util.ArrayList;
import java.util.List;

/**
 * 混合楼层的另一种优化方案
 *
 * @author: chansiqing
 * @date: 2018-10-30 17:36
 */
public class MixListNewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMixListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mix_list);
        initView(binding);
    }

    private void initView(ActivityMixListBinding binding) {
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        MixFloorListNormalAdapter adapter = new MixFloorListNormalAdapter();
        adapter.setData(initData());
        binding.recycleView.setAdapter(adapter);
    }

    private List<FloorData> initData() {
        List<FloorData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FloorData data = new FloorData();
            data.setFloorJson(JsonResource.listNew[i % 3]);
            data.setType((10001 + i % 3) + "");
            list.add(data);
        }
        return list;
    }
}
