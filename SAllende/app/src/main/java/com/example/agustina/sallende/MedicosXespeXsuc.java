package com.example.agustina.sallende;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Beans.BeanMedico;

/**
 * Created by Usuario on 03/11/2015.
 */
public class MedicosXespeXsuc extends Activity {
    private int idEspecialidad;
    private int idSucursal;
    ArrayList<BeanMedico> lista= new ArrayList<BeanMedico>();
    ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicosxespexsuc);
        listViewItems = (ListView) findViewById(R.id.listMedicos);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            idEspecialidad = bundle.getInt("IdEspecialidad", 0);
            idSucursal=bundle.getInt("IdSucursal");
        }

        SQLiteDB db = new SQLiteDB(getApplicationContext());
        if(idEspecialidad != 0 && idSucursal!=0) {
            lista = db.getMedicosXEspeXSuc(idSucursal,idEspecialidad);
        }

        if (lista != null)
        {
            ArrayAdapter<BeanMedico> adapter = new ArrayAdapter<BeanMedico>(this,android.R.layout.simple_list_item_1,lista);
            listViewItems.setAdapter(adapter);
        }
    }
}
