package Catalogos;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexionBD.Conexion;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CatalogoVendedores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DefaultTableModel model;
	private JPanel contentPane;
	private JTable tbVendedores;


	/**
	 * Create the frame.
	 */
	public CatalogoVendedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CatalogoVendedores.class.getResource("/Imagenes/Prospectos.png")));
		setTitle("Catalogo de Vendedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 414, 186);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tbVendedores = new JTable();
		tbVendedores.setBounds(20, 26, 384, 138);
		panel.add(tbVendedores);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(CatalogoVendedores.class.getResource("/Imagenes/Salir.png")));
		btnSalir.setBounds(314, 227, 110, 23);
		contentPane.add(btnSalir);
		
		CargarDatos("");
	}
	
	
	void CargarDatos(String valor) {
		try {
			String[] titulos = {"Clave", "Nombre del Vendedor"};
			String [] registros = new String[2];
			model = new DefaultTableModel(null,titulos);

						
			model.addColumn("Vendedor");
			model.addColumn("Nombre del Vendedor");
			
			String cons = "Select Cve_Vendedor, Nom_Vendedor From Vendedores";
	
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(cons);
			
			while(rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				
				model.addRow(registros);
			}
			
			tbVendedores.setModel(model);
			tbVendedores.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbVendedores.getColumnModel().getColumn(1).setPreferredWidth(350);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	Conexion cc = new Conexion();
	Connection cn = cc.conexionDB();

}
