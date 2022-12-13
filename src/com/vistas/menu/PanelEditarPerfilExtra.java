package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.controlador.DAOGeneral;
import com.entities.AreaTutor;
import com.entities.Estudiante;
import com.entities.TipoTutor;
import com.entities.Tutor;
import com.exception.ServicesException;

import rojeru_san.rsfield.RSTextFull;
import rojerusan.RSComboBox;

public class PanelEditarPerfilExtra extends JPanel {
	
	DefaultComboBoxModel modeloAreaTutor=new DefaultComboBoxModel();
	DefaultComboBoxModel modeloTipoTutor=new DefaultComboBoxModel();
	static public RSTextFull yearDate;
	static public RSComboBox comboBoxAreaTutor;
	static public RSComboBox comboBoxRolTutor;
	
	public PanelEditarPerfilExtra() {
	}
	public void initUIEstudiante() {
		removeAll();
		setLayout(null);
		
		yearDate = new RSTextFull();
		yearDate.setBordeColorFocus(Color.LIGHT_GRAY);
		yearDate.setMostrarBoton(false);
		yearDate.setHorizontalAlignment(SwingConstants.CENTER);
		yearDate.setBounds(89, 4, 250, 42);
		yearDate.setText(((((Estudiante) Menu.getUsuario()).getAnoIngreso())+""));
		add(yearDate);
		
		
		JLabel lblAoDeIngreso = new JLabel("A\u00f1o de ingreso");
		lblAoDeIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAoDeIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAoDeIngreso.setBounds(-1, 11, 86, 14);
		add(lblAoDeIngreso);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("a la carrera *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(-1, 26, 86, 14);
		add(lblTelefonoDeContacto_1);
		
		yearDate.setEnabled(false);
	}
	
	public void initUITutor() {
		setLayout(null);
		
		JLabel lblAreaTutor = new JLabel("Area*");
		lblAreaTutor.setBounds(1, 73, 78, 14);
		lblAreaTutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAreaTutor.setFont(new Font("Lato", Font.PLAIN, 11));
		add(lblAreaTutor);
		
		comboBoxRolTutor = new RSComboBox();
		comboBoxRolTutor.setColorBoton(Color.WHITE);
		comboBoxRolTutor.setModel(modeloTipoTutor);
		comboBoxRolTutor.setBounds(89, 6, 250, 42);
		comboBoxRolTutor.setEnabled(false);
		comboBoxRolTutor.setColorArrow(Color.DARK_GRAY);
		comboBoxRolTutor.setColorBoton(Color.LIGHT_GRAY);
		comboBoxRolTutor.setConBorde(true);
		comboBoxRolTutor.setColorBorde(Color.LIGHT_GRAY);
		add(comboBoxRolTutor);
		
		comboBoxAreaTutor = new RSComboBox();
		comboBoxAreaTutor.setColorBoton(Color.WHITE);
		comboBoxAreaTutor.setModel(modeloAreaTutor);
		comboBoxAreaTutor.setBounds(89, 58, 250, 42);
		comboBoxAreaTutor.setEnabled(false);
		comboBoxAreaTutor.setColorArrow(Color.DARK_GRAY);
		comboBoxAreaTutor.setColorBoton(Color.LIGHT_GRAY);
		comboBoxAreaTutor.setConBorde(true);
		comboBoxAreaTutor.setColorBorde(Color.LIGHT_GRAY);
		
		
		add(comboBoxAreaTutor);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRol.setFont(new Font("Lato", Font.PLAIN, 11));
		lblRol.setBounds(1, 22, 78, 14);
		add(lblRol);
		cargarComboBox();
		
		comboBoxAreaTutor.setSelectedItem(((Tutor) Menu.getUsuario()).getAreaTutor().getNombre());
		comboBoxRolTutor.setSelectedItem(((Tutor) Menu.getUsuario()).getTipoTutor().getNombre());
		comboBoxAreaTutor.setEditable(false);
		comboBoxRolTutor.setEditable(false);


	}
	
	public void initUIAnalista() {
		
		
	}
	
	
	public void cargarComboBox() {	
		try {
			modeloAreaTutor.removeAllElements();
			modeloAreaTutor.addElement("");
			for(AreaTutor t:DAOGeneral.areaTutorRemote.obtenerAreaTutor()) {
				modeloAreaTutor.addElement(t.getNombre());
			}
			
			modeloTipoTutor.removeAllElements();
			modeloTipoTutor.addElement("");
			for(TipoTutor tp:DAOGeneral.tipoTutorRemote.obtenerTipoTutor()) {
				modeloTipoTutor.addElement(tp.getNombre());
			}
		} catch (ServicesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);

		}
	}
}
