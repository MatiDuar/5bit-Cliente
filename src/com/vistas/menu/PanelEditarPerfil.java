package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import rojeru_san.rsfield.RSTextFull;
import javax.swing.SwingConstants;

import com.controlador.DAOGeneral;
import com.entities.Departamento;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

import rojeru_san.rsdate.RSDateChooser;
import rojerusan.RSComboBox;
import java.awt.Color;
import rojeru_san.rsfield.RSPassword;
import rojeru_san.complementos.RSButtonHover;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import rojeru_san.rsdate.RSYearDate;
import rojeru_san.rslabel.RSLabelImage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PanelEditarPerfil extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	private Menu menu = Menu.getInstancia();
	public PanelEditarPerfilExtra panelDinamicoEditarPerfilPorTipoUsuarios;
	private PanelMenu panelEstudiante = new PanelMenu();

	DefaultComboBoxModel modeloDep = new DefaultComboBoxModel();;
	RSComboBox comboBoxITR;
	RSComboBox comboBoxDepartamento;
	DefaultComboBoxModel modeloITR = new DefaultComboBoxModel();;

	
	public PanelEditarPerfil() {
		setBounds(245, 0, 700, 725);

		setLayout(null);

		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerNombre.setBounds(12, 110, 84, 14);
		add(lblPrimerNombre);

		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setBordeColorFocus(new Color(52, 152, 219));
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(101, 96, 250, 42);
		textNombre1.setText(Menu.getUsuario().getNombre1());
		add(textNombre1);

		JLabel lblNombre2 = new JLabel("Segundo Nombre");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(356, 110, 86, 14);
		add(lblNombre2);

		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setBordeColorFocus(new Color(52, 152, 219));
		textNombre2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre2.setBounds(447, 96, 250, 42);
		textNombre2.setText(Menu.getUsuario().getNombre2());
		add(textNombre2);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setFont(new Font("Lato", Font.PLAIN, 11));
		lblPrimerApellido.setBounds(12, 157, 94, 14);
		add(lblPrimerApellido);

		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setBordeColorFocus(new Color(52, 152, 219));
		textApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido1.setBounds(101, 143, 250, 42);
		textApellido1.setText(Menu.getUsuario().getApellido1());
		add(textApellido1);

		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(356, 157, 102, 14);
		add(lblApellido2);

		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setBordeColorFocus(new Color(52, 152, 219));
		textApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido2.setBounds(447, 143, 250, 42);
		textApellido2.setText(Menu.getUsuario().getApellido2());
		add(textApellido2);

		JLabel lblCedula = new JLabel("C\u00e9dula*");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCedula.setBounds(12, 209, 84, 14);
		add(lblCedula);

		RSTextFull textCedula = new RSTextFull();
		textCedula.setBordeColorFocus(new Color(52, 152, 219));
		textCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCedula.setBounds(101, 195, 250, 42);
		textCedula.setText(Menu.getUsuario().getDocumento());
		add(textCedula);

		RSDateChooser FechaNacimiento = new RSDateChooser();
		FechaNacimiento.setColorBackground(new Color(52, 152, 219));
		FechaNacimiento.setBounds(447, 195, 250, 42);
		FechaNacimiento.setDatoFecha(Menu.getUsuario().getFechaNacimiento());
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
		textEmailPersonal.setBordeColorFocus(new Color(52, 152, 219));
		textEmailPersonal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailPersonal.setBounds(101, 247, 250, 42);
		textEmailPersonal.setText(Menu.getUsuario().getMail());
		add(textEmailPersonal);

		JLabel lblTelefonoDeContacto = new JLabel("Tel\u00e9fono de");
		lblTelefonoDeContacto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto.setBounds(356, 253, 86, 14);
		add(lblTelefonoDeContacto);

		RSTextFull textTelefonoContacto = new RSTextFull();
		textTelefonoContacto.setBordeColorFocus(new Color(52, 152, 219));
		textTelefonoContacto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTelefonoContacto.setBounds(447, 247, 250, 42);
		textTelefonoContacto.setText(Menu.getUsuario().getTelefono());
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

		comboBoxDepartamento = new RSComboBox();
		comboBoxDepartamento.setColorBoton(Color.WHITE);
		comboBoxDepartamento.setModel(modeloDep);
		comboBoxDepartamento.setColorFondo(new Color(52, 152, 219));
		comboBoxDepartamento.setBounds(101, 299, 250, 42);
		add(comboBoxDepartamento);

		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setBordeColorFocus(new Color(52, 152, 219));
		textLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalidad.setBounds(447, 299, 250, 42);
		textLocalidad.setText(Menu.getUsuario().getLocalidad());
		add(textLocalidad);

		JLabel lblEmailUTEC = new JLabel("Email UTEC*");
		lblEmailUTEC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailUTEC.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUTEC.setBounds(12, 365, 84, 14);
		add(lblEmailUTEC);

		RSTextFull textEmailUtec = new RSTextFull();
		textEmailUtec.setBordeColorFocus(new Color(52, 152, 219));
		textEmailUtec.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailUtec.setBounds(101, 351, 250, 42);
		textEmailUtec.setText(Menu.getUsuario().getMailInstitucional());
		add(textEmailUtec);

		JLabel lblContrasenia = new JLabel("Contrase\u00f1a*");
		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setFont(new Font("Lato", Font.PLAIN, 11));
		lblContrasenia.setBounds(358, 365, 84, 14);
		add(lblContrasenia);

		RSPassword password = new RSPassword();
		password.setBordeColorFocus(new Color(52, 152, 219));
		password.setBounds(447, 351, 250, 42);
		password.setText(Menu.getUsuario().getContrasena());
		add(password);

		JLabel lblITR = new JLabel("ITR *");
		lblITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblITR.setFont(new Font("Lato", Font.PLAIN, 11));
		lblITR.setBounds(12, 417, 84, 14);
		add(lblITR);

		comboBoxITR = new RSComboBox();
		comboBoxITR.setColorBoton(Color.WHITE);
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(101, 403, 250, 42);
		add(comboBoxITR);
		panelDinamicoEditarPerfilPorTipoUsuarios = new PanelEditarPerfilExtra();
		panelDinamicoEditarPerfilPorTipoUsuarios.setBounds(12, 455, 680, 124);

		cargaComboBox();

		comboBoxITR.setSelectedItem(Menu.getUsuario().getItr().getNombre());
		comboBoxDepartamento.setSelectedItem(Menu.getUsuario().getDepartamento().getNombre());

		

		if (Menu.getUsuario() instanceof Estudiante) {
			panelDinamicoEditarPerfilPorTipoUsuarios.initUIEstudiante();
			panelDinamicoEditarPerfilPorTipoUsuarios.yearDate.setEnabled(false);
			comboBoxITR.setEnabled(false);
		} else if (Menu.getUsuario() instanceof Tutor) {
			panelDinamicoEditarPerfilPorTipoUsuarios.initUITutor();
			panelDinamicoEditarPerfilPorTipoUsuarios.comboBoxAreaTutor.setEditable(false);
			panelDinamicoEditarPerfilPorTipoUsuarios.comboBoxRolTutor.setEditable(false);
			comboBoxITR.setEnabled(false);

		}
		add(panelDinamicoEditarPerfilPorTipoUsuarios);

		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int input = JOptionPane.showConfirmDialog(getParent(),
							"Esta seguro de confirmar los datos modificados", "Guardado...", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (input == 0) {
						Usuario usuarioMod = Menu.getUsuario();

						String apellido1 = textApellido1.getText();

						if (apellido1.length() > 50) {
							throw new Exception("El campo primer apellido debe contener menos de 50 caracteres.");
						}

						// ^[a-zA-Z]+$ matches only strings that consist of one or more letters only (^
						// and $ mark the begin and end of a string respectively)

						if (!apellido1.matches("^[a-zA-Z]+$")) {
							throw new Exception(
									"El campo primer apellido no puede ser vac√≠o y debe contener solo letras.");
						}
						usuarioMod.setApellido1(apellido1);

						String apellido2 = textApellido2.getText();

						if (apellido2.length() > 50) {
							throw new Exception("El campo segundo apellido debe contener menos de 50 caracteres.");
						}

						// ^[a-zA-Z]+$ matches only strings that consist of one or more letters only (^
						// and $ mark the begin and end of a string respectively)

						if (!apellido2.isEmpty()) {
							if (!apellido2.matches("^[a-zA-Z]+$")) {
								throw new Exception(
										"El campo segundo apellido no puede ser vac√≠o y debe contener solo letras.");
							}
						}

						usuarioMod.setApellido2(apellido2);

						String nombre1 = textNombre1.getText();

						if (nombre1.length() > 50) {
							throw new Exception("El campo primer nombre debe contener menos de 50 caracteres.");
						}

						// ^[a-zA-Z]+$ matches only strings that consist of one or more letters only (^
						// and $ mark the begin and end of a string respectively)

						if (!nombre1.matches("^[a-zA-Z]+$")) {
							throw new Exception(
									"El campo primer nombre no puede ser vac√≠o y debe contener solo letras.");
						}

						usuarioMod.setNombre1(nombre1);

						String nombre2 = textNombre2.getText();

						if (nombre2.length() > 50) {
							throw new Exception("El campo segundo nombre debe contener menos de 50 caracteres.");
						}

						if (!textNombre2.getText().isEmpty()) {
							if (nombre2.isBlank()) {
								throw new Exception("El campo segundo nombre no puede ser solo espacios");
							}
							if ((nombre2.matches("^[0-9]*$"))) {
								throw new Exception("El campo segundo nombre no puede contener numeros");
							}
							if (nombre2.contains(" ")) {
								throw new Exception("No puede contener espacios vacios");
							}
						}

						usuarioMod.setNombre2(nombre2);

						String contrasena = password.getText();

						if (contrasena.length() > 50 || contrasena.length() < 8) {
							throw new Exception("El campo contraseÒa debe tener entre 8 y 50 caracteres.");
						}

						boolean contieneNums = false;
						boolean contieneLetras = false;

						for (int i = 0; i < contrasena.length(); i++) {
							if (Character.isLetter(contrasena.charAt(i))) {
								contieneLetras = true;
								break;
							}
						}

						for (int i = 0; i < contrasena.length(); i++) {
							if (Character.isDigit(contrasena.charAt(i))) {
								contieneNums = true;
								break;
							}
						}
						if (!contieneNums || !contieneLetras) {
							throw new Exception("La contrasena debe contener numeros y letras");
						}

						usuarioMod.setContrasena(contrasena);

						String doc = textCedula.getText();

						if (doc.length() != 8 || doc == "        " || !esNumerico(doc)) {
							throw new Exception("Formato de documento inv·lido, debe contener 8 dÌgitos numericos");
						} else {
							usuarioMod.setDocumento(doc);
						}

						String valorCBDepString = comboBoxDepartamento.getSelectedItem().toString();

						if (valorCBDepString == "") {
							throw new Exception("Debe seleccionar un Departamento");
						}

						usuarioMod.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(valorCBDepString));

						java.util.Date fecha = FechaNacimiento.getDatoFecha();

						LocalDate fechaActualLD = LocalDate.now();
						java.sql.Date fechaActualSQL = java.sql.Date.valueOf(fechaActualLD);

						java.util.Date fechaActualDATE = new java.util.Date(fechaActualSQL.getTime());

						if (fecha.before(fechaActualDATE)) {
							java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
							usuarioMod.setFechaNacimiento(sqlDate);
						} else {
							throw new Exception("Fecha inv·lida, introduzca una fecha menor a la actual.");
						}

						usuarioMod.setGenero(DAOGeneral.generoRemote.buscarGeneroPorId((long) 1));

						String valorCBITRString = comboBoxITR.getSelectedItem().toString();

						if (valorCBITRString == "") {
							throw new Exception("Debe seleccionar un ITR");
						}

						usuarioMod.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(valorCBITRString));

						String localidad = textLocalidad.getText();

						if (textLocalidad.getText().equalsIgnoreCase("")) {
							throw new Exception("El campo localidad no puede ser vacio");
						}

						if ((!localidad.matches("\\w.*"))) {
							throw new Exception("El campo localidad debe contener letras");
						}

						if (localidad.length() > 50) {
							throw new Exception("El campo localidad no puede contener mas de 50 caracteres");
						}

						usuarioMod.setLocalidad(localidad.replaceAll("\\s", ""));

						String mailPersonal = textEmailPersonal.getText();

						if (!mailPersonal.contains("@")) {
							throw new Exception("Formato de email personal incorrecto");
						}

						usuarioMod.setMail(mailPersonal);

						String mailInstitucional = textEmailUtec.getText();

						if (!mailInstitucional.contains("@")) {
							throw new Exception("Formato de email institucional incorrecto");
						}

						usuarioMod.setMailInstitucional(mailInstitucional);

						String tel = textTelefonoContacto.getText();

						if (!esNumerico(tel)) {
							throw new Exception("Ingrese un tel√©fono v√°lido");
						}

						usuarioMod.setTelefono(tel);

						DAOGeneral.usuarioRemote.modificarUsuario(usuarioMod);

					}
				} catch (Exception m) {
					JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
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
		lblNewLabel_2_1.setBounds(277, 24, 239, 27);
		add(lblNewLabel_2_1);

		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelEditarPerfil.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		add(labelImage_1);

	}

	public void cargaComboBox() {
		try {
			cargarComboBoxDepartamento();
			cargarComboBoxITR();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargarComboBoxDepartamento() throws ServicesException {
		modeloDep.removeAllElements();
		modeloDep.addElement("");

		for (Departamento d : DAOGeneral.DepRemote.obtenerDepartamento()) {
			modeloDep.addElement(d.getNombre());
		}
	}

	public void cargarComboBoxITR() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITR.addElement(itr.getNombre());
		}
	}

	// si usa un numero que no sea entre 0 y 9
	// se te va a romper porque la parte "d+" solo trabaja
	// con numeros arabicos.

	public static boolean esNumerico(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

}
