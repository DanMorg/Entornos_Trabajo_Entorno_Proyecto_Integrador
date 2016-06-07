package IniciarAp;

import Control.Control;
import Model.Model;
import View.*;

public class IniciarAp {
	private static Model model;
	public static void main(String[] args) {
		/*Constructures*/
//		Login vtnLogin = new Login();
		 model = new Model();
		 Control control = new Control();
		Configuracion conf = new Configuracion();
		Ap ap=new Ap();
		
		/*Relaciones*/
//		vtnLogin.setap(ap);
//		vtnLogin.setfrmConfig(conf);
		ap.setmodel(model);
		ap.setControl(control);
		model.setcontrol(control);
		model.setAp(ap);
		control.setAp(ap);
		control.setmodel(model);
		control.setControl(control);
		
		ap.setVisible(true);
	}
}
