package guia_02;

public class Cuenta {
    private int numero;
    private double saldo;

    public Cuenta(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public Cuenta(int numero){
        this(numero, 0);
    }

    // setter y getter

    public String toString(){
        // complete con la informacion requerida
        return "";
    }
}