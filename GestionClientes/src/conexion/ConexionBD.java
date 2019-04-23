package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.ArrayList;
//import javax.swing.DefaultComboBoxModel;




public class ConexionBD {
	Connection conectar = null;
	static Statement sentencia;
	static ResultSet resultado;
	
	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","mmrqs1");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public Connection getConnection() {
		return conectar;
	}
	
	
	public void desconectar() {
		conectar = null;
	}
	
	
	
	
    public static ArrayList<String> llenarCombo(){
        ArrayList<String> lista = new ArrayList<String>();
        String q = "Select * From Prospectos";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString("prospecto"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
