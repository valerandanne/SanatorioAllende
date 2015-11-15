package com.example.agustina.sallende;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Beans.BeanMedico;

/**
 * Created by Usuario on 03/11/2015.
 */
public class MedicosXespeXsuc extends ActionBarActivity {
    private int idEspecialidad;
    private int idSucursal;
    ArrayList<BeanMedico> listaMedicos = new ArrayList<BeanMedico>();
    ListView listViewItems;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicosxespexsuc);
        listViewItems = (ListView) findViewById(R.id.listMedicos);
         actionBar = getActionBar();
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(" ");


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idEspecialidad = bundle.getInt("IdEspecialidad", 0);
            idSucursal = bundle.getInt("IdSucursal");
        }
        new BuscarDatosAsincrono(getApplicationContext()).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nombre:OrdenarListaPorNombre(listaMedicos);
                return true;
            case R.id.apellido: OrdenarListaPorApellido(listaMedicos);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void OrdenarListaPorApellido(ArrayList<BeanMedico> lista){

        if (lista != null)
        {
            ArrayList<BeanMedico> listaOrdenada= lista;

            Collections.sort(listaOrdenada, new Comparator<BeanMedico>() {
                @Override
                public int compare(BeanMedico s1, BeanMedico s2) {
                    String name1 = s1.getApellido();
                    String name2 = s2.getApellido();
                    return name1.compareToIgnoreCase(name2);
                }
            });

            cargarAdapter(listaOrdenada);
        }
    }

    private void OrdenarListaPorNombre(ArrayList<BeanMedico> lista){
        if (lista != null)
        {
            Collections.sort(lista, new Comparator<BeanMedico>() {
                @Override
                public int compare(BeanMedico s1, BeanMedico s2) {
                    String name1= s1.getMedNombre();
                    String name2= s2.getMedNombre();
                    return name1.compareToIgnoreCase(name2);
                }
            });

            cargarAdapter(lista);
        }
    }

    private void cargarAdapter(ArrayList<BeanMedico> lista) {
        if (lista != null) {
            ArrayAdapter<BeanMedico> adapter = new ArrayAdapter<BeanMedico>(getApplicationContext(), R.layout.list_item, lista);
            listViewItems.setAdapter(adapter);
        }
    }


    private class BuscarDatosAsincrono extends AsyncTask<Void, Void, ArrayList<BeanMedico>> {
        Context context;

        public BuscarDatosAsincrono(Context context) {
            this.context = context;
        }

        protected ArrayList<BeanMedico> doInBackground(Void... params) {
            SQLiteDB db = new SQLiteDB(context);
            if (idEspecialidad != 0 && idSucursal != 0) {
                listaMedicos = db.getMedicosXEspeXSuc(idSucursal, idEspecialidad);
            }
            return listaMedicos;
        }

        @Override
        protected void onPostExecute(ArrayList<BeanMedico> beanMedicos) {
            super.onPostExecute(beanMedicos);
            if (listaMedicos != null) {
                ArrayAdapter<BeanMedico> adapter = new ArrayAdapter<BeanMedico>(context, R.layout.list_item, listaMedicos);
                listViewItems.setAdapter(adapter);
            }
        }
    }
}
