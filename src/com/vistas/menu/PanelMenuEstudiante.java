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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PanelMenuEstudiante extends JPanel {
	private Menu menu = Menu.getInstancia();
	private JLabel lblCerrarSesion;
	private PanelEditarPerfil panelEditarPerfil = new PanelEditarPerfil();
	
	static private PanelMenuEstudiante instancia = new PanelMenuEstudiante();

	/**
	 * Create the panel.
	 */
	public PanelMenuEstudiante() {
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
		labelImage_1.setIcon(new ImageIcon(PanelMenuEstudiante.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(639, 11, 51, 53);
		panelDinamico.add(labelImage_1);
		
		JPanel menuUsuario = new JPanel();
		menuUsuario.setLayout(null);
		menuUsuario.setBackground(new Color(177, 192, 207));
		menuUsuario.setBounds(0, 0, 246, 725);
		add(menuUsuario);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(PanelMenuEstudiante.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
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

	public static PanelMenuEstudiante getInstancia() {
		return instancia;
		
	}
}
