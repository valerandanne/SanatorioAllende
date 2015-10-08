package com.example.agustina.sallende;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class EspecialidadesActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);

        SQLiteDB db = new SQLiteDB(this);
        Cursor cursor= db.getAllEspecialidades();
        String[] from = new String[]{"name"};
        int[] to = new int[]{R.id.text};

       /* SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.Row , cursor, from, to);

        listViewitems.setAdapter(cursorAdapter);


        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.activity_especialidades, ObjectItemData);

        ListView listViewItems = new ListView(this);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());
        */
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
