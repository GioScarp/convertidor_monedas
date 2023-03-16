package Gio_Challenge.Vista;

import Gio_Challenge.Controladores.ControladorMoneda.MonedaBase;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class ConvertidorMonedas extends JDialog{
    private JTextField textFieldValor;
    private JComboBox<MonedaBase> comboBoxBase;
    private JComboBox<MonedaBase> comboBoxDestino;
    private JButton btnConvertir;
    private JLabel JLabelTitulo;
    private JLabel JLabelInfo;
    private JLabel JLabelResultado;
    private JPanel JPanelMoneda;
    private JLabel JLabelIconDestino;
    private JLabel JLabelIconBase;
    private JLabel JLabelnvertir;
    private JLabel JLabeltitleIcono;

    public ConvertidorMonedas(JFrame parent){
        super(parent,"Convertidor de Monedas",true);
        iniciarComponentes();
        setContentPane(JPanelMoneda);
        setMinimumSize(new Dimension(450, 530));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Se agrega DocumentListener para usar el evento insertUpdate
        // Esto detectará cuando se inserta nuevo contenido en el campo de texto
        textFieldValor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textFieldValor.setForeground(Utilidades.COLOR_BLUE); // Cambiar el color del texto al insertar
            }
            @Override
            public void removeUpdate(DocumentEvent e) {}
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        //FocusListener para usar los eventos focusGained y FocusLost
        //focusGained detecta cuando el campo de texto gana el foco
        //focusLost detecta cuando el campo de texto pierde el foco
        textFieldValor.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                Utilidades.cleanTextFields(textFieldValor);
            }
            @Override
            public void focusLost(FocusEvent e) {
                Utilidades.setTextIfEmpty(textFieldValor);

                String text = textFieldValor.getText().replace(",", ".");
                if(validateJTextField(text))
                    Utilidades.setTextoAjustado(JLabelInfo, "Valor Moneda: ", Utilidades.COLOR_GREY);
                else Utilidades.setTextoAjustado(JLabelInfo, "¡Número invalido!", Color.red);
            }
        });

        //MouseListener para usar el evento mouseClicked
        //Esto, detectará cuando se haga click en el Jlabel e invertirá los indices de los JComboBoxes
        JLabelnvertir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if((comboBoxBase.getSelectedIndex() & comboBoxDestino.getSelectedIndex()) !=-1){
                    int indexComboBase = comboBoxBase.getSelectedIndex();
                    comboBoxBase.setSelectedIndex(comboBoxDestino.getSelectedIndex());
                    comboBoxDestino.setSelectedIndex(indexComboBase);
                }
            }
        });

        //ActionListener para detectar la moneda seleccionada de los JComboBoxes
        //y colocar el icono en el Jlabel
        comboBoxBase.addActionListener(e -> {
            MonedaBase monedaBase = (MonedaBase)comboBoxBase.getSelectedItem();
            if(monedaBase != null)
                Utilidades.setImageLabel(JLabelIconBase, monedaBase.getIcono(),30);
        });
        comboBoxDestino.addActionListener(e -> {
            MonedaBase monedaDestino = (MonedaBase)comboBoxDestino.getSelectedItem();
            if(monedaDestino != null)
                Utilidades.setImageLabel(JLabelIconDestino, monedaDestino.getIcono(),30);
        });

        //ActionListener para hacer la conversion de la moneda
        btnConvertir.addActionListener(e -> {
            String text = textFieldValor.getText().replace(",", ".");
            if (validateAllCampos(text)) {
                MonedaBase monedaBase = (MonedaBase) comboBoxBase.getSelectedItem();
                MonedaBase monedaDestino = (MonedaBase) comboBoxDestino.getSelectedItem();
                try {
                    double valor = Double.parseDouble(text);
                    double conversionMoneda = Objects.requireNonNull(monedaBase).convertirToDestino(valor, Objects.requireNonNull(monedaDestino).getSimbolo());
                    DecimalFormat df = new DecimalFormat("#,###.00");
                    String resultado = text + " " + monedaBase.getSimbolo() + " = " + df.format(conversionMoneda) + " " + monedaDestino.getSimbolo();
                    Utilidades.setTextoAjustado(JLabelResultado, resultado, Utilidades.COLOR_BLUE);
                } catch(IOException | NullPointerException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Upps, error interno, intente mas tarde .",
                            "Error al convertir", JOptionPane.ERROR_MESSAGE);
                }
             }
        });

        this.setResizable(false);
        setVisible(true);
    }

    private void iniciarComponentes(){
        textFieldValor.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Utilidades.COLOR_BLUE));
        Utilidades.setImageLabel(JLabeltitleIcono, new ImageIcon("resources/moneda.png"),30);
        Utilidades.setImageLabel(JLabelnvertir, new ImageIcon("resources/invertir.png"),30);
        JLabelTitulo.setText("Convertidor Monedas");
        fillComboBox();
        JLabelInfo.setFocusable(true);
        comboBoxBase.setFont(Utilidades.SECOND_SEGOE);
        comboBoxDestino.setFont(Utilidades.SECOND_SEGOE);
        btnConvertir.setFont(Utilidades.PRIMARY_SEGOE);
    }
    //llenar los JComboBoxes con las Monedas predefinidas
    private void fillComboBox(){
        Utilidades.MONEDAS.forEach(moneda -> {
            comboBoxBase.addItem(moneda);
            comboBoxDestino.addItem(moneda);
        });
        comboBoxBase.setSelectedIndex(-1);
        comboBoxDestino.setSelectedIndex(-1);
    }

    private boolean validateAllCampos(String text){
        if (!validateJTextField(text)){
            Utilidades.setTextoAjustado(JLabelInfo, "¡Número invalido!", Color.red);
            return false;
        } else if (!validateComboBox()) {
            Utilidades.setTextoAjustado(JLabelInfo, "¡Seleccione las monedas correspondientes!", Color.red);
            return false;
        }

        Utilidades.setTextoAjustado(JLabelInfo, "Valor Moneda: ", Utilidades.COLOR_GREY);
        return true;
    }

    private boolean validateJTextField(String text) {
        try{
            return Double.parseDouble(text) > 0;
        }catch (NumberFormatException | NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
    private boolean validateComboBox(){
        MonedaBase monedaBase = (MonedaBase)comboBoxBase.getSelectedItem();
        MonedaBase monedaDestino = (MonedaBase)comboBoxDestino.getSelectedItem();

        return monedaBase != null && monedaDestino != null;
    }

}
