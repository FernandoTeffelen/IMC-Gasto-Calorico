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

public class TelaIMC extends JDialog {
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnCalcular;
    private JLabel lblResultado;
    private JLabel lblInterpretacao;

    public TelaIMC(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setTitle("Cálculo do IMC");

        lblPeso = new JLabel("Peso (kg):");
        lblAltura = new JLabel("Altura (m):");
        txtPeso = new JTextField(10);
        txtAltura = new JTextField(10);
        btnCalcular = new JButton("Calcular");
        lblResultado = new JLabel("Resultado:");
        lblInterpretacao = new JLabel();

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calcularIMC();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeso)
                    .addComponent(lblAltura))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPeso, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txtAltura))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblResultado)
                        .addGap(97, 97, 97))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInterpretacao)
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAltura)
                    .addComponent(txtAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultado)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInterpretacao)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            double imc = peso / (altura * altura);
            lblResultado.setText("Resultado: " + String.format("%.2f", imc));
            if (imc < 18.5)
                lblInterpretacao.setText("Magreza");
            else if (imc < 25)
                lblInterpretacao.setText("Normal");
            else if (imc < 30)
                lblInterpretacao.setText("Sobrepeso");
            else if (imc < 40)
                lblInterpretacao.setText("Obesidade");
            else
                lblInterpretacao.setText("Obesidade grave");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

