package Actividad_04;

public class pruebaPila {
    public static void main(String[] args) {
        Pila<String> pila1 = new Pila<>();
        Pila<String> pila2 = new Pila<>();
        Pila<String> pila3 = new Pila<>();
        
        pila1.push("primero");
        pila1.push("segundo");
        pila1.push("tercero");
        
        pila2.push("primero");
        pila2.push("segundo");
        pila2.push("tercero");
        
        pila3.push("primero");
        pila3.push("segundo");
        pila3.push("diferente");
        
        System.out.println("¿pila1 es igual a pila2? " + pila1.esIgual(pila2)); 
        System.out.println("¿pila1 es igual a pila3? " + pila1.esIgual(pila3)); 
        System.out.println("¿pila1 es igual a sí misma? " + pila1.esIgual(pila1)); 
        
        System.out.println("Tope de pila1: " + pila1.peek()); 
        System.out.println("Tamaño de pila1: " + pila1.size()); 
        
        System.out.println("¿pila1 contiene 'segundo'? " + pila1.contains("segundo")); 
        System.out.println("¿pila1 contiene 'cuarto'? " + pila1.contains("cuarto")); 
    }
}
