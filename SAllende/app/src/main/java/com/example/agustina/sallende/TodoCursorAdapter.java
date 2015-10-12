package com.example.agustina.sallende;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Vale on 08/10/2015.
 */
public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_cobertura, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        TextView tvID = (TextView)view.findViewById(R.id.tvID);
        TextView tvName = (TextView)view.findViewById(R.id.tvName);
        //Extract properties from cursor

        String name = cursor.getString(cursor.getColumnIndex("colCobName"));
        int ID = cursor.getInt(cursor.getColumnIndex("colCobID"));

        tvID.setText(String.valueOf(ID));
        tvName.setText(name);

    }
}