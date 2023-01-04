package Domain;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;


class R2D2_Test {
	int[] expected = {1,2,3,4,5,6,7,8};

	int[] testNumbers = {1,3,2,4,8,7,6,5};
	int[] testNumbers42 = {1,3,2,4,8,7,6,5,42};
	
	R2D2 robot = new R2D2("Testunit");
	
	/**
	 * Hier wird geschaut ob die 'richtige' Seriennummer vergeben wird
	 */
	@Test
	void checkSerialnumber() {
		assertTrue(robot.getSeriennummer() < 10000);
	}
	
	/**
	 * Hier wird der Schalter getestet
	 */
	@Test
	void triggerPowerSwitchTest() {
		robot.triggerPowerSwitch();
		assertEquals(true,robot.isPowerOn());
	}
	
	/**
	 *	Hier wird geprüft ob der Roboter an ist
	 */
	@Test
	void isPowerOn() {
		assertEquals(false,robot.isPowerOn());
	}

	/**
	 * Hier wird geprüft ob die Zahlen richtig sortiert werden.
	 * 
	 * @throws RobotException
	 */
	@Test
	void thinkTest() throws RobotException {
		robot.triggerPowerSwitch();
		assertArrayEquals(expected, robot.think(testNumbers));
	}
	
	/**
	 * Hier wird geprüft ob der Roboter richtig spricht
	 * 
	 * @throws RobotException
	 */
	@Test
	void speakTest() throws RobotException {
		robot.triggerPowerSwitch();
		assertEquals("1,3,2,4,8,7,6,5", robot.speak(testNumbers));
	}
	
	/**
	 * Hier wird geprüft ob denken und sprechen funktioniert
	 * 
	 * @throws RobotException
	 */
	@Test
	void roboterTest() throws RobotException {
		robot.triggerPowerSwitch();
		int[] ergebnis = robot.think(testNumbers);
		assertEquals("1,2,3,4,5,6,7,8", robot.speak(ergebnis));
	}
	
	/**
	 * Hier wird geprüft ob die RoboterException geworfen wird, dass er aus ist.
	 */
	@Test
	void turnedOffTest() {
		assertThrows(RobotIllegalStateException.class, () -> robot.think(testNumbers));
	}
	
	/**
	 * Hier wird die RobotMagicValueException geprüft ob sie geworfen wird, wenn die '42' vorhanden ist.
	 *
	 * @throws RobotException
	 */
	@Test
	void think42Test() throws RobotException {
		robot.triggerPowerSwitch();
		assertThrows(RobotMagicValueException.class, () -> robot.think(testNumbers42));	
	}
}
