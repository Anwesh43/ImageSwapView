package com.anwesome.ui.imageswapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 12/05/17.
 */
public class CircularImageView extends View {
    private Bitmap bitmap;
    public CircularImageView(Context context, Bitmap bitmap) {
        super(context);
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.argb(0,0,0,0));
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
    public void update(float factor) {

    }
}
