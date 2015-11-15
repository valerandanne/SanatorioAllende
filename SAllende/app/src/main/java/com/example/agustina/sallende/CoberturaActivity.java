package com.example.agustina.sallende;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import Beans.BeanCobertura;


public class CoberturaActivity extends Activity {

    ListView listViewItems;
    ArrayList<BeanCobertura> listaCoberturas = new ArrayList<BeanCobertura>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobertura);
        listViewItems = (ListView) findViewById(R.id.lista);

        new BuscarDatosAsincrono(getApplicationContext()).execute();
    }


    private class BuscarDatosAsincrono extends AsyncTask<Void,Void, ArrayList<BeanCobertura>>{

        Context context;

        public BuscarDatosAsincrono(Context context){
            this.context = context;
        }

        @Override
        protected ArrayList<BeanCobertura> doInBackground(Void... params) {
            SQLiteDB db = new SQLiteDB(getApplicationContext());
            listaCoberturas = db.getAllCoberturas();
            return listaCoberturas;
        }
        @Override
        protected void onPostExecute(ArrayList<BeanCobertura> listaCoberturas) {
            super.onPostExecute(listaCoberturas);
            ArrayAdapter<BeanCobertura> adapter = new ArrayAdapter<BeanCobertura>(context, R.layout.list_item, listaCoberturas);
            listViewItems.setAdapter(adapter);
        }
    }
}
