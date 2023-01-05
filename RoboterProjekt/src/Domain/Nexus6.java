package Domain;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Domain.Roboter;

public class Nexus6 extends Roboter {

	private static Nexus6 nexus = new Nexus6("Pris");

	/**
	 * Hier wird der Nexus6 durch den Konstruktor erstellt.
	 * 
	 * @param name : Hier wird der Name übergeben, wie der Roboter später heißen
	 *             soll.
	 */
	private Nexus6(String name) {
		super(name);
		super.setId(19281982);

	}

	/**
	 * Hier wird nach dem Singleton-Prinzip das einzige Nexus6 Objekt zur�ckgegeben.
	 * 
	 * @return Das Nexus6 Objekt
	 */
	public static Nexus6 getNexus() {
		return nexus;
	}

	/**
	 * Hier wird der Roboter ein- und ausgeschaltet.
	 * 
	 * @void : gibt zurück ob er nun ein oder aus ist.
	 */
	@Override
	public void triggerPowerSwitch() {
		super.setRoboterOn(false);

	}

	/**
	 * Hier soll eine RobotIllegalStateException geworfen werden, da der Roboter
	 * defekt ist.
	 * 
	 * @param numbers Zahlen, die sortiert werden sollten
	 * @throws RobotIllegalStateException, da defekt ist.
	 */
	@Override
	public int[] think(int[] numbers) throws RobotException {
		super.getList().add(new RobotIllegalStateException(super.getName()));
		throw new RobotIllegalStateException(super.getName());

	}

	/**
	 * Hier soll eine RobotIllegalStateException geworfen werden, da der Roboter
	 * defekt ist.
	 * 
	 * @param numbers Zahlen, die in einen String umgewandelt werden sollen
	 * @throws RobotIllegalStateException, da defekt ist.
	 */
	@Override
	public String speak(int[] numbers) throws RobotException {
		super.getList().add(new RobotIllegalStateException(super.getName()));
		throw new RobotIllegalStateException(super.getName());
	}

}
