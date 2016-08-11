package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class SquareCheckBox extends CheckBox {
    public SquareCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SquareCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareCheckBox(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int widthWithoutPadding = (width - getPaddingLeft()) - getPaddingRight();
        int heigthWithoutPadding = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (widthWithoutPadding < heigthWithoutPadding) {
            size = heigthWithoutPadding;
        } else {
            size = widthWithoutPadding;
        }
        setMeasuredDimension((getPaddingLeft() + size) + getPaddingRight(), (getPaddingTop() + size) + getPaddingBottom());
    }
}
