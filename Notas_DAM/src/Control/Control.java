package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Model;
import View.*;

public class Control {
	private static  Model model;
	private Control control;
	private Ap ap;


	/**
	 * Method to make a Select
	 * 
	 * @param tabla
	 * @param columna
	 * @param dato
	 * @return
	 */
	public static boolean SELECT(String tabla, String columna, String dato) {
		return model.SELECT(tabla, "*", columna, dato);
	}

	/**
	 * Method to make a Select
	 * 
	 * @param tabla
	 * @param columna
	 * @param dato
	 * @return
	 */
	public String SSELECT(String objetivo, String tabla, String columna, String dato) {
		return model.SSELECT(tabla, objetivo, columna, dato);
	}

	/**
	 * Insert could be modificte to 2 or more columns by ading , and amplify to
	 * 2 or moro date by ading ','
	 * 
	 * @param tabla
	 * @param columna
	 * @param dato
	 * @return
	 */
	public static boolean Insert(String tabla, String columna, String dato) {
		return model.INSERT(tabla, columna, dato);
	}

	/**
	 * Method to delete
	 * 
	 * @param tabla
	 * @param colum_clave
	 * @param clave
	 * @return
	 */
	public static boolean Delete(String tabla, String colum_clave, String clave) {
		return model.DELETE(tabla, colum_clave, clave);
	}

	

	/**
	 * Boton general para conocer el resto de las pantallas
	 * @param model
	 	 */
	public void set( Model model) {
		this.model = model;
	}
	public void makeConexion() {
		// TODO Auto-generated method stub

	}

	public boolean isIntro(String text, String string) {
		return false;
		// TODO Auto-generated method stub
	}
	

	/**
	 * Method to include new content to a JComboBox
	 * 
	 * @param comboBoxModel
	 */
	public void rellenarComboBox(ComboBoxModel<String> comboBoxModel) {
		String[] comboBox = comboBoxModel.toString().split(",");
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>)comboBoxModel;
		for (int i = 0; i < comboBox.length; i++) {
			model.addElement(comboBox[i]);
			;
		}
	}

	/**
	 * Method to eliminated all data of a table
	 * 
	 * @param tabla
	 */
	public void limpiarComboBox(ComboBoxModel<?> infotabla) {
		for (int i = 0; i < infotabla.getSize(); i++) {
			ComboBoxModel<?> modeling = infotabla;
			((DefaultComboBoxModel<?>) modeling).removeElementAt(i);
			;
			i -= 1;
		}
	}

	public void buscarInfo(JTextField txtF) {
		txtF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
	}

	

	/**
	 * method to set Control
	 * 
	 * @param control
	 */
	public void setControl(Control control) {
		this.control = control;
	}

	public void setAp(Ap ap) {
		// TODO Auto-generated method stub
		this.ap=ap;
	}

	public void setmodel(Model model2) {
		// TODO Auto-generated method stub
		this.model=model;
	}
}
