package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Control.Control;
import View.Ap;
import View.Configuracion;


public class Model {
	private Configuracion config ;
	private Connection conet ;
	private Control control;
	private String[][] table;
	private String[] comboBox;
	private Ap ap;
	
	public Model(){
		try {
			conexion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Conexion no establecida");
		}
	}
	
	/**
	 * Method to get the credencial of a user
	 * 
	 * @return
	 */
	public boolean Introduccion(String user, String pass) {
		try {
			String answer = Consulta("SELECT * FROM USUARIO WHERE USERS = '" + user + "'AND PASS = '" + pass + "'");
			if (answer.equals("")) {
				// JOptionPane.showMessageDialog(null, "Contraseña o Usuario
				// incorrectos", null, JOptionPane.ERROR_MESSAGE);
				return false;

			}
			return true;
		} catch (Exception e) {

			return false;

		}
	}
	public String SSELECT(String Tabla,String Objetivo, String Campo, String Dato) {
		try {
			String answer = Consulta("SELECT "+Objetivo+" FROM " + Tabla + " WHERE " + Campo + " = '" + Dato + "'");
			return answer;
		} catch (Exception e) {

			return "-";

		}
	}
	public String SSSELECT(String Tabla,String Objetivo){
		try {
			String answer = Consulta("SELECT "+Objetivo+" FROM " + Tabla );
			return answer;
		} catch (Exception e) {

			return "-";

		}	
	}
	public String selecCombo(String Tabla,String Objetivo){
		String answer = Consulta("SELECT "+Objetivo+" FROM " + Tabla);
		return answer;
	}
	public boolean SELECT(String Tabla,String Objetivo, String Campo, String Dato) {
		try {
			String answer = Consulta("SELECT "+Objetivo+" FROM " + Tabla + " WHERE " + Campo + " = '" + Dato + "'");
			if (answer.equals("")) {
				// JOptionPane.showMessageDialog(null, "Contraseña o Usuario
				// incorrectos", null, JOptionPane.ERROR_MESSAGE);
				return false;

			}
			return true;
		} catch (Exception e) {

			return false;

		}
	}

	/**
	 * method to INSERT
	 * 
	 * @param tabla
	 * @param columna
	 * @param dato
	 * @return
	 */
	public boolean INSERT(String tabla, String columa, String dato) {
		return NuevosDatos("INSERT INTO " + tabla + "(" + columa + ") VALUES ('" + dato + "')");
	}

	/**
	 * method to UPDATE TABLE
	 * 
	 * @param tabla
	 * @param columna
	 * @param dato
	 * @param colum_calve
	 * @param clave
	 * @return
	 */
	public boolean UPDATE(String tabla, String columa, String new_dato, String colum_calve, String clave) {
		return NuevosDatos(
				"UPDATE " + tabla + " SET " + columa + "='" + new_dato + "'WHERE " + colum_calve + "='" + clave + "'");
	}

	/**
	 * method to DELETE TABLE
	 * 
	 * @param tabla
	 * @param columna
	 * @param dato
	 * @return
	 */
	public boolean DELETE(String tabla, String colum_clave, String clave) {
		return NuevosDatos("DELETE FROM " + tabla + " WHERE " + colum_clave + " ='" + clave + "'");
	}
	public boolean DELETEMat(String tabla, String colum_clave) {
		return NuevosDatos("DELETE FROM " + tabla + tablear(colum_clave));
	}
	/**
	 * Method to get a table
	 * 
	 * @param Tabla
	 * @return
	 */
	public String GetTable(String Tabla) {
		String ary = Consulta("SELECT * FROM " + Tabla);
		return ary;
	}

	/**
	 * Method to make the querys
	 * 
	 * @param query
	 * @param columna
	 */
	public String Consulta(String query) {
		try {
			Statement stmt = conet.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int columna = 1;// Variable de seleccion de columna en la tabla
			String anser = "";// respuesta de la select
			while (rset.next()) {
				anser = (anser + rset.getString(columna) + " ");
				columna++;
			}
			return anser;
		} catch (SQLException s) {
			s.printStackTrace();
			return "";
		}
	}
	
	

