package Actividad_01;

public class Main {

	public static void main(String[] args) {
		CuentaBancaria c1 = new CuentaBancaria(123456, "Antonela Alviz", 1500.0);
		try {
			c1.retirar(1200);
			System.out.println("Retiro exitoso. Saldo restante: " + c1.getSaldo());
		} catch (CuentaBancaria.SaldoInsuficienteException e) {
			System.out.println("Error al intentar retirar dinero: " + e.getMessage());
		}
		
		try {
			c1.retirar(500);
			System.out.println("Retiro exitoso. Saldo restante: " + c1.getSaldo());
		} catch (CuentaBancaria.SaldoInsuficienteException e) {
			System.out.println("Error al intentar retirar dinero: " + e.getMessage());
		}
	}
}