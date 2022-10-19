package com.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSTextFull;

public class PanelRegistroPag extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelRegistroPag() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO USUARIO");
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		lblNewLabel.setBounds(116, 11, 478, 58);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre 1");
		lblNewLabel_1_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(70, 89, 61, 14);
		add(lblNewLabel_1_2);
		
		RSTextFull textFull = new RSTextFull();
		textFull.setBounds(70, 114, 250, 42);
		add(textFull);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre 2");
		lblNewLabel_1_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(390, 89, 61, 14);
		add(lblNewLabel_1_2_1);
		
		RSTextFull textFull_1 = new RSTextFull();
		textFull_1.setBounds(390, 114, 250, 42);
		add(textFull_1);
		
		RSTextFull textFull_2 = new RSTextFull();
		textFull_2.setBounds(70, 192, 250, 42);
		add(textFull_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Apellido 1");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(70, 167, 61, 14);
		add(lblNewLabel_1_2_2);
		
		RSTextFull textFull_3 = new RSTextFull();
		textFull_3.setBounds(70, 270, 250, 42);
		add(textFull_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Documento");
		lblNewLabel_1_2_3.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_3.setBounds(70, 245, 61, 14);
		add(lblNewLabel_1_2_3);
		
		RSTextFull textFull_4 = new RSTextFull();
		textFull_4.setBounds(70, 348, 250, 42);
		add(textFull_4);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Email Personal");
		lblNewLabel_1_2_4.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_4.setBounds(70, 323, 77, 14);
		add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Apellido 2");
		lblNewLabel_1_2_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2_1.setBounds(390, 167, 61, 14);
		add(lblNewLabel_1_2_2_1);
		
		RSTextFull textFull_2_1 = new RSTextFull();
		textFull_2_1.setBounds(390, 192, 250, 42);
		add(textFull_2_1);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Usuario");
		lblNewLabel_1_2_3_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_3_1.setBounds(390, 245, 61, 14);
		add(lblNewLabel_1_2_3_1);
		
		RSTextFull textFull_3_1 = new RSTextFull();
		textFull_3_1.setBounds(390, 270, 250, 42);
		add(textFull_3_1);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Email UTEC");
		lblNewLabel_1_2_4_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_4_1.setBounds(390, 323, 61, 14);
		add(lblNewLabel_1_2_4_1);
		
		RSTextFull textFull_4_1 = new RSTextFull();
		textFull_4_1.setBounds(390, 348, 250, 42);
		add(textFull_4_1);
		
		RSButtonHover btnVolver = new RSButtonHover();
		btnVolver.setText("Volver");
		btnVolver.setFont(new Font("Lato", Font.BOLD, 14));
		btnVolver.setBackground(new Color(52, 152, 219));
		btnVolver.setBounds(70, 436, 172, 33);
		add(btnVolver);
		
		RSButtonHover btnRegistrarse = new RSButtonHover();
		btnRegistrarse.setText("Registrarse");
		btnRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		btnRegistrarse.setBackground(new Color(52, 152, 219));
		btnRegistrarse.setBounds(468, 436, 172, 33);
		add(btnRegistrarse);
		
		

	}
}
