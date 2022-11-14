package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.AreaTutor;
import com.entities.Estudiante;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.Tutor;
import com.exception.ServicesException;

import RSMaterialComponent.RSButtonIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rsfield.RSTextFull;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;

public class FrameAsignarTutores extends JFrame {

	private JPanel contentPane;
	private DefaultComboBoxModel modeloITR;
	private DefaultComboBoxModel modeloArea;
	
	
	private DefaultTableModel modeloAsignados;
	private DefaultTableModel modeloNoAsignados;
	
	private RSTableMetro tableNoAsignados;
	private RSTableMetro tableAsignados;

	
	public static boolean esNuevo;
		
	
	public static ArrayList<Tutor>asignados;
	private ArrayList<Tutor>noAsignados;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAsignarTutores frame = new FrameAsignarTutores();
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
	public FrameAsignarTutores() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 525, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 201, 284);
		contentPane.add(scrollPane);
		modeloAsignados = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Documento", "ITR", "Area", "Id" }){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};;
		
		tableAsignados = new RSTableMetro();
		
		tableAsignados.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==2 && tableAsignados.getSelectedRow()!=-1) {
					try {
						quitarTutor();
					} catch (ServicesException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		tableAsignados.setModel(modeloAsignados);
		tableAsignados.removeColumn(tableAsignados.getColumnModel().getColumn(4));
		

		scrollPane.setViewportView(tableAsignados);
		
		JLabel lblNewLabel = new JLabel("Tutores Asignados");
		lblNewLabel.setBounds(22, 135, 165, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFuncionalidadesNoAsignadas = new JLabel("Tutores  No Asignadaos");
		lblFuncionalidadesNoAsignadas.setBounds(310, 135, 180, 14);
		contentPane.add(lblFuncionalidadesNoAsignadas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(298, 160, 201, 284);
		contentPane.add(scrollPane_1);
		
		modeloNoAsignados = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Documento", "ITR", "Area", "Id" }){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};;;
		tableNoAsignados = new RSTableMetro();
		tableNoAsignados.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==2 && tableNoAsignados.getSelectedRow()!=-1) {
					try {
						agregarTutor();
					} catch (ServicesException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		tableNoAsignados.setModel(modeloNoAsignados);
		tableNoAsignados.removeColumn(tableNoAsignados.getColumnModel().getColumn(4));

		scrollPane_1.setViewportView(tableNoAsignados);
		
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("ASIGNAR TUTORES");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(136, 11, 237, 27);
		contentPane.add(lblNewLabel_2_1);
		
		RSButtonHover btnGuardar = new RSButtonHover();
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(esNuevo) {
					FrameNuevoEvento.tutoresAsignados=asignados;
				}else {
					FrameModificarEvento.tutoresAsignados=asignados;
				}
				setVisible(false);
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnGuardar.setBackground(new Color(0, 112, 192));
		btnGuardar.setBounds(310, 481, 108, 33);
		contentPane.add(btnGuardar);
		
		
		RSButtonIconUno btnAgregarTutor = new RSButtonIconUno();
		btnAgregarTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					agregarTutor();
				} catch (ServicesException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAgregarTutor.setIcons(ICONS.ARROW_BACK);
		btnAgregarTutor.setBounds(234, 185, 40, 40);
		contentPane.add(btnAgregarTutor);
		
		RSButtonIconUno btnSacarTutor = new RSButtonIconUno();
		btnSacarTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					quitarTutor();
				} catch (ServicesException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSacarTutor.setIcons(ICONS.ARROW_FORWARD);
		btnSacarTutor.setBounds(234, 358, 40, 40);
		contentPane.add(btnSacarTutor);
		
		RSButtonHover btnCancelar = new RSButtonHover();
		btnCancelar.setText("Cancelar");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(0, 112, 192));
		btnCancelar.setBounds(103, 481, 108, 33);
		contentPane.add(btnCancelar);
		
		RSTextFull textBuscar = new RSTextFull();
		textBuscar.setText((String) null);
		textBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		textBuscar.setBounds(10, 82, 218, 33);
		contentPane.add(textBuscar);
		
		modeloITR=new DefaultComboBoxModel();
		RSComboBox comboBoxITR = new RSComboBox();
		comboBoxITR.setFont(new Font("Dialog", Font.BOLD, 12));
		comboBoxITR.setModel(modeloITR);
		comboBoxITR.setBounds(246, 82, 99, 33);
		contentPane.add(comboBoxITR);
		
		modeloArea=new DefaultComboBoxModel();
		RSComboBox comboBoxArea = new RSComboBox();
		comboBoxArea.setModel(modeloArea);
		comboBoxArea.setFont(new Font("Dialog", Font.BOLD, 12));
		comboBoxArea.setBounds(355, 82, 99, 33);
		contentPane.add(comboBoxArea);
		
		RSButtonHover btnhvrBuscar = new RSButtonHover();
		btnhvrBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				try {
					ArrayList<Tutor>tutoresFiltAsignados=new ArrayList<>();
					ArrayList<Tutor>tutoresFiltNoAsignados=new ArrayList<>();

					if(comboBoxITR.getSelectedItem().toString()=="") {
						tutoresFiltAsignados= asignados;
						tutoresFiltNoAsignados=noAsignados;
					}else {
						for(Tutor t: asignados) {
							if(t.getItr().getNombre().equalsIgnoreCase(comboBoxITR.getSelectedItem().toString())) {
								tutoresFiltAsignados.add(t);
							}
						}
						for(Tutor t:noAsignados) {
							if(t.getItr().getNombre().equalsIgnoreCase(comboBoxITR.getSelectedItem().toString())) {
								tutoresFiltNoAsignados.add(t);
							}
						}
					}
					ArrayList<Tutor>tutoresFiltAsignados1=new ArrayList<>();
					ArrayList<Tutor>tutoresFiltNoAsignados1=new ArrayList<>();

					
					if(comboBoxArea.getSelectedItem().toString()=="") {
						tutoresFiltAsignados1=tutoresFiltAsignados;
						tutoresFiltNoAsignados1=tutoresFiltNoAsignados;
					}else {
						for(Tutor t: tutoresFiltAsignados) {
							if(t.getAreaTutor().getNombre().equalsIgnoreCase(comboBoxArea.getSelectedItem().toString())) {
								tutoresFiltAsignados1.add(t);
							}
						}
						for(Tutor t: tutoresFiltNoAsignados) {
							if(t.getAreaTutor().getNombre().equalsIgnoreCase(comboBoxArea.getSelectedItem().toString())) {
								tutoresFiltNoAsignados1.add(t);
							}
						}
					}
					
					ArrayList<Tutor>tutoresFiltAsigandos2=new ArrayList<>();
					ArrayList<Tutor>tutoresFiltNoAsigandos2=new ArrayList<>();

					if(textBuscar.getText()=="") {
						tutoresFiltAsigandos2=tutoresFiltAsignados1;
						tutoresFiltNoAsigandos2=tutoresFiltNoAsignados1;
					}else {
						for(Tutor es:tutoresFiltAsignados1) {
							String nombre=es.getNombre1()+ " "+ es.getApellido1();
							nombre=nombre.toLowerCase();
							String cedula=es.getDocumento()+"";
							if(nombre.startsWith(textBuscar.getText().toLowerCase()) || cedula.startsWith(textBuscar.getText()) ) {
								tutoresFiltAsigandos2.add(es);
							}
						}
						for(Tutor es:tutoresFiltNoAsignados1) {
							String nombre=es.getNombre1()+ " "+ es.getApellido1();
							nombre=nombre.toLowerCase();
							String cedula=es.getDocumento()+"";
							if(nombre.startsWith(textBuscar.getText().toLowerCase()) || cedula.startsWith(textBuscar.getText()) ) {
								tutoresFiltNoAsigandos2.add(es);
							}
						}
					}				
					cargarTablaAsignado(tutoresFiltAsigandos2);
					cargarTablaNoAsignado(tutoresFiltNoAsigandos2);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrBuscar.setSelectedIcon(new ImageIcon(FrameAsignarTutores.class.getResource("/necesario/ver2.png")));
		btnhvrBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnhvrBuscar.setBackground(new Color(0, 112, 192));
		btnhvrBuscar.setBounds(464, 81, 35, 33);
		contentPane.add(btnhvrBuscar);
		
		JLabel lblItr = new JLabel("ITR");
		lblItr.setHorizontalAlignment(SwingConstants.LEFT);
		lblItr.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblItr.setBounds(246, 57, 71, 14);
		contentPane.add(lblItr);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setHorizontalAlignment(SwingConstants.LEFT);
		lblArea.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblArea.setBounds(355, 58, 71, 14);
		contentPane.add(lblArea);
		
		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscador.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblBuscador.setBounds(10, 57, 71, 14);
		contentPane.add(lblBuscador);
		
		try{
			cargarComboBox();
			cargarListas();
			cargarTablaAsignado(asignados);
			cargarTablaNoAsignado(noAsignados);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void cargarComboBox() throws ServicesException {
		modeloITR.removeAllElements();
		modeloITR.addElement("");
		for(ITR itr:DAOGeneral.itrRemote.obtenerItrs()) {
			if(itr.getActivo()){
				modeloITR.addElement(itr.getNombre());
			}
		}
		
		modeloArea.removeAllElements();
		modeloArea.addElement("");
		for(AreaTutor t:DAOGeneral.areaTutorRemote.obtenerAreaTutor()) {
			modeloArea.addElement(t.getNombre());
		}
	}
	
	
	public void cargarTablaAsignado(List<Tutor> tutores) throws ServicesException {
		modeloAsignados.setRowCount(0);
		for (Tutor e : tutores) {
			if(e.getActivo()) {
				Vector v = new Vector();
				v.addElement(e.getNombre1() + " " + e.getApellido1());
				v.addElement(e.getDocumento());
				v.addElement(e.getItr().getNombre());
				v.addElement(e.getAreaTutor().getNombre());
				v.addElement(e.getId());
				modeloAsignados.addRow(v);
			}	
		}
	}

	public void cargarTablaNoAsignado(List<Tutor> tutores) throws ServicesException {
		modeloNoAsignados.setRowCount(0);
		for (Tutor e : tutores) {
			if(e.getActivo()) {
				Vector v = new Vector();
				v.addElement(e.getNombre1() + " " + e.getApellido1());
				v.addElement(e.getDocumento());
				v.addElement(e.getItr().getNombre());
				v.addElement(e.getAreaTutor().getNombre());
				v.addElement(e.getId());
				modeloNoAsignados.addRow(v);
			}			
		}
	}
	
	
	public void cargarListas() throws ServicesException {
		if( asignados!=null && asignados.size()>0) {
			noAsignados=new ArrayList<>();
			for(Tutor t:DAOGeneral.tutorRemote.obtenerTutor()) {
				boolean flag=false;
				for(Tutor j:asignados) {
					if(t.getId()==j.getId()) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					noAsignados.add(t);
				}
			}	
		}else {
			asignados=new ArrayList<>();
			noAsignados=(ArrayList<Tutor>) DAOGeneral.tutorRemote.obtenerTutor();
		}
		
	}
	
	
	public Tutor buscarTutor(Tutor target,ArrayList<Tutor> tutores) {
		for(Tutor t:tutores) {
			if(t.getId()==target.getId()) {
				return t;
			}
		}
		return null;
		
	}
	
	
	public void agregarTutor() throws ServicesException {
		Tutor tutorTabla = (Tutor) DAOGeneral.usuarioRemote
				.buscarUsuarioPorId((Long) modeloNoAsignados.getValueAt(tableNoAsignados.getSelectedRow(), 4));
		Tutor tutorLista = buscarTutor(tutorTabla,noAsignados);
		noAsignados.remove(tutorLista);
		asignados.add(tutorLista);

		cargarTablaAsignado(asignados);
		cargarTablaNoAsignado(noAsignados);
	}
	
	
	public void quitarTutor() throws ServicesException {
		Tutor tutorTabla = (Tutor) DAOGeneral.usuarioRemote
				.buscarUsuarioPorId((Long) modeloAsignados.getValueAt(tableAsignados.getSelectedRow(), 4));
		Tutor tutorLista = buscarTutor(tutorTabla,asignados);
		asignados.remove(tutorLista);
		noAsignados.add(tutorLista);

		cargarTablaAsignado(asignados);
		cargarTablaNoAsignado(noAsignados);
	}
}
