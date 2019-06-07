package com.company.yapenegocios;

public class Movement {
    public int fecha;
    public int monto;
    public String por;

    public Movement(String usuarios, String lastName, String roll) {}

    public Movement(int fecha, int monto, String por) {
        this.fecha = fecha;
        this.monto = monto;
        this.por = por;
    }

    public int getFecha() {
        return fecha;
    }

    public int getMonto() {
        return monto;
    }

    public String getPor() {
        return por;
    }
}
