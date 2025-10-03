package Ejercicio_03;

public class Main {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println("Par: " + par);
    }
    
    static class Persona {
        private String nombre;
        private int edad;
        
        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
        
        @Override
        public String toString() {
            return nombre + " (" + edad + " años)";
        }
    }
    
    public static void main(String[] args) {
        Par<String, Integer> parStringInt = new Par<>("Edad", 25);
        System.out.print("String, Integer: ");
        imprimirPar(parStringInt);
        
        Par<Double, Boolean> parDoubleBoolean = new Par<>(3.1416, true);
        System.out.print("Double, Boolean: ");
        imprimirPar(parDoubleBoolean);
        
        Persona persona = new Persona("Antonela", 20);
        Par<Persona, Integer> parPersonaInt = new Par<>(persona, 1001);
        System.out.print("Persona, Integer: ");
        imprimirPar(parPersonaInt);
        
        Par<String, String> parStringString = new Par<>("Hola", "Mundo");
        System.out.print("String, String: ");
        imprimirPar(parStringString);
        
        Par<Integer, Double> parIntDouble = new Par<>(42, 99.9);
        System.out.print("Integer, Double: ");
        imprimirPar(parIntDouble);
        
        Par<Boolean, Character> parBooleanChar = new Par<>(false, 'A');
        System.out.print("Boolean, Character: ");
        imprimirPar(parBooleanChar);
        
        Par<String, Integer> parConNull = new Par<>(null, 100);
        System.out.print("Con null: ");
        imprimirPar(parConNull);
    }
}
