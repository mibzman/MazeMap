package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sam on 3/2/2015.
 */
public class arrowscreen extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrowscreen);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendIntent();
            }
        });

    }
    public void sendIntent(){
        Intent intent = new Intent(this, Mapscreen.class);
        startActivity(intent);
    }
}