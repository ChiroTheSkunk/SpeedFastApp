import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.asignarRepartidor();
        pedido.asignarRepartidor("Juan");
        PedidoComida pedidoComida = new PedidoComida();
        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Carlos");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda();
        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Marcos");
        PedidoExpress pedidoExpress = new PedidoExpress();
        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Pedro");
    }
}