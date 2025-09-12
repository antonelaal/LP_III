package Actividad_03;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaNormal = new CuentaBancaria(2001, "Antonela", 1000.0);
        CuentaCredito cuentaCredito = new CuentaCredito(3001, "Melani", 500.0, 1000);

        System.out.println("PRUEBAS CON CUENTA NORMAL");
        try {
            cuentaNormal.retirar(1200);
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente (cuenta normal): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nPRUEBAS CON CUENTA DE CRÉDITO");
        try {
            cuentaCredito.retirar(1200);
            System.out.println("Retiro exitoso. Saldo actual: " + cuentaCredito.getSaldo());
        } catch (CuentaCredito.LimiteCreditoExcedidoException e) {
            System.out.println("Error (límite de crédito): " + e.getMessage());
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente (cuenta crédito): " + e.getMessage());
        }

        try {
            cuentaCredito.retirar(2000);
            System.out.println("Retiro exitoso. Saldo actual: " + cuentaCredito.getSaldo());
        } catch (CuentaCredito.LimiteCreditoExcedidoException e) {
            System.out.println("Excepción capturada (límite de crédito): " + e.getMessage());
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente (cuenta crédito): " + e.getMessage());
        }

        System.out.println("\nPRUEBAS DE TRANSFERENCIAS");
        try {
            cuentaCredito.transferir(cuentaNormal, 800);
            System.out.println("Saldo cuenta crédito: " + cuentaCredito.getSaldo());
            System.out.println("Saldo cuenta normal: " + cuentaNormal.getSaldo());
        } catch (CuentaCredito.LimiteCreditoExcedidoException e) {
            System.out.println("Error (límite de crédito): " + e.getMessage());
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            System.out.println("Error (saldo insuficiente): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        try {
            cuentaCredito.transferir(cuentaNormal, 2000);
        } catch (CuentaCredito.LimiteCreditoExcedidoException e) {
            System.out.println("Excepción capturada en transferencia (límite crédito): " + e.getMessage());
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            System.out.println("Excepción capturada en transferencia (saldo insuficiente): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }
    }
}

