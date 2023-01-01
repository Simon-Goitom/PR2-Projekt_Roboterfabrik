package Interfaces;

import Exceptions.RobotException;

public interface RobotControl {

	/**
	 * Gibt die ID (Seriennummer) des Roboters zur�ck.
	 *
	 * @return Eine eindeutige Identifikation in Form einer Zahl.
	 */
	public int getId();

	/**
	 * Gibt den Namen des Roboter-Exemplars zur�ck.
	 *
	 * @return Der Name des Roboters.
	 */
	public String getName();

	/**
	 * Bet�tigen den An-/Ausschaltknopf.
	 */
	public void triggerPowerSwitch();

	/**
	 * Pr�ft ob der Roboter eingeschaltet ist.
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