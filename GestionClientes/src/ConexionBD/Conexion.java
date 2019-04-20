package ConexionBD;

import java.sql.*;
import javax.swing.*;

public class Conexion {
Connection conect = null;

	public Connection conexionDB()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conect = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","mmrqs1");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error " + e);
		}
		return conect;
	}
}
