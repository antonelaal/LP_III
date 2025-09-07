package guia_01;

import java.util.Scanner;

public class Ejercicio_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = new int[10];
        
        System.out.println("Ingrese 10 números en orden creciente:");
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                System.out.print("Número " + (i + 1) + ": ");
                arreglo[i] = scanner.nextInt();
            } else {
                int numero;
                do {
                    System.out.print("Número " + (i + 1) +  ": ");
                    numero = scanner.nextInt();
                } while (numero <= arreglo[i - 1]);
                arreglo[i] = numero;
            }
        }
        
        System.out.println("Arreglo final:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}