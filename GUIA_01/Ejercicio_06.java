package guia_01;

import java.util.Scanner;

public class Ejercicio_06 {
    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Horas: ");
        int horas = scanner.nextInt();
        
        System.out.print("Minutos: ");
        int minutos = scanner.nextInt();
        
        System.out.print("Segundos: ");
        int segundos = scanner.nextInt();
        
        int totalSegundos = convertirASegundos(horas, minutos, segundos);
        System.out.println("Total en segundos: " + totalSegundos);
    }
}