package com.vistas.menu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class ModificarDatosUsuarios extends JFrame {

	public PanelModificarDatosUsuarios panelDatosUsuario = new PanelModificarDatosUsuarios();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuarios frame = new ModificarDatosUsuarios();
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
	public ModificarDatosUsuarios() {
		JPanel panelCargarDatosUsuario = new JPanel();
		panelCargarDatosUsuario.setLayout(null);
		add(panelCargarDatosUsuario);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarDatosUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Modificar datos de usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 546);

		
		panelCargarDatosUsuario.setBounds(0, 0, 666, 509);
		panelDatosUsuario.setBounds(0,0,666,509);
		panelDatosUsuario.datosAnalista();
		add(panelCargarDatosUsuario);
	
		panelCargarDatosUsuario.add(panelDatosUsuario);
		setLocationRelativeTo(null);
		
	}
}
