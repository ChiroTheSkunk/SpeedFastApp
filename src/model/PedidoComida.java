package model;

public class PedidoComida extends Pedido implements Despachable, Cancelable, Rastreable {
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido de comida: se requiere repartidor con mochila termica.");
    }
    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("Pedido de comida asignado al repartidor: " + nombre);
        System.out.println("Verificando mochila termica...");
        System.out.println("Mochila termica confirmada.");
    }
    @Override
    public double calcularTiempoEntrega() {
        return getDistanciaKm() * 5;
    }
    @Override
    public void despachar() {
        System.out.println("Pedido de comida despachado.");
    }
    @Override
    public void cancelar() {
        System.out.println("Pedido de comida cancelado.");
    }
    @Override
    public void verHistorial() {
        System.out.println("Historial del pedido de comida #" + getIdPedido());
    }
}