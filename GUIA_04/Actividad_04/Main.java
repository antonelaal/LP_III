package Actividad_04;

public class Main {
    public static void main(String[] args) {
        ReporteTransacciones cuenta1 = new ReporteTransacciones(1010, "Antonela", 1500.0);
        ReporteTransacciones cuenta2 = new ReporteTransacciones(2020, "Laura", 2000.0);

        System.out.println("PRUEBA 1: Reporte sin transacciones");
        try {
            cuenta1.generarReporte("reporte1.txt");
        } catch (ReporteTransacciones.HistorialVacioException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nPRUEBA 2: Reporte con transacciones");
        cuenta2.registrarTransaccion(500);
        try {
            cuenta2.generarReporte("reporte2.txt");
        } catch (ReporteTransacciones.HistorialVacioException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nPRUEBA 3: Leer reporte existente");
        cuenta2.leerReporte("reporte2.txt");

        System.out.println("\nPRUEBA 4: Leer archivo inexistente");
        cuenta1.leerReporte("archivo_inexistente.txt");
    }
}
