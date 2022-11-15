package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public FrameModificarEvento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 717, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("NUEVO EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(280, 24, 160, 27);
		contentPane.add(lblNewLabel_2_1);

		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setBounds(644, 11, 51, 53);
		contentPane.add(labelImage_1);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTitulo.setBounds(56, 110, 28, 14);
		contentPane.add(lblTitulo);

		RSTextFull textTitulo = new RSTextFull();
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
		fechaFin.setDatoFecha(new java.util.Date(eventoSeleccionado.getFechaFin().getYear(),
				eventoSeleccionado.getFechaFin().getMonth(), eventoSeleccionado.getFechaFin().getDay()));
		fechaFin.setBounds(94, 196, 250, 42);
		contentPane.add(fechaFin);

		modeloTipoEvento = new DefaultComboBoxModel();
		RSComboBox comboBoxTipoEvento = new RSComboBox();
		comboBoxTipoEvento.setModel(modeloTipoEvento);
		comboBoxTipoEvento.setBounds(440, 96, 250, 42);
		contentPane.add(comboBoxTipoEvento);

		RSDateChooser fechaInicio = new RSDateChooser();
		fechaInicio.setDatoFecha(new java.util.Date(eventoSeleccionado.getFechaInicio().getYear(),
				eventoSeleccionado.getFechaInicio().getMonth(), eventoSeleccionado.getFechaInicio().getDay()));
		fechaInicio.setBounds(94, 143, 250, 42);
		contentPane.add(fechaInicio);

		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModalidad.setFont(new Font("Lato", Font.PLAIN, 11));
		lblModalidad.setBounds(27, 263, 62, 14);
		contentPane.add(lblModalidad);

		modeloModalidad = new DefaultComboBoxModel();
		RSComboBox comboBoxModalidad = new RSComboBox();
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
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setBounds(440, 248, 250, 42);
		contentPane.add(comboBoxITR);

		JLabel lblLocalizacion = new JLabel("Localizacion");
		lblLocalizacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocalizacion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblLocalizacion.setBounds(18, 316, 66, 14);
		contentPane.add(lblLocalizacion);

		RSTextFull textLocalicacion = new RSTextFull();
		textLocalicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLocalicacion.setBounds(94, 302, 250, 42);
		textLocalicacion.setText(eventoSeleccionado.getLocalizacion());

		contentPane.add(textLocalicacion);

		DefaultComboBoxModel modeloInicio = new DefaultComboBoxModel();
		RSComboBox comboBoxHoraInicio = new RSComboBox();
		comboBoxHoraInicio.setModel(modeloInicio);
		comboBoxHoraInicio.setBounds(440, 144, 250, 42);
		contentPane.add(comboBoxHoraInicio);
		DefaultComboBoxModel modeloFin = new DefaultComboBoxModel();

		RSComboBox comboBoxHoraFin = new RSComboBox();
		comboBoxHoraFin.setModel(modeloFin);
		comboBoxHoraFin.setBounds(440, 196, 250, 42);
		contentPane.add(comboBoxHoraFin);

		RSComboBox comboBoxEstado = new RSComboBox();
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
						eventoNuevo.setTitulo(textTitulo.getText());

						// falta campos pero no lo pide el requerimiento
						eventoNuevo.setCreditos(0);
						eventoNuevo.setSemestre(1);

						eventoNuevo.setEstado(DAOGeneral.estadosEventoRemote
								.buscarNombreEstadoEvento(comboBoxEstado.getSelectedItem().toString()));
						eventoNuevo.setItr(
								DAOGeneral.itrRemote.obtenerItrPorNombre(comboBoxITR.getSelectedItem().toString()));
						eventoNuevo.setModalidad(DAOGeneral.modalidadEventoRemote
								.buscarNombreModalidadEvento(comboBoxModalidad.getSelectedItem().toString()));
						eventoNuevo.setTipoActividad(DAOGeneral.tipoActividadRemote
								.obtenerTipoActividadPorNombre(comboBoxTipoEvento.getSelectedItem().toString()));
						eventoNuevo.setTutores(tutoresAsignados);

//					// fecha de evento inicio

						Timestamp dateInicio = new Timestamp(fechaInicio.getDatoFecha().getTime());
						String horaMinIncio[] = comboBoxHoraInicio.getSelectedItem().toString().split(":");
						dateInicio.setHours(Integer.parseInt(horaMinIncio[0]));
						dateInicio.setMinutes(Integer.parseInt(horaMinIncio[1]));
						eventoNuevo.setFechaInicio(dateInicio);

						// fecha de evento fin

						Timestamp dateFin = new Timestamp(fechaFin.getDatoFecha().getTime());
						String[] horaMinFin = comboBoxHoraFin.getSelectedItem().toString().split(":");
						dateFin.setHours(Integer.parseInt(horaMinFin[0]));
						dateFin.setMinutes(Integer.parseInt(horaMinFin[1]));

						eventoNuevo.setFechaFin(dateFin);

						eventoNuevo.setSemestre(1);

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
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(386, 440, 227, 33);
		contentPane.add(btnhvrGuardar);

		JLabel lblSeleccionarTutor = new JLabel("Seleccionar Tutor");
		lblSeleccionarTutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeleccionarTutor.setFont(new Font("Lato", Font.PLAIN, 17));
		lblSeleccionarTutor.setBounds(18, 374, 232, 14);
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
		btnhvrAsignarTutor.setBackground(new Color(0, 112, 192));
		btnhvrAsignarTutor.setBounds(179, 366, 227, 33);
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
		String horasInicio;
		String minutosInicio;
		if (eventoSeleccionado.getFechaInicio().getHours() < 10) {
			horasInicio = "0" + eventoSeleccionado.getFechaInicio().getHours();
		} else {
			horasInicio = "0" + eventoSeleccionado.getFechaInicio().getHours();
		}
		if (eventoSeleccionado.getFechaInicio().getMinutes() == 0) {
			minutosInicio = "00";
		} else {
			minutosInicio = "30";
		}
		comboBoxHoraInicio.setSelectedItem(horasInicio + ":" + minutosInicio);

		String horasFin;
		String minutosFin;
		if (eventoSeleccionado.getFechaFin().getHours() < 10) {
			horasFin = "0" + eventoSeleccionado.getFechaFin().getHours();
		} else {
			horasFin = "0" + eventoSeleccionado.getFechaFin().getHours();
		}
		if (eventoSeleccionado.getFechaFin().getMinutes() == 0) {
			minutosFin = "00";
		} else {
			minutosFin = "30";
		}
		comboBoxHoraFin.setSelectedItem(horasFin + ":" + minutosFin);
		
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
		btnhvrCancel.setBackground(new Color(0, 112, 192));
		btnhvrCancel.setBounds(94, 440, 227, 33);
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
