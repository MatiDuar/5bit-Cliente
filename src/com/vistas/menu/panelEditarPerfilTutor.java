package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import rojerusan.RSComboBox;
import java.awt.Color;

public class panelEditarPerfilTutor extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelEditarPerfilTutor() {
		setLayout(null);
		
		JLabel lblAreaTutor = new JLabel("Área*");
		lblAreaTutor.setBounds(5, 77, 78, 14);
		lblAreaTutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAreaTutor.setFont(new Font("Lato", Font.PLAIN, 11));
		add(lblAreaTutor);
		
		RSComboBox comboBoxRolTutor = new RSComboBox();
		comboBoxRolTutor.setBounds(93, 10, 250, 42);
		comboBoxRolTutor.setColorFondo(new Color(52, 152, 219));
		add(comboBoxRolTutor);
		
		RSComboBox comboBoxAreaTutor = new RSComboBox();
		comboBoxAreaTutor.setColorFondo(new Color(52, 152, 219));
		comboBoxAreaTutor.setBounds(93, 62, 250, 42);
		add(comboBoxAreaTutor);
		
		JLabel lblRol = new JLabel("Rol*");
		lblRol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRol.setFont(new Font("Lato", Font.PLAIN, 11));
		lblRol.setBounds(5, 26, 78, 14);
		add(lblRol);

	}
}
