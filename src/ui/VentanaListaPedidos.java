package ui;

import dao.PedidoDAO;
import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private final DefaultTableModel modelo;
    private final PedidoDAO pedidoDAO = new PedidoDAO();

    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos - SpeedFast");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel(
                new Object[]{"ID", "Direccion", "Tipo", "Estado"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarPedidos());

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnActualizar);
        add(panelInferior, BorderLayout.SOUTH);

        cargarPedidos();
    }

    private void cargarPedidos() {
        modelo.setRowCount(0);

        List<Pedido> pedidos = pedidoDAO.listarTodos();

        for (Pedido pedido : pedidos) {
            String tipo = pedido.getClass().getSimpleName()
                    .replace("Pedido", "")
                    .toUpperCase();

            modelo.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    tipo,
                    pedido.getEstado()
            });
        }
    }
}
