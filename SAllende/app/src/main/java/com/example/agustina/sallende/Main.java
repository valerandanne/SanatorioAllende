package com.example.agustina.sallende;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Main extends AppCompatActivity{


    AlertDialog alertDialogEspe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button_esp:
                        ShowEspe();
                        break;

                }
            }


        };
        findViewById(R.id.button_esp).setOnClickListener(handler);
    }
    public void ShowEspe() {
        ObjectItem[] ObjectItemData = new ObjectItem[15];

        ObjectItemData[0] = new ObjectItem(0, "Alergia e inmunología");
        ObjectItemData[1] = new ObjectItem(1, "Anestesiología");
        ObjectItemData[2] = new ObjectItem(2, "Cardiología");
        ObjectItemData[3] = new ObjectItem(3, "Cirugía cardíaca");
        ObjectItemData[4] = new ObjectItem(4, "Dermatología");
        ObjectItemData[5] = new ObjectItem(5, "Fonoaudiología");
        ObjectItemData[6] = new ObjectItem(6, "Endocrinología");
        ObjectItemData[7] = new ObjectItem(7, "Gatroenterología");
        ObjectItemData[8] = new ObjectItem(8, "Nefrología");
        ObjectItemData[9] = new ObjectItem(9, "Neurología");
        ObjectItemData[10] = new ObjectItem(10, "Nutrición");
        ObjectItemData[11] = new ObjectItem(11, "Oftalmología");
        ObjectItemData[12] = new ObjectItem(12, "Otorrinolaringologia");
        ObjectItemData[13] = new ObjectItem(13, "Pediatría");
        ObjectItemData[14] = new ObjectItem(14, "Traumatología");


        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.activity_especialidades, ObjectItemData);

        ListView listViewItems = new ListView(this);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());

     alertDialogEspe = new AlertDialog.Builder(this)
             .setView(listViewItems)
                .setTitle("ESPECIALIDADES")
                .show();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
