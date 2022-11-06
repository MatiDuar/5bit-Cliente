package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.EstadosEventos;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.ModalidadesEventos;
import com.entities.TipoActividad;
import com.entities.Usuario;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSCheckBox;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;

public class PanelGestionDeEventos extends JPanel {
	private RSTableMetro table;
	
	private DefaultTableModel modeloTabla;
	private DefaultComboBoxModel modeloITR;
	private DefaultComboBoxModel modeloTipo;
	private DefaultComboBoxModel modeloModalidad;
	private DefaultComboBoxModel modeloEstado;
	
	
	private RSDateChooser dateChooserFechaHasta;
	private RSDateChooser dateChooserFechaInicio;
	/**
	 * Create the panel.
	 */
	public PanelGestionDeEventos() {
		setBounds(0, 0, 700, 705);
		setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("GESTION DE EVENTOS");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(236, 23, 227, 27);
		add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelGestionDeEventos.class.getResource("/com/vistas/img/UTEC.png")));
//		labelImage_1.setIcon(new ImageIcon(Dise�o.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		add(labelImage_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 233, 561, 357);
		add(scrollPane);
		modeloTabla=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Titulo", "Tipo","Fec Inc", "ITR", "Modalidad", "Estado"
				}
			);
		
		table = new RSTableMetro();
		table.setModel(modeloTabla);
