package Actividad_02;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    
    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
    }
    
    public String getNombrePlato() {
        return nombrePlato;
    }
    
    public String getTipoPlato() {
        return tipoPlato;
    }
    
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
    
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }
    
    @Override
    public String toString() {
        return nombrePlato + " (" + tipoPlato + ")";
    }
}