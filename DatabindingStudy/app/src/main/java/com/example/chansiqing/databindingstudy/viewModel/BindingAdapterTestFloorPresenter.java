package com.example.chansiqing.databindingstudy.viewModel;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.text.TextUtils;

import com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 展示bindingAdapter楼层的viewModel
 *
 * @author: chansiqing
 * @date: 2018-10-12 15:01
 */
public class BindingAdapterTestFloorPresenter extends BasePresenter{
    /**
     * 自定义属性binding方法，参数需要一一对应，注解中的参数是xml中使用的属性，可以联合多个属性共同决定一个方法的执行内容
     *
     * @param view
     * @param isDefault 对应showDefault
     * @param url 对应url
     * @param defaultUrl 对应url2
     */
    @BindingAdapter({"showDefault", "url", "url2"})
    public static void loadImage(SimpleDraweeView view, boolean isDefault, String url, String defaultUrl) {
        if (TextUtils.isEmpty(url)) return;
        if (isDefault) view.setImageURI(url);
        else view.setImageURI(defaultUrl);
    }

    /**
     * convert注解作用是，在使用dataBinding的setter时，输入类型与setter类型不一致，
     * dataBinding会自动检索所有此注解下的类型转换方法，找到符合转换前后两种类型的方法为止
     *
     * @param data
     * @return
     */
    @BindingConversion
    public static String convertDataToString(BindingAdapterTestFloorData data) {
        if (data == null) return "";
        if (data.getShowDefault())
            return "展示的图片是" + data.getUrl();
        else
            return "展示的图片是" + data.getUrl2();
    }

}
