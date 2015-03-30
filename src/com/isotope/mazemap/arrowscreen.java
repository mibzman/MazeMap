package com.isotope.mazemap;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Sam on 3/2/2015.
 */
public class arrowscreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.arrowscreen, container, false);
        Button button = (Button) getView().findViewById(R.id.button);
        return view;

    }/*
    public void sendIntent(){
        Intent intent = new Intent(this, Mapscreen.class);
        startActivity(intent);
    }*/
}