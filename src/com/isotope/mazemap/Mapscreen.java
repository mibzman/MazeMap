package com.isotope.mazemap;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sam on 3/2/2015.
 */
public class Mapscreen extends Fragment {
    float oldX = 0;
    float oldY = 0;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        final View view = inflater.inflate(R.layout.mapscreen, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstAnimation(view);

            }
        });
        return view;
    }
    void firstAnimation(final View view){
        View animatedView = view.findViewById(R.id.theDot);
        final float x = -50;
        final float y =0;
        TranslateAnimation animation = new TranslateAnimation(
                oldX, (x + oldX), oldY, (y +oldY)
        );
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animatedView.startAnimation(animation);
        oldX = (x+oldX);
        oldY = (x+oldY);
        //secondAnimation(view);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                secondAnimation(view);
            }
        }, 1000);
    }
    void secondAnimation(View view){
        View animatedView = view.findViewById(R.id.theDot);
        final float x = 0;
        final float y =-100;
        TranslateAnimation animation = new TranslateAnimation(
                oldX, (x + oldX), oldY, (y +oldY)
        );
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animatedView.startAnimation(animation);
        oldX = (x+oldX);
        oldY = (x+oldY);
    }
}
