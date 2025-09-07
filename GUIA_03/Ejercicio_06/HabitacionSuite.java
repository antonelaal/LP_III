package Ejercicio_06;


class HabitacionSuite extends Habitacion implements ServicioLimpieza, ServicioComida, ServicioLavanderia, ServicioConcierge {
    HabitacionSuite(int n, double p) {
        super(n, "suite", p);
    }
    
    public String getDescripcion() {
        return "Suite premium con todos los servicios incluidos";
    }
    
    public boolean tieneServiciosPremium() {
        return true;
    }
    
    public void solicitarLimpieza() {
        System.out.println("Limpieza express solicitada para suite " + numero);
    }
    
    public void programarLimpiezaRegular() {
        System.out.println("Limpieza regular programada para suite " + numero);
    }
    
    public void solicitarComida(String plato) {
        System.out.println("Pedido gourmet: " + plato + " en suite " + numero);
    }
    
    public void solicitarMenuEspecial(String menu) {
        System.out.println("Menú especial " + menu + " solicitado para suite " + numero);
    }
    
    public void solicitarLavanderia(int prendas) {
        System.out.println("Lavandería para " + prendas + " prendas en suite " + numero);
    }
    
    public void solicitarLavanderiaUrgente(int prendas) {
        System.out.println("Lavandería urgente para " + prendas + " prendas en suite " + numero);
    }
    
    public void solicitarTransporte() {
        System.out.println("Transporte privado solicitado desde suite " + numero);
    }
    
    public void reservarTour(String tour) {
        System.out.println("Tour " + tour + " reservado para huésped de suite " + numero);
    }
} 