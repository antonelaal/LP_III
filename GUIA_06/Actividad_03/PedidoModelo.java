package Actividad_03;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;
    
    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }
    
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        historial.add(pedido);
    }
    
    public boolean eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            pedido.marcarComoEliminado();
            return true;
        }
        return false;
    }
    
    public boolean marcarComoCompletado(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            pedido.marcarComoCompletado();
            return true;
        }
        return false;
    }
    
    public boolean actualizarPedido(int indice, String nuevoNombre, String nuevoTipo) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            pedido.setNombrePlato(nuevoNombre);
            pedido.setTipoPlato(nuevoTipo);
            return true;
        }
        return false;
    }
    
    public List<Pedido> buscarPorNombre(String nombre) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().toLowerCase().contains(nombre.toLowerCase()) && 
                !pedido.estaEliminado()) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo) && !pedido.estaEliminado()) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> getPedidos() {
        List<Pedido> pedidosActivos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.estaEliminado()) {
                pedidosActivos.add(pedido);
            }
        }
        return pedidosActivos;
    }
    
    public List<Pedido> getPedidosPorEstado(String estado) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals(estado)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> getPedidosPendientes() {
        return getPedidosPorEstado("PENDIENTE");
    }
    
    public List<Pedido> getPedidosCompletados() {
        return getPedidosPorEstado("COMPLETADO");
    }
    
    public List<Pedido> getHistorial() {
        return new ArrayList<>(historial);
    }
    
    public int getTotalPedidos() {
        return getPedidos().size();
    }
    
    public int getTotalPendientes() {
        return getPedidosPendientes().size();
    }
    
    public int getTotalCompletados() {
        return getPedidosCompletados().size();
    }
    
    public int contarPorTipo(String tipo) {
        int contador = 0;
        for (Pedido pedido : getPedidos()) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }
    
    public List<String> getTiposExistentes() {
        List<String> tipos = new ArrayList<>();
        for (Pedido pedido : getPedidos()) {
            String tipo = pedido.getTipoPlato();
            if (!tipos.contains(tipo)) {
                tipos.add(tipo);
            }
        }
        return tipos;
    }
}