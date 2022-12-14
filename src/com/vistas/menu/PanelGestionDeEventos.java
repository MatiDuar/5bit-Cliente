package com.vistas.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.Analista;
import com.entities.EstadosEventos;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.ModalidadesEventos;
import com.entities.TipoActividad;
import com.entities.Tutor;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSCheckBox;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelGestionDeEventos extends JPanel {
	private RSTableMetro table;

	private static PanelGestionDeEventos instancia = new PanelGestionDeEventos();

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
	private PanelGestionDeEventos() {
		setBounds(0, 0, 700, 725);
		setLayout(null);

		JPanel panelMantenimientoAnalista = new JPanel();
		panelMantenimientoAnalista.setBounds(570, 257, 127, 348);
		add(panelMantenimientoAnalista);

		JLabel lblNewLabel_2_1 = new JLabel("GESTION DE EVENTOS");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(255, 23, 291, 27);
		add(lblNewLabel_2_1);

		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelGestionDeEventos.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(639, 11, 51, 53);
		add(labelImage_1);
		modeloEstado = new DefaultComboBoxModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(17, 233, 552, 357);
		add(scrollPane);

		modeloTabla = new DefaultTableModel(new Object[][] {},
				new String[] { "Titulo", "Tipo", "Fec Inc", "ITR", "Modalidad", "Estado", "Id" }) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new RSTableMetro();
		if (Menu.getUsuario() instanceof Analista) {
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
						try {
							Evento eventoSeleccionado = DAOGeneral.eventoRemote.buscarEventoPorId((long) Integer
									.parseInt(modeloTabla.getValueAt(table.getSelectedRow(), 6).toString()));
							FrameModificarEvento.eventoSeleccionado = eventoSeleccionado;
							FrameModificarEvento frame = new FrameModificarEvento();
							frame.setVisible(true);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}

		table.setModel(modeloTabla);

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setMinWidth(60);
		}
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.setBackgoundHead(new Color(52, 152, 219));

		scrollPane.setViewportView(table);

		dateChooserFechaInicio = new RSDateChooser();

		dateChooserFechaInicio.setColorBackground(new Color(52, 152, 219));
		dateChooserFechaInicio.setPlaceholder("Fecha desde");
		dateChooserFechaInicio.setBounds(15, 116, 159, 32);
		add(dateChooserFechaInicio);

		dateChooserFechaHasta = new RSDateChooser();
		dateChooserFechaHasta.setColorBackground(new Color(52, 152, 219));
		dateChooserFechaHasta.setPlaceholder("Fecha hasta");
		dateChooserFechaHasta.setBounds(184, 116, 150, 32);
		add(dateChooserFechaHasta);

		JLabel lblNewLabel = new JLabel("Tipo Evento");
		lblNewLabel.setFont(new Font("Lato", Font.PLAIN, 14));
		lblNewLabel.setBounds(17, 174, 91, 13);
		add(lblNewLabel);
		modeloTipo = new DefaultComboBoxModel();
		RSComboBox comboBoxTipo = new RSComboBox();
		comboBoxTipo.setColorFondo(new Color(52, 152, 219));
		comboBoxTipo.setDisabledIdex("");

		comboBoxTipo.setModel(modeloTipo);
		comboBoxTipo.setColorBoton(Color.WHITE);
		comboBoxTipo.setBounds(17, 191, 121, 32);
		add(comboBoxTipo);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 14));
		lblEstado.setBounds(155, 174, 45, 13);
		add(lblEstado);

		RSComboBox comboBoxEstado = new RSComboBox();
		comboBoxEstado.setColorFondo(new Color(52, 152, 219));
		comboBoxEstado.setDisabledIdex("");

		comboBoxEstado.setModel(modeloEstado);
		comboBoxEstado.setColorBoton(Color.WHITE);
		comboBoxEstado.setBounds(155, 191, 121, 32);
		add(comboBoxEstado);

		modeloITR = new DefaultComboBoxModel();
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setDisabledIdex("");

		comboBoxITR.setColorBoton(Color.WHITE);
		comboBoxITR.setBounds(293, 191, 121, 32);
		add(comboBoxITR);

		modeloModalidad = new DefaultComboBoxModel();
		RSComboBox comboBoxModalidad = new RSComboBox();
		comboBoxModalidad.setColorFondo(new Color(52, 152, 219));
		comboBoxModalidad.setDisabledIdex("");

		comboBoxModalidad.setModel(modeloModalidad);
		comboBoxModalidad.setColorBoton(Color.WHITE);
		comboBoxModalidad.setBounds(431, 191, 121, 32);
		add(comboBoxModalidad);

		RSCheckBox chckbxFechaExacta = new RSCheckBox();
		chckbxFechaExacta.setColorUnCheck(new Color(52, 152, 219));
		chckbxFechaExacta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxFechaExacta.isSelected()) {
					dateChooserFechaHasta.setVisible(false);
					dateChooserFechaInicio.setPlaceholder("Fecha");
					dateChooserFechaInicio.repaint();
				} else {
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
		btnhvrFiltrar.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrFiltrar.setBackground(new Color(52, 152, 219));
		btnhvrFiltrar.setBounds(570, 191, 117, 33);
		add(btnhvrFiltrar);
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Evento> eventos = (ArrayList<Evento>) DAOGeneral.eventoRemote.obtenerEvento();
					ArrayList<Evento> eventosFilt1 = new ArrayList<>();
					if (dateChooserFechaInicio.getDatoFecha() != null || dateChooserFechaHasta.getDatoFecha() != null) {
						if (chckbxFechaExacta.isSelected()) {
							eventosFilt1 = (ArrayList<Evento>) filtrarFechaExacta(eventos);
						} else if (!chckbxFechaExacta.isSelected()) {
							eventosFilt1 = (ArrayList<Evento>) filtrarFechaEntre(eventos);
						}
					} else {
						eventosFilt1 = eventos;
					}
					ArrayList<Evento> eventosFilt2 = new ArrayList<>();
					for (Iterator<Evento> iter = eventosFilt1.iterator(); iter.hasNext();) {
						Evento u = iter.next();
						if (comboBoxTipo.getSelectedItem().toString() != "") {
							if (u.getTipoActividad().getNombre()
									.equalsIgnoreCase(comboBoxTipo.getSelectedItem().toString())) {
								eventosFilt2.add(u);
							}
						} else {
							eventosFilt2.add(u);

						}
					}
					ArrayList<Evento> eventosFilt3 = new ArrayList<>();
					if (comboBoxEstado.getSelectedItem().toString() == "") {
						eventosFilt3 = eventosFilt2;
					} else {
						for (Iterator<Evento> iter = eventosFilt2.iterator(); iter.hasNext();) {
							Evento u = iter.next();
							if (u.getEstado().getNombre()
									.equalsIgnoreCase(comboBoxEstado.getSelectedItem().toString())) {
								eventosFilt3.add(u);
							}

						}
					}
					ArrayList<Evento> eventosFilt4 = new ArrayList<>();
					if (comboBoxITR.getSelectedItem().toString() == "") {
						eventosFilt4 = eventosFilt3;
					} else {
						for (Iterator<Evento> iter = eventosFilt3.iterator(); iter.hasNext();) {
							Evento u = iter.next();
							if (u.getItr().getNombre().equalsIgnoreCase(comboBoxITR.getSelectedItem().toString())) {
								eventosFilt4.add(u);
							}

						}
					}
					ArrayList<Evento> eventosFilt5 = new ArrayList<>();
					if (comboBoxModalidad.getSelectedItem().toString() == "") {
						eventosFilt5 = eventosFilt4;
					} else {
						for (Iterator<Evento> iter = eventosFilt4.iterator(); iter.hasNext();) {
							Evento u = iter.next();
							if (u.getModalidad().getNombre()
									.equalsIgnoreCase(comboBoxModalidad.getSelectedItem().toString())) {
								eventosFilt5.add(u);
							}

						}
					}
					cargarTabla(eventosFilt5);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel("ITR");
		lblNewLabel_1.setFont(new Font("Lato", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(293, 175, 45, 13);
		add(lblNewLabel_1);

		JLabel lblEstado_1 = new JLabel("Modalidad");
		lblEstado_1.setFont(new Font("Lato", Font.PLAIN, 14));
		lblEstado_1.setBounds(431, 175, 69, 13);
		add(lblEstado_1);
		panelMantenimientoAnalista.setLayout(null);

		RSButtonHover btnhvrModificar = new RSButtonHover();
		btnhvrModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(table.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar un evento para poder modificarlo.");
					}
					Evento eventoSeleccionado = DAOGeneral.eventoRemote.buscarEventoPorId(
							(long) Integer.parseInt(modeloTabla.getValueAt(table.getSelectedRow(), 6).toString()));
					FrameModificarEvento.eventoSeleccionado = eventoSeleccionado;
					FrameModificarEvento frame = new FrameModificarEvento();
					frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnhvrModificar.setText("Modificar");
		btnhvrModificar.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrModificar.setBackground(new Color(52, 152, 219));
		btnhvrModificar.setBounds(4, 66, 117, 33);
		panelMantenimientoAnalista.add(btnhvrModificar);

		RSButtonHover btnhvrEliminar = new RSButtonHover();
		btnhvrEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (table.getSelectedRow() == -1) {
						throw new Exception("Debe seleccionar un evento para poder eliminarlo");
					}
					Evento eventoEliminar = DAOGeneral.eventoRemote
							.buscarEventoPorId((Long) modeloTabla.getValueAt(table.getSelectedRow(), 6));
					
					if (!DAOGeneral.conAsistenciaBean.buscarPorEvento(eventoEliminar).isEmpty()) {
						throw new Exception("Para poder eliminar el evento no puede tener estudiantes convocados");
					}

					int input = JOptionPane.showConfirmDialog(getParent(), "Desea Eliminar el evento seleccionado",
							"Aviso...", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (input == 0) {
						DAOGeneral.eventoRemote.borrarEvento(eventoEliminar.getId());
						cargarTabla(DAOGeneral.eventoRemote.obtenerEvento());
						JOptionPane.showMessageDialog(null, "Se Elimino correctamente el evento seleccionado",
								"Aviso...", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrEliminar.setText("Eliminar");
		btnhvrEliminar.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrEliminar.setBackground(new Color(52, 152, 219));
		btnhvrEliminar.setBounds(4, 117, 117, 33);
		panelMantenimientoAnalista.add(btnhvrEliminar);

		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setFont(new Font("Lato", Font.PLAIN, 13));
		lblFechaDeInicio.setBounds(17, 92, 108, 13);
		add(lblFechaDeInicio);

		RSButtonHover btnhvrAlta = new RSButtonHover();
		btnhvrAlta.setText("Alta");
		btnhvrAlta.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrAlta.setBackground(new Color(52, 152, 219));
		btnhvrAlta.setBounds(4, 11, 117, 33);
		panelMantenimientoAnalista.add(btnhvrAlta);

		btnhvrAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameNuevoEvento.tutoresAsignados = null;
					FrameNuevoEvento ventana = new FrameNuevoEvento();
					ventana.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		RSButtonHover btnhvrConvocatoriaDeEvento = new RSButtonHover();
		btnhvrConvocatoriaDeEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (table.getSelectedRow() == -1) {
						throw new Exception("Debe seleccionar un evento para realizar esta accion");
					}
					FrameConvocatoriaEvento.eventoSeleccionado = DAOGeneral.eventoRemote
							.buscarEventoPorId((Long) modeloTabla.getValueAt(table.getSelectedRow(), 6));
					FrameConvocatoriaEvento frameConvocatoriaEvento = new FrameConvocatoriaEvento();
					frameConvocatoriaEvento.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnhvrConvocatoriaDeEvento.setText("Convocatoria de Evento");
		btnhvrConvocatoriaDeEvento.setFont(new Font("Lato Black", Font.BOLD, 14));
		btnhvrConvocatoriaDeEvento.setBackground(new Color(52, 152, 219));
		btnhvrConvocatoriaDeEvento.setBounds(89, 636, 227, 33);
		add(btnhvrConvocatoriaDeEvento);

		RSButtonHover btnhvrAsistenciaAEventos = new RSButtonHover();
		btnhvrAsistenciaAEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (table.getSelectedRow() == -1) {
						throw new Exception("Debe seleccionar un evento para realizar esta accion");
					}
					FrameAsistenciaAEvento.eventoSeleccionado = DAOGeneral.eventoRemote
							.buscarEventoPorId((Long) modeloTabla.getValueAt(table.getSelectedRow(), 6));
					FrameAsistenciaAEvento frame = new FrameAsistenciaAEvento();
					frame.setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrAsistenciaAEventos.setText("Asistencia a Evento");
		btnhvrAsistenciaAEventos.setFont(new Font("Lato Black", Font.BOLD, 14));
		btnhvrAsistenciaAEventos.setBackground(new Color(52, 152, 219));
		btnhvrAsistenciaAEventos.setBounds(384, 636, 227, 33);
		add(btnhvrAsistenciaAEventos);

		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimiento.setFont(new Font("Lato", Font.BOLD, 14));
		lblMantenimiento.setBounds(10, 204, 108, 13);
		panelMantenimientoAnalista.add(lblMantenimiento);

		RSButtonHover btnhvrModalidades = new RSButtonHover();
		btnhvrModalidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MantenimientoModalidadesEvento es = MantenimientoModalidadesEvento.getInstancia();
				es.setVisible(true);

			}
		});
		btnhvrModalidades.setText("Modalidades");
		btnhvrModalidades.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrModalidades.setBackground(new Color(52, 152, 219));
		btnhvrModalidades.setBounds(4, 228, 117, 33);
		panelMantenimientoAnalista.add(btnhvrModalidades);

		RSButtonHover btnhvrEstados = new RSButtonHover();
		btnhvrEstados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MantenimientoEstadosEvento mod = MantenimientoEstadosEvento.getInstancia();

				mod.setVisible(true);

			}
		});
		btnhvrEstados.setText("Estados");
		btnhvrEstados.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrEstados.setBackground(new Color(52, 152, 219));
		btnhvrEstados.setBounds(4, 279, 117, 33);
		panelMantenimientoAnalista.add(btnhvrEstados);

		RSButtonHover btnhvrReiniciarFiltro = new RSButtonHover();
		btnhvrReiniciarFiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dateChooserFechaInicio.setDatoFecha(null);
					dateChooserFechaHasta.setDatoFecha(null);
					comboBoxITR.setSelectedIndex(0);
					comboBoxModalidad.setSelectedIndex(0);
					comboBoxEstado.setSelectedIndex(0);
					comboBoxTipo.setSelectedIndex(0);

					cargarTabla(DAOGeneral.eventoRemote.obtenerEvento());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnhvrReiniciarFiltro.setText("Borrar Filtro");
		btnhvrReiniciarFiltro.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnhvrReiniciarFiltro.setBackground(new Color(52, 152, 219));
		btnhvrReiniciarFiltro.setBounds(570, 154, 117, 33);
		add(btnhvrReiniciarFiltro);

		try {
			if (Menu.getUsuario() instanceof Tutor) {
				btnhvrConvocatoriaDeEvento.setVisible(false);
				btnhvrAsistenciaAEventos.setLocation(236, 636);
				panelMantenimientoAnalista.setVisible(false);
				scrollPane.setSize(672, 357);
			}
			cargarTabla(DAOGeneral.eventoRemote.obtenerEvento());
			cargarCombo();
			table.removeColumn(table.getColumnModel().getColumn(6));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void cargarTabla(List<Evento> eventos) throws Exception {
		modeloTabla.setRowCount(0);

		for (Evento e : eventos) {
			if ((Menu.getUsuario() instanceof Analista) || (Menu.getUsuario() instanceof Tutor
					&& contieneTutor((Tutor) Menu.getUsuario(), (List<Tutor>) e.getTutores()))) {
				Vector v = new Vector();
				v.addElement(e.getTitulo());
				v.addElement(e.getTipoActividad().getNombre());
				String Fecha = e.getFechaInicio().getDay() + "-" + e.getFechaInicio().getMonth() + "-"
						+ e.getFechaInicio().getYear();
				v.addElement(e.getFechaInicio());
				v.addElement(e.getItr().getNombre());
				v.addElement(e.getModalidad().getNombre());
				v.addElement(e.getEstado().getNombre());
				v.addElement(e.getId());

				modeloTabla.addRow(v);
			}
		}
	}

	public List<Evento> filtrarFechaExacta(List<Evento> eventos) throws ParseException {
		ArrayList<Evento> eventosFiltArrayList = new ArrayList<>();
		for (Evento ev : eventos) {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			String year = "" + ev.getFechaInicio().getYear();
			String mes = "" + ev.getFechaInicio().getMonth();
			String dia = "" + ev.getFechaInicio().getDate();
			Date date = sdformat.parse(year + "-" + mes + "-" + "-" + dia);

			String year1 = "" + dateChooserFechaInicio.getDatoFecha().getYear();
			String mes1 = "" + dateChooserFechaInicio.getDatoFecha().getMonth();
			String dia1 = "" + dateChooserFechaInicio.getDatoFecha().getDate();
			Date date1 = sdformat.parse(year1 + "-" + mes1 + "-" + "-" + dia1);
			if (date.compareTo(date1) == 0) {
				eventosFiltArrayList.add(ev);
			}
		}
		return eventosFiltArrayList;
	}

	public List<Evento> filtrarFechaEntre(List<Evento> eventos) throws ParseException {
		ArrayList<Evento> eventosFiltArrayList = new ArrayList<>();
		for (Evento ev : eventos) {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			// fecha de evento
			String year = "" + ev.getFechaInicio().getYear();
			String mes = "" + ev.getFechaInicio().getMonth();
			String dia = "" + ev.getFechaInicio().getDate();
			Date date = sdformat.parse(year + "-" + mes + "-" + dia);

			String year1;
			String mes1;
			String dia1;
			Date date1;

			String year2;
			String mes2;
			String dia2;
			Date date2;

			if (dateChooserFechaInicio.getDatoFecha() != null && dateChooserFechaHasta.getDatoFecha() == null) {
				// fecha de inicio del filtro
				year1 = "" + dateChooserFechaInicio.getDatoFecha().getYear();
				mes1 = "" + dateChooserFechaInicio.getDatoFecha().getMonth();
				dia1 = "" + dateChooserFechaInicio.getDatoFecha().getDate();
				date1 = sdformat.parse(year1 + "-" + mes1 + "-" + dia1);
				if (date.after(date1) || date.compareTo(date1)==0) {
					eventosFiltArrayList.add(ev);
				}
			} else if (dateChooserFechaInicio.getDatoFecha() == null && dateChooserFechaHasta.getDatoFecha() != null) {

				// fecha de hasta del filtro
				year2 = "" + dateChooserFechaHasta.getDatoFecha().getYear();
				mes2 = "" + dateChooserFechaHasta.getDatoFecha().getMonth();
				dia2 = "" + dateChooserFechaHasta.getDatoFecha().getDate();
				date2 = sdformat.parse(year2 + "-" + mes2 + "-" + dia2);
				if (date.compareTo(date2) == 0) {
					eventosFiltArrayList.add(ev);
				}
			} else {
				// fecha de inicio del filtro
				year1 = "" + dateChooserFechaInicio.getDatoFecha().getYear();
				mes1 = "" + dateChooserFechaInicio.getDatoFecha().getMonth();
				dia1 = "" + dateChooserFechaInicio.getDatoFecha().getDate();
				date1 = sdformat.parse(year1 + "-" + mes1 + "-" + dia1);
				
				// fecha de hasta del filtro
				year2 = "" + dateChooserFechaHasta.getDatoFecha().getYear();
				mes2 = "" + dateChooserFechaHasta.getDatoFecha().getMonth();
				dia2 = "" + dateChooserFechaHasta.getDatoFecha().getDate();
				date2 = sdformat.parse(year2 + "-" + mes2 + "-" + dia2);
				if (date.after(date1) && date.before(date2)) {
					eventosFiltArrayList.add(ev);
				}
			}
		}
		return eventosFiltArrayList;
	}

	public void cargarCombo() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for (ITR i : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITR.addElement(i.getNombre());
		}
		modeloModalidad.removeAllElements();
		modeloModalidad.addElement("");
		for (ModalidadesEventos e : DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()) {
			modeloModalidad.addElement(e.getNombre());
		}
		modeloEstado.removeAllElements();
		modeloEstado.addElement("");
		for (EstadosEventos es : DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()) {
			modeloEstado.addElement(es.getNombre());
		}
		modeloTipo.removeAllElements();
		modeloTipo.addElement("");
		for (TipoActividad t : DAOGeneral.tipoActividadRemote.obtenerTipoActividad()) {
			modeloTipo.addElement(t.getNombre());
		}
	}

	public boolean contieneTutor(Tutor buscar, List<Tutor> tutores) {
		for (Tutor t : tutores) {
			if (t.getId() == buscar.getId()) {
				return true;
			}
		}
		return false;
	}

	public static PanelGestionDeEventos getInstancia() {
		return instancia;
	}

	public static void reset() {
		instancia = new PanelGestionDeEventos();
	}
}
