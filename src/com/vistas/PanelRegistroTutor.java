package com.vistas;

import javax.swing.JPanel;

import com.controlador.DAOGeneral;
import com.entities.TipoTutor;

import rojeru_san.rsdate.RSDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import rojerusan.RSComboBox;
import java.awt.Color;
import rojeru_san.rsfield.RSTextFull;

public class PanelRegistroTutor extends JPanel {

	private static PanelRegistroTutor instancia = new PanelRegistroTutor();
			
	public static RSComboBox comboBoxTipo = new RSComboBox();
	private static RSComboBox comboBoxRol;

	public DefaultComboBoxModel modeloTipo=new DefaultComboBoxModel();
	/**
	 * Create the panel.
	 */
	public PanelRegistroTutor() {

		setLayout(null);
		setBounds(100, 100, 571, 101);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Rol");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(321, 11, 61, 14);
		add(lblNewLabel_1_2_2);
		
		comboBoxRol = new RSComboBox();
		comboBoxRol.setColorSeleccion(new Color(52, 152, 219));
		comboBoxRol.setModel(modeloTipo);
		comboBoxRol.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxRol.setColorFondo(new Color(52, 152, 219));
		comboBoxRol.setBounds(321, 36, 250, 42);
		add(comboBoxRol);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Lato", Font.PLAIN, 11));
		lblArea.setBounds(0, 11, 61, 14);
		add(lblArea);
		
		RSTextFull textArea = new RSTextFull();
		textArea.setMostrarBoton(false);
		textArea.setFont(new Font("Lato", Font.BOLD, 14));
		textArea.setPlaceholder("Ingrese Area...");
		textArea.setBounds(0, 36, 250, 42);
		textArea.setBordeColorFocus(new Color(52, 152, 219));
		add(textArea);
	}
	public static PanelRegistroTutor getInstancia(){
		return instancia;
	}
	
	public void cargarComboTipo() {
		modeloTipo.removeAllElements();
		modeloTipo.addElement("");
		try {
			for(TipoTutor t:DAOGeneral.tipoTutorRemote.obtenerTipoTutor()){
				modeloTipo.addElement(t.getNombre());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}
