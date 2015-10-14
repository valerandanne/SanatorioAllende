package com.example.agustina.sallende;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Beans.BeanCobertura;
import Beans.BeanEspecialidad;

public class CoberturaActivity extends AppCompatActivity {

    ListView listViewItems;
    ArrayList<BeanCobertura> lista =new ArrayList<BeanCobertura>();
    BeanCobertura cobertura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobertura);

        listViewItems = (ListView) findViewById(R.id.lista);
        SQLiteDB db = new SQLiteDB(this);
        db.getReadableDatabase();
        Cursor c = db.getAllCoberturas();



        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            lista.add(cobertura = new BeanCobertura(c.getString(1)));
        }

        c.close();

        ArrayAdapter<BeanCobertura> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listViewItems.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cobertura, menu);
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
