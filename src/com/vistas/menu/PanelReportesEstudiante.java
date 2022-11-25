package com.vistas.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.Carrera;
import com.entities.Escolaridad;
import com.entities.Estudiante;
import com.entities.Inscripcion;
import com.entities.Matricula;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.complementos.TableMetro;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class PanelReportesEstudiante extends JPanel {
	
	public static Estudiante estudianteSeleccionado;
	private DefaultTableModel modeloTabla;
	private DefaultTableModel modeloTablaCreditos;
	private DefaultComboBoxModel modeloCarrera;
	private RSComboBox comboBoxCarrera;
	private JLabel lblNombreCarrera;
	private TableMetro tableMetro;
	
	private JLabel lblidExpediente;
	/**
	 * Create the panel.
	 */
	public PanelReportesEstudiante() {
		setLayout(null);
		
		setPreferredSize(new Dimension(700,725));
		setSize(700,725);
		
		JLabel lblTituloVentana = new JLabel("ESCOLARIDAD");
		lblTituloVentana.setBounds(279, 22, 174, 27);
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 20));
		add(lblTituloVentana);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setBounds(642, 10, 51, 53);
		add(labelImage);
		
		JLabel lblNewLabel = new JLabel("DATOS ESTUDIANTE");
		lblNewLabel.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 68, 141, 13);
		add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombre y Apellidos:");
		lblNombres.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNombres.setBounds(10, 91, 120, 13);
		add(lblNombres);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula: ");
		lblNewLabel_1.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 107, 51, 13);
		add(lblNewLabel_1);
		
		JLabel lblNombrenombreapellidoapellido = new JLabel("NOMBRE1+NOMBRE2+APELLIDO1+APELLIDO2");
		
		String nombreCompleto=estudianteSeleccionado.getNombre1();
		if(estudianteSeleccionado.getNombre2()!=null) {
			nombreCompleto=nombreCompleto + " "+estudianteSeleccionado.getNombre2();
		}
		nombreCompleto=nombreCompleto + " "+estudianteSeleccionado.getApellido1();
		if(estudianteSeleccionado.getApellido2()!=null) {
			nombreCompleto=nombreCompleto + " "+estudianteSeleccionado.getApellido2();
		}

		lblNombrenombreapellidoapellido.setText(nombreCompleto);
		
		lblNombrenombreapellidoapellido.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNombrenombreapellidoapellido.setBounds(123, 91, 250, 13);
		add(lblNombrenombreapellidoapellido);
		
		JLabel lblValorCedula = new JLabel("VALOR CEDULA");
		lblValorCedula.setText(Menu.getUsuario().getDocumento());
		lblValorCedula.setFont(new Font("Lato", Font.PLAIN, 12));
		lblValorCedula.setBounds(54, 107, 250, 13);
		add(lblValorCedula);
		
		JLabel lblAnioIngreso = new JLabel("Año de ingreso:");
		lblAnioIngreso.setFont(new Font("Lato", Font.PLAIN, 12));
		lblAnioIngreso.setBounds(10, 124, 84, 13);
		add(lblAnioIngreso);
		
		JLabel lblValorAnioIngreso = new JLabel("");
		lblValorAnioIngreso.setText(estudianteSeleccionado.getAnoIngreso()+"");
		lblValorAnioIngreso.setFont(new Font("Lato", Font.PLAIN, 12));
		lblValorAnioIngreso.setBounds(97, 124, 250, 13);
		add(lblValorAnioIngreso);
		
		JLabel lblCarrera = new JLabel("Carrera: ");
		lblCarrera.setFont(new Font("Lato", Font.PLAIN, 12));
		lblCarrera.setBounds(10, 141, 84, 13);
		add(lblCarrera);
		
		lblNombreCarrera = new JLabel("");
		lblNombreCarrera.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNombreCarrera.setBounds(59, 141, 250, 13);
		add(lblNombreCarrera);
		
		JLabel lblNroExpediente = new JLabel("Nro. Expediente: ");
		lblNroExpediente.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNroExpediente.setBounds(10, 158, 120, 13);
		add(lblNroExpediente);
		
		lblidExpediente = new JLabel("");
		lblidExpediente.setFont(new Font("Lato", Font.PLAIN, 12));
		lblidExpediente.setBounds(106, 158, 128, 13);
		add(lblidExpediente);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 12));
		lblEstado.setBounds(212, 158, 51, 13);
		add(lblEstado);
		
		JLabel lblEstadoExpediente = new JLabel("ABIERTO");
		lblEstadoExpediente.setFont(new Font("Lato", Font.PLAIN, 12));
		lblEstadoExpediente.setBounds(254, 158, 71, 13);
		add(lblEstadoExpediente);
		
		JLabel lblAsignaturasDelExpediente = new JLabel("ASIGNATURAS DEL EXPEDIENTE");
		lblAsignaturasDelExpediente.setFont(new Font("Lato", Font.PLAIN, 14));
		lblAsignaturasDelExpediente.setBounds(10, 196, 224, 13);
		add(lblAsignaturasDelExpediente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 683, 256);
		add(scrollPane);
		
		tableMetro = new TableMetro();
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setColorBordeHead(Color.DARK_GRAY);
		tableMetro.setColorBordeFilas(Color.DARK_GRAY);
		tableMetro.setFuenteHead(new Font("Tahoma", Font.BOLD, 12));
		tableMetro.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setFuenteFilas(new Font("Tahoma", Font.BOLD, 11));
		tableMetro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		modeloTabla=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
				},
				new String[] {
					"Asiganturas", "Cr\u00E9ditos", "Tipo", "Convocatoria", "Calificaci\u00F3n"
				}
			);
		tableMetro.setModel(modeloTabla);
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
		lblCrditosConseguidosPor.setBounds(10, 488, 362, 13);
		add(lblCrditosConseguidosPor);
		
		RSButtonHover btnhvrDescargarEscolaridad = new RSButtonHover();
		btnhvrDescargarEscolaridad.setText("Descargar Escolaridad");
		btnhvrDescargarEscolaridad.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrDescargarEscolaridad.setBackground(new Color(0, 112, 192));
		btnhvrDescargarEscolaridad.setBounds(238, 731, 227, 33);
		add(btnhvrDescargarEscolaridad);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setForeground(Color.DARK_GRAY);
		scrollPane_1.setBounds(10, 511, 683, 148);
		add(scrollPane_1);
		modeloTablaCreditos=new DefaultTableModel(
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
			);
		TableMetro tableMetroCreditos = new TableMetro();
		tableMetroCreditos.setModel(modeloTablaCreditos);
		tableMetroCreditos.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableMetroCreditos.getColumnModel().getColumn(0).setMinWidth(120);
		tableMetroCreditos.getColumnModel().getColumn(1).setMinWidth(75);
		tableMetroCreditos.getColumnModel().getColumn(2).setMinWidth(75);
		tableMetroCreditos.getColumnModel().getColumn(3).setMinWidth(75);
		tableMetroCreditos.getColumnModel().getColumn(4).setMinWidth(75);
		tableMetroCreditos.setIntercellSpacing(new Dimension(0, 0));
		tableMetroCreditos.setFuenteHead(new Font("Tahoma", Font.BOLD, 12));
		tableMetroCreditos.setFuenteFilasSelect(new Font("Tahoma", Font.BOLD, 11));
		tableMetroCreditos.setFuenteFilas(new Font("Tahoma", Font.BOLD, 11));
		tableMetroCreditos.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableMetroCreditos.setForeground(Color.DARK_GRAY);
		tableMetroCreditos.setColorBordeHead(Color.DARK_GRAY);
		tableMetroCreditos.setColorBordeFilas(Color.DARK_GRAY);
		scrollPane_1.setViewportView(tableMetroCreditos);
		
		comboBoxCarrera = new RSComboBox();
		comboBoxCarrera.setDisabledIdex("");
		modeloCarrera=new DefaultComboBoxModel();
		comboBoxCarrera.setModel(modeloCarrera);
		comboBoxCarrera.setBounds(466, 193, 224, 22);
		comboBoxCarrera.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					actualizarCombo();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		add(comboBoxCarrera);
		
