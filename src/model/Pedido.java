package model;

public class Pedido {
    private int idPedido;
    private String direccionEntrega;
    private String tipoPedido;
public void asignarRepartidor() {
System.out.println("Asignando repartidor...");
}
public void asignarRepartidor(String nombreRepartidor) {
    System.out.println("Repartidor: " + nombreRepartidor);
}
}
