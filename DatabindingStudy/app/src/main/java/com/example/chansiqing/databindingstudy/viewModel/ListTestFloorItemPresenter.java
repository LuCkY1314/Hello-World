package com.example.chansiqing.databindingstudy.viewModel;

import android.support.v7.widget.LinearLayoutManager;

import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.data.ListTestFloorData;
import com.example.chansiqing.databindingstudy.floor.listAdapter.ListTestFloorListAdapterSimple;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.MyRecycleView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 列表楼层viewModel
 *
 * @author: chansiqing
 * @date: 2018-10-24 18:52
 */
public class ListTestFloorItemPresenter extends BasePresenter {
    /**
     * 将下发的时间戳转化成日期
     *
     * @param millisecond
     * @return
     */
    public String numberToDate(long millisecond) {
        Date date = new Date();
        date.setTime(millisecond * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");//12小时制
        return simpleDateFormat.format(date);
    }

    /**
     * 将下发的尺寸数据转化成dp为单位的大小
     *
     * @param number
     * @return
     */
    public int numberToPx(int number) {
        return UIUtil.dp2px(number);
    }

}
