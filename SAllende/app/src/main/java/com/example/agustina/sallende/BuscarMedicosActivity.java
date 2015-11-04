package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Usuario on 03/11/2015.
 */
public class BuscarMedicosActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_medicos);
    }

    public void clickEspecialidad(View v) {
        startActivity(new Intent(this, EspecialidadesActivity.class));
    }
    public void clickSucursal(View v) {
        startActivity(new Intent(this, MedicosXSucursal.class));
    }
}

