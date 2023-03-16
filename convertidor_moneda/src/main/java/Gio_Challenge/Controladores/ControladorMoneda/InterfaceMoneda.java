package Gio_Challenge.Controladores.ControladorMoneda;

import java.io.IOException;

public interface InterfaceMoneda {

    double convertirToDestino(Double cantidad, String simboloDestino) throws IOException;
}
