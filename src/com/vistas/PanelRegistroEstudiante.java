package com.vistas;

import javax.swing.JPanel;
import rojeru_san.rsdate.RSDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelRegistroEstudiante extends JPanel {

	
	private static PanelRegistroEstudiante instancia = new PanelRegistroEstudiante();
	/**
	 * Create the panel.
	 */
	public PanelRegistroEstudiante() {

		setLayout(null);
		
		
		JLabel lblAoDeIngreso = new JLabel("Año de Ingreso");
		lblAoDeIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAoDeIngreso.setBounds(0, 11, 100, 14);
		add(lblAoDeIngreso);
		
		RSDateChooser dateChooser = new RSDateChooser();
		dateChooser.setBounds(0, 36, 250, 42);
		add(dateChooser);
	}
	
	public static PanelRegistroEstudiante getInstancia(){
		return instancia;
	}
	
}
