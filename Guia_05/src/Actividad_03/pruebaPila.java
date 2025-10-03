package Actividad_03;

public class pruebaPila {
    public static void main(String[] args) {
        Pila<String> pilaStrings = new Pila<>();
        
        pilaStrings.push("Hola");
        pilaStrings.push("Mundo");
        pilaStrings.push("Java");
        
        System.out.println("¿Contiene 'Java'? " + pilaStrings.contains("Java")); 
        System.out.println("¿Contiene 'Python'? " + pilaStrings.contains("Python")); 
        System.out.println("¿Contiene 'Mundo'? " + pilaStrings.contains("Mundo")); 
        
        Pila<Integer> pilaEnteros = new Pila<>();
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        pilaEnteros.push(30);
        
        System.out.println("¿Contiene 20? " + pilaEnteros.contains(20)); 
        System.out.println("¿Contiene 40? " + pilaEnteros.contains(40)); 

        System.out.println("Elemento en el tope: " + pilaStrings.peek()); 
        System.out.println("Tamaño de la pila: " + pilaStrings.size()); 
    }
}
