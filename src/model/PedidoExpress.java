package model;

public class PedidoExpress extends Pedido {
    @Override
    public void asignarRepartidor() {
        System.out.println("Buscando al repartidor mas cercano...");
    }
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor: " + nombreRepartidor);
    }
}
