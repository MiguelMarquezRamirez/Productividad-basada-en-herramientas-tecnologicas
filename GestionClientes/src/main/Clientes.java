package main;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Procesos.Prospectos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Clientes extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Clientes1.png"));
		setTitle("Sistema de Gesti\u00F3n de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 580, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Catalogos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmVendedores = new JMenuItem("Vendedores");
		mntmVendedores.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Clientes2.png"));
		mnNewMenu.add(mntmVendedores);
		
		JMenuItem mntmTareas = new JMenuItem("Tareas");
		mntmTareas.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Tareas.png"));
		mnNewMenu.add(mntmTareas);
		
		JMenu mnNewMenu_1 = new JMenu("Procesos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Asignaciones");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AsignacionProspecto Asignaprosp = new AsignacionProspecto();
				Asignaprosp.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Prospectos");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Prospectos.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prospectos prosp = new Prospectos();
				prosp.setVisible(true);
				  
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Herramientas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmUsuariosDelSistema = new JMenuItem("Usuarios del Sistema");
		mntmUsuariosDelSistema.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Usuarios.png"));
		mnNewMenu_2.add(mntmUsuariosDelSistema);
		
		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mnNewMenu_2.add(mntmConsultas);
		
		JMenu mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);
		
		JMenu menu = new JMenu("New menu");
		mnNewMenu_3.add(menu);
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalirDelSistema = new JMenuItem("Salir del Sistema");
		mntmSalirDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalirDelSistema.setIcon(new ImageIcon("C:\\Users\\Miguel\\eclipse-workspace\\GestionClientes\\Imagenes\\16x12\\Salida.png"));
		mnSalir.add(mntmSalirDelSistema);
	}
}
