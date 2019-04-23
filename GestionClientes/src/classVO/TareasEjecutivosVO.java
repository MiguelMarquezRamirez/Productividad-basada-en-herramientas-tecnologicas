package classVO;

//import java.sql.Date;

public class TareasEjecutivosVO {
	private String vendedor;
	private String tarea;
	private String prospecto;
	private String fecha;
	private String fechatarea;
	private String observaciones;
	private String resultado;
	
	
	public String getVendedor() {
		return vendedor;
	}
	
	
	public String getProspecto() {
		return prospecto;
	}


	public void setProspecto(String prospecto) {
		this.prospecto = prospecto;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	
	public String getTarea() {
		return tarea;
	}
	
	
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	
	
	public String getFecha() {
		return fecha;
	}
	
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	public String getFechatarea() {
		return fechatarea;
	}
	
	
	public void setFechatarea(String fechatarea) {
		this.fechatarea = fechatarea;
	}
	
	
	public String getObservaciones() {
		return observaciones;
	}
	
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	public String getResultado() {
		return resultado;
	}
	
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	

}
