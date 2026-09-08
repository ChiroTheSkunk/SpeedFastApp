package model;

import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidos;
    private Random random = new Random();
    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }
    @Override
    public void run() {
        System.out.println(
                "\n[" + nombre + "] comenzo su jornada."
        );
        for (Pedido pedido : pedidos) {
            System.out.println(
                    "[" + nombre + "] recibio el pedido #"
                            + pedido.getIdPedido()
            );
            pedido.mostrarResumen();
            System.out.println(
                    "[" + nombre + "] se dirige a entregar el pedido #"
                            + pedido.getIdPedido()
            );
            try {
                int tiempoEspera = 1000 + random.nextInt(3000);
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                System.out.println(
                        "[" + nombre + "] fue interrumpido."
                );
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(
                    "[" + nombre + "] entrego correctamente el pedido #"
                            + pedido.getIdPedido()
            );
            System.out.println(
                    "[" + nombre + "] Tiempo estimado de entrega: "
                            + pedido.calcularTiempoEntrega()
                            + " minutos."
            );
            System.out.println("-----------------------------------");
        }
        System.out.println(
                "[" + nombre + "] termino todas sus entregas."
        );
    }
}