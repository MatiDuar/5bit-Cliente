package com.vistas.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import rojeru_san.efectos.ValoresEnum.ICONS;

public class PanelReportesAnalistaTutor extends JPanel {

	/**
	 * Create the panel.
	 */

	private DefaultTableModel modeloTabla;

	private DefaultComboBoxModel modeloITR;
	private DefaultComboBoxModel modeloGen;

	public PanelReportesAnalistaTutor() {
		setLayout(null);
		setBounds(0, 0, 700, 725);
		JLabel lblTituloVentana = new JLabel("REPORTES");
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblTituloVentana.setBounds(299, 22, 180, 27);
		add(lblTituloVentana);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(PanelReportesAnalistaTutor.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(642, 10, 51, 53);
		add(labelImage);

		RSTextFieldIconUno textBuscar = new RSTextFieldIconUno();
		textBuscar.setBorderColor(new Color(52, 152, 219));
		textBuscar.setIcons(ICONS.SEARCH);
		textBuscar.setFont(new Font("Lato", Font.BOLD, 14));
		textBuscar.setPlaceholder("Ingrese Nombre y Apellido");
		textBuscar.setBounds(10, 102, 303, 33);
		add(textBuscar);

		modeloITR = new DefaultComboBoxModel();
		RSComboBox comboITR = new RSComboBox();
		comboITR.setColorFondo(new Color(52, 152, 219));
		comboITR.setFont(new Font("Lato Black", Font.BOLD, 14));
		comboITR.setModel(modeloITR);
		comboITR.setBounds(323, 103, 121, 32);
		add(comboITR);

		modeloGen = new DefaultComboBoxModel();
		RSComboBox comboGen = new RSComboBox();
		comboGen.setColorFondo(new Color(52, 152, 219));
		comboGen.setFont(new Font("Lato Black", Font.BOLD, 14));
		comboGen.setModel(modeloGen);
		comboGen.setBounds(454, 103, 121, 32);
		add(comboGen);

		modeloGen.addElement("");
		for (int i = 2012; i < 2023; i++) {
			modeloGen.addElement(i);
		}

		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Estudiante> estudiantesFilt1 = new ArrayList<>();
					if (comboITR.getSelectedItem().toString() != "") {
						for (Estudiante es : DAOGeneral.estudianteBean.obtenerEstudiantes()) {
							if (es.getItr().getNombre().equalsIgnoreCase(comboITR.getSelectedItem().toString())) {
								estudiantesFilt1.add(es);
							}
						}
					} else {

						estudiantesFilt1 = (ArrayList<Estudiante>) DAOGeneral.estudianteBean.obtenerEstudiantes();

					}
					ArrayList<Estudiante> estudiantesFilt2 = new ArrayList<>();
					if (comboGen.getSelectedItem().toString() != "") {
						for(Estudiante es:estudiantesFilt1) {
							if(es.getAnoIngreso()==Integer.parseInt(comboGen.getSelectedItem().toString())) {
								estudiantesFilt2.add(es);
							}
						}
					} else {
						estudiantesFilt2 = estudiantesFilt1;
					}
					
					ArrayList<Estudiante>estudiantesFilt3=new ArrayList<>();
					
					if(textBuscar.getText()!="") {
						for(Estudiante es:estudiantesFilt2) {
							if((es.getNombre1()+" "+es.getApellido1()).toLowerCase().startsWith(textBuscar.getText().toLowerCase())) {
								estudiantesFilt3.add(es);
							}
						}
					}else {
						estudiantesFilt3=estudiantesFilt2;
					}
					cargarTabla(estudiantesFilt3);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato Black", Font.PLAIN, 14));
		btnhvrFiltrar.setBackground(new Color(52, 152, 219));
		btnhvrFiltrar.setBounds(585, 102, 108, 33);
		add(btnhvrFiltrar);

		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Lato", Font.PLAIN, 14));
		lblITR.setBounds(323, 87, 45, 13);
		add(lblITR);

		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Lato", Font.PLAIN, 14));
		lblGeneracion.setBounds(454, 87, 102, 13);
		add(lblGeneracion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 145, 683, 486);
		add(scrollPane);

		TableMetro tableMetro = new TableMetro();
		modeloTabla = new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula",
						"ITR", "Generaci\u00F3n", "Email UTEC", "Tel\u00E9fono" });
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
		btnhvrEscolaridad.setFont(new Font("Lato Black", Font.PLAIN, 14));
		btnhvrEscolaridad.setBackground(new Color(52, 152, 219));
		btnhvrEscolaridad.setBounds(236, 641, 227, 33);
		add(btnhvrEscolaridad);
		try {
			cargarTabla(DAOGeneral.estudianteBean.obtenerEstudiantes());
			cargarComboBox();
		} catch (ServicesException e) {
			e.printStackTrace();
		}
	}

	public void cargarTabla(List<Estudiante> estudiantes) {
//		"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula", "ITR", "Generaci\u00F3n", "Email UTEC", "Tel\u00E9fono"

		modeloTabla.setRowCount(0);
		for (Estudiante e : estudiantes) {
			Vector v = new Vector();
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
		for (ITR i : DAOGeneral.itrRemote.obtenerItrs()) {
			if (i.getActivo()) {
				modeloITR.addElement(i.getNombre());
			}
		}
	}
}
