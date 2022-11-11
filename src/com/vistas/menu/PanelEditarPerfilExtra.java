package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import rojeru_san.rsdate.RSYearDate;
import rojerusan.RSComboBox;

import java.awt.Color;
import javax.swing.SwingConstants;

import com.controlador.DAOGeneral;
import com.entities.AreaTutor;
import com.entities.TipoTutor;
import com.entities.Tutor;
import com.entities.Estudiante;
import com.exception.ServicesException;

public class PanelEditarPerfilExtra extends JPanel {
	
	DefaultComboBoxModel modeloAreaTutor=new DefaultComboBoxModel();
	DefaultComboBoxModel modeloTipoTutor=new DefaultComboBoxModel();
	static public RSYearDate yearDate;
	static public RSComboBox comboBoxAreaTutor;
	static public RSComboBox comboBoxRolTutor;
	public PanelEditarPerfilExtra() {

	}
	public void initUIEstudiante() {
		removeAll();
		setLayout(null);
		
		yearDate = new RSYearDate();
		yearDate.setColorBackground(new Color(52, 152, 219));
		yearDate.setBounds(98, 10, 250, 42);
//		yearDate.setYear(((Estudiante) Menu.usuarioIngresado).getAnoIngreso());
		add(yearDate);
		
		
		JLabel lblAoDeIngreso = new JLabel("A;o de ingreso");
		lblAoDeIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAoDeIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAoDeIngreso.setBounds(10, 17, 86, 14);
		add(lblAoDeIngreso);
		
		JLabel lblTelefonoDeContacto_1 = new JLabel("a la carrera *");
		lblTelefonoDeContacto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoDeContacto_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTelefonoDeContacto_1.setBounds(10, 32, 86, 14);
		add(lblTelefonoDeContacto_1);
	}
	
	public void initUITutor() {
		setLayout(null);
		
		JLabel lblAreaTutor = new JLabel("Area*");
		lblAreaTutor.setBounds(5, 77, 78, 14);
		lblAreaTutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAreaTutor.setFont(new Font("Lato", Font.PLAIN, 11));
		add(lblAreaTutor);
		
		comboBoxRolTutor = new RSComboBox();
		comboBoxRolTutor.setModel(modeloTipoTutor);
		comboBoxRolTutor.setBounds(93, 10, 250, 42);
		comboBoxRolTutor.setColorFondo(new Color(52, 152, 219));
		add(comboBoxRolTutor);
		
		comboBoxAreaTutor = new RSComboBox();
		comboBoxAreaTutor.setModel(modeloAreaTutor);
		comboBoxAreaTutor.setColorFondo(new Color(52, 152, 219));
		comboBoxAreaTutor.setBounds(93, 62, 250, 42);
		add(comboBoxAreaTutor);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRol.setFont(new Font("Lato", Font.PLAIN, 11));
		lblRol.setBounds(5, 26, 78, 14);
		add(lblRol);
		cargarComboBox();
		
		comboBoxAreaTutor.setSelectedItem(((Tutor) Menu.getUsuario()).getAreaTutor().getNombre());
		comboBoxRolTutor.setSelectedItem(((Tutor) Menu.getUsuario()).getTipoTutor().getNombre());

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
