package model;
import java.util.LinkedList;
import java.util.List;
public class ZonaDeCarga {
    private List<Pedido> pedidos;
    public ZonaDeCarga() {
        pedidos = new LinkedList<>();
    }
    public synchronized void agregarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println(
                "Pedido #" + p.getIdPedido() +
                        " agregado a la zona de carga."
        );
    }
    public synchronized Pedido retirarPedido() {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
                pedidos.remove(i);
                return pedido;
            }
        }
        return null;
    }
}