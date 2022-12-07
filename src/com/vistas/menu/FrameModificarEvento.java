package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.controlador.DAOGeneral;
import com.entities.EstadosEventos;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.ModalidadesEventos;
import com.entities.TipoActividad;
import com.entities.Tutor;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class FrameModificarEvento extends JFrame {

	private JPanel contentPane;
	private DefaultComboBoxModel modeloTipoEvento;
	private DefaultComboBoxModel modeloModalidad;
	private DefaultComboBoxModel modeloITR;
	private DefaultComboBoxModel modeloEstado;

	public static List<Tutor> tutoresAsignados;

	public static Evento eventoSeleccionado;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModificarEvento frame = new FrameModificarEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrameModificarEvento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Modificar Evento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/vistas/img/UTEC.png")));
		setResizable(false);

		setBounds(100, 100, 717, 554);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("MODIFICAR EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(272, 24, 212, 27);
		contentPane.add(lblNewLabel_2_1);

		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelGestionDeEventos.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(644, 11, 51, 53);
		contentPane.add(labelImage_1);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTitulo.setBounds(56, 110, 28, 14);
		contentPane.add(lblTitulo);

		RSTextFull textTitulo = new RSTextFull();
		textTitulo.setBordeColorFocus(new Color(52, 152, 219));
		textTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTitulo.setBounds(94, 96, 250, 42);
		textTitulo.setText(eventoSeleccionado.getTitulo());

		contentPane.add(textTitulo);

		JLabel lblTipoDeEvento = new JLabel("Tipo de Evento");
		lblTipoDeEvento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeEvento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTipoDeEvento.setBounds(364, 110, 71, 14);
		contentPane.add(lblTipoDeEvento);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaInicio.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaInicio.setBounds(27, 157, 57, 14);
		contentPane.add(lblFechaInicio);

		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraInicio.setFont(new Font("Lato", Font.PLAIN, 11));
		lblHoraInicio.setBounds(349, 157, 86, 14);
		contentPane.add(lblHoraInicio);

		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setFont(new Font("Lato", Font.PLAIN, 11));
		lblFechaFin.setBounds(27, 209, 57, 14);
		contentPane.add(lblFechaFin);

		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraFin.setFont(new Font("Lato", Font.PLAIN, 11));
		lblHoraFin.setBounds(345, 209, 90, 14);
		contentPane.add(lblHoraFin);

		RSDateChooser fechaFin = new RSDateChooser();
		fechaFin.setColorBackground(new Color(52, 152, 219));
		
		fechaFin.setBounds(94, 196, 250, 42);
		contentPane.add(fechaFin);

		modeloTipoEvento = new DefaultComboBoxModel();
		RSComboBox comboBoxTipoEvento = new RSComboBox();
		comboBoxTipoEvento.setColorBoton(Color.WHITE);
		comboBoxTipoEvento.setColorFondo(new Color(52, 152, 219));
		comboBoxTipoEvento.setModel(modeloTipoEvento);
		comboBoxTipoEvento.setBounds(440, 96, 250, 42);
		contentPane.add(comboBoxTipoEvento);

		RSDateChooser fechaInicio = new RSDateChooser();
		fechaInicio.setColorBackground(new Color(52, 152, 219));
	
		fechaInicio.setBounds(94, 143, 250, 42);
		contentPane.add(fechaInicio);

		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblModalidad.setBounds(27, 263, 62, 14);
		contentPane.add(lblModalidad);

		modeloModalidad = new DefaultComboBoxModel();
		RSComboBox comboBoxModalidad = new RSComboBox();
		comboBoxModalidad.setColorBoton(Color.WHITE);
		comboBoxModalidad.setColorFondo(new Color(52, 152, 219));
		comboBoxModalidad.setModel(modeloModalidad);
		comboBoxModalidad.setBounds(94, 249, 250, 42);
		contentPane.add(comboBoxModalidad);

		JLabel lblItr = new JLabel("ITR");
		lblItr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItr.setFont(new Font("Lato", Font.PLAIN, 11));
		lblItr.setBounds(364, 262, 71, 14);
		contentPane.add(lblItr);

		modeloITR = new DefaultComboBoxModel();
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorBoton(Color.WHITE);
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setBounds(440, 248, 250, 42);
		contentPane.add(comboBoxITR);

		JLabel lblLocalizacion = new JLabel("Localizacion");
		lblLocalizacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocalizacion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalizacion.setBounds(18, 316, 66, 14);
		contentPane.add(lblLocalizacion);

		RSTextFull textLocalicacion = new RSTextFull();
		textLocalicacion.setBordeColorFocus(new Color(52, 152, 219));
		textLocalicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalicacion.setBounds(94, 302, 250, 42);
		textLocalicacion.setText(eventoSeleccionado.getLocalizacion());

		contentPane.add(textLocalicacion);

		DefaultComboBoxModel modeloInicio = new DefaultComboBoxModel();
		RSComboBox comboBoxHoraInicio = new RSComboBox();
		comboBoxHoraInicio.setColorBoton(Color.WHITE);
		comboBoxHoraInicio.setColorFondo(new Color(52, 152, 219));
		comboBoxHoraInicio.setModel(modeloInicio);
		comboBoxHoraInicio.setBounds(440, 144, 250, 42);
		contentPane.add(comboBoxHoraInicio);
		DefaultComboBoxModel modeloFin = new DefaultComboBoxModel();

		RSComboBox comboBoxHoraFin = new RSComboBox();
		comboBoxHoraFin.setColorBoton(Color.WHITE);
		comboBoxHoraFin.setColorFondo(new Color(52, 152, 219));
		comboBoxHoraFin.setModel(modeloFin);
		comboBoxHoraFin.setBounds(440, 196, 250, 42);
		contentPane.add(comboBoxHoraFin);

		RSComboBox comboBoxEstado = new RSComboBox();
		comboBoxEstado.setColorBoton(Color.WHITE);
		comboBoxEstado.setColorFondo(new Color(52, 152, 219));
		modeloEstado = new DefaultComboBoxModel();
		comboBoxEstado.setModel(modeloEstado);
		comboBoxEstado.setBounds(440, 302, 250, 42);
		contentPane.add(comboBoxEstado);

		// se agregan las horas en el ComboBox
		for (int j = 0; j < 24; j++) {
			for (int i = 0; i < 31; i += 30) {
				if (i == 0 && j < 10) {
					modeloInicio.addElement("0" + j + ":" + i + "0");
					modeloFin.addElement("0" + j + ":" + i + "0");

				} else if (i == 0 && j > 10) {
					modeloInicio.addElement(j + ":" + i + "0");
					modeloFin.addElement(j + ":" + i + "0");

				} else if (i != 0 && j < 10) {
					modeloInicio.addElement("0" + j + ":" + i);
					modeloFin.addElement("0" + j + ":" + i);

				} else if (i == 0 && j >= 10) {
					modeloInicio.addElement(+j + ":" + i + "0");
					modeloFin.addElement(+j + ":" + i + "0");

				} else {
					modeloInicio.addElement(j + ":" + i);
					modeloFin.addElement(j + ":" + i);

				}
			}
		}

		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int input = JOptionPane.showConfirmDialog(getParent(),
							"Estas seguro de modificar los datos del evento Seleccionado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

					if (input == 0) {

						Evento eventoNuevo = eventoSeleccionado;
						if(textTitulo.getText().equalsIgnoreCase("")) {
							throw new Exception("Debe espesificar un titulo");
						}
						
						if(textTitulo.getText().length()>50) {
							throw new Exception("El titulo no puede contener mas de 50 caracteres");
						}
						eventoNuevo.setTitulo(textTitulo.getText());

						eventoNuevo.setCreditos(0);
						eventoNuevo.setSemestre(1);
						if(comboBoxEstado.getSelectedIndex()==0) {
							throw new Exception("Debe selecionar un estado de evento");
						}
						eventoNuevo.setEstado(DAOGeneral.estadosEventoRemote
								.buscarNombreEstadoEvento(comboBoxEstado.getSelectedItem().toString()));
						
						if(comboBoxITR.getSelectedIndex()==0) {
							throw new Exception("Debe seleccionar un ITR");
						}
						eventoNuevo.setItr(
								DAOGeneral.itrRemote.obtenerItrPorNombre(comboBoxITR.getSelectedItem().toString()));
						if(comboBoxModalidad.getSelectedIndex()==0) {
							throw new Exception("Debe seleccionar una Modalidad");
						}
						eventoNuevo.setModalidad(DAOGeneral.modalidadEventoRemote
								.buscarNombreModalidadEvento(comboBoxModalidad.getSelectedItem().toString()));
						if(comboBoxTipoEvento.getSelectedIndex()==0) {
							throw new Exception("Debe seleccionar un Tipo de evento");
						}
						eventoNuevo.setTipoActividad(DAOGeneral.tipoActividadRemote
								.obtenerTipoActividadPorNombre(comboBoxTipoEvento.getSelectedItem().toString()));
						if(tutoresAsignados==null || tutoresAsignados.size()<1) {
							throw new Exception("Debe haber por lo menos un tutor asignado al evento");
						}
						eventoNuevo.setTutores(tutoresAsignados);

					// fecha de evento inicio
						java.util.Date fecha = fechaInicio.getDatoFecha();

						LocalDate fechaActualLD = LocalDate.now();
						java.sql.Date fechaActualSQL = java.sql.Date.valueOf(fechaActualLD);

						java.util.Date fechaActualDATE = new java.util.Date(fechaActualSQL.getTime());

						if (fecha.before(fechaActualDATE)) {
							throw new Exception("El evento no puede ser registrado con una fecha anterior a la de hoy");
						}
						Timestamp dateInicio = new Timestamp(fechaInicio.getDatoFecha().getTime());
						String horaMinIncio[] = comboBoxHoraInicio.getSelectedItem().toString().split(":");
						String[] horaMinFin = comboBoxHoraFin.getSelectedItem().toString().split(":");
						
						java.util.Date fechaFin1 = fechaFin.getDatoFecha();


						if(fechaFin1.getDate()==fecha.getDate() && fechaFin1.getMonth()==fecha.getMonth() && fechaFin1.getYear()==fecha.getYear()) {
							if(Integer.parseInt(horaMinFin[0])<Integer.parseInt(horaMinIncio[0])) {
								throw new Exception("La hora de inicio no puede ser mayor a la hora de finalizacion");
							}
							if(Integer.parseInt(horaMinFin[0])==Integer.parseInt(horaMinIncio[0])) {
								
								if(Integer.parseInt(horaMinFin[1])<=Integer.parseInt(horaMinIncio[1])) {
									throw new Exception("La hora de inicio no puede ser mayor o igual a la hora de finalizacion");
								}
							}
							
						}
						System.out.println(Integer.parseInt(horaMinIncio[0]));
						System.out.println(Integer.parseInt(horaMinIncio[1]));
						System.out.println(Integer.parseInt(horaMinFin[0]));
						System.out.println(Integer.parseInt(horaMinFin[1]));
						
						System.out.println(fechaFin1);
						System.out.println(fecha);
						dateInicio.setHours(Integer.parseInt(horaMinIncio[0]));
						dateInicio.setMinutes(Integer.parseInt(horaMinIncio[1]));
						eventoNuevo.setFechaInicio(dateInicio);

						// fecha de evento fin

						if(fechaFin1.before(fecha)) {
							throw new Exception("La fecha fin no puede ser anterior a la fecha de Inicio");
						}

						if (fecha.before(fechaActualDATE)) {
							throw new Exception("El evento no puede ser registrado con una fecha anterior a la de hoy");
						}
						Timestamp dateFin = new Timestamp(fechaFin.getDatoFecha().getTime());
						dateFin.setHours(Integer.parseInt(horaMinFin[0]));
						dateFin.setMinutes(Integer.parseInt(horaMinFin[1]));
						
						eventoNuevo.setFechaFin(dateFin);
						
						eventoNuevo.setSemestre(1);
						
						eventoNuevo.setLocalizacion(textLocalicacion.getText());

						DAOGeneral.eventoRemote.modificarEvento(eventoNuevo);
						PanelGestionDeEventos.getInstancia().cargarTabla(DAOGeneral.eventoRemote.obtenerEvento());

						JOptionPane.showMessageDialog(null, "Se modifico correctamente el Evento.", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(391, 440, 227, 33);
		contentPane.add(btnhvrGuardar);

		JLabel lblSeleccionarTutor = new JLabel("Seleccionar Tutor");
		lblSeleccionarTutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeleccionarTutor.setFont(new Font("Lato", Font.PLAIN, 17));
		lblSeleccionarTutor.setBounds(94, 374, 232, 14);
		contentPane.add(lblSeleccionarTutor);

		RSButtonHover btnhvrAsignarTutor = new RSButtonHover();
		btnhvrAsignarTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameAsignarTutores.asignados = tutoresAsignados;
				FrameAsignarTutores.esNuevo = false;
				FrameAsignarTutores frame = new FrameAsignarTutores();
				frame.setVisible(true);
			}
		});
		btnhvrAsignarTutor.setText("Asignar tutores");
		btnhvrAsignarTutor.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAsignarTutor.setBackground(new Color(52, 152, 219));
		btnhvrAsignarTutor.setBounds(237, 366, 227, 33);
		contentPane.add(btnhvrAsignarTutor);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(364, 317, 71, 14);
		contentPane.add(lblEstado);

		// se cargan todos los comboBox
		try {
			cargarComboBox();
			tutoresAsignados = eventoSeleccionado.getTutores();
		} catch (ServicesException e) {
			e.printStackTrace();
		}

		comboBoxITR.setSelectedItem(eventoSeleccionado.getItr().getNombre());
		comboBoxModalidad.setSelectedItem(eventoSeleccionado.getModalidad().getNombre());
		comboBoxTipoEvento.setSelectedItem(eventoSeleccionado.getTipoActividad().getNombre());
		comboBoxEstado.setSelectedItem(eventoSeleccionado.getEstado().getNombre());
		
		fechaInicio.setDatoFecha(eventoSeleccionado.getFechaInicio());
		fechaFin.setDatoFecha(eventoSeleccionado.getFechaFin());

		String horaInicio;
		String minInicio;
		if(eventoSeleccionado.getFechaInicio().getHours()<10) {
			horaInicio="0"+eventoSeleccionado.getFechaInicio().getHours();
		}	else {
			horaInicio=""+eventoSeleccionado.getFechaInicio().getHours();
		}
		if(eventoSeleccionado.getFechaInicio().getMinutes()==0) {
			minInicio="00";
		}else {
			minInicio=""+eventoSeleccionado.getFechaInicio().getMinutes();
		}
		comboBoxHoraInicio.setSelectedItem(horaInicio + ":" +minInicio );

		
		String horaFin;
		String minFin;
		if(eventoSeleccionado.getFechaFin().getHours()<10) {
			horaFin="0"+eventoSeleccionado.getFechaFin().getHours();
		}else {
			horaFin=""+eventoSeleccionado.getFechaFin().getHours();
		}
		
		if(eventoSeleccionado.getFechaFin().getMinutes()==0) {
			minFin="00";
		}else {
			minFin=""+eventoSeleccionado.getFechaFin().getMinutes();
		}
		comboBoxHoraFin.setSelectedItem(horaFin + ":" + minFin);
		
		RSButtonHover btnhvrCancel = new RSButtonHover();
		btnhvrCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(getParent(), "Estas seguro de cancelar, los datos no seran guardados.",
						"Guardado...", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

				if (input == 0) {
					setVisible(false);
				}
			}
		});
		btnhvrCancel.setText("Cancelar");
		btnhvrCancel.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrCancel.setBackground(new Color(52, 152, 219));
		btnhvrCancel.setBounds(82, 440, 227, 33);
		contentPane.add(btnhvrCancel);

	}

	public void cargarComboBox() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
			if (itr.getActivo()) {
				modeloITR.addElement(itr.getNombre());
			}
		}

		modeloModalidad.removeAllElements();
		modeloModalidad.addElement("");
		for (ModalidadesEventos m : DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()) {
			if (m.getActivo()) {
				modeloModalidad.addElement(m.getNombre());
			}
		}

		modeloTipoEvento.removeAllElements();
		modeloTipoEvento.addElement("");
		for (TipoActividad t : DAOGeneral.tipoActividadRemote.obtenerTipoActividad()) {
			modeloTipoEvento.addElement(t.getNombre());
		}

		modeloEstado.removeAllElements();
		modeloEstado.addElement("");
		for (EstadosEventos e : DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()) {
			if (e.getActivo()) {
				modeloEstado.addElement(e.getNombre());
			}
		}
	}
}
