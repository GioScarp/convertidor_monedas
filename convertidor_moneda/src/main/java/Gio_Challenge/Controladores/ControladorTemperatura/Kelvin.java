package Gio_Challenge.Controladores.ControladorTemperatura;

import javax.swing.*;

public class Kelvin extends Temperatura{
    public Kelvin(String simbolo, String nombre, ImageIcon icon) {
        super(simbolo, nombre, icon);
    }

    public double kelvinToCelsius(){
        return (getTemperatura() - 273.15);
    }

    public double KelvinToFahrenheit(){
        return ((getTemperatura() - 273.15) * 1.8 ) + 32;
    }
}
