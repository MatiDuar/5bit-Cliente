package com.vistas.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import rojerusan.RSTableMetro;
import javax.swing.JLabel;
import rojeru_san.rsbutton.RSButtonCircleIcon;
import rojeru_san.rsbutton.RSButtonMetro;
import RSMaterialComponent.RSButtonIconUno;
import rojeru_san.efectos.ValoresEnum.ICONS;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import rojeru_san.complementos.RSButtonHover;

public class FrameAsignarFuncionalidad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAsignarFuncionalidad frame = new FrameAsignarFuncionalidad();
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
	public FrameAsignarFuncionalidad() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 525, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 201, 284);
		contentPane.add(scrollPane);
		
		RSTableMetro tableMetro = new RSTableMetro();
		scrollPane.setViewportView(tableMetro);
		
		JLabel lblNewLabel = new JLabel("Funcionalidades Asignadas");
		lblNewLabel.setBounds(22, 59, 165, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFuncionalidadesNoAsignadas = new JLabel("Funcionalidades No Asignadas");
		lblFuncionalidadesNoAsignadas.setBounds(310, 59, 180, 14);
		contentPane.add(lblFuncionalidadesNoAsignadas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(298, 84, 201, 284);
		contentPane.add(scrollPane_1);
		
		RSTableMetro tableMetro_1 = new RSTableMetro();
		scrollPane_1.setViewportView(tableMetro_1);
		
		RSButtonIconUno buttonIconUno = new RSButtonIconUno();
		buttonIconUno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		buttonIconUno.setIcons(ICONS.ARROW_BACK);
		buttonIconUno.setBounds(234, 109, 40, 40);
		contentPane.add(buttonIconUno);
		
		RSButtonIconUno buttonIconUno_1 = new RSButtonIconUno();
		buttonIconUno_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		buttonIconUno_1.setIcons(ICONS.ARROW_FORWARD);
		buttonIconUno_1.setBounds(234, 282, 40, 40);
		contentPane.add(buttonIconUno_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("ELEGIR FUNCIONALIDAD");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(136, 11, 237, 27);
		contentPane.add(lblNewLabel_2_1);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(0, 112, 192));
		btnhvrGuardar.setBounds(198, 384, 108, 33);
		contentPane.add(btnhvrGuardar);
	}
}
