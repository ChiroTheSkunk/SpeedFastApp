package model;

public abstract class Pedido {

    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }
    public int getIdPedido() {
        return idPedido;
    }
    public String getDireccionEntrega() {
        return direccionEntrega;
    }
    public double getDistanciaKm() {
        return distanciaKm;
    }
    public void mostrarResumen() {
        System.out.println(
                "Pedido #" + idPedido +
                        " | Dirección: " + direccionEntrega +
                        " | Distancia: " + distanciaKm + " km"
        );
    }
    public abstract int calcularTiempoEntrega();
}