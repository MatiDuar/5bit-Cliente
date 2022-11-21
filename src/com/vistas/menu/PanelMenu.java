package com.vistas.menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.vistas.Login;

import RSMaterialComponent.RSButtonMaterialIconUno;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;

public class PanelMenu extends JPanel {
//	private PanelEditarPerfil panelEditarPerfil = new PanelEditarPerfil();
	
//	static private PanelMenuEstudiante instancia = new PanelMenuEstudiante()


	/**
	 * Create the panel.
	 */
	public PanelMenu() {
	}

//	public static PanelMenuEstudiante getInstancia() {
//		return instancia;
//		
//	}
	public void initUITutor() {
		removeAll();
		
		setBounds(0,0,955, 725);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 0, 700, 725);
		
		JPanel panelDinamico = new JPanel();		
		panelDinamico.setBounds(0, 0, 700, 725);		
		panelDinamico.setLayout(null);
		
		scrollPane.add(panelDinamico);

		
		add(scrollPane);
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
		lblNombreUsuario.setText(Menu.getUsuario().getNombre1()+" "+Menu.getUsuario().getApellido1());
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		
		RSButtonMaterialIconUno buttonGestionConstancias = new RSButtonMaterialIconUno();
		buttonGestionConstancias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelReportesAnalistaTutor ventana=new PanelReportesAnalistaTutor();

				panelDinamico.removeAll();
				ventana.setSize(945, 725);
				ventana.setLocation(0, 0);
				panelDinamico.add(ventana);
				panelDinamico.revalidate();
				panelDinamico.repaint();
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
		labelImage.setIcon(new ImageIcon("/com/vistas/img/UTEC.png"));
		labelImage.setBounds(639, 10, 51, 53);
		panelTituloSistema.add(labelImage);
		
		
		
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
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEditarPerfil.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblEditarPerfil.setForeground(new Color(27, 91, 124));

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
		JLabel lblCerrarSesion=new JLabel("Cerrar sesion");
		
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu.setUsuario(null);
				Menu.getInstancia().setVisible(false);
				PanelGestionDeEventos.reset();
				Login log=new Login();
				log.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblCerrarSesion.setForeground(new Color(27, 91, 124));

			}
		});
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 600, 73, 13);
		
		menuUsuario.add(lblCerrarSesion);
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
		
		RSButtonMaterialIconUno buttonGestionEventos = new RSButtonMaterialIconUno();
		buttonGestionEventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelGestionDeEventos panelGestionDeEventos=PanelGestionDeEventos.getInstancia();
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
		buttonGestionEventos.setBounds(25, 340, 200, 40);
		menuUsuario.add(buttonGestionEventos);
		
	}
	
	
	
	
	
	/////////////////////////////////////////////////
	
	
	public void initUI() {
		
		removeAll();
		
		setBounds(0,0,955, 725);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 0, 700, 725);
		
		JPanel panelDinamico = new JPanel();
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
		lblNombreUsuario.setText(Menu.getUsuario().getNombre1()+" "+Menu.getUsuario().getApellido1());
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		JLabel editarPerfil = new JLabel("Editar perfil");
		
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
			@Override
			public void mouseEntered(MouseEvent e) {
				editarPerfil.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				editarPerfil.setForeground(new Color(27, 91, 124));

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
		buttonReportes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelReportesEstudiante ventana=new PanelReportesEstudiante();
				scrollPane.removeAll();

//				ventana.setSize(700, 800);
//				ventana.setLocation(0, 0);

				scrollPane.add(ventana);
				scrollPane.setPreferredSize(new Dimension(700,500));
				scrollPane.revalidate();
				scrollPane.repaint();

			}
		});
		
		
		menuUsuario.add(buttonReportes);
		JLabel lblCerrarSesion=new JLabel("Cerrar sesión");
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
				Menu.setUsuario(null);
				Menu.getInstancia().setVisible(false);
				
				Login log=new Login();
				log.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblCerrarSesion.setForeground(new Color(27, 91, 124));

			}
		});
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 600, 73, 13);
		menuUsuario.add(lblCerrarSesion);
//		scrollPane.add(panelDinamico);
		add(scrollPane);
		
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
		lblNombreUsuario.setText(Menu.getUsuario().getNombre1()+" "+Menu.getUsuario().getApellido1());
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
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEditarPerfil.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblEditarPerfil.setForeground(new Color(27, 91, 124));

			}
			
		});
		lblEditarPerfil.setFont(new Font("Lato", Font.PLAIN, 11));
		lblEditarPerfil.setBounds(93, 226, 60, 13);
		menuUsuario.add(lblEditarPerfil);
		
		JLabel lblCerrarSesion = new JLabel("Cerrar sesión");
		
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
				PanelGestionDeEventos panelGestionDeEventos=PanelGestionDeEventos.getInstancia();

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
		
		buttonReportes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelReportesAnalistaTutor ventana=new PanelReportesAnalistaTutor();

				panelDinamico.removeAll();
				ventana.setSize(945, 725);
				ventana.setLocation(0, 0);
				panelDinamico.add(ventana);
				panelDinamico.revalidate();
				panelDinamico.repaint();
			}
		});
		
		
		
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
				Menu.setUsuario(null);
				Menu.getInstancia().setVisible(false);
				
				Login log=new Login();
				log.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblCerrarSesion.setForeground(new Color(27, 91, 124));

			}
		});
		lblCerrarSesion.setFont(new Font("Lato", Font.PLAIN, 11));
		lblCerrarSesion.setBounds(93, 600, 73, 13);
		menuUsuario.add(lblCerrarSesion);
		
	}
}
