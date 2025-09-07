package Ejercicio_02;

public class Controlador {
    public static void main(String[] args) {
        Habitacion hab1 = new Habitacion(101, "Doble", 150.0);

        PoliticaCancelacion politicaFlexible = new PoliticaCancelacionFlexible();
        
        if (hab1.reservar("Antonela", "2025-09-10", "2025-09-12", politicaFlexible)) {
            System.out.println("Reserva realizada para Antonela con política flexible.");
        }

        System.out.println("Puede cancelar: " + hab1.verificarPuedeCancelar("Antonela"));
    }
}