package Ejercicio_06;

import java.time.LocalDate;

class PromocionEstadiaLarga implements Promocion {
    public boolean esAplicable(Habitacion habitacion, LocalDate fecha) {
        return true;
    }
    
    public double calcularDescuento(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        int dias = (int) java.time.temporal.ChronoUnit.DAYS.between(inicio, fin);
        if (dias > 7) {
            return habitacion.precio * dias * 0.2;
        return 0;
    }
}