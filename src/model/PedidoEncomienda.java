package model;

public class PedidoEncomienda extends Pedido implements Despachable, Cancelable, Rastreable {
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido de encomienda: asignando repartidor disponible.");
    }
    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("Pedido de encomienda asignado al repartidor: " + nombre);
    }
    @Override
    public double calcularTiempoEntrega() {
        return getDistanciaKm() * 4;
    }
    @Override
    public void despachar() {
        System.out.println("Encomienda despachada.");
    }
    @Override
    public void cancelar() {
        System.out.println("Encomienda cancelada.");
    }
    @Override
    public void verHistorial() {
        System.out.println("Historial de la encomienda #" + getIdPedido());
    }
}