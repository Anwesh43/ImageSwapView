package com.anwesome.ui.imageswapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by anweshmishra on 12/05/17.
 */
public class MainImageView extends View {
    private float scale = 1;
    private int render = 0,w,h;
    private Bitmap bitmap;
    public MainImageView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        Bitmap.createScaledBitmap(bitmap,w,h,true);
    }
    public void onDraw(Canvas canvas) {
        if(render == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        canvas.drawColor(Color.BLACK);
        canvas.save();
        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);
        canvas.scale(scale,scale);
        canvas.drawBitmap(bitmap,-bitmap.getWidth()/2,-bitmap.getHeight()/2,DrawUtils.paint);
        canvas.restore();
        render++;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void update(float factor) {
        scale *= factor;
    }
}
