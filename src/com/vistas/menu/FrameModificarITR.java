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

public class FrameModificarITR extends JFrame {

	private JPanel contentPane;
	public static ITR itr;
	private DefaultComboBoxModel modeloDep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModificarITR frame = new FrameModificarITR();
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
	public FrameModificarITR() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameModificarITR.class.getResource("/com/vistas/img/UTEC.png")));
		setTitle("Modificar ITR");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 325, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarItr = new JLabel("MODIFICAR ITR");
		lblModificarItr.setForeground(new Color(58, 69, 75));
		lblModificarItr.setFont(new Font("Lato Black", Font.PLAIN, 17));
		lblModificarItr.setBounds(91, 18, 128, 25);
		contentPane.add(lblModificarItr);
		
		RSLabelImage labelImage = new RSLabelImage();
		labelImage.setIcon(new ImageIcon(FrameModificarITR.class.getResource("/com/vistas/img/UTEC.png")));
		labelImage.setBounds(264, 10, 37, 38);
		contentPane.add(labelImage);
		
		JLabel lblIngresarNombre = new JLabel("Nombre");
		lblIngresarNombre.setFont(new Font("Lato", Font.PLAIN, 11));
		lblIngresarNombre.setBounds(10, 60, 85, 13);
		contentPane.add(lblIngresarNombre);
		
		RSTextFieldIconUno textFieldNombreUno = new RSTextFieldIconUno();
		textFieldNombreUno.setBorderColor(new Color(52, 152, 219));
		textFieldNombreUno.setPlaceholder("Ingresar Nombre");
		textFieldNombreUno.setText(itr.getNombre());
		textFieldNombreUno.setIcons(ICONS.BUSINESS);
		textFieldNombreUno.setBounds(10, 76, 291, 36);
		contentPane.add(textFieldNombreUno);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Lato", Font.PLAIN, 11));
		lblDepartamento.setBounds(10, 122, 85, 13);
		contentPane.add(lblDepartamento);
		
		RSComboBox comboBox = new RSComboBox();
		comboBox.setColorBoton(Color.WHITE);
		comboBox.setColorFondo(new Color(52, 152, 219));
		modeloDep=new DefaultComboBoxModel();
		comboBox.setModel(modeloDep);
		comboBox.setBounds(10, 138, 291, 36);
		contentPane.add(comboBox);
		try {
			cargarCombo();
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboBox.setSelectedItem(itr.getDepartamento().getNombre());
		
		RSButtonHover btnhvrCancelar = new RSButtonHover();
		btnhvrCancelar.setText("Cancelar");
		btnhvrCancelar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrCancelar.setBackground(new Color(52, 152, 219));
		btnhvrCancelar.setBounds(10, 200, 98, 30);
		contentPane.add(btnhvrCancelar);
		
		RSButtonHover btnhvrModificar = new RSButtonHover();
		btnhvrModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					itr.setDepartamento(DAOGeneral.DepRemote.obtenerDepPorNombre(comboBox.getSelectedItem().toString()));
					itr.setNombre(textFieldNombreUno.getText());
					DAOGeneral.itrRemote.actualizarITR(itr);
					MantenimientoListadoITR.getInstancia().cargarTabla(DAOGeneral.itrRemote.obtenerItrs());
					PanelGestionUsuarios.getInstancia().cargarComboBox();
					JOptionPane.showMessageDialog(null, "Se realizo correctamente la modificacion del itr ", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnhvrModificar.setText("Modificar");
		btnhvrModificar.setFont(new Font("Lato", Font.BOLD, 14));
		btnhvrModificar.setBackground(new Color(52, 152, 219));
		btnhvrModificar.setBounds(203, 200, 98, 30);
		contentPane.add(btnhvrModificar);
	}
	
	public void cargarCombo() throws ServicesException {
		modeloDep.removeAllElements();
		modeloDep.addElement("");
		for(Departamento d:DAOGeneral.DepRemote.obtenerDepartamento()) {
			modeloDep.addElement(d.getNombre());
		}
	}
}