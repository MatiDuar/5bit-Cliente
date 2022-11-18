package com.vistas.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.entities.Estudiante;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.complementos.TableMetro;
import rojeru_san.rslabel.RSLabelImage;

public class PanelReportesEstudiante extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelReportesEstudiante() {
		setLayout(null);
		
		setPreferredSize(new Dimension(700,725));
		setSize(700,1500);
		
		JLabel lblTituloVentana = new JLabel("ESCOLARIDAD");
		lblTituloVentana.setBounds(281, 22, 141, 27);
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 20));
		add(lblTituloVentana);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setBounds(642, 10, 51, 53);
		add(labelImage);
		
		JLabel lblNewLabel = new JLabel("DATOS ESTUDIANTE");
		lblNewLabel.setFont(new Font("Lato", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 68, 141, 13);
		add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombre y Apellidos:");
		lblNombres.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombres.setBounds(10, 91, 102, 13);
		add(lblNombres);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula: ");
		lblNewLabel_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 107, 51, 13);
		add(lblNewLabel_1);
		
		JLabel lblNombrenombreapellidoapellido = new JLabel("NOMBRE1+NOMBRE2+APELLIDO1+APELLIDO2");
		
		String nombreCompleto=Menu.getUsuario().getNombre1();
		if(Menu.getUsuario().getNombre2()!=null) {
			nombreCompleto=nombreCompleto + " "+Menu.getUsuario().getNombre2();
		}
		nombreCompleto=nombreCompleto + " "+Menu.getUsuario().getApellido1();
		if(Menu.getUsuario().getApellido2()!=null) {
			nombreCompleto=nombreCompleto + " "+Menu.getUsuario().getApellido2();
		}

		lblNombrenombreapellidoapellido.setText(nombreCompleto);
		
		lblNombrenombreapellidoapellido.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombrenombreapellidoapellido.setBounds(115, 91, 250, 13);
		add(lblNombrenombreapellidoapellido);
		
		JLabel lblValorCedula = new JLabel("VALOR CEDULA");
		lblValorCedula.setText(Menu.getUsuario().getDocumento());
		lblValorCedula.setFont(new Font("Lato", Font.PLAIN, 11));
		lblValorCedula.setBounds(54, 107, 250, 13);
		add(lblValorCedula);
		
		JLabel lblAnioIngreso = new JLabel("Año de ingreso:");
		lblAnioIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblAnioIngreso.setBounds(10, 124, 84, 13);
		add(lblAnioIngreso);
		
		JLabel lblValorAnioIngreso = new JLabel("VALOR ANIO INGRESO");
		lblValorAnioIngreso.setText(((Estudiante) Menu.getUsuario()).getAnoIngreso()+"");
		lblValorAnioIngreso.setFont(new Font("Lato", Font.PLAIN, 11));
		lblValorAnioIngreso.setBounds(88, 124, 250, 13);
		add(lblValorAnioIngreso);
		
		JLabel lblCarrera = new JLabel("Carrera: ");
		lblCarrera.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCarrera.setBounds(10, 141, 84, 13);
		add(lblCarrera);
		
		JLabel lblNombreCarrera = new JLabel("Licenciatura en Tecnologías de la Información");
		lblNombreCarrera.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNombreCarrera.setBounds(54, 141, 250, 13);
		add(lblNombreCarrera);
		
		JLabel lblNroExpediente = new JLabel("Nro. Expediente: ");
		lblNroExpediente.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNroExpediente.setBounds(10, 158, 86, 13);
		add(lblNroExpediente);
		
		JLabel lblIdDelEstudiante = new JLabel("Id del estudiante??");
		lblIdDelEstudiante.setFont(new Font("Lato", Font.PLAIN, 11));
		lblIdDelEstudiante.setBounds(95, 158, 102, 13);
		add(lblIdDelEstudiante);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEstado.setBounds(218, 158, 43, 13);
		add(lblEstado);
		
		JLabel lblEstadoExpediente = new JLabel("ABIERTO");
		lblEstadoExpediente.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEstadoExpediente.setBounds(258, 158, 51, 13);
		add(lblEstadoExpediente);
		
		JLabel lblAsignaturasDelExpediente = new JLabel("ASIGNATURAS DEL EXPEDIENTE");
		lblAsignaturasDelExpediente.setFont(new Font("Lato", Font.PLAIN, 14));
		lblAsignaturasDelExpediente.setBounds(10, 196, 224, 13);
		add(lblAsignaturasDelExpediente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 683, 300);
		add(scrollPane);
		
		TableMetro tableMetro = new TableMetro();
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setColorBordeHead(Color.DARK_GRAY);
		tableMetro.setColorBordeFilas(Color.DARK_GRAY);
		tableMetro.setFuenteHead(new Font("Tahoma", Font.BOLD, 12));
		tableMetro.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setFuenteFilas(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableMetro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Asiganturas", "Cr\u00E9ditos", "Tipo", "Convocatoria", "Calificaci\u00F3n"
			}
		));
		tableMetro.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(0).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(1).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(2).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(3).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(4).setMinWidth(100);
		scrollPane.setViewportView(tableMetro);
		
		JLabel lblCrditosConseguidosPor = new JLabel("CRÉDITOS CONSEGUIDOS POR TIPO DE ASIGNATURA");
		lblCrditosConseguidosPor.setFont(new Font("Lato", Font.PLAIN, 14));
		lblCrditosConseguidosPor.setBounds(10, 550, 362, 13);
		add(lblCrditosConseguidosPor);
		
		RSButtonHover btnhvrDescargarEscolaridad = new RSButtonHover();
		btnhvrDescargarEscolaridad.setText("Descargar Escolaridad");
		btnhvrDescargarEscolaridad.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrDescargarEscolaridad.setBackground(new Color(0, 112, 192));
		btnhvrDescargarEscolaridad.setBounds(238, 731, 227, 33);
		add(btnhvrDescargarEscolaridad);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setForeground(Color.DARK_GRAY);
		scrollPane_1.setBounds(10, 573, 683, 148);
		add(scrollPane_1);
		
		TableMetro tableMetro_1 = new TableMetro();
		tableMetro_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Obligatoria", "333", null, null, null},
				{"Optativa", "12", null, null, null},
				{"Libre Configuraci\u00F3n", "0", null, null, null},
				{"Proyecto", "0", null, null, null},
				{"Pr\u00E1cticas Profesionales", "0", null, null, null},
				{"Total", "345", null, null, null},
			},
			new String[] {
				"Tipolog\u00EDas", "Requeridos", "Aprobados", "Pendientes", "Matriculados"
			}
		));
		tableMetro_1.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableMetro_1.getColumnModel().getColumn(0).setMinWidth(120);
		tableMetro_1.getColumnModel().getColumn(1).setMinWidth(75);
		tableMetro_1.getColumnModel().getColumn(2).setMinWidth(75);
		tableMetro_1.getColumnModel().getColumn(3).setMinWidth(75);
		tableMetro_1.getColumnModel().getColumn(4).setMinWidth(75);
		tableMetro_1.setIntercellSpacing(new Dimension(0, 0));
		tableMetro_1.setFuenteHead(new Font("Tahoma", Font.BOLD, 12));
		tableMetro_1.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 11));
		tableMetro_1.setFuenteFilas(new Font("Tahoma", Font.BOLD, 11));
		tableMetro_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableMetro_1.setForeground(Color.DARK_GRAY);
		tableMetro_1.setColorBordeHead(Color.DARK_GRAY);
		tableMetro_1.setColorBordeFilas(Color.DARK_GRAY);
		scrollPane_1.setViewportView(tableMetro_1);

	}
}
