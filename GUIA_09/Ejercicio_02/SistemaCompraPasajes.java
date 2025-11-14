package Ejercicio_02;

import javax.swing.*;
import java.awt.*;

public class SistemaCompraPasajes extends JFrame {
    private JTextField txtNombres, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaCalidad;
    private JButton btnComprar, btnLimpiar;
    
    private String[] ciudades = {"Lima", "Arequipa", "Trujillo", "Cusco", "Piura", "Chiclayo"};
    private String[] calidades = {"Económico", "Standard", "VIP"};

    public SistemaCompraPasajes() {
        super("Compra de Pasajes");
        configurarInterfaz();
        configurarEventos();
    }

    private void configurarInterfaz() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(crearTitulo("Datos Personales"), gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("Nombres:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        txtNombres = new JTextField(20);
        add(txtNombres, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Documento:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        txtDocumento = new JTextField(15);
        add(txtDocumento, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Fecha:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        txtFecha = new JTextField(10);
        add(txtFecha, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(crearTitulo("Servicios Opcionales"), gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        JPanel panelServicios = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);
        add(panelServicios, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        add(crearTitulo("Preferencia de Piso"), gbc);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        JPanel panelPiso = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        ButtonGroup grupoPiso = new ButtonGroup();
        rbPrimerPiso = new JRadioButton("1er Piso", true);
        rbSegundoPiso = new JRadioButton("2do Piso");
        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        add(panelPiso, gbc);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        add(crearTitulo("Ruta de Viaje"), gbc);

        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 1;
        add(new JLabel("Origen:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 9;
        cbOrigen = new JComboBox<>(ciudades);
        add(cbOrigen, gbc);

        gbc.gridx = 0; gbc.gridy = 10;
        add(new JLabel("Destino:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 10;
        cbDestino = new JComboBox<>(ciudades);
        cbDestino.setSelectedIndex(1);
        add(cbDestino, gbc);

        gbc.gridx = 0; gbc.gridy = 11; gbc.gridwidth = 2;
        add(crearTitulo("Calidad de Servicio"), gbc);

        gbc.gridx = 0; gbc.gridy = 12; gbc.gridwidth = 2;
        listaCalidad = new JList<>(calidades);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCalidad.setSelectedIndex(1);
        JScrollPane scrollCalidad = new JScrollPane(listaCalidad);
        scrollCalidad.setPreferredSize(new Dimension(200, 50));
        add(scrollCalidad, gbc);

        gbc.gridx = 0; gbc.gridy = 13; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnComprar = new JButton("Comprar");
        btnLimpiar = new JButton("Limpiar");
        
        panelBotones.add(btnComprar);
        panelBotones.add(btnLimpiar);
        add(panelBotones, gbc);

        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JLabel crearTitulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        return label;
    }

    private void configurarEventos() {
        btnComprar.addActionListener(e -> {
            if (validarDatos()) mostrarResumen();
        });

        btnLimpiar.addActionListener(e -> limpiarFormulario());
    }

    private boolean validarDatos() {
        if (txtNombres.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese sus nombres");
            return false;
        }
        if (txtDocumento.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese su documento");
            return false;
        }
        if (txtFecha.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la fecha");
            return false;
        }
        if (cbOrigen.getSelectedItem().equals(cbDestino.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Origen y destino deben ser diferentes");
            return false;
        }
        return true;
    }

    private void mostrarResumen() {
        String nombres = txtNombres.getText();
        String documento = txtDocumento.getText();
        String fecha = txtFecha.getText();
        String origen = cbOrigen.getSelectedItem().toString();
        String destino = cbDestino.getSelectedItem().toString();
        String piso = rbPrimerPiso.isSelected() ? "1er Piso" : "2do Piso";
        String calidad = listaCalidad.getSelectedValue();
        
        StringBuilder servicios = new StringBuilder();
        int costoExtra = 0;
        if (chkAudifonos.isSelected()) { servicios.append("Audífonos\n"); costoExtra += 5; }
        if (chkManta.isSelected()) { servicios.append("Manta\n"); costoExtra += 8; }
        if (chkRevistas.isSelected()) { servicios.append("Revistas\n"); costoExtra += 3; }
        
        int precioBase = calidad.equals("Económico") ? 40 : 
                        calidad.equals("Standard") ? 60 : 90;
        int total = precioBase + costoExtra;

        String resumen = "RESUMEN DE COMPRA\n\n" +
                        "Datos:\n" + nombres + " - " + documento + "\n" +
                        "Fecha: " + fecha + "\n\n" +
                        "Viaje:\n" + origen + " a " + destino + "\n" +
                        piso + " - " + calidad + "\n\n" +
                        "Servicios:\n" + (servicios.length() > 0 ? servicios : "Ninguno") +
                        "\nTotal: S/" + total;

        JOptionPane.showMessageDialog(this, resumen);
    }

    private void limpiarFormulario() {
        txtNombres.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        rbPrimerPiso.setSelected(true);
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(1);
        listaCalidad.setSelectedIndex(1);
    }

    public static void main(String[] args) {
        new SistemaCompraPasajes().setVisible(true);
    }
}