//		cargarComboCarrera();
		try {
			cargarComboCarrera();
			cargarAsignaturas();
			cargarTablaCreditos();
			lblNombreCarrera.setText(comboBoxCarrera.getItemAt(0).toString());
			lblidExpediente.setText(buscarInscripcion(estudianteSeleccionado,comboBoxCarrera.getItemAt(0).toString()).getId()+"");
			
			JLabel lblCarreras = new JLabel("Carreras:");
			lblCarreras.setFont(new Font("Dialog", Font.PLAIN, 12));
			lblCarreras.setBounds(466, 169, 128, 13);
			add(lblCarreras);
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void  cargarAsignaturas() throws ServicesException{
//		"Asiganturas", "Cr\u00E9ditos", "Tipo", "Convocatoria", "Calificaci\u00F3n"
		
		modeloTabla.setRowCount(0);
		Escolaridad escolaridadEstudiante=buscarInscripcion(estudianteSeleccionado,comboBoxCarrera.getSelectedItem().toString()).getEscolaridad();
		for(Matricula m:escolaridadEstudiante.getMatriculas()) {
			if(m.getNota()>=3.0) {
				Vector v=new Vector();
				v.addElement(m.getMateria().getNombre());
				v.addElement(m.getCreditos());
				//falta tipo de asignatura
				v.addElement(m.getTipoAsignatura().getNombre());
				//falta convocatoria
				v.addElement(m.getConvocatoriaTipo().getNombre());
				
				v.addElement(m.getNota());
				modeloTabla.addRow(v);
			}
			
		}

	}
	
	
	public Inscripcion buscarInscripcion(Estudiante es,String nombreCarrera) throws ServicesException {
		for(Inscripcion ins:DAOGeneral.inscripcionBean.obtenerInscripcionesPorEstudiante(es)) {
			if(ins.getCarrera().getNombre().equalsIgnoreCase(nombreCarrera)){
				return ins;
			}
		}
		
		return null;
	}
	
	private void cargarComboCarrera() {
		modeloCarrera.removeAllElements();
		for(Inscripcion ins:(estudianteSeleccionado).getInscripciones()) {
			modeloCarrera.addElement(ins.getCarrera().getNombre());
		}
	}
	
	
	private void actualizarCombo() throws ServicesException {
		lblNombreCarrera.setText(comboBoxCarrera.getSelectedItem().toString());
		lblidExpediente.setText(buscarInscripcion(estudianteSeleccionado,comboBoxCarrera.getSelectedItem().toString()).getId()+"");
		cargarAsignaturas();
		cargarTablaCreditos();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void cargarTablaCreditos() throws ServicesException {
//		Tabla de referencia
//		Tipologias  Requeridos  Aprobados  Pendientes  Matriculados 
//		Obligatoria
//		Optativa
//		Libre Configuracion
//		Proyecto
//		Practicas Profesionales
//		Total
		Escolaridad escolaridadEstudiante=buscarInscripcion(estudianteSeleccionado,comboBoxCarrera.getSelectedItem().toString()).getEscolaridad();

		modeloTablaCreditos.setRowCount(0);
		int aprobadosObligatorio=0;
		int aprobadosOptativo=0;
		int aprobadosLibreConfiguracion=0;
		int aprobadosProyecto=0;
		int aprobadosPracticasProfesionales=0;
		for(int i=0;i<tableMetro.getRowCount();i++) {
			String tipoAsignatura=modeloTabla.getValueAt(i, 2).toString();
			int cantidadCreditos=(int)modeloTabla.getValueAt(i, 1);
			if(tipoAsignatura.equalsIgnoreCase("Obligatoria")) {
				aprobadosObligatorio+=cantidadCreditos;
			}else if(tipoAsignatura.equalsIgnoreCase("Optativa")) {
				aprobadosOptativo+=cantidadCreditos;
			}else if(tipoAsignatura.equalsIgnoreCase("Libre Configuraci\u00F3n")) {
				aprobadosLibreConfiguracion+=cantidadCreditos;
			}else if(tipoAsignatura.equalsIgnoreCase("Proyecto")) {
				aprobadosProyecto+=cantidadCreditos;
			}else if(tipoAsignatura.equalsIgnoreCase("Pr\u00E1cticas Profesionales")) {
				aprobadosPracticasProfesionales+=cantidadCreditos;
			}
		}
		
		
		int matriculadosOblicatorio=0;
		int matriculadosOptativo=0;
		int matriculadosLibreConfiguracion=0;
		int matriculadosProyecto=0;
		int matriculadosPracticasProfesionales=0;
		for(Matricula m:escolaridadEstudiante.getMatriculas()) {
			String tipoAsignatura=m.getTipoAsignatura().getNombre();
			int cantCreditos=m.getCreditos();
			if(tipoAsignatura.equalsIgnoreCase("Obligatoria")) {
				matriculadosOblicatorio+=cantCreditos;	
			}else if(tipoAsignatura.equalsIgnoreCase("Optativa")) {
				matriculadosOptativo+=cantCreditos;	
			}else if(tipoAsignatura.equalsIgnoreCase("Libre Configuraci\u00F3n")) {
				matriculadosLibreConfiguracion+=cantCreditos;	
			}else if(tipoAsignatura.equalsIgnoreCase("Proyecto")) {
				matriculadosProyecto+=cantCreditos;	
			}else if(tipoAsignatura.equalsIgnoreCase("Pr\u00E1cticas Profesionales")) {
				matriculadosPracticasProfesionales+=cantCreditos;	
			}
		}
		
		Vector v=new Vector();
		
		v.addElement("Obligatoria");
		Carrera carrera=buscarInscripcion(estudianteSeleccionado,comboBoxCarrera.getSelectedItem().toString()).getCarrera();
		
		int obligatorios=carrera.getCreditosObligatorios();
		v.addElement(obligatorios);
		
		v.addElement(aprobadosObligatorio);
		v.addElement(obligatorios-aprobadosObligatorio);
		
		
		v.addElement(matriculadosOblicatorio);
		
		modeloTablaCreditos.addRow(v);
		
		Vector v1=new Vector();
		
		v1.addElement("Optativa");
		v1.addElement(carrera.getCreditosOptativos());

	
		v1.addElement(aprobadosOptativo);
		v1.addElement(carrera.getCreditosOptativos()-aprobadosOptativo);
		v1.addElement(matriculadosOptativo);
		
		modeloTablaCreditos.addRow(v1);
		

		
		Vector v2=new Vector();
		v2.addElement("Libre Configuraci\u00F3n");
		v2.addElement(carrera.getCreditosLibreConfiguracion());
		v2.addElement(aprobadosLibreConfiguracion);
		v2.addElement(carrera.getCreditosLibreConfiguracion()-aprobadosLibreConfiguracion);
		v2.addElement(matriculadosLibreConfiguracion);
		
		modeloTablaCreditos.addRow(v2);
		
		Vector v3=new Vector();
		
		v3.addElement("Proyecto");
		v3.addElement(carrera.getCreditosProyecto());
		v3.addElement(aprobadosProyecto);
		v3.addElement(carrera.getCreditosProyecto()-aprobadosProyecto);
		v3.addElement(matriculadosProyecto);
		
		modeloTablaCreditos.addRow(v3);
		
		Vector v4=new Vector();
		
		v4.addElement("Pr\u00E1cticas Profesionales");
		v4.addElement(carrera.getCreditosPracticasProfecionales());
		v4.addElement(aprobadosPracticasProfesionales);
		v4.addElement(carrera.getCreditosPracticasProfecionales()-aprobadosPracticasProfesionales);
		v4.addElement(matriculadosPracticasProfesionales);
		
		modeloTablaCreditos.addRow(v4);
		

		
		Vector v5=new Vector();
		
		v5.addElement("Total");
		int cantidadCreditosTotal=carrera.getCreditosLibreConfiguracion()+carrera.getCreditosObligatorios()+carrera.getCreditosOptativos()+carrera.getCreditosPracticasProfecionales()+carrera.getCreditosProyecto();
		v5.addElement(cantidadCreditosTotal);
		int cantidadAprobadosTotal=aprobadosLibreConfiguracion+aprobadosObligatorio+aprobadosOptativo+aprobadosPracticasProfesionales+aprobadosProyecto;
		v5.addElement(cantidadAprobadosTotal);
		v5.addElement(cantidadCreditosTotal-cantidadAprobadosTotal);
		int cantidadMatriculadosTotal=matriculadosLibreConfiguracion+matriculadosOblicatorio+matriculadosOptativo+matriculadosPracticasProfesionales+matriculadosProyecto;
		v5.addElement(cantidadMatriculadosTotal);
		
		modeloTablaCreditos.addRow(v5);
		
		
	}
}
