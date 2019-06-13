package com.example.myapplication;

public class Customer {
    static String name;
    static String dir;
    static String id;
    static String correo;

    public static String getName() {
        return name;
    }

    public static String getDir() {
        return dir;
    }

    public static String getId() {
        return id;
    }

    public static String getCorreo() {
        return correo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Customer(String name, String dir, String id, String correo) {
        this.name = name;
        this.dir = dir;
        this.id = id;
        this.correo = correo;
    }
    public Customer() {
        if (this.name == null){

            this.name = "Void";
            this.dir = "Void";
            this.id = "Void";
            this.correo = "Void";

        }
    }

}