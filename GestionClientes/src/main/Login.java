package main;

//import java.awt.BorderLayout;
//import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
//import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtUsuario;
	public static JPasswordField pssContrasena;

	
	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Acceso al Sistema");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/Acceso.png")));
		setBounds(100, 100, 428, 296);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 434, 10);
			getContentPane().add(panel);
		}
		
		JLabel lblNewLabel = new JLabel("Capture el nombre del usuario y su clave de");
		lblNewLabel.setBounds(140, 21, 223, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Acceso.");
		lblNewLabel_1.setBounds(140, 46, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(45, 126, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Clave de acceso");
		lblNewLabel_3.setBounds(45, 166, 100, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(155, 123, 242, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Login.png")));
		lblNewLabel_4.setBounds(27, 33, 56, 56);
		getContentPane().add(lblNewLabel_4);
		
				
		final DatosUsuario data = new DatosUsuario();		
		final Clientes window2 = new Clientes();
		
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(data.probarPass()==1) {
					JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
					window2.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error, favor de verificar sus datos" );
				}
				
				
			}
		});
		btnAceptar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Aceptar.png")));
		btnAceptar.setBounds(191, 216, 100, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Salir.png")));
		btnSalir.setBounds(302, 216, 100, 23);
		getContentPane().add(btnSalir);
		
		pssContrasena = new JPasswordField();
		pssContrasena.setBounds(155, 163, 242, 20);
		getContentPane().add(pssContrasena);
	}
}
