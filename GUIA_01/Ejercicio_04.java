
package guia_01;

import java.util.Scanner;

public class Ejercicio_04 {
    
    public static double encontrarMenor(double a, double b, double c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese tres números decimales:");
        
        System.out.print("Primer número: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Segundo número: ");
        double num2 = scanner.nextDouble();
        
        System.out.print("Tercer número: ");
        double num3 = scanner.nextDouble();
        
        double menor = encontrarMenor(num1, num2, num3);
        System.out.println("El menor de los tres números es: " + menor);
        
        scanner.close();
    }
}