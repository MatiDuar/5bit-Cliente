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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 363, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 354, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(52, 11, 156, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		
		RSButtonHover btnIngresar = new RSButtonHover();
		btnIngresar.setBackground(new Color(52, 152, 219));
		btnIngresar.setFont(new Font("Lato", Font.BOLD, 14));
		btnIngresar.setText("Ingresar");
		btnIngresar.setBounds(91, 264, 172, 33);
		panel.add(btnIngresar);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Lato", Font.PLAIN, 11));
		lblContrasena.setBounds(52, 168, 61, 14);
		panel.add(lblContrasena);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEmail.setBounds(52, 90, 61, 14);
		panel.add(lblEmail);
		
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
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblRegistrarse.setForeground(Color.BLUE);
			}
		});

		lblRegistrarse.setFont(new Font("Lato", Font.PLAIN, 11));
		lblRegistrarse.setBounds(52, 308, 67, 14);
		panel.add(lblRegistrarse);
	}
}
