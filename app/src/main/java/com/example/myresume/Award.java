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

public class Award extends Activity {

    List<Pro> projectLists = new ArrayList<Pro>();
    int count = 0;//用于计数奖项个数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("奖项证书");
        Button proButt = findViewById(R.id.proButt);
        proButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加项目经历
                creatPro();
            }
        });

        ListView proList = findViewById(R.id.proList);
        ProAdapter adapter = new ProAdapter(Award.this,R.layout.pro_item,projectLists);
        proList.setAdapter(adapter);

    }

    public void creatPro(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Award.this);
        View viewinfor = View.inflate(Award.this,R.layout.addaward,null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setView(viewinfor);
        alertDialog.show();
        Button awardButt = alertDialog.findViewById(R.id.addawardButt);
        final EditText awardname = alertDialog.findViewById(R.id.awardname);
        awardname.setHint("奖项名称、级别");
        final EditText awardtime = alertDialog.findViewById(R.id.awardtime);
        awardtime.setHint("获奖时间");
        awardButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = awardname.getText().toString();
                String time = awardtime.getText().toString();
                if(name.equals("")||time.equals("")){
                    Toast.makeText(Award.this,"请输入完整信息",Toast.LENGTH_SHORT).show();
                }else{
                    //添加成功
                    count++;
                    alertDialog.cancel();
                    projectLists.add(new Pro("奖项"+count));
                    Toast.makeText(Award.this, "添加成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
