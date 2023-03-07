package Gio_Challenge.Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton JButtonMoney;
    private JButton JButtonTemperature;
    private JButton JButtonMeasures;
    private JPanel MainPanel;
    private JLabel JLabelInfo;
    private JButton pruebaButton;

    public MainMenu(){
        this.setLocationRelativeTo(null);
        JButtonMoney.setIcon(new ImageIcon("E:\\ALURA_ORACLE\\Challenge_Alura\\convertidor_monedas\\convertidor_moneda\\src\\main\\java\\Gio_Challenge\\Vista\\exchange_1.png"));
        JButtonMeasures.setIcon(new ImageIcon("E:\\ALURA_ORACLE\\Challenge_Alura\\convertidor_monedas\\convertidor_moneda\\src\\main\\java\\Gio_Challenge\\Vista\\measuring-tapes.png"));
        JButtonTemperature.setIcon(new ImageIcon("E:\\ALURA_ORACLE\\Challenge_Alura\\convertidor_monedas\\convertidor_moneda\\src\\main\\java\\Gio_Challenge\\Vista\\thermometerss.png"));
        setTitle("Conversor Multiple");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(550, 474));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButtonMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ConvertidorMonedas convertidorMonedas = new ConvertidorMonedas(MainMenu.this);
            }
        });

        pruebaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmabia();
            }
        });
    }

    private void cmabia() {
        JLabelInfo.setText("Funciona el boton monedas");
        System.out.println("se presiono el boton");
    }

    private void setIcono() {

    }

}