package com.bawei.liushibuju.dandianchukong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/6/6/0006.
 */

public class CircleView extends View {

    private Paint paint;
    private float x = 50;
    private float y = 50;

    Rect rect = new Rect();

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //创建一个画笔
        paint = new Paint();
        paint.setColor(Color.BLUE);
        //锯齿
        paint.setAntiAlias(true);

    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画圆
        canvas.drawCircle(x, y, 50, paint);

        rect.set((int)(x-100), (int)(y-100), (int)(x+100), (int)(y+100));

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:

                float x1 = event.getX();
                float y1 = event.getY();

                if (x1 > rect.left && x1 < rect.right && y1 > rect.top && y1 < rect.bottom){

                    x = event.getX();
                    y = event.getY();

                    //主线程调用刷新
                    invalidate();
                    //子线程 调用刷新
//                postInvalidate();

                }

                break;
            case MotionEvent.ACTION_UP:

                break;

        }

        return true;

    }
}
