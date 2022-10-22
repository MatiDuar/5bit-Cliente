package com.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSTextFull;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojeru_san.rsdate.RSDateChooser;
import rojerusan.RSComboBox;
import rojerusan.RSRadioButton;
import javax.swing.JButton;

public class PanelRegistroPag extends JPanel {
	
	private static PanelRegistroPag instancia = new PanelRegistroPag();
	
	PanelRegistroPag2 panelRegistroPag2 = new PanelRegistroPag2();
	Registro regsitro = Registro.getInstancia();

	/**
	 * Create the panel.
	 */
	public PanelRegistroPag() {
		setLayout(null);
		setBounds(100, 100, 710, 841);
		
		
		JLabel lblNombre1 = new JLabel("Nombre 1");
		lblNombre1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre1.setBounds(70, 90, 61, 14);
		add(lblNombre1);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(70, 115, 250, 33);
		add(textNombre1);
		
		JLabel lblNombre2 = new JLabel("Nombre 2");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(390, 90, 61, 14);
		add(lblNombre2);
		
		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setBounds(390, 115, 250, 42);
		add(textNombre2);
		
		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setBounds(70, 193, 250, 42);
		add(textApellido1);
		
		JLabel lbApellido1 = new JLabel("Apellido 1");
		lbApellido1.setFont(new Font("Lato", Font.PLAIN, 11));
		lbApellido1.setBounds(70, 168, 61, 14);
		add(lbApellido1);
		
		RSTextFull textdOCUMENTO = new RSTextFull();
		textdOCUMENTO.setBounds(70, 271, 250, 42);
		add(textdOCUMENTO);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDocumento.setBounds(70, 246, 61, 14);
		add(lblDocumento);
		
		RSTextFull textMailPersonal = new RSTextFull();
		textMailPersonal.setBounds(70, 349, 250, 42);
		add(textMailPersonal);
		
		JLabel lblEmailPersonal = new JLabel("Email Personal");
		lblEmailPersonal.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(70, 324, 77, 14);
		add(lblEmailPersonal);
		
		JLabel lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(390, 168, 61, 14);
		add(lblApellido2);
		
		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setBounds(390, 193, 250, 42);
		add(textApellido2);
		
		JLabel lblFecNac = new JLabel("Fecha Naciemiento");
		lblFecNac.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFecNac.setBounds(390, 246, 100, 14);
		add(lblFecNac);
		
		JLabel lblEmailUtec = new JLabel("Email UTEC");
		lblEmailUtec.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUtec.setBounds(390, 324, 61, 14);
		add(lblEmailUtec);
		
		RSTextFull textMailUtec = new RSTextFull();
		textMailUtec.setBounds(390, 349, 250, 42);
		add(textMailUtec);
		
		JLabel lblTitulo = new JLabel("REGISTRO USUARIO");
		lblTitulo.setFont(new Font("Lato", Font.BOLD, 50));
		lblTitulo.setBounds(116, 11, 524, 58);
		add(lblTitulo);
		
		RSButtonHover btnhvrRegistrarse = new RSButtonHover();
		btnhvrRegistrarse.setText("Registrarse");
		btnhvrRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrRegistrarse.setBackground(new Color(52, 152, 219));
		btnhvrRegistrarse.setBounds(70, 791, 172, 33);
		add(btnhvrRegistrarse);
		
		RSButtonHover btnhvrSiguiente = new RSButtonHover();
		btnhvrSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro.mostrarPag2(panelRegistroPag2);

			}
		});
		btnhvrSiguiente.setText("Siguiente");
		btnhvrSiguiente.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrSiguiente.setBackground(new Color(52, 152, 219));
		btnhvrSiguiente.setBounds(468, 791, 172, 33);
		add(btnhvrSiguiente);
		
		RSDateChooser dateChooser = new RSDateChooser();
		dateChooser.setBounds(390, 271, 250, 42);
		add(dateChooser);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setColorFondo(new Color(52, 152, 219));
		comboBox.setBounds(70, 450, 250, 42);
		add(comboBox);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setColorFondo(new Color(52, 152, 219));
		comboBox_1.setBounds(390, 450, 250, 42);
		add(comboBox_1);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setColorFondo(new Color(52, 152, 219));
		comboBox_2.setBounds(70, 528, 250, 42);
		add(comboBox_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tipo de Usuario");
		lblNewLabel_1_2_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2_1.setBounds(390, 503, 77, 14);
		add(lblNewLabel_1_2_2_1);
		
		RSRadioButton radioEstudiante = new RSRadioButton();
		radioEstudiante.setText("Estudiante");
		radioEstudiante.setFont(new Font("Lato", Font.BOLD, 11));
		radioEstudiante.setBounds(384, 528, 87, 42);
		add(radioEstudiante);
		
		RSRadioButton radioTutor = new RSRadioButton();
		radioTutor.setText("Tutor");
		radioTutor.setFont(new Font("Lato", Font.BOLD, 11));
		radioTutor.setBounds(468, 528, 61, 42);
		add(radioTutor);
		
		RSRadioButton radioAnalista = new RSRadioButton();
		radioAnalista.setText("Analista");
		radioAnalista.setFont(new Font("Lato", Font.BOLD, 11));
		radioAnalista.setBounds(531, 528, 77, 42);
		add(radioAnalista);
		
		JPanel panelDinamicoReg2 = new JPanel();
		panelDinamicoReg2.setLayout(null);
		panelDinamicoReg2.setBounds(70, 581, 570, 174);
		add(panelDinamicoReg2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(135, 48, 89, 23);
		panelDinamicoReg2.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("ITR");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(70, 503, 61, 14);
		add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Localidad");
		lblNewLabel_1_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(70, 425, 61, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(390, 425, 77, 14);
		add(lblNewLabel_1_2_1);
		
		

	}
	
	public static PanelRegistroPag getInstancia(){
		return instancia;
	}
}
