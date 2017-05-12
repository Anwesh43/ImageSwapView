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
    private CircularImage circularImage = new CircularImage();
    public CircularImageView(Context context, Bitmap bitmap) {
        super(context);
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void onDraw(Canvas canvas) {
        if(render == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        canvas.drawColor(Color.argb(0,0,0,0));
        render++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
    public void update(float factor) {
        circularImage.update(factor);
    }
    private class CircularImage  {
        private float deg = 360;
        public void draw(Canvas canvas) {
            canvas.drawCircle(w/2,h/2,Math.min(w,h)/2,DrawUtils.paint);
            canvas.save();
            Path path = new Path();
            path.addArc(new RectF(0,0,w,h),0,deg);
            canvas.clipPath(path);
            canvas.drawBitmap(bitmap,0,0,DrawUtils.paint);
            canvas.restore();
        }
        public void update(float factor) {
            deg = 360*factor;
        }
    }
}
