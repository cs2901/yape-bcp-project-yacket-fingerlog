package com.utec.yapenegocios;

public class Business {
    public String nameBusiness;
    public String rolOf;


    public Business(String name, String rol) {
        this.nameBusiness = name;
        this.rolOf = rol;

    }

    public Business() {

    }

    public String getName() {
        return nameBusiness;
    }

    public String getRol() {
        return rolOf;
    }

}
