package com.isotope.mazemap;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sam on 3/2/2015.
 */
public class Mapscreen extends Fragment{
    //location at paul's seat: Lat:41.4846039, Long:-81.7835846
   // LocationManager locationManager;
    //LocationListener locationListener;

    float oldX = 0;
    float oldY = 0;
    int currentLat;
    int currentLong;
    int oldLat;
    int oldLong;
    Context context;
    double Lat1 = 41.4906377;
    double oldLon = -81.056922;
    LocationManager locationManager;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        final View view = inflater.inflate(R.layout.mapscreen, container, false);
        Button button = (Button) view.findViewById(R.id.Start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstAnimation(view);

            }
        });

        return view;

/*
        //location start

        //String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        //locationManager = (LocationManager) getActivity.getSystemService(context);

        Criteria crta = new Criteria();
        crta.setAccuracy(Criteria.ACCURACY_FINE);
        crta.setAltitudeRequired(false);
        crta.setBearingRequired(false);
        crta.setCostAllowed(true);
        crta.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(crta, true);

        // String provider = LocationManager.GPS_PROVIDER;
        final Location location = locationManager.getLastKnownLocation(provider);
        updateWithNewLocation(location);

        locationManager.requestLocationUpdates(provider, 1000, 0,
                locationListener);
        Button mbutton = (Button) view.findViewById(R.id.Start);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lat1 = location.getLatitude();
                oldLon = location.getLongitude();
            }
        });
//location end
*/
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
    private final LocationListener locationListener = new LocationListener()
    {

        @Override
        public void onLocationChanged(Location location)
        {
            updateWithNewLocation(location);
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            updateWithNewLocation(null);
        }

        @Override
        public void onProviderEnabled(String provider)
        {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
        }

    };

    private void updateWithNewLocation(Location location)
    {
        String latLong;
        TextView myLocation;
       // myLocation = (TextView) findViewById(R.id.textView);
        if (location != null)
        {
            //this is all from http://www.movable-type.co.uk/scripts/latlong.html
            double lat2 = location.getLatitude();
            double lon = location.getLongitude();
            latLong = "Lat:" + lat2 + "\nLong:" + lon;
            double R = 6371000;
            double sigma1 = Math.toRadians(Lat1);
            double sigma2 = Math.toRadians(lat2);
            //double deltaSigma = Math.toRadians()

            double radOldlat = Math.toRadians(Lat1);
            double radOldlon = Math.toRadians(oldLon);

            double radLat = Math.toRadians(location.getLatitude());
            double radLon = Math.toRadians(location.getLongitude());


            double deltaSigma = Math.toRadians((radOldlat - radLat));
            double deltaLambda = Math.toRadians((radOldlon - radLon));

            double a = (Math.sin(deltaSigma/2)*Math.sin(deltaSigma)) +
                    Math.cos(sigma1)*Math.cos(sigma2)*
                            (Math.sin(deltaLambda/2)*Math.sin(deltaLambda/2));

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

            double d = R * c;
            final String DeeString = Double.toString(d);
            //setTheText(DeeString);
            //oldLat = lat;
            //oldLon = lon;
        } else{
            latLong = " NO Location Found ";
        }
        //  TextView theTextView = (TextView) findViewById(R.id.butt);
        //theTextView.setText(DeeString);
       // myLocation.setText("your Current Position is :\n" + latLong);
    }
}
