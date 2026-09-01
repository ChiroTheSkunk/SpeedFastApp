package model;

public abstract class Pedido {
    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;
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
        System.out.println("ID del pedido: " + idPedido);
        System.out.println("Direccion de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor automaticamente...");
    }
    public void asignarRepartidor(String nombre) {
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }
    public abstract double calcularTiempoEntrega();
}