package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.ConvocatoriaAsistencia;
import com.entities.EstadoAsistencia;
import com.entities.Estudiante;
import com.entities.Evento;
import com.entities.ITR;
import com.exception.ServicesException;

import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;
import rojeru_san.efectos.ValoresEnum.ICONS;

public class FrameAsistenciaAEvento extends JFrame {

	private JPanel contentPane;
	RSTableMetro table;
	private DefaultTableModel modeloTabla;
	public static Evento eventeSeleccionado;

	DefaultComboBoxModel modeloEstadoAsistencia;
	DefaultComboBoxModel modeloItr = new DefaultComboBoxModel<>();
	DefaultComboBoxModel modeloEstado = new DefaultComboBoxModel<>();
	private RSTextFieldIconUno textBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAsistenciaAEvento frame = new FrameAsistenciaAEvento();
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
	public FrameAsistenciaAEvento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 586, 657);
		setLocationRelativeTo(getParent());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("ASISTENCIA A EVENTO");
		lblTitulo.setForeground(new Color(58, 69, 75));
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(161, 10, 281, 27);
		contentPane.add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 163, 521, 393);
		contentPane.add(scrollPane);

		table = new RSTableMetro();
		modeloEstadoAsistencia=new DefaultComboBoxModel();
		RSComboBox comboBoxEstadoTabla = new RSComboBox();
		comboBoxEstadoTabla.setSelectedIndex(1);
		comboBoxEstadoTabla.setModel(modeloEstadoAsistencia);

		modeloTabla = new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Nombre", "Cedula", "ITR", "Asistencia","Id" });
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxEstadoTabla));

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setMinWidth(60);
		}
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		table.removeColumn(table.getColumnModel().getColumn(4));

		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setColorBoton(Color.WHITE);
		comboBoxITR.setColorFondo(new Color(52, 152, 219));
		comboBoxITR.setDisabledIdex("");
		comboBoxITR.setModel(modeloItr);
		comboBoxITR.setBounds(161, 94, 121, 32);
		contentPane.add(comboBoxITR);

		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(161, 77, 45, 13);
		contentPane.add(lblNewLabel);

		modeloEstado=new DefaultComboBoxModel();
		
		RSComboBox comboBoxEstado = new RSComboBox();
		comboBoxEstado.setColorBoton(Color.WHITE);
		comboBoxEstado.setColorFondo(new Color(52, 152, 219));
		comboBoxEstado.setDisabledIdex("");

		comboBoxEstado.setModel(modeloEstado);
		comboBoxEstado.setBounds(292, 94, 121, 32);
		contentPane.add(comboBoxEstado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(292, 77, 45, 13);
		contentPane.add(lblEstado);

		
		
		DefaultComboBoxModel modeloGen=new DefaultComboBoxModel();
		modeloGen.addElement("");
		for(int i=2012;i<2023;i++) {
			modeloGen.addElement(i);
		}

		JLabel lblNewLabel_2_1_1 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_2_1_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 136, 281, 27);
		contentPane.add(lblNewLabel_2_1_1);

		RSButtonHover btnhvrCancelar = new RSButtonHover();
		
		btnhvrCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 int input = JOptionPane.showConfirmDialog(getParent(), "Desea cancelar el registro de asistencias al evento \nLos datos no seran guardados", "Guardado...",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					 if(input==0) {
						 setVisible(false);
					 }
					 
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(106, 571, 108, 33);
		contentPane.add(btnhvrCancelar);

		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 int input = JOptionPane.showConfirmDialog(getParent(), "Desea confirmar la asistencia al evento", "Guardado...",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					 if(input==0) {
						 for(long i=0;i<table.getRowCount();i++) {
							ConvocatoriaAsistencia conAsis=DAOGeneral.conAsistenciaBean.buscarPorId((long)modeloTabla.getValueAt((int) i, 4));
							conAsis.setEstadoAsistencia(DAOGeneral.estadoAsistenciaBean.obtenerPorNombre(modeloTabla.getValueAt((int) i, 3).toString()));
							DAOGeneral.conAsistenciaBean.modificar(conAsis);
						 }
						 
						 JOptionPane.showMessageDialog(null, "Se guardo correctamente la asistencia al evento seleccionado", "Guardado...",
									JOptionPane.INFORMATION_MESSAGE);
						 
						 setVisible(false);
					 }
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(321, 571, 108, 33);
		contentPane.add(btnhvrGuardar);
		
		textBuscar = new RSTextFieldIconUno();
		textBuscar.setBorderColor(new Color(52, 152, 219));
		textBuscar.setIcons(ICONS.SEARCH);
		textBuscar.setPlaceholder("Busacar ...");
		textBuscar.setBounds(10, 94, 141, 32);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);

		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					ArrayList<Estudiante>estudiantesFilt=new ArrayList<>();
					if(comboBoxITR.getSelectedItem().toString()=="") {
						estudiantesFilt= (ArrayList<Estudiante>) DAOGeneral.conAsistenciaBean.buscarPorEvento(eventeSeleccionado);
					}else {
						for(Estudiante es: DAOGeneral.conAsistenciaBean.buscarPorEvento(eventeSeleccionado)) {
							if(es.getItr().getNombre().equalsIgnoreCase(comboBoxITR.getSelectedItem().toString())) {
								estudiantesFilt.add(es);
							}
						}
					}
					ArrayList<Estudiante>estudiantesFilt2=new ArrayList<>();
					
					if(comboBoxEstado.getSelectedItem().toString()=="") {
						estudiantesFilt2=estudiantesFilt;
					}else {
						for(Estudiante es: estudiantesFilt) {
							if(DAOGeneral.conAsistenciaBean.buscarPorEstudianteEvento(es, eventeSeleccionado).getEstadoAsistencia().getNombre().equalsIgnoreCase(comboBoxEstado.getSelectedItem().toString())) {
								estudiantesFilt2.add(es);
							}
						}
					}
					
					ArrayList<Estudiante>estudiantesFilt3=new ArrayList<>();
					if(textBuscar.getText()=="") {
						estudiantesFilt3=estudiantesFilt2;
					}else {
						for(Estudiante es:estudiantesFilt2) {
							String nombre=es.getNombre1()+ " "+ es.getApellido1();
							nombre=nombre.toLowerCase();
							String cedula=es.getDocumento()+"";
							if(nombre.startsWith(textBuscar.getText().toLowerCase()) || cedula.startsWith(textBuscar.getText()) ) {
								estudiantesFilt3.add(es);
							}
						}
					}
					
					cargarTabla(estudiantesFilt3);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(52, 152, 219));
		btnhvrFiltrar.setBounds(423, 93, 108, 33);
		contentPane.add(btnhvrFiltrar);
		
		try {
			cargarCombo();

			cargarTabla(DAOGeneral.conAsistenciaBean.buscarPorEvento(eventeSeleccionado));
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarTabla(List<Estudiante>estudiantes) throws ServicesException {
//		"Nombre", "Cedula", "A\u00F1o Ingreso", "Asistencia"

		modeloTabla.setRowCount(0);
		for (Estudiante e : estudiantes) {
			Vector v = new Vector();
			v.addElement(e.getNombre1() + " " + e.getApellido1());
			v.addElement(e.getDocumento());
			v.addElement(e.getItr().getNombre());
			ConvocatoriaAsistencia ca = DAOGeneral.conAsistenciaBean.buscarPorEstudianteEvento(e, eventeSeleccionado);
			if (ca.getEstadoAsistencia() == null) {
				v.addElement("Sin Registrar");
			} else {
				v.addElement(ca.getEstadoAsistencia().getNombre());
			}
			v.addElement(ca.getId());
			modeloTabla.addRow(v);
		}
	}

	public void cargarCombo() throws ServicesException {
		modeloEstadoAsistencia.removeAllElements();
		for (EstadoAsistencia es : DAOGeneral.estadoAsistenciaBean.obtenerTodos()) {
			modeloEstadoAsistencia.addElement(es.getNombre());
		}

		modeloItr.removeAllElements();
		modeloItr.addElement("");
		for (ITR i : DAOGeneral.itrRemote.obtenerItrs()) {
			modeloItr.addElement(i.getNombre());
		}

		modeloEstado.removeAllElements();
		modeloEstado.addElement("");
		for (EstadoAsistencia d : DAOGeneral.estadoAsistenciaBean.obtenerTodos()) {
			modeloEstado.addElement(d.getNombre());
		}

	}
}
