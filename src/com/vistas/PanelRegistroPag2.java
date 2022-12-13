package com.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.controlador.DAOGeneral;
import com.entities.Analista;
import com.entities.Departamento;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSTextFull;
import rojerusan.RSComboBox;
import rojerusan.RSRadioButton;

public class PanelRegistroPag2 extends JPanel {
	
	private static PanelRegistroPag2 instancia = new PanelRegistroPag2();
	// Inntancias Paneles
	Registro registro = Registro.getInstancia();
	PanelRegistroPag panelRegistroPag1 = PanelRegistroPag.getInstancia();
	PanelRegistroEstudiante panelRegistroEstudiante = PanelRegistroEstudiante.getInstancia();
	PanelRegistroTutor panelRegistroTutor = PanelRegistroTutor.getInstancia();
	// Radio button
	private RSRadioButton radioAnalista;
	private RSRadioButton radioTutor;
	private RSRadioButton radioEstudiante;
	
	 DefaultComboBoxModel modeloDep=new DefaultComboBoxModel<>();
	 RSComboBox comboBoxDep;
	 RSComboBox comboBoxITR;
	 DefaultComboBoxModel modeloITR=new DefaultComboBoxModel<>();

	static JPanel panelDinamicoReg2;
	
	Usuario us=PanelRegistroPag.usuarioRegistro;


