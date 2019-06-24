package com.utec.yapenegocios;

import java.util.ArrayList;

public class Register {
    public String nameBusiness;
    public String ruc;
    public String direction;
    public String email;
    public String PIN;
    public String yourNumber;
    public String dniCollaborator;
    public String rolOf;
    public ArrayList<String> addNewCollaborator;

    public Register(){}

    public Register(String nameBusiness, String ruc,  String direction, String email, String PIN, String yourNumber, String dniCollaborator, String rolOf, ArrayList<String> addNewCollaborator) {
        this.nameBusiness = nameBusiness;
        this.ruc = ruc;
        this.direction = direction;
        this.email= email;
        this.PIN = PIN;
        this.yourNumber=yourNumber;
        this.dniCollaborator = dniCollaborator;
       this.addNewCollaborator = addNewCollaborator;
        this.rolOf = "Owner";
    }


    public String getName() {
        return nameBusiness;
    }

    public ArrayList<String> getNewCollaborator(){
        return addNewCollaborator;
    }
    public String getRuc() {
        return ruc;
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

    public String getOneByCollaborator(int index){
        return  addNewCollaborator.get(index);
    }

}