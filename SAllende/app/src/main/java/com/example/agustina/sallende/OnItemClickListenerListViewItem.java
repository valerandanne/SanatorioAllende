package com.example.agustina.sallende;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

        TextView textViewItem = ((TextView) view.findViewById(R.id.textViewItem));

        //String listItemText = textViewItem.getText().toString();

        AlertDialog.Builder alertDialogProf =new AlertDialog.Builder(context);

        alertDialogProf.setMessage("Dra Agustina Demaldé ")
                .setTitle("Profesional")
                .setCancelable(false)
                .setNeutralButton("Aceptar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        AlertDialog alert =alertDialogProf.create();
        alert.show();

        //Toast.makeText(context, "Item: " + listItemText , Toast.LENGTH_SHORT).show();

        //((Main) context).alertDialogEspe.cancel();

    }

}
