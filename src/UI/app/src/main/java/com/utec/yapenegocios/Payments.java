package com.utec.yapenegocios;

public class Payments  {

    String item;
    String payMethod;
    String amount;
    String nameBusiness;
    String ruc;
    String email;
    String direction;



    public Payments() {}

    public Payments( String item, String payMethod, String amount, String nameBusiness, String ruc, String email, String direction) {

        this.item = item;
        this.payMethod = payMethod;
        this.amount = amount;
        this.nameBusiness = nameBusiness;
        this.ruc = ruc;
        this.email = email;
        this.direction = direction;
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