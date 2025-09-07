package guia_01;

import java.util.Random;

public class Ejercicio_03 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] frecuencia = new int[6];
        
        for (int i = 0; i < 20000; i++) {
            int resultado = random.nextInt(6) + 1;
            frecuencia[resultado - 1]++;
        }
        
        System.out.println("Frecuencia de caras:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i] + " veces");
        }
    }
}

