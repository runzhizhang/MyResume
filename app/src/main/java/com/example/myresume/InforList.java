package com.example.myresume;

import android.widget.EditText;

public class InforList {
    private String inforname;
    private EditText editText;

    public InforList(String inforname){
        this.inforname = inforname;
    }
    public String getInforname(){
        return inforname;
    }
    public EditText getEditText(){ return editText; }
    public void setEditText(EditText editText){ this.editText = editText; }
}
