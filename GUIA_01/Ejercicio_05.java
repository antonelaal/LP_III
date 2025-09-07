package guia_01;

import java.util.Scanner;

public class Ejercicio_05 {
    public static double calcularCargo(double horas) {
        if (horas <= 0) return 0;
        
        double cargo = 3.00;
        if (horas > 1) {
            cargo += Math.ceil(horas - 1) * 0.50;
        }
        
        return Math.min(cargo, 12.00);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese número de horas: ");
        double horas = scanner.nextDouble();
        System.out.println("Cargo: S/" + calcularCargo(horas));
    }
}