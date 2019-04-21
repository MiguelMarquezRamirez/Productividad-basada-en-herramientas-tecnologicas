package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Conexion {
	
Connection conect = null;
Connection conn = null;

	public Connection conexionDB()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conect = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","mmrqs1");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","mmrqs1");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error " + e);
		}
		return conect;
	}
	
	public Conexion() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","mmrqs1");
			if (conn != null) {
				
			}
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Error " + e);
			System.out.println(e);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	
	public ResultSet consulta(String sql) {
		ResultSet res = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,  "Error en la Consulta " + e);
			System.err.println("Error en la Consulta :" + e.getMessage());
		}
		return res;
	}
	
	
	public DefaultComboBoxModel Obt_Prospecto() {
		DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
		ListaModelo.addElement("Seleccione un Prospecto");
		ResultSet res = this.consulta("Select * From Prospectos Order By Prospecto");
		
		try {
			while(res.next()) {
				ListaModelo.addElement(res.getString("Prospecto"));

			}
			res.close();
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return ListaModelo;
	}
	
	
	public DefaultComboBoxModel Obt_Vendedor() {
		DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
		ListaModelo.addElement("Seleccione un Vendedor");
		ResultSet res = this.consulta("Select * From Vendedores Order By Nom_Vendedor");
		
		try {
			while(res.next()) {
				ListaModelo.addElement(res.getString("Nom_Vendedor"));
			}
			res.close();
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return ListaModelo;
	}
	
	
}
