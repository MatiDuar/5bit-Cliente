package com.vistas.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import rojeru_san.rslabel.RSLabelImage;
import javax.swing.SwingConstants;

import com.vistas.Login;

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
	
//	static private PanelMenuEstudiante instancia = new PanelMenuEstudiante()

	PanelGestionDeEventos panelGestionDeEventos=new PanelGestionDeEventos();

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
//		initUIAnalista();
	}

//	public static PanelMenuEstudiante getInstancia() {
//		return instancia;
//		
//	}
	public void initUITutor() {
		removeAll();
		
		setBounds(0,0,955, 725);
		setLayout(null);
		
		JPanel menuUsuario = new JPanel();
		menuUsuario.setBounds(0, 0, 246, 725);
		menuUsuario.setBackground(new Color(177, 192, 207));
		add(menuUsuario);
		menuUsuario.setLayout(null);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon("/com/vistas/img/LogoDeUsuario.png"));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setText(Menu.usuarioIngresado.getNombre1()+" "+Menu.usuarioIngresado.getApellido1());
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
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
		
		JPanel panelDinamico = new JPanel();
		panelDinamico.setBounds(245, 0, 700, 725);
		add(panelDinamico);
		panelDinamico.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA DE GESTIÓN");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(247, 28, 206, 27);
		panelDinamico.add(lblNewLabel_2);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
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
		lblEditarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				lblEditarPerfil.setForeground(Color.BLUE);
//				setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
		});
		
		lblEditarPerfil.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEditarPerfil.setBounds(93, 226, 60, 13);
		
		
		menuUsuario.add(lblEditarPerfil);
		lblCerrarSesion=new JLabel("Cerrar sesion");
		lblCerrarSesion.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.usuarioIngresado=null;
				Menu.getInstancia().setVisible(false);
				
				Login log=new Login();
				log.setVisible(true);
			}
		});
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 600, 73, 13);
		
		menuUsuario.add(lblCerrarSesion);
		
		RSButtonMaterialIconUno btnmtrlcnFuncionalidades = new RSButtonMaterialIconUno();
		btnmtrlcnFuncionalidades.setHorizontalAlignment(SwingConstants.LEFT);
		btnmtrlcnFuncionalidades.setText("FUNCIONALIDADES                 ");
		btnmtrlcnFuncionalidades.setIcons(ICONS.INFO_OUTLINE);
		btnmtrlcnFuncionalidades.setBounds(25, 441, 200, 40);
		menuUsuario.add(btnmtrlcnFuncionalidades);
		menuUsuario.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				if(lblEditarPerfil.getForeground()==Color.BLUE) {
//					lblEditarPerfil.setForeground(Color.BLACK);
//					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//				if(lblCerrarSesion.getForeground()==Color.BLUE) {
//					lblCerrarSesion.setForeground(Color.BLACK);
//					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//			}
		});
	}
	
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
		lblNombreUsuario.setText(Menu.usuarioIngresado.getNombre1()+" "+Menu.usuarioIngresado.getApellido1());
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		JLabel editarPerfil = new JLabel("Editar perfil");
		menuUsuario.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				if(editarPerfil.getForeground()==Color.BLUE) {
//					editarPerfil.setForeground(Color.BLACK);
//					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//				if(lblCerrarSesion.getForeground()==Color.BLUE) {
//					lblCerrarSesion.setForeground(Color.BLACK);
//					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//			}
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
		editarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				editarPerfil.setForeground(Color.BLUE);
//				setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
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
		lblCerrarSesion=new JLabel("Cerrar sesion");
		lblCerrarSesion.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.usuarioIngresado=null;
				Menu.getInstancia().setVisible(false);
				
				Login log=new Login();
				log.setVisible(true);
			}
		});
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 600, 73, 13);
		menuUsuario.add(lblCerrarSesion);
		
		RSButtonMaterialIconUno btnFuncionalidades = new RSButtonMaterialIconUno();
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelFuncionalidades panelFuncionalidades=new PanelFuncionalidades();
				panelDinamico.removeAll();
				panelFuncionalidades.setSize(945, 725);
				panelFuncionalidades.setLocation(0, 0);
				panelDinamico.add(panelFuncionalidades);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		btnFuncionalidades.setText(" FUNCIONALIDADES                 ");
		btnFuncionalidades.setIcons(ICONS.INFO_OUTLINE);
		btnFuncionalidades.setHorizontalAlignment(SwingConstants.LEFT);
		btnFuncionalidades.setBounds(25, 441, 200, 40);
		menuUsuario.add(btnFuncionalidades);
	}
	
	
	
	public void initUIAnalista() {
		removeAll();
		setLayout(null);
		setBounds(0,0,955, 725);

		JPanel menuUsuario = new JPanel();
		JPanel panelDinamico = new JPanel();

		menuUsuario.setBounds(0, 0, 246, 725);
		menuUsuario.setBackground(new Color(177, 192, 207));
		add(menuUsuario);
		menuUsuario.setLayout(null);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(Menu.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setText(Menu.usuarioIngresado.getNombre1()+" "+Menu.usuarioIngresado.getApellido1());
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				lblEditarPerfil.setForeground(Color.BLUE);
//				setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
		});
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
		
		JLabel lblCerrarSesion = new JLabel("Cerrar sesión");

		
