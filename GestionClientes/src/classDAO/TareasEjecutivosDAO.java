package classDAO;

import classVO.TareasEjecutivosVO;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

public class TareasEjecutivosDAO {
	
	@SuppressWarnings("resource")
	public static String registrarTareasEjecutivos(TareasEjecutivosVO tareaejecutivo) {
		String result = null, last = null;
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		
		String sql = "Insert Into TareasEjecutivos (idTareas, Vendedor, Tarea, Prospecto, Fecha, FechaTarea, Observaciones) values(null,?,?,?,?,?,?)";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, tareaejecutivo.getVendedor());
			pst.setString(2, tareaejecutivo.getTarea());
			pst.setString(3, tareaejecutivo.getProspecto());
			pst.setString(4, tareaejecutivo.getFecha());
			pst.setString(5, tareaejecutivo.getFechatarea());
			pst.setString(6, tareaejecutivo.getObservaciones());
			pst.execute();
			pst = cn.prepareStatement("Select MAX(idTareas) AS id From TareasEjecutivos");
			
			ResultSet rs = pst.executeQuery();  
			
			if(rs.next()) {
				last = rs.getString(1);
			}
			result = "Tarea Ejecutivo registrada con exito, TAREA_EJECUTIVO :" + last;
			
			
			
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

}
