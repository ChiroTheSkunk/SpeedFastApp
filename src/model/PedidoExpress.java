package model;

public class PedidoExpress extends Pedido implements Despachable, Cancelable, Rastreable {
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido express: asignando repartidor de forma prioritaria.");
    }
    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("Pedido express asignado al repartidor: " + nombre);
    }
    @Override
    public double calcularTiempoEntrega() {
        return getDistanciaKm() * 3;
    }
    @Override
    public void despachar() {
        System.out.println("Pedido express despachado.");
    }
    @Override
    public void cancelar() {
        System.out.println("Pedido express cancelado.");
    }
    @Override
    public void verHistorial() {
        System.out.println("Historial del pedido express #" + getIdPedido());
    }
}
