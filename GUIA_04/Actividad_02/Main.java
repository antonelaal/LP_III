package Actividad_02;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria c1 = new CuentaBancaria(1001, "Antonela", 1500.0);
        CuentaBancaria c2 = new CuentaBancaria(1002, "Melani", 500.0);
        CuentaBancaria c3 = null;

        System.out.println("\n--- PRUEBAS DE TRANSFERENCIA ---");
        try {
            c1.transferir(c2, 300);
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        try {
            c1.transferir(c3, 100);
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        try {
            c2.transferir(c1, 2000);
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        System.out.println("Saldo C1: " + c1.getSaldo());
        System.out.println("Saldo C2: " + c2.getSaldo());

        System.out.println("\n--- PRUEBAS DE CIERRE DE CUENTAS ---");
        try {
            c2.cerrarCuenta(c2.getSaldo());
        } catch (CuentaBancaria.SaldoNoCeroException e) {
            System.out.println("Error al cerrar cuenta C2: " + e.getMessage());
        }

        try {
            c2.retirar(c2.getSaldo());
            c2.cerrarCuenta(c2.getSaldo());
        } catch (Exception e) {
            System.out.println("Error al cerrar cuenta C2: " + e.getMessage());
        }
    }
}
