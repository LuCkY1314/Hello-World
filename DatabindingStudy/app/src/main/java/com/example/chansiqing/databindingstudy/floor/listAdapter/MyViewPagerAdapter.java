package com.example.chansiqing.databindingstudy.floor.listAdapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.view.GridEachView;

import java.util.List;

/**
 * viewPager Adapter
 *
 * @author: chansiqing
 * @date: 2018-12-11 14:53
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<GridEachView> views;

    public List<GridEachView> getViews() {
        return views;
    }

    public void setViews(List<GridEachView> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public GridEachView instantiateItem(ViewGroup container, int position) {
        GridEachView view = views.get(position);
        view.setId(position);
        if (view != null)
            container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
