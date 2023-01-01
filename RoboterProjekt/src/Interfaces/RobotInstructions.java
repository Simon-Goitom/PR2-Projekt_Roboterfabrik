package Interfaces;

import Exceptions.RobotException;

public interface RobotInstructions {

	/**
	 * Gibt ein Array von Zahlen als String zurück. Die Zahlen werden <b>nicht</b>
	 * sortiert.
	 *
	 * @param zahlen Zahlen, die ausgegeben werden sollen.
	 * @return Zahlen als String
	 * @throws RobotException wenn der Roboter in einem ungültigen Zustand ist, oder
	 *                        das Array nicht seinen Vorstellungen entspricht.
	 */
	public String speak(int[] zahlen) throws RobotException;

	/**
	 * Sortiert ein Array von Zahlen. Die Reihenfolge hängt von dem Typ des Roboters
	 * ab.
	 *
	 * @param zahlen Zahlen, die sortiert werden sollen.
	 * @return Sortierte Zahlen
	 * @throws RobotException wenn der Roboter in einem ungültigen Zustand ist, oder
	 *                        das Array nicht seinen Vorstellungen entspricht.
	 */
	public int[] think(int[] zahlen) throws RobotException;
}

