package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Control;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Configuracion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUrl;
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnCambiar;
	private Login frmLog;
	private JButton btnVolver;
	private Control control;
	private String Url="";
	private String User="";
	private String Pass="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracion frame = new Configuracion();
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
	public Configuracion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 451);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtUrl = new JTextField();
		txtUrl.setText(Url);//"jdbc:oracle:thin:@localhost:1521:XE"
		txtUrl.setColumns(10);

		JLabel lblNewLabel = new JLabel("Url");

		txtUser = new JTextField();
		txtUser.setText(User);//"USUARIO"
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setText(Pass);//"CLAVE"
		txtPass.setColumns(10);

		JLabel lblUsuarui = new JLabel("Usuario");

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");

		btnCambiar = new JButton("Cambiar");
		btnCambiar.setForeground(new Color(255, 255, 255));
		btnCambiar.setBackground(new Color(50, 205, 50));

		btnCambiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setConexion(txtUrl.getText(), txtUser.getText(), txtPass.getText());
				control.makeConexion();
			}
		});

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frmLog.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Configuracion");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 31));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblContrasea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblUsuarui, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPass)
								.addComponent(txtUser)
								.addComponent(txtUrl, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(168)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnVolver, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCambiar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuarui)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addComponent(btnCambiar)
					.addGap(18)
					.addComponent(btnVolver)
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void setConexion(String basedatos, String usuario, String clave) {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		FileOutputStream miFichero = null;
		String Configuracion="[Propieties]"+"\n"+" basedatos = "+basedatos+"\n"+" usuario = "+usuario+"\n"+" clave = "+clave;
		byte[]config=Configuracion.getBytes();
		try {
			miFichero =  new FileOutputStream("src/Config/configuracion.ini");
			for (int i = 0; i < config.length; i++) {
				try {
					miFichero.write(config[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Esrror en byte"+config[i]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fichero");
		}

//		propiedades.setProperty("basedatos", "jdbc:oracle:thin:@localhost:1521:XE");
//		propiedades.setProperty("usuario", "ELENA");
//		propiedades.setProperty("clave", "ELENA");
		
	}
	public void setfrmLogin(Login frmLog) {
		this.frmLog = frmLog;
	}
	/**
	 * method to set the controler
	 * @param control
	 */
	public void setControl(Control control){
		this.control=control;
	}
	public void setConexion1(String Url,String User,String Pass){
		
		/*Pasamos los String a variables de la clase*/
		this.Url=Url;
		this.User=User;
		this.Pass=Pass;
		
		/*Escribimos los nuevos textos*/
		txtUrl.setText(Url);
		txtUser.setText(User);
		txtPass.setText(Pass);
	}
}