package ui;

import javax.swing.*;
import java.awt.*;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtId;
    private JTextField txtDireccion;
    private JTextField txtDistancia;
    private JComboBox<String> comboTipo;
    private JButton btnGuardar;
    public VentanaRegistroPedido() {
        setTitle("Registrar Pedido - SpeedFast");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);
        panel.add(new JLabel("Direccion:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);
        panel.add(new JLabel("Distancia (km):"));
        txtDistancia = new JTextField();
        panel.add(txtDistancia);
        panel.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>();
        comboTipo.addItem("Comida");
        comboTipo.addItem("Encomienda");
        comboTipo.addItem("Express");
        panel.add(comboTipo);
        btnGuardar = new JButton("Guardar");
        panel.add(new JLabel(""));
        panel.add(btnGuardar);
        add(panel);
        btnGuardar.addActionListener(e -> guardarPedido());
    }
    private void guardarPedido() {
        try {
            if (txtId.getText().trim().isEmpty()
                    || txtDireccion.getText().trim().isEmpty()
                    || txtDistancia.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            int id = Integer.parseInt(txtId.getText().trim());
            String direccion = txtDireccion.getText().trim();
            double distancia = Double.parseDouble(
                    txtDistancia.getText().trim()
            );

            String tipo = comboTipo.getSelectedItem().toString();
            Pedido pedido;
            if (tipo.equals("Comida")) {
                pedido = new PedidoComida(
                        id,
                        direccion,
                        distancia,
                        "Pendiente"
                );
            } else if (tipo.equals("Encomienda")) {
                pedido = new PedidoEncomienda(
                        id,
                        direccion,
                        distancia,
                        "Pendiente"
                );
            } else {
                pedido = new PedidoExpress(
                        id,
                        direccion,
                        distancia,
                        "Pendiente"
                );
            }
            VentanaPrincipal.listaPedidos.add(pedido);
            JOptionPane.showMessageDialog(
                    this,
                    "Pedido registrado correctamente.",
                    "SpeedFast",
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtId.setText("");
            txtDireccion.setText("");
            txtDistancia.setText("");
            comboTipo.setSelectedIndex(0);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "ID y distancia deben ser valores numericos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}