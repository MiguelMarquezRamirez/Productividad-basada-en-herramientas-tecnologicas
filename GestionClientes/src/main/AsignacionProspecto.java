package main;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import ConexionBD.Conexion;
import classVO.ProspectosVO;
//import conexion.ConexionBD;
import ConexionBD.Conexion;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AsignacionProspecto extends JFrame {

	private JPanel contentPane;
	private Conexion Con = new Conexion();
	private JTextField txtProspecto;
	private JTextField txtVendedor;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AsignacionProspecto() {
			
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Prospecto.png"));
		setTitle("Asignacion de Prospectos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prospecto");
		lblNewLabel.setBounds(20, 30, 64, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox cmbProspectos = new JComboBox();
		cmbProspectos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtProspecto.setText(cmbProspectos.getSelectedItem().toString());
			}
		});
		cmbProspectos.setBounds(94, 27, 213, 20);
		contentPane.add(cmbProspectos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 74, 414, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ejecutivo de Ventas");
		lblNewLabel_1.setBounds(10, 25, 106, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox cmbVendedores = new JComboBox();
		cmbVendedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				txtVendedor.setText(cmbVendedores.getSelectedItem().toString());
			}
		});
		cmbVendedores.setBounds(126, 22, 259, 20);
		panel.add(cmbVendedores);
		
		JCheckBox chkNotificacion = new JCheckBox("Enviar Correo Electronico de Notificacion al Vendedor");
		chkNotificacion.setBounds(10, 67, 279, 23);
		panel.add(chkNotificacion);
		
		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Guardar.png"));
		btnAceptar.setBounds(207, 227, 100, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Cancelar.png"));
		btnCancelar.setBounds(324, 227, 110, 23);
		contentPane.add(btnCancelar);
		
		
		cmbProspectos.setModel(Con.Obt_Prospecto());
		cmbVendedores.setModel(Con.Obt_Vendedor());
	
		//cmbProspectos.setSelectedItem(txtProspecto);
		//txtProspecto.setText(cmbProspectos.getSelectedItem().toString());
		
		txtVendedor = new JTextField();
		txtVendedor.setBounds(299, 53, 86, 20);
		panel.add(txtVendedor);
		txtVendedor.setColumns(10);
		
		txtProspecto = new JTextField();
		txtProspecto.setBounds(318, 27, 86, 20);
		contentPane.add(txtProspecto);
		txtProspecto.setColumns(10);
		
		//txtProspecto.setText(cmbProspectos.getSelectedItem().toString());
		/*
		//ProspectosVO prosp = new ProspectosVO();
		//ConexionBD cc = new ConexionBD();
		//Connection cn = cc.getConnection();

		
		cmbProspectos.removeAllItems();
		ArrayList<String> lista = new ArrayList<String>();
		lista = ConexionBD.llenarCombo();
		for(int i = 0; i<lista.size();i++) {
			//cmbProspectos.addItem(Lista.get(i));
			cmbProspectos.addItem(lista.get(i));
		}
		*/
		 
	}
}
