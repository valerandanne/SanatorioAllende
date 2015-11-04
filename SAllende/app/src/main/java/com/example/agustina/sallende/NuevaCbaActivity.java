package com.example.agustina.sallende;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * Created by Agustina on 15/10/2015.
 */
public class NuevaCbaActivity extends FragmentActivity implements OnMapReadyCallback

{
    private final LatLng LatLongNueva = new LatLng(-31.4245983,-64.1872955);
    GoogleMap mapa;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevacba);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

       /* mapa = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLongNueva, 15));
        mapa.setMyLocationEnabled(true);
        mapa.getUiSettings().setZoomControlsEnabled(false);
        mapa.getUiSettings().setCompassEnabled(true);
        mapa.addMarker(new MarkerOptions()
                .position(LatLongNueva)
                .title("SANATORIO ALLENDE")
                .snippet("Sucursal Nueva Córdoba")
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));

*/


    public void moveCamera(View view) {
        mapa.moveCamera(CameraUpdateFactory.newLatLng(LatLongNueva));
    }

    public void animateCamera(View view) {
        if (mapa.getMyLocation() != null)
            mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng( mapa.getMyLocation().getLatitude(),
                            mapa.getMyLocation().getLongitude()), 15));
    }

    public void addMarker(View view) {
        mapa.addMarker(new MarkerOptions().position(
                new LatLng(mapa.getCameraPosition().target.latitude,
                        mapa.getCameraPosition().target.longitude)));
    }



}


