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

public class panelMenuEstudiante extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelMenuEstudiante() {
		setLayout(null);
		
		JPanel panelTituloSistema = new JPanel();
		panelTituloSistema.setLayout(null);
		panelTituloSistema.setBounds(245, 0, 700, 74);
		add(panelTituloSistema);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA DE GESTIÓN");
		lblNewLabel_2.setForeground(new Color(58, 69, 75));
		lblNewLabel_2.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(247, 23, 206, 27);
		panelTituloSistema.add(lblNewLabel_2);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(panelMenuEstudiante.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(639, 10, 51, 53);
		panelTituloSistema.add(labelImage);
		
		JPanel panelDinamico = new JPanel();
		panelDinamico.setBounds(245, 71, 700, 654);
		add(panelDinamico);
		
		JPanel menuUsuario = new JPanel();
		menuUsuario.setLayout(null);
		menuUsuario.setBackground(new Color(177, 192, 207));
		menuUsuario.setBounds(0, 0, 246, 725);
		add(menuUsuario);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(panelMenuEstudiante.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		JLabel editarPerfil = new JLabel("Editar perfil");
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

	}

}
