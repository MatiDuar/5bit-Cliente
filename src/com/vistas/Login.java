package com.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vistas.menu.Menu;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSTextFull;

import rojeru_san.rslabel.RSLabelImage;
import rojeru_san.rsfield.RSPassword;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblRegistrarse;
	Registro frameRegistro = new Registro();
	
	

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
		setBounds(100, 100, 374, 387);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblRegistrarse.setForeground(Color.BLACK);
			}
		});
		panel.setBounds(0, 0, 354, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(52, 11, 160, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));
		
		RSButtonHover btnIngresar = new RSButtonHover();
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				Menu menu=new Menu();
				
				menu.panelMenu.initUI();

				
				menu.setVisible(true);
				
				
				
				setVisible(false);
			}
		});
		btnIngresar.setBackground(new Color(52, 152, 219));
		btnIngresar.setFont(new Font("Lato", Font.BOLD, 14));
		btnIngresar.setText("Ingresar");
		btnIngresar.setBounds(91, 264, 172, 33);
		panel.add(btnIngresar);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Lato", Font.PLAIN, 11));
		lblContrasena.setBounds(52, 168, 61, 14);
		panel.add(lblContrasena);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Lato", Font.PLAIN, 11));
		lblUsuario.setBounds(52, 90, 61, 14);
		panel.add(lblUsuario);
		
		RSPassword password = new RSPassword();
		password.setBounds(52, 193, 250, 42);
		panel.add(password);
		
		RSTextFull textUsuario = new RSTextFull();
		textUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		textUsuario.setPlaceholder(" Escribe algo...");
		textUsuario.setMostrarBoton(false);
		textUsuario.setForeground(new Color(52, 152, 219));
		textUsuario.setBotonColor(new Color(52, 152, 219));
		textUsuario.setBordeColorFocus(new Color(52, 152, 219));
		textUsuario.setBounds(52, 115, 250, 42);
		panel.add(textUsuario);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(Login.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(252, 11, 50, 50);
		panel.add(labelImage);
		
		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameRegistro.setVisible(true);
			}
		});
		lblRegistrarse.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblRegistrarse.setForeground(Color.BLUE);
			}
		});

		lblRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		lblRegistrarse.setBounds(52, 314, 83, 23);
		panel.add(lblRegistrarse);
	}
}
