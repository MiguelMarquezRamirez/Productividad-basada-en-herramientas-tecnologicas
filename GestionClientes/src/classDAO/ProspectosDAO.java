package classDAO;

import classVO.ProspectosVO;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProspectosDAO {
	@SuppressWarnings("resource")
	public static String registrarProspectos(ProspectosVO prosp) {
		String result = null, last = null;
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		
		String sql = "Insert Into prospectos (idprospecto, prospecto, contacto, cargo, telefono, correoelectronico) values(null,?,?,?,?,?)";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, prosp.getProspecto());
			pst.setString(2, prosp.getContacto());
			pst.setString(3, prosp.getCargo());
			pst.setString(4, prosp.getTelefono());
			pst.setString(5, prosp.getCorreoElectronico());
			pst.execute();
			pst = cn.prepareStatement("Select MAX(idprospecto) AS id From Prospectos");
			
			ResultSet rs = pst.executeQuery();  
			
			if(rs.next()) {
				last = rs.getString(1);
			}
			result = "Prospecto registrado con exito, PROSPECTO :" + last;
			//result = "Prospecto registrado con exito, PROSPECTO :";
			
			
		}catch (SQLException e) {
			result = "Error en la consulta :" + e.getMessage();
		}finally {
			try {
			if(cn != null) {
				cn.close();
				pst.close();
			}
			}catch (Exception e) {
				result = "Error :" + e;
			}
		}
		return result;
	}

	

	@SuppressWarnings("resource")
	public static String actualizarProspectos(ProspectosVO prosp) {
		String result = null, last = null;
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		String sql = "Update prospectos Set Contacto=?, Cargo=?, Telefono=?, CorreoElectronico=? Where Prospecto=?";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, prosp.getProspecto());
			pst.setString(2, prosp.getContacto());
			pst.setString(3, prosp.getCargo());
			pst.setString(4, prosp.getTelefono());
			pst.setString(5, prosp.getCorreoElectronico());
			pst.execute();
			pst = cn.prepareStatement("Select MAX(prospecto) AS id From Prospectos");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				last = rs.getString(1);
			}
			result = "Prospecto registrado con exito, PROSPECTO :" + last;
			
			
		}catch (SQLException e) {
			result = "Error en la consulta :" + e.getMessage();
		}finally {
			try {
			if(cn != null) {
				cn.close();
				pst.close();
			}
			}catch (Exception e) {
				result = "Error :" + e;
			}
		}
		return result;
	}

	
	
	public static ProspectosVO buscarProspectos(String clave) {
		ProspectosVO prosp = new ProspectosVO();
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		String sql = "Select * From prospectos Where Prospecto=?";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, clave);
			ResultSet rs = pst.executeQuery();
						
			if(rs.next()) {
				prosp.setProspecto(rs.getString(1));
				prosp.setContacto(rs.getString(2));
				prosp.setCargo(rs.getString(3));
				prosp.setTelefono(rs.getString(4));
				prosp.setCorreoElectronico(rs.getString(5));
			}
			prosp.setResultado("Busqueda Exitosa");
						
		}catch (SQLException e) {
			prosp.setResultado("Error en la consulta :" + e.getMessage());
		}finally {
			try {
			if(cn != null) {
				cn.close();
				pst.close();
			}
			}catch (Exception e) {
				prosp.setResultado("Error :" + e);
			}
		}
		return prosp;
	}
	

	
	public static String eliminarProspectos(String clave) {
		String result = null;
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		String sql = "Delete From prospectos Where Prospecto=?";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, clave);
			pst.executeUpdate();
			result = "Prospecto eliminado con exito";
			
		}catch (SQLException e) {
			result = "Error en la consulta :" + e.getMessage();
		}finally {
			try {
			if(cn != null) {
				cn.close();
				pst.close();
			}
			}catch (Exception e) {
				result = "Error :" + e;
			}
		}
		return result;
	}
	
	
	public static ArrayList<ProspectosVO> getListProspectos(){
		ArrayList<ProspectosVO> arrProsp = new ArrayList<ProspectosVO>();
		
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		ProspectosVO prosp = null;
		String sql = "Select Prospecto, Contacto, Cargo, Telefono, CorreoElectronico From prospectos";
		
		try {
			pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
						
			while(rs.next()) {
				prosp = new ProspectosVO();
				prosp.setProspecto(rs.getString(1));
				prosp.setContacto(rs.getString(2));
				if(arrProsp.isEmpty()) {
					arrProsp.add(0, prosp);
				}else {
					arrProsp.add(prosp);
				}
			}
									
		}catch (SQLException e) {
			System.out.println("Error en la consulta :" + e.getMessage());
		}finally {
			try {
			if(cn != null) {
				cn.close();
				pst.close();
			}
			}catch (Exception e) {
				System.out.println("Error :" + e);
			}
		}
		return arrProsp;

		
	}

}
