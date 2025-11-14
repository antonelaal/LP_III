package Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFlowLayout extends JFrame {
    private JLabel etiqueta;
    private JTextField campoTexto;
    private JButton boton;
    private int contadorClicks = 0;

    public VentanaFlowLayout() {
        super("Ventana FlowLayout - Contador de Clicks");
        setLayout(new FlowLayout());

        etiqueta = new JLabel("Contador: 0 clicks");
        campoTexto = new JTextField(15);
        campoTexto.setText("Escribe algo aquí");
        boton = new JButton("Haz Click Aquí");

        etiqueta.setToolTipText("Muestra el número de clicks");
        campoTexto.setToolTipText("Campo de texto editable");
        boton.setToolTipText("Incrementa el contador");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorClicks++;
                etiqueta.setText("Contador: " + contadorClicks + " clicks");
                JOptionPane.showMessageDialog(null,"Texto ingresado: " + campoTexto.getText() + "\nClicks totales: " + contadorClicks);
            }
        });

        add(etiqueta);
        add(campoTexto);
        add(boton);

        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        VentanaFlowLayout ventana = new VentanaFlowLayout();
        ventana.setVisible(true);
    }
}