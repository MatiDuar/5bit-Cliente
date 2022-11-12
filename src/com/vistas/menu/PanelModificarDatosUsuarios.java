package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.controlador.DAOGeneral;
import com.entities.AreaTutor;
import com.entities.Departamento;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.TipoTutor;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rsdate.RSYearDate;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class PanelModificarDatosUsuarios extends JPanel {
	public static Usuario usuarioLogeado;
	private DefaultComboBoxModel modeloITR;
	private DefaultComboBoxModel modeloDep;
	private DefaultComboBoxModel modeloAreaTutor;
	private DefaultComboBoxModel modeloTipoTutor;
	
	private RSComboBox comboBoxAreaTutor;
	private RSComboBox comboBoxRolTutor;
	private RSYearDate yearDate;

	/**
	 * Create the panel.
	 */
	public PanelModificarDatosUsuarios() {
		datosComunes();
	}

	public void datosAnalista() {
		removeAll();
		datosComunes();
	}

	public void datosEstudiante() {
		removeAll();

		datosComunes();

		JLabel lblTelefonoDeContacto_1_1 = new JLabel("a la carrera *");
		lblTelefonoDeContacto_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1_1.setBounds(12, 417, 86, 14);
		add(lblTelefonoDeContacto_1_1);

		JLabel lblAoDeIngreso = new JLabel("AÃ±o de ingreso");
		lblAoDeIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAoDeIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAoDeIngreso.setBounds(12, 402, 86, 14);
		add(lblAoDeIngreso);

		yearDate = new RSYearDate();
		yearDate.setColorBackground(new Color(52, 152, 219));
		yearDate.setBounds(100, 395, 215, 42);
		add(yearDate);
		
		yearDate.setYear(((Estudiante) usuarioLogeado).getAnoIngreso());
	}

	public void datosTutor() {
		removeAll();
		datosComunes();
		JLabel lblRol = new JLabel("Rol*");
		lblRol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRol.setFont(new Font("Lato", Font.PLAIN, 11));
		lblRol.setBounds(18, 410, 78, 14);
		add(lblRol);

		comboBoxRolTutor = new RSComboBox();
		modeloTipoTutor = new DefaultComboBoxModel();
		comboBoxRolTutor.setModel(modeloTipoTutor);
		comboBoxRolTutor.setColorFondo(new Color(52, 152, 219));
		comboBoxRolTutor.setBounds(101, 395, 214, 42);
		add(comboBoxRolTutor);

		JLabel lblAreaTutor = new JLabel("Ã�rea*");
		lblAreaTutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAreaTutor.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAreaTutor.setBounds(337, 410, 78, 14);
		add(lblAreaTutor);

		comboBoxAreaTutor = new RSComboBox();
		modeloAreaTutor = new DefaultComboBoxModel();
		comboBoxAreaTutor.setModel(modeloAreaTutor);
		comboBoxAreaTutor.setColorFondo(new Color(52, 152, 219));
		comboBoxAreaTutor.setBounds(420, 396, 214, 42);
		add(comboBoxAreaTutor);
		
		try {
			cargarComboTutor();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		comboBoxAreaTutor.setSelectedItem(((Tutor) usuarioLogeado).getAreaTutor().getNombre());
		comboBoxRolTutor.setSelectedItem(((Tutor) usuarioLogeado).getTipoTutor().getNombre());

	}

	public void datosComunes() {
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

		JLabel lblCedula = new JLabel("CÃ©dula*");
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
		textNombre1.setText(usuarioLogeado.getNombre1());
		textNombre1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre1.setBounds(101, 88, 214, 42);
		add(textNombre1);

		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setText(usuarioLogeado.getApellido1());

		textApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido1.setBounds(101, 135, 214, 42);
		add(textApellido1);

		RSTextFull textCedula = new RSTextFull();
		textCedula.setText(usuarioLogeado.getDocumento());
		textCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCedula.setBounds(101, 187, 214, 42);
		add(textCedula);

		RSTextFull textEmailPersonal = new RSTextFull();
		textEmailPersonal.setText(usuarioLogeado.getMail());
		textEmailPersonal.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailPersonal.setBounds(101, 239, 214, 42);
		add(textEmailPersonal);

		RSComboBox comboBoxDepartamento = new RSComboBox();
		modeloDep = new DefaultComboBoxModel();
		comboBoxDepartamento.setModel(modeloDep);
		comboBoxDepartamento.setColorFondo(new Color(52, 152, 219));
		comboBoxDepartamento.setBounds(101, 291, 214, 42);
		add(comboBoxDepartamento);

		RSTextFull textEmailUtec = new RSTextFull();
		textEmailUtec.setText(usuarioLogeado.getMailInstitucional());
		textEmailUtec.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmailUtec.setBounds(101, 343, 214, 42);
		add(textEmailUtec);

		RSComboBox comboBoxITR = new RSComboBox();
		modeloITR = new DefaultComboBoxModel();
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(420, 341, 214, 42);
		add(comboBoxITR);

		JLabel lblNombre2 = new JLabel("Segundo Nombre");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(329, 102, 86, 14);
		add(lblNombre2);

		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setText(usuarioLogeado.getNombre2());
		textNombre2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNombre2.setBounds(420, 88, 214, 42);
		add(textNombre2);

		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(329, 149, 102, 14);
		add(lblApellido2);

		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setText(usuarioLogeado.getApellido2());
		textApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textApellido2.setBounds(420, 135, 214, 42);
		add(textApellido2);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento*");
		lblFechaNacimiento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaNacimiento.setBounds(325, 201, 110, 14);
		add(lblFechaNacimiento);

		RSDateChooser FechaNacimiento = new RSDateChooser();
		FechaNacimiento.setDatoFecha(usuarioLogeado.getFechaNacimiento());
		FechaNacimiento.setBounds(420, 187, 214, 42);
		add(FechaNacimiento);

		JLabel lblTelefonoDeContacto = new JLabel("TelÃ©fono de");
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
		textTelefonoContacto.setText(usuarioLogeado.getTelefono());
		textTelefonoContacto.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTelefonoContacto.setBounds(420, 239, 214, 42);
		add(textTelefonoContacto);

		JLabel lblLocalidad = new JLabel("Localidad*");
		lblLocalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalidad.setBounds(361, 306, 54, 14);
		add(lblLocalidad);

		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setText(usuarioLogeado.getLocalidad());
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
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Usuario usuarioMod = usuarioLogeado;
				try {
					
					String apellido1=textApellido1.getText();
				
					if(apellido1.length()>50) {
						throw new Exception("El campo primer apellido debe contener menos de 50 caracteres.");
					}
						
					//^[a-zA-Z]+$ matches only strings that consist of one or more letters only (^ and $ mark the begin and end of a string respectively)
						
					if(!apellido1.matches("^[a-zA-Z]+$")) {
						throw new Exception("El campo primer apellido no puede ser vacÃ­o y debe contener solo letras.");
					}
					
					usuarioMod.setApellido1(apellido1);
					
					String apellido2=textApellido2.getText();
					
					if(apellido2.length()>50) {
						throw new Exception("El campo segundo apellido debe contener menos de 50 caracteres.");
					}
						
					//^[a-zA-Z]+$ matches only strings that consist of one or more letters only (^ and $ mark the begin and end of a string respectively)
						
					if(!apellido2.isEmpty()){
						if(!apellido2.matches("^[a-zA-Z]+$")) {
							throw new Exception("El campo segundo apellido no puede ser vacÃ­o y debe contener solo letras.");
						}
					}
					
					usuarioMod.setApellido2(apellido2);
					
					String nombre1=textNombre1.getText();
					
					if(nombre1.length()>50) {
						throw new Exception("El campo primer nombre debe contener menos de 50 caracteres.");
					}
						
					//^[a-zA-Z]+$ matches only strings that consist of one or more letters only (^ and $ mark the begin and end of a string respectively)
						
					if(!nombre1.matches("^[a-zA-Z]+$")) {
						throw new Exception("El campo primer nombre no puede ser vacÃ­o y debe contener solo letras.");
					}
				
					
					usuarioMod.setNombre1(nombre1);
					
					String nombre2=textNombre2.getText();
					
					if(nombre2.length()>50) {
						throw new Exception("El campo segundo nombre debe contener menos de 50 caracteres.");
					}
						
					
					if(!textNombre2.getText().isEmpty()) {
						if(nombre2.isBlank()) {
							throw new Exception("El campo segundo nombre no puede ser solo espacios");
						}
						if((nombre2.matches("^[0-9]*$"))){
							throw new Exception("El campo segundo nombre no puede contener numeros");
						}
						if(nombre2.contains(" ")) {
							throw new Exception("No puede contener espacios vacios");
						}
					}
						
					usuarioMod.setNombre2(nombre2);
					
					// corresponde en editar usuario siendo un analista
			 		// usuarioMod.setContrasena(password.getText());
			 		
			 		String valorCBDepString = comboBoxDepartamento.getSelectedItem().toString();
						
					if(valorCBDepString==""){
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
						throw new Exception("Fecha inválida, introduzca una fecha menor a la actual.");
					}
					// falta campo Genero
//					usuarioMod.setGenero(DAOGeneral.generoRemote.buscarGeneroPorId((long) 1));
					
					String valorCBITRString = comboBoxITR.getSelectedItem().toString();
						
					if(valorCBITRString==""){
						throw new Exception("Debe seleccionar un ITR");
					}
					
					usuarioMod.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(valorCBITRString));
					
					String localidad =textLocalidad.getText();
				
					if(textLocalidad.getText().equalsIgnoreCase("")) {
						throw new Exception("El campo localidad no puede ser vacio");
					}
							
					if( (!localidad.matches("\\w.*") ) ){
						throw new Exception("El campo localidad debe contener letras");		
					}
							
					if(localidad.length()>50){
						throw new Exception("El campo localidad no puede contener mas de 50 caracteres");
					} 
					
					usuarioMod.setLocalidad(localidad.replaceAll("\\s", ""));
					
					String mailPersonal= textEmailPersonal.getText();
				
					if(!mailPersonal.contains("@")){
						throw new Exception("Formato de email personal incorrecto");
					}
					
					usuarioMod.setMail(mailPersonal);
					
					String mailInstitucional= textEmailUtec.getText();
				
					if(!mailInstitucional.contains("@")){
						throw new Exception("Formato de email institucional incorrecto");
					}
					
					usuarioMod.setMailInstitucional(mailInstitucional);
					
					String tel = textTelefonoContacto.getText();
					
					if(!esNumerico(tel)) {
						throw new Exception("Ingrese un telÃ©fono vÃ¡lido");
					}
					
					usuarioMod.setTelefono(tel);
					
				
					
					String doc = textCedula.getText();
					
					if(doc.length()!=8 || doc == "        " || !esNumerico(doc)){
						throw new Exception("Formato de documento inválido, debe contener 8 dígitos numericos");
					}else{
						usuarioMod.setDocumento(doc);
					}
					
					if (usuarioMod instanceof Tutor) {

						((Tutor) usuarioMod).setAreaTutor(DAOGeneral.areaTutorRemote.buscarPorNombre(comboBoxAreaTutor.getSelectedItem().toString()));
						((Tutor) usuarioMod).setTipoTutor(DAOGeneral.tipoTutorRemote.obtenerTipoTutorPorNombre(
								comboBoxRolTutor.getSelectedItem().toString()));

					} else if (usuarioMod instanceof Estudiante) {
						((Estudiante) usuarioMod).setAnoIngreso(yearDate.getYear());
					}

					DAOGeneral.usuarioRemote.modificarUsuario(usuarioMod);
					
					PanelGestionUsuarios.getInstancia().cargarDatosTabla(DAOGeneral.usuarioRemote.obtenerUsuarios());
					JOptionPane.showMessageDialog(null, "Se modifico correctamente el usuario", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
					FrameModificarDatosUsuarios.getInstancia().setVisible(false);
					
				} catch (Exception m) {
					JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(462, 486, 172, 33);
		add(btnhvrGuardar);

		try {
			cargarComboComun();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		comboBoxITR.setSelectedItem(usuarioLogeado.getItr().getNombre());
		comboBoxDepartamento.setSelectedItem(usuarioLogeado.getDepartamento().getNombre());

	}

	public void cargarComboComun() throws ServicesException {
		modeloDep.removeAllElements();
		modeloDep.addElement("");
		for (Departamento d : DAOGeneral.DepRemote.obtenerDepartamento()) {
			modeloDep.addElement(d.getNombre());
		}

		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITR.addElement(itr.getNombre());
		}
	}

	public void cargarComboTutor() throws ServicesException {
		modeloAreaTutor.removeAllElements();
		modeloAreaTutor.addElement("");
		for (AreaTutor a : DAOGeneral.areaTutorRemote.obtenerAreaTutor()) {
			modeloAreaTutor.addElement(a.getNombre());
		}

		modeloTipoTutor.removeAllElements();
		modeloTipoTutor.addElement("");
		for (TipoTutor t : DAOGeneral.tipoTutorRemote.obtenerTipoTutor()) {
			modeloTipoTutor.addElement(t.getNombre());
		}

	}
	
	//	si usa un numero que no sea entre 0 y 9
	//  se te va a romper porque la parte "d+" solo trabaja 
	// con numeros arabicos.

	public static boolean esNumerico(String str) {
 	 return str.matches("-?\\d+(\\.\\d+)?");
	}
}
