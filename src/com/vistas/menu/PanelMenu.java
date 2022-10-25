package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import rojeru_san.rslabel.RSLabelImage;
import javax.swing.SwingConstants;
import RSMaterialComponent.RSButtonMaterialIconUno;
import rojeru_san.efectos.ValoresEnum.ICONS;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PanelMenu extends JPanel {
	private JLabel lblCerrarSesion;
//	private PanelEditarPerfil panelEditarPerfil = new PanelEditarPerfil();
	
//	static private PanelMenuEstudiante instancia = new PanelMenuEstudiante();

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		
	}

//	public static PanelMenuEstudiante getInstancia() {
//		return instancia;
//		
//	}
	
	public void initUI() {
		
		removeAll();
		
		setBounds(0,0,955, 725);
		setLayout(null);
		JPanel panelDinamico = new JPanel();
		panelDinamico.setBounds(245, 0, 700, 725);
		add(panelDinamico);
		panelDinamico.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("SISTEMA DE GESTIÓN");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(247, 24, 206, 27);
		panelDinamico.add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelMenu.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(639, 11, 51, 53);
		panelDinamico.add(labelImage_1);
		
		JPanel menuUsuario = new JPanel();
		menuUsuario.setLayout(null);
		menuUsuario.setBackground(new Color(177, 192, 207));
		menuUsuario.setBounds(0, 0, 246, 725);
		add(menuUsuario);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(PanelMenu.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		JLabel editarPerfil = new JLabel("Editar perfil");
		editarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				editarPerfil.setForeground(Color.BLACK);
				lblCerrarSesion.setForeground(Color.BLACK);
			}
		});
		editarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelEditarPerfil panelEditarPerfil=new PanelEditarPerfil();
				panelDinamico.removeAll();
				panelEditarPerfil.setSize(945, 725);
				panelEditarPerfil.setLocation(0, 0);
				panelDinamico.add(panelEditarPerfil);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		editarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		editarPerfil.setFont(new Font("Lato", Font.PLAIN, 11));
		editarPerfil.setBounds(93, 226, 60, 13);
		menuUsuario.add(editarPerfil);
		
		RSButtonMaterialIconUno buttonGestionConstancias = new RSButtonMaterialIconUno();
		buttonGestionConstancias.setText("CONSTANCIAS                 ");
		buttonGestionConstancias.setIcons(ICONS.FILTER_NONE);
		buttonGestionConstancias.setBounds(25, 340, 200, 40);
		menuUsuario.add(buttonGestionConstancias);
		
		RSButtonMaterialIconUno buttonReportes = new RSButtonMaterialIconUno();
		buttonReportes.setText("REPORTES                            ");
		buttonReportes.setIcons(ICONS.ASSESSMENT);
		buttonReportes.setHorizontalAlignment(SwingConstants.TRAILING);
		buttonReportes.setBounds(25, 390, 200, 40);
		menuUsuario.add(buttonReportes);
		
		lblCerrarSesion = new JLabel("Cerrar sesión");
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(80, 684, 73, 13);
		menuUsuario.add(lblCerrarSesion);
	}
	
	
	
	public void initUIAnalista() {
		removeAll();
		setLayout(null);
		
		JPanel menuUsuario = new JPanel();
		JLabel lblEditarPerfil = new JLabel("Editar perfil");

		menuUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblEditarPerfil.setForeground(Color.BLUE);
			}
		});
		menuUsuario.setBounds(0, 0, 246, 725);
		menuUsuario.setBackground(new Color(177, 192, 207));
		add(menuUsuario);
		menuUsuario.setLayout(null);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(Menu.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		lblEditarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblEditarPerfil.setForeground(Color.BLACK);
				lblCerrarSesion.setForeground(Color.BLACK);
			}
		});
		JPanel panelDinamico = new JPanel();

		lblEditarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelEditarPerfil panelEditarPerfil=new PanelEditarPerfil();
				panelDinamico.removeAll();
				panelEditarPerfil.setSize(945, 725);
				panelEditarPerfil.setLocation(0, 0);
				panelDinamico.add(panelEditarPerfil);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		lblEditarPerfil.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEditarPerfil.setBounds(93, 226, 60, 13);
		menuUsuario.add(lblEditarPerfil);
		
		RSButtonMaterialIconUno buttonGestionUsuarios = new RSButtonMaterialIconUno();
		buttonGestionUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGestionUsuarios.setHorizontalAlignment(SwingConstants.TRAILING);
		buttonGestionUsuarios.setText("USUARIOS                            ");
		buttonGestionUsuarios.setBounds(25, 330, 200, 40);
		menuUsuario.add(buttonGestionUsuarios);
		
		RSButtonMaterialIconUno buttonGestionEventos = new RSButtonMaterialIconUno();
		buttonGestionEventos.setIcons(ICONS.DATE_RANGE);
		buttonGestionEventos.setText("EVENTOS                             ");
		buttonGestionEventos.setBounds(25, 380, 200, 40);
		menuUsuario.add(buttonGestionEventos);
		
		RSButtonMaterialIconUno buttonGestionConstancias = new RSButtonMaterialIconUno();
		buttonGestionConstancias.setIcons(ICONS.FILTER_NONE);
		buttonGestionConstancias.setText("CONSTANCIAS                 ");
		buttonGestionConstancias.setBounds(25, 430, 200, 40);
		menuUsuario.add(buttonGestionConstancias);
		
		RSButtonMaterialIconUno buttonReportes = new RSButtonMaterialIconUno();
		buttonReportes.setIcons(ICONS.ASSESSMENT);
		buttonReportes.setHorizontalAlignment(SwingConstants.TRAILING);
		buttonReportes.setText("REPORTES                            ");
		buttonReportes.setBounds(25, 480, 200, 40);
		menuUsuario.add(buttonReportes);
		
		JLabel lblCerrarSesion = new JLabel("Cerrar sesión");
		lblCerrarSesion.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
			}
		});
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 686, 73, 13);
		menuUsuario.add(lblCerrarSesion);
		
		panelDinamico.setBounds(245, 0, 700, 725);
		add(panelDinamico);
		panelDinamico.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("SISTEMA DE GESTIÓN");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(247, 24, 206, 27);
		panelDinamico.add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelMenu.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		panelDinamico.add(labelImage_1);
	}
	
	public void initUITutor() {
		removeAll();
		setLayout(null);
		
		JPanel menuUsuario = new JPanel();
		menuUsuario.setBounds(0, 0, 246, 725);
		menuUsuario.setBackground(new Color(177, 192, 207));
		add(menuUsuario);
		menuUsuario.setLayout(null);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon("C:\\Users\\GabrielaP\\Downloads\\LogoDeUsuario.png"));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblEditarPerfil.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEditarPerfil.setBounds(93, 226, 60, 13);
		menuUsuario.add(lblEditarPerfil);
		
		RSButtonMaterialIconUno buttonGestionEventos = new RSButtonMaterialIconUno();
		buttonGestionEventos.setIcons(ICONS.DATE_RANGE);
		buttonGestionEventos.setText("EVENTOS                             ");
		buttonGestionEventos.setBounds(25, 340, 200, 40);
		menuUsuario.add(buttonGestionEventos);
		
		RSButtonMaterialIconUno buttonGestionConstancias = new RSButtonMaterialIconUno();
		buttonGestionConstancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGestionConstancias.setIcons(ICONS.ASSESSMENT);
		buttonGestionConstancias.setText("REPORTES                          ");
		buttonGestionConstancias.setBounds(25, 390, 200, 40);
		menuUsuario.add(buttonGestionConstancias);
		
		JPanel panelTituloSistema = new JPanel();
		panelTituloSistema.setBounds(245, 0, 700, 74);
		add(panelTituloSistema);
		panelTituloSistema.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA DE GESTIÓN");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(247, 23, 206, 27);
		panelTituloSistema.add(lblNewLabel_2);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon("C:\\Users\\GabrielaP\\ProyectoPDT\\5bit-Cliente\\src\\com\\vistas\\img\\UTEC.png"));
		labelImage.setBounds(639, 10, 51, 53);
		panelTituloSistema.add(labelImage);
		
		JPanel panelDinamico = new JPanel();
		panelDinamico.setBounds(245, 71, 700, 654);
		add(panelDinamico);

	}
}
