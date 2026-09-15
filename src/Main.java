import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;
import model.ZonaDeCarga;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        // Agregar pedidos a la zona de carga
        zonaDeCarga.agregarPedido(
                new PedidoComida(
                        1,
                        "Av. Providencia 123",
                        4.5,
                        "Restaurant El Buen Sabor"
                )
        );
        zonaDeCarga.agregarPedido(
                new PedidoExpress(
                        2,
                        "Av. Apoquindo 456",
                        3.2,
                        "Supermercado Central"
                )
        );
        zonaDeCarga.agregarPedido(
                new PedidoEncomienda(
                        3,
                        "Calle Los Leones 789",
                        6.0,
                        "Documentos"
                )
        );
        zonaDeCarga.agregarPedido(
                new PedidoComida(
                        4,
                        "Av. Irarrazaval 321",
                        2.8,
                        "Pizza Express"
                )
        );
        zonaDeCarga.agregarPedido(
                new PedidoExpress(
                        5,
                        "Calle Macul 555",
                        5.5,
                        "Farmacia Salud"
                )
        );
        zonaDeCarga.agregarPedido(
                new PedidoEncomienda(
                        6,
                        "Av. Vicuña Mackenna 999",
                        7.2,
                        "Paquete"
                )
        );
        // Crear repartidores
        Repartidor repartidorCarlos =
                new Repartidor("Carlos", zonaDeCarga);
        Repartidor repartidorAna =
                new Repartidor("Ana", zonaDeCarga);
        Repartidor repartidorLuis =
                new Repartidor("Luis", zonaDeCarga);
        // Crear ExecutorService con 3 hilos
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
        System.out.println("====================================");
        System.out.println("   SPEEDFAST - SISTEMA DE ENTREGAS");
        System.out.println("====================================");
        System.out.println(
                "Iniciando entregas simultaneas..."
        );
        // Ejecutar repartidores en paralelo
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
                    "Todos los pedidos han sido entregados correctamente"
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