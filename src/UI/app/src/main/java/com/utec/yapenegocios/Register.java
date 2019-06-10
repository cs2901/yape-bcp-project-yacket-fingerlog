package com.utec.yapenegocios;

public class Register{
    public String nameBusiness;
    public String ruc;
    public String nAccount;
    public String direction;
    public String email;
    public String PIN;
    public String yourNumber;
    public String dniCollaborator;
    public String rolOf;

public Register(){}

    public Register(String nameBusiness, String ruc, String nAccount, String direction, String email, String PIN, String yourNumber, String dniCollaborator,String rolOf) {
        this.nameBusiness = nameBusiness;
        this.ruc = ruc;
        this.nAccount = nAccount;
        this.direction = direction;
        this.email= email;
        this.PIN = PIN;
        this.yourNumber=yourNumber;
        this.dniCollaborator = dniCollaborator;
        this.rolOf = "Owner";
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

    public String getPINnr(){
        return PIN;
    }

    public String getNumber(){
        return yourNumber;
    }

    public String getCollaborator(){
        return dniCollaborator;
    }

    public String getRolOf(){return rolOf;}


}