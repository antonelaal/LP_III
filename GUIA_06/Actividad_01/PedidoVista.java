package Actividad_01;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;
    
    public PedidoVista() {
        scanner = new Scanner(System.in);
    }
    
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine().trim();
    }
    
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("\nLista de Pedidos");
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i + 1) + ". " + pedidos.get(i).getNombrePlato());
            }
            System.out.println("Total de pedidos: " + pedidos.size());
        }
    }
    
    public void mostrarMenu() {
        System.out.println("\nSistema de Gestión de Pedidos");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Salir");
    }
    
    public String solicitarOpcion() {
        System.out.print("Seleccione una opción (1-3): ");
        return scanner.nextLine().trim();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}