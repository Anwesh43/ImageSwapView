package com.anwesome.ui.imageswapview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;

/**
 * Created by anweshmishra on 12/05/17.
 */
public class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    private CircularImageView circularImageView;
    private MainImageView mainImageView;
    private int dir = 0;
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    {{
        startAnim.setDuration(500);
        endAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        endAnim.addUpdateListener(this);
        startAnim.addListener(this);
        endAnim.addListener(this);
    }}
    public AnimationHandler(CircularImageView circularImageView,MainImageView mainImageView) {
        this.circularImageView = circularImageView;
        this.mainImageView = mainImageView;
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)valueAnimator.getAnimatedValue();
        mainImageView.update(factor);
        circularImageView.update(factor);
    }
    private void swapImages() {
        Bitmap mainBitmap = mainImageView.getBitmap();
        Bitmap circleBitmap = circularImageView.getBitmap();
        circularImageView.setBitmap(mainBitmap);
        mainImageView.setBitmap(circleBitmap);
    }
    public void onAnimationEnd(Animator animator) {
        if(dir == -1) {
            swapImages();
        }

    }
    public void start() {
        dir = 1;
        startAnim.start();
    }
    public void end() {
        dir = -1;
        endAnim.start();
    }

}
