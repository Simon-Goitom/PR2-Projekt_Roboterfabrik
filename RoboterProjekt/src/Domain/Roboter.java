package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;

import Interfaces.Robot;
import Interfaces.RobotControl;
import Interfaces.RobotInstructions;

public abstract class Roboter implements Robot {
	private final String name;
	private int id;
	private boolean powerOn = false;
	private List<RobotException> list;

	/**
	 * Rückgabe der Ausnahmenliste des Roboters.
	 * 
	 * @return : Rückgabe vom Typ Liste.
	 */
	public List<RobotException> getList() {
		return list;
	}

	/**
	 * 
	 * @param list : Hier wird die Ausnahmenliste des Roboters übergeben.
	 */
	public void setList(List<RobotException> list) {
		this.list = list;
	}

	/**
	 * Hier wird der Roboter konstruiert.
	 * 
	 * @param name : Hier wird der Name des neuen Roboters übergeben.
	 */
	Roboter(String name) {
		this.name = name;
		list = new ArrayList<>();
	}

	/**
	 * Hier wird die Seriennummer gesetzt.
	 * 
	 * @param id : Hier gibt man eine beliebige Seriennummer ein.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Hier wird der Roboter eingeschaltet.
	 * 
	 * @param powerOn : Damit wird das ein- und ausschalten realisiert.
	 */
	public void setRoboterOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	/**
	 * Hier werden übergebene Zahlen korrekt formatiert ausgegeben.
	 * 
	 * @param : Die Zahlen die formatiert und ausgegeben werden sollen.
	 * @return : Die tatsächliche Ausgabe als String.
	 * @throws : Wirft eine Exception, falls der Roboter nicht den richtigen Zustand
	 *           hat oder ein falsches Format des Arrays vorkommen sollte.
	 * 
	 */
	@Override
	public String speak(int[] numbers) throws RobotException {
		boolean exit = false;
		for (int number : numbers) {
			if (number == 42) {
				exit = true;
			}
		}
		if (exit)
			throw new RobotMagicValueException(this.getName());
		else if (isPowerOn())
			return getResult(numbers);
		else
			throw new RobotIllegalStateException(this.getName());
	}

	/**
	 * Abhängig vom Roboter werden Zahlen formatiert.
	 * 
	 * @param numbers : Zahlen die formatiert werden sollen.
	 * @return : Gibt einen String abhängig vom Roboter-Typ zurück.
	 */
	private String getResult(int[] numbers) {
		String result = "";
		if (this instanceof R2D2)
			result = Arrays.stream(numbers).mapToObj(s -> String.valueOf(s)).reduce((a, b) -> a + "," + b).get();
		if (this instanceof C3PO)
			result = Arrays.stream(numbers).mapToObj(s -> String.valueOf(s)).reduce((a, b) -> a + ";" + b).get();

		return result;
	}
	/**
	 * Hier wird die ID zurückgegeben.
	 * 
	 * @return : Seriennummer als Integer.
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Gibt den Namen des Roboters zurück.
	 * 
	 * @return : String als Rückgabewert.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Hier wird der Roboter ein- und ausgeschaltet.
	 * 
	 * @void : gibt zurück ob er nun ein oder aus ist.
	 */
	@Override
	public void triggerPowerSwitch() {
		if (powerOn)
			powerOn = false;
		if (!powerOn)
			powerOn = true;
	}

	/**
	 * Hier wird geprüft in welchem Zustand sich der Roboter befindet.
	 * 
	 * @return : gibt den aktuellen Status zurück.
	 */
	@Override
	public boolean isPowerOn() {
		return powerOn;
	}

	/**
	 * Hier wird die letzte Fehlermeldung des Roboterspeichers zurückgegeben.
	 * 
	 * @return : Die jeweilige Exception wird zurückgegeben.
	 */
	@Override
	public RobotException getLastException() {
		if (list == null)
			return null;
		return list.get(list.size() - 1);
	}

}
