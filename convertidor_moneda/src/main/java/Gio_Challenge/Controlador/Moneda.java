package Gio_Challenge.Controlador;

public class Moneda {
    private String nombre;
    private String simbolo;
    private String codigo;
    private double tipoCambio;

    public Moneda(){

    }

    public Moneda(String nombre, String simbolo, String codigo, double tipoCambio) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.codigo = codigo;
        this.tipoCambio = tipoCambio;
    }

    public double convertirMoneda(Moneda monedaDestino){
        return 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
