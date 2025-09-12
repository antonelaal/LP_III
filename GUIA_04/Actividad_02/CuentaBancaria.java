package Actividad_02;

public class CuentaBancaria {
	private int NumeroCuenta;
	private String Titular;
	private double Saldo;
	
	public CuentaBancaria(int NumeroCuenta, String Titular, double Saldo) {
		this.NumeroCuenta=NumeroCuenta;
		this.Titular=Titular;
		this.Saldo=Saldo;
	}
	
	public static class SaldoInsuficienteException extends Exception {
		public SaldoInsuficienteException (String message) {
			super (message);
		}
	}
	
	public static class CuentaNoEncontradaException extends Exception {
		public CuentaNoEncontradaException (String message) {
			super (message);
		}
	}
	
	public static class SaldoNoCeroException extends Exception {
		public SaldoNoCeroException (String message) {
			super (message);
		}
	}
	
	
	public int getNumeroCuenta() {
		return this.NumeroCuenta;
	}
	
	public void setNumeroCuenta(int NumeroCuenta){		
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
	
	public void cerrarCuenta(double saldo)throws SaldoNoCeroException{
		if(saldo ==0) {
			System.out.println("Se cero su cuenta con éxito");
		}else {
			throw new SaldoNoCeroException("El saldo de la cuenta no es igual a cero");
		}
	}
	public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException {
		if (destino == null) {
			throw new CuentaNoEncontradaException("La cuenta destino no existe.");
		}
		 
		if(monto>getSaldo()) {
			throw new SaldoInsuficienteException("El saldo no es suficiente para el retiro");
		}
	
		this.retirar(monto);
		destino.depositar(monto);
	 
		System.out.println("Transferencia exitosa. Se han transferido " + monto + " a la cuenta " + destino.getNumeroCuenta());
	}

}
