package com.example.agustina.sallende;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import Beans.BeanMedico;

/**
 * Created by Usuario on 03/11/2015.
 */
public class MedicosXEspecialidadActivity extends Activity{
    private int idEspecialidad;
    ArrayList<BeanMedico>listaMedicos= new ArrayList<BeanMedico>();
    ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicosporespe);
        listViewItems = (ListView) findViewById(R.id.listMedicos);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            idEspecialidad = bundle.getInt("IdEspecialidad", 0);
        }

        SQLiteDB db = new SQLiteDB(getApplicationContext());
        if(idEspecialidad != 0) {
            listaMedicos = db.getMedicosFromEspe(idEspecialidad);
        }

        if (listaMedicos != null)
        {
           cargarAdapter(listaMedicos);
        }
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
                    String name1= s1.getApellido();
                    String name2= s2.getApellido();
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

    private void cargarAdapter(final ArrayList<BeanMedico> lista){
        ArrayAdapter<BeanMedico> adapter = new ArrayAdapter<BeanMedico>(this,android.R.layout.simple_list_item_2,android.R.id.text1,lista){
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                BeanMedico med = lista.get(position);

                text1.setText(med.getNombre());
                text2.setText(med.getSucursal());
                return view;
            }
        };
        listViewItems.setAdapter(adapter);
    }
}
