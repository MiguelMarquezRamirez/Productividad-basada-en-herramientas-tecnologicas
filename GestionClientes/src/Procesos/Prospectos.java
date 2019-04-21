package Procesos;
//import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//import java.awt.Panel;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.JLayeredPane;
//import javax.swing.JOptionPane;
//import javax.swing.JInternalFrame;
//import javax.swing.JDesktopPane;
//import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import ConexionBD.Conexion;
import classDAO.ProspectosDAO;
import classVO.ProspectosVO;

import java.sql.*;
//import java.util.logging.*;
//import javax.swing.border.LineBorder;
//import java.awt.Color;
//import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



@SuppressWarnings("serial")
public class Prospectos extends JDialog {
	
	DefaultTableModel model;
	
	private JTextField txtContacto;
	private JTextField txtEmpresa;
	private JTextField txtCargo;
	private JTextField txtTelefono;
	private JTextField txtCorreo;

	
	/**
	 * Create the dialog.
	 */
	public Prospectos() {
		setResizable(false);
	
		cargar("");
		
		setTitle("Registro de Prospectos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Prospecto.png"));
		setBounds(100, 100, 771, 618);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 200);
		panel.setToolTipText("dddd");
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contacto");
		lblNewLabel.setBounds(10, 31, 46, 14);
		panel.add(lblNewLabel);
		
		txtContacto = new JTextField();
		txtContacto.setBounds(80, 28, 298, 20);
		panel.add(txtContacto);
		txtContacto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Empresa");
		lblNewLabel_1.setBounds(10, 62, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(80, 59, 298, 20);
		panel.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		lblNewLabel_2.setBounds(10, 93, 46, 14);
		panel.add(lblNewLabel_2);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(80, 90, 200, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(10, 124, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(80, 121, 124, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo Electronico");
		lblNewLabel_4.setBounds(10, 155, 95, 14);
		panel.add(lblNewLabel_4);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(110, 152, 268, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(545, 542, 99, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ProspectosVO prosp = new ProspectosVO();
				prosp.setProspecto(txtEmpresa.getText());
				prosp.setContacto(txtContacto.getText());
				prosp.setCargo(txtCargo.getText());
				prosp.setTelefono(txtTelefono.getText());
				prosp.setCorreoElectronico(txtCorreo.getText());
				
				String resp = ProspectosDAO.registrarProspectos(prosp);
				
				txtStatus.setText(resp);
				
				txtEmpresa.setText("");
				txtContacto.setText("");
				txtCargo.setText("");
				txtTelefono.setText("");
				txtCorreo.setText("");
				
				cargar("");
				
				/*
				String contacto, empresa, cargo, telefono, correo;
				String sSQL = "";
				
				contacto = txtContacto.getText();
				empresa = txtEmpresa.getText();
				cargo = txtCargo.getText();
				telefono = txtTelefono.getText();
				correo = txtCorreo.getText();
				
				
				sSQL = "Insert Into Prospectos (Prospecto, Contacto, cargo, telefono, correoElectronico) Values (?,?,?,?,?)";
				
				try {
					PreparedStatement pst = cn.prepareStatement(sSQL);
					pst.setString(1, empresa); 
					pst.setString(2, contacto);
					pst.setString(3, cargo);
					pst.setString(4, telefono);
					pst.setString(5, correo);
					int n = pst.executeUpdate();
					if (n>0) {
						JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
						bloquear();
					}
					
					cargar("");
				} catch (SQLException ex) {
					Logger.getLogger(Prospectos.class.getName()).log(Level.SEVERE,  null,  ex);
				}
				*/
			}
		});
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Guardar.png"));
		getContentPane().add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(654, 542, 101, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
				
			}
		});
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Salir.png"));
		getContentPane().add(btnSalir);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(10, 225, 414, 20);
		getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 271, 745, 260);
		getContentPane().add(scrollPane);
		
		tbProspectos = new JTable();
		tbProspectos.setColumnSelectionAllowed(true);
		scrollPane.setColumnHeaderView(tbProspectos);
		
		
		//bloquear();
		cargar("");
	}
	
	
	void bloquear() {
		txtContacto.setEnabled(false);
		txtEmpresa.setEnabled(false);
		txtTelefono.setEnabled(false); 
		txtCargo.setEnabled(false);
		txtCorreo.setEnabled(false);
	}
	
	void limpiar() {
		txtContacto.setText("");
		txtEmpresa.setText("");
		txtTelefono.setText("");
		txtCargo.setText("");
		txtCorreo.setText("");
	}
	
	void desbloquear() {
		txtContacto.setEnabled(true);
		txtEmpresa.setEnabled(true);
		txtTelefono.setEnabled(true); 
		txtCargo.setEnabled(true);
		txtCorreo.setEnabled(true);
	}
	
	void cargar(String valor) {
		try {
			String[] titulos = {"Empresa", "Contacto", "Cargo", "Telefono", "Correo Electronico"};
			String [] registros = new String[5];
			model = new DefaultTableModel(null,titulos);
			
			//model.addColumn("Empresa");
			//model.addColumn("Contacto");
			//model.addColumn("Cargo");
			//model.addColumn("Telefono");
			//model.addColumn("Correo");
			
			String cons = "Select Prospecto, contacto, Cargo, Telefono, CorreoElectronico From Prospectos Where Concat (Prospecto, '',Contacto) Like '%"+valor+"%'";
			//String cons = "Select Prospecto, Contacto, Cargo, Telefono, CorreoElectronico From Prospectos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(cons);
			
			while(rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				registros[2] = rs.getString(3);
				registros[3] = rs.getString(4);
				registros[4] = rs.getString(5);
				
				model.addRow(registros);
			}
			
			tbProspectos.setModel(model);
			tbProspectos.getColumnModel().getColumn(0).setPreferredWidth(200);
			tbProspectos.getColumnModel().getColumn(1).setPreferredWidth(120);
			tbProspectos.getColumnModel().getColumn(2).setPreferredWidth(100);
			tbProspectos.getColumnModel().getColumn(3).setPreferredWidth(80);
			tbProspectos.getColumnModel().getColumn(4).setPreferredWidth(100);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	Conexion cc = new Conexion();
	Connection cn = cc.conexionDB();
	private JTextField txtStatus;
	private JTable tbProspectos;
}
