/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3real.interfazGrafica;

import javax.swing.*;
import java.awt.event.*;

public class MenuRecitalGUI {
    private JTextField nombreCompradorField; // Campo para ingresar nombre de comprador

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuRecitalGUI gui = new MenuRecitalGUI();
                gui.createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Sistema de Gestión de Recital");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Menú:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);
        
        JTextField nombreCompradorField = new JTextField(); // Campo para ingresar nombre de comprador
        nombreCompradorField.setBounds(200, 50, 150, 25);
        panel.add(nombreCompradorField);

        JButton comprarButton = new JButton("Comprar entrada");
        comprarButton.setBounds(30, 50, 150, 25);
        panel.add(comprarButton);

        JButton realizarPagoButton = new JButton("Realizar pago");
        realizarPagoButton.setBounds(10, 80, 150, 25);
        panel.add(realizarPagoButton);

        JButton consultarSaldoButton = new JButton("Consultar saldo");
        consultarSaldoButton.setBounds(10, 110, 150, 25);
        panel.add(consultarSaldoButton);

        JButton verEntradasButton = new JButton("Ver entradas compradas");
        verEntradasButton.setBounds(10, 140, 180, 25);
        panel.add(verEntradasButton);

        JButton cancelarEntradaButton = new JButton("Cancelar entrada");
        cancelarEntradaButton.setBounds(10, 170, 150, 25);
        panel.add(cancelarEntradaButton);

        JButton salirButton = new JButton("Salir");
        salirButton.setBounds(10, 200, 150, 25);
        panel.add(salirButton);

        comprarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Precio de la entrada: 10000 CLP\nIngrese el nombre del comprador (zatiel, angel, miguel)");
            }
        });

        realizarPagoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Realizar pago");
            }
        });

        consultarSaldoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreConsultar = JOptionPane.showInputDialog("Ingrese el nombre del comprador para consultar el saldo (zatiel, angel, miguel, vendedor)");
                JOptionPane.showMessageDialog(null, "Consultar saldo para: " + nombreConsultar);
            }
        });

        verEntradasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ver entradas compradas");
            }
        });

        cancelarEntradaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreCancelar = JOptionPane.showInputDialog("Ingrese el nombre del comprador para cancelar la entrada");
                JOptionPane.showMessageDialog(null, "Cancelar entrada para: " + nombreCancelar);
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                System.exit(0);
            }
        });
        
        comprarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreComprador = nombreCompradorField.getText();
                if (!nombreComprador.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Entrada comprada por: " + nombreComprador);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del comprador.");
                }
            }
        });
    }
}