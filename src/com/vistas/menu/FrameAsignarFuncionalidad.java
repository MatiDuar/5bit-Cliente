package com.vistas.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controlador.DAOGeneral;
import com.controlador.DAOGenero;
import com.entities.Funcionalidad;
import com.entities.Rol;
import com.exception.ServicesException;

import javax.swing.JScrollPane;
import rojerusan.RSTableMetro;
import javax.swing.JLabel;
import rojeru_san.rsbutton.RSButtonCircleIcon;
import rojeru_san.rsbutton.RSButtonMetro;
import RSMaterialComponent.RSButtonIconUno;
import rojeru_san.efectos.ValoresEnum.ICONS;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import rojeru_san.complementos.RSButtonHover;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


public class FrameAsignarFuncionalidad extends JFrame {

	private JPanel contentPane;
	public static Rol rolSeleccionado;
	private DefaultTableModel modeloAsignado;
	private DefaultTableModel modeloNoAsignada;
	
	
	List<Funcionalidad> asignadas=new ArrayList<>();
	List<Funcionalidad> noAsignadas=new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAsignarFuncionalidad frame = new FrameAsignarFuncionalidad();
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
	public FrameAsignarFuncionalidad() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 525, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 201, 284);
		contentPane.add(scrollPane);
		modeloAsignado=new DefaultTableModel(
				new Object[][] {
						{ null },
						},
				new String[] { "Nombre"});
		RSTableMetro tableFunAsignadas = new RSTableMetro();
		tableFunAsignadas.setModel(modeloAsignado);
		scrollPane.setViewportView(tableFunAsignadas);
		
		JLabel lblNewLabel = new JLabel("Funcionalidades Asignadas");
		lblNewLabel.setBounds(22, 59, 165, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFuncionalidadesNoAsignadas = new JLabel("Funcionalidades No Asignadas");
		lblFuncionalidadesNoAsignadas.setBounds(310, 59, 180, 14);
		contentPane.add(lblFuncionalidadesNoAsignadas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(298, 84, 201, 284);
		contentPane.add(scrollPane_1);
		
		RSTableMetro tableFunNoAsignadas = new RSTableMetro();
		modeloNoAsignada=new DefaultTableModel(
				new Object[][] {
						{ null },
						},
				new String[] { "Nombre"});
		tableFunNoAsignadas.setModel(modeloNoAsignada);
		scrollPane_1.setViewportView(tableFunNoAsignadas);
		
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("ELEGIR FUNCIONALIDAD");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(136, 11, 237, 27);
		contentPane.add(lblNewLabel_2_1);
		
		RSButtonHover btnGuardar = new RSButtonHover();
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rolSeleccionado.setFuncionalidades(asignadas);
				try {
					DAOGeneral.rolBean.modificarRol(rolSeleccionado);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnGuardar.setBackground(new Color(0, 112, 192));
		btnGuardar.setBounds(198, 384, 108, 33);
		contentPane.add(btnGuardar);
		
		
		RSButtonIconUno btnAgregarFun = new RSButtonIconUno();
		btnAgregarFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionalidad f=buscarNombre(noAsignadas, modeloNoAsignada.getValueAt(tableFunNoAsignadas.getSelectedRow(), 0).toString());
				asignadas.add(f);
				noAsignadas.remove(f);
				
				cargarTablaAsignado(asignadas);
				cargarTablaNoAsignado(noAsignadas);
			}
		});
		btnAgregarFun.setIcons(ICONS.ARROW_BACK);
		btnAgregarFun.setBounds(234, 109, 40, 40);
		contentPane.add(btnAgregarFun);
		
		RSButtonIconUno btnSacarFun = new RSButtonIconUno();
		btnSacarFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionalidad f=buscarNombre(asignadas, modeloAsignado.getValueAt(tableFunAsignadas.getSelectedRow(), 0).toString());
				noAsignadas.add(f);
				asignadas.remove(f);
				
				cargarTablaAsignado(asignadas);
				cargarTablaNoAsignado(noAsignadas);
			}
		});
		btnSacarFun.setIcons(ICONS.ARROW_FORWARD);
		btnSacarFun.setBounds(234, 282, 40, 40);
		contentPane.add(btnSacarFun);
		
		try{
			cargarTablaAsignado(obtenerAsignado());
			cargarTablaNoAsignado(obtenerNoAsignada());
			
			
			asignadas=obtenerAsignado();
			noAsignadas=obtenerNoAsignada();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public List<Funcionalidad> obtenerAsignado(){
		ArrayList<Funcionalidad>asignadas=new ArrayList<>();
		for(Funcionalidad f:rolSeleccionado.getFuncionalidades()){
			asignadas.add(f);
		}
		return asignadas;
	}
	
	public List<Funcionalidad> obtenerNoAsignada() throws ServicesException{
		ArrayList<Funcionalidad>noAsignadas=new ArrayList<>();
		for(Funcionalidad f:DAOGeneral.funcionalidadRemote.obtenerFuncionalidades()){
			Boolean flag=false;
			for(Funcionalidad j:DAOGeneral.rolBean.buscarNombre(rolSeleccionado.getNombre()).getFuncionalidades()){
				if(f.getId()==j.getId()){
					flag=true;
				}
			}
			if(!flag){
				noAsignadas.add(f);
			}
		}
		return noAsignadas;
	}
	
	
	
	public void cargarTablaAsignado(List<Funcionalidad>fun){
		modeloAsignado.setRowCount(0);
		for(Funcionalidad f:fun){
			Vector v=new Vector();
			v.addElement(f.getNombre());
			modeloAsignado.addRow(v);
		}
	}
	
	
	public void cargarTablaNoAsignado(List<Funcionalidad>fun){
		modeloNoAsignada.setRowCount(0);
		for(Funcionalidad f:fun){
			Vector v=new Vector();
			v.addElement(f.getNombre());
			modeloNoAsignada.addRow(v);
		}
	}
	
	public Funcionalidad buscarNombre(List<Funcionalidad>fun,String buscar){
		for(Funcionalidad f:fun){
			if(f.getNombre().equalsIgnoreCase(buscar)){
				return f;
			}
		}
		return null;
	}
	
}
