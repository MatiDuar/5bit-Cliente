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
import java.awt.SystemColor;
import rojerusan.RSComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		lblNewLabel_2.setBounds(100, 22, 145, 27);
		contentPane.add(lblNewLabel_2);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(MantenimientoListadoITR.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(311, 10, 51, 53);
		contentPane.add(labelImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.DARK_GRAY);
		scrollPane.setBounds(26, 79, 219, 272);
		contentPane.add(scrollPane);
		
		TableMetro tableMetro = new TableMetro();
		tableMetro.setColorFilasBackgound2(SystemColor.controlHighlight);
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
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Nombre"
			}
		));
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
		
		RSButtonHover btnhvrReactivarITR = new RSButtonHover();
		btnhvrReactivarITR.setText("Reactivar");
		btnhvrReactivarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrReactivarITR.setBackground(new Color(0, 112, 192));
		btnhvrReactivarITR.setBounds(254, 260, 108, 33);
		contentPane.add(btnhvrReactivarITR);
		
		RSButtonHover btnhvrModificarITR = new RSButtonHover();
		btnhvrModificarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificarITR modificarITR = new ModificarITR();
				modificarITR.setVisible(true);
			}
		});
		btnhvrModificarITR.setText("Modificar");
		btnhvrModificarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificarITR.setBackground(new Color(0, 112, 192));
		btnhvrModificarITR.setBounds(254, 212, 108, 33);
		contentPane.add(btnhvrModificarITR);
		
		RSButtonHover btnhvrAgregarITR = new RSButtonHover();
		btnhvrAgregarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AgregarITR agregarITR = new AgregarITR();
				agregarITR.setVisible(true);
			}
		});
		btnhvrAgregarITR.setText("Agregar");
		btnhvrAgregarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrAgregarITR.setBackground(new Color(0, 112, 192));
		btnhvrAgregarITR.setBounds(254, 164, 108, 33);
		contentPane.add(btnhvrAgregarITR);
		
		RSButtonHover btnhvrEliminarITR_1 = new RSButtonHover();
		btnhvrEliminarITR_1.setText("Eliminar");
		btnhvrEliminarITR_1.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrEliminarITR_1.setBackground(new Color(0, 112, 192));
		btnhvrEliminarITR_1.setBounds(254, 308, 108, 33);
		contentPane.add(btnhvrEliminarITR_1);
		
		RSComboBox comboBoxEstadoITR = new RSComboBox();
		comboBoxEstadoITR.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		comboBoxEstadoITR.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxEstadoITR.setBounds(254, 98, 108, 32);
		contentPane.add(comboBoxEstadoITR);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEstado.setBounds(254, 79, 45, 13);
		contentPane.add(lblEstado);
		
		setLocationRelativeTo(null);

	}
}
