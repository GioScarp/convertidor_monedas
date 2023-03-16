package Gio_Challenge.Controladores.ControladorTemperatura;

import javax.swing.*;

public class Celsius extends Temperatura{

    public Celsius(String simbolo, String nombre, ImageIcon icon) {
        super(simbolo, nombre, icon);
    }

    public double celsiusToKelvin(){
        return (getTemperatura() + 273.15) ;
    }

    public double celsiusToFahrenheit(){
        return (getTemperatura() * 1.8) + 32;
    }
}
