package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Agustina on 10/11/2015.
 */
public class SucursalesActivity extends Activity

{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    }

    public void clickNueva(View v){
        startActivity(new Intent(this, NuevaCbaActivity.class));
    }
    public void clickCerro(View v){
        startActivity(new Intent(this, CerroActivity.class));
    }
}
