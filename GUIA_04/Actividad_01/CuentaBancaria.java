package Actividad_01;

public class CuentaBancaria {
	private int NumeroCuenta;
	private String Titular;
	private double Saldo;
	
	public CuentaBancaria(int NumeroCuenta, String Titular, double Saldo) {
		this.NumeroCuenta=NumeroCuenta;
		this.Titular=Titular;
		this.Saldo=Saldo;
	}
	
	public int getNumeroCuenta() {
		return this.NumeroCuenta;
	}
	
	public void setNumeroCuenta(int NumeroCuenta) {
		this.NumeroCuenta = NumeroCuenta;
	}
	public String getTitular() {
		return this.Titular;
	}
	public double getSaldo() {
		return this.Saldo;
	}
	public void setSaldo(double saldo) {
		this.Saldo = saldo;
	}
	public void crearCuenta(double NumeroCuenta) {
		if (NumeroCuenta < 0) {
			throw new IllegalArgumentException("Numero de cuenta negativo, no es válido");
		}
	}
	public void depositar(double monto) {
		if (monto < 0) {
			throw new IllegalArgumentException("El monto debe ser positivo.");
		}
		this.Saldo += monto;
	}
	public void retirar(double monto) throws SaldoInsuficienteException {
		if (monto < 0) {
			throw new IllegalArgumentException("El monto debe ser positivo.");
		}
		if (monto > this.Saldo) {
			throw new SaldoInsuficienteException("El saldo es insuficiente. Saldo: " + this.Saldo);
		}
		this.Saldo -= monto;
	}
	
	public static class SaldoInsuficienteException extends Exception {
		public SaldoInsuficienteException (String message) {
			super (message);
		}
	}

}
