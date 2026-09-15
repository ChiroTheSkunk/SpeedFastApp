package model;

import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private Random random = new Random();
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }
    @Override
    public void run() {
        System.out.println(
                "\n[" + nombre + "] comenzo su jornada."
        );
        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null) {
                break;
            }
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println(
                    "[" + nombre + "] retiro el pedido #" +
                            pedido.getIdPedido() +
                            " | Estado: " +
                            pedido.getEstado()
            );
            pedido.mostrarResumen();
            System.out.println(
                    "[" + nombre + "] se dirige a entregar el pedido #" +
                            pedido.getIdPedido()
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
            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println(
                    "[" + nombre + "] entrego correctamente el pedido #" +
                            pedido.getIdPedido() +
                            " | Estado: " +
                            pedido.getEstado()
            );
            System.out.println(
                    "[" + nombre + "] Tiempo estimado de entrega: " +
                            pedido.calcularTiempoEntrega() +
                            " minutos."
            );
            System.out.println("-----------------------------------");
        }
        System.out.println(
                "[" + nombre + "] termino todas sus entregas."
        );
    }
}