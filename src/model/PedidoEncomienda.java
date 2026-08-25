package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
    }
    @Override
    public void asignarRepartidor() {
        System.out.println("Validando peso y embalaje...");
    }
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor: " + nombreRepartidor);
        System.out.println("Validando peso y embalaje... OK");
    }
}