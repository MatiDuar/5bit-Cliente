package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import rojeru_san.rsfield.RSTextFull;
import javax.swing.SwingConstants;
import rojeru_san.rsdate.RSDateChooser;
import rojerusan.RSComboBox;
import java.awt.Color;
import rojeru_san.rsfield.RSPassword;
import rojeru_san.complementos.RSButtonHover;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojeru_san.rsdate.RSYearDate;
import rojeru_san.rslabel.RSLabelImage;
import javax.swing.ImageIcon;

public class PanelEditarPerfil extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Menu menu = new Menu();
	private JPanel panelDinamicoEditarPerfilPorTipoUsuarios;
	private PanelMenu panelEstudiante = new PanelMenu();
	/**
	 * Create the panel.
	 */
	public PanelEditarPerfil() {
		setBounds(245, 0, 700, 725);

		setLayout(null);
		
		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerNombre.setBounds(12, 110, 84, 14);
		add(lblPrimerNombre);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(101, 96, 250, 42);
		add(textNombre1);
		
		JLabel lblNombre2 = new JLabel("Segundo Nombre");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(356, 110, 86, 14);
		add(lblNombre2);
		
		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre2.setBounds(447, 96, 250, 42);
		add(textNombre2);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerApellido.setBounds(12, 157, 94, 14);
		add(lblPrimerApellido);
		
		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido1.setBounds(101, 143, 250, 42);
		add(textApellido1);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(356, 157, 102, 14);
		add(lblApellido2);
		
		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido2.setBounds(447, 143, 250, 42);
		add(textApellido2);
		
		JLabel lblCedula = new JLabel("Cédula*");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCedula.setBounds(12, 209, 84, 14);
		add(lblCedula);
		
		RSTextFull textCedula = new RSTextFull();
		textCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCedula.setBounds(101, 195, 250, 42);
		add(textCedula);
		
		RSDateChooser FechaNacimiento = new RSDateChooser();
		FechaNacimiento.setBounds(447, 195, 250, 42);
		add(FechaNacimiento);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento*");
		lblFechaNacimiento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(352, 209, 110, 14);
		add(lblFechaNacimiento);
		
		JLabel lblEmailPersonal = new JLabel("Email Personal*");
		lblEmailPersonal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailPersonal.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(12, 261, 84, 14);
		add(lblEmailPersonal);
		
		RSTextFull textEmailPersonal = new RSTextFull();
		textEmailPersonal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailPersonal.setBounds(101, 247, 250, 42);
		add(textEmailPersonal);
		
		JLabel lblTelefonoDeContacto = new JLabel("Teléfono de");
		lblTelefonoDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto.setBounds(356, 253, 86, 14);
		add(lblTelefonoDeContacto);
		
		RSTextFull textTelefonoContacto = new RSTextFull();
		textTelefonoContacto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTelefonoContacto.setBounds(447, 247, 250, 42);
		add(textTelefonoContacto);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("Contacto *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(356, 269, 86, 14);
		add(lblTelefonoDeContacto_1);
		
		JLabel lblLocalidad = new JLabel("Localidad*");
		lblLocalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalidad.setBounds(388, 314, 54, 14);
		add(lblLocalidad);
		
		JLabel lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 314, 86, 14);
		add(lblDepartamento);
		
		RSComboBox comboBoxDepartamento = new RSComboBox();
		comboBoxDepartamento.setColorFondo(new Color(52, 152, 219));
		comboBoxDepartamento.setBounds(101, 299, 250, 42);
		add(comboBoxDepartamento);
		
		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalidad.setBounds(447, 299, 250, 42);
		add(textLocalidad);
		
		JLabel lblEmailUTEC = new JLabel("Email UTEC*");
		lblEmailUTEC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailUTEC.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUTEC.setBounds(12, 365, 84, 14);
		add(lblEmailUTEC);
		
		RSTextFull textEmailUtec = new RSTextFull();
		textEmailUtec.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailUtec.setBounds(101, 351, 250, 42);
		add(textEmailUtec);
		
		JLabel lblContrasenia = new JLabel("Contraseña*");
		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setFont(new Font("Lato", Font.PLAIN, 11));
		lblContrasenia.setBounds(358, 365, 84, 14);
		add(lblContrasenia);
		
		RSPassword password = new RSPassword();
		password.setBounds(447, 351, 250, 42);
		add(password);
		
		JLabel lblITR = new JLabel("ITR *");
		lblITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblITR.setFont(new Font("Lato", Font.PLAIN, 11));
		lblITR.setBounds(12, 417, 84, 14);
		add(lblITR);
		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(101, 403, 250, 42);
		add(comboBoxITR);
		PanelEditarPerfilExtra panelDinamicoEditarPerfilPorTipoUsuarios=new PanelEditarPerfilExtra();
		panelDinamicoEditarPerfilPorTipoUsuarios.setBounds(12, 455, 680, 124);
		//
		boolean esEstudiante = false;
		boolean esTutor = true;
		if(esEstudiante){
			panelDinamicoEditarPerfilPorTipoUsuarios.initUI();
		}else if(esTutor) {
			panelDinamicoEditarPerfilPorTipoUsuarios.initUITutor();
		}else {
			
		}
		add(panelDinamicoEditarPerfilPorTipoUsuarios);

		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(518, 630, 172, 33);
		add(btnhvrGuardar);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(10, 630, 172, 33);
		add(btnhvrCancelar);
		
		JLabel lblNewLabel_2_1 = new JLabel("EDITAR PERFIL");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(301, 24, 146, 27);
		add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelEditarPerfil.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		add(labelImage_1);

	}
}
