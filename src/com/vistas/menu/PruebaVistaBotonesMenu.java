package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import rojerusan.RSTableMetro;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSTableMetro1;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import RSComponentShade.RSButtonRippleShade;
import RSMaterialComponent.RSTextFieldIconUno;
import rojerusan.RSComboBox;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojerusan.RSMenuBar;

public class PruebaVistaBotonesMenu extends JPanel {
	
	private JTable tableUsuario;
	private DefaultTableModel modelo=new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public PruebaVistaBotonesMenu() {
		setLayout(null);
		setBounds(10, 48, 738, 654);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 560, 372);
		scrollPane.setAutoscrolls(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		
		tableUsuario = new JTable();
		tableUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		modelo.addColumn("ID");
		modelo.addColumn("Documento");
		modelo.addColumn("Apellido 1");
		modelo.addColumn("Apellido 2");
		modelo.addColumn("Nombre 1");
		modelo.addColumn("Nombre 2");
		modelo.addColumn("Fecha de Nacimiento");
		modelo.addColumn("Mail");
		modelo.addColumn("Rol");
		
		scrollPane.setViewportView(tableUsuario);
		
		RSButtonRippleShade btnrplshdBaja = new RSButtonRippleShade();
		btnrplshdBaja.setText("Baja");
		btnrplshdBaja.setBounds(580, 124, 142, 40);
		add(btnrplshdBaja);
		
		RSButtonRippleShade btnrplshdModificar = new RSButtonRippleShade();
		btnrplshdModificar.setText("Modificar");
		btnrplshdModificar.setBounds(580, 189, 142, 40);
		add(btnrplshdModificar);
		
		RSButtonRippleShade buttonRippleShade_2 = new RSButtonRippleShade();
		buttonRippleShade_2.setBounds(10, 504, 142, 40);
		add(buttonRippleShade_2);
		
		RSButtonRippleShade buttonRippleShade_3 = new RSButtonRippleShade();
		buttonRippleShade_3.setBounds(428, 504, 142, 40);
		add(buttonRippleShade_3);
		
		RSTextFieldIconUno textFieldIconUno = new RSTextFieldIconUno();
		textFieldIconUno.setIcons(ICONS.SEARCH);
		textFieldIconUno.setBounds(10, 55, 386, 42);
		add(textFieldIconUno);
		
		RSButtonRippleShade btnrplshdFiltrar = new RSButtonRippleShade();
		btnrplshdFiltrar.setText("Filtrar");
		btnrplshdFiltrar.setBounds(580, 55, 142, 40);
		add(btnrplshdFiltrar);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setBounds(400, 55, 170, 42);
		add(comboBox);

	}
}
