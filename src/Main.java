import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // pedidos repartidor 1
        List<Pedido> pedidosCarlos = Arrays.asList(
                new PedidoComida(
                        1,
                        "Av. Providencia 123",
                        4.5,
                        "Restaurant El Buen Sabor"
                ),
                new PedidoExpress(
                        2,
                        "Av. Apoquindo 456",
                        3.2,
                        "Supermercado Central"
                )
        );
        // pedidos repartidor 2
        List<Pedido> pedidosAna = Arrays.asList(
                new PedidoEncomienda(
                        3,
                        "Calle Los Leones 789",
                        6.0,
                        "Documentos"
                ),
                new PedidoComida(
                        4,
                        "Av. Irarrazaval 321",
                        2.8,
                        "Pizza Express"
                )
        );
        // pedidos repartidor 3
        List<Pedido> pedidosLuis = Arrays.asList(
                new PedidoExpress(
                        5,
                        "Calle Macul 555",
                        5.5,
                        "Farmacia Salud"
                ),
                new PedidoEncomienda(
                        6,
                        "Av. Vicuña Mackenna 999",
                        7.2,
                        "Paquete"
                )
        );
        // crear repartidores
        Repartidor repartidorCarlos =
                new Repartidor("Carlos", pedidosCarlos);
        Repartidor repartidorAna =
                new Repartidor("Ana", pedidosAna);
        Repartidor repartidorLuis =
                new Repartidor("Luis", pedidosLuis);
        // crear executor service
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
        System.out.println("====================================");
        System.out.println("   SPEEDFAST - SISTEMA DE ENTREGAS");
        System.out.println("====================================");
        System.out.println(
                "Iniciando entregas simultaneas..."
        );
        // ejec. concurrente
        executor.submit(repartidorCarlos);
        executor.submit(repartidorAna);
        executor.submit(repartidorLuis);
        executor.shutdown();
        try {
            while (!executor.isTerminated()) {
                Thread.sleep(500);
            }
            System.out.println(
                    "\n===================================="
            );
            System.out.println(
                    "Todas las entregas fueron completadas."
            );
            System.out.println(
                    "===================================="
            );
        } catch (InterruptedException e) {
            System.out.println(
                    "El proceso principal fue interrumpido."
            );
            Thread.currentThread().interrupt();
        }
    }
}