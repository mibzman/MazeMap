package com.isotope.mazemap;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class MyActivity extends Activity {
    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bestmain);
    //nav drawer start
    navdrawergarbage();
    Fragment Map = new Mapscreen();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();
//nav drawer end

        }
    void navdrawergarbage() {
        menu = new String[]{"Navigate","Tips", "Settings"};
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        dList.setAdapter(adapter);
        dList.setSelector(android.R.color.holo_blue_dark);
        Fragment Map = new Mapscreen();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();
        dList.setItemChecked(0, true);
        dList.setSelection(0);
        dList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                dLayout.closeDrawers();
                if(position == 0) {
                    Fragment Map = new Mapscreen();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();

                }else if (position== 1){
                    Fragment Tips = new Tips();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Tips).commit();
                }else if (position== 2){
                    Fragment Settings = new Settings();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Settings).commit();
                }else{
                    Fragment Map = new Mapscreen();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, Map).commit();
                    dList.setItemChecked(0, true);
                    dList.setSelection(0);
                }
            }

        });
    }

}