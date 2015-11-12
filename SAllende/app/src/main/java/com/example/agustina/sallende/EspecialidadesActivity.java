package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import Beans.BeanEspecialidad;

public class EspecialidadesActivity extends Activity {

    ListView listViewItems;
    ArrayList<BeanEspecialidad> listaEspecialidades =new ArrayList<BeanEspecialidad>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);

        listViewItems = (ListView) findViewById(R.id.list);
        new BuscarDatosAsincrono(getApplicationContext()).execute();

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String espe_id = listaEspecialidades.get(position).getId_espe();
                Intent medicosXEspecialidad = new Intent(getApplicationContext(), MedicosXEspecialidadActivity.class);
                medicosXEspecialidad.putExtra("IdEspecialidad", Integer.parseInt(espe_id));
                startActivity(medicosXEspecialidad);
            }
        });
    }

    private class BuscarDatosAsincrono extends AsyncTask<Void,Void, ArrayList<BeanEspecialidad>>
    {
        Context context;
        public BuscarDatosAsincrono(Context context) {
            this.context = context;
        }

        @Override
        protected ArrayList<BeanEspecialidad> doInBackground(Void... params) {
            SQLiteDB db=new SQLiteDB(getApplicationContext());
            listaEspecialidades = db.getAllEspecialidades();
            return listaEspecialidades;
        }
        @Override
        protected void onPostExecute(ArrayList<BeanEspecialidad> listaEspecialidades) {
            super.onPostExecute(listaEspecialidades);
            ArrayAdapter<BeanEspecialidad> adapter =
                    new ArrayAdapter<BeanEspecialidad>(context,R.layout.list_item,listaEspecialidades);
            listViewItems.setAdapter(adapter);
        }
    }
}
