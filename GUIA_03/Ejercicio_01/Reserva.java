package guia_03;

public class Reserva {
    private String cliente;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(String cliente, String fechaInicio, String fechaFin) {
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
}
