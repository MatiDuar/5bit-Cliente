package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vistas.PanelRegistroPag;

import RSMaterialComponent.RSTextFieldIconDos;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionDeUsuario extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public GestionDeUsuario() {

		setBounds(0, 0, 700, 705);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 561, 498);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Documento", "Etc", "Etc"
			}
		));
		scrollPane.setViewportView(table);
		
		RSButtonHover btnModificar = new RSButtonHover();
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnModificar.setText("Modificar");
		btnModificar.setBounds(581, 287, 109, 40);
		add(btnModificar);
		
		RSButtonHover btnFicha = new RSButtonHover();
		btnFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFicha.setText("Ficha");
		btnFicha.setBounds(581, 170, 109, 40);
		add(btnFicha);
		
		RSTextFieldIconDos textFieldBuscador = new RSTextFieldIconDos();
		textFieldBuscador.setIcons(ICONS.SEARCH);
		textFieldBuscador.setBounds(10, 118, 260, 42);
		add(textFieldBuscador);
		
		RSComboBox comboBoxFiltro1 = new RSComboBox();
		comboBoxFiltro1.setBounds(280, 118, 140, 42);
		add(comboBoxFiltro1);
		
		RSComboBox comboBoxFiltro2 = new RSComboBox();
		comboBoxFiltro2.setBounds(430, 118, 140, 42);
		add(comboBoxFiltro2);
		
		JLabel lblNewLabel_2_1 = new JLabel("LISTADO DE USUARIOS");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(236, 23, 227, 27);
		add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(Diseño.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		add(labelImage_1);
		
		RSButtonHover btnEliminar = new RSButtonHover();
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setBounds(581, 413, 109, 40);
		add(btnEliminar);
	}

}
