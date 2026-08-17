package model;

public class PedidoComida extends Pedido {
    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor...");
        System.out.println("Se requiere mochila termica.");
    }
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor: " + nombreRepartidor);
        System.out.println("Verificando mochila termica... OK");
    }
}
