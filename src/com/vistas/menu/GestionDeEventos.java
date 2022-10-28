package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import RSMaterialComponent.RSTextFieldIconDos;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;
import rojeru_san.rslabel.RSLabelBorder;
import RSComponentShade.RSToggleButtonRippleShade;
import RSComponentShade.RSToggleButtonShade;
import rojerusan.RSMenuBar;
import javax.swing.JButton;
import RSComponentShade.RSToggleButtonShade.THEMETOOLTIP;

public class GestionDeEventos extends JPanel {
	private RSButtonHover btnhvrListadoDeEventos;
	private RSButtonHover btnhvrConvocatoriaAEventos;
	private JPanel panelDinamico;
	
	
	/**
	 * Create the panel.
	 */
	public GestionDeEventos() {
		setBounds(0, 0, 700, 705);
		setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("GESTION DE EVENTOS");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(236, 23, 227, 27);
		add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
//		labelImage_1.setIcon(new ImageIcon(Diseño.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		add(labelImage_1);
		
		btnhvrConvocatoriaAEventos = new RSButtonHover();
		btnhvrConvocatoriaAEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colores botones
				btnhvrConvocatoriaAEventos.setBackground(new Color(0,160,255));
				btnhvrListadoDeEventos.setBackground(new Color(0,112,192));
				//mostrar Panel

				
			}
		});
		btnhvrConvocatoriaAEventos.setText("CONVOCATORIA A EVENTOS");
		btnhvrConvocatoriaAEventos.setBounds(357, 93, 325, 40);
		add(btnhvrConvocatoriaAEventos);
		
		btnhvrListadoDeEventos = new RSButtonHover();
		btnhvrListadoDeEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colores botones
				btnhvrConvocatoriaAEventos.setBackground(new Color(0,112,192));
				btnhvrListadoDeEventos.setBackground(new Color(0,160,255));
				//mostrar Panel
				ListadoEventos panelListadoEventos = new ListadoEventos();
				panelDinamico.removeAll();
				panelDinamico.setLayout(null);
				panelListadoEventos.setSize(1, 1);
				panelListadoEventos.setLocation(348, 5);
				panelDinamico.add(panelListadoEventos);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		btnhvrListadoDeEventos.setBackground(new Color(0,160,255));
		btnhvrListadoDeEventos.setText("LISTADO DE EVENTOS");
		btnhvrListadoDeEventos.setBounds(16, 93, 325, 40);
		add(btnhvrListadoDeEventos);
		
		panelDinamico = new JPanel();
		panelDinamico.setBounds(0, 153, 697, 514);
		add(panelDinamico);
		
		ListadoEventos panelListadoEventos = new ListadoEventos();
		panelDinamico.removeAll();
		panelDinamico.setLayout(null);
		panelListadoEventos.setSize(1, 1);
		panelListadoEventos.setLocation(348, 5);
		panelDinamico.add(panelListadoEventos);
		panelDinamico.revalidate();
		panelDinamico.repaint();
		
	}
}
