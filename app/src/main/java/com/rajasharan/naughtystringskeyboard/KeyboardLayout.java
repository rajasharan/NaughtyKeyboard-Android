package com.rajasharan.naughtystringskeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by rajasharan on 8/15/15.
 */
class KeyboardLayout extends ViewGroup {
    private NaughtyStringsIME mIME;
    private int mHeight;
    private RecyclerView mKeyboarView;
    private Paint mPaint;
    private Paint mTextPaint;
    private int mRadius;

    public KeyboardLayout(NaughtyStringsIME ime, Context context) {
        super(context);
        mIME = ime;
        mHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170,
                context.getResources().getDisplayMetrics());

        mKeyboarView = new RecyclerKeyboardView(context);
        mKeyboarView.setAdapter(new KeyboardAdapter(context, ime));
        mKeyboarView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        mKeyboarView.addItemDecoration(new KeyboardItemDecoration(context));

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.argb(128, 0, 0, 0));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStrokeWidth(2f);
        mTextPaint.setColor(Color.RED);

        mRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25,
                context.getResources().getDisplayMetrics());

        addView(mKeyboarView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY);
        mKeyboarView.measure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mKeyboarView.layout(l, t, r, b);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int cx = getRight() - 2 * mRadius;
        int cy = getBottom() - 2 * mRadius;

        canvas.drawCircle(cx, cy, mRadius, mPaint);
        canvas.drawLine(cx - mRadius / 2, cy - mRadius / 2, cx + mRadius / 2, cy + mRadius / 2, mTextPaint);
        canvas.drawLine(cx + mRadius / 2, cy - mRadius / 2, cx - mRadius / 2, cy + mRadius / 2, mTextPaint);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            if (isTouchOnCross(ev.getX(), ev.getY())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            if (isTouchOnCross(event.getX(), event.getY())) {
                mIME.clearText();
            }
        }
        return true;
    }

    private boolean isTouchOnCross(float x, float y) {
        int cx = getRight() - 2 * mRadius;
        int cy = getBottom() - 2 * mRadius;

        if (x >= cx - mRadius && x <= cx + mRadius && y >= cy - mRadius && y <= cy + mRadius) {
            return true;
        }

        return false;
    }
}
