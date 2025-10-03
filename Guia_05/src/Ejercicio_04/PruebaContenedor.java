package Ejercicio_04;
import java.util.ArrayList;
import java.util.List;

public class PruebaContenedor {
    public static void main(String[] args) {
        System.out.println("1. Contenedor String-Integer:");
        Contenedor<String, Integer> contenedorEdades = new Contenedor<>();
        
        contenedorEdades.agregarPar("Gustavo", 25);
        contenedorEdades.agregarPar("Antonela", 20);
        contenedorEdades.agregarPar("Carlos", 32);
        
        contenedorEdades.mostrarPares();
        
        System.out.println("\nPar en posición 1: " + contenedorEdades.obtenerPar(1));
        
        System.out.println("\nTodos los pares:");
        for (Par<String, Integer> par : contenedorEdades.obtenerTodosLosPares()) {
            System.out.println("  - " + par);
        }

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("2. CONTENEDOR Double-Boolean:");
        Contenedor<Double, Boolean> contenedorEstados = new Contenedor<>();
        
        contenedorEstados.agregarPar(3.14, true);
        contenedorEstados.agregarPar(2.71, false);
        contenedorEstados.agregarPar(1.61, true);
        
        contenedorEstados.mostrarPares();

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("3. Contenedor Persona-Integer:");
        Contenedor<Persona, Integer> contenedorPersonas = new Contenedor<>();
        
        contenedorPersonas.agregarPar(new Persona("Ana", 28), 1001);
        contenedorPersonas.agregarPar(new Persona("Luis", 35), 1002);
        contenedorPersonas.agregarPar(new Persona("Elena", 29), 1003);
        
        contenedorPersonas.mostrarPares();

        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("Tamaño del contenedor de edades: " + contenedorEdades.tamaño());
        System.out.println("¿Está vacío el contenedor de estados? " + contenedorEstados.estaVacio());
        // Buscar por primer elemento
        System.out.println("\nBúsqueda de 'Juan' en contenedor de edades:");
        List<Par<String, Integer>> resultadoBusqueda = contenedorEdades.buscarPorPrimero("Juan");
        for (Par<String, Integer> par : resultadoBusqueda) {
            System.out.println("  - " + par);
        }
        
        System.out.println("\nEliminando par en posición 0 del contenedor de edades:");
        Par<String, Integer> parEliminado = contenedorEdades.eliminarPar(0);
        System.out.println("Par eliminado: " + parEliminado);
        contenedorEdades.mostrarPares();
    }
}

class Persona {
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
    
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
}

