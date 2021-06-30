package com.samil.androidmapapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class LocationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        ArrayList<Data> datas = new ArrayList<Data>();

        try {
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            Cursor cursor = vt.rawQuery("SELECT * FROM TiyatroDB where _id between 1 and 50",null);
            int name = cursor.getColumnIndex("PLAY_NAME");
            int information = cursor.getColumnIndex("THEATER_NAME");
            int description = cursor.getColumnIndex("PLAY_CATEGORY");

            while(cursor.moveToNext()){
                Data t = new Data(cursor.getString(name),cursor.getString(information), cursor.getString(description));
                datas.add(t);
            }
            cursor.close();

        }catch (Exception e){
            Log.d("hata",null);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        adaptor adp = new adaptor(datas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adp);
    }

    public void GetAllTheater(View view){

        ArrayList<Data> theaters = new ArrayList<Data>();

        try {
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            Cursor cursor = vt.rawQuery("SELECT * FROM TiyatroDB where _id between 1 and 50",null);
            int name = cursor.getColumnIndex("PLAY_NAME");
            int information = cursor.getColumnIndex("THEATER_NAME");
            int description = cursor.getColumnIndex("PLAY_CATEGORY");

            while(cursor.moveToNext()){
                Data t = new Data(cursor.getString(name),cursor.getString(information), cursor.getString(description));
                theaters.add(t);
            }
            cursor.close();

        }catch (Exception e){
            Log.d("hata",null);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        adaptor adp = new adaptor(theaters);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adp);
    }



    public void GetAllPark(View view){

        ArrayList<Data> parks = new ArrayList<Data>();

        try {
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            Cursor cursor = vt.rawQuery("SELECT * FROM ParkDB where _id between 1 and 50",null);
            int name = cursor.getColumnIndex("NAME");
            int information = cursor.getColumnIndex("NEIGHBORHOOD_NAME");
            int description = cursor.getColumnIndex("COUNTY_NAME");

            while(cursor.moveToNext()){
                Data t = new Data(cursor.getString(name),cursor.getString(information), cursor.getString(description));
                parks.add(t);
            }
            cursor.close();

        }catch (Exception e){
            Log.d("hata",null);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        adaptor adp = new adaptor(parks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adp);
    }


    public void GetAllFuel(View view){

        ArrayList<Data> fuels = new ArrayList<Data>();

        try {
            SQLiteDatabase vt = openOrCreateDatabase("ParkDB.db",MODE_PRIVATE,null);

            Cursor cursor = vt.rawQuery("SELECT * FROM AkaryakitDB where _id between 1 and 50",null);
            int name = cursor.getColumnIndex("FUEL_DISTRIBUTION_COMPANY_DESC");
            int information = cursor.getColumnIndex("NEIGHBORHOOD_NAME");
            int description = cursor.getColumnIndex("COUNTY_NAME");

            while(cursor.moveToNext()){
                Data t = new Data(cursor.getString(name),cursor.getString(information), cursor.getString(description));
                fuels.add(t);
            }
            cursor.close();

        }catch (Exception e){
            Log.d("hata",null);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recview);
        adaptor adp = new adaptor(fuels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adp);
    }



}