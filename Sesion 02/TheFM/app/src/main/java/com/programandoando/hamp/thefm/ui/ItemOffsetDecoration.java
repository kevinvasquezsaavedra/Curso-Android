package com.programandoando.hamp.thefm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Usuario on 20/05/2016.
 */
public class ItemOffsetDecoration extends RecyclerView.ItemDecoration{
    private int nItemOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId)
    {
        int itemOffsetDp=context.getResources().getInteger(integerResId);
        nItemOffset=convertToPx(itemOffsetDp, context.getResources().getDisplayMetrics());
    }

    private int convertToPx(int OffsetDp, DisplayMetrics metrics) {
        return OffsetDp*(metrics.densityDpi/160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView
            .State state)
    {
        super.getItemOffsets(outRect, view, parent,state);
        outRect.set(nItemOffset,nItemOffset,nItemOffset,nItemOffset);
    }
}
