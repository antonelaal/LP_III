package guia_03;

public class Habitacion {
    private int numero;
    private String tipo;   
    private double precio;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean verificarDisponibilidad(String fechaInicio, String fechaFin) {
        return gestorDisponibilidad.verificarDisponibilidad(fechaInicio, fechaFin);
    }

    public boolean reservar(String cliente, String fechaInicio, String fechaFin) {
        return gestorDisponibilidad.reservar(cliente, fechaInicio, fechaFin);
    }

    public void cancelarReserva(String cliente) {
        gestorDisponibilidad.cancelarReserva(cliente);
    }
}

