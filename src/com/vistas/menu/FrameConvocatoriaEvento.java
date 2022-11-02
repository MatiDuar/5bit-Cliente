package com.vistas.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import rojerusan.RSComboBox;
import rojeru_san.complementos.RSButtonHover;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameConvocatoriaEvento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConvocatoriaEvento frame = new FrameConvocatoriaEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameConvocatoriaEvento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 711, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("CONVOCATORIA DE EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(202, 10, 281, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 142, 569, 207);
		contentPane.add(scrollPane);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setBounds(17, 73, 121, 32);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(17, 56, 45, 13);
		contentPane.add(lblNewLabel);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setBounds(155, 73, 121, 32);
		contentPane.add(comboBox_1);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(155, 56, 45, 13);
		contentPane.add(lblEstado);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setBounds(293, 73, 121, 32);
		contentPane.add(comboBox_2);
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblTipoUsuario.setBounds(293, 56, 78, 13);
		contentPane.add(lblTipoUsuario);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(569, 73, 108, 33);
		contentPane.add(btnhvrFiltrar);
		
		RSComboBox comboBox_2_1 = new RSComboBox();
		comboBox_2_1.setBounds(431, 73, 121, 32);
		contentPane.add(comboBox_2_1);
		
		JLabel lblGeneracionEstudiante = new JLabel("Generaci\u00C3\u00B3n");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(431, 56, 78, 13);
		contentPane.add(lblGeneracionEstudiante);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_2_1_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 115, 281, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("ESTUDIANTES CONVOCADOS");
		lblNewLabel_2_1_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(10, 422, 298, 27);
		contentPane.add(lblNewLabel_2_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 451, 569, 207);
		contentPane.add(scrollPane_1);
		
		RSButtonHover btnhvrAgregar = new RSButtonHover();
		btnhvrAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnhvrAgregar.setText("Agregar");
		btnhvrAgregar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAgregar.setBackground(new Color(0, 112, 192));
		btnhvrAgregar.setBounds(585, 222, 108, 33);
		contentPane.add(btnhvrAgregar);
		
		RSButtonHover btnhvrEliminar = new RSButtonHover();
		btnhvrEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnhvrEliminar.setText("Eliminar");
		btnhvrEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrEliminar.setBackground(new Color(0, 112, 192));
		btnhvrEliminar.setBounds(585, 600, 108, 33);
		contentPane.add(btnhvrEliminar);
		
		RSComboBox comboBox_3 = new RSComboBox();
		comboBox_3.setBounds(17, 379, 121, 32);
		contentPane.add(comboBox_3);
		
		RSComboBox comboBox_1_1 = new RSComboBox();
		comboBox_1_1.setBounds(155, 379, 121, 32);
		contentPane.add(comboBox_1_1);
		
		RSComboBox comboBox_2_2 = new RSComboBox();
		comboBox_2_2.setBounds(293, 379, 121, 32);
		contentPane.add(comboBox_2_2);
		
		RSComboBox comboBox_2_1_1 = new RSComboBox();
		comboBox_2_1_1.setBounds(431, 379, 121, 32);
		contentPane.add(comboBox_2_1_1);
		
		RSButtonHover btnhvrFiltrar_1 = new RSButtonHover();
		btnhvrFiltrar_1.setText("Filtrar");
		btnhvrFiltrar_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar_1.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar_1.setBounds(569, 379, 108, 33);
		contentPane.add(btnhvrFiltrar_1);
		
		RSButtonHover btnhvrAsistencia = new RSButtonHover();
		btnhvrAsistencia.setText("Asistencia");
		btnhvrAsistencia.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAsistencia.setBackground(new Color(0, 112, 192));
		btnhvrAsistencia.setBounds(585, 498, 108, 33);
		contentPane.add(btnhvrAsistencia);
		
		JLabel lblGeneracionEstudiante_1 = new JLabel("Generaci\u00C3\u00B3n");
		lblGeneracionEstudiante_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante_1.setBounds(431, 362, 78, 13);
		contentPane.add(lblGeneracionEstudiante_1);
		
		JLabel lblTipoUsuario_1 = new JLabel("Tipo Usuario");
		lblTipoUsuario_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblTipoUsuario_1.setBounds(293, 362, 78, 13);
		contentPane.add(lblTipoUsuario_1);
		
		JLabel lblEstado_1 = new JLabel("Estado");
		lblEstado_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado_1.setBounds(155, 362, 45, 13);
		contentPane.add(lblEstado_1);
		
		JLabel lblNewLabel_1 = new JLabel("ITR");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(17, 362, 45, 13);
		contentPane.add(lblNewLabel_1);
	}
}
