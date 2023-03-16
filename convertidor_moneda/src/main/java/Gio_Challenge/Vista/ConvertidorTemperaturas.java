package Gio_Challenge.Vista;

import Gio_Challenge.Controladores.ControladorTemperatura.Celsius;
import Gio_Challenge.Controladores.ControladorTemperatura.Fahrenheit;
import Gio_Challenge.Controladores.ControladorTemperatura.Kelvin;
import Gio_Challenge.Controladores.ControladorTemperatura.Temperatura;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class ConvertidorTemperaturas extends JDialog{
    private JTextField textFieldTemper1;
    private JTextField textFieldTemper2;
    private JTextField textFieldTemper3;
    private JLabel JLabelTitle;
    private JLabel JLabeIconoTemper1;
    private JLabel JLabeIconoTemper2;
    private JLabel JLabeIconoTemper3;
    private JLabel JLabelInfo;
    private JPanel JPanelTemperatura;
    private JLabel JLabeIconoTitle;
    private JButton btnConvertir;
    private JComboBox<Temperatura> comboBoxTemperatura;

    public ConvertidorTemperaturas (JFrame parent) {
        super(parent,"Convertidor de Temperaturas",true);
        iniciarComponentes();
        setContentPane(JPanelTemperatura);
        setMinimumSize(new Dimension(500, 530));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //ActionListener para detectar la Temperatura seleccionada del JComboBoxe
        //y colocar el icono en el Jlabel correspondientes
        comboBoxTemperatura.addActionListener(e -> {
            setIconosJlabels();
            textFieldTemper2.setText("");
            textFieldTemper3.setText("");
        });

        //Se agregan DocumentListener para usar el evento insertUpdate
        // Esto detectará cuando se inserta nuevo contenido en el campo de texto
        textFieldTemper1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textFieldTemper1.setForeground(Utilidades.COLOR_BLUE); // Cambiar el color del texto al insertar
            }
            @Override
            public void removeUpdate(DocumentEvent e) {}
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        //FocusListener para usar los eventos focusGained y FocusLost
        //focusGained detecta cuando el campo de texto gana el foco
        //focusLost detecta cuando el campo de texto pierde el foco
        textFieldTemper1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                    Utilidades.cleanTextFields(textFieldTemper1);
            }
            @Override
            public void focusLost(FocusEvent e) {
                Utilidades.setTextIfEmpty(textFieldTemper1);

                String text = textFieldTemper1.getText().replace(",", ".");
                if(validateText(text))
                    Utilidades.setTextoAjustado(JLabelInfo, "Valor Temperatura: ", Utilidades.COLOR_GREY);
                else Utilidades.setTextoAjustado(JLabelInfo, "¡Temperatura invalida!", Color.red);
            }
        });

        btnConvertir.addActionListener(e -> {
            String text = textFieldTemper1.getText().replace(",", ".");
            if(validateAllCampos(text)){
                Temperatura temperaturaPrincipal = (Temperatura) comboBoxTemperatura.getSelectedItem();
                Objects.requireNonNull(temperaturaPrincipal).setTemperatura(Double.parseDouble(text));
                double valor2, valor3;

                if(temperaturaPrincipal instanceof Celsius){
                    valor2 = ((Celsius) temperaturaPrincipal).celsiusToKelvin();
                    valor3 = ((Celsius) temperaturaPrincipal).celsiusToFahrenheit();
                }else if(temperaturaPrincipal instanceof Kelvin){
                    valor2 = ((Kelvin) temperaturaPrincipal).kelvinToCelsius();
                    valor3 = ((Kelvin) temperaturaPrincipal).KelvinToFahrenheit();
                }else{
                    valor2 = ((Fahrenheit) temperaturaPrincipal).fahrenheitTocelsius();
                    valor3 = ((Fahrenheit) temperaturaPrincipal).fahrenheitToKelvin();
                }

                DecimalFormat df = new DecimalFormat("#.00");
                textFieldTemper2.setText(String.valueOf(df.format(valor2)));
                textFieldTemper3.setText(String.valueOf(df.format(valor3)));
            }
        });

        this.setResizable(false);
        setVisible(true);
    }

    private void iniciarComponentes(){
        textFieldTemper1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Utilidades.COLOR_BLUE));
        textFieldTemper2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Utilidades.COLOR_BLUE));
        textFieldTemper3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Utilidades.COLOR_BLUE));
        Utilidades.setImageLabel(JLabeIconoTitle, new ImageIcon("resources/temperaturas.png"),30);
        JLabelTitle.setText("Convertidor Temperatura");
        JLabelInfo.setFocusable(true);
        btnConvertir.setFont(Utilidades.PRIMARY_SEGOE);
        comboBoxTemperatura.setFont(Utilidades.SECOND_SEGOE);
        fillComboBoxTemperatura();
    }
    //De acuerdo al elemento seleccionado del ComboBox
    //Se asignan los iconos a los Jlabel
    private void setIconosJlabels(){
        Temperatura temperatura = (Temperatura)comboBoxTemperatura.getSelectedItem();
        if(temperatura != null) {
            Utilidades.setImageLabel(JLabeIconoTemper1, temperatura.getIcon(),30);
            ArrayList<Temperatura> tempTemperaturas = new ArrayList<>();
            for (int i = 0; i < comboBoxTemperatura.getItemCount(); i++) {
                if (!comboBoxTemperatura.getItemAt(i).equals(temperatura)) {
                    tempTemperaturas.add(comboBoxTemperatura.getItemAt(i));
                }
            }

            if (tempTemperaturas.size() >= 2) {
                Utilidades.setImageLabel(JLabeIconoTemper2, tempTemperaturas.get(0).getIcon(),30);
                Utilidades.setImageLabel(JLabeIconoTemper3, tempTemperaturas.get(1).getIcon(),30);
            }
        }
    }

    private boolean validateAllCampos(String text){
        if (!validateText(text)){
            Utilidades.setTextoAjustado(JLabelInfo,"¡Temperatura Invalida!",Color.red);
            return false;
        } else if (!validateComboBox()) {
            Utilidades.setTextoAjustado(JLabelInfo,"¡Seleccione la Temperatura principal!",Color.red);
            return false;
        }

        Utilidades.setTextoAjustado(JLabelInfo,"Valor Temperatura: ",Utilidades.COLOR_GREY);
        return true;
    }

    private boolean validateText(String text){
        try{
            Double.parseDouble(text);
            return true;
        }catch (NumberFormatException | NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean validateComboBox(){
        Temperatura temperatura = (Temperatura) comboBoxTemperatura.getSelectedItem();
        return (temperatura != null);
    }

    public void fillComboBoxTemperatura(){
        Utilidades.TEMPERATURAS.forEach(comboBoxTemperatura::addItem);
        comboBoxTemperatura.setSelectedIndex(-1);
    }
}
