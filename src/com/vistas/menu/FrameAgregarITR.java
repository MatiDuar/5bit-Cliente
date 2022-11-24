package com.vistas.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controlador.DAOGeneral;
import com.entities.Departamento;
import com.entities.ITR;
import com.exception.ServicesException;

import RSMaterialComponent.RSTextFieldIconUno;
import rojeru_san.complementos.RSButtonHover;
import rojeru_san.efectos.ValoresEnum.ICONS;
import rojeru_san.rslabel.RSLabelImage;
import rojerusan.RSComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameAgregarITR extends JFrame {

	private JPanel contentPane;
	
	private DefaultComboBoxModel modeloDep;
	private RSTextFieldIconUno textNombre;
	private RSComboBox comboBoxDep;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarITR frame = new FrameAgregarITR();
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
	public FrameAgregarITR() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAgregarITR.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Agregar ITR");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 325, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloVentana = new JLabel("AGREGAR ITR");
		lblTituloVentana.setForeground(new Color(58, 69, 75));
		lblTituloVentana.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblTituloVentana.setBounds(100, 18, 154, 25);
		contentPane.add(lblTituloVentana);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(FrameAgregarITR.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(264, 10, 37, 38);
		contentPane.add(labelImage);
		
		textNombre = new RSTextFieldIconUno();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//El codigo 10 es el Enter
				if(e.getKeyCode()==10) {				
					try {
						guardarITR();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		textNombre.setBorderColor(new Color(52, 152, 219));
		textNombre.setIcons(ICONS.BUSINESS);
		textNombre.setPlaceholder("Ingresar Nombre");
		textNombre.setBounds(10, 76, 291, 36);
		contentPane.add(textNombre);
		
		JLabel lblIngresarNombre = new JLabel("Nombre");
		lblIngresarNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblIngresarNombre.setBounds(10, 60, 85, 13);
		contentPane.add(lblIngresarNombre);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 122, 85, 13);
		contentPane.add(lblDepartamento);
		
		comboBoxDep = new RSComboBox();
		comboBoxDep.setColorBoton(Color.WHITE);
		comboBoxDep.setColorFondo(new Color(52, 152, 219));
		modeloDep=new DefaultComboBoxModel();
		comboBoxDep.setModel(modeloDep);
		comboBoxDep.setBounds(10, 138, 291, 36);
		contentPane.add(comboBoxDep);
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(10, 200, 98, 30);
		contentPane.add(btnhvrCancelar);
		
		RSButtonHover btnhvrGuardar = new RSButtonHover();
		btnhvrGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					guardarITR();
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnhvrGuardar.setText("Guardar");
		btnhvrGuardar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrGuardar.setBackground(new Color(52, 152, 219));
		btnhvrGuardar.setBounds(203, 200, 98, 30);
		contentPane.add(btnhvrGuardar);
		
		try {
			cargarCombo();
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarCombo() throws ServicesException {
		modeloDep.removeAllElements();
		modeloDep.addElement("");
		for(Departamento d:DAOGeneral.DepRemote.obtenerDepartamento()) {
			modeloDep.addElement(d.getNombre());
		}
	}
	
	private void guardarITR() throws Exception {
		if(textNombre.getText().length()<1) {
			throw new Exception("Debe indicar un nombre de ITR");
		}
		if(comboBoxDep.getSelectedIndex()==0) {
			throw new Exception("Debe seleccionar un departamento");
		}

		if(DAOGeneral.itrRemote.obtenerItrPorNombre(textNombre.getText())!=null) {
			throw new Exception("El ITR espesificado ya esta registrado en el sistema");
		}
		int input = JOptionPane.showConfirmDialog(getParent(), "Estas seguro de crear el ITR", "Guardado...",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(input==0) {
			DAOGeneral.itrRemote.crearITR(textNombre.getText(),DAOGeneral.DepRemote.obtenerDepPorNombre(comboBoxDep.getSelectedItem().toString()), true);
			PanelGestionUsuarios.getInstancia().cargarComboBox();
			MantenimientoListadoITR.getInstancia().cargarTabla(MantenimientoListadoITR.getInstancia().filtrarITRActivo(DAOGeneral.itrRemote.obtenerItrs()));
			MantenimientoListadoITR.getInstancia().comboBoxEstadoITR.setSelectedIndex(0);
			JOptionPane.showMessageDialog(null, "Se creo correctamente el ITR.", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		}
	}
}
