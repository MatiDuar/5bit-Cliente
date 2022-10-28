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

	public DefaultComboBoxModel modeloTipo=new DefaultComboBoxModel();
	/**
	 * Create the panel.
	 */
	public PanelRegistroTutor() {

		setLayout(null);
		setBounds(100, 100, 571, 187);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Rol");
		lblNewLabel_1_2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setBounds(321, 11, 61, 14);
		add(lblNewLabel_1_2_2);
		
		comboBoxTipo = new RSComboBox();
		comboBoxTipo.setModel(modeloTipo);
		comboBoxTipo.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxTipo.setColorFondo(new Color(52, 152, 219));
		comboBoxTipo.setBounds(321, 36, 250, 42);
		add(comboBoxTipo);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Lato", Font.PLAIN, 11));
		lblArea.setBounds(0, 11, 61, 14);
		add(lblArea);
		
		RSTextFull textNombre1 = new RSTextFull();
		textNombre1.setMostrarBoton(false);
		textNombre1.setFont(new Font("Lato", Font.BOLD, 14));
		textNombre1.setPlaceholder("Ingrese Area...");
		textNombre1.setBounds(0, 36, 250, 42);
		add(textNombre1);
	}
	public static PanelRegistroTutor getInstancia(){
		return instancia;
	}
	
	public void cargarComboTipo() {
		modeloTipo.removeAllElements();
		modeloTipo.addElement("");
		try {
			for(TipoTutor t:DAOGeneral.tipoTutorRempote.obtenerTipoTutor()){
				modeloTipo.addElement(t.getNombre());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}
