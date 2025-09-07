package Ejercicio_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        LocalDate fechaCheckIn = LocalDate.parse(reserva.getFechaInicio(), DateTimeFormatter.ISO_DATE);
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(fechaCheckIn.minusDays(1));
    }
    
    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0.0; 
    }
}