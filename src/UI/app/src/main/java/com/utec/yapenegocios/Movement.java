package com.utec.yapenegocios;

public class Movement {
    public String fecha;
    public String monto;
    public String por;

    public Movement() {}

    public Movement(String fecha, String monto, String por) {
        this.fecha = fecha;
        this.monto = monto;
        this.por = por;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMonto() {
        return monto;
    }

    public String getPor() {
        return por;
    }
}
