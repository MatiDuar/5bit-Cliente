package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSComboBox;
import RSMaterialComponent.RSTextFieldIconDos;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rsdate.RSDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import rojerusan.RSRadioButton;
import rojerusan.RSCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelListadoEventos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelListadoEventos() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 561, 357);
		add(scrollPane);
		
		RSDateChooser dateChooserFechaInicio = new RSDateChooser();
		dateChooserFechaInicio.setColorBackground(new Color(52, 152, 219));
		dateChooserFechaInicio.setPlaceholder("Fecha desde");
		dateChooserFechaInicio.setBounds(15, 43, 159, 32);
		add(dateChooserFechaInicio);
		
		RSDateChooser dateChooserFechaHasta = new RSDateChooser();
		dateChooserFechaHasta.setColorBackground(new Color(52, 152, 219));
		dateChooserFechaHasta.setPlaceholder("Fecha hasta");
		dateChooserFechaHasta.setBounds(184, 43, 150, 32);
		add(dateChooserFechaHasta);
		
		JLabel lblNewLabel = new JLabel("Tipo Evento");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(17, 101, 61, 13);
		add(lblNewLabel);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setColorFondo(new Color(52, 152, 219));
		comboBox.setFont(new Font("Lato Black", Font.BOLD, 14));
		comboBox.setColorBoton(Color.WHITE);
		comboBox.setBounds(17, 118, 121, 32);
		add(comboBox);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(155, 101, 45, 13);
		add(lblEstado);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setColorFondo(new Color(52, 152, 219));
		comboBox_1.setFont(new Font("Lato Black", Font.BOLD, 14));
		comboBox_1.setColorBoton(Color.WHITE);
		comboBox_1.setBounds(155, 118, 121, 32);
		add(comboBox_1);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setColorFondo(new Color(52, 152, 219));
		comboBox_2.setFont(new Font("Lato Black", Font.BOLD, 14));
		comboBox_2.setColorBoton(Color.WHITE);
		comboBox_2.setBounds(293, 118, 121, 32);
		add(comboBox_2);
		
		RSComboBox comboBox_1_1 = new RSComboBox();
		comboBox_1_1.setColorFondo(new Color(52, 152, 219));
		comboBox_1_1.setFont(new Font("Lato Black", Font.BOLD, 14));
		comboBox_1_1.setColorBoton(Color.WHITE);
		comboBox_1_1.setBounds(431, 118, 121, 32);
		add(comboBox_1_1);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato Black", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(52, 152, 219));
		btnhvrFiltrar.setBounds(581, 118, 108, 33);
		add(btnhvrFiltrar);
		
		JLabel lblNewLabel_1 = new JLabel("ITR");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(293, 102, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblEstado_1 = new JLabel("Modalidad");
		lblEstado_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado_1.setBounds(431, 102, 52, 13);
		add(lblEstado_1);
		
		RSButtonHover btnhvrModificar = new RSButtonHover();
		btnhvrModificar.setText("Modificar");
		btnhvrModificar.setFont(new Font("Lato Black", Font.BOLD, 14));
		btnhvrModificar.setBackground(new Color(52, 152, 219));
		btnhvrModificar.setBounds(581, 362, 108, 33);
		add(btnhvrModificar);
		
		RSButtonHover btnhvrEliminar = new RSButtonHover();
		btnhvrEliminar.setText("Eliminar");
		btnhvrEliminar.setFont(new Font("Lato Black", Font.BOLD, 14));
		btnhvrEliminar.setBackground(new Color(52, 152, 219));
		btnhvrEliminar.setBounds(581, 484, 108, 33);
		add(btnhvrEliminar);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblFechaDeInicio.setBounds(17, 19, 77, 13);
		add(lblFechaDeInicio);
		
		RSCheckBox chckbxFechaExacta = new RSCheckBox();
		chckbxFechaExacta.setColorUnCheck(new Color(52, 152, 219));
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
		chckbxFechaExacta.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxFechaExacta.setText("Fecha Exacta");
		chckbxFechaExacta.setBounds(100, 6, 180, 40);
		add(chckbxFechaExacta);
		
		RSButtonHover btnhvrAlta = new RSButtonHover();
		btnhvrAlta.setText("Alta");
		btnhvrAlta.setFont(new Font("Lato Black", Font.BOLD, 14));
		btnhvrAlta.setBackground(new Color(52, 152, 219));
		btnhvrAlta.setBounds(581, 240, 108, 33);
		add(btnhvrAlta);

	}
}
