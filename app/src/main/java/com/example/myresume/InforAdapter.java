package com.example.myresume;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class InforAdapter extends ArrayAdapter {
    private int resourceId;
    public InforAdapter(Context context, int resource, List<InforList> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        InforList inforList = (InforList) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(inforList.getInforname());
        EditText editText = view.findViewById(R.id.editText);
        Log.d("Infor",editText.getText().toString());
        inforList.setEditText(editText);
        Log.d("Infor","获取文本输入框");
        return view;
    }

}
