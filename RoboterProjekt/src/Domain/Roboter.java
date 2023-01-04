package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;

public abstract class Roboter implements Robot {
	private final String name;
	private int seriennummer;
	private boolean roboterAn = false;
	private List<RobotException> liste;

	/**
	 * Rückgabe der Ausnahmenliste des Roboters.
	 * 
	 * @return : Rückgabe vom Typ Liste.
	 */
	public List<RobotException> getListe() {
		return liste;
	}

	/**
	 * 
	 * @param liste : Hier wird die Ausnahmenliste des Roboters übergeben.
	 */
	public void setListe(List<RobotException> liste) {
		this.liste = liste;
	}

	/**
	 * Hier wird der Roboter konstruiert.
	 * 
	 * @param name : Hier wird der Name des neuen Roboters übergeben.
	 */
	Roboter(String name) {
		this.name = name;
		liste = new ArrayList<>();
	}

	/**
	 * Hier wird die Seriennummer zurückgegeben.
	 * 
	 * @return : Seriennummer als Integerzahl.
	 */
	public int getSeriennummer() {
		return seriennummer;
	}

	/**
	 * Hier wird die Seriennummer gesetzt.
	 * 
	 * @param seriennummer : Hier gibt man eine beliebige Seriennummer ein.
	 */
	public void setSeriennummer(int seriennummer) {
		this.seriennummer = seriennummer;
	}

	/**
	 * Hier wird der Roboter eingeschaltet.
	 * 
	 * @param roboterAn : Damit wird das ein- und ausschalten realisiert.
	 */
	public void setRoboterAn(boolean roboterAn) {
		this.roboterAn = roboterAn;
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
	public String speak(int[] zahlen) throws RobotException {
		boolean exit = false;
		for (int zahl : zahlen) {
			if (zahl == 42) {
				exit = true;
			}
		}
		if (exit)
			throw new RobotMagicValueException(this.getName());
		else if (isPowerOn())
			return getAusgabe(zahlen);
		else
			throw new RobotIllegalStateException(this.getName());
	}

	/**
	 * Abhängig vom Roboter werden Zahlen formatiert.
	 * 
	 * @param zahlen : Zahlen die formatiert werden sollen.
	 * @return : Gibt einen String abhängig vom Roboter-Typ zurück.
	 */
	private String getAusgabe(int[] zahlen) {
		String ergebnis = "";
		if (this instanceof R2D2)
			ergebnis = Arrays.stream(zahlen).mapToObj(s -> String.valueOf(s)).reduce((a, b) -> a + "," + b).get();
		if (this instanceof C3PO)
			ergebnis = Arrays.stream(zahlen).mapToObj(s -> String.valueOf(s)).reduce((a, b) -> a + ";" + b).get();

		return ergebnis;
	}
	/**
	 * Hier wird die ID zurückgegeben.
	 * 
	 * @return : Seriennummer als Integer.
	 */
	@Override
	public int getId() {
		return seriennummer;
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
		if (roboterAn)
			roboterAn = false;
		if (!roboterAn)
			roboterAn = true;
	}

	/**
	 * Hier wird geprüft in welchem Zustand sich der Roboter befindet.
	 * 
	 * @return : gibt den aktuellen Status zurück.
	 */
	@Override
	public boolean isPowerOn() {
		return roboterAn;
	}

	/**
	 * Hier wird die letzte Fehlermeldung des Roboterspeichers zurückgegeben.
	 * 
	 * @return : Die jeweilige Exception wird zurückgegeben.
	 */
	@Override
	public RobotException getLastException() {
		if (liste == null)
			return null;
		return liste.get(liste.size() - 1);
	}

}
