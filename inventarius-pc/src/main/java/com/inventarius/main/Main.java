package com.inventarius.main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inventarius v0.05.0");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 600);
            frame.setLayout(null);  // Desabilita o layout automático

            JLabel label = new JLabel("Teste de Tela OK!", SwingConstants.CENTER);
            frame.add(label);

            frame.setVisible(true);

            //Cria uma box para "conter" o texto.
            JPanel panel = new JPanel();
            panel.setBackground(Color.gray);
            panel.setBounds(150, 150, 400, 200); // Define a posição e tamanho do painel

            //Muda a cor do fundo para o azul em RGB.
            frame.getContentPane().setBackground(new Color(0, 51, 102));

            //Muda a cor do texto para branco.
            label.setForeground(Color.white);

            //Adiciona o JLabel dentro do JPanel
            panel.add(label);

            //Adiciona o JPanel ao JFrame
            frame.add(panel);
        });
    }
}
