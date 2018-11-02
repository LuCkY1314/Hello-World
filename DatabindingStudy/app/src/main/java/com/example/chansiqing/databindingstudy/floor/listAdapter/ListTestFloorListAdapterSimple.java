package com.example.chansiqing.databindingstudy.floor.listAdapter;


import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.ListTestFloorItemData;
import com.example.chansiqing.databindingstudy.databinding.ListItemListFloorBinding;
import com.example.chansiqing.databindingstudy.floor.listHolder.BaseBindingHolder;
import com.example.chansiqing.databindingstudy.viewModel.BasePresenter;
import com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter;

/**
 * 列表实验楼层adapter
 * 角色作用：绑定view视图——viewHolder
 * 绑定视图所需的viewModel——presenter
 * （局部事务局部消化，闭合原则，真的需要和外部交互，通过接口丢出去）
 *
 * @author: chansiqing
 * @date: 2018-10-24 17:10
 */
public class ListTestFloorListAdapterSimple extends BaseBindingListAdapter<ListTestFloorItemData, ListItemListFloorBinding> {

    @Override
    public BaseBindingHolder<ListTestFloorItemData, ListItemListFloorBinding> createMyViewHolder(ViewGroup parent, int viewType) {
        return new BaseBindingHolder<ListTestFloorItemData, ListItemListFloorBinding>((ListItemListFloorBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_list_floor, parent, false)) {
            @Override
            public BasePresenter getPresenter() {
                return new ListTestFloorItemPresenter();
            }
        };
    }

}