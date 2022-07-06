package com.example.myapplicationduan1.LopModel;

public class Dangki {
    String username,pass,enterpass;

    public Dangki(String username, String pass) {
        this.username = username;
        this.pass = pass;

    }

    public Dangki() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public static final String TB_NAME_DK = "Dangki";
    public static final String COL_NAME_TK = "taikhoan";
    public static final String COL_NAME_MK = "matkhau";
}
