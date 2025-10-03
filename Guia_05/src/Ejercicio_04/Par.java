package Ejercicio_04;

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

    public boolean esIgual(Par<F, S> otroPar) {
        if (this == otroPar) {
            return true;
        }
        
        if (otroPar == null) {
            return false;
        }
        
        boolean primerosIguales;
        if (this.primero == null) {
            primerosIguales = (otroPar.primero == null);
        } else {
            primerosIguales = this.primero.equals(otroPar.primero);
        }
        
        boolean segundosIguales;
        if (this.segundo == null) {
            segundosIguales = (otroPar.segundo == null);
        } else {
            segundosIguales = this.segundo.equals(otroPar.segundo);
        }
        
        return primerosIguales && segundosIguales;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
}

