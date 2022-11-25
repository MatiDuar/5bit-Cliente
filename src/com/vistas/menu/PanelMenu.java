package com.vistas.menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.entities.Estudiante;
import com.vistas.Login;

import RSMaterialComponent.RSButtonMaterialIconUno;
import RSMaterialComponent.RSLabelTextIcon;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;

public class PanelMenu extends JPanel {
//	private PanelEditarPerfil panelEditarPerfil = new PanelEditarPerfil();
	
//	static private PanelMenuEstudiante instancia = new PanelMenuEstudiante()

	private JPanel menuUsuario;
	private JPanel panelDinamico;
	private JScrollPane scrollPane;
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
		datosComunes();

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
		datosComunes();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 0, 700, 725);

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
				try {
					if(((Estudiante) Menu.getUsuario()).getInscripciones().size()<1){
						throw new Exception("Usted no cuenta con una escolaridad");
					}
					PanelReportesEstudiante.estudianteSeleccionado=(Estudiante) Menu.getUsuario();
					
					PanelReportesEstudiante ventana=new PanelReportesEstudiante();
					panelDinamico.removeAll();
					panelDinamico.add(ventana);
					panelDinamico.setPreferredSize(new Dimension(700,500));
					panelDinamico.revalidate();
					panelDinamico.repaint();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		
		
		menuUsuario.add(buttonReportes);

		
	}
	
	
	
	public void initUIAnalista() {
		 datosComunes();
	
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
	
	}
	
	
	public void datosComunes() {
		removeAll();
		setLayout(null);
		setBounds(0,0,955, 725);

		menuUsuario = new JPanel();
		panelDinamico = new JPanel();

		menuUsuario.setBounds(0, 0, 246, 725);
		menuUsuario.setBackground(new Color(177, 192, 207));
		add(menuUsuario);
		menuUsuario.setLayout(null);
		
		RSLabelImage iconoUsuario = new RSLabelImage();
		iconoUsuario.setIcon(new ImageIcon(Menu.class.getResource("/com/vistas/img/LogoDeUsuario.png")));
		iconoUsuario.setBounds(46, 30, 154, 154);
		menuUsuario.add(iconoUsuario);
		
		JLabel lblNombreUsuario = new JLabel("NOMBRE USUARIO");
		lblNombreUsuario.setText((Menu.getUsuario().getNombre1()+" "+Menu.getUsuario().getApellido1()).toUpperCase());
		lblNombreUsuario.setForeground(new Color(59, 168, 231));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblNombreUsuario.setBounds(10, 194, 227, 30);
		menuUsuario.add(lblNombreUsuario);
		
		RSLabelTextIcon lbltxtcnEditarPerfil = new RSLabelTextIcon();
        lbltxtcnEditarPerfil.setText("Editar Perfil");
        lbltxtcnEditarPerfil.setIcons(ICONS.ACCOUNT_BOX);
        lbltxtcnEditarPerfil.setBounds(46, 235, 155, 40);
        lbltxtcnEditarPerfil.addMouseListener(new MouseAdapter() {
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
                lbltxtcnEditarPerfil.setForeground(Color.BLUE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                lbltxtcnEditarPerfil.setForeground(new Color(27, 91, 124));

            }

        });
        menuUsuario.add(lbltxtcnEditarPerfil);
		
        RSLabelTextIcon lbltxtcnCerrarSesin = new RSLabelTextIcon();
        lbltxtcnCerrarSesin.setText("Cerrar Sesión");
        lbltxtcnCerrarSesin.setIcons(ICONS.EXIT_TO_APP);
        lbltxtcnCerrarSesin.setBounds(46, 630, 180, 40);
        lbltxtcnCerrarSesin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Menu.setUsuario(null);
                Menu.getInstancia().setVisible(false);

                Login log=new Login();
                log.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbltxtcnCerrarSesin.setForeground(Color.BLUE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                lbltxtcnCerrarSesin.setForeground(new Color(27, 91, 124));

            }
        });
        menuUsuario.add(lbltxtcnCerrarSesin);
		
		panelDinamico.setBounds(245, 0, 700, 725);
		add(panelDinamico);
		panelDinamico.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("SISTEMA DE GESTIÃ“N");
		lblNewLabel_2_1.setForeground(new Color(58, 69, 75));
		lblNewLabel_2_1.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(247, 24, 206, 27);
		panelDinamico.add(lblNewLabel_2_1);
		
		RSLabelImage labelImage_1 = new RSLabelImage();
		labelImage_1.setIcon(new ImageIcon(PanelMenu.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage_1.setBounds(646, 11, 51, 53);
		panelDinamico.add(labelImage_1);
		
		
	}
}
