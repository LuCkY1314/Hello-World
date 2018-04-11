package transic.scrollinterceptsample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by siqingchan on 2018/4/11.
 * mail:gonejobfindme@163.com
 */

public class MyViewPager extends ViewGroup {
    private GestureDetector detector;

    public MyViewPager(Context context) {
        super(context);
        init(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
//              childView.layout(i*getWidth(), 0, (i+1)*getWidth(), getHeight());、//这是水平方向滑动
            childView.layout(0, i * getHeight(), getWidth(), (i + 1) * getHeight());//这是竖直方向滑动
        }
    }

    private void init(Context context) {
        detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /**
             * distanceX 在屏幕上要移动的距离 而不是坐标
             */
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                scrollBy(0, (int) distanceY);
                return true;
            }
        });
    }
}
