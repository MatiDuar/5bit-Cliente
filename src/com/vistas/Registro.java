package com.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.complementos.RSButtonHover;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {
	
	private static Registro instancia = new Registro();
	
	

	private JPanel contentPane;
	private static JPanel panelDinamico;
	PanelRegistroPag panelRegistroPag = PanelRegistroPag.getInstancia();
	static PanelRegistroPag2 panelRegistroPag2 = PanelRegistroPag2.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = instancia;
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
	public Registro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 726, 523);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		setPanelDinamico(new JPanel());
		getPanelDinamico().setBounds(0, 0, 710, 495);
		contentPane.add(getPanelDinamico());
		getPanelDinamico().setLayout(null);
		//Mostrar primer pagina registro
		mostrarPag1(panelRegistroPag);
	}
	
	public static void mostrarPag1(PanelRegistroPag panelRegistroPag) {
		panelDinamico.removeAll();
		panelRegistroPag.setSize(710, 844);
		panelRegistroPag.setLocation(0, 0);
		panelDinamico.add(panelRegistroPag);
		panelDinamico.revalidate();
		panelDinamico.repaint();
	}
	
	public static void mostrarPag2(PanelRegistroPag2 panelRegistroPag2) {
		panelDinamico.removeAll();
		panelRegistroPag2.cargaComboBox();
		panelRegistroPag2.setSize(710, 495);
		panelRegistroPag2.setLocation(0, 0);
		panelRegistroPag2.cargaComboBox();
		panelDinamico.add(panelRegistroPag2);
		panelDinamico.revalidate();
		panelDinamico.repaint();
	}
	
	public static void mostrarDatosTutor(PanelRegistroTutor panelRegistroTutor) {
		panelRegistroPag2.panelDinamicoReg2.removeAll();
		panelRegistroTutor.setSize(570, 186);
		panelRegistroTutor.setLocation(0, 0);
		panelRegistroPag2.panelDinamicoReg2.add(panelRegistroTutor);
		panelRegistroPag2.panelDinamicoReg2.revalidate();
		panelRegistroPag2.panelDinamicoReg2.repaint();
	}
	
	public static void mostrarDatoEstudiante(PanelRegistroEstudiante panelRegistroEstudiante) {
		panelRegistroPag2.panelDinamicoReg2.removeAll();
		panelRegistroEstudiante.setSize(571, 187);
		panelRegistroEstudiante.setLocation(0, 0);
		panelRegistroPag2.panelDinamicoReg2.add(panelRegistroEstudiante);
		panelRegistroPag2.panelDinamicoReg2.revalidate();
		panelRegistroPag2.panelDinamicoReg2.repaint();
	}
	
	public static Registro getInstancia(){
		return instancia;
	}
	
	public static void setInstancia(Registro registro){
		instancia=registro;
	}

	public static JPanel getPanelDinamico() {
		return panelDinamico;
		
	}

	public static void setPanelDinamico(JPanel panelDinamico) {
		Registro.panelDinamico = panelDinamico;
		
	}
	
	
	public static void resetDatos() {
		PanelRegistroEstudiante.reset();
		PanelRegistroPag.reset();
		PanelRegistroPag2.reset();
		PanelRegistroTutor.reset();
	}
}
