package guia_01;

import java.util.Scanner;

public class Actividad_03 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int n = scanner.nextInt();
		imprimirNumerosPerfectos(n);
	}
	// Función para verificar si un número es perfecto
	public static boolean esPerfecto(int num) {
		int sumaDivisores = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sumaDivisores += i;
			}
		}
		return sumaDivisores == num;
	}
	// Función para encontrar y mostrar todos los números perfectosmenores a un número dado n
	public static void imprimirNumerosPerfectos(int n) {
		for (int num = 1; num < n; num++) {
			if (esPerfecto(num)) {
				System.out.println(num + " es un número perfecto.");
			}
		}
	}
}