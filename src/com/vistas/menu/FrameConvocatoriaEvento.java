package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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

import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;

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
		setBounds(100, 100, 711, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("CONVOCATORIA DE EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(202, 10, 281, 27);
		contentPane.add(lblNewLabel_2_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 142, 569, 207);
		contentPane.add(scrollPane);
		modeloNoAsignados = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Docuemtno", "ITR", "Generacion", "Id" });
		tableNoAsignado = new RSTableMetro();
		tableNoAsignado.setModel(modeloNoAsignados);
		tableNoAsignado.removeColumn(tableNoAsignado.getColumnModel().getColumn(4));
		scrollPane.setViewportView(tableNoAsignado);

		modeloITRN = new DefaultComboBoxModel();
		RSComboBox comboBoxITRN= new RSComboBox();
		comboBoxITRN.setModel(modeloITRN);
		comboBoxITRN.setBounds(17, 73, 121, 32);
		contentPane.add(comboBoxITRN);

		modeloGenN = new DefaultComboBoxModel();
		RSComboBox comboBoxGenN = new RSComboBox();
		comboBoxGenN.setModel(modeloGenN);
		comboBoxGenN.setBounds(151, 73, 121, 32);
		contentPane.add(comboBoxGenN);
		
		
		modeloITRA = new DefaultComboBoxModel();
		RSComboBox comboBoxITRA = new RSComboBox();
		comboBoxITRA.setModel(modeloITRA);
		comboBoxITRA.setBounds(17, 379, 121, 32);
		contentPane.add(comboBoxITRA);

		modeloGenA = new DefaultComboBoxModel();
		RSComboBox comboBoxGenA = new RSComboBox();
		comboBoxGenA.setModel(modeloGenA);
		comboBoxGenA.setBounds(151, 379, 121, 32);
		contentPane.add(comboBoxGenA);

		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(17, 56, 45, 13);
		contentPane.add(lblNewLabel);

		RSButtonHover btnhvrFiltrarN = new RSButtonHover();
		btnhvrFiltrarN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Estudiante> estudiantesFilt1 = new ArrayList<>();
					if (comboBoxITRN.getSelectedItem().toString() == "") {
						estudiantesFilt1 = noAsignados;
					} else {
						for (Estudiante es : noAsignados) {
							if (es.getItr().getNombre().equalsIgnoreCase(comboBoxITRN.getSelectedItem().toString())) {
								estudiantesFilt1.add(es);
							}
						}
					}
					ArrayList<Estudiante> estudiantesFilt2 = new ArrayList<>();
					if (comboBoxGenN.getSelectedItem().toString() == "") {
						estudiantesFilt2 = estudiantesFilt1;
					} else {
						for (Estudiante es : estudiantesFilt1) {
							if (es.getAnoIngreso() == Integer.parseInt(comboBoxGenN.getSelectedItem().toString())) {
								estudiantesFilt2.add(es);
							}
						}
					}
					cargarTablaNoAsignado(estudiantesFilt2);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnhvrFiltrarN.setText("Filtrar");
		btnhvrFiltrarN.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrarN.setBackground(new Color(0, 112, 192));
		btnhvrFiltrarN.setBounds(569, 73, 108, 33);
		contentPane.add(btnhvrFiltrarN);

		JLabel lblGeneracionEstudiante = new JLabel("Generaci\u00C3\u00B3n");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(151, 56, 78, 13);
		contentPane.add(lblGeneracionEstudiante);

		JLabel lblNewLabel_2_1_1 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_2_1_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 115, 281, 27);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("ESTUDIANTES CONVOCADOS");
		lblNewLabel_2_1_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(10, 422, 298, 27);
		contentPane.add(lblNewLabel_2_1_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 451, 569, 207);
		contentPane.add(scrollPane_1);

		tableAsignado = new RSTableMetro();
		modeloAsignados = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Docuemtno", "ITR", "Generacion", "Id" });
		tableAsignado.setModel(modeloAsignados);
		scrollPane_1.setViewportView(tableAsignado);
		tableAsignado.removeColumn(tableAsignado.getColumnModel().getColumn(4));

		RSButtonHover btnhvrAgregar = new RSButtonHover();
		btnhvrAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(tableNoAsignado.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar un estudiante de la lista No Asignados, para poder Agregarlo.");
					}
					Estudiante estudianteTabla = (Estudiante) DAOGeneral.usuarioRemote.buscarUsuarioPorId(
							(Long) modeloNoAsignados.getValueAt(tableNoAsignado.getSelectedRow(), 4));
					Estudiante estudianteLista = buscarEstudiante(noAsignados, estudianteTabla);
					noAsignados.remove(estudianteLista);
					asignados.add(estudianteLista);

					cargarTablaAsignado(asignados);
					cargarTablaNoAsignado(noAsignados);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnhvrAgregar.setText("Agregar");
		btnhvrAgregar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrAgregar.setBackground(new Color(0, 112, 192));
		btnhvrAgregar.setBounds(585, 222, 108, 33);
		contentPane.add(btnhvrAgregar);

		RSButtonHover btnhvrQuitar = new RSButtonHover();

		btnhvrQuitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(tableAsignado.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar un estudiante de la lista Asignados, para poder quitarlo de la misma.");
					}
					Estudiante estudianteTabla = (Estudiante) DAOGeneral.usuarioRemote
							.buscarUsuarioPorId((Long) modeloAsignados.getValueAt(tableAsignado.getSelectedRow(), 4));
					Estudiante estudianteLista = buscarEstudiante(asignados, estudianteTabla);
					asignados.remove(estudianteLista);
					noAsignados.add(estudianteLista);

					cargarTablaAsignado(asignados);
					cargarTablaNoAsignado(noAsignados);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrQuitar.setText("Quitar");
		btnhvrQuitar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrQuitar.setBackground(new Color(0, 112, 192));
		btnhvrQuitar.setBounds(589, 533, 108, 33);
		contentPane.add(btnhvrQuitar);

		

		RSButtonHover btnhvrFiltrarA = new RSButtonHover();
		btnhvrFiltrarA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Estudiante> estudiantesFilt1 = new ArrayList<>();
					if (comboBoxITRA.getSelectedItem().toString() == "") {
						estudiantesFilt1 = asignados;
					} else {
						for (Estudiante es : asignados) {
							if (es.getItr().getNombre().equalsIgnoreCase(comboBoxITRA.getSelectedItem().toString())) {
								estudiantesFilt1.add(es);
							}
						}
					}
					ArrayList<Estudiante> estudiantesFilt2 = new ArrayList<>();
					if (comboBoxGenA.getSelectedItem().toString() == "") {
						estudiantesFilt2 = estudiantesFilt1;
					} else {
						for (Estudiante es : estudiantesFilt1) {
							if (es.getAnoIngreso() == Integer.parseInt(comboBoxGenA.getSelectedItem().toString())) {
								estudiantesFilt2.add(es);
							}
						}
					}
					cargarTablaAsignado(estudiantesFilt2);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnhvrFiltrarA.setText("Filtrar");
		btnhvrFiltrarA.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrarA.setBackground(new Color(0, 112, 192));
		btnhvrFiltrarA.setBounds(569, 379, 108, 33);
		contentPane.add(btnhvrFiltrarA);

		JLabel lblGeneracionEstudiante_1 = new JLabel("Generaci\u00C3\u00B3n");
		lblGeneracionEstudiante_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante_1.setBounds(151, 362, 78, 13);
		contentPane.add(lblGeneracionEstudiante_1);

		JLabel lblNewLabel_1 = new JLabel("ITR");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(17, 362, 45, 13);
		contentPane.add(lblNewLabel_1);

		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea Guardar la convocatoria al evento seleccionado", "Guardado...",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(input==0) {
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
						 
						 JOptionPane.showMessageDialog(null, "Se guardo la convocatoria al evento seleccionado", "Guardado...",
									JOptionPane.INFORMATION_MESSAGE);
						 
						 setVisible(false);
					 }
					
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(413, 669, 108, 33);
		contentPane.add(btnhvrGuardar);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int input = JOptionPane.showConfirmDialog(getParent(), "Desea cancelar la convocatoria al evento seleccionado\nLos datos no seran guardados", "Guardado...",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(input==0) {
					setVisible(false);
				}
			}
		});
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(0, 112, 192));
		btnhvrCancelar.setBounds(164, 669, 108, 33);
		contentPane.add(btnhvrCancelar);

		try {
			asignados = (ArrayList<Estudiante>) estudianteAsignados();
			noAsignados = (ArrayList<Estudiante>) estudianteNoAsignados();
			cargarTablaAsignado(asignados);
			cargarTablaNoAsignado(noAsignados);
			cargarCombo();

			LocalDate year = LocalDate.now();
			modeloGenA.addElement("");
			for (int i = 2012; i <= year.getYear(); i++) {
				modeloGenA.addElement(i);
			}

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

	public void cargarCombo() throws ServicesException {
		modeloITRA.removeAllElements();
		modeloITRA.addElement("");
		for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITRA.addElement(itr.getNombre());
		}
		modeloITRN.removeAllElements();
		modeloITRN.addElement("");
		for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloITRN.addElement(itr.getNombre());
		}
	}
}
