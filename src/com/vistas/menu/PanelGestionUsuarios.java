package com.vistas.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.controlador.DAOGeneral;
import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;
import rojerusan.RSTableMetro;

public class PanelGestionUsuarios extends JPanel {

	private static PanelGestionUsuarios instancia = new PanelGestionUsuarios();

	DefaultTableModel modeloTablaMetro;
	
	
//	DefaultComboBoxModel modeloITR;
//	DefaultComboBoxModel modeloDep;
//	DefaultComboBoxModel modeloEstado;
//	DefaultComboBoxModel modeloTipoUsuario;

	/**
	 * Create the panel.
	 */
	private PanelGestionUsuarios() {
		setLayout(null);
		setSize(1000,1000);
		JLabel lblNewLabel_2 = new JLabel("GESTIÓN DE USUARIOS");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(251, 23, 222, 27);
		add(lblNewLabel_2);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(PanelGestionUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(639, 11, 51, 53);
		add(labelImage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(7, 156, 568, 522);
		add(scrollPane);

		RSTableMetro tableMetro = new RSTableMetro();
		tableMetro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMetro.setIntercellSpacing(new Dimension(0, 0));
		tableMetro.setForeground(Color.DARK_GRAY);
		tableMetro.setGridColor(Color.DARK_GRAY);
		tableMetro.setColorBorderRows(Color.DARK_GRAY);
		tableMetro.setColorBorderHead(Color.DARK_GRAY);
		tableMetro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		modeloTablaMetro = new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null }, },
				new String[] { "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula",
						"Fecha de Nacimiento", "Tel\u00E9fono", "Localidad", "Departamento", "Email Personal",
						"Email UTEC", "ITR", "Tipo Usuario", "Generaci\u00F3n Estudiante", "\u00C1rea Tutor",
						"Rol Tutor", "Estado" });

		tableMetro.setModel(modeloTablaMetro);
		tableMetro.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(0).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableMetro.getColumnModel().getColumn(1).setMinWidth(120);
		tableMetro.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(2).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableMetro.getColumnModel().getColumn(3).setMinWidth(120);
		tableMetro.getColumnModel().getColumn(4).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(5).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(5).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(6).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(7).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(8).setPreferredWidth(95);
		tableMetro.getColumnModel().getColumn(8).setMinWidth(95);
		tableMetro.getColumnModel().getColumn(9).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(9).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(10).setPreferredWidth(130);
		tableMetro.getColumnModel().getColumn(10).setMinWidth(130);
		tableMetro.getColumnModel().getColumn(11).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(12).setPreferredWidth(90);
		tableMetro.getColumnModel().getColumn(12).setMinWidth(90);
		tableMetro.getColumnModel().getColumn(13).setPreferredWidth(150);
		tableMetro.getColumnModel().getColumn(13).setMinWidth(150);
		tableMetro.getColumnModel().getColumn(14).setPreferredWidth(100);
		tableMetro.getColumnModel().getColumn(14).setMinWidth(100);
		tableMetro.getColumnModel().getColumn(15).setMinWidth(75);
		tableMetro.getColumnModel().getColumn(16).setPreferredWidth(80);
		tableMetro.getColumnModel().getColumn(16).setMinWidth(80);
		scrollPane.setViewportView(tableMetro);

		RSComboBox comboITR = new RSComboBox();
		comboITR.setBounds(7, 113, 121, 32);
		add(comboITR);

