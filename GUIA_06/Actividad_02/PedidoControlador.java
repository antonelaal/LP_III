package Actividad_02;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;
    
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("✅ Pedido agregado: " + nombrePlato + " (" + tipoPlato + ")");
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
        }
    }
    
    public void eliminarPedido() {
        vista.mostrarPedidos(modelo.getPedidos());
        if (!modelo.getPedidos().isEmpty()) {
            int indice = vista.solicitarIndicePedido();
            if (modelo.eliminarPedido(indice)) {
                vista.mostrarMensaje("Pedido eliminado correctamente.");
            } else {
                vista.mostrarMensaje("Índice de pedido inválido.");
            }
        }
    }
    
    public void actualizarPedido() {
        vista.mostrarPedidos(modelo.getPedidos());
        if (!modelo.getPedidos().isEmpty()) {
            int indice = vista.solicitarIndicePedido();
            if (indice >= 0 && indice < modelo.getPedidos().size()) {
                String nuevoNombre = vista.solicitarNombrePlato();
                String nuevoTipo = vista.solicitarTipoPlato();
                if (modelo.actualizarPedido(indice, nuevoNombre, nuevoTipo)) {
                    vista.mostrarMensaje("Pedido actualizado correctamente.");
                } else {
                    vista.mostrarMensaje("Error al actualizar el pedido.");
                }
            } else {
                vista.mostrarMensaje("Índice de pedido inválido.");
            }
        }
    }
    
    public void buscarPorNombre() {
        String nombre = vista.solicitarTextoBusqueda();
        List<Pedido> resultados = modelo.buscarPorNombre(nombre);
        vista.mostrarResultadosBusqueda(resultados, "nombre: " + nombre);
    }
    
    public void buscarPorTipo() {
        String tipo = vista.solicitarTipoBusqueda();
        List<Pedido> resultados = modelo.buscarPorTipo(tipo);
        vista.mostrarResultadosBusqueda(resultados, "tipo: " + tipo);
    }
    
    public void mostrarEstadisticas() {
        int total = modelo.getTotalPedidos();
        List<String> tipos = modelo.getTiposExistentes();
        vista.mostrarEstadisticas(total, tipos, modelo);
    }
    
    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }
    
    public void iniciar() {
        vista.mostrarMensaje("Bienvenido al Sistema de Gestión de Pedidos");
        String opcion;
        
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPorNombre();
                    break;
                case "6":
                    buscarPorTipo();
                    break;
                case "7":
                    mostrarEstadisticas();
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("8"));
        
        vista.cerrarScanner();
    }
}