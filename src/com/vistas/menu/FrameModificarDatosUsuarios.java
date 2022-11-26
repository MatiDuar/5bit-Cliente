package com.vistas.menu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class FrameModificarDatosUsuarios extends JFrame {

	private static FrameModificarDatosUsuarios instancia=new FrameModificarDatosUsuarios();
	
	public PanelModificarDatosUsuarios panelDatosUsuario = new PanelModificarDatosUsuarios();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModificarDatosUsuarios frame = new FrameModificarDatosUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private FrameModificarDatosUsuarios() {
		JPanel panelCargarDatosUsuario = new JPanel();
		panelCargarDatosUsuario.setLayout(null);
		add(panelCargarDatosUsuario);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameModificarDatosUsuarios.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Modificar datos de usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 680, 600);

		
		panelCargarDatosUsuario.setBounds(0, 0, 666, 509);
		panelDatosUsuario.setBounds(0,0,666,600);
		panelDatosUsuario.datosAnalista();
		add(panelCargarDatosUsuario);
	
		panelCargarDatosUsuario.add(panelDatosUsuario);
		setLocationRelativeTo(null);
		
	}
	
	
	public static FrameModificarDatosUsuarios getInstancia() {
		return instancia;
	}
}
