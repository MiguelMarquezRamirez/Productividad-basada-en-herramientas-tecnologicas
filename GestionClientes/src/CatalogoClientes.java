import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatalogoClientes extends JFrame {


	/**
	 * Create the frame.
	 */
	public CatalogoClientes() {
		setTitle("Catalogo de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 328, 107);
		getContentPane().add(panel);
	}
}
