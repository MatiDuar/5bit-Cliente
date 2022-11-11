package com.vistas.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.Estudiante;
import com.entities.ITR;
import com.exception.ServicesException;

import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.complementos.TableMetro;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class PanelReportesAnalistaTutor extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private DefaultTableModel modeloTabla;
	
	private DefaultComboBoxModel modeloITR;
	private DefaultComboBoxModel modeloGen;
	
	
	public PanelReportesAnalistaTutor() {
		setLayout(null);
		setBounds(0,0,700,725);
		JLabel lblTituloVentana = new JLabel("REPORTES");
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblTituloVentana.setBounds(300, 22, 102, 27);
		add(lblTituloVentana);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(PanelReportesAnalistaTutor.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(642, 10, 51, 53);
		add(labelImage);
		
		RSTextFieldIconUno textFieldIconUno = new RSTextFieldIconUno();
		textFieldIconUno.setPlaceholder("Ingrese Nombre y Apellido");
		textFieldIconUno.setBounds(10, 102, 303, 33);
		add(textFieldIconUno);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(585, 102, 108, 33);
		add(btnhvrFiltrar);
		modeloITR=new DefaultComboBoxModel();
		RSComboBox comboITR = new RSComboBox();
		comboITR.setModel(modeloITR);
		comboITR.setBounds(323, 103, 121, 32);
		add(comboITR);
		
		modeloGen=new DefaultComboBoxModel();
		RSComboBox comboGen = new RSComboBox();
		comboGen.setModel(modeloGen);
		comboGen.setBounds(454, 103, 121, 32);
		add(comboGen);
		
		modeloGen.addElement("");
		for(int i=2012;i<2023;i++) {
			modeloGen.addElement(i);
		}
		
		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Lato", Font.PLAIN, 11));
		lblITR.setBounds(323, 91, 45, 13);
		add(lblITR);
		
		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblGeneracion.setBounds(454, 91, 69, 13);
		add(lblGeneracion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 145, 683, 486);
		add(scrollPane);
		
		TableMetro tableMetro = new TableMetro();
		modeloTabla=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula", "ITR", "Generaci\u00F3n", "Email UTEC", "Tel\u00E9fono"
				}
			);
		tableMetro.setModel(modeloTabla);
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setFuenteFilas(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setFuenteHead(new Font("Tahoma", Font.BOLD, 12));
		tableMetro.setGridColor(Color.DARK_GRAY);
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setColorBordeHead(Color.DARK_GRAY);
		tableMetro.setColorBordeFilas(Color.DARK_GRAY);
		tableMetro.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(0).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableMetro.getColumnModel().getColumn(1).setMinWidth(120);
		tableMetro.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(2).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableMetro.getColumnModel().getColumn(3).setMinWidth(120);
		tableMetro.getColumnModel().getColumn(4).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(5).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(6).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(7).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(7).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(8).setMinWidth(75);
		scrollPane.setViewportView(tableMetro);
		
		RSButtonHover btnhvrEscolaridad = new RSButtonHover();
		btnhvrEscolaridad.setText("Escolaridad");
		btnhvrEscolaridad.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrEscolaridad.setBackground(new Color(0, 112, 192));
		btnhvrEscolaridad.setBounds(238, 641, 227, 33);
		add(btnhvrEscolaridad);
		try {
			cargarTabla(DAOGeneral.estudianteBean.obtenerEstudiantes());
			cargarComboBox();
		} catch (ServicesException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarTabla(List<Estudiante>estudiantes) {
//		"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula", "ITR", "Generaci\u00F3n", "Email UTEC", "Tel\u00E9fono"

		modeloTabla.setRowCount(0);
		for(Estudiante e:estudiantes) {
			Vector v=new Vector();
			v.addElement(e.getNombre1());
			v.addElement(e.getNombre2());
			v.addElement(e.getApellido1());
			v.addElement(e.getApellido2());
			v.addElement(e.getDocumento());
			v.addElement(e.getItr().getNombre());
			v.addElement(e.getAnoIngreso());
			v.addElement(e.getMailInstitucional());
			v.addElement(e.getTelefono());
			
			modeloTabla.addRow(v);
		}
	}
	
	
	public void cargarComboBox() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for(ITR i: DAOGeneral.itrRemote.obtenerItrs()){
			if(i.getActivo()) {
				modeloITR.addElement(i.getNombre());
			}
		}
	}
}