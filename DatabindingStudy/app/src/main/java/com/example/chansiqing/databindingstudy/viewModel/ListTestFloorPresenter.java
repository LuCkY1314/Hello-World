package com.example.chansiqing.databindingstudy.viewModel;

import android.support.v7.widget.LinearLayoutManager;

import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorItemData;
import com.example.chansiqing.databindingstudy.floor.listAdapter.ListTestFloorListAdapterSimple;
import com.example.chansiqing.databindingstudy.view.MyRecycleView;

import java.util.ArrayList;

/**
 * 列表测试楼层viewModel
 *
 * @author: chansiqing
 * @date: 2018-10-26 18:28
 */
public class ListTestFloorPresenter extends BasePresenter {
    /**
     * 预先准备好recycleView的adapter和layoutManager
     *
     * @param view
     * @param data
     * @return
     */
    public ArrayList<ListTestFloorItemData> prepareAdapter(MyRecycleView view, ListTestFloorData data) {
        ListTestFloorListAdapterSimple adapter = new ListTestFloorListAdapterSimple();
        view.setAdapter(adapter);
        adapter.setData(data.getList());
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return data.getList();
    }

    /**
     * 对比测试需要
     *
     * @param view
     * @param list
     * @return
     */
    public ArrayList<ListTestFloorItemData> prepareAdapterNew(MyRecycleView view, ArrayList<ListTestFloorItemData> list) {
        ListTestFloorListAdapterSimple adapter = new ListTestFloorListAdapterSimple();
        view.setAdapter(adapter);
        adapter.setData(list);
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return list;
    }
}
