package com.example.agustina.sallende;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * Created by Agustina on 15/10/2015.
 */
public class NuevaCbaActivity extends FragmentActivity implements OnMapReadyCallback

{
    GoogleMap googleMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevacba);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMap();
    }


    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng latLng = new LatLng(-31.4245983, -64.1872955);
        map.addMarker(new MarkerOptions().position(latLng).title("Sucursal Nueva Córdoa"));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }


}


