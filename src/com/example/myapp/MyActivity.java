package com.example.myapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MyActivity extends Activity implements SensorEventListener {
    private float mLastX, mLastY, mLastZ, sAX, sAY, sAZ;
    private boolean mInitialized;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private final float NOISE = (float) 2.0;
    double mXX, mXY;
    int elaspedTime = 0;
    float calAX, calAY, calAZ;
    boolean goStop = false;
    boolean cal = false;
    SharedPreferences DATAAA_data;
    public static String filename1 = "first";
    boolean val = true;
    double onex, twox, threex, fourx, fivex, sixx, sevenx, eightx, ninex, tenx =2;
    double oney, twoy, threey, foury, fivey, sixy, seveny, eighty, niney, teny = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// can be safely ignored for this demo
    }
    public void onSensorChanged(SensorEvent event) {
       /* TextView AX= (TextView)findViewById(R.id.x_accl);
        TextView AY= (TextView)findViewById(R.id.y_accl);
        TextView AZ= (TextView)findViewById(R.id.z_accl);
        TextView VX= (TextView)findViewById(R.id.x_vol);
        TextView VY= (TextView)findViewById(R.id.y_vol);
        TextView XX= (TextView) findViewById(R.id.x_loc);
        TextView XY= (TextView) findViewById(R.id.y_loc);
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        if (!mInitialized) {
            mLastX = x;
            mLastY = y;
            mLastZ = z;
            AX.setText("0.0");
            AY.setText("0.0");
            AZ.setText("0.0");

            mInitialized = true;
        } else {
            if (cal) {
                calAX = mLastX;
                calAY = mLastY;
                calAZ = mLastZ;
                cal = false;
            } else{
                double mVX = (((mLastX - calAX) * elaspedTime)/1000);
                double mVY = ((((mLastY - calAY) * elaspedTime)/1000));
                mXX = ((((mLastX - calAX) / 2) * elaspedTime * elaspedTime));
                mXY = ((((mLastY - calAY) / 2) * elaspedTime * elaspedTime));

                mLastX = x;
                mLastY = y;
                mLastZ = z;
                DecimalFormat df = new DecimalFormat("###.##");
                AX.setText("A= " + Double.toString(round(mLastX - calAX)) + " m/s/s");
                AY.setText("A= " + Double.toString(round(mLastY - calAY)) + " m/s/s");
                AZ.setText("A= " + Double.toString(round(mLastZ - calAZ)) + " m/s/s");
                VX.setText("V= " + Double.toString(alsoround(mVX)) + " m/s");
                VY.setText("V= " + Double.toString(alsoround(mVY)) + " m/s");
                XX.setText("X= " + Double.toString(alsoround(mXX)) + " m");
                XY.setText("X = " + Double.toString(alsoround(mXY)) + " m");
            }
        }*/
    }
}
