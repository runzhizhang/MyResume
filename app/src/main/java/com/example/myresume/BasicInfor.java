package com.example.myresume;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class BasicInfor extends Activity {

    private List<InforList> inforLists = new ArrayList<InforList>();
    private List<OtherList> otherLists = new ArrayList<OtherList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_infor);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("个人基本信息");
        //个人照片导入
        ImageView imageView = findViewById(R.id.imageView);
        //监听
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //连接手机相册，选择相片上传

            }
        });
        //信息必填部分
        ListView listView = findViewById(R.id.inforlistView);
        initInforName();
        InforAdapter adapter = new InforAdapter(BasicInfor.this,R.layout.infor_item,inforLists);
        listView.setAdapter(adapter);

        final EditText nameET = inforLists.get(0).getEditText();
        final EditText numberET = inforLists.get(1).getEditText();
        final EditText emailET = inforLists.get(2).getEditText();
        //nameET.setText(MainActivity.name);
        //numberET.setText(MainActivity.number);
        //emailET.setText(MainActivity.email);

        //自定义信息显示
        ListView otherInforList = findViewById(R.id.otherInforList);
        DefineAdapter otheradapter = new DefineAdapter(BasicInfor.this,R.layout.defineinfor,otherLists);
        otherInforList.setAdapter(otheradapter);

        //自定义信息部分
        Button butt = findViewById(R.id.addButton);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加自定义信息
                userdefined();
            }
        });

        //保存按钮监听，保存信息
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourname = nameET.getText().toString();
                Log.d("BasicInfor",yourname);
                String yournumber = numberET.getText().toString();
                String youremail = emailET.getText().toString();
                if(!yourname.equals("")&&!yournumber.equals("")&&!youremail.equals("")){
                    //必填信息完整，保存信息
                    MainActivity.name = yourname;
                    MainActivity.number = yournumber;
                    MainActivity.email = youremail;
                    Log.d("BasicInfor",yourname+","+yournumber+","+youremail);
                    Toast.makeText(BasicInfor.this,"保存成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BasicInfor.this,"请输入完整信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initInforName(){
        String[] infor = {"姓名*：","联系方式*：","邮箱*："};
        for(int i=0;i<infor.length;i++){
            InforList list = new InforList(infor[i]);
            inforLists.add(list);
        }
    }

    public void userdefined(){
        AlertDialog.Builder builder = new AlertDialog.Builder(BasicInfor.this);
        View viewinfor = View.inflate(BasicInfor.this,R.layout.otherinfor,null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setView(viewinfor);
        alertDialog.show();
        final EditText inforType = alertDialog.findViewById(R.id.inforType);
        final EditText content = alertDialog.findViewById(R.id.content);
        Button defineButton = alertDialog.findViewById(R.id.defineButton);
        defineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String infortype = inforType.getText().toString();
                String inforcontent = content.getText().toString();
                if(!infortype.equals("")&&!inforcontent.equals("")){
                    Toast.makeText(BasicInfor.this,"添加成功",Toast.LENGTH_SHORT).show();
                    alertDialog.cancel();
                    //自定义信息的显示
                    OtherList otherList = new OtherList(infortype+"：",inforcontent);
                    otherLists.add(otherList);
                }else{
                    Toast.makeText(BasicInfor.this,"请输入完整信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
