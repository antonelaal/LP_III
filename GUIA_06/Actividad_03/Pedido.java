package Actividad_03;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private String estado;
    private String fechaCreacion;
    private String fechaModificacion;
    
    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = "PENDIENTE";
        this.fechaCreacion = java.time.LocalDateTime.now().toString();
        this.fechaModificacion = this.fechaCreacion;
    }
    
    public String getNombrePlato() {
        return nombrePlato;
    }
    
    public String getTipoPlato() {
        return tipoPlato;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    public String getFechaModificacion() {
        return fechaModificacion;
    }
    
    // Setters
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
        this.fechaModificacion = java.time.LocalDateTime.now().toString();
    }
    
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
        this.fechaModificacion = java.time.LocalDateTime.now().toString();
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
        this.fechaModificacion = java.time.LocalDateTime.now().toString();
    }
    
    public void marcarComoCompletado() {
        this.estado = "COMPLETADO";
        this.fechaModificacion = java.time.LocalDateTime.now().toString();
    }
    
    public void marcarComoEliminado() {
        this.estado = "ELIMINADO";
        this.fechaModificacion = java.time.LocalDateTime.now().toString();
    }
    
    public boolean estaPendiente() {
        return "PENDIENTE".equals(estado);
    }
    
    public boolean estaCompletado() {
        return "COMPLETADO".equals(estado);
    }
    
    public boolean estaEliminado() {
        return "ELIMINADO".equals(estado);
    }
    
    @Override
    public String toString() {
        String emoji = "";
        switch (estado) {
            case "PENDIENTE": emoji = "⏳"; break;
            case "COMPLETADO": emoji = "✅"; break;
            case "ELIMINADO": emoji = "🗑️"; break;
        }
        return nombrePlato + " (" + tipoPlato + ") " + emoji + " - " + estado;
    }
    
    public String toHistorialString() {
        return nombrePlato + " (" + tipoPlato + ") - " + estado + 
               " - Creado: " + fechaCreacion.substring(0, 16) + 
               " - Modificado: " + fechaModificacion.substring(0, 16);
    }
}