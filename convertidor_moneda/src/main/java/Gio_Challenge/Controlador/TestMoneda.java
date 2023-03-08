package Gio_Challenge.Controlador;

import java.io.IOException;

public class TestMoneda {
    public static void main(String[] args) {
        MonedaBase monedaBase = new MonedaBase("Pesos Colombianos", "COP");

        MonedaBase monedaBase2 = new MonedaBase("Euros", "EUR");


        try {
            System.out.println(monedaBase.convertirToDestino(5000.0, "USD"));
            System.out.println(monedaBase2.convertirToDestino(50.0, "COP"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
