package com.example.agustina.sallende;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Agustina on 06/10/2015.
 */
public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        /*switch (context)
        {
            case "EspecialidadesActivity" : onItemClickEspecialidad(parent,view, position, id);
                break;
        }*/

        TextView c = (TextView) view.findViewById(position);
        String especialidad = c.getText().toString();

        SQLiteDB db = new SQLiteDB(context);
        db.getReadableDatabase();
        int idEspe = db.getIdEspecialidad(especialidad);
        Cursor cur= db.getMedicosFromEspe(idEspe);

        Toast toast = Toast.makeText(context, "espe id"+ idEspe, Toast.LENGTH_SHORT);
        toast.show();
    }

   /* private void onItemClickEspecialidad(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView c = (TextView) view.findViewById(position);
        String especialidad = c.getText().toString();

        SQLiteDB db = new SQLiteDB(context);
        db.getReadableDatabase();
        int idEspe = db.getIdEspecialidad(especialidad);
        Cursor cur= db.getMedicosFromEspe(idEspe);

        Toast toast = Toast.makeText(context, "espe id"+ idEspe, Toast.LENGTH_SHORT);
        toast.show();

    }*/


}
