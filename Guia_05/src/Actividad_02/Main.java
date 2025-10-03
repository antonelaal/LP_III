package Actividad_02;

public class Main {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>();
        
        pila.push("Java");
        pila.push("Python");
        pila.push("C++");
        
        System.out.println(pila.contains("Python")); 
        System.out.println(pila.contains("JavaScript")); 
        System.out.println(pila.contains("Java")); 
        
        // La pila mantiene su estado original
        System.out.println(pila.pop()); 
        System.out.println(pila.pop()); 
    }
}