package Ejercicio_06;

import java.time.LocalDate;

interface Promocion {
    boolean esAplicable(Habitacion habitacion, LocalDate fecha);
    double calcularDescuento(Habitacion habitacion, LocalDate inicio, LocalDate fin);
}

class PromocionTemporadaAlta implements Promocion {
    public boolean esAplicable(Habitacion habitacion, LocalDate fecha) {
        return fecha.getMonthValue() >= 6 && fecha.getMonthValue() <= 8;
    }
    
    public double calcularDescuento(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        int dias = (int) java.time.temporal.ChronoUnit.DAYS.between(inicio, fin);
        return habitacion.precio * dias * 0.1;
    }
}