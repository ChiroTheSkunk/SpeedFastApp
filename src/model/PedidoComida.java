package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {
    private String restaurante;
    public PedidoComida(int idPedido, String direccionEntrega,
                        double distanciaKm, String restaurante) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.restaurante = restaurante;
    }
    @Override
    public int calcularTiempoEntrega() {
        return (int) (distanciaKm * 5) + 15;
    }
    @Override
    public void despachar() {
        System.out.println("Pedido de comida despachado desde " + restaurante);
    }
    @Override
    public void cancelar() {
        System.out.println("Pedido de comida #" + idPedido + " cancelado.");
    }
    @Override
    public void rastrear() {
        System.out.println("Rastreando pedido de comida #" + idPedido);
    }
    @Override
    public void mostrarResumen() {
        System.out.println(
                "Pedido Comida #" + idPedido +
                        " | Restaurante: " + restaurante +
                        " | Direccion: " + direccionEntrega +
                        " | Distancia: " + distanciaKm + " km"
        );
    }
}