package com.example.agustina.sallende;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Beans.BeanEspecialidad;
import Beans.BeanMedico;

/**
 * Created by Usuario on 14/10/2015.
 */
public class MedicosPorEspecialidad extends Activity {

   /* ListView listViewItems;
    ArrayList<BeanMedico> lista =new ArrayList<BeanMedico>();
    BeanMedico medico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicosporespe);

        listViewItems = (ListView) findViewById(R.id.listMedicos);
        SQLiteDB db = new SQLiteDB(this);
        db.getReadableDatabase();
        Cursor c = db.getMedicosFromEspe();



        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            lista.add(especialidad = new BeanEspecialidad(id_espe, c.getString(1)));
        }

        c.close();

        ArrayAdapter<BeanEspecialidad> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listViewItems.setAdapter(adapter);
        }
*/
    }
