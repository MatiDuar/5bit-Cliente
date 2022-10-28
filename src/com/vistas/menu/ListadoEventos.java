package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSComboBox;
import RSMaterialComponent.RSTextFieldIconDos;
import rojeru_san.efectos.ValoresEnum.ICONS;

public class ListadoEventos extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListadoEventos() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 561, 444);
		add(scrollPane);
		
		RSButtonHover btnModificar = new RSButtonHover();
		btnModificar.setText("Modificar");
		btnModificar.setBounds(581, 179, 109, 40);
		add(btnModificar);
		
		RSComboBox comboBoxFiltro2 = new RSComboBox();
		comboBoxFiltro2.setBounds(430, 10, 140, 42);
		add(comboBoxFiltro2);
		
		RSComboBox comboBoxFiltro1 = new RSComboBox();
		comboBoxFiltro1.setBounds(280, 10, 140, 42);
		add(comboBoxFiltro1);
		
		RSTextFieldIconDos textFieldBuscador = new RSTextFieldIconDos();
		textFieldBuscador.setIcons(ICONS.SEARCH);
		textFieldBuscador.setBounds(10, 10, 260, 42);
		add(textFieldBuscador);
		
		RSButtonHover btnEliminar = new RSButtonHover();
		btnEliminar.setText("Eliminar");
		btnEliminar.setBounds(581, 305, 109, 40);
		add(btnEliminar);

	}
}
