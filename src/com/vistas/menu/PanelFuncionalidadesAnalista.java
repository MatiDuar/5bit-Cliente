package com.vistas.menu;

import javax.swing.JPanel;
import RSMaterialComponent.RSTextFieldIconDos;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojerusan.RSComboBox;
import rojeru_san.complementos.RSButtonHover;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSTableMetro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.exception.ServicesException;


import com.controlador.DAOGeneral;
import com.entities.Rol;



public class PanelFuncionalidadesAnalista extends JPanel {
	private DefaultTableModel modeloTabla;
	
	public PanelFuncionalidadesAnalista() {
		setLayout(null);
		
		RSTextFieldIconDos textBuscador = new RSTextFieldIconDos();
		textBuscador.setIcons(ICONS.TV);
		textBuscador.setBounds(10, 89, 548, 32);
		add(textBuscador);
		
		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String buscar=textBuscador.getText();
					buscar=buscar.toLowerCase();
					
					List<Rol> roles=DAOGeneral.rolBean.obtenerRoles();
					ArrayList<Rol> rolesFiltrado=new ArrayList<>();
					for(Rol r:roles){
						if(r.getNombre().toLowerCase().startsWith(buscar)){
							rolesFiltrado.add(r);
						}
					}
					cargarTabla(rolesFiltrado);
					
					
					
				} catch (Exception e1) {
						e1.printStackTrace();
				}
				
			}
		});
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(568, 88, 108, 33);
		add(btnhvrFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 666, 425);
		add(scrollPane);
		
		modeloTabla=new DefaultTableModel(
				new Object[][] {
						{ null, null },
						},
				new String[] { "Nombre","Descripcion" });
		RSTableMetro tableMetro = new RSTableMetro();
		scrollPane.setViewportView(tableMetro);
		
		tableMetro.setModel(modeloTabla);
		
		JLabel lblNewLabel_2_1 = new JLabel("ASIGNAR FUNCIONALIDADES");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(211, 23, 278, 27);
		add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelFuncionalidadesAnalista.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(625, 11, 51, 53);
		add(labelImage_1);
		
		JLabel lblNewLabel = new JLabel("Roles");
		lblNewLabel.setBounds(10, 67, 46, 14);
		add(lblNewLabel);
		
		RSButtonHover btnhvrAsignarFuncionalidad = new RSButtonHover();
		btnhvrAsignarFuncionalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAsignarFuncionalidad frameAsignarFuncionalidades  = new FrameAsignarFuncionalidad();
				frameAsignarFuncionalidades.setVisible(true);
			}
		});
		btnhvrAsignarFuncionalidad.setText("Asignar Funcionalidad");
		btnhvrAsignarFuncionalidad.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrAsignarFuncionalidad.setBackground(new Color(0, 112, 192));
		btnhvrAsignarFuncionalidad.setBounds(226, 571, 247, 33);
		add(btnhvrAsignarFuncionalidad);
		
		try {
			cargarTabla(null);
		} catch (ServicesException e) {
			e.printStackTrace();
		}

	}
	
	
	public void cargarTabla(List<Rol>roles) throws ServicesException{
		if(roles==null){
			roles=DAOGeneral.rolBean.obtenerRoles();
		}
		modeloTabla.setRowCount(0);
		for(Rol r:roles){
			Vector v=new Vector();
			v.addElement(r.getNombre());
			v.addElement(r.getDescripcion());
			modeloTabla.addRow(v);
		}
	}
}
