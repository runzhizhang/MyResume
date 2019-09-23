package com.example.myresume;

public class OtherList {
    private String infortype;
    private String content;

    public OtherList(String infortype,String content){
        this.infortype = infortype;
        this.content = content;
    }

    public String getInfortype() {
        return infortype;
    }

    public void setInfortype(String infortype) {
        this.infortype = infortype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
