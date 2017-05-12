package com.anwesome.ui.imageswapview;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 12/05/17.
 */
public class CircularImageView extends View {
    private Bitmap bitmap;
    private int w,h,render = 0;
    private OnTapListener onTapListener;
    private CircularImage circularImage = new CircularImage();
    public CircularImageView(Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void setOnTapListener(OnTapListener onTapListener) {
        this.onTapListener = onTapListener;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
    }
    public void onDraw(Canvas canvas) {
        if(render == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        canvas.drawColor(Color.argb(0,0,0,0));
        circularImage.draw(canvas);
        render++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(onTapListener != null && event.getAction() == MotionEvent.ACTION_DOWN) {
            onTapListener.onTap();
        }
        return true;
    }
    public void update(float factor) {
        circularImage.update(factor);
        postInvalidate();
    }
    private class CircularImage  {
        private float deg = 0;
        public void draw(Canvas canvas) {
            canvas.save();
            Path path = new Path();
            path.addArc(new RectF(0,0,w,h),0,360);
            canvas.clipPath(path);
            canvas.drawBitmap(bitmap,0,0,DrawUtils.paint);
            canvas.restore();
            DrawUtils.paint.setColor(Color.BLACK);
            canvas.drawArc(new RectF(0,0,w,h),0,deg,true,DrawUtils.paint);
        }
        public void update(float factor) {
            deg = 360*(1-factor);
        }
    }
}
