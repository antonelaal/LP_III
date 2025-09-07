package guia_03;


public class Controlador {
    public static void main(String[] args) {
        Habitacion hab1 = new Habitacion(101, "Doble", 150.0);

        System.out.println("Disponibilidad inicial: " + hab1.verificarDisponibilidad("2025-09-10", "2025-09-12"));

        if (hab1.reservar("Antonela", "2025-09-10", "2025-09-12")) {
            System.out.println("Reserva realizada para Antonela.");
        } else {
            System.out.println("No se pudo realizar la reserva.");
        }

        System.out.println("Disponibilidad después de reservar: " + hab1.verificarDisponibilidad("2025-09-10", "2025-09-12"));

        hab1.cancelarReserva("Antonela");

        System.out.println("Disponibilidad tras cancelar: " + hab1.verificarDisponibilidad("2025-09-10", "2025-09-12"));
    }
}
