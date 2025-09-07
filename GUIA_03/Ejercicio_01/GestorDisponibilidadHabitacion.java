package guia_03;

import java.util.ArrayList;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas;

    public GestorDisponibilidadHabitacion() {
        this.reservas = new ArrayList<>();
    }

    public boolean verificarDisponibilidad(String fechaInicio, String fechaFin) {
        for (Reserva r : reservas) {
            if (!(fechaFin.compareTo(r.getFechaInicio()) < 0 || fechaInicio.compareTo(r.getFechaFin()) > 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean reservar(String cliente, String fechaInicio, String fechaFin) {
        if (verificarDisponibilidad(fechaInicio, fechaFin)) {
            reservas.add(new Reserva(cliente, fechaInicio, fechaFin));
            return true;
        }
        return false;
    }

    public void cancelarReserva(String cliente) {
        reservas.removeIf(r -> r.getCliente().equals(cliente));
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}

