package Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGridLayout extends JFrame {
    private JButton[][] botones;
    private JLabel etiquetaEstado;
    private int filas = 3;
    private int columnas = 3;

    public VentanaGridLayout() {
        super("Ventana GridLayout - Tablero Interactivo");
        setLayout(new BorderLayout());

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(filas, columnas, 5, 5));
        
        botones = new JButton[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton(i + "," + j);
                final int fila = i;
                final int columna = j;
                
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String mensaje = "Presionado: Fila " + fila + ", Columna " + columna;
                        etiquetaEstado.setText(mensaje);
                        botones[fila][columna].setText("✓");
                        botones[fila][columna].setEnabled(false);
                        
                        JOptionPane.showMessageDialog(null, 
                            "Celda seleccionada: (" + fila + "," + columna + ")");
                    }
                });
                
                panelGrid.add(botones[i][j]);
            }
        }

        etiquetaEstado = new JLabel("Selecciona una celda", JLabel.CENTER);
        etiquetaEstado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(panelGrid, BorderLayout.CENTER);
        add(etiquetaEstado, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        VentanaGridLayout ventana = new VentanaGridLayout();
        ventana.setVisible(true);
    }
}