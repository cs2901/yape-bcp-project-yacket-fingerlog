package com.utec.yapenegocios;

public class Payments  {

    String item;
    String payMethod;
    String amount;
    String nameBusiness;
    String ruc;
    String email;
    String direction;
    String dni;
    String typeOfCollaborator;


    public Payments() {}

    public Payments( String item, String payMethod, String amount, String nameBusiness, String ruc, String email, String direction, String dni, String typeOfCollaborator) {

        this.item = item;
        this.payMethod = payMethod;
        this.amount = amount;
        this.nameBusiness = nameBusiness;
        this.ruc = ruc;
        this.email = email;
        this.direction = direction;
        this.dni = dni;
        this.typeOfCollaborator = typeOfCollaborator;
    }

    public String getDni() {
        return dni;
    }

    public String getTypeOfCollaborator() {
        return typeOfCollaborator;
    }

    public String getItem() {
        return item;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public String getAmount() {
        return amount;
    }

    public String getNameBusiness() {
        return nameBusiness;
    }

    public String getRuc() {
        return ruc;
    }

    public String getEmail() {
        return email;
    }

    public String getDirection() {
        return direction;
    }




}