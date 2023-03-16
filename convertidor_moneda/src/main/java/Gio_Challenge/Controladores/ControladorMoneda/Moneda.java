package Gio_Challenge.Controladores.ControladorMoneda;

import javax.swing.*;

public class Moneda {
    private String nombre;
    private String simbolo;
    private ImageIcon icono;

    public Moneda(){

    }

    public Moneda(String nombre, String simbolo, ImageIcon icono) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.icono = icono;
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

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "(" + simbolo + ")" + " / " + nombre;
    }
}
