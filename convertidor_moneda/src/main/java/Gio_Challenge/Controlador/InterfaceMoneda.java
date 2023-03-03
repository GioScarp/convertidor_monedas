package Gio_Challenge.Controlador;

import java.io.IOException;

public interface InterfaceMoneda {

    double convertirToDestino(Double cantidad, String simboloDestino) throws IOException;
}
