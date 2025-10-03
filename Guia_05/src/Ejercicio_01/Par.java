package Ejercicio_01;

public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par() {
    }

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }
    public S getSegundo() {
        return segundo;
    }
    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
}
