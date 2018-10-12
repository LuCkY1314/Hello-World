package com.example.chansiqing.databindingstudy.viewModel;

import android.databinding.InverseMethod;
import android.text.TextUtils;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-11 18:02
 */
public class AutoAdapterFloorPresenter {
    /**
     * 显示count默认值转换
     *
     * @param count
     * @return
     */
    @InverseMethod("countDefaultBack")
    public String countDefault(String count) {
        if (TextUtils.isEmpty(count)) {
            return "0";
        } else
            return count;
    }

    public String countDefaultBack(String count) {
        return count;
    }

    /**
     * 转化count为int值
     *
     * @param count
     * @return
     */
    @InverseMethod("countToIntBack")
    public int countToInt(String count) {
        if (TextUtils.isEmpty(count)) {
            return 0;
        } else {
            try {
                return Integer.parseInt(count);
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public String countToIntBack(int count) {
        return count + "";
    }
}
