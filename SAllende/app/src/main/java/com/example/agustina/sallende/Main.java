package com.example.agustina.sallende;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity{

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button_ub);
        b2 = (Button) findViewById(R.id.button_cob);
        b3 = (Button) findViewById(R.id.button_esp);


        b1.setOnClickListener(myhandler);
        b2.setOnClickListener(myhandler);
        b3.setOnClickListener(myhandler);
    }

    View.OnClickListener myhandler = new View.OnClickListener() {
        public void onClick(View v) {
            Intent in = new Intent();
            switch (v.getId()) {
                case R.id.button_ub:
                    in = new Intent(Main.this, MapsActivity.class);
                    break;
                case R.id.button_esp:
                    in = new Intent(Main.this, EspecialidadesActivity.class);
                    break;
                case R.id.button_cob:
                    in = new Intent(Main.this, CoberturaActivity.class);
                    break;
                case (R.id.button_tur):
            }
            startActivity(in);
        }
    };

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
