package com.example.sqlite;

public class VentaModelo {
    private  double tarjeta, efectivo, total;

    public VentaModelo(){
    }

    public VentaModelo(double tarjeta, double efectivo, double total) {
        this.tarjeta = tarjeta;
        this.efectivo = efectivo;
        this.total = total;
    }

    public double getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(double tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
