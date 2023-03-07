package Gio_Challenge.Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertidorMonedas extends JDialog{
    private JTextField textFieldImporte;
    private JComboBox comboBoxBase;
    private JComboBox comboBoxDestino;
    private JButton btnConvertir;
    private JLabel JLabelTitulo;
    private JLabel JLabelImporte;
    private JLabel JLabelResultado;
    private JPanel JPanelMoneda;
    private JLabel JLabelIconDestino;
    private JLabel JLabelIconBase;

    public ConvertidorMonedas(JFrame parent){
        super(parent,"Convertidor de Mondeas",true);
        textFieldImporte.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, textFieldImporte.getForeground()));
        setContentPane(JPanelMoneda);
        setMinimumSize(new Dimension(380, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabelResultado.setText("Funciona Dialog");
                System.out.println("Hola");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvertidorMonedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JFrame frame = new JFrame();
        ConvertidorMonedas convertidorMonedas = new ConvertidorMonedas(frame);
    }

}
