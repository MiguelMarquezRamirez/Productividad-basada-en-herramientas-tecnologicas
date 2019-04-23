package Procesos;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JComboBox;
//import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import ConexionBD.Conexion;
import classDAO.TareasEjecutivosDAO;
import classVO.TareasEjecutivosVO;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import javax.swing.JTable;

public class TareasEjecutivos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	private JPanel contentPane;
	private JTextField txtObservaciones;
	private Conexion Con = new Conexion();
	private JTextField txtVendedor;
	private JTextField txtTarea;
	
	private JTextField txtStatus;
	private JTextField txtFecha;
	private JTextField txtFechaTarea;
	private JTable tbTareas;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public TareasEjecutivos() {
		setResizable(false);
		setTitle("Asignacion de Tareas a Ejecutivos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TareasEjecutivos.class.getResource("/Imagenes/Tareas1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 963, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vendedor");
		lblNewLabel.setBounds(20, 24, 86, 14);
		panel.add(lblNewLabel);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbVendedores = new JComboBox();
		cmbVendedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtVendedor.setText(cmbVendedores.getSelectedItem().toString());
			}
		});
		cmbVendedores.setBounds(138, 21, 297, 20);
		panel.add(cmbVendedores);
		
		JLabel lblNewLabel_1 = new JLabel("Tarea Asignada");
		lblNewLabel_1.setBounds(519, 24, 96, 14);
		panel.add(lblNewLabel_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbTareas = new JComboBox();
		cmbTareas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				txtTarea.setText(cmbTareas.getSelectedItem().toString());
			}
		});
		cmbTareas.setBounds(625, 21, 297, 20);
		panel.add(cmbTareas);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de la Tarea");
		lblNewLabel_2.setBounds(494, 80, 121, 14);
		panel.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.getCalendarButton().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
			}
		});
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		dateChooser.getCalendarButton().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				

			}
		});
		dateChooser.getCalendarButton().addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent arg0) {
				
				
			}
		});
		dateChooser.setBounds(625, 74, 129, 20);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Observaciones");
		lblNewLabel_3.setBounds(20, 128, 86, 14);
		panel.add(lblNewLabel_3);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(138, 125, 784, 20);
		panel.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Date fechaActual = new Date();
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				txtFechaTarea.setText(df.format(dateChooser.getDate()));
				txtFecha.setText(df.format(fechaActual));
				
				TareasEjecutivosVO tareaejecu = new TareasEjecutivosVO();
				tareaejecu.setVendedor(txtVendedor.getText());
				tareaejecu.setTarea(txtTarea.getText());
				tareaejecu.setProspecto(txtProspecto.getText());
				tareaejecu.setFecha(txtFecha.getText());
				tareaejecu.setFechatarea(txtFechaTarea.getText());
				tareaejecu.setObservaciones(txtObservaciones.getText());
								
				String resp = TareasEjecutivosDAO.registrarTareasEjecutivos(tareaejecu);
				
				txtStatus.setText(resp);
				
				txtVendedor.setText("");
				txtTarea.setText("");
				txtFecha.setText("");
				txtProspecto.setText("");
				txtFechaTarea.setText("");
				txtObservaciones.setText("");
				
				cargar("");

			}
		});
		btnAceptar.setIcon(new ImageIcon(TareasEjecutivos.class.getResource("/Imagenes/Guardar.png")));
		btnAceptar.setBounds(743, 467, 110, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TareasEjecutivos.class.getResource("/Imagenes/Cancelar.png")));
		btnCancelar.setBounds(863, 467, 110, 23);
		contentPane.add(btnCancelar);
		
		cmbVendedores.setModel(Con.Obt_Vendedor());
		cmbTareas.setModel(Con.Obt_Tarea());
		//cmbProspectos.setModel(Con.Obt_Prospectos());
		
		txtVendedor = new JTextField();
		txtVendedor.setBounds(194, 43, 86, 20);
		panel.add(txtVendedor);
		txtVendedor.setColumns(10);
		txtVendedor.setVisible(false);
		
		txtTarea = new JTextField();
		txtTarea.setBounds(625, 43, 86, 20);
		panel.add(txtTarea);
		txtTarea.setColumns(10);
		txtTarea.setVisible(false);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(759, 74, 86, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		txtFecha.setVisible(false);
		
		txtFechaTarea = new JTextField();
		txtFechaTarea.setBounds(855, 74, 86, 20);
		panel.add(txtFechaTarea);
		txtFechaTarea.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Prospecto");
		lblNewLabel_4.setBounds(20, 77, 86, 14);
		panel.add(lblNewLabel_4);
		
		@SuppressWarnings("rawtypes")
		JComboBox cmbProspectos = new JComboBox();
		cmbProspectos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				txtProspecto.setText(cmbProspectos.getSelectedItem().toString());
				
			} 
		});
		cmbProspectos.setBounds(138, 74, 293, 20);
		panel.add(cmbProspectos);
		
		txtProspecto = new JTextField();
		txtProspecto.setBounds(194, 94, 86, 20);
		panel.add(txtProspecto);
		txtProspecto.setColumns(10);
		txtProspecto.setVisible(false);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(10, 207, 963, 20);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 250, 963, 206);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tbTareas = new JTable();
		tbTareas.setBounds(10, 11, 943, 184);
		panel_1.add(tbTareas);
		txtFechaTarea.setVisible(false);
		
		cmbProspectos.setModel(Con.Obt_Prospecto());
		
		cargar("");
	}
	
	
	void cargar(String valor) {
		try {
			String[] titulos = {"Vendedor", "Tarea", "Prospecto", "Fecha Registro", "Fecha Tarea", "Observaciones"};
			String [] registros = new String[6];
			model = new DefaultTableModel(null,titulos);
			
			
			String cons = "Select Vendedor, Tarea, Prospecto, Fecha, FechaTarea, Observaciones From TareasEjecutivos";
	
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(cons);
			
			while(rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				registros[2] = rs.getString(3);
				registros[3] = rs.getString(4);
				registros[4] = rs.getString(5);
				registros[5] = rs.getString(6);
				
				model.addRow(registros);
			}
			
			tbTareas.setModel(model);
			tbTareas.getColumnModel().getColumn(0).setPreferredWidth(320);
			tbTareas.getColumnModel().getColumn(1).setPreferredWidth(220);
			tbTareas.getColumnModel().getColumn(2).setPreferredWidth(350);
			tbTareas.getColumnModel().getColumn(3).setPreferredWidth(120);
			tbTareas.getColumnModel().getColumn(4).setPreferredWidth(120);
			tbTareas.getColumnModel().getColumn(5).setPreferredWidth(400);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	Conexion cc = new Conexion();
	Connection cn = cc.conexionDB();
	private JTextField txtProspecto;
}
