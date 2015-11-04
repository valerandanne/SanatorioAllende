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
public class MedicosXEspecialidadActivity extends Activity {
    private int idEspecialidad;
    ArrayList<BeanMedico>lista= new ArrayList<BeanMedico>();
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
            lista = db.getMedicosFromEspe(idEspecialidad);
        }

        if (lista != null)
        {
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
}
