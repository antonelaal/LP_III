package Actividad_03;

public class CuentaCredito extends CuentaBancaria {
    private int limiteCredito;

    public CuentaCredito(int NumeroCuenta, String Titular, double Saldo, int limiteCredito) {
        super(NumeroCuenta, Titular, Saldo);
        this.limiteCredito = limiteCredito;
    }

    public int getLimiteCredito() {
        return this.limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public static class LimiteCreditoExcedidoException extends SaldoInsuficienteException {
        public LimiteCreditoExcedidoException(String message) {
            super(message);
        }
    }


    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        double saldoDisponible = this.getSaldo() + limiteCredito;

        if (monto < 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (monto > saldoDisponible) {
            throw new LimiteCreditoExcedidoException(
                "Se excedió el límite de crédito. Saldo disponible con crédito: " + saldoDisponible
            );
        }

        this.setSaldo(this.getSaldo() - monto);
    }

    @Override
    public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException, LimiteCreditoExcedidoException {

        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe.");
        }

        double saldoDisponible = this.getSaldo() + limiteCredito;
        if (monto > saldoDisponible) {
            throw new LimiteCreditoExcedidoException(
                "La transferencia excede el límite de crédito. Saldo disponible con crédito: " + saldoDisponible
            );
        }

        this.setSaldo(this.getSaldo() - monto);
        destino.depositar(monto);

        System.out.println("Transferencia exitosa de " + monto + " a la cuenta " + destino.getNumeroCuenta());
    }
}

