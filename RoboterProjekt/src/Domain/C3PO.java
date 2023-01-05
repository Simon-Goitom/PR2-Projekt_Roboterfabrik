package Domain;

import java.util.List;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;
import Domain.Roboter;

public class C3PO extends Roboter {

	/**
	 * Hier wird der C3PO durch den Konstruktor erstellt.
	 * 
	 * @param name : Hier wird der Name übergeben, wie der Roboter später heißen
	 *             soll.
	 */
	public C3PO(String name) {
		super(name);
		super.setId(10000 + (int) Math.random() * 9999 + 1);
	}

	/**
	 * Hier denkt der Roboter, also ordnet die Zahlen mithilfe des
	 * InsertionSort-Algorithmus
	 *
	 * @param numbers : Zahlen die sortiert werden sollen
	 * @return sortierte Zahlen im Integer-Array
	 * @throws RobotException wenn der Roboter einen ungültigen Zustand oder das
	 *                        Array nicht passt
	 */
	@Override
	public int[] think(int[] numbers) throws RobotException {
		int temp;
		boolean valid = true;
		for (int number : numbers) {
			if (number == 42) {
				valid = false;
			}
		}
		if (super.isPowerOn()) {
			if (valid == false) {
				super.getList().add(new RobotMagicValueException(super.getName()));
				throw new RobotMagicValueException(super.getName());
			} else {
				for (int i = 1; i < numbers.length; i++) {
					temp = numbers[i];
					int j = i;
					while (j > 0 && numbers[j - 1] < temp) {
						numbers[j] = numbers[j - 1];
						j--;
					}
					numbers[j] = temp;
				}
				return numbers;
			}
		} else {
			super.getList().add(new RobotIllegalStateException(super.getName()));
			throw new RobotIllegalStateException(super.getName());
		}
	}
}
