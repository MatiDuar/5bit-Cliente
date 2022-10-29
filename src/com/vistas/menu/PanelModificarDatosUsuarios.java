package com.vistas.menu;

import javax.swing.JPanel;
import rojeru_san.rslabel.RSLabelImage;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import rojeru_san.rsfield.RSTextFull;
import rojerusan.RSComboBox;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rsfield.RSPassword;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsdate.RSYearDate;

public class PanelModificarDatosUsuarios extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelModificarDatosUsuarios() {
		
	}
	
	public void datosAnalista() {
		removeAll();
		setLayout(null);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setBounds(603, 10, 51, 53);
		labelImage.setIcon(new ImageIcon(PanelModificarDatosUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		add(labelImage);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICAR DATOS DEL USUARIO");
		lblNewLabel_2.setBounds(174, 22, 327, 27);
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		add(lblNewLabel_2);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerNombre.setBounds(12, 101, 84, 14);
		add(lblPrimerNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerApellido.setBounds(12, 148, 94, 14);
		add(lblPrimerApellido);
		
		JLabel lblCedula = new JLabel("Cédula*");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCedula.setBounds(12, 200, 84, 14);
		add(lblCedula);
		
		JLabel lblEmailPersonal = new JLabel("Email Personal*");
		lblEmailPersonal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailPersonal.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(12, 252, 84, 14);
		add(lblEmailPersonal);
		
		JLabel lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 305, 86, 14);
		add(lblDepartamento);
		
		JLabel lblEmailUTEC = new JLabel("Email UTEC*");
		lblEmailUTEC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailUTEC.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUTEC.setBounds(12, 356, 84, 14);
		add(lblEmailUTEC);
		
		JLabel lblITR = new JLabel("ITR *");
		lblITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblITR.setFont(new Font("Lato", Font.PLAIN, 11));
		lblITR.setBounds(331, 356, 84, 14);
		add(lblITR);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(101, 88, 214, 42);
		add(textNombre1);
		
		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido1.setBounds(101, 135, 214, 42);
		add(textApellido1);
		
		RSTextFull textCedula = new RSTextFull();
		textCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCedula.setBounds(101, 187, 214, 42);
		add(textCedula);
		
		RSTextFull textEmailPersonal = new RSTextFull();
		textEmailPersonal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailPersonal.setBounds(101, 239, 214, 42);
		add(textEmailPersonal);
		
		RSComboBox comboBoxDepartamento = new RSComboBox();
		comboBoxDepartamento.setColorFondo(new Color(52, 152, 219));
		comboBoxDepartamento.setBounds(101, 291, 214, 42);
		add(comboBoxDepartamento);
		
		RSTextFull textEmailUtec = new RSTextFull();
		textEmailUtec.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailUtec.setBounds(101, 343, 214, 42);
		add(textEmailUtec);
		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(420, 341, 214, 42);
		add(comboBoxITR);
		
		JLabel lblNombre2 = new JLabel("Segundo Nombre");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(329, 102, 86, 14);
		add(lblNombre2);
		
		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre2.setBounds(420, 88, 214, 42);
		add(textNombre2);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(329, 149, 102, 14);
		add(lblApellido2);
		
		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido2.setBounds(420, 135, 214, 42);
		add(textApellido2);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento*");
		lblFechaNacimiento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(325, 201, 110, 14);
		add(lblFechaNacimiento);
		
		RSDateChooser FechaNacimiento = new RSDateChooser();
		FechaNacimiento.setBounds(420, 187, 214, 42);
		add(FechaNacimiento);
		
		JLabel lblTelefonoDeContacto = new JLabel("Teléfono de");
		lblTelefonoDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto.setBounds(329, 245, 86, 14);
		add(lblTelefonoDeContacto);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("Contacto *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(329, 261, 86, 14);
		add(lblTelefonoDeContacto_1);
		
		RSTextFull textTelefonoContacto = new RSTextFull();
		textTelefonoContacto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTelefonoContacto.setBounds(420, 239, 214, 42);
		add(textTelefonoContacto);
		
		JLabel lblLocalidad = new JLabel("Localidad*");
		lblLocalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalidad.setBounds(361, 306, 54, 14);
		add(lblLocalidad);
		
		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalidad.setBounds(420, 291, 214, 42);
		add(textLocalidad);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(12, 486, 172, 33);
		add(btnhvrCancelar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(462, 486, 172, 33);
		add(btnhvrGuardar);

	}
	
	public void datosEstudiante() {
		setLayout(null);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setBounds(583, 10, 51, 53);
		labelImage.setIcon(new ImageIcon(PanelModificarDatosUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		add(labelImage);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICAR DATOS DEL USUARIO");
		lblNewLabel_2.setBounds(174, 22, 327, 27);
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		add(lblNewLabel_2);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerNombre.setBounds(12, 101, 84, 14);
		add(lblPrimerNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerApellido.setBounds(12, 148, 94, 14);
		add(lblPrimerApellido);
		
		JLabel lblCedula = new JLabel("Cédula*");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCedula.setBounds(12, 200, 84, 14);
		add(lblCedula);
		
		JLabel lblEmailPersonal = new JLabel("Email Personal*");
		lblEmailPersonal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailPersonal.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(12, 252, 84, 14);
		add(lblEmailPersonal);
		
		JLabel lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 305, 86, 14);
		add(lblDepartamento);
		
		JLabel lblEmailUTEC = new JLabel("Email UTEC*");
		lblEmailUTEC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailUTEC.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUTEC.setBounds(12, 356, 84, 14);
		add(lblEmailUTEC);
		
		JLabel lblITR = new JLabel("ITR *");
		lblITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblITR.setFont(new Font("Lato", Font.PLAIN, 11));
		lblITR.setBounds(331, 356, 84, 14);
		add(lblITR);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(101, 88, 214, 42);
		add(textNombre1);
		
		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido1.setBounds(101, 135, 214, 42);
		add(textApellido1);
		
		RSTextFull textCedula = new RSTextFull();
		textCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCedula.setBounds(101, 187, 214, 42);
		add(textCedula);
		
		RSTextFull textEmailPersonal = new RSTextFull();
		textEmailPersonal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailPersonal.setBounds(101, 239, 214, 42);
		add(textEmailPersonal);
		
		RSComboBox comboBoxDepartamento = new RSComboBox();
		comboBoxDepartamento.setColorFondo(new Color(52, 152, 219));
		comboBoxDepartamento.setBounds(101, 291, 214, 42);
		add(comboBoxDepartamento);
		
		RSTextFull textEmailUtec = new RSTextFull();
		textEmailUtec.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailUtec.setBounds(101, 343, 214, 42);
		add(textEmailUtec);
		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(420, 341, 214, 42);
		add(comboBoxITR);
		
		JLabel lblNombre2 = new JLabel("Segundo Nombre");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(329, 102, 86, 14);
		add(lblNombre2);
		
		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre2.setBounds(420, 88, 214, 42);
		add(textNombre2);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(329, 149, 102, 14);
		add(lblApellido2);
		
		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido2.setBounds(420, 135, 214, 42);
		add(textApellido2);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento*");
		lblFechaNacimiento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(325, 201, 110, 14);
		add(lblFechaNacimiento);
		
		RSDateChooser FechaNacimiento = new RSDateChooser();
		FechaNacimiento.setBounds(420, 187, 214, 42);
		add(FechaNacimiento);
		
		JLabel lblTelefonoDeContacto = new JLabel("Teléfono de");
		lblTelefonoDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto.setBounds(329, 245, 86, 14);
		add(lblTelefonoDeContacto);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("Contacto *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(329, 261, 86, 14);
		add(lblTelefonoDeContacto_1);
		
		RSTextFull textTelefonoContacto = new RSTextFull();
		textTelefonoContacto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTelefonoContacto.setBounds(420, 239, 214, 42);
		add(textTelefonoContacto);
		
		JLabel lblLocalidad = new JLabel("Localidad*");
		lblLocalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalidad.setBounds(361, 306, 54, 14);
		add(lblLocalidad);
		
		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalidad.setBounds(420, 291, 214, 42);
		add(textLocalidad);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(12, 486, 172, 33);
		add(btnhvrCancelar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(462, 486, 172, 33);
		add(btnhvrGuardar);
		
		JLabel lblTelefonoDeContacto_1_1 = new JLabel("a la carrera *");
		lblTelefonoDeContacto_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1_1.setBounds(12, 417, 86, 14);
		add(lblTelefonoDeContacto_1_1);
		
		JLabel lblAoDeIngreso = new JLabel("Año de ingreso");
		lblAoDeIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAoDeIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAoDeIngreso.setBounds(12, 402, 86, 14);
		add(lblAoDeIngreso);
		
		RSYearDate yearDate = new RSYearDate();
		yearDate.setColorBackground(new Color(52, 152, 219));
		yearDate.setBounds(100, 395, 215, 42);
		add(yearDate);
	}
	
	public void datosTutor() {
		setLayout(null);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setBounds(583, 10, 51, 53);
		labelImage.setIcon(new ImageIcon(PanelModificarDatosUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		add(labelImage);
		
		JLabel lblNewLabel_2 = new JLabel("MODIFICAR DATOS DEL USUARIO");
		lblNewLabel_2.setBounds(174, 22, 327, 27);
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		add(lblNewLabel_2);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerNombre.setBounds(12, 101, 84, 14);
		add(lblPrimerNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerApellido.setBounds(12, 148, 94, 14);
		add(lblPrimerApellido);
		
		JLabel lblCedula = new JLabel("Cédula*");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCedula.setBounds(12, 200, 84, 14);
		add(lblCedula);
		
		JLabel lblEmailPersonal = new JLabel("Email Personal*");
		lblEmailPersonal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailPersonal.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(12, 252, 84, 14);
		add(lblEmailPersonal);
		
		JLabel lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 305, 86, 14);
		add(lblDepartamento);
		
		JLabel lblEmailUTEC = new JLabel("Email UTEC*");
		lblEmailUTEC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailUTEC.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUTEC.setBounds(12, 356, 84, 14);
		add(lblEmailUTEC);
		
		JLabel lblITR = new JLabel("ITR *");
		lblITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblITR.setFont(new Font("Lato", Font.PLAIN, 11));
		lblITR.setBounds(331, 356, 84, 14);
		add(lblITR);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(101, 88, 214, 42);
		add(textNombre1);
		
		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido1.setBounds(101, 135, 214, 42);
		add(textApellido1);
		
		RSTextFull textCedula = new RSTextFull();
		textCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCedula.setBounds(101, 187, 214, 42);
		add(textCedula);
		
		RSTextFull textEmailPersonal = new RSTextFull();
		textEmailPersonal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailPersonal.setBounds(101, 239, 214, 42);
		add(textEmailPersonal);
		
		RSComboBox comboBoxDepartamento = new RSComboBox();
		comboBoxDepartamento.setColorFondo(new Color(52, 152, 219));
		comboBoxDepartamento.setBounds(101, 291, 214, 42);
		add(comboBoxDepartamento);
		
		RSTextFull textEmailUtec = new RSTextFull();
		textEmailUtec.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailUtec.setBounds(101, 343, 214, 42);
		add(textEmailUtec);
		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(420, 341, 214, 42);
		add(comboBoxITR);
		
		JLabel lblNombre2 = new JLabel("Segundo Nombre");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(329, 102, 86, 14);
		add(lblNombre2);
		
		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre2.setBounds(420, 88, 214, 42);
		add(textNombre2);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(329, 149, 102, 14);
		add(lblApellido2);
		
		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido2.setBounds(420, 135, 214, 42);
		add(textApellido2);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento*");
		lblFechaNacimiento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(325, 201, 110, 14);
		add(lblFechaNacimiento);
		
		RSDateChooser FechaNacimiento = new RSDateChooser();
		FechaNacimiento.setBounds(420, 187, 214, 42);
		add(FechaNacimiento);
		
		JLabel lblTelefonoDeContacto = new JLabel("Teléfono de");
		lblTelefonoDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto.setBounds(329, 245, 86, 14);
		add(lblTelefonoDeContacto);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("Contacto *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(329, 261, 86, 14);
		add(lblTelefonoDeContacto_1);
		
		RSTextFull textTelefonoContacto = new RSTextFull();
		textTelefonoContacto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTelefonoContacto.setBounds(420, 239, 214, 42);
		add(textTelefonoContacto);
		
		JLabel lblLocalidad = new JLabel("Localidad*");
		lblLocalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalidad.setBounds(361, 306, 54, 14);
		add(lblLocalidad);
		
		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalidad.setBounds(420, 291, 214, 42);
		add(textLocalidad);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(12, 486, 172, 33);
		add(btnhvrCancelar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(462, 486, 172, 33);
		add(btnhvrGuardar);
		
		JLabel lblRol = new JLabel("Rol*");
		lblRol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRol.setFont(new Font("Lato", Font.PLAIN, 11));
		lblRol.setBounds(18, 410, 78, 14);
		add(lblRol);
		
		RSComboBox comboBoxRolTutor = new RSComboBox();
		comboBoxRolTutor.setColorFondo(new Color(52, 152, 219));
		comboBoxRolTutor.setBounds(101, 395, 214, 42);
		add(comboBoxRolTutor);
		
		JLabel lblAreaTutor = new JLabel("Área*");
		lblAreaTutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAreaTutor.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAreaTutor.setBounds(337, 410, 78, 14);
		add(lblAreaTutor);
		
		RSComboBox comboBoxAreaTutor = new RSComboBox();
		comboBoxAreaTutor.setColorFondo(new Color(52, 152, 219));
		comboBoxAreaTutor.setBounds(420, 396, 214, 42);
		add(comboBoxAreaTutor);
	}
}
