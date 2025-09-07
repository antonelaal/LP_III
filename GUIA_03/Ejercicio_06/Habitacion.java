package Ejercicio_06;

abstract class Habitacion {
    int numero;
    String tipo;
    double precio;
    boolean ocupada;
    HabitacionLibre gestor;
    
    Habitacion(int n, String t, double p) {
        numero = n;
        tipo = t;
        precio = p;
        ocupada = false;
        gestor = new HabitacionLibre();
    }
    
    abstract String getDescripcion();
    abstract boolean tieneServiciosPremium();

    final void marcarReservada() {
        ocupada = true;
    }
    
    final void marcarDisponible() {
        ocupada = false;
    }
    
    final HabitacionLibre getGestor() {
        return gestor;
    }
    
    final boolean estaOcupada() {
        return ocupada;
    }
}