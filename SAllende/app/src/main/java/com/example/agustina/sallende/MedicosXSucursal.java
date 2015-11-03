package com.example.agustina.sallende;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import Beans.BeanEspecialidad;
import Beans.BeanSucursal;

/**
 * Created by Usuario on 03/11/2015.
 */
public class MedicosXSucursal extends Activity {
    ArrayList<BeanSucursal> sucursales = new ArrayList<BeanSucursal>();
    Spinner suc_spinner;
    Spinner espe_spinner;
    ArrayList<BeanEspecialidad> especialidades = new ArrayList<BeanEspecialidad>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarxsucursal);

        suc_spinner = (Spinner) findViewById(R.id.sucursales_spinner);
        espe_spinner = (Spinner) findViewById(R.id.especialidades_spinner);

        SQLiteDB db = new SQLiteDB(getApplicationContext());
        sucursales = db.getAllSucursales();
        especialidades = db.getAllEspecialidades();

        ArrayAdapter<BeanSucursal> suc_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sucursales);
        suc_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        suc_spinner.setAdapter(suc_adapter);

        ArrayAdapter<BeanEspecialidad> espe_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, especialidades);
        espe_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espe_spinner.setAdapter(espe_adapter);
    }
}
