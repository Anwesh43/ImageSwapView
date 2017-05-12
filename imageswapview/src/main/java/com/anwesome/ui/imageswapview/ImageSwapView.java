package com.anwesome.ui.imageswapview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by anweshmishra on 12/05/17.
 */
public class ImageSwapView  {
    private RelativeLayout relativeLayout;
    private Activity activity;
    private CircularImageView circularImageView;
    private MainImageView mainImageView;
    private AnimationHandler animationHandler;
    private int w,h;
    private boolean isShown = false;
    public ImageSwapView(Activity activity) {
        this.activity = activity;
        relativeLayout = new RelativeLayout(activity);
        initDimensions();
    }
    public void initDimensions() {
        DisplayManager displayManager = (DisplayManager) activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void addMainImage(Bitmap bitmap) {
        if(!isShown && mainImageView == null) {
            mainImageView = new MainImageView(activity,bitmap);
        }
    }
    public void addSideCircularImage(Bitmap bitmap) {
        if(!isShown && circularImageView == null) {
            circularImageView = new CircularImageView(activity,bitmap);
        }
    }
    public void show() {
        if(!isShown && circularImageView != null && mainImageView != null) {
            animationHandler = new AnimationHandler(circularImageView,mainImageView);
            circularImageView.setOnTapListener(new OnTapListener() {
                @Override
                public void onTap() {
                    animationHandler.end();
                }
            });
            relativeLayout.addView(mainImageView,new ViewGroup.LayoutParams(w,h));
            relativeLayout.addView(circularImageView,new ViewGroup.LayoutParams(w/4,w/4));
            activity.setContentView(relativeLayout);
        }
    }
}
