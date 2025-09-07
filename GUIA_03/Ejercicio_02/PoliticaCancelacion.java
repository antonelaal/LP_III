package Ejercicio_02;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva);
    double calcularPenalizacion(Reserva reserva); 
}
