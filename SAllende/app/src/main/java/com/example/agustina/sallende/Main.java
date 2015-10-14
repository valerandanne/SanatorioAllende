package com.example.agustina.sallende;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Main extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PhoneCallListener callListener = new PhoneCallListener();
        TelephonyManager mTM = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        mTM.listen(callListener, PhoneStateListener.LISTEN_CALL_STATE);
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

    public void clickCobertura(View v){
        Button btn = (Button)findViewById(R.id.button_cob);
        startActivity(new Intent(this, CoberturaActivity.class));
    }
    public void clickUbicación(View v){
        Button btn = (Button)findViewById(R.id.button_ub);
        startActivity(new Intent(this, MapsActivity.class));
    }
    public void clickEspecialidades(View v){
        Button btn = (Button)findViewById(R.id.button_esp);
        startActivity(new Intent(this,EspecialidadesActivity.class));
    }
    public void clickTurnos(View v){
        Button btn = (Button)findViewById(R.id.button_tur);
        String number= (String)btn.getText().toString();

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:08105552553"));
        startActivity(callIntent);
    }


private class PhoneCallListener extends PhoneStateListener {

    private boolean isPhoneCalling = false;

    String LOG_TAG = "LOGGING 123";

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        if (TelephonyManager.CALL_STATE_RINGING == state) {
            // phone ringing
            Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
        }

        if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
            // active
            Log.i(LOG_TAG, "OFFHOOK");

            isPhoneCalling = true;
        }

        if (TelephonyManager.CALL_STATE_IDLE == state) {
            // run when class initial and phone call ended,
            // need detect flag from CALL_STATE_OFFHOOK
            Log.i(LOG_TAG, "IDLE");

            if (isPhoneCalling) {

                Log.i(LOG_TAG, "restart app");

                // restart app
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(
                                getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

                isPhoneCalling = false;
            }

        }
    }
}

}