	/**
	 * Method to make Insert,Update,Delete
	 * 
	 * @param sql
	 * @return
	 */
	public boolean NuevosDatos(String sql) {
		try {
			Statement stmt = conet.createStatement();
			int rset = stmt.executeUpdate(sql);// si es correcto 1 y si catch
			if (rset == 1) {
				return true;
			}
			return false;
		} catch (SQLException s) {
			s.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to get the number Of colums of table
	 * 
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	public int GetNumberOfColum(String tabla) throws SQLException {
		Statement stmt = conet.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);
		ResultSetMetaData rsmd = rs.getMetaData();
		return rsmd.getColumnCount();
	}

	/**
	 * Method for get the name of a Table
	 * 
	 * @param Tabla
	 * @return
	 * @throws SQLException
	 */
	public String ColumnasTabla(String Tabla) throws SQLException {
		Statement stmt = conet.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM " + Tabla);
		ResultSetMetaData rsmd = rs.getMetaData();
		int Columnas = GetNumberOfColum(Tabla);
		String answer = null;// Nombre de columnas
		for (int i = 0; i < Columnas; i++) {// recorremos para obtener el nombre
											// de las colmunas
			if (i == (Columnas - 1)) {
				answer = answer + rsmd.getColumnTypeName(i);
			} else {
				answer = answer + rsmd.getColumnTypeName(i) + " , ";
			}
		}
		return answer;
	}

	/**
	 * Method to get the data of a table
	 * 
	 * @param Tabla
	 * @return
	 * @throws SQLException
	 */
	public String DatosTabla(String Tabla) throws SQLException {
		Statement stmt = conet.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM " + Tabla);
		ResultSetMetaData rsmd = rs.getMetaData();
		return "";
	}

	public void consultaMateriales(String columna, String Tabla, String condiciones, DefaultTableModel dtm) {
		try {
			String nfilas = "Select count(*) from " + Tabla + tablear(condiciones);// +tablear(condiciones);
			Statement stmt = conet.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);

			String query = "Select " + columna + " from " + Tabla + tablear(condiciones); // +tablear(condiciones);
			stmt = conet.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			table = new String[f][c];
			while (rset.next()) {
				for (int j = 0; j < c; j++) {
					table[i][j] = rset.getString(j + 1);
				}
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		ap.rellenarTabla(dtm);
	}
	public void SelectComboBox(String Tabla,String Objetivo){
		 comboBox = SSSELECT(Tabla,Objetivo).split("");
	}
	public String tablear(String condicion) {
		String[] condiciones = condicion.split(",");
		String t = " Where ";// tablas finales
		if (condiciones.length % 2 == 0) {
			for (int i = 0; i < condiciones.length; i += 2) {
				if (i == 0) {
					t = t + condiciones[i] + " = " + condiciones[i + 1];
				} else {
					t = t + " AND " + condiciones[i] + " = " + condiciones[i + 1];
				}
			}

		} else {
			return "";
		}
		return t;

	}
	/**
	 * method to make the conexion
	 * @throws IOException
	 */
	public void conexion() throws IOException {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Config/configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				// cargamos el archivo de propiedades
				propiedades.load(entrada);
				//metemos los archivos
				propiedades.setProperty("mi_url","jdbc:oracle:thin:@localhost:1521:XE");
				// obtenemos las contraseña
				Class.forName("oracle.jdbc.driver.OracleDriver");// Busqueda del
																	// driver
				String mi_url = propiedades.getProperty("basedatos");// Url y
																		// puerto
				String mi_user = propiedades.getProperty("usuario");// usuario de Oracle
				String mi_pass = propiedades.getProperty("clave");// Password de Oracle
				
				System.out.println("Direcion url: "+mi_url);
				System.out.println("Usuaro "+mi_user);
				System.out.println("Contraseña "+mi_pass);
				
				conet = DriverManager.getConnection(mi_url, mi_user, mi_pass);
				JOptionPane.showMessageDialog(null, "Conexion establecida con la Base de Datos");
//				config.setConexion(mi_url,mi_user,mi_pass);
			} else
				System.err.println("Fichero no encontrado");
		} catch (ClassNotFoundException e) {// En caso de que no haya driver
			System.out.println("No hay driver");

		} catch (SQLException e) {// En caso de que no se pueda conerctar con
									// oracle
			JOptionPane.showMessageDialog(null, "No ha podido establecerse la conexión compruebe la configuración", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	public String[][] getMateriales() {
		// TODO Auto-generated method stub
		return table;
	}
	public String[] getComboBox() {
		// TODO Auto-generated method stub
		return comboBox;
	}
	public void setcontrol(Control control) {
		// TODO Auto-generated method stub
		this.control=control;
	}
	public void setAp(Ap ap) {
		// TODO Auto-generated method stub
		this.ap=ap;
	}
}
