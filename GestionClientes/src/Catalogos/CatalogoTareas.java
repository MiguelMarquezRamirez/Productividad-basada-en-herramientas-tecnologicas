package Catalogos;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexionBD.Conexion;

import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CatalogoTareas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	private JPanel contentPane;
	private JTable tbTareas;


	/**
	 * Create the frame.
	 */
	public CatalogoTareas() {
		setResizable(false);
		setTitle("Catalogo de Tareas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CatalogoTareas.class.getResource("/Imagenes/Tareas2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 278, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tbTareas = new JTable();
		tbTareas.setBounds(10, 32, 254, 170);
		panel.add(tbTareas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(CatalogoTareas.class.getResource("/Imagenes/Salir.png")));
		btnSalir.setBounds(178, 235, 110, 23);
		contentPane.add(btnSalir);
		
		CargarDatos("");
	}
	
	
	void CargarDatos(String valor) {
		try {
			String[] titulos = {"Clave", "Tarea"};
			String [] registros = new String[2];
			model = new DefaultTableModel(null,titulos);
			
			
			String cons = "Select IdTarea, Tarea From Tareas";
	
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(cons);
			
			while(rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				
				model.addRow(registros);
			}
			
			tbTareas.setModel(model);
			tbTareas.getColumnModel().getColumn(0).setPreferredWidth(70);
			tbTareas.getColumnModel().getColumn(1).setPreferredWidth(180);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	Conexion cc = new Conexion();
	Connection cn = cc.conexionDB();


}
