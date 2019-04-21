package main;


public class DatosUsuario {
	String usuario1 = "";
	String pass1 = "";
	
	public int probarPass() {
		usuario1 = Login.txtUsuario.getText();
		pass1 = Login.pssContrasena.getText();
		
		if(usuario1.equals("admin") && pass1.equals("gclientes")) {
			return 1;
		}
		else
			return 0;
	}

}
