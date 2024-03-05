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

public class TelaGastoCalorico extends JDialog {
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JLabel lblIdade;
    private JLabel lblNivelAtividade;
    private JLabel lblGenero;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JTextField txtIdade;
    private JRadioButton rdbHomem;
    private JRadioButton rdbMulher;
    private ButtonGroup generoGroup;
    private JComboBox<String> cmbNivelAtividade;
    private JButton btnCalcular;
    private JLabel lblGastoBasal;
    private JLabel lblGastoTotal;

    public TelaGastoCalorico(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setTitle("Gasto Calórico");

        lblPeso = new JLabel("Peso (kg):");
        lblAltura = new JLabel("Altura (cm):");
        lblIdade = new JLabel("Idade:");
        lblNivelAtividade = new JLabel("Nível de Atividade:");
        lblGenero = new JLabel("Gênero:");
        txtPeso = new JTextField(10);
        txtAltura = new JTextField(10);
        txtIdade = new JTextField(10);
        cmbNivelAtividade = new JComboBox<>(new String[]{"Sedentário", "Leve", "Moderado", "Ativo", "Extremamente ativo"});
        rdbHomem = new JRadioButton("Homem");
        rdbMulher = new JRadioButton("Mulher");
        generoGroup = new ButtonGroup();
        generoGroup.add(rdbHomem);
        generoGroup.add(rdbMulher);
        btnCalcular = new JButton("Calcular");
        lblGastoBasal = new JLabel("Gasto Basal:");
        lblGastoTotal = new JLabel("Gasto Total:");

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calcularGastoCalorico();
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
                    .addComponent(lblAltura)
                    .addComponent(lblIdade)
                    .addComponent(lblGenero)
                    .addComponent(lblNivelAtividade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPeso)
                    .addComponent(txtAltura)
                    .addComponent(txtIdade)
                    .addComponent(rdbHomem)
                    .addComponent(rdbMulher)
                    .addComponent(cmbNivelAtividade, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblGastoBasal)
                    .addComponent(lblGastoTotal))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivelAtividade)
                    .addComponent(cmbNivelAtividade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGenero)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbHomem)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbMulher)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbNivelAtividade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGastoBasal)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGastoTotal)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void calcularGastoCalorico() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText()) / 100; // Convertendo altura de cm para m
            int idade = Integer.parseInt(txtIdade.getText());
            double calBasal;

            if (peso <= 0 || altura <= 0 || idade <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para peso, altura e idade.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!rdbHomem.isSelected() && !rdbMulher.isSelected()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione o gênero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (rdbHomem.isSelected()) {
                calBasal = 66 + (13.8 * peso) + (5 * altura * 100) - (6.8 * idade);
            } else { // rdbMulher.isSelected() == true
                calBasal = 655 + (9.6 * peso) + (1.9 * altura * 100) - (4.7 * idade);
            }

            double calTotal;

            switch (cmbNivelAtividade.getSelectedIndex()) {
                case 0: // Sedentário
                    calTotal = calBasal * 1.2;
                    break;
                case 1: // Leve
                    calTotal = calBasal * 1.375;
                    break;
                case 2: // Moderado
                    calTotal = calBasal * 1.55;
                    break;
                case 3: // Ativo
                    calTotal = calBasal * 1.725;
                    break;
                case 4: // Extremamente Ativo
                    calTotal = calBasal * 1.9;
                    break;
                default:
                    calTotal = 0;
            }

            lblGastoBasal.setText("Gasto Basal: " + String.format("%.2f", calBasal));
            lblGastoTotal.setText("Gasto Total: " + String.format("%.2f", calTotal));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para peso, altura e idade.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
