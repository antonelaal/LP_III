package Actividad_04;

public class Pila<E> {
    private final int tamanio;
    private int superior; 
    private E[] elementos; 

    public Pila() {
        this(10); 
    } 

    public Pila(int s) {
        tamanio = s > 0 ? s : 10; 
        superior = -1; 
        elementos = (E[]) new Object[tamanio]; 
    } 
    public void push(E valorAMeter) {
        if (superior == tamanio - 1) 
            throw new ExcepcionPilaLlena(String.format(
                "La Pila esta llena, no se puede meter %s", valorAMeter));
        elementos[++superior] = valorAMeter; 
    } 

    public E pop() {
        if (superior == -1) 
            throw new ExcepcionPilaVacia("Pila vacia, no se puede sacar");
        return elementos[superior--]; 
    } 

    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i] == null && elemento == null) {
                return true;
            } else if (elementos[i] != null && elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() { //para ver si la pila está vacía o no
        return superior == -1;
    }
    public E peek() { //solo para ver el último element de la pila sin sacarlo
        if (superior == -1) {
            throw new ExcepcionPilaVacia("Pila vacia, no se puede ver el tope");
        }
        return elementos[superior];
    }

    public int size() {
        return superior + 1;
    }
    
    public boolean esIgual(Pila<E> otraPila) {
        if (this == otraPila) {
            return true;
        }
        
        if (this.superior != otraPila.superior) {
            return false;
        }
        
        for (int i = 0; i <= superior; i++) {
            E elementoThis = this.elementos[i];
            E elementoOtra = otraPila.elementos[i];
            
            if (elementoThis == null) {
                if (elementoOtra != null) {
                    return false;
                }
            } else {
                if (!elementoThis.equals(elementoOtra)) {
                    return false;
                }
            }
        }
        
        return true;
    }
} 

class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String mensaje) {
        super(mensaje);
    }
}
 
