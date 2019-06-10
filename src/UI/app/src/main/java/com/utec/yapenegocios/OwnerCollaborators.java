package com.utec.yapenegocios;

public class OwnerCollaborators {

    public String yourNumber;
    public String dniCollaborator;
    public String rolOf;



    public OwnerCollaborators( String dniCollaborator,String rolOf) {
        this.dniCollaborator = dniCollaborator;
        this.rolOf = "Colaborador";
    }


    public String getNumber(){
        return yourNumber;
    }

    public String getCollaborator(){
        return dniCollaborator;
    }

    public String getRolOf(){return rolOf;}
}