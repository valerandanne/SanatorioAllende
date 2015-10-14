package com.example.agustina.sallende;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Agustina on 06/10/2015.
 */
public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();
        ListView ListViewItem = ((ListView) view.findViewById(R.id.list));
        Toast.makeText(context, "id is: " + id , Toast.LENGTH_SHORT).show();


    }

}
