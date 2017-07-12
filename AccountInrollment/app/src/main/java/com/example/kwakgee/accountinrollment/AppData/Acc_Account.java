package com.example.kwakgee.accountinrollment.AppData;

import android.graphics.Bitmap;

/**
 * Created by kwakgee on 2017. 7. 12..
 */

public class Acc_Account {

    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private Bitmap img;

    public Acc_Account(String id, String password, String name, String phone, String email, Bitmap img) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
