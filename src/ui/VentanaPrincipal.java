package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class VentanaPrincipal extends JFrame {
    public static List<Pedido> listaPedidos = new ArrayList<>();

    private JButton btnRegistrarPedido;
    private JButton btnListarPedidos;
    private JButton btnRegistrarRepartidor;
    private JButton btnListarRepartidores;
    private JButton btnEntrega;

    public VentanaPrincipal() {
        setTitle("SpeedFast - Gestion de Entregas");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        btnRegistrarPedido = new JButton("Registrar pedido");
        btnListarPedidos = new JButton("Listar pedidos desde BD");
        btnRegistrarRepartidor = new JButton("Registrar repartidor");
        btnListarRepartidores = new JButton("Listar repartidores");
        btnEntrega = new JButton("Asignar repartidor / Iniciar entrega");

        panel.add(btnRegistrarPedido);
        panel.add(btnListarPedidos);
        panel.add(btnRegistrarRepartidor);
        panel.add(btnListarRepartidores);
        panel.add(btnEntrega);

        add(panel, BorderLayout.CENTER);

        btnRegistrarPedido.addActionListener(e ->
                new VentanaRegistroPedido().setVisible(true));

        btnListarPedidos.addActionListener(e ->
                new VentanaListaPedidos().setVisible(true));

        btnRegistrarRepartidor.addActionListener(e ->
                new VentanaRegistroRepartidor().setVisible(true));

        btnListarRepartidores.addActionListener(e ->
                new VentanaListaRepartidores().setVisible(true));

        btnEntrega.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "La funcionalidad de entrega se mantiene disponible para integrar el DAO de entregas.",
                        "SpeedFast",
                        JOptionPane.INFORMATION_MESSAGE
                ));
    }
}
