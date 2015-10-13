package com.example.agustina.sallende;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Beans.BeanEspecialidad;

/**
 * Created by Agustina on 06/10/2015.
 */
public class ArrayAdapterItem extends ArrayAdapter<BeanEspecialidad> {


    private static class ViewHolder {
        TextView text1;
    }

    public ArrayAdapterItem(Context mContext, ArrayAdapter<BeanEspecialidad> especialidades) {

        super(mContext, android.R.layout.simple_list_item_1, (List<BeanEspecialidad>) especialidades);


    }
    public View getView(int position, View convertView, ViewGroup parent) {

      BeanEspecialidad especialidad = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder.text1 = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text1.setText(especialidad.getDescripcion());

        return convertView;
    }



    }
