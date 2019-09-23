package com.example.myresume;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Education extends Activity {

    List<Pro> projectLists = new ArrayList<Pro>();
    int count = 0;//用于计数总的项目的个数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("教育背景");
        Button eduButt = findViewById(R.id.eduButt);
        eduButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加项目经历
                creatPro();
            }
        });

        ListView eduList = findViewById(R.id.eduList);
        ProAdapter adapter = new ProAdapter(Education.this,R.layout.pro_item,projectLists);
        eduList.setAdapter(adapter);
    }

    public void creatPro(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Education.this);
        View viewinfor = View.inflate(Education.this,R.layout.addproject,null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setView(viewinfor);
        alertDialog.show();
        Button addproButt = alertDialog.findViewById(R.id.addproButt);
        final EditText namepro = alertDialog.findViewById(R.id.namepro);
        namepro.setHint("学校名称");
        final EditText time = alertDialog.findViewById(R.id.time);
        time.setHint("时间段");
        final EditText role = alertDialog.findViewById(R.id.role);
        role.setHint("专业");
        final EditText detail = alertDialog.findViewById(R.id.detail);
        detail.setHint("主修课程");
        addproButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namep = namepro.getText().toString();
                String tim = time.getText().toString();
                String rol = role.getText().toString();
                String deta = detail.getText().toString();
                if(namep.equals("")||deta.equals("")){
                    Toast.makeText(Education.this,"请输入完整信息",Toast.LENGTH_SHORT).show();
                }else{
                    //添加成功
                    count++;
                    alertDialog.cancel();
                    projectLists.add(new Pro("教育背景"+count));
                    Toast.makeText(Education.this, "添加成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /*
    public void initProLists(){
        String[] name = {"项目名称：","时间段：","担任角色：","项目详情："};
        for(int i=0;i<name.length;i++){
            InforList list = new InforList(name[i]);
            projectLists.add(list);
        }
    }
    */
}
