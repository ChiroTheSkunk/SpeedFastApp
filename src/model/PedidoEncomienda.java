package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {
    private String tipoEncomienda;
    public PedidoEncomienda(int idPedido, String direccionEntrega,
                            double distanciaKm, String tipoEncomienda) {

        super(idPedido, direccionEntrega, distanciaKm);
        this.tipoEncomienda = tipoEncomienda;
    }
    @Override
    public int calcularTiempoEntrega() {
        return (int) (distanciaKm * 4) + 20;
    }
    @Override
    public void despachar() {
        System.out.println("Encomienda despachada. Tipo: " + tipoEncomienda);
    }
    @Override
    public void cancelar() {
        System.out.println("Encomienda #" + idPedido + " cancelada.");
    }
    @Override
    public void rastrear() {
        System.out.println("Rastreando encomienda #" + idPedido);
    }
    @Override
    public void mostrarResumen() {
        System.out.println(
                "Pedido Encomienda #" + idPedido +
                        " | Tipo: " + tipoEncomienda +
                        " | Direccion: " + direccionEntrega +
                        " | Distancia: " + distanciaKm + " km"
        );
    }
}