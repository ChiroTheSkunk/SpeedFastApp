import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PedidoComida comida =
                new PedidoComida(1, "Av. Vicuña Mackenna 123", 5);
        PedidoEncomienda encomienda =
                new PedidoEncomienda(2, "Av. Providencia 456", 8);
        PedidoExpress express =
                new PedidoExpress(3, "Av. La Florida 789", 3);
        System.out.println("===== PEDIDO COMIDA =====");
        comida.mostrarResumen();
        System.out.println("\nAsignacion automatica:");
        comida.asignarRepartidor();
        System.out.println("\nAsignacion manual:");
        comida.asignarRepartidor("Carlos");
        System.out.println("\nTiempo estimado:");
        System.out.println(comida.calcularTiempoEntrega() + " minutos");
        System.out.println("\nDespacho:");
        comida.despachar();
        System.out.println("\n===== PEDIDO ENCOMIENDA =====");
        encomienda.mostrarResumen();
        encomienda.asignarRepartidor();
        encomienda.asignarRepartidor("Juan");
        System.out.println("Tiempo estimado: "
                + encomienda.calcularTiempoEntrega() + " minutos");
        encomienda.despachar();
        System.out.println("\n===== PEDIDO EXPRESS =====");
        express.mostrarResumen();
        express.asignarRepartidor();
        express.asignarRepartidor("Pedro");
        System.out.println("Tiempo estimado: "
                + express.calcularTiempoEntrega() + " minutos");
        express.despachar();
        System.out.println("\n===== CANCELACION =====");
        express.cancelar();
        System.out.println("\n===== HISTORIAL =====");
        ArrayList<Pedido> historial = new ArrayList<>();
        historial.add(comida);
        historial.add(encomienda);
        for (Pedido pedido : historial) {
            pedido.mostrarResumen();
            System.out.println("--------------------");
        }
        System.out.println("\nMostrando historial individual:");
        comida.verHistorial();
        encomienda.verHistorial();
        express.verHistorial();
    }
}