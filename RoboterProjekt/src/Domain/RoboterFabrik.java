package Domain;

import java.util.InputMismatchException;

import Exceptions.RobotException;
import Interfaces.Robot;

public class RoboterFabrik {
	

	/**
	 * Mithilfe dieser Methode soll der 'Kunde' einen beliebigen Roboter bestellen können.
	 * 
	 * @param modell : Hier gibt man an ob R2D2 oder C3PO ausgewählt werden soll.
	 * @param name : Hier gibt man dem Roboter einen Namen.
	 * @return : Der Roboter wird 'ausgeliefert' und ist bereit.
	 * 
	 */
	public static Robot order(RobotType modell, String name)  {
		Robot roboter = null;
		if (name != null) {
			switch (modell) {
			case R2D2:
				roboter = new R2D2(name);
				break;
			case C3PO:
				roboter = new C3PO(name);
				break;
			}
			return roboter;
		} else {
			throw new RuntimeException("Kein Name eingegeben");
		}
	}

}
