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

public class School extends Activity {

    List<Pro> projectLists = new ArrayList<Pro>();
    int count = 0;//用于统计在校总的经历
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("在校经历");
        Button schoolButt = findViewById(R.id.schoolButt);
        schoolButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加项目经历
                creatPro();
            }
        });

        ListView schoolList = findViewById(R.id.schoolList);
        ProAdapter adapter = new ProAdapter(School.this,R.layout.pro_item,projectLists);
        schoolList.setAdapter(adapter);

    }

    public void creatPro(){
        AlertDialog.Builder builder = new AlertDialog.Builder(School.this);
        View viewinfor = View.inflate(School.this,R.layout.addproject,null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setView(viewinfor);
        alertDialog.show();
        Button addproButt = alertDialog.findViewById(R.id.addproButt);
        final EditText namepro = alertDialog.findViewById(R.id.namepro);
        namepro.setHint("部门名称或活动名称");
        final EditText time = alertDialog.findViewById(R.id.time);
        time.setHint("时间段");
        final EditText role = alertDialog.findViewById(R.id.role);
        role.setHint("担任角色");
        final EditText detail = alertDialog.findViewById(R.id.detail);
        detail.setHint("在校经历详情");
        addproButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namep = namepro.getText().toString();
                String tim = time.getText().toString();
                String rol = role.getText().toString();
                String deta = detail.getText().toString();
                if(namep.equals("")||deta.equals("")){
                    Toast.makeText(School.this,"请输入完整信息",Toast.LENGTH_SHORT).show();
                }else{
                    //添加成功
                    count++;
                    alertDialog.cancel();
                    projectLists.add(new Pro("在校经历"+count));
                    Toast.makeText(School.this, "添加成功", Toast.LENGTH_SHORT).show();
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
