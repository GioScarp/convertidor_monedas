package Gio_Challenge.Controladores.ControladorTemperatura;

import javax.swing.*;

public class Temperatura {

    private double temperatura;
    private String simbolo;
    private String nombre;
    private ImageIcon icon;

    public Temperatura(){

    }

    public Temperatura(double temperatura, String simbolo, String nombre, ImageIcon icon) {
        this.temperatura = temperatura;
        this.simbolo = simbolo;
        this.nombre = nombre;
        this.icon = icon;
    }

    public Temperatura (String simbolo, String nombre, ImageIcon icon){
        this.simbolo = simbolo;
        this.nombre = nombre;
        this.icon = icon;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "(" + simbolo + ")" + " " + nombre;
    }
}

