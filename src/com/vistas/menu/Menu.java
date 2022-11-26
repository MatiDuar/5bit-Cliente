package com.vistas.menu;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entities.Usuario;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;
	public PanelMenu panelMenu=new PanelMenu();
	private static Usuario usuarioIngresado;
	private static Menu instancia=new Menu();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private Menu() {
		
		setTitle("Men\u00fa Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/vistas/img/UTEC.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(panelMenu);
		setLocationRelativeTo(null);
	}
	
	public static Menu getInstancia() {
		return instancia;
	}
	
	
	public static void setUsuario(Usuario user) {
		usuarioIngresado=user;
	}
	
	public static Usuario getUsuario() {
		return usuarioIngresado;
	}
}
