package com.example.myresume;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ApplyforJob extends Activity {

    List<InforList> applyList = new ArrayList<InforList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyfor_job);
        TextView titleText = findViewById(R.id.titleText);
        titleText.setText("求职意向");
        ListView applyView = findViewById(R.id.applyView);
        initList();
        InforAdapter applyAdapter = new InforAdapter(ApplyforJob.this,R.layout.infor_item,applyList);
        applyView.setAdapter(applyAdapter);
        //设置本文信息为上次保存信息
        InforList itemPlace = applyList.get(0);
        InforList itemLocat = applyList.get(1);
        final EditText placeText = itemPlace.getEditText();
        final EditText locatText = itemLocat.getEditText();
        Log.d("Infor","======"+placeText.getText().toString());//placeText为空

        //placeText.setText(MainActivity.intension[0]);//获取的EditText报空指针错误
        //locatText.setText(MainActivity.intension[1]);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存信息
                //MainActivity.intension[0] = placeText.getText().toString();
                //MainActivity.intension[1] = placeText.getText().toString();
                Toast.makeText(ApplyforJob.this,"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initList(){
        String[] jobType = {"职位：","地点："};
        for(int i=0;i<jobType.length;i++){
            InforList list = new InforList(jobType[i]);
            applyList.add(list);
        }
    }
}
