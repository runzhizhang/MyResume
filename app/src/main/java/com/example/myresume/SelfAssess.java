package com.example.myresume;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SelfAssess extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏系统自带标题栏
        setContentView(R.layout.activity_self_assess);
        TextView textView = findViewById(R.id.titleText);
        textView.setText("自我评价");
        final EditText selfText = findViewById(R.id.editTextSelf);
        selfText.setText(MainActivity.myself);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.myself = selfText.getText().toString();
                Toast.makeText(SelfAssess.this,"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
