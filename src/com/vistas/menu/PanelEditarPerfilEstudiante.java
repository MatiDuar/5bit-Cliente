package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import rojeru_san.rsdate.RSYearDate;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelEditarPerfilEstudiante extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEditarPerfilEstudiante() {
		setLayout(null);
		
		RSYearDate yearDate = new RSYearDate();
		yearDate.setColorBackground(new Color(52, 152, 219));
		yearDate.setBounds(98, 10, 250, 42);
		add(yearDate);
		
		JLabel lblAoDeIngreso = new JLabel("Año de ingreso");
		lblAoDeIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAoDeIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAoDeIngreso.setBounds(10, 17, 86, 14);
		add(lblAoDeIngreso);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("a la carrera *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(10, 32, 86, 14);
		add(lblTelefonoDeContacto_1);

	}
}
