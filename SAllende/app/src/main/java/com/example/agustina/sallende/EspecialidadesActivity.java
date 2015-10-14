package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Beans.BeanEspecialidad;

public class EspecialidadesActivity extends Activity {

    ListView listViewItems;
    ArrayList<BeanEspecialidad> lista =new ArrayList<BeanEspecialidad>();
    BeanEspecialidad especialidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);

        listViewItems = (ListView) findViewById(R.id.list);
        SQLiteDB db = new SQLiteDB(this);
        db.getReadableDatabase();
        Cursor c = db.getAllEspecialidades();


        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            lista.add(especialidad = new BeanEspecialidad(c.getString(0),c.getString(1)));
        }

        c.close();

        ArrayAdapter<BeanEspecialidad> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_especialidades, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
