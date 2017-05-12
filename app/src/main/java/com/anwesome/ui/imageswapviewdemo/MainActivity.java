package com.anwesome.ui.imageswapviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.imageswapview.ImageSwapView;

public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap1,bitmap2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        if(bitmap1 == null && bitmap2 == null) {
            bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.back1);
            bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.back3);
        }
        ImageSwapView imageSwapView = new ImageSwapView(this);
        imageSwapView.addMainImage(bitmap2);
        imageSwapView.addSideCircularImage(bitmap1);
        imageSwapView.show();
    }
}
