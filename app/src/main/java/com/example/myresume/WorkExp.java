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

public class WorkExp extends Activity {

    List<Pro> projectLists = new ArrayList<Pro>();
    int count = 0;//用于计数总的工作经历的个数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("工作经历");
        Button butt = findViewById(R.id.workButt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加项目经历
                creatPro();
            }
        });

        ListView workList = findViewById(R.id.workList);
        ProAdapter adapter = new ProAdapter(WorkExp.this,R.layout.pro_item,projectLists);
        workList.setAdapter(adapter);

    }

    public void creatPro(){
        AlertDialog.Builder builder = new AlertDialog.Builder(WorkExp.this);
        View viewinfor = View.inflate(WorkExp.this,R.layout.addproject,null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setView(viewinfor);
        alertDialog.show();
        Button workButt = alertDialog.findViewById(R.id.addproButt);
        final EditText namepro = alertDialog.findViewById(R.id.namepro);
        namepro.setHint("公司名称");
        final EditText time = alertDialog.findViewById(R.id.time);
        time.setHint("时间段");
        final EditText role = alertDialog.findViewById(R.id.role);
        role.setHint("职务");
        final EditText detail = alertDialog.findViewById(R.id.detail);
        detail.setHint("工作详情");
        workButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namep = namepro.getText().toString();
                String tim = time.getText().toString();
                String rol = role.getText().toString();
                String deta = detail.getText().toString();
                if(namep.equals("")||deta.equals("")){
                    Toast.makeText(WorkExp.this,"请输入公司名称或工作详情",Toast.LENGTH_SHORT).show();
                }else{
                    //添加成功
                    count++;
                    alertDialog.cancel();
                    projectLists.add(new Pro("工作经历"+count));
                    Toast.makeText(WorkExp.this, "添加成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
