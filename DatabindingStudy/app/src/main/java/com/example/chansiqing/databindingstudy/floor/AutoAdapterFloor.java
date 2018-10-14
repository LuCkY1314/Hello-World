package com.example.chansiqing.databindingstudy.floor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorAutoAdapterBinding;
import com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter;

/**
 * 双向绑定实验
 *
 * @author: chansiqing
 * @date: 2018-10-11 14:13
 */
public class AutoAdapterFloor extends LinearLayout {
    private FloorAutoAdapterBinding binding;

    public AutoAdapterFloor(Context context) {
        super(context);
        init(context);
    }

    public AutoAdapterFloor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AutoAdapterFloor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.floor_auto_adapter, this, true);
        binding.setPresenter(new AutoAdapterFloorPresenter());
        binding.edit.setSelectAllOnFocus(true);
        binding.edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.edit.setSelection(s.length());
                //因为双向绑定中，当输入为空的时候，会在设置回数据model的时候发生强转错误，导致仍返回更改前的数据，
                //具体逻辑见dataBinding自动生成的类FloorAutoAdapterBinding的64行
                //所以提前判断这种情况，将其直接设为默认值0，以避免出现显示不符预期的问题
//                if (TextUtils.isEmpty(s)) {
//                    data.setCount(0);
//                }
                //或者解法2：将count设为String类型避免强转问题，即是现在的做法
            }
        });
    }

    /**
     * 适配数据源
     *
     * @param data
     */
    public void setData(final AutoAdapterFloorData data) {
        if (data == null) return;
        binding.setItem(data);
    }

    /**
     * 测试全局converse使用的数据源
     *
     * @param data
     */
    public void setModel(BindingAdapterTestFloorData data) {
        if (data == null) return;
        //binding.setModel(data);
    }
}
