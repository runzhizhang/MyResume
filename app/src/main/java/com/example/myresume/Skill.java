package com.example.myresume;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Skill extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        TextView titleText = findViewById(R.id.titleText);
        titleText.setText("职业技能");
        final EditText skillsText = findViewById(R.id.skillsText);
        skillsText.setText(MainActivity.skills);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存信息
                MainActivity.skills = skillsText.getText().toString();
                Toast.makeText(Skill.this,"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
