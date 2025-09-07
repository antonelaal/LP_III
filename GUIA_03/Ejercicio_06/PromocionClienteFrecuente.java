package Ejercicio_06;

import java.time.LocalDate;

class PromocionClienteFrecuente implements Promocion {
    public boolean esAplicable(Habitacion habitacion, LocalDate fecha) {
        return true;
    }
    
    public double calcularDescuento(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        int dias = (int) java.time.temporal.ChronoUnit.DAYS.between(inicio, fin);
        return habitacion.precio * dias * 0.15;
    }
}