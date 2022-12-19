package com.example.helloandroidworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class TwoColoredView extends View {
    private int measuredWidth, measuredHeight;
    private Paint topPaint, bottomPaint;

    public TwoColoredView(Context context) {
        super(context);
        init();
    }

    public TwoColoredView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TwoColoredView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        topPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        topPaint.setStyle(Paint.Style.FILL);
        topPaint.setColor(getResources().getColor(R.color.flag_top_color));

        bottomPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bottomPaint.setStyle(Paint.Style.FILL);
        bottomPaint.setColor(getResources().getColor(R.color.flag_bottom_collor));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, measuredWidth, measuredHeight * 0.01f * 50, topPaint);
        canvas.drawRect(0, measuredHeight * 0.01f * 50, measuredWidth, measuredHeight, bottomPaint);
    }
}