		JLabel lblNewLabel = new JLabel("ITR");
		lblNewLabel.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 96, 45, 13);
		add(lblNewLabel);

		RSComboBox comboEstado = new RSComboBox();
		comboEstado.setBounds(155, 113, 121, 32);
		add(comboEstado);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEstado.setBounds(158, 96, 45, 13);
		add(lblEstado);

		RSComboBox comboTipoUsuario = new RSComboBox();
		comboTipoUsuario.setBounds(303, 113, 121, 32);
		add(comboTipoUsuario);

		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Lato", Font.PLAIN, 11));
		lblTipoUsuario.setBounds(306, 96, 78, 13);
		add(lblTipoUsuario);

		RSButtonHover btnhvrFiltrar = new RSButtonHover();
		btnhvrFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnhvrFiltrar.setText("Filtrar");
		btnhvrFiltrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrFiltrar.setBackground(new Color(0, 112, 192));
		btnhvrFiltrar.setBounds(582, 113, 108, 33);
		add(btnhvrFiltrar);

		RSComboBox comboGeneracion = new RSComboBox();
		comboGeneracion.setBounds(451, 113, 121, 32);
		add(comboGeneracion);

		JLabel lblGeneracionEstudiante = new JLabel("Generación");
		lblGeneracionEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeneracionEstudiante.setFont(new Font("Lato", Font.PLAIN, 11));
		lblGeneracionEstudiante.setBounds(454, 96, 78, 13);
		add(lblGeneracionEstudiante);

		RSButtonHover btnhvrHabilitarUsuario = new RSButtonHover();
		btnhvrHabilitarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s[] = modeloTablaMetro.getValueAt(tableMetro.getSelectedRow(), 10).toString().split("@");
				try {
					Usuario usuarioHa = DAOGeneral.usuarioRemote.buscarNombre(s[0]);
					if(usuarioHa.getActivo()) {
						throw new Exception("Usuario ya esta habilitado");
					}else {
						usuarioHa.setActivo(true);
						DAOGeneral.usuarioRemote.modificarUsuario(usuarioHa);
						JOptionPane.showMessageDialog(null, "Se habilito correctamente el usuario", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						cargarDatosTabla();
					}
				}catch(Exception m) {
					JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrHabilitarUsuario.setText("Habilitar");
		btnhvrHabilitarUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrHabilitarUsuario.setBackground(new Color(0, 112, 192));
		btnhvrHabilitarUsuario.setBounds(585, 219, 108, 33);
		add(btnhvrHabilitarUsuario);

		RSButtonHover btnhvrEliminarUsuario = new RSButtonHover();
		btnhvrEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String s[] = modeloTablaMetro.getValueAt(tableMetro.getSelectedRow(), 10).toString().split("@");
				try {
					Usuario usuarioRm = DAOGeneral.usuarioRemote.buscarNombre(s[0]);
					usuarioRm.setActivo(false);
					DAOGeneral.usuarioRemote.modificarUsuario(usuarioRm);
					JOptionPane.showMessageDialog(null, "Se realizo una baja logica del usuario seleccionado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					cargarDatosTabla();
				} catch (Exception b) {
					b.printStackTrace();
				}

			}
		});
		btnhvrEliminarUsuario.setText("Eliminar");
		btnhvrEliminarUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrEliminarUsuario.setBackground(new Color(0, 112, 192));
		btnhvrEliminarUsuario.setBounds(585, 315, 108, 33);
		add(btnhvrEliminarUsuario);

		
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(585, 598, 108, 33);
		add(btnhvrGuardar);

		RSButtonHover btnhvrCerrar = new RSButtonHover();
		btnhvrCerrar.addMouseListener(new MouseAdapter() {

		});
		btnhvrCerrar.setText("Cerrar");
		btnhvrCerrar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCerrar.setBackground(new Color(0, 112, 192));
		btnhvrCerrar.setBounds(585, 646, 108, 33);
		add(btnhvrCerrar);

		RSButtonHover btnhvrMantenimientoListaItr = new RSButtonHover();
		btnhvrMantenimientoListaItr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MantenimientoListadoITR mantenerListaITR = new MantenimientoListadoITR();
				mantenerListaITR.setVisible(true);
			}
		});
		btnhvrMantenimientoListaItr.setText("Lista ITR");
		btnhvrMantenimientoListaItr.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrMantenimientoListaItr.setBackground(new Color(0, 112, 192));
		btnhvrMantenimientoListaItr.setBounds(585, 401, 108, 33);
		add(btnhvrMantenimientoListaItr);

		JLabel lblUsuarios = new JLabel("Acciones Usuarios");
		lblUsuarios.setFont(new Font("Lato", Font.BOLD, 11));
		lblUsuarios.setBounds(585, 198, 108, 13);
		add(lblUsuarios);

		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setFont(new Font("Lato", Font.BOLD, 11));
		lblMantenimiento.setBounds(585, 380, 108, 13);
		add(lblMantenimiento);

		RSButtonHover btnhvrModificarUsuario = new RSButtonHover();
		btnhvrModificarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s[] = modeloTablaMetro.getValueAt(tableMetro.getSelectedRow(), 10).toString().split("@");
				try {
					Usuario usuarioMod = DAOGeneral.usuarioRemote.buscarNombre(s[0]);
					PanelModificarDatosUsuarios.usuarioLogeado = usuarioMod;

					ModificarDatosUsuarios modificarDatosUsuario = ModificarDatosUsuarios.getInstancia();

					if (usuarioMod instanceof Estudiante) {
						modificarDatosUsuario.panelDatosUsuario.datosEstudiante();
					} else if (usuarioMod instanceof Tutor) {
						modificarDatosUsuario.panelDatosUsuario.datosTutor();
					} else if (usuarioMod instanceof Analista) {
						modificarDatosUsuario.panelDatosUsuario.datosAnalista();
					}
					modificarDatosUsuario.setVisible(true);

				} catch (ServicesException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnhvrModificarUsuario.setText("Modificar");
		btnhvrModificarUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificarUsuario.setBackground(new Color(0, 112, 192));
		btnhvrModificarUsuario.setBounds(585, 267, 108, 33);
		add(btnhvrModificarUsuario);

		try {
			cargarDatosTabla();
		} catch (ServicesException e1) {
			e1.printStackTrace();
		}
	}

	public void cargarDatosTabla() throws ServicesException {
//		"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "C\u00E9dula", 
//		"Fecha de Nacimiento", "Tel\u00E9fono", "Localidad", "Departamento", "Email Personal", "Email UTEC", "ITR", 
//		"Tipo Usuario", "Generaci\u00F3n Estudiante", "\u00C1rea Tutor", "Rol Tutor", "Estado"
		modeloTablaMetro.setRowCount(0);
		for (Usuario u : DAOGeneral.usuarioRemote.obtenerUsuarios()) {
//			if (u.getActivo()) {
				Vector v = new Vector<>();
				v.addElement(u.getNombre1());
				v.addElement(u.getNombre2());
				v.addElement(u.getApellido1());
				v.addElement(u.getApellido2());
				v.addElement(u.getDocumento());
				v.addElement(u.getFechaNacimiento());
				v.addElement(u.getTelefono());
				v.addElement(u.getLocalidad());
				v.addElement(u.getDepartamento().getNombre());
				v.addElement(u.getMail());
				v.addElement(u.getMailInstitucional());
				v.addElement(u.getItr().getNombre());
//			String s[]=u.getClass().getName().split(".");
//			v.addElement(s.toString());
				if (u instanceof Estudiante) {
					v.addElement("Estudiante");
					v.addElement(((Estudiante) u).getAnoIngreso());
					v.addElement("-");
					v.addElement("-");
				} else if (u instanceof Analista) {
					v.addElement("Analista");
					v.addElement("-");
					v.addElement("-");
					v.addElement("-");
				} else if (u instanceof Tutor) {
					v.addElement("Tutor");
					v.addElement("-");
					v.addElement(((Tutor) u).getAreaTutor().getNombre());
					v.addElement(((Tutor) u).getTipoTutor().getNombre());
				} else {
					v.addElement("-");
					v.addElement("-");
				}
				if (u.getActivo()) {
					v.addElement("Activo");
				} else {
					v.addElement("Inactivo");
				}
				modeloTablaMetro.addRow(v);
			}
//		}
	}

	public static PanelGestionUsuarios getInstancia() {
		return instancia;
	}
}
