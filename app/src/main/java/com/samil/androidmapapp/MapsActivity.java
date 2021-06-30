package com.samil.androidmapapp;

import androidx.fragment.app.FragmentActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    LatLng marker;
    LatLng marker2;
    LatLng marker3;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LocationList.class);
                startActivity(intent);


            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Double enlem;
        Double boylam;
        String name;

        try{
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            //Tiyaro Konumları
            Cursor cursor = vt.rawQuery("SELECT * FROM TiyatroDB where _id between 1 and 20",null);
            int id = cursor.getColumnIndex("_id");
            int longitude = cursor.getColumnIndex("LONGITUDE"); //boylam
            int latitude = cursor.getColumnIndex("LATITUDE");
            int playName = cursor.getColumnIndex("PLAY_NAME");

            while(cursor.moveToNext()) {
                    if (mMap != null) {

                    enlem = Double.parseDouble(cursor.getString(latitude));
                    boylam = Double.parseDouble(cursor.getString(longitude));
                    name = cursor.getString(playName);

                    marker = new LatLng(enlem, boylam);

                    mMap.addMarker(new MarkerOptions().position(marker)
                            .title(name)
                            .snippet("Tiyatro")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

                }
            }

        }catch (Exception e){
            Log.d("hata",null);
        }



        //Akaryakit
        try {
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            //Akaryakıt Konumları
            Cursor cursor2 = vt.rawQuery("SELECT * FROM AkaryakitDB where _id between 1 and 20",null);
            int id2 = cursor2.getColumnIndex("_id");
            int longitude2 = cursor2.getColumnIndex("LONGTITUDE"); //boylam
            int latitude2 = cursor2.getColumnIndex("LATITUDE");
            int FuelName = cursor2.getColumnIndex("FUEL_DISTRIBUTION_COMPANY_DESC");


            while(cursor2.moveToNext()) {
                if (mMap != null) {

                    enlem = Double.parseDouble(cursor2.getString(latitude2));
                    boylam = Double.parseDouble(cursor2.getString(longitude2));
                    name = cursor2.getString(FuelName);

                    marker2 = new LatLng(enlem, boylam);

                    mMap.addMarker(new MarkerOptions().position(marker2)
                            .title(name)
                            .snippet("Akaryakıt")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

                }
            }

        }catch (Exception e){
            Log.d("hata",null);
        }

        //Park
        try{
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            //park
            Cursor cursor3 = vt.rawQuery("SELECT * FROM ParkDB where _id between 1 and 20",null);
            int id3 = cursor3.getColumnIndex("_id");
            int longitude = cursor3.getColumnIndex("LONGITUDE"); //boylam
            int latitude = cursor3.getColumnIndex("LATITUDE");
            int parkName = cursor3.getColumnIndex("NAME");

            while(cursor3.moveToNext()) {
                if (mMap != null) {

                    enlem = Double.parseDouble(cursor3.getString(latitude));
                    boylam = Double.parseDouble(cursor3.getString(longitude));
                    name = cursor3.getString(parkName);

                    marker3 = new LatLng(enlem, boylam);

                    mMap.addMarker(new MarkerOptions().position(marker3)
                            .title(name)
                            .snippet("Park")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                }
            }

        }catch (Exception e){
            Log.d("hata",null);
        }



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,11));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker2,11));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker3,11));

    }
}