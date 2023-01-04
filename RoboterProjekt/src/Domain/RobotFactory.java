package Domain;

import java.util.InputMismatchException;

import Exceptions.RobotException;

public class RobotFactory {

	/**
	 * Mithilfe dieser Methode soll der 'Kunde' einen beliebigen Roboter bestellen können.
	 * 
	 * @param modell : Hier gibt man an ob R2D2 oder C3PO ausgewählt werden soll.
	 * @param name : Hier gibt man dem Roboter einen Namen.
	 * @return : Der Roboter wird 'ausgeliefert' und ist bereit.
	 * @throws InputMismatchException : Wird geworfen, falls kein Name eingegeben wird. 
	 */
	public static Roboter order(RobotType modell, String name) throws InputMismatchException {
		Roboter roboter = null;
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
			throw new InputMismatchException("Kein Name eingegeben");
		}
	}

}
