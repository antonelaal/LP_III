package Ejercicio_04;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F, S> {
    private ArrayList<Par<F, S>> pares;

    public Contenedor() {
        this.pares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        pares.add(nuevoPar);
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice < 0 || indice >= pares.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return pares.get(indice);
    }

    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return new ArrayList<>(pares); 
    }

    public void mostrarPares() {
        if (pares.isEmpty()) {
            System.out.println("El contenedor está vacío.");
            return;
        }
        
        System.out.println("Pares en el contenedor");
        for (int i = 0; i < pares.size(); i++) {
            System.out.println((i + 1) + ". " + pares.get(i));
        }
        System.out.println("Total: " + pares.size() + " pares");
    }

    public int tamaño() {
        return pares.size();
    }

    public boolean estaVacio() {
        return pares.isEmpty();
    }

    public Par<F, S> eliminarPar(int indice) {
        if (indice < 0 || indice >= pares.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return pares.remove(indice);
    }

    public List<Par<F, S>> buscarPorPrimero(F primerElemento) {
        List<Par<F, S>> resultado = new ArrayList<>();
        for (Par<F, S> par : pares) {
            if (par.getPrimero() == null && primerElemento == null) {
                resultado.add(par);
            } else if (par.getPrimero() != null && par.getPrimero().equals(primerElemento)) {
                resultado.add(par);
            }
        }
        return resultado;
    }
} 
