package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class VentanaPrincipal extends JFrame {
    public static List<Pedido> listaPedidos = new ArrayList<>();
    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnEntrega;
    public VentanaPrincipal() {
        setTitle("SpeedFast - Gestion de Entregas");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        btnRegistrar = new JButton("Registrar pedido");
        btnListar = new JButton("Listar pedidos");
        btnEntrega = new JButton("Asignar repartidor / Iniciar entrega");
        panel.add(btnRegistrar);
        panel.add(btnListar);
        panel.add(btnEntrega);
        add(panel, BorderLayout.CENTER);
        btnRegistrar.addActionListener(e -> {
            new VentanaRegistroPedido().setVisible(true);
        });
        btnListar.addActionListener(e -> {
            new VentanaListaPedidos().setVisible(true);
        });
        btnEntrega.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Entrega iniciada correctamente.",
                    "SpeedFast",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
    }
}