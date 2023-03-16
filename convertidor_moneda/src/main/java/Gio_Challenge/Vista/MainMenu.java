package Gio_Challenge.Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class MainMenu extends JFrame{
    private JButton JButtonMoney;
    private JButton JButtonTemperature;
    private JButton JButtonMeasures;
    private JPanel MainPanel;
    private JLabel JLabelFooter;
    private JLabel JLabelGitHub;
    private JLabel JLabeLinkedin;
    private JLabel JLabelTitulo;


    public MainMenu(){
        this.setLocationRelativeTo(null);
        setIconos();
        setTitle("Conversor Múltiple");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(550, 474));
        setLocationRelativeTo(this);
        JLabelTitulo.setText("CONVERTIDOR MÚLTIPLE");
        JLabelFooter.setText("<html> Copyright © 2023 | Coded with <font color='blue'>❤</font> by <font color='blue'>Giovanni Scarpetta</font></html>");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButtonMoney.addActionListener(e -> {
           ConvertidorMonedas convertidorMonedas = new ConvertidorMonedas(MainMenu.this);
        });
        JButtonTemperature.addActionListener(e -> {
            ConvertidorTemperaturas convertidorTemperaturas = new ConvertidorTemperaturas(MainMenu.this);
        });
        JButtonMeasures.addActionListener(e -> {
            ConvertidorMedidas convertidorMedidas = new ConvertidorMedidas(MainMenu.this);
        });
        JLabeLinkedin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirPageWeb("https://www.linkedin.com/in/giovanni-scarpetta/");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                Utilidades.setImageLabel(JLabeLinkedin,new ImageIcon("resources/icon-linkedin.png"),30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Utilidades.setImageLabel(JLabeLinkedin,new ImageIcon("resources/icon-linkedin.png"),25);
            }
        });
        JLabelGitHub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirPageWeb("https://github.com/GioScarp");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                Utilidades.setImageLabel(JLabelGitHub,new ImageIcon("resources/icon-gh.png"),30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Utilidades.setImageLabel(JLabelGitHub,new ImageIcon("resources/icon-gh.png"),25);
            }
        });
    }

    private void setIconos(){
        Image icon = Toolkit.getDefaultToolkit().getImage("resources/Logo.png");
        this.setIconImage(icon);
        JButtonMoney.setIcon(new ImageIcon("resources/exchange_1.png"));
        JButtonMeasures.setIcon(new ImageIcon("resources/measuring-tapes.png"));
        JButtonTemperature.setIcon(new ImageIcon("resources/thermometerss.png"));
        JButtonMoney.setRolloverIcon(new ImageIcon("resources/exchange_2.png"));
        JButtonMeasures.setRolloverIcon(new ImageIcon("resources/measuring-tapes_2.png"));
        JButtonTemperature.setRolloverIcon(new ImageIcon("resources/thermometerss_2.png"));
        Utilidades.setImageLabel(JLabeLinkedin,new ImageIcon("resources/icon-linkedin.png"),25);
        Utilidades.setImageLabel(JLabelGitHub,new ImageIcon("resources/icon-gh.png"),25);
    }

    private void abrirPageWeb(String url){
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //Se establece el look and feel en Nimbus
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
        MainMenu convertidor = new MainMenu();
    }
}