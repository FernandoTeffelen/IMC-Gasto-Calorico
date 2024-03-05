/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Fernando T
 */

public class TelaRecomendacoes extends JDialog {
    private JLabel lblCalorias;
    private JTextField txtCalorias;
    private JButton btnCalcular;
    private JLabel lblCarboidratos;
    private JLabel lblProteinas;
    private JLabel lblGorduras;

    public TelaRecomendacoes(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setTitle("Recomendações");

        lblCalorias = new JLabel("Calorias:");
        txtCalorias = new JTextField(10);
        btnCalcular = new JButton("Calcular");
        lblCarboidratos = new JLabel("Carboidratos:");
        lblProteinas = new JLabel("Proteínas:");
        lblGorduras = new JLabel("Gorduras:");

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calcularRecomendacoes();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblCalorias)
                    .addComponent(lblCarboidratos)
                    .addComponent(lblProteinas)
                    .addComponent(lblGorduras))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCalorias, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnCalcular)
                    .addComponent(lblCarboidratos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProteinas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGorduras, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalorias)
                    .addComponent(txtCalorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalcular)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCarboidratos)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProteinas)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGorduras)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void calcularRecomendacoes() {
        try {
            double calorias = Double.parseDouble(txtCalorias.getText());
            double carboidratos = calorias * 0.5 / 4;
            double proteinas = calorias * 0.25 / 4;
            double gorduras = calorias * 0.25 / 9;

            lblCarboidratos.setText("Carboidratos: " + String.format("%.2f", carboidratos) + "g");
            lblProteinas.setText("Proteínas: " + String.format("%.2f", proteinas) + "g");
            lblGorduras.setText("Gorduras: " + String.format("%.2f", gorduras) + "g");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido para as calorias.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

