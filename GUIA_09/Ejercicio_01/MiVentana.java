package Ejercicio_01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MiVentana extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtPassword;
    private JTextField txtUsuario;
    private JCheckBox chkRecordar;
    private final Action action = new SwingAction();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MiVentana frame = new MiVentana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MiVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        contentPane.setLayout(new java.awt.GridLayout(4, 2, 10, 10));
        
        JLabel lblNewLabel = new JLabel("Usuario");
        contentPane.add(lblNewLabel);
        
        txtUsuario = new JTextField();
        contentPane.add(txtUsuario);
        
        JLabel lblPassword = new JLabel("Contraseña:");
        contentPane.add(lblPassword);
        
        txtPassword = new JTextField();
        contentPane.add(txtPassword);
        

        contentPane.add(new JLabel(""));
        
        chkRecordar = new JCheckBox("Recordarme");
        contentPane.add(chkRecordar);
        
        contentPane.add(new JLabel(""));
        
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = txtPassword.getText();
                boolean recordar = chkRecordar.isSelected();
                
                JOptionPane.showMessageDialog(null, 
                    "Usuario: " + usuario + 
                    "\nRecordar: " + recordar);
            }
        });
        contentPane.add(btnIngresar);
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "SwingAction");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
        }
    }
}
