package com.vistas;

import javax.swing.JPanel;

import com.controlador.DAOGeneral;
import com.controlador.DAOGenero;
import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.Usuario;
import com.exception.ServicesException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSTextFull;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rsfield.RSPassword;

public class PanelRegistroPag extends JPanel {
	
	private static PanelRegistroPag instancia = new PanelRegistroPag();
	
//	PanelRegistroPag2 panelRegistroPag2;
	Registro regsitro = Registro.getInstancia();
	
	public static Usuario usuarioRegistro;
	private RSPassword password;

	/**
	 * Create the panel.
	 */
	public PanelRegistroPag() {
		setLayout(null);
		setBounds(100, 100, 710, 495);
		
		
		JLabel lblNombre1 = new JLabel("Nombre 1");
		lblNombre1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre1.setBounds(70, 90, 61, 14);
		add(lblNombre1);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setPlaceholder(" Nombre...");
		textNombre1.setFont(new Font("Lato", Font.BOLD, 14));
		textNombre1.setBounds(70, 115, 250, 42);
		textNombre1.setBordeColorFocus(new Color(52, 152, 219));
		add(textNombre1);
		
		JLabel lblNombre2 = new JLabel("Nombre 2");
		lblNombre2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombre2.setBounds(390, 90, 61, 14);
		add(lblNombre2);
		
		RSTextFull textNombre2 = new RSTextFull();
		textNombre2.setPlaceholder(" Nombre...");
		textNombre2.setFont(new Font("Lato", Font.BOLD, 14));
		textNombre2.setBounds(390, 115, 250, 42);
		textNombre2.setBordeColorFocus(new Color(52, 152, 219));
		add(textNombre2);
		
		RSTextFull textApellido1 = new RSTextFull();
		textApellido1.setPlaceholder(" Apellido...");
		textApellido1.setFont(new Font("Lato", Font.BOLD, 14));
		textApellido1.setBounds(70, 193, 250, 42);
		textApellido1.setBordeColorFocus(new Color(52, 152, 219));
		add(textApellido1);
		
		JLabel lbApellido1 = new JLabel("Apellido 1");
		lbApellido1.setFont(new Font("Lato", Font.PLAIN, 11));
		lbApellido1.setBounds(70, 168, 61, 14);
		add(lbApellido1);
		
		RSTextFull textdOCUMENTO = new RSTextFull();
		textdOCUMENTO.setPlaceholder(" Documento...");
		textdOCUMENTO.setFont(new Font("Lato", Font.BOLD, 14));
		textdOCUMENTO.setBounds(70, 271, 250, 42);
		textdOCUMENTO.setBordeColorFocus(new Color(52, 152, 219));
		add(textdOCUMENTO);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDocumento.setBounds(70, 246, 61, 14);
		add(lblDocumento);
		
		JLabel lblEmailPersonal = new JLabel("Contrase\u00F1a");
		lblEmailPersonal.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailPersonal.setBounds(70, 324, 77, 14);
		add(lblEmailPersonal);
		
		JLabel lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblApellido2.setBounds(390, 168, 61, 14);
		add(lblApellido2);
		
		RSTextFull textApellido2 = new RSTextFull();
		textApellido2.setPlaceholder(" Apellido...");
		textApellido2.setFont(new Font("Lato", Font.BOLD, 14));
		textApellido2.setBounds(390, 193, 250, 42);
		textApellido2.setBordeColorFocus(new Color(52, 152, 219));
		add(textApellido2);
		
		JLabel lblFecNac = new JLabel("Fecha Naciemiento");
		lblFecNac.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFecNac.setBounds(390, 246, 100, 14);
		add(lblFecNac);
		
		JLabel lblEmailUtec = new JLabel("Telefono");
		lblEmailUtec.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmailUtec.setBounds(390, 324, 93, 14);
		add(lblEmailUtec);
		
		RSTextFull textTelefono = new RSTextFull();
		textTelefono.setPlaceholder(" Telefono ...");
		textTelefono.setFont(new Font("Lato", Font.BOLD, 14));
		textTelefono.setBounds(390, 349, 250, 42);
		textTelefono.setBordeColorFocus(new Color(52, 152, 219));
		add(textTelefono);
		
		JLabel lblTitulo = new JLabel("REGISTRO USUARIO");
		lblTitulo.setFont(new Font("Lato", Font.BOLD, 50));
		lblTitulo.setBounds(116, 11, 524, 58);
		add(lblTitulo);
		
		RSDateChooser dateChooser = new RSDateChooser();
		dateChooser.setColorBackground(new Color(52, 152, 219));
		dateChooser.setBounds(390, 271, 250, 42);
		add(dateChooser);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(70, 436, 172, 33);
		add(btnhvrCancelar);
		
		password = new RSPassword();
		password.setPlaceholder(" Contrase\u00F1a... ");
		password.setMostrarBoton(false);
		password.setForeground(new Color(27, 91, 124));
		password.setBordeColorFocus(new Color(52, 152, 219));
		password.setBounds(70, 348, 250, 42);
		add(password);
		
		RSButtonHover btnhvrSiguiente = new RSButtonHover();
		btnhvrSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					usuarioRegistro=new Analista();
					
					usuarioRegistro.setActivo(true);
					
					usuarioRegistro.setApellido1(textApellido1.getText());
					
					usuarioRegistro.setApellido2(textApellido2.getText());
										
					usuarioRegistro.setDocumento(textdOCUMENTO.getText());
					
					
	//				LocalDate localDate = LocalDate.of(1999, 04, 01);
	//				Date date= Date.valueOf(localDate);
	
					//pasar de util.date a sql.date
					
		
					java.util.Date fecha= dateChooser.getDatoFecha();
					
					LocalDate fechaActualLD = LocalDate.now();
//		
					java.sql.Date fechaActualSQL=java.sql.Date.valueOf(fechaActualLD);
					
					java.util.Date fechaActualDATE = new java.util.Date(fechaActualSQL.getTime());
					
					if(fecha.before(fechaActualDATE)){
						java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
				    	usuarioRegistro.setFechaNacimiento(sqlDate);
					}else{
						throw new Exception("Fecha inválida, introduzca una fecha menor a la actual.");
					}
				    
				    				    
//				    if(mailPersonal.contains("@")){
//						usuarioRegistro.setMail(mailPersonal);
//					}else{
//						throw new Exception("Formato de email personal incorrecto");
//					}
//					
//					String mailInstitucional =textTelefono.getText();
//				
//					
//					if(mailInstitucional.contains("@")){
//						usuarioRegistro.setMailInstitucional(mailInstitucional);
//					}else{
//						throw new Exception("Formato de email institucional incorrecto");
//					}
					
					usuarioRegistro.setNombre1(textNombre1.getText());
					
					usuarioRegistro.setNombre2(textNombre2.getText());
					
					usuarioRegistro.setTelefono(textTelefono.getText());
					usuarioRegistro.setContrasena(password.getText());
					
//					String[] splitNombreUsuario=textTelefono.getText().split("@");
//					usuarioRegistro.setNombreUsuario(splitNombreUsuario[0]);
				
					Registro.mostrarPag2(PanelRegistroPag2.getInstancia());

				}catch(Exception m) {
					JOptionPane.showMessageDialog(null, m.getMessage(),
						      "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				

				
				
				
				
				
				
				Usuario estudiante=new Estudiante();
				
				
//				Registro.getPanelDinamico().removeAll();
//				panelRegistroPag2.setSize(710, 495);
//				panelRegistroPag2.setLocation(0, 0);
//				Registro.getPanelDinamico().add(panelRegistroPag2);
//				Registro.getPanelDinamico().revalidate();
//				Registro.getPanelDinamico().repaint();
			}
		});
		btnhvrSiguiente.setText("Siguiente");
		btnhvrSiguiente.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrSiguiente.setBackground(new Color(52, 152, 219));
		btnhvrSiguiente.setBounds(468, 436, 172, 33);
		add(btnhvrSiguiente);
		
		
		
		
		
		

	}
	
	public static PanelRegistroPag getInstancia(){
		return instancia;
	}
}
