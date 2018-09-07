package com.example.application.bean;

/**
 * Created by Magic
 * on 2018/9/7.
 */
public class User {
    private String name;
    private int type;
//    private String imgUrl;

    public User(String name,int type) {
        this.name = name;
        this.type = type;
//        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
