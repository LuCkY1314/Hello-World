package com.example.chansiqing.databindingstudy.viewModel;

import android.support.v7.widget.LinearLayoutManager;

import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.floor.listAdapter.ListTestFloorListAdapterSimple;
import com.example.chansiqing.databindingstudy.view.MyRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-26 18:28
 */
public class ListTestFloorPresenter extends BasePresenter {
    /**
     * 预先准备好recycleView的adapter和layoutManager
     *
     * @param view
     * @param list
     * @return
     */
    public ArrayList<ListTestFloorData> prepareAdapter(MyRecycleView view, ArrayList<ListTestFloorData> list) {
        ListTestFloorListAdapterSimple adapter = new ListTestFloorListAdapterSimple();
        view.setAdapter(adapter);
        adapter.setData(list);
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return list;
    }
}
