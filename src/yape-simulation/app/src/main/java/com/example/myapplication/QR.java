package com.example.myapplication;

import java.util.ArrayList;

public class QR {
    String name;
    ArrayList<String > items;
    String ammount;
    String RUC;
    String email;
    String dir;

    public QR(String name, ArrayList<String> items, String ammount, String RUC, String email, String dir) {
        this.name = name;
        this.items = items;
        this.ammount = ammount;
        this.RUC = RUC;
        this.email = email;
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public String getAmmount() {
        return ammount;
    }

    public String getRUC() {
        return RUC;
    }

    public String getEmail() {
        return email;
    }

    public String getDir() {
        return dir;
    }
}
