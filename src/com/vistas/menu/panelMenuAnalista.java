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
import rojerusan.RSComboBox;
import rojeru_san.rsfield.RSTextFull;
import rojeru_san.rsdate.RSDateChooser;
import rojeru_san.rsfield.RSPassword;

public class panelMenuAnalista extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelMenuAnalista() {
		setLayout(null);
		
		JPanel menuUsuario = new JPanel();
		menuUsuario.setBounds(0, 0, 246, 725);
		menuUsuario.setBackground(new Color(177, 192, 207));
		add(menuUsuario);
		menuUsuario.setLayout(null);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(panelMenuAnalista.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
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
		
		RSButtonMaterialIconUno buttonGestionUsuarios = new RSButtonMaterialIconUno();
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
		labelImage.setIcon(new ImageIcon(panelMenuAnalista.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(639, 10, 51, 53);
		panelTituloSistema.add(labelImage);
		
		JPanel panelDinamico = new JPanel();
		panelDinamico.setBounds(245, 71, 700, 654);
		add(panelDinamico);
		panelDinamico.setLayout(null);

	}
}
