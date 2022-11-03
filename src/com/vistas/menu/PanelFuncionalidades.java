package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.Funcionalidad;
import com.exception.ServicesException;

import org.jgroups.tests.TestToaOrder;

import rojerusan.RSTableMetro;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import rojeru_san.rslabel.RSLabelImage;
import RSMaterialComponent.RSComboBoxMaterial;
import rojerusan.RSComboBox;
import RSMaterialComponent.RSTextFieldIconUno;
import RSMaterialComponent.RSTextFieldIconDos;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.complementos.RSButtonHover;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelFuncionalidades extends JPanel {
	private DefaultComboBoxModel modeloCombo;
	private DefaultTableModel modeloTabla;
	/**
	 * Create the panel.
	 */
	public PanelFuncionalidades() {
		setLayout(null);
		setBounds(0, 0, 700, 725);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 135, 666, 579);
		add(scrollPane);
		modeloTabla=new DefaultTableModel(
				new Object[][] {
						{ null, null },
						},
				new String[] { "Nombre","Descripcion" });
		
		RSTableMetro tableMetro = new RSTableMetro();
		tableMetro.setModel(modeloTabla);
		scrollPane.setViewportView(tableMetro);
		
		JLabel lblNewLabel_2_1 = new JLabel("GESTION DE EVENTOS");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(236, 23, 227, 27);
		add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setBounds(636, 11, 51, 53);
		add(labelImage_1);
		
		RSTextFieldIconDos textBuscador = new RSTextFieldIconDos();
		textBuscador.setIcons(ICONS.TV);
		textBuscador.setBounds(21, 92, 386, 32);
		add(textBuscador);
		
		modeloCombo=new DefaultComboBoxModel();
		
		modeloCombo.addElement("Asignado");
		modeloCombo.addElement("No Asignado");
		RSComboBox comboBox = new RSComboBox();
		comboBox.setDisabledIdex("");
		
		comboBox.setModel(modeloCombo);
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					if(comboBox.getSelectedItem().toString()=="Asignado"){
						cargarTabla(funAsignada());
					}else if(comboBox.getSelectedItem().toString()=="No Asignado"){
						cargarTabla(funNoAsignada());
					}
					textBuscador.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(417, 91, 152, 32);
		add(comboBox);
		
		
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String buscar=textBuscador.getText();
					buscar=buscar.toLowerCase();
					
					
					if(comboBox.getSelectedItem().toString()=="Asignado"){
						List<Funcionalidad> fun;
						fun = funAsignada();
						List<Funcionalidad> funFiltrada=new ArrayList<>();
						for(Funcionalidad f:fun){
							if(f.getNombre().toLowerCase().startsWith(buscar)){
								funFiltrada.add(f);
							}
						}
						cargarTabla(funFiltrada);
					}else if(comboBox.getSelectedItem().toString()=="No Asignado"){
						List<Funcionalidad> fun;
						fun = funNoAsignada();
						List<Funcionalidad> funFiltrada=new ArrayList<>();
						for(Funcionalidad f:fun){
							if(f.getNombre().toLowerCase().startsWith(buscar)){
								funFiltrada.add(f);
							}
						}
						cargarTabla(funFiltrada);
					}
				} catch (ServicesException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(579, 91, 108, 33);
		add(btnhvrFiltrar);
		
		
		
		try {
			cargarTabla(funAsignada());
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	public void cargarTabla(List<Funcionalidad> fun){
		modeloTabla.setRowCount(0);
		for(Funcionalidad f: fun){
			Vector v=new Vector();
			v.addElement(f.getNombre());
			v.addElement(f.getDescripcion());
			modeloTabla.addRow(v);
		}
	}
	
	public List<Funcionalidad> funAsignada()throws ServicesException{
		List<Funcionalidad> fun= new ArrayList<>();
		for(Funcionalidad f:DAOGeneral.funcionalidadRemote.obtenerFuncionalidades()){
			for(Funcionalidad j:Menu.usuarioIngresado.getRol().getFuncionalidades()){
				if(f.getId()==j.getId()){
					fun.add(f);
				break;
				}
			}		
		}
		return fun;
	}
	public List<Funcionalidad> funNoAsignada() throws ServicesException{
		List<Funcionalidad>funNo=new ArrayList<>();
		for(Funcionalidad f:DAOGeneral.funcionalidadRemote.obtenerFuncionalidades()){
			Boolean flag=false;
			for(Funcionalidad j:Menu.usuarioIngresado.getRol().getFuncionalidades()){
				if(f.getId()==j.getId()){
					flag=true;
					break;
				}
			}
			if(!flag){
				funNo.add(f);
			}
		}
		return funNo;
	}
}
