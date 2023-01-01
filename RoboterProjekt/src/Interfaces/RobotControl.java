package Interfaces;

import Exceptions.RobotException;

public interface RobotControl {

	/**
	 * Gibt die ID (Seriennummer) des Roboters zurück.
	 *
	 * @return Eine eindeutige Identifikation in Form einer Zahl.
	 */
	public int getId();

	/**
	 * Gibt den Namen des Roboter-Exemplars zurück.
	 *
	 * @return Der Name des Roboters.
	 */
	public String getName();

	/**
	 * Betätigen den An-/Ausschaltknopf.
	 */
	public void triggerPowerSwitch();

	/**
	 * Prüft ob der Roboter eingeschaltet ist.
	 *
	 * @return <code>true</code> bedeutet, dass der Roboter eingeschaltet ist,
	 *         <code>false</code>, dass er nicht eingeschaltet ist.
	 */
	public boolean isPowerOn();

	/**
	 * Ruft die zuletzt aufgetretene Ausnahme aus der Blackbox ab.
	 *
	 * @return zuletzt aufgetretene Ausnahme oder <code>null</code> falls noch keine
	 *         aufgetreten ist.
	 */
	public RobotException getLastException();
}