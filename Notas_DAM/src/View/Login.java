package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Control;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private Configuracion conf;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private Control control;
	private int intentos=0;
	private JButton btnConfig;
	private JButton btnSignin;
	private JButton btnLogOut;
	private Ap ap;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setFont(new Font("Ebrima", Font.BOLD, 12));
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lucas\\Downloads\\FAVICON.png"));
		setTitle("Materiales de Construcci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);

		btnLogin = new JButton("Iniciar sesión");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.isIntro(txtUser.getText(),new String(passwordField.getPassword()));
			}
		});
		btnLogin.setEnabled(false);
		btnLogin.setBounds(49, 164, 143, 25);
		btnLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ap.setVisible(true);
			}
		});

		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ActiveLogin();
			}
		});
		txtUser.setBounds(210, 48, 116, 22);
		txtUser.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(116, 51, 59, 16);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(94, 91, 81, 16);

		passwordField = new JPasswordField();
		passwordField.setBounds(210, 88, 116, 22);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ActiveLogin();
			}
		});

		btnLogOut = new JButton("Salir");
		btnLogOut.setBackground(new Color(255, 0, 0));
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(150, 202, 99, 25);
		btnLogOut.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.exit(0);// cerrar app
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblContraseña);
		contentPane.add(lblUsuario);
		contentPane.add(btnLogin);
		contentPane.add(passwordField);
		contentPane.add(txtUser);
		contentPane.add(btnSignin);
		contentPane.add(btnLogOut);
		
		btnConfig = new JButton("Configuracion");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conf.setVisible(true);
				setVisible(false);
			}
		});
		btnConfig.setBounds(210, 166, 116, 23);
		contentPane.add(btnConfig);
		
	
	}


	public void setMenuManagement(Ap ap) {
		this.ap =ap;
	}
	
	
	public void setfrmConfig(Configuracion conf) {
		this.conf = conf;
	}
/**
 * method to active btnLogin
 * @return
 */
	public void ActiveLogin() {
		if (!(new String(passwordField.getPassword()).trim()).equals("")&&!txtUser.getText().trim().equals("")) {
				btnLogin.setEnabled(true);	
			}
		}
	

	/**
	 * method to check pass and nick
	 * 
	 * @return
	 */
	public boolean isTruePas() {
		 return control.isIntro(txtUser.getText(),new String(passwordField.getPassword()));
	}

	/**
	 * Method to get null txt amd pass
	 */
	public void reset() {
		txtUser.setText(null);
		passwordField.setText(null);
	}
	 /**
	  * Method to make a the conexion
	  * @param conex
	  */
	 	public void setControler(Control conex) {
	 		control = conex;
	 	}


	public void setap(Ap ap) {
		// TODO Auto-generated method stub
		this.ap=ap;
	}
}
