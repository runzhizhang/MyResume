package com.example.myresume;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class DefineAdapter extends ArrayAdapter {

    private int resourceId;
    public DefineAdapter(Context context, int resource, List<OtherList> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        OtherList otherList = (OtherList) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView typeView = view.findViewById(R.id.infortype);
        TextView contentView = view.findViewById(R.id.content);
        typeView.setText(otherList.getInfortype());
        contentView.setText(otherList.getContent());
        return view;
    }
}
