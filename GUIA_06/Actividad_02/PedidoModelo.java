package Actividad_02;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;
    
    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }
    
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public boolean eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.remove(indice);
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
            if (pedido.getNombrePlato().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }
    
    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
    
    public int getTotalPedidos() {
        return pedidos.size();
    }
    
    public int contarPorTipo(String tipo) {
        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }
    
    public List<String> getTiposExistentes() {
        List<String> tipos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            String tipo = pedido.getTipoPlato();
            if (!tipos.contains(tipo)) {
                tipos.add(tipo);
            }
        }
        return tipos;
    }
}