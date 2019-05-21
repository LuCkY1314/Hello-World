package com.example.chansiqing.databindingstudy.fragment;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.activity.PictureCatchActivity;
import com.example.chansiqing.databindingstudy.data.MainFrameData;
import com.example.chansiqing.databindingstudy.data.ValueAnimFloorData;
import com.example.chansiqing.databindingstudy.databinding.FragmentHomeBinding;
import com.example.chansiqing.databindingstudy.floors.floor.ValueAnimFloor;
import com.example.chansiqing.databindingstudy.utils.JsonResource;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.MyFlipperView;
import com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter;
import com.google.gson.Gson;

/**
 * 主页的fragment
 *
 * @author: chansiqing
 * @date: 2019-02-13 11:35
 */
public class HomeFragment extends BaseFragment {
    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setItem(initMockData());
        binding.setPresenter(new MainFramePresenter());
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_in_cover);
        animation.setInterpolator(new LinearInterpolator());
        ObjectAnimator animator = ObjectAnimator.ofFloat(binding.rotate, "translationY", 0.0f, 350.0f, 0f);
        animator.setDuration(2500).start();
//        ValueAnimFloor valueAnimFloor = new ValueAnimFloor(getContext());
//        valueAnimFloor.setClipChildren(false);
//        ValueAnimFloorData data = new Gson().fromJson(JsonResource.valueAnimFloorJson, ValueAnimFloorData.class);
//        valueAnimFloor.updateItemData(data.getItems());
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, UIUtil.dp2px(100));
//        params.addRule(RelativeLayout.BELOW, R.id.rotate);
//        binding.root.addView(valueAnimFloor, params);

        LinearLayout relativeLayout = new LinearLayout(getContext());
        relativeLayout.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(100));
        params.addRule(RelativeLayout.BELOW, R.id.rotate);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(80));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtil.dp2px(80));
        LinearLayout linearLayout1 = new LinearLayout(getContext());
        linearLayout1.setBackgroundResource(R.color.colorAccent);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setBackgroundResource(R.color.softBlue);
        relativeLayout.addView(linearLayout1, layoutParams1);
        relativeLayout.addView(linearLayout2, layoutParams2);
        binding.root.addView(relativeLayout, params);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), PictureCatchActivity.class);
                getActivity().startActivity(intent);
            }
        });
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(linearLayout2, "translationY", 0, -UIUtil.dp2px(100), 0);
        animator1.setDuration(2000).setRepeatCount(20);
        animator1.start();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private MainFrameData initMockData() {
        MainFrameData data = new MainFrameData();
        MainFrameData.ItemBtnData btnData1 = new MainFrameData.ItemBtnData();
        btnData1.setSimpleBtnName("普通addView楼层");
        btnData1.setSimpleBtnVisible(true);
        btnData1.setMarginHorizon(UIUtil.dp2px(20));
        btnData1.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData2 = new MainFrameData.ItemBtnData();
        btnData2.setSimpleBtnName("bindingHolder混合楼层");
        btnData2.setSimpleBtnVisible(true);
        btnData2.setMarginVertical(UIUtil.dp2px(20));
        btnData2.setMarginHorizon(UIUtil.dp2px(20));
        btnData2.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData3 = new MainFrameData.ItemBtnData();
        btnData3.setSimpleBtnName("复用view的混合楼层");
        btnData3.setSimpleBtnVisible(true);
        btnData3.setMarginHorizon(UIUtil.dp2px(20));
        btnData3.setMarginVertical(UIUtil.dp2px(20));
        btnData3.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData4 = new MainFrameData.ItemBtnData();
        btnData4.setSimpleBtnName("仅为好看凑数的按钮");
        btnData4.setSimpleBtnVisible(true);
        btnData4.setMarginHorizon(UIUtil.dp2px(20));
        btnData4.setMarginVertical(UIUtil.dp2px(20));
        btnData4.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");
        MainFrameData.ItemBtnData btnData5 = new MainFrameData.ItemBtnData();
        btnData5.setSimpleBtnName("去另一个次元");
        btnData5.setSimpleBtnVisible(true);
        btnData5.setMarginHorizon(UIUtil.dp2px(20));
        btnData5.setMarginVertical(UIUtil.dp2px(20));
        btnData5.setSimpleBtnDrawableUrl("http://m.360buyimg.com/mobilecms/jfs/t27775/135/517402683/124382/348be7c3/5bb06cc6N0a8b634a.jpeg!q70.jpg.webp");

        data.setBtn1(btnData1);
        data.setBtn2(btnData2);
        data.setBtn3(btnData3);
        data.setBtn4(btnData4);
        data.setBtn5(btnData5);
        return data;
    }
}
