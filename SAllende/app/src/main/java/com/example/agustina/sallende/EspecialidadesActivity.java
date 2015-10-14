package com.example.agustina.sallende;

import android.app.Activity;
import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

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
            lista.add(especialidad = new BeanEspecialidad(c.getString(1)));
        }

        c.close();

        ArrayAdapter<BeanEspecialidad> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listViewItems.setAdapter(adapter);



       }

        /*SQLiteDB db = new SQLiteDB(this);
        Cursor cursor= db.getAllEspecialidades();
        String[] from = new String[]{"name"};
        int[] to = new int[]{R.id.text};

       /*SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.Row , cursor, from, to);

        listViewitems.setAdapter(cursorAdapter);


        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.activity_especialidades, ObjectItemData);

        ListView listViewItems = new ListView(this);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());
        */




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
