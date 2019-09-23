package com.example.myresume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public String[] infor = {"基本信息","求职意向","教育背景","在校经历","工作经历","项目经历","奖项证书","职业技能","兴趣爱好","自我评价"};
    static String name = null;//姓名
    static String number = null;//电话号码
    static String email = null;//邮箱
    static List<BasicOtherInfors> basicOtherInfors = new ArrayList<BasicOtherInfors>();//自定义基本信息
    static String[] intension = new String[2];//求职意向
    static List<EducationBG> edu = new ArrayList<EducationBG>();//教育背景
    static List<InSchool> inSchool = new ArrayList<InSchool>();//在校经历
    static List<Work> work = new ArrayList<Work>();//工作经历
    static List<Projects> projects = new ArrayList<Projects>();//项目经历
    static List<Awards> awards = new ArrayList<Awards>();//获奖证书
    static String skills = null;//职业技能
    static String hobbys = null;//兴趣爱好
    static String myself = null;//自我评价
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();//初始化
        tabHost.addTab(tabHost.newTabSpec("tab_1").setIndicator("信息填写").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab_2").setIndicator("模板选择").setContent(R.id.tab2));

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("tab_1")){
                    //填写信息界面
                    Toast.makeText(MainActivity.this, "请填写信息", Toast.LENGTH_SHORT).show();
                }else if(s.equals("tab_2")){
                    //模板选择界面
                    Toast.makeText(MainActivity.this,"请选择模板",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ListView listView = findViewById(R.id.listView);
        //适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,infor);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String type = infor[i];
                Toast.makeText(MainActivity.this, type, Toast.LENGTH_SHORT).show();
                //相应界面跳转
                Intent intent;
                switch (type){
                    case "基本信息":
                        //跳转到“基本信息”页面
                        intent = new Intent(MainActivity.this,BasicInfor.class);
                        startActivity(intent);
                        break;
                    case "求职意向":
                        //求职意向（职位，地点）
                        intent = new Intent(MainActivity.this,ApplyforJob.class);
                        startActivity(intent);
                        break;
                    case "教育背景":
                        intent = new Intent(MainActivity.this,Education.class);
                        startActivity(intent);
                        break;
                    case "在校经历":
                        intent = new Intent(MainActivity.this,School.class);
                        startActivity(intent);
                        break;
                    case "工作经历":
                        intent = new Intent(MainActivity.this,WorkExp.class);
                        startActivity(intent);
                        break;
                    case "项目经历":
                        intent = new Intent(MainActivity.this,Project.class);
                        startActivity(intent);
                        break;
                    case "奖项证书":
                        intent = new Intent(MainActivity.this,Award.class);
                        startActivity(intent);
                        break;
                    case "职业技能":
                        intent = new Intent(MainActivity.this,Skill.class);
                        startActivity(intent);
                        break;
                    case "兴趣爱好":
                        intent = new Intent(MainActivity.this,Hobby.class);
                        startActivity(intent);
                        break;
                    case "自我评价":
                        //跳转自我评价界面
                        intent = new Intent(MainActivity.this,SelfAssess.class);
                        startActivity(intent);
                        break;
                    default:break;
                }
            }
        });
    }
}
