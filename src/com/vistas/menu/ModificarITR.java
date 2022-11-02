package com.vistas.menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import rojeru_san.rslabel.RSLabelImage;
import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojerusan.RSComboBox;
import rojeru_san.complementos.RSButtonHover;
import javax.swing.ImageIcon;

public class ModificarITR extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarITR frame = new ModificarITR();
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
	public ModificarITR() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarITR.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Modificar ITR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarItr = new JLabel("MODIFICAR ITR");
		lblModificarItr.setForeground(new Color(58, 69, 75));
		lblModificarItr.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblModificarItr.setBounds(91, 18, 128, 25);
		contentPane.add(lblModificarItr);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(ModificarITR.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(264, 10, 37, 38);
		contentPane.add(labelImage);
		
		JLabel lblIngresarNombre = new JLabel("Nombre");
		lblIngresarNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblIngresarNombre.setBounds(10, 60, 85, 13);
		contentPane.add(lblIngresarNombre);
		
		RSTextFieldIconUno textFieldNombreUno = new RSTextFieldIconUno();
		textFieldNombreUno.setPlaceholder("Ingresar Nombre");
		textFieldNombreUno.setIcons(ICONS.BUSINESS);
		textFieldNombreUno.setBounds(10, 76, 291, 36);
		contentPane.add(textFieldNombreUno);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 122, 85, 13);
		contentPane.add(lblDepartamento);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setBounds(10, 138, 291, 36);
		contentPane.add(comboBox);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(0, 112, 192));
		btnhvrCancelar.setBounds(10, 200, 98, 30);
		contentPane.add(btnhvrCancelar);
		
		RSButtonHover btnhvrModificar = new RSButtonHover();
		btnhvrModificar.setText("Modificar");
		btnhvrModificar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificar.setBackground(new Color(0, 112, 192));
		btnhvrModificar.setBounds(203, 200, 98, 30);
		contentPane.add(btnhvrModificar);
	}
}
