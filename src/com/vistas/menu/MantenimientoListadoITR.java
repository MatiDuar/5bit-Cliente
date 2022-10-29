package com.vistas.menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import rojeru_san.rslabel.RSLabelImage;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import rojeru_san.complementos.TableMetro;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import rojeru_san.complementos.RSButtonHover;
import java.awt.Dimension;

public class MantenimientoListadoITR extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoListadoITR frame = new MantenimientoListadoITR();
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
	public MantenimientoListadoITR() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoListadoITR.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Mantenimiento Lista de ITR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LISTADO DE ITRs");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(120, 23, 145, 27);
		contentPane.add(lblNewLabel_2);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(MantenimientoListadoITR.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(304, 10, 51, 53);
		contentPane.add(labelImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.DARK_GRAY);
		scrollPane.setBounds(26, 79, 218, 256);
		contentPane.add(scrollPane);
		
		TableMetro tableMetro = new TableMetro();
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setColorBordeHead(Color.DARK_GRAY);
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableMetro.setColorBordeFilas(Color.DARK_GRAY);
		tableMetro.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableMetro.setFuenteFilasSelect(new Font("Tahoma", Font.PLAIN, 14));
		tableMetro.setFuenteHead(new Font("Tahoma", Font.BOLD, 14));
		tableMetro.setFuenteFilas(new Font("Tahoma", Font.PLAIN, 14));
		tableMetro.setAltoHead(30);
		tableMetro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Id", "Nombre"
			}
		));
		tableMetro.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableMetro.getColumnModel().getColumn(0).setMinWidth(40);
		scrollPane.setViewportView(tableMetro);
		
		RSButtonHover btnhvrCerrar = new RSButtonHover();
		btnhvrCerrar.setText("Cerrar");
		btnhvrCerrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCerrar.setBackground(new Color(0, 112, 192));
		btnhvrCerrar.setBounds(26, 370, 108, 33);
		contentPane.add(btnhvrCerrar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(254, 370, 108, 33);
		contentPane.add(btnhvrGuardar);
		
		RSButtonHover btnhvrEliminarITR = new RSButtonHover();
		btnhvrEliminarITR.setText("Eliminar");
		btnhvrEliminarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrEliminarITR.setBackground(new Color(0, 112, 192));
		btnhvrEliminarITR.setBounds(254, 209, 108, 33);
		contentPane.add(btnhvrEliminarITR);
		
		RSButtonHover btnhvrModificarITR = new RSButtonHover();
		btnhvrModificarITR.setText("Modificar");
		btnhvrModificarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificarITR.setBackground(new Color(0, 112, 192));
		btnhvrModificarITR.setBounds(254, 161, 108, 33);
		contentPane.add(btnhvrModificarITR);
		
		RSButtonHover btnhvrAgregarITR = new RSButtonHover();
		btnhvrAgregarITR.setText("Agregar");
		btnhvrAgregarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrAgregarITR.setBackground(new Color(0, 112, 192));
		btnhvrAgregarITR.setBounds(254, 113, 108, 33);
		contentPane.add(btnhvrAgregarITR);
		
		setLocationRelativeTo(null);

	}
}
