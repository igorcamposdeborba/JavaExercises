package principal;

import entities.Associate;
import entities.HRManager;

public class Principal {
	public static void main (String [] args) {
	
	HRManager management1 = new HRManager(1500.00);
	HRManager associate1 = new HRManager(2000.00);
	HRManager associate2 = new HRManager(1300.49);
	
	management1.addAssociate(associate1);
	management1.addAssociate(associate2);
	
	System.out.println(management1);
	
	}
}
