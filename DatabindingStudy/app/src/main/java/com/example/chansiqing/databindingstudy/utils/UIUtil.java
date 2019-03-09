/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.chansiqing.databindingstudy.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.chansiqing.databindingstudy.activity.MyApp;

/**
 * ui工具
 *
 * @author: chansiqing
 * @date: 2018-10-09 15:18
 */
public class UIUtil {
    /**
     * dp转换成px
     */
    public static int dp2px(float dpValue) {
        float scale = MyApp.context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转换成dp
     */
    public static int px2dp(float pxValue) {
        float scale = MyApp.context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转换成px
     */
    public static int sp2px(float spValue) {
        float fontScale = MyApp.context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转换成sp
     */
    public static int px2sp(float pxValue) {
        float fontScale = MyApp.context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 获取屏幕的宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        WindowManager manager = (WindowManager) MyApp.context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }

    /**
     * 获取屏幕的高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }

    /**
     * 是否在默认展示区域中
     *
     * @param v
     * @param visiblePercent
     * @return
     */
    public static boolean isDisplayed(View v, int visiblePercent) {
        return isViewDisplay(v, 0, getScreenHeight(MyApp.context) - dp2px(60), visiblePercent);
    }

    /**
     * 检查传入的View是否在显示范围内
     *
     * @param v
     * @param topExcludeHeight 首页searchbar的高度
     * @param homeContentHeight 首页内容页的高度:即去掉底部bar后的高度
     * @param visiblePercent 显示了百分之多少的时候算
     * @return
     */
    public static boolean isViewDisplay(View v, int topExcludeHeight, int homeContentHeight, int visiblePercent) {
        if (v == null) return false;
        try {
            if (null == v.getParent() || null == v.getParent().getParent()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        boolean bRet = false;
        try {
            int viewHeight = v.getHeight();
            if (viewHeight == 0) {
                return false;
            }
            Rect rcVisible = new Rect();
            v.getWindowVisibleDisplayFrame(rcVisible);

            int[] location = new int[2];
            v.getLocationOnScreen(location);
            int viewTop = location[1];

            float fVisiblePercent = 0.0001f;
            if (visiblePercent > 100) {
                visiblePercent = 100;
            }

            if (visiblePercent > 0) {
                fVisiblePercent = visiblePercent / 100.0f;
            }
            bRet = (viewTop + (1 - fVisiblePercent) * viewHeight >= rcVisible.top + topExcludeHeight) && (viewTop + fVisiblePercent * viewHeight <= homeContentHeight);
        } catch (Exception e) {
            // 在getWindowVisibleDisplayFrame和getLocationOnScreen调用过程中可能view被detach,导致mAttachInfo为空引发NullPointerException
            // 当前min API < 19 没有太好的方法解决,因此使用try catch
        }

        return bRet;
    }
}
