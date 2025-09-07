package guia_01;

import java.util.Scanner;

public class Ejercicio_01 {
    
    public static int sumarArreglo(int[] arr) {
        int suma = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
        }
        return suma;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();
        
        int[] arreglo = new int[n];
        
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }
        
        int resultado = sumarArreglo(arreglo);
        System.out.println("La suma de los elementos es: " + resultado);
        
        scanner.close();
    }
}