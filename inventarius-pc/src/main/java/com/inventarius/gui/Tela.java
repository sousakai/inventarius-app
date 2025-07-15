package com.inventarius.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JFrame frame = this;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloInventarius = new JLabel("INVENTARIUS");
		tituloInventarius.setBounds(217, 36, 215, 37);
		tituloInventarius.setFont(new Font("Arial Black", Font.BOLD, 26));
		tituloInventarius.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(tituloInventarius);
		
		JLabel lblKayke = new JLabel("Kayke @ 2025");
		lblKayke.setVerticalAlignment(SwingConstants.TOP);
		lblKayke.setHorizontalAlignment(SwingConstants.CENTER);
		lblKayke.setFont(new Font("Baskerville Old Face", Font.ITALIC, 15));
		lblKayke.setBounds(228, 353, 185, 22);
		contentPane.add(lblKayke);
		
		JButton btnInicio = new JButton("Iniciar");
		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				frame.dispose();
			}
		});
		btnInicio.setBounds(248, 172, 149, 58);
		contentPane.add(btnInicio);
	}
}
