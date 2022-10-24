package com.vistas.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vistas.PanelRegistroEstudiante;
import com.vistas.Registro;

import rojerusan.RSMenuBar;
import java.awt.Toolkit;

public class Menu extends JFrame {
	
	
	
	private static JPanel contentPane;
	//Menu
	static PanelMenuAnalista panelMenuAnalista = new PanelMenuAnalista();
	static PanelMenuEstudiante panelMenuEstudainte = PanelMenuEstudiante.getInstancia();
	static PanelMenuTutor panelMenuTutor = new PanelMenuTutor();
	static PanelEditarPerfil panelEditarPerfil = new PanelEditarPerfil();
	static PanelEditarPerfilEstudiante panelEditarEstudiante = new PanelEditarPerfilEstudiante();
	
	private static Menu instancia = new Menu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = instancia;
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
	public Menu() {
		setTitle("Menú Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/vistas/img/UTEC.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		boolean esEstudiante = true;
		boolean esTutor = false;
		if(esEstudiante){
			mostrarJPanel(panelMenuEstudainte,945, 725);
		}else if(esTutor) {
			mostrarJPanel(panelMenuTutor,945, 725);
		}else{
			mostrarJPanel(panelMenuAnalista,945, 725);
		}
	}
	
//	public static void mostrarJPanel(PanelMenuEstudiante panelMenu) {
//		contentPane.removeAll();
//		panelMenu.setSize(945, 725);
//		panelMenu.setLocation(0, 0);
//		contentPane.add(panelMenu);
//		contentPane.revalidate();
//		contentPane.repaint();
//	}
	
	public static void mostrarJPanel(JPanel panelMenu, int width, int hight) {
		contentPane.removeAll();
		panelMenu.setSize(width, hight);
		panelMenu.setLocation(0, 0);
		contentPane.add(panelMenu);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public static Menu getInstancia() {
		return instancia;
		
	}

}
