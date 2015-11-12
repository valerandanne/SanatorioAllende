package com.example.agustina.sallende;

import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends FragmentActivity {



        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);


        }
           /*setUpMapIfNeeded();
            mMap=((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            Marker Cba = mMap.addMarker(new MarkerOptions().position(CBA).title("Córdoba").snippet("Por favor funciona"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CBA, 15));*/



    public void clickNueva (View v){

        Button btnNueva = (Button)findViewById(R.id.button_nueva);
        //Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?geo:34.067214,-118.349332?q=410+Hauser+Boulevard,+Los+Angeles,+CA"));
        //geo:-31.4245983,-64.1872955?q=-31.4245983,-64.1872955(SUCURSAL NUEVA CORDOBA

        startActivity(new Intent(this,NuevaCbaActivity.class));



    }

    public void clickCerro (View v){
        Button btnCerro = (Button)findViewById(R.id.button_cerro);

    }






    /*protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    /*private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */

}
