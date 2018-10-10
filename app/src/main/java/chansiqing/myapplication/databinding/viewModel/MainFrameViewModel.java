/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package chansiqing.myapplication.databinding.viewModel;

import android.view.View;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-09-30 19:15
 */
public class MainFrameViewModel {

    public static int isVisible(boolean flag) {
        return flag ? View.VISIBLE : View.GONE;
    }
}