//		table.getColumnModel().getColumn(0).setMinWidth(60);

		for(int i=0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setMinWidth(60);
		}
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		dateChooserFechaInicio = new RSDateChooser();
		dateChooserFechaInicio.setPlaceholder("Fecha desde");
		dateChooserFechaInicio.setBounds(15, 116, 159, 32);
		add(dateChooserFechaInicio);
		
		dateChooserFechaHasta = new RSDateChooser();
		dateChooserFechaHasta.setPlaceholder("Fecha hasta");
		dateChooserFechaHasta.setBounds(184, 116, 150, 32);
		add(dateChooserFechaHasta);
		
		JLabel lblNewLabel = new JLabel("Tipo Evento");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(17, 174, 61, 13);
		add(lblNewLabel);
		modeloTipo=new DefaultComboBoxModel();
		RSComboBox comboBoxTipo = new RSComboBox();
		comboBoxTipo.setModel(modeloTipo);
		comboBoxTipo.setColorBoton(Color.WHITE);
		comboBoxTipo.setBounds(17, 191, 121, 32);
		add(comboBoxTipo);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(155, 174, 45, 13);
		add(lblEstado);
		
		modeloEstado=new DefaultComboBoxModel();
		RSComboBox comboBoxEstado = new RSComboBox();
		comboBoxEstado.setModel(modeloEstado);
		comboBoxEstado.setColorBoton(Color.WHITE);
		comboBoxEstado.setBounds(155, 191, 121, 32);
		add(comboBoxEstado);
		
		modeloITR=new DefaultComboBoxModel();
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setColorBoton(Color.WHITE);
		comboBoxITR.setBounds(293, 191, 121, 32);
		add(comboBoxITR);
		
		modeloModalidad=new DefaultComboBoxModel();
		RSComboBox comboBoxModalidad = new RSComboBox();
		comboBoxModalidad.setModel(modeloModalidad);
		comboBoxModalidad.setColorBoton(Color.WHITE);
		comboBoxModalidad.setBounds(431, 191, 121, 32);
		add(comboBoxModalidad);
		
		RSCheckBox chckbxFechaExacta = new RSCheckBox();
		chckbxFechaExacta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxFechaExacta.isSelected()) {
					dateChooserFechaHasta.setVisible(false);
					dateChooserFechaInicio.setPlaceholder("Fecha");
					dateChooserFechaInicio.repaint();					
				}else {
					dateChooserFechaHasta.setVisible(true);
					dateChooserFechaInicio.setPlaceholder("Fecha desde");
					dateChooserFechaInicio.repaint();
				}
			}
		});
		chckbxFechaExacta.setText("Fecha Exacta");
		chckbxFechaExacta.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxFechaExacta.setBounds(100, 79, 180, 40);
		add(chckbxFechaExacta);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(581, 191, 108, 33);
		add(btnhvrFiltrar);
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Evento>eventos =(ArrayList<Evento>) DAOGeneral.eventoRemote.obtenerEvento();
					ArrayList<Evento>eventosFilt1=new ArrayList<>();
					if(dateChooserFechaInicio.getDatoFecha()!=null) {
						if(chckbxFechaExacta.isSelected()) {
							eventosFilt1=(ArrayList<Evento>)filtrarFechaExacta(eventos);
						}else if(!chckbxFechaExacta.isSelected()) {
							if(dateChooserFechaHasta.getDatoFecha()==null) {
								throw new Exception("Debe seleccionar una fecha hasta");
							}
							eventosFilt1=(ArrayList<Evento>)filtrarFechaEntre(eventos);
						}
					}else {
						eventosFilt1=eventos;
					}
					ArrayList<Evento>eventosFilt2=new ArrayList<>();
					for (Iterator<Evento> iter = eventosFilt1.iterator(); iter.hasNext();) {
						Evento u = iter.next();
						if(comboBoxTipo.getSelectedItem().toString()!="") {
							if(u.getTipoActividad().getNombre().equalsIgnoreCase(comboBoxTipo.getSelectedItem().toString())) {
								eventosFilt2.add(u);
							}
						}else {
							eventosFilt2.add(u);

						}
					}
					cargarTabla(eventosFilt2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel("ITR");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(293, 175, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblEstado_1 = new JLabel("Modalidad");
		lblEstado_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado_1.setBounds(431, 175, 52, 13);
		add(lblEstado_1);
		
		RSButtonHover btnhvrModificar = new RSButtonHover();
		btnhvrModificar.setText("Modificar");
		btnhvrModificar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrModificar.setBackground(new Color(0, 112, 192));
		btnhvrModificar.setBounds(581, 435, 108, 33);
		add(btnhvrModificar);
		
		RSButtonHover btnhvrEliminar = new RSButtonHover();
		btnhvrEliminar.setText("Eliminar");
		btnhvrEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrEliminar.setBackground(new Color(0, 112, 192));
		btnhvrEliminar.setBounds(581, 557, 108, 33);
		add(btnhvrEliminar);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblFechaDeInicio.setBounds(17, 92, 77, 13);
		add(lblFechaDeInicio);
		
		
		
		RSButtonHover btnhvrAlta = new RSButtonHover();
		btnhvrAlta.setText("Alta");
		btnhvrAlta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAlta.setBackground(new Color(0, 112, 192));
		btnhvrAlta.setBounds(581, 313, 108, 33);
		add(btnhvrAlta);
		
		RSButtonHover btnhvrConvocatoriaDeEvento = new RSButtonHover();
		btnhvrConvocatoriaDeEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameConvocatoriaEvento frameConvocatoriaEvento= new FrameConvocatoriaEvento();
				frameConvocatoriaEvento.setVisible(true);
			}
		});
		btnhvrConvocatoriaDeEvento.setText("Convocatoria de Evento");
		btnhvrConvocatoriaDeEvento.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrConvocatoriaDeEvento.setBackground(new Color(0, 112, 192));
		btnhvrConvocatoriaDeEvento.setBounds(10, 601, 227, 33);
		add(btnhvrConvocatoriaDeEvento);
		
		RSButtonHover btnhvrAsistenciaAEventos = new RSButtonHover();
		btnhvrAsistenciaAEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAsistenciaAEvento frameAsistenciaAEvento= new FrameAsistenciaAEvento();
				frameAsistenciaAEvento.setVisible(true);
			}
		});
		btnhvrAsistenciaAEventos.setText("Asistencia a Evento");
		btnhvrAsistenciaAEventos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAsistenciaAEventos.setBackground(new Color(0, 112, 192));
		btnhvrAsistenciaAEventos.setBounds(344, 601, 227, 33);
		add(btnhvrAsistenciaAEventos);
		try {
			cargarTabla(DAOGeneral.eventoRemote.obtenerEvento());
			cargarCombo();
		} catch (ServicesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void cargarTabla(List<Evento>eventos) throws ServicesException {
//		"Titulo", "Tipo","Fec Inc", "ITR", "Modalidad", "Estado"
		modeloTabla.setRowCount(0);
		for(Evento e:eventos) {
			Vector v=new Vector();
			v.addElement(e.getTitulo());
			v.addElement(e.getTipoActividad().getNombre());
			v.addElement(e.getFechaInicio());
			v.addElement(e.getItr().getNombre());
			v.addElement(e.getModalidad().getNombre());
			v.addElement(e.getEstado().getNombre());
			
			modeloTabla.addRow(v);
		}
	}
	
	
	public List<Evento> filtrarFechaExacta(List<Evento> eventos) throws ParseException{
		ArrayList<Evento>eventosFiltArrayList=new ArrayList<>();
		for(Evento ev:eventos) {
			SimpleDateFormat sdformat = new 
	                SimpleDateFormat("yyyy-MM-dd");
			String year=""+ev.getFechaInicio().getYear();
			String mes=""+ev.getFechaInicio().getMonth();
			String dia=""+ ev.getFechaInicio().getDate();
			Date date = sdformat.parse(year+"-"+mes+"-"+"-"+dia);
			
			String year1=""+dateChooserFechaInicio.getDatoFecha().getYear();
			String mes1=""+dateChooserFechaInicio.getDatoFecha().getMonth();
			String dia1=""+ dateChooserFechaInicio.getDatoFecha().getDate();
			Date date1 = sdformat.parse(year1+"-"+mes1+"-"+"-"+dia1);
			if(date.compareTo(date1)==0) {
				eventosFiltArrayList.add(ev);
			}
		}
		return eventosFiltArrayList;
	}
	
	public List<Evento> filtrarFechaEntre(List<Evento> eventos) throws ParseException{
		ArrayList<Evento>eventosFiltArrayList=new ArrayList<>();
		for(Evento ev:eventos) {
			SimpleDateFormat sdformat = new 
	                SimpleDateFormat("yyyy-MM-dd");
			
			//fecha de evento
			String year=""+ev.getFechaInicio().getYear();
			String mes=""+ev.getFechaInicio().getMonth();
			String dia=""+ ev.getFechaInicio().getDate();
			Date date = sdformat.parse(year+"-"+mes+"-"+dia);
			//fecha de inicio del filtro
			String year1=""+dateChooserFechaInicio.getDatoFecha().getYear();
			String mes1=""+dateChooserFechaInicio.getDatoFecha().getMonth();
			String dia1=""+ dateChooserFechaInicio.getDatoFecha().getDate();
			Date date1 = sdformat.parse(year1+"-"+mes1+"-"+dia1);
			
			//fecha de hasta del filtro
			String year2=""+dateChooserFechaHasta.getDatoFecha().getYear();
			String mes2=""+dateChooserFechaHasta.getDatoFecha().getMonth();
			String dia2=""+ dateChooserFechaHasta.getDatoFecha().getDate();
			Date date2 = sdformat.parse(year2+"-"+mes2+"-"+dia2);
			
			if(date.after(date1) && date.before(date2)) {
				eventosFiltArrayList.add(ev);
			}
		}
		return eventosFiltArrayList;
	}
	
	
	public void cargarCombo() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for(ITR i:DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITR.addElement(i.getNombre());
		}
		modeloModalidad.removeAllElements();
		modeloModalidad.addElement("");
		for(ModalidadesEventos e:DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()) {
			modeloModalidad.addElement(e.getNombre());
		}
		modeloEstado.removeAllElements();
		modeloEstado.addElement("");
		for(EstadosEventos es:DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()) {
			modeloEstado.addElement(es.getNombre());
		}
		modeloTipo.removeAllElements();
		modeloTipo.addElement("");
		for(TipoActividad t:DAOGeneral.tipoActividadRemote.obtenerTipoActividad()) {
			modeloTipo.addElement(t.getNombre());
		}
	}
}
