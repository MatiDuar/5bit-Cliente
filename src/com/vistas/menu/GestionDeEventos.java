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
import rojeru_san.rsdate.RSDateChooser;
import rojerusan.RSCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionDeEventos extends JPanel {
	private JTable table;
	
	
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
		labelImage_1.setIcon(new ImageIcon(GestionDeEventos.class.getResource("/com/vistas/img/UTEC.png")));
//		labelImage_1.setIcon(new ImageIcon(Diseño.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		add(labelImage_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 561, 357);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		RSDateChooser dateChooserFechaInicio = new RSDateChooser();
		dateChooserFechaInicio.setPlaceholder("Fecha desde");
		dateChooserFechaInicio.setBounds(15, 116, 159, 32);
		add(dateChooserFechaInicio);
		
		RSDateChooser dateChooserFechaHasta = new RSDateChooser();
		dateChooserFechaHasta.setPlaceholder("Fecha hasta");
		dateChooserFechaHasta.setBounds(184, 116, 150, 32);
		add(dateChooserFechaHasta);
		
		JLabel lblNewLabel = new JLabel("Tipo Evento");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(17, 174, 61, 13);
		add(lblNewLabel);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setColorBoton(Color.WHITE);
		comboBox.setBounds(17, 191, 121, 32);
		add(comboBox);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(155, 174, 45, 13);
		add(lblEstado);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setColorBoton(Color.WHITE);
		comboBox_1.setBounds(155, 191, 121, 32);
		add(comboBox_1);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setColorBoton(Color.WHITE);
		comboBox_2.setBounds(293, 191, 121, 32);
		add(comboBox_2);
		
		RSComboBox comboBox_1_1 = new RSComboBox();
		comboBox_1_1.setColorBoton(Color.WHITE);
		comboBox_1_1.setBounds(431, 191, 121, 32);
		add(comboBox_1_1);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(581, 191, 108, 33);
		add(btnhvrFiltrar);
		
		JLabel lblNewLabel_1 = new JLabel("ITR");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(293, 175, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblEstado_1 = new JLabel("Modalidad");
		lblEstado_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado_1.setBounds(431, 175, 52, 13);
		add(lblEstado_1);
		
		RSButtonHover btnhvrModificar = new RSButtonHover();
		btnhvrModificar.setText("Modificar");
		btnhvrModificar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrModificar.setBackground(new Color(0, 112, 192));
		btnhvrModificar.setBounds(581, 435, 108, 33);
		add(btnhvrModificar);
		
		RSButtonHover btnhvrEliminar = new RSButtonHover();
		btnhvrEliminar.setText("Eliminar");
		btnhvrEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrEliminar.setBackground(new Color(0, 112, 192));
		btnhvrEliminar.setBounds(581, 557, 108, 33);
		add(btnhvrEliminar);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblFechaDeInicio.setBounds(17, 92, 77, 13);
		add(lblFechaDeInicio);
		
		RSCheckBox chckbxFechaExacta = new RSCheckBox();
		chckbxFechaExacta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxFechaExacta.isSelected()) {
					dateChooserFechaHasta.setVisible(false);
					dateChooserFechaInicio.setPlaceholder("Fecha");
					dateChooserFechaInicio.repaint();					
				}else {
					dateChooserFechaHasta.setVisible(true);
					dateChooserFechaInicio.setPlaceholder("Fecha desde");
					dateChooserFechaInicio.repaint();
				}
			}
		});
		chckbxFechaExacta.setText("Fecha Exacta");
		chckbxFechaExacta.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxFechaExacta.setBounds(100, 79, 180, 40);
		add(chckbxFechaExacta);
		
		RSButtonHover btnhvrAlta = new RSButtonHover();
		btnhvrAlta.setText("Alta");
		btnhvrAlta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAlta.setBackground(new Color(0, 112, 192));
		btnhvrAlta.setBounds(581, 313, 108, 33);
		add(btnhvrAlta);
		
		RSButtonHover btnhvrConvocatoriaDeEvento = new RSButtonHover();
		btnhvrConvocatoriaDeEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameConvocatoriaEvento frameConvocatoriaEvento= new FrameConvocatoriaEvento();
				frameConvocatoriaEvento.setVisible(true);
			}
		});
		btnhvrConvocatoriaDeEvento.setText("Convocatoria de Evento");
		btnhvrConvocatoriaDeEvento.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrConvocatoriaDeEvento.setBackground(new Color(0, 112, 192));
		btnhvrConvocatoriaDeEvento.setBounds(236, 609, 227, 33);
		add(btnhvrConvocatoriaDeEvento);
		
	}
}
