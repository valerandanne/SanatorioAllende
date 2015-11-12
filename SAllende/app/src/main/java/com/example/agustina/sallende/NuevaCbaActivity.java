package com.example.agustina.sallende;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NuevaCbaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mapa; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cba);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap mapa) {
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng nuevacba = new LatLng(-31.424509, -64.187325);
        mapa.setMyLocationEnabled(true);
        mapa.addMarker(new MarkerOptions()
                .position(nuevacba)
                .title("SANATORIO ALLENDE")
                .snippet("Obispo oro 37, Nueva Córdoba")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(nuevacba,16));
    }
}

