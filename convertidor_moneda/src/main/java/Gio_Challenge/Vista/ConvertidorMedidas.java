package Gio_Challenge.Vista;

import javax.swing.*;
import java.awt.*;

public class ConvertidorMedidas extends JDialog{
    private JPanel JPanelPrincipal;
    private JLabel JLabelmage;

    public ConvertidorMedidas(JFrame parent){
        super(parent,"Convertidor de Medidas", true);
        setContentPane(JPanelPrincipal);
        setMinimumSize(new Dimension(450, 500));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Utilidades.setImageLabel(JLabelmage,new ImageIcon("resources/contruccion.png"), 400);
        this.setResizable(false);
        setVisible(true);
    }
}
