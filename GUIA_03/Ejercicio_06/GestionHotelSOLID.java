package Ejercicio_06;

import java.time.LocalDate;
import java.util.List;


public class GestionHotelSOLID {
    public static void main(String[] args) {
        List<Promocion> promociones = List.of(
            new PromocionTemporadaAlta(),
            new PromocionClienteFrecuente(),
            new PromocionEstadiaLarga()
        );
        
        CalculadoraPrecioHabitacion calculadora = new CalculadoraPrecioHabitacion(promociones);

        Habitacion h1 = new HabitacionSimple(1, 50);
        Habitacion h2 = new HabitacionDoble(2, 80);
        Habitacion h3 = new HabitacionSuite(3, 150);
        
        LocalDate inicio = LocalDate.of(2025, 9, 2);
        LocalDate fin = LocalDate.of(2025, 9, 10);
        
        double precioFinal = calculadora.calcularPrecioFinal(h3, inicio, fin);
        System.out.println("Precio final suite: $" + precioFinal);
        
        if (h3.getGestor().verificarDisponibilidad(inicio, fin)) {
            PoliticaCancelacion politica = new PoliticaCancelacionModerada();
            Cliente cliente = new Cliente("francois", "frangames@gmail.pe");
            Reserva reserva = new Reserva(h3, inicio, fin, cliente, politica);
            
            h3.getGestor().agregarReserva(reserva);
            h3.marcarReservada();
            
            System.out.println("Reserva realizada: " + h3.getDescripcion());
            
            if (h3 instanceof ServicioConcierge) {
                ((ServicioConcierge) h3).reservarTour("City Tour");
            }
            
            NotificadorReserva notificador = new NotificadorReserva(new EnviadorSMS());
            notificador.notificar("Reserva confirmada para habitación " + h3.numero);
        }
    }
}