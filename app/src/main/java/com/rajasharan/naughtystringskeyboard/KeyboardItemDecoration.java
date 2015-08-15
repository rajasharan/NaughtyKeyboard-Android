package com.rajasharan.naughtystringskeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rajasharan on 8/15/15.
 */
public class KeyboardItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public KeyboardItemDecoration(Context context) {
        TypedArray a = context.obtainStyledAttributes(new int[] {android.R.attr.listDivider});
        mDivider = a.getDrawable(0);
        a.recycle();
    }
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        for (int i=0; i<parent.getChildCount()-1; i++) {
            View child = parent.getChildAt(i);
            mDivider.setBounds(parent.getLeft(), child.getBottom(),
                    parent.getRight(), child.getBottom()+mDivider.getIntrinsicHeight());
            mDivider.draw(c);
        }
    }
}