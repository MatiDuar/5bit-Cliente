package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.Evento;
import com.entities.ITR;
import com.exception.ServicesException;
import com.vistas.Login;

import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;
import javax.swing.JTextField;
import rojerusan.RSTableMetro.SELECTION_ROWS;
import rojeru_san.efectos.ValoresEnum.ICONS;

public class FrameConvocatoriaEvento extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloNoAsignados;
	private DefaultTableModel modeloAsignados;

	public static Evento eventoSeleccionado;

	private RSTableMetro tableNoAsignado;
	private RSTableMetro tableAsignado;

	private DefaultComboBoxModel modeloITRA;
	private DefaultComboBoxModel modeloGenA;

	private DefaultComboBoxModel modeloITRN;
	private DefaultComboBoxModel modeloGenN;

	private ArrayList<Estudiante> asignados;
	private ArrayList<Estudiante> noAsignados;

	private RSTextFieldIconUno textBuscador;
	
	private RSComboBox comboBoxITRN;
	private RSComboBox comboBoxGenN;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConvocatoriaEvento frame = new FrameConvocatoriaEvento();
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
	public FrameConvocatoriaEvento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/vistas/img/UTEC.png")));
		setResizable(false);

		setTitle("Convocatoria a Evento");
		setBounds(100, 100, 718, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("CONVOCATORIA DE EVENTO");
		lblTitulo.setForeground(new Color(58, 69, 75));
		lblTitulo.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblTitulo.setBounds(207, 10, 360, 27);
		contentPane.add(lblTitulo);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(Login.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(639, 10, 50, 50);
		contentPane.add(labelImage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 142, 569, 222);
		contentPane.add(scrollPane);
		modeloNoAsignados = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Docuemtno", "ITR", "Generacion", "Id" }) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableNoAsignado = new RSTableMetro();
		tableNoAsignado.setModelSelection(SELECTION_ROWS.MULTIPLE_INTERVAL_SELECTION);
		tableNoAsignado.setBackgoundHead(new Color(52, 152, 219));

		tableNoAsignado.setModel(modeloNoAsignados);
		tableNoAsignado.removeColumn(tableNoAsignado.getColumnModel().getColumn(4));
		scrollPane.setViewportView(tableNoAsignado);

		modeloITRN = new DefaultComboBoxModel();
		 comboBoxITRN = new RSComboBox();
		comboBoxITRN.setColorBoton(Color.WHITE);
		comboBoxITRN.setDisabledIdex("");
		comboBoxITRN.setColorFondo(new Color(52, 152, 219));
		comboBoxITRN.setModel(modeloITRN);
		comboBoxITRN.setBounds(266, 74, 121, 32);
		contentPane.add(comboBoxITRN);

		modeloGenN = new DefaultComboBoxModel();
		comboBoxGenN = new RSComboBox();
		comboBoxGenN.setDisabledIdex("");

		comboBoxGenN.setColorBoton(Color.WHITE);
		comboBoxGenN.setColorFondo(new Color(52, 152, 219));
		comboBoxGenN.setModel(modeloGenN);
		comboBoxGenN.setBounds(400, 74, 121, 32);
		contentPane.add(comboBoxGenN);

		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(266, 57, 45, 13);
		contentPane.add(lblNewLabel);

		RSButtonHover btnhvrFiltrarN = new RSButtonHover();
		btnhvrFiltrarN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					filtrarTabla();
				} catch (ServicesException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnhvrFiltrarN.setText("Filtrar");
		btnhvrFiltrarN.setFont(new Font("Lato Black", Font.BOLD, 13));
		btnhvrFiltrarN.setBackground(new Color(52, 152, 219));
		btnhvrFiltrarN.setBounds(585, 74, 112, 33);
		contentPane.add(btnhvrFiltrarN);

		JLabel lblGeneracionEstudiante = new JLabel("Generaci\u00f3n");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(400, 57, 78, 13);
		contentPane.add(lblGeneracionEstudiante);

		JLabel lblNewLabel_2_1_1 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_2_1_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 115, 281, 27);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("ESTUDIANTES CONVOCADOS");
		lblNewLabel_2_1_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(10, 398, 360, 27);
		contentPane.add(lblNewLabel_2_1_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 436, 569, 222);
		contentPane.add(scrollPane_1);

		tableAsignado = new RSTableMetro();
		tableAsignado.setModelSelection(SELECTION_ROWS.MULTIPLE_INTERVAL_SELECTION);
		tableAsignado.setBackgoundHead(new Color(52, 152, 219));

		modeloAsignados = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Docuemtno", "ITR", "Generacion", "Id" }) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableAsignado.setModel(modeloAsignados);
		scrollPane_1.setViewportView(tableAsignado);
		tableAsignado.removeColumn(tableAsignado.getColumnModel().getColumn(4));

		RSButtonHover btnhvrAgregar = new RSButtonHover();
		btnhvrAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					agregarEstudiante();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnhvrAgregar.setText("Agregar");
		btnhvrAgregar.setFont(new Font("Lato Black", Font.BOLD, 13));
		btnhvrAgregar.setBackground(new Color(52, 152, 219));
		btnhvrAgregar.setBounds(585, 222, 112, 33);
		contentPane.add(btnhvrAgregar);

		RSButtonHover btnhvrQuitar = new RSButtonHover();

		btnhvrQuitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					quitarEstudiante();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrQuitar.setText("Quitar");
		btnhvrQuitar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrQuitar.setBackground(new Color(52, 152, 219));
		btnhvrQuitar.setBounds(585, 533, 112, 33);
		contentPane.add(btnhvrQuitar);

		tableAsignado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2 && tableAsignado.getSelectedRow() != -1) {
					try {
						quitarEstudiante();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		tableNoAsignado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2 && tableNoAsignado.getSelectedRow() != -1) {
					try {
						agregarEstudiante();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					int input = JOptionPane.showConfirmDialog(getParent(),
							"Desea Guardar la convocatoria al evento seleccionado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (input == 0) {
						ArrayList<Estudiante> asginadosNueva = asignados;
						for (Estudiante es : DAOGeneral.conAsistenciaBean.buscarPorEvento(eventoSeleccionado)) {
							boolean flag = false;
							for (Estudiante j : asignados) {
								if (es.getId() == j.getId()) {
									flag = true;
									break;
								}
							}
							if (!flag) {
								DAOGeneral.conAsistenciaBean.borrar(es, eventoSeleccionado);
								asginadosNueva.remove(es);
							}
						}

						for (Estudiante es : asginadosNueva) {
							boolean flag = false;
							for (Estudiante j : DAOGeneral.conAsistenciaBean.buscarPorEvento(eventoSeleccionado)) {
								if (es.getId() == j.getId()) {
									flag = true;
									break;
								}
							}
							if (!flag) {
								ConvocatoriaAsistencia con = new ConvocatoriaAsistencia();
								con.setEvento(eventoSeleccionado);
								con.setEstudiante(es);
								DAOGeneral.conAsistenciaBean.crear(con);
							}
						}

						JOptionPane.showMessageDialog(null, "Se guardo la convocatoria al evento seleccionado",
								"Guardado...", JOptionPane.INFORMATION_MESSAGE);

						setVisible(false);
					}

				} catch (ServicesException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(432, 669, 108, 33);
		contentPane.add(btnhvrGuardar);

		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int input = JOptionPane.showConfirmDialog(getParent(),
						"Desea cancelar la convocatoria al evento seleccionado\nLos datos no seran guardados",
						"Guardado...", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (input == 0) {
					setVisible(false);
				}
			}
		});
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(162, 669, 108, 33);
		contentPane.add(btnhvrCancelar);

		textBuscador = new RSTextFieldIconUno();
		textBuscador.setIcons(ICONS.SEARCH);
		textBuscador.setPlaceholder("Buscador...\r\n");
		textBuscador.setBounds(10, 74, 228, 32);
		contentPane.add(textBuscador);
		textBuscador.setColumns(10);

		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscador.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblBuscador.setBounds(10, 57, 78, 13);
		contentPane.add(lblBuscador);

		RSButtonHover btnhvrBorrarFiltro = new RSButtonHover();
		btnhvrBorrarFiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxGenN.setSelectedIndex(0);
				comboBoxITRN.setSelectedIndex(0);
				textBuscador.setText("");
				try {
					cargarTablaAsignado(asignados);
					cargarTablaNoAsignado(noAsignados);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnhvrBorrarFiltro.setText("Borrar Filtro");
		btnhvrBorrarFiltro.setFont(new Font("Lato Black", Font.BOLD, 13));
		btnhvrBorrarFiltro.setBackground(new Color(52, 152, 219));
		btnhvrBorrarFiltro.setBounds(585, 144, 112, 33);
		contentPane.add(btnhvrBorrarFiltro);

		try {
			asignados = (ArrayList<Estudiante>) estudianteAsignados();
			noAsignados = (ArrayList<Estudiante>) estudianteNoAsignados();
			cargarTablaAsignado(asignados);
			cargarTablaNoAsignado(noAsignados);
			cargarCombo();

			LocalDate year = LocalDate.now();

			modeloGenN.addElement("");
			for (int i = 2012; i <= year.getYear(); i++) {
				modeloGenN.addElement(i);
			}
		} catch (ServicesException e1) {
			e1.printStackTrace();
		}
	}

	public void cargarTablaAsignado(List<Estudiante> estudiantes) throws ServicesException {
		modeloAsignados.setRowCount(0);
		for (Estudiante e : estudiantes) {
			Vector v = new Vector();
			v.addElement(e.getNombre1() + " " + e.getApellido1());
			v.addElement(e.getDocumento());
			v.addElement(e.getItr().getNombre());
			v.addElement(e.getAnoIngreso());
			v.addElement(e.getId());
			modeloAsignados.addRow(v);
		}
	}

	public void cargarTablaNoAsignado(List<Estudiante> estudiantes) throws ServicesException {
		modeloNoAsignados.setRowCount(0);
		for (Estudiante e : estudiantes) {
			Vector v = new Vector();
			v.addElement(e.getNombre1() + " " + e.getApellido1());
			v.addElement(e.getDocumento());
			v.addElement(e.getItr().getNombre());
			v.addElement(e.getAnoIngreso());
			v.addElement(e.getId());
			modeloNoAsignados.addRow(v);
		}
	}

	public List<Estudiante> estudianteAsignados() throws ServicesException {
		return DAOGeneral.conAsistenciaBean.buscarPorEvento(eventoSeleccionado);
	}

	public List<Estudiante> estudianteNoAsignados() throws ServicesException {
		List<Estudiante> estudiantes = new ArrayList<>();
		for (Estudiante e : DAOGeneral.estudianteBean.obtenerEstudiantes()) {
			if (e.getValidado() && e.getActivo()) {
				boolean flag = false;
				for (Estudiante j : estudianteAsignados()) {
					if (e.getId() == j.getId()) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					estudiantes.add(e);
				}
			}

		}

		return estudiantes;
	}

	public Estudiante buscarEstudiante(List<Estudiante> estudiantes, Estudiante e) {
		for (Estudiante i : estudiantes) {
			if (i.getId() == e.getId()) {
				return i;
			}
		}
		return null;
	}
	
	public void filtrarTabla() throws ServicesException {
		ArrayList<Estudiante> estudiantesFilt1NoAsignado = new ArrayList<>();
		ArrayList<Estudiante> estudiantesFilt1Asignado = new ArrayList<>();

		if (comboBoxITRN.getSelectedItem().toString() == "") {
			estudiantesFilt1NoAsignado = noAsignados;
			estudiantesFilt1Asignado = asignados;
		} else {
			for (Estudiante es : noAsignados) {
				if (es.getItr().getNombre().equalsIgnoreCase(comboBoxITRN.getSelectedItem().toString())) {
					estudiantesFilt1NoAsignado.add(es);
				}
			}
			for (Estudiante es : asignados) {
				if (es.getItr().getNombre().equalsIgnoreCase(comboBoxITRN.getSelectedItem().toString())) {
					estudiantesFilt1Asignado.add(es);
				}
			}
		}
		ArrayList<Estudiante> estudiantesFilt2NoAsignado = new ArrayList<>();
		ArrayList<Estudiante> estudiantesFilt2Asignado = new ArrayList<>();

		if (comboBoxGenN.getSelectedItem().toString() == "") {
			estudiantesFilt2NoAsignado = estudiantesFilt1NoAsignado;
			estudiantesFilt2Asignado = estudiantesFilt1Asignado;
		} else {
			for (Estudiante es : estudiantesFilt1NoAsignado) {
				if (es.getAnoIngreso() == Integer.parseInt(comboBoxGenN.getSelectedItem().toString())) {
					estudiantesFilt2NoAsignado.add(es);
				}
			}
			for (Estudiante es : estudiantesFilt1Asignado) {
				if (es.getAnoIngreso() == Integer.parseInt(comboBoxGenN.getSelectedItem().toString())) {
					estudiantesFilt2Asignado.add(es);
				}
			}
		}
		ArrayList<Estudiante> estudiantesFilt3NoAsignado = new ArrayList<>();
		ArrayList<Estudiante> estudiantesFilt3Asignado = new ArrayList<>();
		if(textBuscador.getText().equalsIgnoreCase("")) {
			estudiantesFilt3Asignado=estudiantesFilt2Asignado;
			estudiantesFilt3NoAsignado=estudiantesFilt2NoAsignado;
		}else {
			for (Estudiante es : estudiantesFilt2NoAsignado) {
				String nombre=es.getNombre1()+" "+es.getApellido1();
				if (nombre.toLowerCase().startsWith(textBuscador.getText().toLowerCase())) {
					estudiantesFilt3NoAsignado.add(es);
				}
			}
			for (Estudiante es : estudiantesFilt2Asignado) {
				String nombre=es.getNombre1()+" "+es.getApellido1();
				if (nombre.toLowerCase().startsWith(textBuscador.getText().toLowerCase())) {
					estudiantesFilt3Asignado.add(es);
				}
			}
		}
		
		cargarTablaNoAsignado(estudiantesFilt3NoAsignado);
		cargarTablaAsignado(estudiantesFilt3Asignado);
	}

	public void cargarCombo() throws ServicesException {
		modeloITRN.removeAllElements();
		modeloITRN.addElement("");
		for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITRN.addElement(itr.getNombre());
		}
	}	
	
	public void agregarEstudiante() throws Exception {
		if (tableNoAsignado.getSelectedRow() == -1) {
			throw new Exception("Debe seleccionar un estudiante de la lista No Asignados, para poder Agregarlo.");
		}
		
		for(int i:tableNoAsignado.getSelectedRows()) {
			Estudiante estudianteTabla = (Estudiante) DAOGeneral.usuarioRemote
					.buscarUsuarioPorId((Long) modeloNoAsignados.getValueAt(i, 4));
			Estudiante estudianteLista = buscarEstudiante(noAsignados, estudianteTabla);
			noAsignados.remove(estudianteLista);
			asignados.add(estudianteLista);
		}

		cargarTablaAsignado(asignados);
		cargarTablaNoAsignado(noAsignados);
		filtrarTabla();
	}
	
	
	public void quitarEstudiante() throws Exception {
		if (tableAsignado.getSelectedRow() == -1) {
			throw new Exception(
					"Debe seleccionar un estudiante de la lista Asignados, para poder quitarlo de la misma.");
		}
		for(int i:tableAsignado.getSelectedRows()) {
			Estudiante estudianteTabla = (Estudiante) DAOGeneral.usuarioRemote
					.buscarUsuarioPorId((Long) modeloAsignados.getValueAt(i, 4));
			Estudiante estudianteLista = buscarEstudiante(asignados, estudianteTabla);
			asignados.remove(estudianteLista);
			noAsignados.add(estudianteLista);
		}
		cargarTablaAsignado(asignados);
		cargarTablaNoAsignado(noAsignados);
		filtrarTabla();
	}


}
