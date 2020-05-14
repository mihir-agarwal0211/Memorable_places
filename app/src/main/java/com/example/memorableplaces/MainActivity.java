package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final ArrayList<String> addrrsses = new ArrayList<String>();
    static final ArrayList<LatLng> latLngs = new ArrayList<LatLng>();
    static ArrayAdapter<String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);


        addrrsses.add("Add a new place...");
        latLngs.add(new LatLng(0,0));

        ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,addrrsses);

        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("address",position);
                startActivity(intent);
            }
        });

    }
}
