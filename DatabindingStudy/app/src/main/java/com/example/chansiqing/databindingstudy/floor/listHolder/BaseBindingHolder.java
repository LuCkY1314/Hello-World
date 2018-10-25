package com.example.chansiqing.databindingstudy.floor.listHolder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chansiqing.databindingstudy.BR;
import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.viewModel.BasePresenter;

/**
 * ViewHolder 抽象类
 *
 * @author: chansiqing
 * @date: 2018-10-24 17:11
 */
public abstract class BaseBindingHolder<K extends BaseData, T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T dataBinding;

    /**
     * 构建每个viewHolder的公共逻辑
     *
     * @param dataBinding
     */
    public BaseBindingHolder(T dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        dataBinding.setVariable(BR.presenter, getPresenter());
    }

    /**
     * 公共holder绑定逻辑
     *
     * @param item
     * @param position
     */
    public void bindView(final K item, final int position) {
        dataBinding.setVariable(BR.item, item);
        dataBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnItemClickListener<K> onItemClickListener = getOnItemClickListener();
                if (onItemClickListener == null) return;
                onItemClickListener.onClick(item, position);
            }
        });
    }

    /**
     * 创建对应的viewModel
     *
     * @return
     */
    public abstract BasePresenter getPresenter();

    /**
     * 创建对应的itemClick监听器
     *
     * @return
     */
    public OnItemClickListener<K> getOnItemClickListener() {
        return null;
    }

//================================================ item点击监听 =====================================================

    /**
     * 每个item点击的回调
     */
    public interface OnItemClickListener<K> {

        void onClick(K item, int position);
    }
}
