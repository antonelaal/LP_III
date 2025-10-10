package Actividad_02;

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
    
    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo de plato: ");
        return scanner.nextLine().trim();
    }
    
    public int solicitarIndicePedido() {
        System.out.print("Introduce el número del pedido: ");
        try {
            return Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String solicitarTextoBusqueda() {
        System.out.print("Introduce el texto a buscar: ");
        return scanner.nextLine().trim();
    }
    
    public String solicitarTipoBusqueda() {
        System.out.print("Introduce el tipo a buscar: ");
        return scanner.nextLine().trim();
    }
    
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("\nLista de Pedidos");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println((i + 1) + ". " + pedido.getNombrePlato() + " - " + pedido.getTipoPlato());
            }
            System.out.println("Total de pedidos: " + pedidos.size());
        }
    }
    
    public void mostrarResultadosBusqueda(List<Pedido> resultados, String criterio) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron pedidos con el criterio: " + criterio);
        } else {
            System.out.println("\nResultados de la Busqueda");
            for (int i = 0; i < resultados.size(); i++) {
                Pedido pedido = resultados.get(i);
                System.out.println((i + 1) + ". " + pedido.getNombrePlato() + " - " + pedido.getTipoPlato());
            }
            System.out.println("Encontrados: " + resultados.size() + " pedidos");
        }
    }
    
    public void mostrarEstadisticas(int total, List<String> tipos, PedidoModelo modelo) {
        System.out.println("\nEstadistica de los Pedidos");
        System.out.println("Total de pedidos: " + total);
        System.out.println("\nPedidos por tipo:");
        for (String tipo : tipos) {
            int cantidad = modelo.contarPorTipo(tipo);
            System.out.println("- " + tipo + ": " + cantidad);
        }
    }
    
    public void mostrarMenu() {
        System.out.println("\nSistema de Gestión de Pedidos");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar por Nombre");
        System.out.println("6. Buscar por Tipo");
        System.out.println("7. Mostrar Estadísticas");
        System.out.println("8. Salir");
    }
    
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción (1-8): ");
        return scanner.nextLine().trim();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}