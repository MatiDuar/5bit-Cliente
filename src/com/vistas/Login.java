package com.vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controlador.DAOGeneral;
import com.controlador.DAOUsuario;
import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.vistas.menu.Menu;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSPassword;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rslabel.RSLabelImage;

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
		DAOGeneral dao=new DAOGeneral();
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
		
		;
		
		JLabel lblContrasena = new JLabel("ContraseÃ±a");
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
				frameRegistro.panelRegistroPag2.cargaComboBox();
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
		
		RSButtonHover btnIngresar = new RSButtonHover();
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOUsuario us=new DAOUsuario();			
				Menu menu=new Menu();
				String nombreUsuario=textUsuario.getText();
				String pswd=password.getText();
				
				
				Usuario usuarioIngresado;
				try {
					usuarioIngresado = DAOUsuario.usuarioRemote.verificarUsuario(nombreUsuario, pswd);
					if(usuarioIngresado instanceof Tutor) {
						menu.panelMenu.initUITutor();
						Menu.usuarioIngresado=usuarioIngresado;

						menu.setVisible(true);
						setVisible(false);
					}else if(usuarioIngresado instanceof Analista) {
						menu.panelMenu.initUIAnalista();
						Menu.usuarioIngresado=usuarioIngresado;

						menu.setVisible(true);
						setVisible(false);
					}else if(usuarioIngresado instanceof Estudiante){
						menu.panelMenu.initUI();
						Menu.usuarioIngresado=usuarioIngresado;
						menu.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "nombre de usuario o contraseña incorrecto",
							      "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (ServicesException e1) {
					e1.printStackTrace();
				}
	
				
			}
		});
		btnIngresar.setBackground(new Color(52, 152, 219));
		btnIngresar.setFont(new Font("Lato", Font.BOLD, 14));
		btnIngresar.setText("Ingresar");
		btnIngresar.setBounds(91, 264, 172, 33);
		panel.add(btnIngresar);
	}
}
