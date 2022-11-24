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
import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.ITR;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.complementos.TableMetro;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class MantenimientoListadoITR extends JFrame {

	private static MantenimientoListadoITR instancia=new MantenimientoListadoITR();
	private JPanel contentPane;
	private DefaultTableModel modeloItr;
	public RSComboBox comboBoxEstadoITR;
	
	
	public static ArrayList<ITR>itrsActivos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoListadoITR frame = new MantenimientoListadoITR();
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
	private MantenimientoListadoITR() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MantenimientoListadoITR.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Mantenimiento Lista de ITR");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("LISTADO DE ITRs");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(121, 22, 180, 27);
		contentPane.add(lblNewLabel_2);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(MantenimientoListadoITR.class.getResource("/com/vistas/img/UTEC.png")));
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
		modeloItr = new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Nombre" });
		tableMetro.setModel(modeloItr);
		scrollPane.setViewportView(tableMetro);

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
		btnhvrCerrar.setBounds(130, 370, 126, 33);
		contentPane.add(btnhvrCerrar);

		

		RSButtonHover btnhvrModificarITR = new RSButtonHover();
		btnhvrModificarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(tableMetro.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar un ITR para poder modificarlo");
					}
					ITR itr=DAOGeneral.itrRemote.obtenerItrPorNombre(modeloItr.getValueAt(tableMetro.getSelectedRow(), 0).toString());
					FrameModificarITR.itr=itr;
					FrameModificarITR modificarITR = new FrameModificarITR();
					modificarITR.setVisible(true);
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
				FrameAgregarITR agregarITR = new FrameAgregarITR();
				agregarITR.setVisible(true);
			}
		});
		btnhvrAgregarITR.setText("Agregar");
		btnhvrAgregarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrAgregarITR.setBackground(new Color(52, 152, 219));
		btnhvrAgregarITR.setBounds(254, 164, 108, 33);
		contentPane.add(btnhvrAgregarITR);

		

		comboBoxEstadoITR = new RSComboBox();
		comboBoxEstadoITR.setColorBoton(Color.WHITE);
		comboBoxEstadoITR.setColorFondo(new Color(52, 152, 219));
		comboBoxEstadoITR.setDisabledIdex("");
		comboBoxEstadoITR.setModel(new DefaultComboBoxModel(new String[] { "Activo","Inactivo", "Ambos" }));
		comboBoxEstadoITR.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					List<ITR> itrsFil = new ArrayList<>();
					if (comboBoxEstadoITR.getSelectedItem().toString() == "Activo") {
						for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
							if (itr.getActivo()) {
								itrsFil.add(itr);
							}
						}
					} else if (comboBoxEstadoITR.getSelectedItem().toString() == "Inactivo") {
						for (ITR itr : DAOGeneral.itrRemote.obtenerItrs()) {
							if (!itr.getActivo()) {
								itrsFil.add(itr);
							}
						}
					}else {
						itrsFil=DAOGeneral.itrRemote.obtenerItrs();
					}
					cargarTabla(itrsFil);
				} catch (ServicesException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);				}
			}
		});
		comboBoxEstadoITR.setFont(new Font("Lato", Font.BOLD, 14));
		comboBoxEstadoITR.setBounds(254, 98, 108, 32);
		contentPane.add(comboBoxEstadoITR);

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
						throw new Exception("Debe seleccionar un ITR para poder eliminarlo.");
					}
					
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea elminiar el ITR seleccionado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(input==0) {
						ITR itr=DAOGeneral.itrRemote.obtenerItrPorNombre(modeloItr.getValueAt(tableMetro.getSelectedRow(), 0).toString());
						if(!itr.getActivo()) {
							throw new Exception("El ITR ya esta inhabilitado");
						}
						itr.setActivo(false);
						DAOGeneral.itrRemote.actualizarITR(itr);
						cargarTabla(filtrarITRActivo(DAOGeneral.itrRemote.obtenerItrs()));
						JOptionPane.showMessageDialog(null, "Se realizo la baja logica del itr seleccionado", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						PanelGestionUsuarios.getInstancia().cargarComboBox();
						comboBoxEstadoITR.setSelectedIndex(0);
					}
					 				 
					
				
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnhvrEliminarITR_1.setText("Eliminar");
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
						throw new Exception("Debe seleccionar un ITR para poder activarlo.");
					}
					
					if(DAOGeneral.itrRemote.obtenerItrPorNombre(modeloItr.getValueAt(tableMetro.getSelectedRow(), 0).toString()).getActivo()) {
						throw new Exception("El ITR selccionado ya se encuentra activo");
					}
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea activar el ITR seleccionado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(input==0) {
						ITR itr=DAOGeneral.itrRemote.obtenerItrPorNombre(modeloItr.getValueAt(tableMetro.getSelectedRow(), 0).toString());
						itr.setActivo(true);
						DAOGeneral.itrRemote.actualizarITR(itr);
						cargarTabla(filtrarITRActivo(DAOGeneral.itrRemote.obtenerItrs()));
						JOptionPane.showMessageDialog(null, "Se reactivo el itr seleccionado", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						PanelGestionUsuarios.getInstancia().cargarComboBox();
						comboBoxEstadoITR.setSelectedIndex(0);
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
//			itrsActivos=(ArrayList<ITR>) DAOGeneral.itrRemote.obtenerItrs();
			cargarTabla(filtrarITRActivo(DAOGeneral.itrRemote.obtenerItrs()));
			
		} catch (ServicesException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cargarTabla(List<ITR> itrs) throws ServicesException {
		modeloItr.setRowCount(0);
		for (ITR itr : itrs) {
			Vector v1 = new Vector();
			v1.add(itr.getNombre());
			modeloItr.addRow(v1);
		}
	}
	
	public static MantenimientoListadoITR getInstancia() {
		return instancia;
	}
	public static void reset() {
		instancia=new MantenimientoListadoITR();
	}
	
	public List<ITR> filtrarITRActivo(List<ITR> itrs){
		ArrayList<ITR>itrsFilt=new ArrayList<>();
		for(ITR i:itrs) {
			if(i.getActivo()) {
				itrsFilt.add(i);
			}
		}
		return itrsFilt;
	}
	
	public List<ITR> filtrarITRInactivo(List<ITR> itrs){
		ArrayList<ITR>itrsFilt=new ArrayList<>();
		for(ITR i:itrs) {
			if(!i.getActivo()) {
				itrsFilt.add(i);
			}
		}
		return itrsFilt;
	}
}
