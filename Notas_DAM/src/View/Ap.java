package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.Control;
import Model.Model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Ap extends JFrame {

	private JPanel contentPane;
	private JTable t_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTable t_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable t_4;
	private JTextField textField_4;
	private JTable t_5;
	private JTextField textField_5;
	private JTable t_6;
	private JTable t_7;
	private JTextField textField_6;
	private JTable t_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private Model model;
	private Control control;
	private DefaultTableModel dtm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ap frame = new Ap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ap() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
		/*Cargamos los datos de las tablas*/
		control.cargarMateriales("NOM_ALUM ", "Alumno","", (DefaultTableModel) t_1.getModel());
//		control.cargarMateriales ("Nom_Prof","Profesores","",(DefaultTableModel) t_2.getModel());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(1);
			}
		});
		btnSalir.setBackground(Color.RED);
		btnSalir.setForeground(Color.WHITE);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBackground(Color.BLUE);
		btnAtras.setEnabled(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(btnSalir)
						.addPreferredGap(ComponentPlacement.RELATED, 317, Short.MAX_VALUE).addComponent(btnAtras)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalir).addComponent(btnAtras))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(null);
		tabbedPane.addTab("Dar_De_Alta", null, panel, null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBorder(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		tabbedPane_1.addTab("Alumnos", null, panel_3, null);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblAlumnos = new JLabel("Alumnos:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBackground(Color.GREEN);
		btnCrear.setForeground(new Color(0, 0, 0));

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(Color.GREEN);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addGap(27)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addComponent(lblAlumnos)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup().addComponent(btnCrear).addGap(40)
								.addComponent(btnBorrar)))
				.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup().addGap(42)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAlumnos).addComponent(textField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(30).addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCrear).addComponent(btnBorrar))))
						.addContainerGap(29, Short.MAX_VALUE)));

		t_1 = new JTable();
		dtm=new DefaultTableModel(new Object[][] {}, new String[] { "Alumno" });
		t_1.setModel(dtm);
		scrollPane.setViewportView(t_1);
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		tabbedPane_1.addTab("Profesores", null, panel_4, null);

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblProfesores = new JLabel("Profesores");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnCrear_1 = new JButton("Crear");
		btnCrear_1.setBackground(Color.GREEN);

		JButton btnBorrar_1 = new JButton("Borrar");
		btnBorrar_1.setBackground(Color.GREEN);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_4.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup().addComponent(lblProfesores).addGap(18)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createSequentialGroup().addComponent(btnCrear_1).addGap(35)
										.addComponent(btnBorrar_1)))
						.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGap(31)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(scrollPane_1,
								GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup().addGap(43)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblProfesores)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18).addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCrear_1).addComponent(btnBorrar_1))))
						.addContainerGap(38, Short.MAX_VALUE)));

		t_2 = new JTable();
		t_2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Profesores" }));
		scrollPane_1.setViewportView(t_2);
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		tabbedPane_1.addTab("Modulos", null, panel_5, null);

		JLabel lblModulo = new JLabel("Modulo:");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();

		JButton btnCrear_2 = new JButton("Crear");
		btnCrear_2.setBackground(Color.GREEN);

		JButton btnBorrar_2 = new JButton("Borrar");
		btnBorrar_2.setBackground(Color.GREEN);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup().addComponent(lblModulo)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_2,
										GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup().addComponent(btnCrear_2).addGap(30)
								.addComponent(btnBorrar_2)))
				.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
				.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		gl_panel_5
				.setVerticalGroup(
						gl_panel_5
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup().addGroup(gl_panel_5
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_5.createSequentialGroup().addGap(29)
												.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblModulo).addComponent(textField_2,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnCrear_2).addComponent(btnBorrar_2)))
										.addGroup(gl_panel_5.createSequentialGroup().addContainerGap().addComponent(
												scrollPane_2, GroupLayout.PREFERRED_SIZE, 216,
												GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(36, Short.MAX_VALUE)));

		t_3 = new JTable();
		t_3.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Modulos" }));
		scrollPane_2.setViewportView(t_3);
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane_1,
				GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE)));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		tabbedPane_1.addTab("Clase", null, panel_2, null);

		JLabel lblAlumno = new JLabel("Alumno:");

		JLabel lblProfesor = new JLabel("Profesor:");

		JLabel lblModulo_1 = new JLabel("Modulo:");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JScrollPane scrollPane_3 = new JScrollPane();

		JButton btnCrear_3 = new JButton("Crear");
		btnCrear_3.setBackground(Color.GREEN);

		JButton btnBorrar_3 = new JButton("Borrar");
		btnBorrar_3.setBackground(Color.GREEN);

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblAlumno)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_3))
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblProfesor).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblModulo_1).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup().addComponent(btnCrear_3).addGap(18)
								.addComponent(btnBorrar_3)))
				.addGap(18).addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
				.addContainerGap()));
		gl_panel_2
				.setVerticalGroup(
						gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGap(24).addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblAlumno).addComponent(textField_3,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblProfesor).addComponent(textField_7,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblModulo_1).addComponent(textField_8,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnCrear_3).addComponent(btnBorrar_3)))
										.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(
												scrollPane_3, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
										.addContainerGap()));

		t_4 = new JTable();
		t_4.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Alumno", "Profesor", "Modulo" }));
		scrollPane_3.setViewportView(t_4);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		tabbedPane.addTab("Notas", null, panel_1, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBorder(null);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane_2,
				GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane_2,
				GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		tabbedPane_2.addTab("Poner_Notas_Alumnos", null, panel_6, null);

		JLabel lblAlumno_1 = new JLabel("Alumno:");

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton btnPoner = new JButton("Poner");
		btnPoner.setBackground(Color.GREEN);

		JLabel lblNota = new JLabel("Nota:");

		JButton btnBoarra = new JButton("Boarra");
		btnBoarra.setBackground(Color.GREEN);

		JScrollPane scrollPane_4 = new JScrollPane();

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_6.createSequentialGroup().addComponent(lblAlumno_1)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_4,
														GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_6.createSequentialGroup().addComponent(lblNota).addGap(18)
												.addComponent(textField_6))))
						.addGroup(gl_panel_6.createSequentialGroup().addGap(37).addComponent(btnPoner)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBoarra)))
						.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addGap(120)));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup().addGap(40)
								.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE).addComponent(lblAlumno_1)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(15)
								.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE).addComponent(lblNota)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE).addComponent(btnPoner)
										.addComponent(btnBoarra)))
						.addGroup(gl_panel_6.createSequentialGroup().addContainerGap().addComponent(scrollPane_4,
								GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(21, Short.MAX_VALUE)));

		t_5 = new JTable();
		t_5.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Alumno", "Nota" }));
		scrollPane_4.setViewportView(t_5);
		panel_6.setLayout(gl_panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(null);
		tabbedPane_2.addTab("Modulos", null, panel_7, null);

		JLabel lblModulo_2 = new JLabel("Modulo:");

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JScrollPane scrollPane_5 = new JScrollPane();

		JButton btnCrear_4 = new JButton("Crear");
		btnCrear_4.setBackground(Color.GREEN);

		JButton btnBorrar_4 = new JButton("Borrar");
		btnBorrar_4.setBackground(Color.GREEN);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_7
				.createSequentialGroup().addGap(23)
				.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup().addComponent(lblModulo_2).addGap(18)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup().addComponent(btnCrear_4).addGap(26)
								.addComponent(btnBorrar_4)))
				.addGap(18).addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
				.addGap(32)));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup().addGap(26).addComponent(scrollPane_5,
								GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup().addGap(43)
								.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModulo_2))
								.addGap(18)
								.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE).addComponent(btnCrear_4)
										.addComponent(btnBorrar_4))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		t_6 = new JTable();
		t_6.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Modulo", "Nota" }));
		scrollPane_5.setViewportView(t_6);
		panel_7.setLayout(gl_panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(null);
		tabbedPane_2.addTab("General", null, panel_8, null);

		JScrollPane scrollPane_6 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(86)
						.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(91, Short.MAX_VALUE)));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE)));

		t_7 = new JTable();
		t_7.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nota" }));
		scrollPane_6.setViewportView(t_7);
		panel_8.setLayout(gl_panel_8);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Method to include new content to a Jtable
	 * 
	 * @param infotabla
	 */
	public void rellenarTabla(DefaultTableModel infotabla) {
		String[][] tabla = model.getMateriales();
		DefaultTableModel modelo = infotabla;
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

	/**
	 * Method to eliminated all data of a table
	 * 
	 * @param tabla
	 */
	public void limpiarTabla(JTable tabla) {
		for (int i = 0; i < tabla.getRowCount(); i++) {
			DefaultTableModel modeling = (DefaultTableModel) tabla.getModel();
			modeling.removeRow(i);
			i -= 1;
		}
	}
	/**
	 * JBUtonAceptar Genaliced
	 * 
	 * @param tablas
	 * @param columnas
	 * @param valores
	 * @param Jtable
	 */
	public void botonInsertar(JButton btn, String tablas, String columnas, String valores) {
		if (!Control.SELECT(tablas, columnas, valores.trim())) {
			if (Control.Insert(tablas, columnas, valores.trim())) {
				System.out.println(tablas + " " + columnas + " " + valores);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Datos ya existentes", null, JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * JBUtonElimionar Genaliced
	 * 
	 * @param tablas
	 * @param columnas
	 * @param valores
	 * @param Jtable
	 */
	public void botonEliminar(JButton btn, String tablas, String columnas, String valores, JTable Jtable) {

		if (Control.Delete(tablas, columnas, Jtable.getValueAt(Jtable.getSelectedRow(), 0).toString())) {
			limpiarTabla(Jtable);
			model.consultaMateriales(columnas, tablas, "", (DefaultTableModel) Jtable.getModel());
		}

	}

	public void setmodel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
	}

	public void setControl(Control control) {
		// TODO Auto-generated method stub
		this.control=control;
	}
}
