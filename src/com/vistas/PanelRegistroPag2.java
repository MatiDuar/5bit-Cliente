package com.vistas;

import javax.swing.JPanel;

import com.controlador.DAOGeneral;
import com.entities.Analista;
import com.entities.Departamento;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.vistas.menu.PanelEditarPerfilExtra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSTextFull;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import rojeru_san.rsfield.RSPassword;
import rojerusan.RSComboBox;
import rojerusan.RSCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import rojerusan.RSRadioButton;
import RSMaterialComponent.RSPanelMaterial;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PanelRegistroPag2 extends JPanel {
	
	private static final PanelRegistroPag2 instancia = new PanelRegistroPag2();
	// Inntancias Paneles
	Registro registro = Registro.getInstancia();
	PanelRegistroPag panelRegistroPag1 = PanelRegistroPag.getInstancia();
	PanelRegistroEstudiante panelRegistroEstudiante = PanelRegistroEstudiante.getInstancia();
	PanelRegistroTutor panelRegistroTutor = PanelRegistroTutor.getInstancia();
	// Radio button
	private RSRadioButton radioAnalista;
	private RSRadioButton radioTutor;
	private RSRadioButton radioEstudiante;
	
	 DefaultComboBoxModel modeloDep=new DefaultComboBoxModel<>();;
	 RSComboBox comboBoxDep;
	 RSComboBox comboBoxITR;
	 DefaultComboBoxModel modeloITR=new DefaultComboBoxModel<>();

	static JPanel panelDinamicoReg2;
	
	Usuario us=PanelRegistroPag.usuarioRegistro;

	/**
	 * Create the panel. 
	 */
	public PanelRegistroPag2() {
		setLayout(null);
		setBounds(100, 100, 710, 495);
		
		JLabel lblNewLabel = new JLabel("REGISTRO USUARIO");
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		lblNewLabel.setBounds(116, 11, 512, 58);
		add(lblNewLabel);
				
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
		
		RSButtonHover btnRegistrarse = new RSButtonHover();
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioAnalista.isSelected()) {
					try {
						Analista analistaRegistro=(Analista) PanelRegistroPag.usuarioRegistro;
						PanelRegistroPag.usuarioRegistro.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(comboBoxDep.getSelectedItem().toString()));
						PanelRegistroPag.usuarioRegistro.setLocalidad("El pinar");
						PanelRegistroPag.usuarioRegistro.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(comboBoxITR.getSelectedItem().toString()));						
						DAOGeneral.usuarioRemote.crearUsuario(PanelRegistroPag.usuarioRegistro);
						System.out.println("LOCURAAAAAAAAA");
					}catch(Exception m) {
						m.printStackTrace();
					}
				}else if(radioTutor.isSelected()) {
					try {
						Tutor tutorRegistro=(Tutor) PanelRegistroPag.usuarioRegistro;
						tutorRegistro.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(comboBoxDep.getSelectedItem().toString()));
						tutorRegistro.setLocalidad("El pinar");
						tutorRegistro.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(comboBoxITR.getSelectedItem().toString()));						
						
						//no se si va hacer un comboBox o un textField
						tutorRegistro.setAreaTutor(DAOGeneral.areaTutorRemote.buscarAreaTutorPorId((long)1));
						tutorRegistro.setTipoTutor(DAOGeneral.tipoTutorRemote.buscarTipoTutorPorId((long)PanelRegistroTutor.comboBoxTipo.getSelectedIndex()));
						DAOGeneral.usuarioRemote.crearUsuario(tutorRegistro);
						System.out.println("LOCURAAAAAAAAA");
					}catch(Exception m) {
						m.printStackTrace();
					}
				}else if(radioEstudiante.isSelected()) {
					Estudiante estudianteRegistro=(Estudiante) PanelRegistroPag.usuarioRegistro;
					
					try {
						estudianteRegistro.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(comboBoxDep.getSelectedItem().toString()));
						estudianteRegistro.setLocalidad("El pinar");
						estudianteRegistro.setItr(DAOGeneral.itrRemote.obtenerItrPorNombre(comboBoxITR.getSelectedItem().toString()));						
						//no se como hacerlo por que la tabla generacion solo tiene nombre y no es por a;o
						
						estudianteRegistro.setAnoIngreso(0);
						
						DAOGeneral.usuarioRemote.crearUsuario(estudianteRegistro);
					} catch (ServicesException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		});

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
				registro.mostrarDatoEstudiante(panelRegistroEstudiante);
				
			}
		});
		radioEstudiante.setBounds(384, 270, 83, 42);
		add(radioEstudiante);
		
		radioTutor = new RSRadioButton();
		radioTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelRegistroTutor tt=new PanelRegistroTutor();
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
			System.out.println(d.getNombre());
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
}
