package com.example.chansiqing.databindingstudy.fragment;

import android.support.v4.app.Fragment;

/**
 * 基类fragment
 *
 * @author: chansiqing
 * @date: 2019-02-13 18:09
 */
public class BaseFragment extends Fragment {
    public void hide() {
        getActivity().getSupportFragmentManager().beginTransaction().hide(this).commit();
    }

    public void show() {
        getActivity().getSupportFragmentManager().beginTransaction().show(this).commit();
    }

}