//		menuUsuario.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				if(lblEditarPerfil.getForeground()==Color.BLUE) {
//					lblEditarPerfil.setForeground(Color.BLACK);
//					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//				if(lblCerrarSesion.getForeground()==Color.BLUE) {
//					lblCerrarSesion.setForeground(Color.BLACK);
//					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//			}
//		});

		
		
		RSButtonMaterialIconUno buttonGestionUsuarios = new RSButtonMaterialIconUno();
		buttonGestionUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PanelGestionUsuarios panelGestionUsuarios = PanelGestionUsuarios.getInstancia();
				panelDinamico.removeAll();
				panelGestionUsuarios.setSize(974,725);
				panelGestionUsuarios.setLocation(0,0);
				panelDinamico.add(panelGestionUsuarios);
				panelDinamico.revalidate();
				panelDinamico.repaint();
				
			}
		});
		buttonGestionUsuarios.setHorizontalAlignment(SwingConstants.TRAILING);
		buttonGestionUsuarios.setText("USUARIOS                            ");
		buttonGestionUsuarios.setBounds(25, 330, 200, 40);
		menuUsuario.add(buttonGestionUsuarios);
		
		RSButtonMaterialIconUno buttonGestionEventos = new RSButtonMaterialIconUno();
		buttonGestionEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDinamico.removeAll();
				panelGestionDeEventos.setSize(945, 725);
				panelGestionDeEventos.setLocation(0, 0);
				panelDinamico.add(panelGestionDeEventos);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
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
		
		lblCerrarSesion.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				lblCerrarSesion.setForeground(Color.BLUE);
//				setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
		});
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.usuarioIngresado=null;
				Menu.getInstancia().setVisible(false);
				
				Login log=new Login();
				log.setVisible(true);
			}
		});
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 600, 73, 13);
		menuUsuario.add(lblCerrarSesion);
		
		RSButtonMaterialIconUno btnmtrlcnFuncionalidades = new RSButtonMaterialIconUno();
		btnmtrlcnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelFuncionalidadesAnalista panelFuncionalidadesAnalista = new PanelFuncionalidadesAnalista();
				panelDinamico.removeAll();
				panelFuncionalidadesAnalista.setSize(945, 725);
				panelFuncionalidadesAnalista.setLocation(0, 0);
				panelDinamico.add(panelFuncionalidadesAnalista);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		btnmtrlcnFuncionalidades.setIcons(ICONS.INFO_OUTLINE);
		btnmtrlcnFuncionalidades.setText("FUNCIONALIDADES");
		btnmtrlcnFuncionalidades.setHorizontalAlignment(SwingConstants.LEFT);
		btnmtrlcnFuncionalidades.setBounds(25, 531, 200, 40);
		menuUsuario.add(btnmtrlcnFuncionalidades);
	}
}
