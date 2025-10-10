package Actividad_03;

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
                System.out.println((i + 1) + ". " + pedido.toString());
            }
            System.out.println("Total de pedidos: " + pedidos.size());
        }
    }
    
    public void mostrarPedidosConEstado(List<Pedido> pedidos, String estado) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos con estado: " + estado);
        } else {
            System.out.println("\nPEDIDOS " + estado +":");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println((i + 1) + ". " + pedido.toHistorialString());
            }
            System.out.println("Total: " + pedidos.size() + " pedidos");
        }
    }
    
    public void mostrarResultadosBusqueda(List<Pedido> resultados, String criterio) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron pedidos con el criterio: " + criterio);
        } else {
            System.out.println("\nResultados de Busqueda");
            for (int i = 0; i < resultados.size(); i++) {
                Pedido pedido = resultados.get(i);
                System.out.println((i + 1) + ". " + pedido.toString());
            }
            System.out.println("Encontrados: " + resultados.size() + " pedidos");
        }
    }
    
    public void mostrarEstadisticas(int total, int pendientes, int completados, List<String> tipos, PedidoModelo modelo) {
        System.out.println("\nEstadistica de Pedidos");
        System.out.println("Total de pedidos activos: " + total);
        System.out.println("Pedidos pendientes: " + pendientes);
        System.out.println("Pedidos completados: " + completados);
        
        System.out.println("\nPedidos por tipo:");
        for (String tipo : tipos) {
            int cantidad = modelo.contarPorTipo(tipo);
            System.out.println("- " + tipo + ": " + cantidad);
        }
    }
    
    public void mostrarHistorial(List<Pedido> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay historial de pedidos.");
        } else {
            System.out.println("\nHistorial completo de Pedidos");
            for (int i = 0; i < historial.size(); i++) {
                Pedido pedido = historial.get(i);
                System.out.println((i + 1) + ". " + pedido.toHistorialString());
            }
            System.out.println("Total en historial: " + historial.size() + " pedidos");
        }
    }
    
    public void mostrarMenu() {
        System.out.println("\nSistema de Gestión de Pedidos");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos Activos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Marcar Pedido como Completado");
        System.out.println("6. Buscar por Nombre");
        System.out.println("7. Buscar por Tipo");
        System.out.println("8. Mostrar Pedidos Pendientes");
        System.out.println("9. Mostrar Pedidos Completados");
        System.out.println("10. Mostrar Estadísticas");
        System.out.println("11. Mostrar Historial Completo");
        System.out.println("12. Salir");
    }
    
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción (1-12): ");
        return scanner.nextLine().trim();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}