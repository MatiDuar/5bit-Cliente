package com.vistas.menu;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameEscolaridadEstudiante extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEscolaridadEstudiante frame = new FrameEscolaridadEstudiante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrameEscolaridadEstudiante() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Escolaridad por estudiante");
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/vistas/img/UTEC.png")));
		setBounds(100, 100,720,725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PanelReportesEstudiante panel=new PanelReportesEstudiante();
		setLocation(5, 0);
		contentPane.add(panel);
		setLocationRelativeTo(null);

	}

}
