package com.vistas;

import javax.swing.JPanel;
import rojeru_san.rsdate.RSDateChooser;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import RSMaterialComponent.RSLabelTextIcon;
import rojeru_san.efectos.ValoresEnum.ICONS;

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
		
		RSDateChooser dateChooserAnoIngreso = new RSDateChooser();
		dateChooserAnoIngreso.setBounds(0, 36, 250, 42);
		dateChooserAnoIngreso.setColorBackground(new Color(52, 152, 219));
		add(dateChooserAnoIngreso);
	}
	
	public static PanelRegistroEstudiante getInstancia(){
		return instancia;
	}
}
