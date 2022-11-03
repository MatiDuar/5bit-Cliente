package com.vistas.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrameAsistenciaAEvento extends JFrame {

	private JPanel contentPane;
	private RSTableMetro table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAsistenciaAEvento frame = new FrameAsistenciaAEvento();
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
	public FrameAsistenciaAEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ASISTENCIA A  EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(161, 10, 227, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 163, 521, 393);
		contentPane.add(scrollPane);
		
		table = new RSTableMetro();
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setSelectedIndex(1);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Sin Registrar", "Asistencia ", "Media Asistencia", "Matutina", "Vespertina ", "Ausencia", "Ausencia Justificada"}));
			
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, comboBox_2.getSelectedItem()},
				{null, null, null, null, comboBox_2.getSelectedItem()},
				{null, null, null, null, comboBox_2.getSelectedItem()},
			},
			new String[] {
				"Nombre", "Apellido", "Cedula", "A\u00F1o Ingreso", "Asistencia"
			}
		));
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox_2));

		for(int i=0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setMinWidth(60);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
     
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setBounds(15, 94, 121, 32);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(15, 77, 45, 13);
		contentPane.add(lblNewLabel);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setBounds(151, 94, 121, 32);
		contentPane.add(comboBox_1);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(151, 77, 45, 13);
		contentPane.add(lblEstado);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(423, 93, 108, 33);
		contentPane.add(btnhvrFiltrar);
		
		RSComboBox comboBox_2_1 = new RSComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"Sin Asignar", "Asistencia ", "Media Asistencia", "Matutina", "Vespertina ", "Ausencia", "Ausencia Justificada"}));
		comboBox_2_1.setBounds(287, 94, 121, 32);
		contentPane.add(comboBox_2_1);
		
		JLabel lblGeneracionEstudiante = new JLabel("Generaci\u00f3n");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(287, 77, 78, 13);
		contentPane.add(lblGeneracionEstudiante);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_2_1_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 136, 281, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		
	}
}
