package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controlador.DAOGeneral;
import com.entities.EstadosEventos;
import com.entities.ModalidadesEventos;

import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;

public class FrameAgregarEstadoEvento extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarEstadoEvento frame = new FrameAgregarEstadoEvento();
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
	public FrameAgregarEstadoEvento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAgregarEstadoEvento.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Agregar Estado de Evento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 325, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloVentana = new JLabel("AGREGAR ESTADO");
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblTituloVentana.setBounds(61, 18, 187, 25);
		contentPane.add(lblTituloVentana);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(FrameAgregarEstadoEvento.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(264, 10, 37, 38);
		contentPane.add(labelImage);
		
		RSTextFieldIconUno textNombre = new RSTextFieldIconUno();
		textNombre.setBorderColor(new Color(52, 152, 219));
		textNombre.setIcons(ICONS.BUSINESS);
		textNombre.setPlaceholder("Ingresar Nombre");
		textNombre.setBounds(10, 76, 291, 36);
		contentPane.add(textNombre);
		
		JLabel lblIngresarNombre = new JLabel("Nombre");
		lblIngresarNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblIngresarNombre.setBounds(10, 60, 85, 13);
		contentPane.add(lblIngresarNombre);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(10, 152, 98, 30);
		contentPane.add(btnhvrCancelar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(textNombre.getText()=="") {
						throw new Exception("Debe indicar un nombre de Estado");
					}
					
					if(DAOGeneral.estadosEventoRemote.buscarNombreEstadoEvento(textNombre.getText())!=null) {
						throw new Exception("El Estado espesificado ya esta registrado en el sistema");
					}
					int input = JOptionPane.showConfirmDialog(getParent(), "Estas seguro de crear el Estado", "Guardado...",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(input==0) {
						EstadosEventos ev=new EstadosEventos();
						ev.setActivo(true);
						ev.setNombre(textNombre.getText());
						DAOGeneral.estadosEventoRemote.crearEstadoEvento(ev);;
						JOptionPane.showMessageDialog(null, "Se creo correctamente el Estado.", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						MantenimientoEstadosEvento mod=MantenimientoEstadosEvento.getInstancia();
						mod.cargarTabla(mod.filtrarEstadoActivo(DAOGeneral.estadosEventoRemote.obtenerEstadosEventos()));
						mod.comboBoxModalidades.setSelectedIndex(0);
						PanelGestionDeEventos.getInstancia().cargarCombo();
						setVisible(false);
					}
					
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(201, 152, 98, 30);
		contentPane.add(btnhvrGuardar);
	}
	

}
