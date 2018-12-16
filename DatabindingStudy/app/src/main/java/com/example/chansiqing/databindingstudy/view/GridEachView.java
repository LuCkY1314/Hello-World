package com.example.chansiqing.databindingstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.chansiqing.databindingstudy.utils.UIUtil;

import java.util.List;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-12-11 17:17
 */
public class GridEachView extends RecyclerView {
    private static final int ID = 100001;

    public GridEachView(Context context) {
        super(context);
        setLayoutManager(new GridLayoutManager(context, 5));
    }

    public void setData(List<GridEntity> data) {
        if (data == null) return;
        MyAdapter adapter = new MyAdapter();
        adapter.setList(data);
        setAdapter(adapter);
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public GridViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(ID);
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<GridViewHolder> {

        private List<GridEntity> list;

        public List<GridEntity> getList() {
            return list;
        }

        public void setList(List<GridEntity> list) {
            this.list = list;
        }

        @Override
        public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = new View(parent.getContext());
            view.setId(ID);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(UIUtil.dp2px(50),UIUtil.dp2px(50));
            view.setLayoutParams(params);
            return new GridViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GridViewHolder holder, int position) {
            GridEntity entity = list.get(position);
            holder.view.setBackgroundResource(entity.color);
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }
    }

    public static class GridEntity {
        private int color;

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }

    public static class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        //间距
        private int space;
        //一行个数
        private int num;
        //画笔
        private Paint paint;
        //分割线闭合区域
        private Rect mRect = new Rect(0, 0, 0, 0);

        public SpaceItemDecoration(int space, int num, int color) {
            this.space = space;
            this.num = num;
            paint = new Paint();
            paint.setColor(color);
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
            drawVertical(c, parent);
            drawHorizontal(c, parent);
        }

        /**
         * 竖向分割线绘制
         *
         * @param c
         * @param parent
         */
        public void drawVertical(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + space;
                mRect.set(left, top, right, bottom);
                c.drawRect(mRect, paint);
            }
        }

        /**
         * 横向分割线绘制
         *
         * @param c
         * @param parent
         */
        public void drawHorizontal(Canvas c, RecyclerView parent) {
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + space;
                mRect.set(left, top, right, bottom);
                c.drawRect(mRect, paint);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //不是第一个的格子都设一个左边和底部的间距
            outRect.left = space;
            outRect.bottom = space;
            //由于每行都只有num个，所以第一个都是num的倍数，把左边距设为0
            if (parent.getChildLayoutPosition(view) % num == 0) {
                outRect.left = 0;
            }
        }
    }

}
