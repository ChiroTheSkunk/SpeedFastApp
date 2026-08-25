package model;

public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * getDistanciaKm()));
    }
    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor...");
        System.out.println("Se requiere mochila termica.");
    }
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor: " + nombreRepartidor);
        System.out.println("Verificando mochila termica... OK");
    }
}
