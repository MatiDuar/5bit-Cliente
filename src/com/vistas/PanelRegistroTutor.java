package com.vistas;

import javax.swing.JPanel;
import rojeru_san.rsdate.RSDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import rojerusan.RSComboBox;
import java.awt.Color;
import rojeru_san.rsfield.RSTextFull;

public class PanelRegistroTutor extends JPanel {

	private static PanelRegistroTutor instancia = new PanelRegistroTutor();
	/**
	 * Create the panel.
	 */
	public PanelRegistroTutor() {

		setLayout(null);
		setBounds(100, 100, 571, 187);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Rol");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(321, 11, 61, 14);
		add(lblNewLabel_1_2_2);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setFont(new Font("Lato", Font.BOLD, 14));
		comboBox_2.setColorFondo(new Color(52, 152, 219));
		comboBox_2.setBounds(321, 36, 250, 42);
		add(comboBox_2);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Lato", Font.PLAIN, 11));
		lblArea.setBounds(0, 11, 61, 14);
		add(lblArea);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setMostrarBoton(false);
		textNombre1.setFont(new Font("Lato", Font.BOLD, 14));
		textNombre1.setPlaceholder("Ingrese Area...");
		textNombre1.setBounds(0, 36, 250, 42);
		add(textNombre1);
	}
	public static PanelRegistroTutor getInstancia(){
		return instancia;
	}
}
