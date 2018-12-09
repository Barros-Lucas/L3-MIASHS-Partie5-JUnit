package app;

import tec.Autobus;
import tec.PassagerStandard;
//import tec.Passager; not visible 
import tec.Bus;
import tec.Transport;
import tec.Usager;

// TODO: Auto-generated Javadoc
/**
 * The Class TestVisibilitéPacktageTec.
 */
public class TestVisibilitéPacktageTec {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Autobus auto = new Autobus(1,1);
		if(auto instanceof Transport) {
			System.out.println("implements Transport");
		}
		if(auto instanceof Bus) {
			System.out.println("implements Bus");
		}

	}

}
