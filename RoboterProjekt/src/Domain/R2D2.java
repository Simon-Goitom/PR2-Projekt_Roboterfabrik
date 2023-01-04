package Domain;

import java.util.List;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;

public class R2D2 extends Roboter {

	/**
	 * Hier wird der R2D2 durch den Konstruktor erstellt.
	 * 
	 * @param name : Hier wird der Name übergeben, wie der Roboter später heißen
	 *             soll.
	 */
	public R2D2(String name) {
		super(name);
		super.setSeriennummer((int) Math.random() * 9999 + 1);
	}

	/**
	 * Hier denkt der Roboter, also ordnet die Zahlen mithilfe des
	 * SelectionSort-Algorithmus
	 *
	 * @param zahlen : Zahlen die sortiert werden sollen
	 * @return sortierte Zahlen im Integer-Array
	 * @throws RobotException wenn der Roboter einen ungültigen Zustand oder das
	 *                        Array nicht passt
	 */
	@Override
	public int[] think(int[] zahlen) throws RobotException {
		int temp;
		boolean gültig = true;
		for (int zahl : zahlen) {
			if (zahl == 42) {
				gültig = false;
			}
		}

		if (super.isPowerOn()) {
			if (gültig == false) {
				super.getListe().add(new RobotMagicValueException(super.getName()));
				throw new RobotMagicValueException(super.getName());
			} else {
				for (int i = 0; i < zahlen.length - 1; i++) {
					for (int j = i + 1; j < zahlen.length; j++) {
						if (zahlen[i] > zahlen[j]) {
							temp = zahlen[i];
							zahlen[i] = zahlen[j];
							zahlen[j] = temp;
						}
					}
				}
				return zahlen;
			}

		} else {
			super.getListe().add(new RobotIllegalStateException(super.getName()));
			throw new RobotIllegalStateException(super.getName());
		}
	}

}
