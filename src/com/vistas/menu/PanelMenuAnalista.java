package com.vistas.menu;

import javax.swing.JPanel;
import java.awt.Color;
import rojeru_san.rsdate.RSYearDate;
import rojeru_san.rslabel.RSLabelImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import RSMaterialComponent.RSButtonIconUno;
import RSMaterialComponent.RSButtonMaterialIconDos;
import RSMaterialComponent.RSButtonMaterialIconUno;
import RSMaterialComponent.RSButtonMaterialDos;
import RSMaterialComponent.RSButtonMaterialRipple;
import RSMaterialComponent.RSButtonMaterialShadow;
import RSMaterialComponent.RSButtonMaterialRippleIcon;
import rojeru_san.efectos.ValoresEnum.ICONS;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import rojerusan.RSComboBox;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rsfield.RSPassword;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMenuAnalista extends JPanel {
	
	private PanelEditarPerfil panelEditarPerfil = new PanelEditarPerfil();
	private JPanel panelDinamico;
	private JLabel lblCerrarSesion;
	private JLabel lblEditarPerfil;

	/**
	 * Create the panel.
	 */
	public PanelMenuAnalista() {
		setLayout(null);
		
		JPanel menuUsuario = new JPanel();
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
		iconoUsuario.setIcon(new ImageIcon(PanelMenuAnalista.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblEditarPerfil.setForeground(Color.BLACK);
				lblCerrarSesion.setForeground(Color.BLACK);
			}
		});
		lblEditarPerfil.addMouseListener(new MouseAdapter() {
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
		
		lblCerrarSesion = new JLabel("Cerrar sesión");
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
		
		panelDinamico = new JPanel();
		panelDinamico.setBounds(245, 0, 700, 725);
		add(panelDinamico);
		panelDinamico.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("SISTEMA DE GESTIÓN");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(247, 24, 206, 27);
		panelDinamico.add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelMenuAnalista.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		panelDinamico.add(labelImage_1);

	}
}
