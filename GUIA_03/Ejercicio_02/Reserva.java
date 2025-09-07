package Ejercicio_02;

public class Reserva {
    private String cliente;
    private String fechaInicio;
    private String fechaFin;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva(String cliente, String fechaInicio, String fechaFin, PoliticaCancelacion politicaCancelacion) {
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }
    
    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public boolean puedeCancelar() {
        return politicaCancelacion.puedeCancelar(this);
    }
    
    public double obtenerPenalizacion() {
        return politicaCancelacion.calcularPenalizacion(this);
    }
}

