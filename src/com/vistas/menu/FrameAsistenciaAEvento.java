package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.Evento;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;

public class FrameAsistenciaAEvento extends JFrame {

	private JPanel contentPane;
	private RSTableMetro table;
	
	private DefaultTableModel modeloTabla;
	public static Evento eventeSeleccionado;

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
		setBounds(100, 100, 565, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ASISTENCIA A  EVENTO");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(161, 10, 227, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 163, 521, 393);
		contentPane.add(scrollPane);
		
		table = new RSTableMetro();
		
		RSComboBox comboBoxEstadoTabla = new RSComboBox();
		comboBoxEstadoTabla.setSelectedIndex(1);
		comboBoxEstadoTabla.setModel(new DefaultComboBoxModel(new String[] {"Sin Registrar", "Asistencia ", "Media Asistencia", "Matutina", "Vespertina ", "Ausencia", "Ausencia Justificada"}));
		
		modeloTabla=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null },
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Nombre",  "Cedula", "A\u00F1o Ingreso", "Asistencia"
				}
			);
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxEstadoTabla));
		

		for(int i=0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setMinWidth(60);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
     
		
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setBounds(15, 94, 121, 32);
		contentPane.add(comboBoxITR);
		
		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(15, 77, 45, 13);
		contentPane.add(lblNewLabel);
		
		RSComboBox comboBoxEstado = new RSComboBox();
		comboBoxEstado.setBounds(151, 94, 121, 32);
		contentPane.add(comboBoxEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblEstado.setBounds(151, 77, 45, 13);
		contentPane.add(lblEstado);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(423, 93, 108, 33);
		contentPane.add(btnhvrFiltrar);
		
		RSComboBox comboBoxGen = new RSComboBox();
		comboBoxGen.setModel(new DefaultComboBoxModel(new String[] 
				{"Sin Asignar", "Asistencia ", "Media Asistencia", "Matutina", "Vespertina ", "Ausencia", "Ausencia Justificada"
						}));
		comboBoxGen.setBounds(287, 94, 121, 32);
		contentPane.add(comboBoxGen);
		
		JLabel lblGeneracionEstudiante = new JLabel("Generaci\u00f3n");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(287, 77, 78, 13);
		contentPane.add(lblGeneracionEstudiante);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_2_1_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 136, 281, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(0, 112, 192));
		btnhvrCancelar.setBounds(106, 571, 108, 33);
		contentPane.add(btnhvrCancelar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(321, 571, 108, 33);
		contentPane.add(btnhvrGuardar);
		
		try {
			cargarTabla();
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cargarTabla() throws ServicesException {
//		"Nombre", "Cedula", "A\u00F1o Ingreso", "Asistencia"

		modeloTabla.setColumnCount(0);
		for(Estudiante e:DAOGeneral.conAsistenciaBean.buscarPorEvento(eventeSeleccionado)) {
			Vector v=new Vector();
			v.addElement(e.getNombre1()+" "+e.getApellido1());
			v.addElement(e.getDocumento());
			v.addElement(e.getAnoIngreso());
			ConvocatoriaAsistencia ca=DAOGeneral.conAsistenciaBean.buscarPorEstudianteEvento(e, eventeSeleccionado);
			modeloTabla.setValueAt(ca.getEstadoAsistencia().getNombre(), modeloTabla.getRowCount()-1, 3);
			
			modeloTabla.addRow(v);
		}
	}
}
