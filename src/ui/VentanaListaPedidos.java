package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.Pedido;

public class VentanaListaPedidos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos - SpeedFast");
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Direccion");
        modelo.addColumn("Distancia (km)");
        modelo.addColumn("Tipo");
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        cargarPedidos();
    }
    private void cargarPedidos() {
        modelo.setRowCount(0);
        for (Pedido pedido : VentanaPrincipal.listaPedidos) {
            String tipo = pedido.getClass().getSimpleName();
            modelo.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    pedido.getDistanciaKm(),
                    tipo
            });
        }
    }
}
