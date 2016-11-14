package com.mesmerize.activitytest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.mesmerize.activitytest.R;


public class GuideTextView extends TextView {

    public GuideTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ini(context, attrs);
    }


    private void ini(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GuideTextView);
        radius = typedArray.getDimension(R.styleable.GuideTextView_radius, 0);
        arrowHeight = typedArray.getDimension(R.styleable.GuideTextView_arrowHeight, 0);
        color = typedArray.getColor(R.styleable.GuideTextView_bg, 0xffef67);
        mode = typedArray.getInt(R.styleable.GuideTextView_mode, 0);
    }


    public GuideTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ini(context, attrs);
    }


    public GuideTextView(Context context) {
        super(context);
    }


    private int mode;
    private float radius;
    private float arrowHeight;
    private int color;

    public void setMode(int mode) {
        this.mode = mode;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        radius = radius == 0 ? TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()) : radius;
        arrowHeight = arrowHeight == 0 ? TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) : arrowHeight;

        int left = 0;
        int bottom = getHeight();
        int right = getWidth();
        int top = 0;
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        float triangleTop;  //三角形顶点
        float triangleLeft; //底边左侧顶点
        float triangleRight; //底边右侧顶点
        switch (mode) {
            case 0://三角形在左
                left = (int) (left - arrowHeight + getPaddingLeft());
                triangleTop = getHeight() / 2;
                triangleLeft = triangleTop + arrowHeight;
                triangleRight = triangleTop - arrowHeight;
                path.moveTo(0, triangleTop);
                path.lineTo(left, triangleLeft);
                path.lineTo(left, triangleRight);
                path.lineTo(0, triangleTop);
                break;
            case 1://三角形在下
                bottom = (int) (bottom + arrowHeight - getPaddingBottom());
                triangleTop = getWidth() / 2;
                triangleLeft = triangleTop + arrowHeight;
                triangleRight = triangleTop - arrowHeight;
                path.moveTo(triangleTop, getHeight());
                path.lineTo(triangleRight, bottom);
                path.lineTo(triangleLeft, bottom);
                path.lineTo(triangleTop, getHeight());
                break;
            case 2://三角形在右
                right = (int) (right + arrowHeight - getPaddingRight());
                triangleTop = getHeight() / 2;
                triangleLeft = triangleTop - arrowHeight;
                triangleRight = triangleTop + arrowHeight;
                path.moveTo(getWidth(), triangleTop);
                path.lineTo(right, triangleRight);
                path.lineTo(right, triangleLeft);
                path.lineTo(getWidth(), triangleTop);
                break;
            case 4://左上
                top = (int) (top - arrowHeight + getPaddingTop());
                triangleTop = left + 30;
                triangleLeft = triangleTop - arrowHeight;
                triangleRight = triangleTop + arrowHeight;
                path.moveTo(triangleTop, 0);
                path.lineTo(triangleLeft, top);
                path.lineTo(triangleRight, top);
                path.lineTo(triangleTop, 0);
                break;
            case 5://右上
                top = (int) (top - arrowHeight + getPaddingTop());
                triangleTop = getWidth() - 30;
                triangleLeft = triangleTop - arrowHeight;
                triangleRight = triangleTop + arrowHeight;
                path.moveTo(triangleTop, 0);
                path.lineTo(triangleLeft, top);
                path.lineTo(triangleRight, top);
                path.lineTo(triangleTop, 0);
                break;
            case 6://左下
                bottom = (int) (bottom + arrowHeight - getPaddingBottom());
                triangleTop = left + 30;
                triangleLeft = triangleTop + arrowHeight;
                triangleRight = triangleTop - arrowHeight;
                path.moveTo(triangleTop, getHeight());
                path.lineTo(triangleRight, bottom);
                path.lineTo(triangleLeft, bottom);
                path.lineTo(triangleTop, getHeight());

                break;
            case 7://右下
                bottom = (int) (bottom + arrowHeight - getPaddingBottom());
                triangleTop = getWidth() - 30;
                triangleLeft = triangleTop + arrowHeight;
                triangleRight = triangleTop - arrowHeight;
                path.moveTo(triangleTop, getHeight());
                path.lineTo(triangleRight, bottom);
                path.lineTo(triangleLeft, bottom);
                path.lineTo(triangleTop, getHeight());
                break;
            default://三角形在上
                top = (int) (top - arrowHeight + getPaddingTop());
                triangleTop = getWidth() / 2;
                triangleLeft = triangleTop - arrowHeight;
                triangleRight = triangleTop + arrowHeight;
                path.moveTo(triangleTop, 0);
                path.lineTo(triangleLeft, top);
                path.lineTo(triangleRight, top);
                path.lineTo(triangleTop, 0);
                break;
        }

        canvas.drawRoundRect(new RectF(left, top, right, bottom), radius, radius, paint);
        path.close();
        canvas.drawPath(path, paint);
        super.onDraw(canvas);
    }


}