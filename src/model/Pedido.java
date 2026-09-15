package model;

public abstract class Pedido {
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected EstadoPedido estado;
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.PENDIENTE;
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
    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    public void setEstado(String nuevoEstado) {
        this.estado = EstadoPedido.valueOf(nuevoEstado);
    }
    public void mostrarResumen() {
        System.out.println(
                "Pedido #" + idPedido +
                        " | Direccion: " + direccionEntrega +
                        " | Distancia: " + distanciaKm + " km" +
                        " | Estado: " + estado
        );
    }
    public abstract int calcularTiempoEntrega();
}