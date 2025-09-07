package guia_02;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;

    public Persona(int id, String nombre, String apellido, int numero){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuenta = new Cuenta(numero);
    }

    // setter y getter

    public String toString(){
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + "\n" + cuenta.toString();
    }

}

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

    public void setSaldo(double saldo) { this.saldo = saldo; }
    public String toString(){
        return "Cuenta N°: " + numero + ", Saldo: " + saldo;
    }
}
