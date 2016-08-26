package com.pregnant.health.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 解决问题：
 * 		ScrollView内嵌套ListView时，ListView高度很小只能显示部分数据
 * 解决方案：
 * 		禁止ListView的滚动事件时可以解决该问题，只让ScrollView可以滚动
 * @author Sam
 *
 */
public class NoScrollListView extends ListView {

    private int mPosition;

    public NoScrollListView(Context context) {
        super(context);
    }

    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    // 禁止ListView滚动效果
//	@Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        final int actionMasked = ev.getActionMasked() & MotionEvent.ACTION_MASK;
// 
//        if (actionMasked == MotionEvent.ACTION_DOWN) {
//            mPosition = pointToPosition((int) ev.getX(), (int) ev.getY());
//            return super.dispatchTouchEvent(ev);
//        }
// 
//        if (actionMasked == MotionEvent.ACTION_MOVE) {
//            // 最关键的地方，忽略MOVE 事件
//        	// ListView onTouch获取不到MOVE事件所以不会发生滚动处理
//            return true;
//        }
// 
//        // 手指抬起时
//        if (actionMasked == MotionEvent.ACTION_UP
//        		|| actionMasked == MotionEvent.ACTION_CANCEL) {
//            // 手指按下与抬起都在同一个视图内，交给父控件处理，这是一个点击事件
//            if (pointToPosition((int) ev.getX(), (int) ev.getY()) == mPosition) {
//                super.dispatchTouchEvent(ev);
//            } else {
//            	// 如果手指已经移出按下时的Item，说明是滚动行为，清理Item pressed状态
//                setPressed(false);
//                invalidate();
//                return true;
//            }
//        }
// 
//        return super.dispatchTouchEvent(ev);
//    }
}
