package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controlador.DAOGeneral;
import com.entities.ModalidadesEventos;

import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;

public class FrameModificarModalidad extends JFrame {

	private JPanel contentPane;
	public static ModalidadesEventos modalidadSeleccionada;
	private RSTextFieldIconUno textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModificarModalidad frame = new FrameModificarModalidad();
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
	public FrameModificarModalidad() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrameModificarModalidad.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Modificar Modalidad de Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 325, 233);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTituloVentana = new JLabel("MODIFICAR MODALIDAD");
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblTituloVentana.setBounds(61, 18, 187, 25);
		contentPane.add(lblTituloVentana);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(FrameModificarModalidad.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(264, 10, 37, 38);
		contentPane.add(labelImage);

		textNombre = new RSTextFieldIconUno();
		textNombre.setBorderColor(new Color(52, 152, 219));
		textNombre.setIcons(ICONS.BUSINESS);
		textNombre.setPlaceholder("Ingresar Nombre");
		textNombre.setBounds(10, 76, 291, 36);
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// el 10 es codigo para el Enter
				if (e.getKeyCode() == 10) {
					try {
						guardarModalidad();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		textNombre.setText(modalidadSeleccionada.getNombre());
		contentPane.add(textNombre);

		JLabel lblIngresarNombre = new JLabel("Nombre");
		lblIngresarNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblIngresarNombre.setBounds(10, 60, 85, 13);
		contentPane.add(lblIngresarNombre);

		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(getParent(),
						"Desea cancelar la modificacion modalidad seleccionado"
						+"\nLos datos no seran guardados", "Guardado...", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);

				if (input == 0) {
					textNombre.setText("");
					setVisible(false);
				}
			}
		});
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
					guardarModalidad();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(201, 152, 98, 30);
		contentPane.add(btnhvrGuardar);
	}

	public void guardarModalidad() throws Exception {

		if (textNombre.getText().length() < 1) {
			throw new Exception("Debe indicar un nombre de Modalidad");
		}
		if (textNombre.getText().contains(" ")) {
			throw new Exception("La modalidad no puede contener espacios");
		}
		if(textNombre.getText().length()>50) {
			throw new Exception("El nombre de la modalidad no puede contener mas de 50 caracteres");
		}
		if (DAOGeneral.modalidadEventoRemote.buscarNombreModalidadEvento(textNombre.getText()) != null
				&& DAOGeneral.modalidadEventoRemote.buscarNombreModalidadEvento(textNombre.getText())
						.getId() != modalidadSeleccionada.getId()) {
			throw new Exception("La Modalidad especificada ya esta registrada en el sistema");
		}
		int input = JOptionPane.showConfirmDialog(getParent(), "Estas seguro de Modificar la Modalidad seleccionada",
				"Guardado...", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (input == 0) {
			modalidadSeleccionada.setNombre(textNombre.getText());
			DAOGeneral.modalidadEventoRemote.modificarModalidadEvento(modalidadSeleccionada);
			JOptionPane.showMessageDialog(null, "Se Modifico correctamente la Modalidad seleccionada.", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			MantenimientoModalidadesEvento mod = MantenimientoModalidadesEvento.getInstancia();
			mod.cargarTabla(mod.filtrarITRActivo(DAOGeneral.modalidadEventoRemote.obtenerModalidadesEventos()));
			mod.comboBoxModalidades.setSelectedIndex(0);
			PanelGestionDeEventos.getInstancia().cargarCombo();
			setVisible(false);
		}
	}
}
