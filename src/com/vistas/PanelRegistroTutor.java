package com.vistas;

import javax.swing.JPanel;

import com.controlador.DAOGeneral;
import com.entities.AreaTutor;
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
	public static RSComboBox comboBoxArea;
	public static RSComboBox comboBoxRol;

	public DefaultComboBoxModel modeloRol=new DefaultComboBoxModel();
	
	public DefaultComboBoxModel modeloArea=new DefaultComboBoxModel();
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
		comboBoxRol.setModel(modeloRol);
		comboBoxRol.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxRol.setColorFondo(new Color(52, 152, 219));
		comboBoxRol.setBounds(321, 36, 250, 42);
		add(comboBoxRol);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Lato", Font.PLAIN, 11));
		lblArea.setBounds(0, 11, 61, 14);
		add(lblArea);
		
		comboBoxArea = new RSComboBox();
		comboBoxArea.setModel(modeloArea);
		comboBoxArea.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBoxArea.setColorSeleccion(new Color(52, 152, 219));
		comboBoxArea.setColorFondo(new Color(52, 152, 219));
		comboBoxArea.setBounds(0, 36, 250, 42);
		add(comboBoxArea);
	}
	public static PanelRegistroTutor getInstancia(){
		return instancia;
	}
	
	public void cargarComboTipo() {
		modeloRol.removeAllElements();
		modeloRol.addElement("");
		
		modeloArea.removeAllElements();
		modeloArea.addElement("");
		try {
			for(TipoTutor t:DAOGeneral.tipoTutorRemote.obtenerTipoTutor()){
				modeloRol.addElement(t.getNombre());
			}
			
			for(AreaTutor a:DAOGeneral.areaTutorRemote.obtenerAreaTutor()){
				modeloArea.addElement(a.getNombre());
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void reset() {
		instancia=new PanelRegistroTutor();
	}
}