	public PanelRegistroPag2() {
		setLayout(null);
		setBounds(100, 100, 710, 495);
		
		JLabel lblNewLabel = new JLabel("REGISTRO USUARIO");
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		lblNewLabel.setBounds(116, 11, 512, 58);
		add(lblNewLabel);
		
				RSButtonHover btnRegistrarse = new RSButtonHover();

				
		JLabel lblNewLabel_1_2 = new JLabel("Localidad");
		lblNewLabel_1_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(70, 167, 61, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(390, 167, 77, 14);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("ITR");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(70, 245, 61, 14);
		add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tipo de Usuario");
		lblNewLabel_1_2_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2_1.setBounds(390, 245, 81, 14);
		add(lblNewLabel_1_2_2_1);
		
		RSButtonHover btnVolver = new RSButtonHover();
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro.mostrarPag1(PanelRegistroPag.getInstancia());
			}
		});
		btnVolver.setText("Volver");
		btnVolver.setFont(new Font("Lato", Font.BOLD, 14));
		btnVolver.setBackground(new Color(52, 152, 219));
		btnVolver.setBounds(70, 436, 172, 33);
		add(btnVolver);
		
		

		btnRegistrarse.setText("Registrarse");
		btnRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		btnRegistrarse.setBackground(new Color(52, 152, 219));
		btnRegistrarse.setBounds(468, 436, 172, 33);
		add(btnRegistrarse);
		
		//new Color(52, 152, 219)
		comboBoxDep = new RSComboBox();
		comboBoxDep.setColorBoton(Color.WHITE);
		comboBoxDep.setColorSeleccion(new Color(52, 152, 219));
		comboBoxDep.setModel(modeloDep);
		comboBoxDep.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxDep.setColorFondo(new Color(52, 152, 219));
		comboBoxDep.setBounds(390, 192, 250, 42);
		add(comboBoxDep);
				
		comboBoxITR = new RSComboBox();
		comboBoxITR.setColorBoton(Color.WHITE);
		comboBoxITR.setColorSeleccion(new Color(52, 152, 219));
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setBounds(70, 270, 250, 42);
		add(comboBoxITR);				
				
		radioEstudiante = new RSRadioButton();
		
		radioEstudiante.setColorUnCheck(new Color(52, 152, 219));
		radioEstudiante.setForeground(new Color(52, 152, 219));
		radioEstudiante.setFont(new Font("Lato", Font.BOLD, 11));
		radioEstudiante.setText("Estudiante");
		radioEstudiante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				radioEstudiante.setSelected(true);
				radioTutor.setSelected(false);
				radioAnalista.setSelected(false);
				registro.mostrarDatoEstudiante(PanelRegistroEstudiante.getInstancia());
				
			}
		});
		radioEstudiante.setBounds(384, 270, 83, 42);
		add(radioEstudiante);
		
		radioTutor = new RSRadioButton();
		radioTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelRegistroTutor tt=PanelRegistroTutor.getInstancia();
				radioEstudiante.setSelected(false);
				radioTutor.setSelected(true);
				radioAnalista.setSelected(false);	
				tt.cargarComboTipo();
				registro.mostrarDatosTutor(tt);
			}						
		});
		radioTutor.setColorUnCheck(new Color(52, 152, 219));
		radioTutor.setForeground(new Color(52, 152, 219));		
		radioTutor.setFont(new Font("Lato", Font.BOLD, 11));
		radioTutor.setText("Tutor");
		radioTutor.setBounds(468, 270, 69, 42);
		add(radioTutor);
		
		radioAnalista = new RSRadioButton();
		radioAnalista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				radioEstudiante.setSelected(false);
				radioTutor.setSelected(false);
				radioAnalista.setSelected(true);
				panelDinamicoReg2.removeAll();
				panelDinamicoReg2.repaint();
			}
		});
		radioAnalista.setColorUnCheck(new Color(52, 152, 219));
		radioAnalista.setForeground(new Color(52, 152, 219));	
		radioAnalista.setText("Analista");
		radioAnalista.setFont(new Font("Lato", Font.BOLD, 11));
		radioAnalista.setBounds(539, 271, 77, 42);
		add(radioAnalista);
		
		panelDinamicoReg2 = new JPanel();
		panelDinamicoReg2.setBounds(70, 323, 570, 103);
		add(panelDinamicoReg2);
		panelDinamicoReg2.setLayout(null);
		
		JLabel lblEmailPersonal = new JLabel("Email Personal");
		lblEmailPersonal.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(70, 89, 77, 14);
		add(lblEmailPersonal);
		
		RSTextFull textMailPersonal = new RSTextFull();
		textMailPersonal.setPlaceholder(" Email...");
		textMailPersonal.setFont(new Font("Dialog", Font.BOLD, 14));
		textMailPersonal.setBordeColorFocus(new Color(52, 152, 219));
		textMailPersonal.setBounds(70, 114, 250, 42);
		add(textMailPersonal);
		
		JLabel lblEmailUtec = new JLabel("Email UTEC");
		lblEmailUtec.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEmailUtec.setBounds(390, 89, 61, 14);
		add(lblEmailUtec);
		
		RSTextFull textMailUtec = new RSTextFull();
		textMailUtec.setPlaceholder(" Email...");
		textMailUtec.setFont(new Font("Dialog", Font.BOLD, 14));
		textMailUtec.setBordeColorFocus(new Color(52, 152, 219));
		textMailUtec.setBounds(390, 114, 250, 42);
		add(textMailUtec);
		
		RSTextFull textLocalidad = new RSTextFull();
		textLocalidad.setPlaceholder("Localidad...");
		textLocalidad.setFont(new Font("Dialog", Font.BOLD, 14));
		textLocalidad.setBordeColorFocus(new Color(52, 152, 219));
		textLocalidad.setBounds(70, 191, 250, 42);
		add(textLocalidad);
		panelRegistroTutor.setSize(570, 186);
		panelRegistroTutor.setLocation(0, 0);
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(radioAnalista.isSelected()) {
					try {
						Analista analistaRegistro=(Analista) PanelRegistroPag.usuarioRegistro;
						
						
						//Inicio Control Email Personal
						
				        // Patrón para validar el email
				        Pattern pattern = Pattern
				                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				 
				        // El email a validar
				        String email = textMailPersonal.getText();
				 				        
				        Matcher mather = pattern.matcher(email);
				 
				        if (!mather.find()) {				   
				        	throw new Exception("El Email Personal ingresado es inválido.");
				        }
						
				        //Fin Control Email Personal
						
						analistaRegistro.setMail(textMailPersonal.getText());
						analistaRegistro.setMailInstitucional(textMailUtec.getText());
						
						//Inicio Control Email Institucional
						//verifica que este en el dominio @utec.edu.uy				        
				        Pattern patternInst = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@(utec)\\.edu\\.uy(\\W|$)");
				        
				 
				        // El email a validar
				        String emailInst = textMailUtec.getText();
				 

				        mather = patternInst.matcher(emailInst);
				 
				        if (!mather.find()) {				   
				        	throw new Exception("El email institucional no esta dentro del dominio."
				        			+ "\nEjemplo: nombre.apellido@utec.edu.uy");
				        }
						
				        //Fin Control Email Institucional
						
						
						
		
						String[] splitNombreUsuario=textMailUtec.getText().split("@");
						if(DAOGeneral.usuarioRemote.buscarNombre(splitNombreUsuario[0])!=null) {
							throw new Exception("El email institucional ya se encuentra registado en el sistema");
						}
						analistaRegistro.setNombreUsuario(splitNombreUsuario[0]);
						
						String valorCBDepString = comboBoxDep.getSelectedItem().toString();
						
						if(valorCBDepString==""){
							throw new Exception("Debe seleccionar un Departamento");
						}
						
						analistaRegistro.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(valorCBDepString));
						
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

						
						analistaRegistro.setLocalidad(localidad.replaceAll("\\s", ""));
						
						String valorCBITRString = comboBoxITR.getSelectedItem().toString();
						
						if(valorCBITRString==""){
							throw new Exception("Debe seleccionar un ITR");
						}
							
						analistaRegistro.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(valorCBITRString));
						
						analistaRegistro.setValidado(false);
						analistaRegistro.setActivo(true);		
						
						DAOGeneral.usuarioRemote.crearUsuario(analistaRegistro);
						
						JOptionPane.showMessageDialog(null, "Se registro correctamente el usuario, en espera por revision para su activacion", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						
						

						
						Registro.resetDatos();
						Registro.getInstancia().setVisible(false);
						Login login = new Login();
						login.setVisible(true);

					}catch(Exception m) {
						JOptionPane.showMessageDialog(null, m.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);					
					}
				}else if(radioTutor.isSelected()) {
					try {
						Tutor tutorRegistro=new Tutor();
						copiarUsuario(PanelRegistroPag.usuarioRegistro, tutorRegistro);
						
						
						tutorRegistro.setMailInstitucional(textMailUtec.getText());
						tutorRegistro.setMail(textMailPersonal.getText());
						
						
						//Inicio Control Email Personal
						
				        // Patrón para validar el email
				        Pattern pattern = Pattern
				                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				 
				        // El email a validar
				        String email = textMailPersonal.getText();
				 				        
				        Matcher mather = pattern.matcher(email);
				 
				        if (!mather.find()) {				   
				        	throw new Exception("El Email Personal ingresado es inválido.");
				        }
						
				        //Fin Control Email Personal
						
						//Inicio Control Email Institucional
				        //verifica que este en el dominio @utec.edu.uy
				        Pattern patternInst = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@(utec)\\.edu\\.uy(\\W|$)");
				        
				 
				        // El email a validar
				        String emailInst = textMailUtec.getText();
				 

				        mather = patternInst.matcher(emailInst);
				 
				        if (!mather.find()) {				   
				        	throw new Exception("El email institucional no esta dentro del dominio."
				        			+ "\nEjemplo: nombre.apellido@utec.edu.uy");
				        }
						
				        //Fin Control Email Institucional
						
						String[] splitNombreUsuario=textMailUtec.getText().split("@");
						if(DAOGeneral.usuarioRemote.buscarNombre(splitNombreUsuario[0])!=null) {
							throw new Exception("El email institucional ya se encuentra registado en el sistema");
						}
						tutorRegistro.setNombreUsuario(splitNombreUsuario[0]);
						
						String valorCBDepString = comboBoxDep.getSelectedItem().toString();
						
						if(valorCBDepString==""){
							throw new Exception("Debe seleccionar un Departamento");
						}
						
						tutorRegistro.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(valorCBDepString));
						
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

						
						tutorRegistro.setLocalidad(localidad);
						
						String valorCBITRString = comboBoxITR.getSelectedItem().toString();
						
						if(valorCBITRString==""){
							throw new Exception("Debe seleccionar un ITR");
						}
							
						tutorRegistro.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(valorCBITRString));
												
						System.out.println(PanelRegistroTutor.comboBoxArea.getSelectedItem().toString());
						if(PanelRegistroTutor.comboBoxArea.getSelectedItem().toString()==""){
							throw new Exception("Debe seleccionar un area para el tutor");
						}
							
						tutorRegistro.setAreaTutor(DAOGeneral.areaTutorRemote.buscarPorNombre(PanelRegistroTutor.comboBoxArea.getSelectedItem().toString()));
						
						

						String valorCBRolTutorString = PanelRegistroTutor.comboBoxRol.getSelectedItem().toString();
						
						if(valorCBRolTutorString==""){
							throw new Exception("Debe seleccionar un rol para el tutor");
						}

						tutorRegistro.setTipoTutor(DAOGeneral.tipoTutorRemote.obtenerTipoTutorPorNombre(valorCBRolTutorString));
						tutorRegistro.setValidado(false);
						tutorRegistro.setActivo(true);

						DAOGeneral.usuarioRemote.crearUsuario(tutorRegistro);
						
						JOptionPane.showMessageDialog(null, "Se registr\u00f3 correctamente el usuario, en espera por revision para su activaci\u00f3n", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						Registro.resetDatos();
						Registro.getInstancia().setVisible(false);
						Login login = new Login();
						login.setVisible(true);

					}catch(Exception m) {
						JOptionPane.showMessageDialog(null, m.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}else if(radioEstudiante.isSelected()) {
					
					try {
						Estudiante estudianteRegistro=new Estudiante();
						copiarUsuario(PanelRegistroPag.usuarioRegistro, estudianteRegistro);
						
						estudianteRegistro.setMailInstitucional(textMailUtec.getText());
						estudianteRegistro.setMail(textMailPersonal.getText());
						
						
						//Inicio Control Email Personal
						
				        // Patrón para validar el email
				        Pattern pattern = Pattern
				                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				 
				        // El email a validar
				        String email = textMailPersonal.getText();
				 				        
				        Matcher mather = pattern.matcher(email);
				 
				        if (!mather.find()) {				   
				        	throw new Exception("El Email Personal ingresado es inválido.");
				        }
						
				        //Fin Control Email Personal
						
						//Inicio Control Email Institucional
				        //verifica que este en el dominio @utec.edu.uy
				        Pattern patternInst = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@(estudiantes)\\.utec\\.edu\\.uy(\\W|$)");
				        
				 
				        // El email a validar
				        String emailInst = textMailUtec.getText();
				 

				        mather = patternInst.matcher(emailInst);
				 
				        if (!mather.find()) {				   
				        	throw new Exception("El email institucional no esta dentro del dominio."
				        			+ "\nEjemplo: nombre.apellido@estudiantes.utec.edu.uy");
				        }
						
				        //Fin Control Email Institucional
						
						
						String[] splitNombreUsuario=textMailUtec.getText().split("@");
						if(DAOGeneral.usuarioRemote.buscarNombre(splitNombreUsuario[0])!=null) {
							throw new Exception("El email institucional ya se encuentra registado en el sistema");
						}
						estudianteRegistro.setNombreUsuario(splitNombreUsuario[0]);
						
						String valorCBDepString = comboBoxDep.getSelectedItem().toString();
						
						if(valorCBDepString==""){
							throw new Exception("Debe seleccionar un Departamento");
						}
						
						estudianteRegistro.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(valorCBDepString));
						
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

						
						estudianteRegistro.setLocalidad(localidad);
						
						String valorCBITRString = comboBoxITR.getSelectedItem().toString();
						
						if(valorCBITRString==""){
							throw new Exception("Debe seleccionar un ITR");
						}
							
						estudianteRegistro.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(valorCBITRString));
						
												
						
						int fechaObtenida = PanelRegistroEstudiante.yearDate.getYear();
						
						LocalDate fechaActualLD = LocalDate.now();

						
						System.out.println(fechaObtenida);
						System.out.println(fechaActualLD.getYear());
						
						if (fechaObtenida > fechaActualLD.getYear()) {
							throw new Exception("Fecha invalida, introduzca una fecha menor a la actual.");	
						}
						
						estudianteRegistro.setAnoIngreso(fechaObtenida);
						
						estudianteRegistro.setValidado(false);
						estudianteRegistro.setActivo(true);

						
						DAOGeneral.usuarioRemote.crearUsuario(estudianteRegistro);
						JOptionPane.showMessageDialog(null, "Se registro correctamente el usuario, en espera por revision para su activacion", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						Registro.resetDatos();
						Registro.getInstancia().setVisible(false);
						Login login = new Login();
						login.setVisible(true);
				
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				
					
					
				}else {
					try {
						throw new Exception("Debe seleccionar un tipo de usuario");
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		

	}
	
	public static PanelRegistroPag2 getInstancia(){
		return instancia;
	}
	public void cargaComboBox() {
		try {
			cargarComboBoxDepartamento();
			System.out.println("Se cargo con exito los Departamentos");
			cargarComboBoxITR();
			System.out.println("Se cargo con exito los ITR");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void cargarComboBoxDepartamento() throws ServicesException {
		modeloDep.removeAllElements();
		modeloDep.addElement("");

		for(Departamento d:DAOGeneral.DepRemote.obtenerDepartamento()) {
			modeloDep.addElement(d.getNombre());
		}
	}
	
	public void cargarComboBoxITR() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for(ITR itr:DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITR.addElement(itr.getNombre());
			System.out.println(itr.getNombre());
		}
	}
	
	
	public void copiarUsuario(Usuario a,Usuario b){
		b.setDocumento(a.getDocumento());
		b.setFechaNacimiento(a.getFechaNacimiento());
		b.setActivo(a.getActivo());
		b.setApellido1(a.getApellido1());
		b.setApellido2(a.getApellido2());
		b.setContrasena(a.getContrasena());
		b.setDepartamento(a.getDepartamento());
		b.setGenero(a.getGenero());
		b.setItr(a.getItr());
		b.setLocalidad(a.getLocalidad());
		b.setMail(b.getMail());
		b.setMailInstitucional(a.getMailInstitucional());
		b.setNombre1(a.getNombre1());
		b.setNombre2(a.getNombre2());
		b.setTelefono(a.getTelefono());
		b.setNombreUsuario(a.getNombreUsuario());
	}
	
	
	
	public static void reset() {
		instancia=new PanelRegistroPag2();
	}
}
