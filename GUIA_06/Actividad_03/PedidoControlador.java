package Actividad_03;

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
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipoPlato + ") - Estado: PENDIENTE");
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
        }
    }
    
    public void eliminarPedido() {
        vista.mostrarPedidos(modelo.getPedidos());
        if (!modelo.getPedidos().isEmpty()) {
            int indice = vista.solicitarIndicePedido();
            if (modelo.eliminarPedido(indice)) {
                vista.mostrarMensaje("Pedido marcado como eliminado.");
            } else {
                vista.mostrarMensaje("Índice de pedido inválido.");
            }
        }
    }
    
    public void marcarComoCompletado() {
        vista.mostrarPedidos(modelo.getPedidos());
        if (!modelo.getPedidos().isEmpty()) {
            int indice = vista.solicitarIndicePedido();
            if (modelo.marcarComoCompletado(indice)) {
                vista.mostrarMensaje("Pedido marcado como completado.");
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
    
    public void mostrarPedidosPendientes() {
        List<Pedido> pendientes = modelo.getPedidosPendientes();
        vista.mostrarPedidosConEstado(pendientes, "PENDIENTES");
    }
    
    public void mostrarPedidosCompletados() {
        List<Pedido> completados = modelo.getPedidosCompletados();
        vista.mostrarPedidosConEstado(completados, "COMPLETADOS");
    }
    
    public void mostrarEstadisticas() {
        int total = modelo.getTotalPedidos();
        int pendientes = modelo.getTotalPendientes();
        int completados = modelo.getTotalCompletados();
        List<String> tipos = modelo.getTiposExistentes();
        vista.mostrarEstadisticas(total, pendientes, completados, tipos, modelo);
    }
    
    public void mostrarHistorial() {
        List<Pedido> historial = modelo.getHistorial();
        vista.mostrarHistorial(historial);
    }
    
    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }
    
    public void iniciar() {
        vista.mostrarMensaje("Bienvenido al Sistema de Gestión de Pedidos con Estados");
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
                    marcarComoCompletado();
                    break;
                case "6":
                    buscarPorNombre();
                    break;
                case "7":
                    buscarPorTipo();
                    break;
                case "8":
                    mostrarPedidosPendientes();
                    break;
                case "9":
                    mostrarPedidosCompletados();
                    break;
                case "10":
                    mostrarEstadisticas();
                    break;
                case "11":
                    mostrarHistorial();
                    break;
                case "12":
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("12"));
        
        vista.cerrarScanner();
    }
}