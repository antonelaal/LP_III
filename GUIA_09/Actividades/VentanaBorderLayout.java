package Actividades;

import javax.swing.*;
import java.awt.*;

public class VentanaBorderLayout extends JFrame {
    private JTextArea areaTexto;

    public VentanaBorderLayout() {
        super("Ventana BorderLayout - Editor de Texto");
        setLayout(new BorderLayout());

        JButton botonLimpiar = new JButton("Limpiar Texto");
        JButton botonGuardar = new JButton("Guardar Texto");
        JButton botonInfo = new JButton("Información");
        
        areaTexto = new JTextArea(10, 30);
        areaTexto.setText("Escribe tu texto aquí...\nPuedes usar múltiples líneas.");
        
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        botonLimpiar.addActionListener(e -> {
            areaTexto.setText("");
            JOptionPane.showMessageDialog(null, "Texto limpiado");
        });

        botonGuardar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, 
                "Texto guardado:\n" + areaTexto.getText());
        });

        botonInfo.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                "Caracteres: " + areaTexto.getText().length() +
                "\nLíneas: " + areaTexto.getLineCount());
        });

        add(botonLimpiar, BorderLayout.NORTH);
        add(botonGuardar, BorderLayout.SOUTH);
        add(botonInfo, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        VentanaBorderLayout ventana = new VentanaBorderLayout();
        ventana.setVisible(true);
    }
}