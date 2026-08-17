package model;

public class PedidoEncomienda extends Pedido {
    @Override
    public void asignarRepartidor() {
        System.out.println("Validando peso y embalaje...");
    }
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor: " + nombreRepartidor);
        System.out.println("Validando peso y embalaje... OK");
    }
}
