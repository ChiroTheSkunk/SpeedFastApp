package model;
import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;
public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {
    private String establecimiento;
    public PedidoExpress(int idPedido, String direccionEntrega,
                         double distanciaKm, String establecimiento) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.establecimiento = establecimiento;
    }
    @Override
    public int calcularTiempoEntrega() {
        return (int) (distanciaKm * 3) + 10;
    }
    @Override
    public void despachar() {
        System.out.println(
                "Compra express despachada desde " + establecimiento
        );
    }
    @Override
    public void cancelar() {
        System.out.println("Pedido express #" + idPedido + " cancelado.");
    }
    @Override
    public void rastrear() {
        System.out.println("Rastreando pedido express #" + idPedido);
    }
    @Override
    public void mostrarResumen() {
        System.out.println(
                "Pedido Express #" + idPedido +
                        " | Establecimiento: " + establecimiento +
                        " | Direccion: " + direccionEntrega +
                        " | Distancia: " + distanciaKm + " km"
        );
    }
}
