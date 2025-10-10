package Actividad_01;

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
    
    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
    
    public int getTotalPedidos() {
        return pedidos.size();
    }
}