package Actividad_01;

public class Pedido {
    private String nombrePlato;
    
    public Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
    
    public String getNombrePlato() {
        return nombrePlato;
    }
    
    @Override
    public String toString() {
        return nombrePlato;
    }
}