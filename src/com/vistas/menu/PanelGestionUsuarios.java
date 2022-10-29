package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSMenuBar;
import javax.swing.JScrollPane;
import rojerusan.RSTableMetro;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSTableMetro.SELECTION_ROWS;
import rojerusan.RSTableMetro.POSITION_TEXT;
import rojerusan.RSTableMetro1;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import rojerusan.RSComboBox;
import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.efectos.ValoresEnum.ICONS;
import RSComponentShade.RSButtonRippleShade;
import necesario.MaterialButton;
import rojeru_san.complementos.RSButtonHover;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGestionUsuarios extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGestionUsuarios() {
		setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("GESTIÓN DE USUARIOS");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(251, 23, 222, 27);
		add(lblNewLabel_2);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(PanelGestionUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(639, 11, 51, 53);
		add(labelImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(7, 156, 568, 522);
		add(scrollPane);
		
		RSTableMetro tableMetro = new RSTableMetro();
		tableMetro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setGridColor(Color.DARK_GRAY);
		tableMetro.setColorBorderRows(Color.DARK_GRAY);
		tableMetro.setColorBorderHead(Color.DARK_GRAY);
		tableMetro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableMetro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula", "Fecha de Nacimiento", "Tel\u00E9fono", "Localidad", "Departamento", "Email Personal", "Email UTEC", "ITR", "Tipo Usuario", "Generaci\u00F3n Estudiante", "\u00C1rea Tutor", "Rol Tutor", "Estado"
			}
		));
		tableMetro.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(0).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableMetro.getColumnModel().getColumn(1).setMinWidth(120);
		tableMetro.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(2).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableMetro.getColumnModel().getColumn(3).setMinWidth(120);
		tableMetro.getColumnModel().getColumn(4).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(5).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(5).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(6).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(7).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(8).setPreferredWidth(95);
		tableMetro.getColumnModel().getColumn(8).setMinWidth(95);
		tableMetro.getColumnModel().getColumn(9).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(9).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(10).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(10).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(11).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(12).setPreferredWidth(90);
		tableMetro.getColumnModel().getColumn(12).setMinWidth(90);
		tableMetro.getColumnModel().getColumn(13).setPreferredWidth(150);
		tableMetro.getColumnModel().getColumn(13).setMinWidth(150);
		tableMetro.getColumnModel().getColumn(14).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(14).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(15).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(16).setPreferredWidth(80);
		tableMetro.getColumnModel().getColumn(16).setMinWidth(80);
		scrollPane.setViewportView(tableMetro);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setBounds(7, 113, 121, 32);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 96, 45, 13);
		add(lblNewLabel);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setBounds(155, 113, 121, 32);
		add(comboBox_1);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEstado.setBounds(158, 96, 45, 13);
		add(lblEstado);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setBounds(303, 113, 121, 32);
		add(comboBox_2);
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTipoUsuario.setBounds(306, 96, 78, 13);
		add(lblTipoUsuario);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(582, 113, 108, 33);
		add(btnhvrFiltrar);
		
		RSComboBox comboBox_2_1 = new RSComboBox();
		comboBox_2_1.setBounds(451, 113, 121, 32);
		add(comboBox_2_1);
		
		JLabel lblGeneracionEstudiante = new JLabel("Generación");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Lato", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(454, 96, 78, 13);
		add(lblGeneracionEstudiante);
		
		RSButtonHover btnhvrHabilitarUsuario = new RSButtonHover();
		btnhvrHabilitarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnhvrHabilitarUsuario.setText("Habilitar");
		btnhvrHabilitarUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrHabilitarUsuario.setBackground(new Color(0, 112, 192));
		btnhvrHabilitarUsuario.setBounds(585, 219, 108, 33);
		add(btnhvrHabilitarUsuario);
		
		RSButtonHover btnhvrModificarUsuario = new RSButtonHover();
		btnhvrModificarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificarDatosUsuarios modificarDatosUsuario = new ModificarDatosUsuarios();
				modificarDatosUsuario.panelDatosUsuario.datosAnalista();
				modificarDatosUsuario.setVisible(true);
			}
		});
		btnhvrModificarUsuario.setText("Modificar");
		btnhvrModificarUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificarUsuario.setBackground(new Color(0, 112, 192));
		btnhvrModificarUsuario.setBounds(585, 267, 108, 33);
		add(btnhvrModificarUsuario);
		
		RSButtonHover btnhvrEliminarUsuario = new RSButtonHover();
		btnhvrEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnhvrEliminarUsuario.setText("Eliminar");
		btnhvrEliminarUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrEliminarUsuario.setBackground(new Color(0, 112, 192));
		btnhvrEliminarUsuario.setBounds(585, 315, 108, 33);
		add(btnhvrEliminarUsuario);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(585, 598, 108, 33);
		add(btnhvrGuardar);
		
		RSButtonHover btnhvrCerrar = new RSButtonHover();
		btnhvrCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnhvrCerrar.setText("Cerrar");
		btnhvrCerrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCerrar.setBackground(new Color(0, 112, 192));
		btnhvrCerrar.setBounds(585, 646, 108, 33);
		add(btnhvrCerrar);
		
		RSButtonHover btnhvrMantenimientoListaItr = new RSButtonHover();
		btnhvrMantenimientoListaItr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MantenimientoListadoITR mantenerListaITR = new MantenimientoListadoITR();
				mantenerListaITR.setVisible(true);
			}
		});
		btnhvrMantenimientoListaItr.setText("Lista ITR");
		btnhvrMantenimientoListaItr.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrMantenimientoListaItr.setBackground(new Color(0, 112, 192));
		btnhvrMantenimientoListaItr.setBounds(585, 401, 108, 33);
		add(btnhvrMantenimientoListaItr);
		
		JLabel lblUsuarios = new JLabel("Acciones Usuarios");
		lblUsuarios.setFont(new Font("Lato", Font.BOLD, 11));
		lblUsuarios.setBounds(585, 198, 108, 13);
		add(lblUsuarios);
		
		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setFont(new Font("Lato", Font.BOLD, 11));
		lblMantenimiento.setBounds(585, 380, 108, 13);
		add(lblMantenimiento);
		
	}
}
