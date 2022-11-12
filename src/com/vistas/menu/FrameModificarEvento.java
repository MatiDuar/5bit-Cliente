package com.vistas.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import rojeru_san.rslabel.RSLabelImage;
import rojeru_san.rsfield.RSTextFull;
import javax.swing.SwingConstants;
import rojeru_san.rsdate.RSDateChooser;
import rojerusan.RSComboBox;
import necesario.RSScrollPane;
import javax.swing.JScrollPane;
import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSTableMetro;
import rojeru_san.rsdate.RSLabelHora;

public class FrameModificarEvento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModificarEvento frame = new FrameModificarEvento();
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
	public FrameModificarEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("EDITAR EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(280, 24, 160, 27);
		contentPane.add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setBounds(644, 11, 51, 53);
		contentPane.add(labelImage_1);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTitulo.setBounds(56, 110, 28, 14);
		contentPane.add(lblTitulo);
		
		RSTextFull textTitulo = new RSTextFull();
		textTitulo.setText((String) null);
		textTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTitulo.setBounds(94, 96, 250, 42);
		contentPane.add(textTitulo);
		
		JLabel lblTipoDeEvento = new JLabel("Tipo de Evento");
		lblTipoDeEvento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeEvento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTipoDeEvento.setBounds(364, 110, 71, 14);
		contentPane.add(lblTipoDeEvento);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaInicio.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaInicio.setBounds(27, 157, 57, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraInicio.setFont(new Font("Lato", Font.PLAIN, 11));
		lblHoraInicio.setBounds(349, 157, 86, 14);
		contentPane.add(lblHoraInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaFin.setBounds(27, 209, 57, 14);
		contentPane.add(lblFechaFin);
		
		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraFin.setFont(new Font("Lato", Font.PLAIN, 11));
		lblHoraFin.setBounds(345, 209, 90, 14);
		contentPane.add(lblHoraFin);
		
		RSDateChooser fechaFin = new RSDateChooser();
		fechaFin.setBounds(94, 196, 250, 42);
		contentPane.add(fechaFin);
		
		RSComboBox comboBoxTipoEvento = new RSComboBox();
		comboBoxTipoEvento.setBounds(440, 96, 250, 42);
		contentPane.add(comboBoxTipoEvento);
		
		RSDateChooser fechaInicio = new RSDateChooser();
		fechaInicio.setBounds(94, 143, 250, 42);
		contentPane.add(fechaInicio);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblModalidad.setBounds(27, 263, 62, 14);
		contentPane.add(lblModalidad);
		
		RSComboBox comboBoxModalidad = new RSComboBox();
		comboBoxModalidad.setBounds(94, 249, 250, 42);
		contentPane.add(comboBoxModalidad);
		
		JLabel lblItr = new JLabel("ITR");
		lblItr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItr.setFont(new Font("Lato", Font.PLAIN, 11));
		lblItr.setBounds(364, 262, 71, 14);
		contentPane.add(lblItr);
		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setBounds(440, 248, 250, 42);
		contentPane.add(comboBoxITR);
		
		JLabel lblLocalizacion = new JLabel("Localizacion");
		lblLocalizacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocalizacion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalizacion.setBounds(18, 316, 66, 14);
		contentPane.add(lblLocalizacion);
		
		RSTextFull textTitulo_1 = new RSTextFull();
		textTitulo_1.setText((String) null);
		textTitulo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTitulo_1.setBounds(94, 302, 250, 42);
		contentPane.add(textTitulo_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 392, 665, 205);
		contentPane.add(scrollPane);
		
		RSTableMetro tableMetro = new RSTableMetro();
		scrollPane.setViewportView(tableMetro);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(237, 608, 227, 33);
		contentPane.add(btnhvrGuardar);
		
		JLabel lblSeleccionarTutor = new JLabel("Seleccionar Tutor");
		lblSeleccionarTutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeleccionarTutor.setFont(new Font("Lato", Font.PLAIN, 17));
		lblSeleccionarTutor.setBounds(18, 374, 232, 14);
		contentPane.add(lblSeleccionarTutor);
		
		RSComboBox comboBoxHoraInicio = new RSComboBox();
		comboBoxHoraInicio.setBounds(440, 147, 250, 42);
		contentPane.add(comboBoxHoraInicio);
		
		RSComboBox comboBoxHoraFin = new RSComboBox();
		comboBoxHoraFin.setBounds(440, 199, 250, 42);
		contentPane.add(comboBoxHoraFin);
	}
}
