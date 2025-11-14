package Ejemplo;
import javax.swing.JOptionPane;

public class App {
public static void main(String[] args) throws Exception {
// obtiene la entrada del usuario de los diálogos de entrada de JOptionPane
String primerNumero = JOptionPane.showInputDialog("Introduzca el primer entero");
String segundoNumero = JOptionPane.showInputDialog("Introduzca el segundo entero");
// convierte las entradas String en valores int para usarlos en un cálculo
int numero1 = Integer.parseInt(primerNumero);
int numero2 = Integer.parseInt(segundoNumero);
int suma = numero1 + numero2;
// muestra los resultados en un diálogo de mensajes de JOptionPane
JOptionPane.showMessageDialog(null, "La suma es " + suma, "Suma de dos enteros", JOptionPane.PLAIN_MESSAGE);
}
}