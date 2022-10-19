package com.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import rojeru_san.rslabel.RSLabelImage;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rsfield.RSPassword;
import rojeru_san.complementos.RSButtonHover;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JPanel panelDinamico;
	PanelRegistroPag panelRegistroPag = new PanelRegistroPag();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDinamico = new JPanel();
		panelDinamico.setBounds(0, 0, 710, 495);
		contentPane.add(panelDinamico);
		panelDinamico.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO USUARIO");
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		lblNewLabel.setBounds(116, 11, 478, 58);
		panelDinamico.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre 1");
		lblNewLabel_1_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(70, 89, 61, 14);
		panelDinamico.add(lblNewLabel_1_2);
		
		RSTextFull textFull = new RSTextFull();
		textFull.setBounds(70, 114, 250, 42);
		panelDinamico.add(textFull);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre 2");
		lblNewLabel_1_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(390, 89, 61, 14);
		panelDinamico.add(lblNewLabel_1_2_1);
		
		RSTextFull textFull_1 = new RSTextFull();
		textFull_1.setBounds(390, 114, 250, 42);
		panelDinamico.add(textFull_1);
		
		RSTextFull textFull_2 = new RSTextFull();
		textFull_2.setBounds(70, 192, 250, 42);
		panelDinamico.add(textFull_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Apellido 1");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(70, 167, 61, 14);
		panelDinamico.add(lblNewLabel_1_2_2);
		
		RSTextFull textFull_3 = new RSTextFull();
		textFull_3.setBounds(70, 270, 250, 42);
		panelDinamico.add(textFull_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Documento");
		lblNewLabel_1_2_3.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_3.setBounds(70, 245, 61, 14);
		panelDinamico.add(lblNewLabel_1_2_3);
		
		RSTextFull textFull_4 = new RSTextFull();
		textFull_4.setBounds(70, 348, 250, 42);
		panelDinamico.add(textFull_4);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Localidad");
		lblNewLabel_1_2_4.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_4.setBounds(70, 323, 77, 14);
		panelDinamico.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Apellido 2");
		lblNewLabel_1_2_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2_1.setBounds(390, 167, 61, 14);
		panelDinamico.add(lblNewLabel_1_2_2_1);
		
		RSTextFull textFull_2_1 = new RSTextFull();
		textFull_2_1.setBounds(390, 192, 250, 42);
		panelDinamico.add(textFull_2_1);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_2_3_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_3_1.setBounds(390, 245, 61, 14);
		panelDinamico.add(lblNewLabel_1_2_3_1);
		
		RSTextFull textFull_3_1 = new RSTextFull();
		textFull_3_1.setBounds(390, 270, 250, 42);
		panelDinamico.add(textFull_3_1);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Departamento");
		lblNewLabel_1_2_4_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_4_1.setBounds(390, 323, 61, 14);
		panelDinamico.add(lblNewLabel_1_2_4_1);
		
		RSTextFull textFull_4_1 = new RSTextFull();
		textFull_4_1.setBounds(390, 348, 250, 42);
		panelDinamico.add(textFull_4_1);
		
		RSButtonHover btnhvrRegistrarse = new RSButtonHover();
		btnhvrRegistrarse.setText("Registrarse");
		btnhvrRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrRegistrarse.setBackground(new Color(52, 152, 219));
		btnhvrRegistrarse.setBounds(70, 436, 172, 33);
		panelDinamico.add(btnhvrRegistrarse);
		
		RSButtonHover btnhvrSiguiente = new RSButtonHover();
		btnhvrSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDinamico.removeAll();
				panelRegistroPag.setSize(710, 495);
				panelRegistroPag.setLocation(0, 0);
				panelDinamico.add(panelRegistroPag);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		btnhvrSiguiente.setText("Siguiente?");
		btnhvrSiguiente.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrSiguiente.setBackground(new Color(52, 152, 219));
		btnhvrSiguiente.setBounds(468, 436, 172, 33);
		panelDinamico.add(btnhvrSiguiente);
		
		JLabel lblNewLabel_1 = new JLabel("Son muchos datos, podriamos hacerlo en varias paginas");
		lblNewLabel_1.setBounds(372, 411, 268, 14);
		panelDinamico.add(lblNewLabel_1);
	}
}
