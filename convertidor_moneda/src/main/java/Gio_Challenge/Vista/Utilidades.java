package Gio_Challenge.Vista;

import Gio_Challenge.Controladores.ControladorMoneda.MonedaBase;
import Gio_Challenge.Controladores.ControladorTemperatura.Celsius;
import Gio_Challenge.Controladores.ControladorTemperatura.Fahrenheit;
import Gio_Challenge.Controladores.ControladorTemperatura.Kelvin;
import Gio_Challenge.Controladores.ControladorTemperatura.Temperatura;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class Utilidades {

    public static final Color COLOR_BLUE = new Color(0,75,255);
    public static final Color COLOR_LIGHTGREY = new Color(236,236,236);
    public static final Color COLOR_GREY = new Color(80,80,80);
    public static final Font PRIMARY_SEGOE = new Font("Segoe UI", Font.BOLD,14);
    public static final Font SECOND_SEGOE = new Font("Segoe UI", Font.PLAIN,14);

    public static final ArrayList<MonedaBase> MONEDAS = new ArrayList<>(List.of(
            new MonedaBase("Peso Colombiano", "COP",new ImageIcon("resources/col.png")),
            new MonedaBase("Dolar", "USD",new ImageIcon("resources/usa.png")),
            new MonedaBase("Euro", "EUR",new ImageIcon("resources/union-europea.png")),
            new MonedaBase("Libra Esterlina", "GBP",new ImageIcon("resources/reino-unido.png")),
            new MonedaBase("Yen Japonés", "JPY",new ImageIcon("resources/japon.png")),
            new MonedaBase("Won Surcoreano", "KRW",new ImageIcon("resources/corea-sur.png"))
    ));

    public static final ArrayList<Temperatura> TEMPERATURAS = new ArrayList<>(List.of(
            new Celsius("°C", "Celsius",new ImageIcon("resources/celsius.png")),
            new Kelvin("°K", "Kelvin",new ImageIcon("resources/kelvin.png")),
            new Fahrenheit("°F", "Fahrenheit",new ImageIcon("resources/fahrenheit.png"))
    ));

    private Utilidades() {}

    //colocar Iconos con una dimension establecida
    public static void setImageLabel(JLabel jlabel, ImageIcon imageIcon, int size) {
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
        jlabel.setIcon(icon);
        jlabel.repaint();
    }

    //Insertar texto ajustado al Jlabelresultado para que no altere el tamaño del Label
    public static void setTextoAjustado(JLabel jLabel, String texto, Color color){
// Obtener las métricas de la fuente actual
        FontMetrics metrics = jLabel.getFontMetrics(jLabel.getFont());
// Obtener el ancho del texto en píxeles
        int anchoTexto = metrics.stringWidth(texto);
// Obtener el ancho disponible en el JLabel
        int anchoDisponible = jLabel.getWidth();
// Si el texto es demasiado ancho para el JLabel, reducir el tamaño de la fuente
        if (anchoTexto > anchoDisponible)
            jLabel.setFont(ajustarFuente(jLabel.getFont(), anchoTexto, anchoDisponible));

        jLabel.setText(texto);
        jLabel.setForeground(color);
    }

    // Calcular el nuevo tamaño de fuente que se ajuste al ancho del JLabel
    private static Font ajustarFuente(Font fuenteActual, int anchoTexto, int anchoDisponible){
        int tamanoFuente = fuenteActual.getSize();
        int nuevoTamano = (int) (tamanoFuente * ((double) anchoDisponible / (double) anchoTexto));
        return fuenteActual.deriveFont((float) nuevoTamano);
    }

    public static void cleanTextFields(JTextField jTextField){
        if(jTextField.getText().equals("Ingrese un valor"))
            jTextField.setText("");
    }

    public static void setTextIfEmpty(JTextField jTextField){
        if(jTextField.getText().isEmpty()){
            jTextField.setText("Ingrese un valor");
            jTextField.setForeground(Utilidades.COLOR_LIGHTGREY);
        }
    }
}
