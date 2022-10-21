package com.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

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
import rojerusan.RSRadioButton;
import RSMaterialComponent.RSPanelMaterial;
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
	static JPanel panelDinamicoReg2;

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
		lblNewLabel_1_2.setBounds(70, 89, 61, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento");
		lblNewLabel_1_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(390, 89, 77, 14);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("ITR");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(70, 167, 61, 14);
		add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tipo de Usuario");
		lblNewLabel_1_2_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2_1.setBounds(390, 167, 77, 14);
		add(lblNewLabel_1_2_2_1);
		
		RSButtonHover btnVolver = new RSButtonHover();
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro.mostrarPag1(panelRegistroPag1);
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
			}
		});

		btnRegistrarse.setText("Registrarse");
		btnRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		btnRegistrarse.setBackground(new Color(52, 152, 219));
		btnRegistrarse.setBounds(468, 436, 172, 33);
		add(btnRegistrarse);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setColorFondo(new Color(52, 152, 219));
		comboBox.setBounds(70, 114, 250, 42);
		add(comboBox);
		
		RSComboBox comboBox_1 = new RSComboBox();
		comboBox_1.setColorFondo(new Color(52, 152, 219));
		comboBox_1.setBounds(390, 114, 250, 42);
		add(comboBox_1);
		
		RSComboBox comboBox_2 = new RSComboBox();
		comboBox_2.setColorFondo(new Color(52, 152, 219));
		comboBox_2.setBounds(70, 192, 250, 42);
		add(comboBox_2);				
				
		radioEstudiante = new RSRadioButton();
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
		radioEstudiante.setBounds(384, 192, 87, 42);
		add(radioEstudiante);
		
		radioTutor = new RSRadioButton();
		radioTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				radioEstudiante.setSelected(false);
				radioTutor.setSelected(true);
				radioAnalista.setSelected(false);	
				registro.mostrarDatosTutor(panelRegistroTutor);
			}						
		});
				
		radioTutor.setFont(new Font("Lato", Font.BOLD, 11));
		radioTutor.setText("Tutor");
		radioTutor.setBounds(468, 192, 61, 42);
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
		radioAnalista.setText("Analista");
		radioAnalista.setFont(new Font("Lato", Font.BOLD, 11));
		radioAnalista.setBounds(531, 192, 77, 42);
		add(radioAnalista);
		
		panelDinamicoReg2 = new JPanel();
		panelDinamicoReg2.setBounds(70, 245, 570, 174);
		add(panelDinamicoReg2);
		panelDinamicoReg2.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(135, 48, 89, 23);
		panelDinamicoReg2.add(btnNewButton);
		panelRegistroTutor.setSize(570, 186);
		panelRegistroTutor.setLocation(0, 0);
		

	}
	
	public static PanelRegistroPag2 getInstancia(){
		return instancia;
	}
	
}
