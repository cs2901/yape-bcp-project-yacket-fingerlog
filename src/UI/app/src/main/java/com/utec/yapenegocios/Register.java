package com.utec.yapenegocios;

public class Register{
    public String nameBusiness;
    public String ruc;
    public String nAccount;
    public String direction;
    public String email;
    public String rol;
    public String yourNumber;
    public String dniCollaborator;



    public Register(String nameBusiness, String ruc, String nAccount, String direction, String email, String rol, String yourNumber, String dniCollaborator) {
        this.nameBusiness = nameBusiness;
        this.ruc = ruc;
        this.nAccount = nAccount;
        this.direction = direction;
        this.email= email;
        this.rol = rol;
        this.yourNumber=yourNumber;
        this.dniCollaborator = dniCollaborator;
    }



    public String getName() {
        return nameBusiness;
    }

    public String getRuc() {
        return ruc;
    }

    public String getnAccount() {
        return nAccount;
    }

    public String getDirection(){
        return direction;
    }

    public String getEmail(){
        return email;
    }

    public String getRol(){
        return rol;
    }

    public String getNumber(){
        return yourNumber;
    }

    public String getCollaborator(){
        return dniCollaborator;
    }


}