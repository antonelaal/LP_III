package Ejercicio_06;


import java.time.LocalDate;
import java.util.List;

class CalculadoraPrecioHabitacion {
    private List<Promocion> promociones;
    
    public CalculadoraPrecioHabitacion(List<Promocion> promociones) {
        this.promociones = promociones;
    }
    
    public double calcularPrecioFinal(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        double precioBase = habitacion.precio * calcularDias(fechaInicio, fechaFin);
        double descuento = calcularDescuento(habitacion, fechaInicio, fechaFin);
        return precioBase - descuento;
    }
    
    private int calcularDias(LocalDate inicio, LocalDate fin) {
        return (int) java.time.temporal.ChronoUnit.DAYS.between(inicio, fin);
    }
    
    private double calcularDescuento(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        double descuentoTotal = 0;
        for (Promocion promocion : promociones) {
            if (promocion.esAplicable(habitacion, fechaInicio)) {
                descuentoTotal += promocion.calcularDescuento(habitacion, fechaInicio, fechaFin);
            }
        }
        return descuentoTotal;
    }
}


interface ServicioLimpieza {
    void solicitarLimpieza();
    void programarLimpiezaRegular();
}

interface ServicioComida {
    void solicitarComida(String plato);
    void solicitarMenuEspecial(String menu);
}

interface ServicioLavanderia {
    void solicitarLavanderia(int prendas);
    void solicitarLavanderiaUrgente(int prendas);
}

interface ServicioConcierge {
    void solicitarTransporte();
    void reservarTour(String tour);
}

interface PersonalRecepcion {
    void checkIn(Cliente cliente);
    void checkOut(Cliente cliente);
    void procesarPago(Cliente cliente, double monto);
}


