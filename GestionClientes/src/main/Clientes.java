package main;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Catalogos.CatalogoTareas;
import Catalogos.CatalogoVendedores;
import Procesos.Prospectos;
import Procesos.TareasEjecutivos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

public class Clientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Clientes() {
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/Imagenes/Clientes1.png")));
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
		mntmVendedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				final CatalogoVendedores window3 = new CatalogoVendedores();
				window3.setVisible(true);
				
			}
		});
		mntmVendedores.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Clientes2.png")));
		mnNewMenu.add(mntmVendedores);
		
		JMenuItem mntmTareas = new JMenuItem("Tareas");
		mntmTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final CatalogoTareas window4 = new CatalogoTareas();
				window4.setVisible(true);

			}
		});
		mntmTareas.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Tareas.png")));
		mnNewMenu.add(mntmTareas);
		
		JMenu mnNewMenu_1 = new JMenu("Procesos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Asignaciones");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Tareas1.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AsignacionProspecto Asignaprosp = new AsignacionProspecto();
				Asignaprosp.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Prospectos");
		mntmNewMenuItem.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Prospectos.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prospectos prosp = new Prospectos();
				prosp.setVisible(true);
				  
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmTareasPorEjecutivo = new JMenuItem("Tareas por Ejecutivo");
		mntmTareasPorEjecutivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TareasEjecutivos TareaVend = new TareasEjecutivos();
				TareaVend.setVisible(true);
				
				
				
				
			}
		});
		mntmTareasPorEjecutivo.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Clientes2.png")));
		mnNewMenu_1.add(mntmTareasPorEjecutivo);
		
		JMenu mnNewMenu_2 = new JMenu("Herramientas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmUsuariosDelSistema = new JMenuItem("Usuarios del Sistema");
		mntmUsuariosDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "En Desarrollo para la FASE 2....");
				
			}
		});
		mntmUsuariosDelSistema.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Usuarios.png")));
		mnNewMenu_2.add(mntmUsuariosDelSistema);
		
		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "En Desarrollo para la FASE 2....");
				
			}
		});
		mntmConsultas.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Consulta.png")));
		mnNewMenu_2.add(mntmConsultas);
		
		JMenu mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalirDelSistema = new JMenuItem("Salir del Sistema");
		mntmSalirDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalirDelSistema.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/Salida.png")));
		mnSalir.add(mntmSalirDelSistema);
	}
}
