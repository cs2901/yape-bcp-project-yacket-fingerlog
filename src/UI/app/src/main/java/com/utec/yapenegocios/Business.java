package com.utec.yapenegocios;

public class Business {
    public String name;
    public String rol;

    public Business(String name, String rol) {
        this.name = name;
        this.rol = rol;
    }

    public Business() {

    }

    public String getName() {
        return name;
    }


    public String getRol() {
        return rol;
    }

}
