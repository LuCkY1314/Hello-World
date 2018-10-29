package com.example.chansiqing.databindingstudy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.chansiqing.databindingstudy.data.BaseData;
import com.example.chansiqing.databindingstudy.floor.listAdapter.BaseBindingListAdapter;

import java.util.List;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-10-26 18:08
 */
public class MyRecycleView extends RecyclerView {
    private boolean isAtBottom;
    private boolean isAtTop;
    private boolean isUpToDown;

    public MyRecycleView(Context context) {
        super(context);
        initTouchIntercept();
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTouchIntercept();
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTouchIntercept();

    }

    public void setData(List<? extends BaseData> data) {
        BaseBindingListAdapter adapter = (BaseBindingListAdapter) getAdapter();
        if (adapter == null) return;
        adapter.setData(data);
    }



    private void initTouchIntercept() {
        addOnItemTouchListener(new OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if (!isAtBottom)
                    rv.getParent().requestDisallowInterceptTouchEvent(true);
                else {
                    rv.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LayoutManager layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager;
                if (layoutManager instanceof LinearLayoutManager) {
                    linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int lastItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    if (lastItemPosition == linearLayoutManager.getItemCount() - 1) {
                        isAtBottom = true;
                    } else {
                        isAtBottom = false;
                    }
                    int firstItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                    if (firstItemPosition == 0) {
                        isAtTop = true;
                    } else {
                        isAtTop = false;
                    }
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
