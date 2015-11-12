package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
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
    ArrayList<BeanMedico> listaMedicos = new ArrayList<BeanMedico>();
    ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicosxespexsuc);
        listViewItems = (ListView) findViewById(R.id.listMedicos);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idEspecialidad = bundle.getInt("IdEspecialidad", 0);
            idSucursal = bundle.getInt("IdSucursal");
        }
        new BuscarDatosAsincrono(getApplicationContext()).execute();
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
