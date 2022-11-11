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
import com.entities.EstadosEventos;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.complementos.TableMetro;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;

public class MantenimientoEstadosEvento extends JFrame {

	private static MantenimientoEstadosEvento instancia=new MantenimientoEstadosEvento();
	private JPanel contentPane;
	private DefaultTableModel modeloModalidad;
	public RSComboBox comboBoxModalidades;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoEstadosEvento frame = new MantenimientoEstadosEvento();
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
	private MantenimientoEstadosEvento() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MantenimientoEstadosEvento.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Mantenimiento Lista de ITR");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("LISTADO DE MODALIDADES");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(100, 22, 145, 27);
		contentPane.add(lblNewLabel_2);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(MantenimientoEstadosEvento.class.getResource("/com/vistas/img/UTEC.png")));
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
		modeloModalidad = new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Nombre","Id" });
		tableMetro.setModel(modeloModalidad);
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
		btnhvrCerrar.setBackground(new Color(0, 112, 192));
		btnhvrCerrar.setBounds(26, 370, 108, 33);
		contentPane.add(btnhvrCerrar);

		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(254, 370, 108, 33);
		contentPane.add(btnhvrGuardar);

		

		RSButtonHover btnhvrModificarITR = new RSButtonHover();
		btnhvrModificarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameModificarEstadoEvento.estadoSeleccionado=DAOGeneral.estadosEventoRemote.buscarEstadoEventoPorId((long)modeloModalidad.getValueAt(tableMetro.getSelectedRow(), 1));
					FrameModificarEstadoEvento mod=new FrameModificarEstadoEvento();
					mod.setVisible(true);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnhvrModificarITR.setText("Modificar");
		btnhvrModificarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificarITR.setBackground(new Color(0, 112, 192));
		btnhvrModificarITR.setBounds(254, 212, 108, 33);
		contentPane.add(btnhvrModificarITR);

		RSButtonHover btnhvrAgregarITR = new RSButtonHover();
		btnhvrAgregarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameAgregarEstadoEvento agregarModalidad = new FrameAgregarEstadoEvento();
				agregarModalidad.setVisible(true);
			}
		});
		btnhvrAgregarITR.setText("Agregar");
		btnhvrAgregarITR.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrAgregarITR.setBackground(new Color(0, 112, 192));
		btnhvrAgregarITR.setBounds(254, 164, 108, 33);
		contentPane.add(btnhvrAgregarITR);

		

		comboBoxModalidades = new RSComboBox();
		comboBoxModalidades.setDisabledIdex("");
		comboBoxModalidades.setModel(new DefaultComboBoxModel(new String[] { "Activo","Inactivo", "Ambos" }));
		comboBoxModalidades.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					List<EstadosEventos> estadoFilt = new ArrayList<>();
					if (comboBoxModalidades.getSelectedItem().toString() == "Activo") {
						for (EstadosEventos es : DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()) {
							if (es.getActivo()) {
								estadoFilt.add(es);
							}
						}
					} else if (comboBoxModalidades.getSelectedItem().toString() == "Inactivo") {
						for (EstadosEventos es :DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()) {
							if (!es.getActivo()) {
								estadoFilt.add(es);
							}
						}
					}else {
						estadoFilt=DAOGeneral.estadosEventoRemote.obtenerEstadosEventos();
					}
					cargarTabla(estadoFilt);
				} catch (ServicesException e) {
					e.printStackTrace();
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
						throw new Exception("Debe seleccionar un Estado para poder eliminarlo.");
					}
					
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea elminiar el Estado seleccionado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(input==0) {
						
						EstadosEventos es=DAOGeneral.estadosEventoRemote.buscarEstadoEventoPorId((Long) modeloModalidad.getValueAt(tableMetro.getSelectedRow(), 1));
						
						
						if(!es.getActivo()) {
							throw new Exception("El Estado ya esta inhabilitado");
						}
						es.setActivo(false);
						DAOGeneral.estadosEventoRemote.modificarEstadoEvento(es);
						cargarTabla(filtrarEstadoActivo(DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()));
						JOptionPane.showMessageDialog(null, "Se realizo la baja logica del Estado seleccionado", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
//						PanelGestionUsuarios.getInstancia().cargarComboBox();
						PanelGestionDeEventos.getInstancia().cargarCombo();
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
		btnhvrEliminarITR_1.setBackground(new Color(0, 112, 192));
		btnhvrEliminarITR_1.setBounds(254, 308, 108, 33);
		contentPane.add(btnhvrEliminarITR_1);
		
		RSButtonHover btnhvrReactivarITR = new RSButtonHover();
		btnhvrReactivarITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(tableMetro.getSelectedRow()==-1) {
						throw new Exception("Debe seleccionar un Estado para poder activarlo.");
					}
					int input = JOptionPane.showConfirmDialog(getParent(), "Desea activar el Estado seleccionado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(input==0) {
						
						EstadosEventos est=DAOGeneral.estadosEventoRemote.buscarEstadoEventoPorId((Long) modeloModalidad.getValueAt(tableMetro.getSelectedRow(), 1));
						if(est.getActivo()) {
							throw new Exception("El estado seleccionado ya se encuentra activo");
						}
						est.setActivo(true);
						DAOGeneral.estadosEventoRemote.modificarEstadoEvento(est);
						
						cargarTabla(filtrarEstadoActivo(DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()));
						JOptionPane.showMessageDialog(null, "Se reactivo el Estado seleccionado", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						PanelGestionDeEventos.getInstancia().cargarCombo();
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
		btnhvrReactivarITR.setBackground(new Color(0, 112, 192));
		btnhvrReactivarITR.setBounds(254, 260, 108, 33);
		contentPane.add(btnhvrReactivarITR);
		
		try {
//			itrsActivos=(ArrayList<ITR>) DAOGeneral.itrRemote.obtenerItrs();
			cargarTabla(filtrarEstadoActivo(DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()));
			
		} catch (ServicesException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cargarTabla(List<EstadosEventos> estados) throws ServicesException {
		modeloModalidad.setRowCount(0);
		for (EstadosEventos e : estados) {
			Vector v1 = new Vector();
			v1.add(e.getNombre());
			v1.add(e.getId());
			modeloModalidad.addRow(v1);
		}
	}
	
	public static MantenimientoEstadosEvento getInstancia() {
		return instancia;
	}
	public static void reset() {
		instancia=new MantenimientoEstadosEvento();
	}
	
	public List<EstadosEventos> filtrarEstadoActivo(List<EstadosEventos> estados){
		ArrayList<EstadosEventos>estadosFilt=new ArrayList<>();
		for(EstadosEventos i:estados) {
			if(i.getActivo()) {
				estadosFilt.add(i);
			}
		}
		return estadosFilt;
	}
	
	public List<EstadosEventos> filtrarITRInactivo(List<EstadosEventos> estados){
		ArrayList<EstadosEventos>estadosFilt=new ArrayList<>();
		for(EstadosEventos i:estados) {
			if(!i.getActivo()) {
				estadosFilt.add(i);
			}
		}
		return estadosFilt;
	}
}
