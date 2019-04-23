package classDAO;

import classVO.AsignacionProspectoVO;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;


public class AsignacionProspectosDAO {
	
	@SuppressWarnings("resource")
	public static String registrarAsignacionProspectos(AsignacionProspectoVO asignaprosp) {
	
		String result = null, last = null;
		ConexionBD cc = new ConexionBD();
		Connection cn = cc.getConnection();
		PreparedStatement pst = null;
		
		String sql = "Insert Into AsignacionProspectos (idAsignacion, Prospecto, Vendedor) values(null,?,?)";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, asignaprosp.getProspecto());
			pst.setString(2, asignaprosp.getVendedor());
			pst.execute();
			pst = cn.prepareStatement("Select MAX(idAsignacion) AS id From AsignacionProspectos");
		
			
			ResultSet rs = pst.executeQuery();  
			
			if(rs.next()) {
				last = rs.getString(1);
			}
			result = "Asignacion de Prospecto registrado con exito, Asignacion_PROSPECTO :" + last;
						
			
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
