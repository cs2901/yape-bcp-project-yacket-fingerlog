package com.company.yapenegocios;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    public String dni;
    public String nameCustomer;

    public Customer() {

    }

    public Customer(String dni, String nameCustomer) {
        this.dni = dni;
        this.nameCustomer = nameCustomer;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("dni", dni);
        result.put("name",nameCustomer);

        return result;
    }
}
