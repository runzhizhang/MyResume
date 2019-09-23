package com.example.myresume;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hobby extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assess);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("兴趣爱好");
        //兴趣爱好这部分输入格式与自我评价相似，layout采用自我评价部分的布局
        EditText editText = findViewById(R.id.editTextSelf);
        editText.setHint("请输入个人兴趣爱好");
        Button saveButton = findViewById(R.id.saveButton);
        final EditText hobbyText = findViewById(R.id.editTextSelf);
        hobbyText.setText(MainActivity.hobbys);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存信息
                MainActivity.hobbys = hobbyText.getText().toString();
                Toast.makeText(Hobby.this,"保存成功！",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
