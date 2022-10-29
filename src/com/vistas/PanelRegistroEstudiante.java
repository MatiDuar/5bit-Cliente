package com.vistas;

import javax.swing.JPanel;
import rojeru_san.rsdate.RSDateChooser;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import RSMaterialComponent.RSLabelTextIcon;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rsdate.RSYearDate;

public class PanelRegistroEstudiante extends JPanel {

	public static RSYearDate yearDate = new RSYearDate();
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
		
		yearDate = new RSYearDate();
		yearDate.setColorBackground(new Color(52, 152, 219));
		yearDate.setBounds(0, 35, 250, 40);
		add(yearDate);
	}
	
	public static PanelRegistroEstudiante getInstancia(){
		return instancia;
	}
}
