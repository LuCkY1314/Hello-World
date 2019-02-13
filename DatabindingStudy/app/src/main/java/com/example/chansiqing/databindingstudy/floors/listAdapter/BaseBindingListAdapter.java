package com.example.chansiqing.databindingstudy.floors.listAdapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.floors.listHolder.BaseBindingHolder;

import java.util.List;


/**
 * 列表基类adapter
 * 说明：list的item中使用的data标签下，数据源都起名为"item"，方便统一设值（此adapter默认数据源别名是item，否则出错）
 * 同理，viewModel都起名为"presenter"
 *
 * @author: chansiqing
 * @date: 2018-10-24 17:17
 */
public abstract class BaseBindingListAdapter<K extends BaseData, T extends ViewDataBinding> extends RecyclerView.Adapter<BaseBindingHolder<K, T>> {
    protected List<K> data;

    @Override
    public BaseBindingHolder<K, T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return createMyViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseBindingHolder<K, T> holder, final int position) {
        if (getItemCount() == 0) return;
        //设置每个子view和数据绑定
        K item = data.get(position);
        if (item != null) {
            holder.bindView(item, position);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    //======================================== 提供外部调用 ===========================================

    /**
     * 设值数据源
     *
     * @param data
     */
    public void setData(List<K> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    //======================================= 外部必须实现的方法 ========================================

    /**
     * 创建多type的列表item
     *
     * @param parent
     * @param viewType
     */
    public abstract BaseBindingHolder<K, T> createMyViewHolder(ViewGroup parent, int viewType);

}
