package com.vistas;

import java.awt.Color;
import java.awt.Cursor;
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
import com.vistas.menu.PanelGestionDeEventos;

import rojeru_san.complementos.RSButtonHover;
import rojeru_san.rsfield.RSPassword;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rslabel.RSLabelImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		DAOGeneral dao = new DAOGeneral();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 374, 387);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 354, 348);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(52, 11, 160, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 50));

		;

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setToolTipText("");
		lblContrasena.setFont(new Font("Lato", Font.PLAIN, 11));
		lblContrasena.setBounds(52, 168, 61, 14);
		panel.add(lblContrasena);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Lato", Font.PLAIN, 11));
		lblUsuario.setBounds(52, 90, 61, 14);
		panel.add(lblUsuario);
		
		RSTextFull textUsuario = new RSTextFull();
		
		RSPassword password = new RSPassword();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//10 es codigo para el enter
				if(e.getKeyCode()==10) {
					DAOUsuario us = new DAOUsuario();
					String nombreUsuario = textUsuario.getText();
					String pswd = password.getText();
					try {
						ingresar(nombreUsuario, pswd);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
								JOptionPane.ERROR_MESSAGE);
						password.setText("");
					}
				}
			}
		});
		password.setForeground(new Color(27, 91, 124));
		password.setMostrarBoton(false);
		password.setBordeColorFocus(new Color(52, 152, 219));
		password.setPlaceholder(" Contrase\u00F1a... ");
		password.setBounds(52, 193, 250, 42);
		panel.add(password);

		
		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				// 10 es codigo para el enter
				if (e.getKeyCode() == 10) {
					DAOUsuario us = new DAOUsuario();
					String nombreUsuario = textUsuario.getText();
					String pswd = password.getText();
					try {
						ingresar(nombreUsuario, pswd);

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
						password.setText("");
					}
				}

			}
		});
		textUsuario.setFont(new Font("Lato", Font.BOLD, 14));
		textUsuario.setPlaceholder(" Nombre de Usuario ...");
		textUsuario.setMostrarBoton(false);
		textUsuario.setForeground(new Color(27, 91, 124));
		textUsuario.setBotonColor(new Color(52, 152, 219));
		textUsuario.setBordeColorFocus(new Color(52, 152, 219));
		textUsuario.setBounds(52, 115, 250, 42);
		panel.add(textUsuario);

		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(Login.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(252, 11, 50, 50);
		panel.add(labelImage);

		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(new Color(27, 91, 124));
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Registro reg = new Registro();
				Registro.setInstancia(reg);
				setVisible(false);
				reg.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegistrarse.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblRegistrarse.setForeground(new Color(27, 91, 124));

			}
		});
		

		lblRegistrarse.setFont(new Font("Lato", Font.BOLD, 14));
		lblRegistrarse.setBounds(52, 314, 83, 23);
		panel.add(lblRegistrarse);

		RSButtonHover btnIngresar = new RSButtonHover();
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOUsuario us = new DAOUsuario();
				String nombreUsuario = textUsuario.getText();
				String pswd = password.getText();
				try {
					ingresar(nombreUsuario, pswd);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
					password.setText("");
				}

			}
		});
		btnIngresar.setBackground(new Color(52, 152, 219));
		btnIngresar.setFont(new Font("Lato", Font.BOLD, 14));
		btnIngresar.setText("Ingresar");
		btnIngresar.setBounds(91, 264, 172, 33);
		panel.add(btnIngresar);

	}

	public void ingresar(String nombreUsuario, String pswd) throws Exception {
		Usuario usuarioIngresado = DAOUsuario.usuarioRemote.verificarUsuario(nombreUsuario, pswd);
		Menu menu = Menu.getInstancia();
		if (usuarioIngresado == null) {
			throw new Exception("Nombre de usuario o contraseña incorrecto.");
		}
		if (usuarioIngresado.getActivo() && !usuarioIngresado.getValidado()) {
			throw new Exception("La cuenta todavia no fue verificada.");
		}
		if (!usuarioIngresado.getActivo()) {
			throw new Exception("La cuenta se encuentra incatvia en el sistema sistema.");
		}
		if (usuarioIngresado instanceof Tutor) {

			Menu.setUsuario(usuarioIngresado);

			menu.panelMenu.initUITutor();
			PanelGestionDeEventos.reset();

			menu.setVisible(true);
			setVisible(false);
		} else if (usuarioIngresado instanceof Analista) {

			Menu.setUsuario(usuarioIngresado);
			menu.panelMenu.initUIAnalista();
			PanelGestionDeEventos.reset();

			menu.setVisible(true);
			setVisible(false);
		} else if (usuarioIngresado instanceof Estudiante) {

			Menu.setUsuario(usuarioIngresado);
			menu.panelMenu.initUI();
			PanelGestionDeEventos.reset();

			menu.setVisible(true);
			setVisible(false);
		}
	}
}
