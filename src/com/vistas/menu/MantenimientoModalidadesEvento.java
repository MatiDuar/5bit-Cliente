package com.vistas.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.ITR;
import com.entities.ModalidadesEventos;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.complementos.TableMetro;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class MantenimientoModalidadesEvento extends JFrame {

	private static MantenimientoModalidadesEvento instancia=new MantenimientoModalidadesEvento();
	private JPanel contentPane;
	private DefaultTableModel modeloEstado;
	public RSComboBox comboBoxModalidades;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoModalidadesEvento frame = new MantenimientoModalidadesEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private MantenimientoModalidadesEvento() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MantenimientoModalidadesEvento.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Mantenimiento Lista de Modalidades");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("LISTADO DE MODALIDADES");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(53, 22, 279, 27);
		contentPane.add(lblNewLabel_2);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(MantenimientoModalidadesEvento.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(311, 10, 51, 53);
		contentPane.add(labelImage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.DARK_GRAY);
		scrollPane.setBounds(26, 79, 219, 272);
		contentPane.add(scrollPane);

		TableMetro tableMetro = new TableMetro();
		tableMetro.setColorFilasBackgound2(SystemColor.controlHighlight);
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setColorBordeHead(Color.DARK_GRAY);
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableMetro.setColorBordeFilas(Color.DARK_GRAY);
		tableMetro.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableMetro.setFuenteFilasSelect(new Font("Tahoma", Font.PLAIN, 14));
		tableMetro.setFuenteHead(new Font("Tahoma", Font.BOLD, 14));
		tableMetro.setFuenteFilas(new Font("Tahoma", Font.PLAIN, 14));
		tableMetro.setAltoHead(30);
		tableMetro.setColorBackgoundHead(new Color(52, 152, 219));
		modeloEstado = new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Nombre","Id" });
		tableMetro.setModel(modeloEstado);
		scrollPane.setViewportView(tableMetro);
		
		tableMetro.removeColumn(tableMetro.getColumnModel().getColumn(1));


		RSButtonHover btnhvrCerrar = new RSButtonHover();
		btnhvrCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				setVisible(false);
				reset();
			}
		});
		btnhvrCerrar.setText("Cerrar");
		btnhvrCerrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCerrar.setBackground(new Color(52, 152, 219));
		btnhvrCerrar.setBounds(131, 370, 123, 33);
		contentPane.add(btnhvrCerrar);

		

		RSButtonHover btnhvrModificarITR = new RSButtonHover();
		btnhvrModificarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(tableMetro.getSelectedRow()==-1) {
						throw new Exception("Debe selccionar una modalidad de evento para poder editarlo");
					}
					FrameModificarModalidad.modalidadSeleccionada=DAOGeneral.modalidadEventoRemote.buscarModalidadEventoPorId((Long) modeloEstado.getValueAt(tableMetro.getSelectedRow(), 1));
					FrameModificarModalidad mod=new FrameModificarModalidad();
					mod.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnhvrModificarITR.setText("Modificar");
		btnhvrModificarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificarITR.setBackground(new Color(52, 152, 219));
		btnhvrModificarITR.setBounds(254, 212, 108, 33);
		contentPane.add(btnhvrModificarITR);

		RSButtonHover btnhvrAgregarITR = new RSButtonHover();
		btnhvrAgregarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameAgregarModalidad agregarModalidad = new FrameAgregarModalidad();
				agregarModalidad.setVisible(true);
			}
		});
		btnhvrAgregarITR.setText("Agregar");
		btnhvrAgregarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrAgregarITR.setBackground(new Color(52, 152, 219));
		btnhvrAgregarITR.setBounds(254, 164, 108, 33);
		contentPane.add(btnhvrAgregarITR);

		

		comboBoxModalidades = new RSComboBox();
		comboBoxModalidades.setColorBoton(Color.WHITE);
		comboBoxModalidades.setColorFondo(new Color(52, 152, 219));
		comboBoxModalidades.setDisabledIdex("");
		comboBoxModalidades.setModel(new DefaultComboBoxModel(new String[] { "Activo","Inactivo", "Ambos" }));
		comboBoxModalidades.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					List<ModalidadesEventos> modalidadFilt = new ArrayList<>();
					if (comboBoxModalidades.getSelectedItem().toString() == "Activo") {
						for (ModalidadesEventos mod : DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()) {
							if (mod.getActivo()) {
								modalidadFilt.add(mod);
							}
						}
					} else if (comboBoxModalidades.getSelectedItem().toString() == "Inactivo") {
						for (ModalidadesEventos mod :DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()) {
							if (!mod.getActivo()) {
								modalidadFilt.add(mod);
							}
						}
					}else {
						modalidadFilt=DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos();
					}
					cargarTabla(modalidadFilt);
				} catch (ServicesException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		comboBoxModalidades.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxModalidades.setBounds(254, 98, 108, 32);
		contentPane.add(comboBoxModalidades);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEstado.setBounds(254, 79, 45, 13);
		contentPane.add(lblEstado);

		setLocationRelativeTo(null);
		RSButtonHover btnhvrEliminarITR_1 = new RSButtonHover();
		btnhvrEliminarITR_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(tableMetro.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar una Modalidad para poder eliminarla.");
					}
					
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea elminiar la Modalidad seleccionada", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(input==0) {
						ModalidadesEventos mod=DAOGeneral.modalidadEventoRemote.buscarModalidadEventoPorId((Long) modeloEstado.getValueAt(tableMetro.getSelectedRow(), 1));
						if(!mod.getActivo()) {
							throw new Exception("La modalidad ya esta inhabilitada");
						}
						mod.setActivo(false);
						DAOGeneral.modalidadEventoRemote.modificarModalidadEvento(mod);
						cargarTabla(filtrarITRActivo(DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()));
						JOptionPane.showMessageDialog(null, "Se realizo la baja logica de la Modalidad seleccionada", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						comboBoxModalidades.setSelectedIndex(0);
					}
					 				 
					
				
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnhvrEliminarITR_1.setText("Desactivar");
		btnhvrEliminarITR_1.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrEliminarITR_1.setBackground(new Color(52, 152, 219));
		btnhvrEliminarITR_1.setBounds(254, 308, 108, 33);
		contentPane.add(btnhvrEliminarITR_1);
		
		RSButtonHover btnhvrReactivarITR = new RSButtonHover();
		btnhvrReactivarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(tableMetro.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar una Modalidad para poder activarla.");
					}
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea activar la Modalidad seleccionada", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(input==0) {
						
						ModalidadesEventos mod=DAOGeneral.modalidadEventoRemote.buscarModalidadEventoPorId((Long) modeloEstado.getValueAt(tableMetro.getSelectedRow(), 1));
						if(mod.getActivo()) {
							throw new Exception("La modalidad seleccionada ya se encuentra activa");
						}
						mod.setActivo(true);
						DAOGeneral.modalidadEventoRemote.modificarModalidadEvento(mod);
						cargarTabla(filtrarITRActivo(DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()));
						JOptionPane.showMessageDialog(null, "Se reactivo la Modalidad seleccionada", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						PanelGestionUsuarios.getInstancia().cargarComboBox();
						comboBoxModalidades.setSelectedIndex(0);
					}
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});
		btnhvrReactivarITR.setText("Reactivar");
		btnhvrReactivarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrReactivarITR.setBackground(new Color(52, 152, 219));
		btnhvrReactivarITR.setBounds(254, 260, 108, 33);
		contentPane.add(btnhvrReactivarITR);
		
		try {
			cargarTabla(filtrarITRActivo(DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()));
			
		} catch (ServicesException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cargarTabla(List<ModalidadesEventos> modalidades) throws ServicesException {
		modeloEstado.setRowCount(0);
		for (ModalidadesEventos e : modalidades) {
			Vector v1 = new Vector();
			v1.add(e.getNombre());
			v1.add(e.getId());
			modeloEstado.addRow(v1);
		}
	}
	
	public static MantenimientoModalidadesEvento getInstancia() {
		return instancia;
	}
	public static void reset() {
		instancia=new MantenimientoModalidadesEvento();
	}
	
	public List<ModalidadesEventos> filtrarITRActivo(List<ModalidadesEventos> modalidades){
		ArrayList<ModalidadesEventos>modalidadFilt=new ArrayList<>();
		for(ModalidadesEventos i:modalidades) {
			if(i.getActivo()) {
				modalidadFilt.add(i);
			}
		}
		return modalidadFilt;
	}
	
	public List<ModalidadesEventos> filtrarITRInactivo(List<ModalidadesEventos> modalidades){
		ArrayList<ModalidadesEventos>modalidadFilt=new ArrayList<>();
		for(ModalidadesEventos i:modalidades) {
			if(!i.getActivo()) {
				modalidadFilt.add(i);
			}
		}
		return modalidadFilt;
	}
}
