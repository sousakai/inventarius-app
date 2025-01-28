package com.inventarius.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        // Janela Principal
        JFrame frame = new JFrame("Inventarius - 0.05.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o app depois de fechar, para evitar execução indesejada em segundo plano.
        frame.setSize(400, 300); // Tamanho
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Painel para agrupar os componentes. Facilita na organização.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // Layout em grade
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens

        // JLabel = exibe texto.
        JLabel titleLabel = new JLabel("Bem-vindo ao Inventarius", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel);

        // Botões para cadastrar e listar materiais.
        JButton btnCadastro = new JButton("Cadastro de Materiais");
        btnCadastro.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCadastro.addActionListener(new ActionListener(){
            // ActionListener: adiciona ao botão um "ouvinte de evento', ou seja, quando ele for clicado, ocorrerá uma ação (dentro do actionPerformed).
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Abrir tela de cadastro");
            }
        });
        panel.add(btnCadastro);

        // Adiciona o painel ao JFrame
        frame.add(panel);

        // Tornar a janela visível
        frame.setVisible(true);  // Agora a janela é visível APÓS o painel ser adicionado.
    }
}
