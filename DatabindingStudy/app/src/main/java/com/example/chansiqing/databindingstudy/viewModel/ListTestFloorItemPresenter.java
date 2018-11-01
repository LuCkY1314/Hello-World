package com.example.chansiqing.databindingstudy.viewModel;

import com.example.chansiqing.databindingstudy.utils.UIUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

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
