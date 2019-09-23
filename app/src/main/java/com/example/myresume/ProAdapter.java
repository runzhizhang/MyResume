package com.example.myresume;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProAdapter extends ArrayAdapter {
    private int resourceId;
    public ProAdapter(Context context, int resource, List<Pro> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Pro pro = (Pro) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView protext = view.findViewById(R.id.protext);
        protext.setText(pro.getPro());
        return view;
    }

}
