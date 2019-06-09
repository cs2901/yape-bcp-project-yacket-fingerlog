package com.utec.yapenegocios;

public class OwnerCollaborators {

    public String yourNumber;
    public String dniCollaborator;



    public OwnerCollaborators(String yourNumber, String dniCollaborator) {
        this.yourNumber=yourNumber;
        this.dniCollaborator = dniCollaborator;
    }


    public String getNumber(){
        return yourNumber;
    }

    public String getCollaborator(){
        return dniCollaborator;
    }


}