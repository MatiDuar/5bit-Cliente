package com.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rslabel.RSLabelAnimated;
import rojeru_san.rsfield.RSTextField;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rsfield.RSTextFullRound;
import rojeru_san.rslabel.RSLabelImage;
import RSMaterialComponent.RSLabelTextIcon;
import rojeru_san.rsfield.RSPassword;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 354, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(52, 11, 156, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		
		RSButtonHover btnhvrIngresar = new RSButtonHover();
		btnhvrIngresar.setBackground(new Color(52, 152, 219));
		btnhvrIngresar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrIngresar.setText("Ingresar");
		btnhvrIngresar.setBounds(91, 249, 172, 33);
		panel.add(btnhvrIngresar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(52, 168, 61, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(52, 90, 61, 14);
		panel.add(lblNewLabel_1_2);
		
		RSPassword password = new RSPassword();
		password.setBounds(52, 193, 250, 42);
		panel.add(password);
		
		RSTextFull textFull = new RSTextFull();
		textFull.setBounds(52, 115, 250, 42);
		panel.add(textFull);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(Login.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(218, 19, 50, 50);
		panel.add(labelImage);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Registrarse");
		lblNewLabel_1_2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(52, 293, 67, 14);
		panel.add(lblNewLabel_1_2_1);
	}
}
