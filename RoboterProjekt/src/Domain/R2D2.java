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
		super.setId((int) Math.random() * 9999 + 1);
	}

	/**
	 * Hier denkt der Roboter, also ordnet die Zahlen mithilfe des
	 * SelectionSort-Algorithmus
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
				for (int i = 0; i < numbers.length - 1; i++) {
					for (int j = i + 1; j < numbers.length; j++) {
						if (numbers[i] > numbers[j]) {
							temp = numbers[i];
							numbers[i] = numbers[j];
							numbers[j] = temp;
						}
					}
				}
				return numbers;
			}

		} else {
			super.getList().add(new RobotIllegalStateException(super.getName()));
			throw new RobotIllegalStateException(super.getName());
		}
	}

}
