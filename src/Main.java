import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {
    public static void main(String[] args) {
        PedidoComida pedidoComida =
                new PedidoComida(1, "Av. Vicuña Mackenna 1234", 5);
        PedidoEncomienda pedidoEncomienda =
                new PedidoEncomienda(2, "Av. La Florida 2500", 8);
        PedidoExpress pedidoExpress =
                new PedidoExpress(3, "Av. Walker Martínez 1500", 7);
        System.out.println("===== PEDIDO DE COMIDA =====");
        pedidoComida.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoComida.calcularTiempoEntrega() + " minutos");
        pedidoComida.asignarRepartidor();
        System.out.println();
        System.out.println("===== PEDIDO DE ENCOMIENDA =====");
        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        pedidoEncomienda.asignarRepartidor();
        System.out.println();
        System.out.println("===== PEDIDO EXPRESS =====");
        pedidoExpress.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");
        pedidoExpress.asignarRepartidor();
        System.out.println();
        System.out.println("===== COMPARACION DE TIEMPOS =====");
        System.out.println("Comida: "
                + pedidoComida.calcularTiempoEntrega() + " minutos");
        System.out.println("Encomienda: "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        System.out.println("Express: "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");
    }
}