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
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import ConexionBD.Conexion;
//import classVO.ProspectosVO;
//import conexion.ConexionBD;
//import ConexionBD.Conexion;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ConexionBD.Conexion;
import classDAO.AsignacionProspectosDAO;
import classVO.AsignacionProspectoVO;
import javax.swing.JTable;

public class AsignacionProspecto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	private JPanel contentPane;
	private Conexion Con = new Conexion();
	private JTextField txtProspecto;
	private JTextField txtVendedor;
	private JTextField txtStatus;
	private JTable tbAsignaciones;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AsignacionProspecto() {
			
		setResizable(false);
		cargar("");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AsignacionProspecto.class.getResource("/Imagenes/Prospecto.png")));
		setTitle("Asignacion de Prospectos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prospecto");
		lblNewLabel.setBounds(20, 30, 64, 14);
		contentPane.add(lblNewLabel);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbProspectos = new JComboBox();
		cmbProspectos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtProspecto.setText(cmbProspectos.getSelectedItem().toString());
			}
		});
		cmbProspectos.setBounds(94, 27, 281, 20);
		contentPane.add(cmbProspectos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 74, 461, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ejecutivo de Ventas");
		lblNewLabel_1.setBounds(10, 25, 128, 14);
		panel.add(lblNewLabel_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbVendedores = new JComboBox();
		cmbVendedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				txtVendedor.setText(cmbVendedores.getSelectedItem().toString());
			}
		});
		cmbVendedores.setBounds(136, 22, 315, 20);
		panel.add(cmbVendedores);
		
		JCheckBox chkNotificacion = new JCheckBox("Enviar Correo Electronico de Notificacion al Vendedor");
		chkNotificacion.setBounds(10, 67, 330, 23);
		panel.add(chkNotificacion);
		
		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignacionProspectoVO asignaprosp = new AsignacionProspectoVO();
				
				asignaprosp.setProspecto(txtProspecto.getText());
				asignaprosp.setVendedor(txtVendedor.getText());
								
				String resp = AsignacionProspectosDAO.registrarAsignacionProspectos(asignaprosp);
				
				txtStatus.setText(resp);
				
				txtProspecto.setText("");
				txtVendedor.setText("");

				cargar("");
				
			}
		});
		btnAceptar.setIcon(new ImageIcon(AsignacionProspecto.class.getResource("/Imagenes/Guardar.png")));
		btnAceptar.setBounds(244, 417, 100, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(AsignacionProspecto.class.getResource("/Imagenes/Cancelar.png")));
		btnCancelar.setBounds(361, 417, 110, 23);
		contentPane.add(btnCancelar);
		
		
		cmbProspectos.setModel(Con.Obt_Prospecto());
		cmbVendedores.setModel(Con.Obt_Vendedor());
	
		txtVendedor = new JTextField();
		txtVendedor.setBounds(365, 53, 86, 20);
		panel.add(txtVendedor);
		txtVendedor.setColumns(10);
		txtVendedor.setVisible(false);
		
		txtProspecto = new JTextField();
		txtProspecto.setBounds(385, 27, 86, 20);
		contentPane.add(txtProspecto);
		txtProspecto.setColumns(10);
		txtProspecto.setVisible(false);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(10, 196, 461, 20);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 227, 461, 179);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tbAsignaciones = new JTable();
		tbAsignaciones.setBounds(10, 11, 441, 157);
		panel_1.add(tbAsignaciones);
		
		cargar("");
		 
	}
	
	
	void cargar(String valor) {
		try {
			String[] titulos = {"Prospecto", "Vendedor"};
			String [] registros = new String[2];
			model = new DefaultTableModel(null,titulos);
			
			
			String cons = "Select Prospecto, Vendedor From AsignacionProspectos";
	
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(cons);
			
			while(rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				
				model.addRow(registros);
			}
			
			tbAsignaciones.setModel(model);
			tbAsignaciones.getColumnModel().getColumn(0).setPreferredWidth(200);
			tbAsignaciones.getColumnModel().getColumn(1).setPreferredWidth(120);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	Conexion cc = new Conexion();
	Connection cn = cc.conexionDB();

}
