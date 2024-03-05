/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade2;
import javax.swing.*;

/**
 *
 * @author Fernando T
 */

public class Atividade2 extends javax.swing.JFrame {

    public Atividade2() {
        initComponents();
    }

    private void initComponents() {
        jButtonIMC = new javax.swing.JButton();
        jButtonGastoCalorico = new javax.swing.JButton();
        jButtonRecomendacoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sindicato dos Nutricionistas");

        jButtonIMC.setText("IMC");
        jButtonIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIMCActionPerformed(evt);
            }
        });

        jButtonGastoCalorico.setText("Gasto Calórico");
        jButtonGastoCalorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGastoCaloricoActionPerformed(evt);
            }
        });

        jButtonRecomendacoes.setText("Recomendações");
        jButtonRecomendacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecomendacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonIMC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGastoCalorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRecomendacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButtonIMC)
                .addGap(18, 18, 18)
                .addComponent(jButtonGastoCalorico)
                .addGap(18, 18, 18)
                .addComponent(jButtonRecomendacoes)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonIMCActionPerformed(java.awt.event.ActionEvent evt) {
        TelaIMC telaIMC = new TelaIMC(this, true);

        telaIMC.setVisible(true);
    }

    private void jButtonGastoCaloricoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaGastoCalorico telaGastoCalorico = new TelaGastoCalorico(this, true);
        telaGastoCalorico.setVisible(true);
    }

    private void jButtonRecomendacoesActionPerformed(java.awt.event.ActionEvent evt) {
        TelaRecomendacoes telaRecomendacoes = new TelaRecomendacoes(this, true);
        telaRecomendacoes.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atividade2().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonGastoCalorico;
    private javax.swing.JButton jButtonIMC;
    private javax.swing.JButton jButtonRecomendacoes;
}

