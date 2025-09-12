package Actividad_04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReporteTransacciones {
    private int numeroCuenta;
    private String titular;
    private double saldo;
    private boolean tieneTransacciones;

    public ReporteTransacciones(int numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tieneTransacciones = false;
    }

    public static class HistorialVacioException extends Exception {
        public HistorialVacioException(String mensaje) {
            super(mensaje);
        }
    }

    public void registrarTransaccion(double monto) {
        this.saldo += monto;
        this.tieneTransacciones = true;
    }

    public void generarReporte(String nombreArchivo) throws HistorialVacioException {
        if (!tieneTransacciones) {
            throw new HistorialVacioException("No se puede generar reporte: historial vacío.");
        }

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Número de Cuenta: " + numeroCuenta + "\n");
            writer.write("Titular: " + titular + "\n");
            writer.write("Saldo final: " + saldo + "\n");
            System.out.println("Reporte generado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void leerReporte(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try (Scanner scanner = new Scanner(archivo)) {
            System.out.println("--- Leyendo reporte ---");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + e.getMessage());
        }
    }
}
