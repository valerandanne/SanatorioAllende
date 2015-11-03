package com.example.agustina.sallende;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Main extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickCobertura(View v){
        startActivity(new Intent(this, CoberturaActivity.class));
    }
    public void clickUbicación(View v){
        startActivity(new Intent(this, MapsActivity.class));
    }
    public void clickEspecialidades(View v){
        startActivity(new Intent(this,BuscarMedicosActivity.class));
    }
    public void clickTurnos(View v){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:08105552553"));
        startActivity(callIntent);
    }
}