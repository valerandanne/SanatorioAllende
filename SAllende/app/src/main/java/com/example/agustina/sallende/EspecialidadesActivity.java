package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import Beans.BeanEspecialidad;

public class EspecialidadesActivity extends Activity {

    ListView listViewItems;
    ArrayList<BeanEspecialidad> lista =new ArrayList<BeanEspecialidad>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);

        listViewItems = (ListView) findViewById(R.id.list);
        SQLiteDB db=new SQLiteDB(getApplicationContext());
        lista = db.getAllEspecialidades();

        ArrayAdapter<BeanEspecialidad> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String espe_id = lista.get(position).getId_espe();
                Intent medicosXEspecialidad = new Intent(getApplicationContext(), MedicosXEspecialidadActivity.class);
                medicosXEspecialidad.putExtra("IdEspecialidad", Integer.parseInt(espe_id));
                startActivity(medicosXEspecialidad);
            }
        });
    }


}
