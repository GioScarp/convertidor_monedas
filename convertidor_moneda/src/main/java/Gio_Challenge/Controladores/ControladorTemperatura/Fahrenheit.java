package Gio_Challenge.Controladores.ControladorTemperatura;

import javax.swing.*;

public class Fahrenheit extends Temperatura{

    public Fahrenheit(String simbolo, String nombre, ImageIcon icon) {
        super(simbolo, nombre, icon);
    }

    public double fahrenheitToKelvin(){
        return ((getTemperatura() -32) *(5/9d) + 273.15);
    }

    public double fahrenheitTocelsius(){
        return (getTemperatura() -32)*(5/9d);
    }
}
