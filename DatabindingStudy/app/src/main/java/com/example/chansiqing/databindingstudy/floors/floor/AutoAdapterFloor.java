package com.example.chansiqing.databindingstudy.floors.floor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData;
import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.example.chansiqing.databindingstudy.databinding.FloorAutoAdapterBinding;
import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;
import com.example.chansiqing.databindingstudy.floors.wrapContentParentFloor.LinearLayoutFloor;
import com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter;

/**
 * 双向绑定实验
 *
 * @author: chansiqing
 * @date: 2018-10-11 14:13
 */
public class AutoAdapterFloor extends LinearLayoutFloor implements FloorMatchDataInterface {
    private FloorAutoAdapterBinding binding;
    private AutoAdapterFloorData data;

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
                //如果不使用双向绑定，则设置数据和数据改变通知view都不会自动发生，需要手动设置如下：
//                int progress = 0;
//                try {
//                    progress = Integer.parseInt(s.toString().trim());
//                } catch (Exception e) {
//                }
//                binding.seekBar.setProgress(progress);
//                data.setCount(s.toString());
            }
        });

        //如果不使用双向绑定，数据改变通知view不会自动发生，需要手动设置如下：
        /*binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.edit.setText(progress + "");
                //binding.text.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/
    }

    /**
     * 适配数据源
     *
     * @param data
     */
    public void setData(final AutoAdapterFloorData data) {
        if (data == null) return;
        this.data = data;
        binding.setItem(data);
    }

    /**
     * 测试全局converse使用的数据源
     *
     * @param data
     */
    public void setModel(BindingAdapterTestFloorData data) {
        if (data == null) return;
        binding.setModel(data);
        //如果不使用dataBinding，这里也能实现view和data的绑定，逻辑写在此处
        //比如每个textView的展示文案赋值，simpleDrawee图片展示赋值，EditText文案赋值
    }

    @Override
    public void adapterData(Object data) {
        if (data instanceof AutoAdapterFloorData)
            setData((AutoAdapterFloorData) data);
    }

    //因为双向绑定中，当输入为空的时候，会在设置回数据model的时候发生强转错误，导致仍返回更改前的数据，
    //具体逻辑见dataBinding自动生成的类FloorAutoAdapterBinding的64行
    //所以提前判断这种情况，将其直接设为默认值0，以避免出现显示不符预期的问题
//                if (TextUtils.isEmpty(s)) {
//                    data.setCount(0);
//                }
    //或者解法2：将count设为String类型避免强转问题，即是现在的做法
}
