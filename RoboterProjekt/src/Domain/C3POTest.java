package Domain;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;

class C3POTest {

	C3PO robot1 = new C3PO("name1");
	C3PO robot2 = new C3PO("name2");
	C3PO robot3 = new C3PO("name3");
	C3PO robot4 = new C3PO("name1");
	C3PO robot5 = new C3PO("name2");
	C3PO robot6 = new C3PO("name3");
	int[] testNumbers = { 1, 3, 2, 4, 8, 7, 6, 5 };
	int[] testNumbers42 = { 1, 3, 2, 4, 8, 7, 6, 5, 42 };

	/**
	 * Hier wird der Schalter getestet
	 */
	@Test
	void triggerPowerSwitchTest() {
		robot2.triggerPowerSwitch();
		assertEquals(true, robot2.isPowerOn());
	}

	/**
	 * Hier wird gepr�ft, ob der Roboter an ist
	 */
	@Test
	void isPowerOnTest() {
		assertEquals(false, robot5.isPowerOn());
	}

	/**
	 * Hier wird gepr�ft, ob die RoboterException geworfen wird, dass er aus ist.
	 */
	@Test
	void turnedOffTest() {
		assertThrows(RobotIllegalStateException.class, () -> robot3.think(testNumbers));
	}

	/**
	 * Hier wird geschaut ob die 'richtige' Seriennummer vergeben wird
	 */
	@Test
	void serialNumberTest() {

		assertTrue(robot1.getId() <= 19999);
		assertTrue(robot2.getId() <= 19999);
		assertTrue(robot3.getId() <= 19999);
		assertTrue(robot1.getId() >= 10000);
		assertTrue(robot2.getId() >= 10000);
		assertTrue(robot3.getId() >= 10000);

	}

	/**
	 * Hier wird gepr�ft ob die Zahlen absteigend sortiert werden.
	 * 
	 * @throws RobotException
	 */
	@Test
	void thinkTest() throws RobotException {
		robot4.triggerPowerSwitch();
		robot5.triggerPowerSwitch();
		robot6.triggerPowerSwitch();
		int[] numbSorted1 = new int[] { 165, 80, 70, 36, 25, 2, 1 };
		int[] numbUnsorted1 = new int[] { 1, 2, 25, 36, 70, 80, 165 };
		int[] numbSorted2 = new int[] { 5000, 4890, 4750, 4563, 1500, 600, 30 };
		int[] numbUnsorted2 = new int[] { 5000, 1500, 4563, 600, 4750, 30, 4890 };

		assertArrayEquals(numbSorted1, robot4.think(numbUnsorted1));
		assertArrayEquals(numbSorted2, robot5.think(numbUnsorted2));

	}

	/**
	 * Hier wird bei der speak-Methode getestet , ob einen RobotMagicValueException
	 * geworfen wird, wenn die Zahl 42 vorhanden.
	 */
	@Test
	public void speakExceptionTest() {
		robot2.triggerPowerSwitch();
		assertThrows(RobotMagicValueException.class, () -> robot2.speak(new int[] { 1, 2, 42 }));
	}

	/**
	 * Hier wird bei der think-Methode getestet , ob einen RobotMagicValueException
	 * geworfen wird, wenn die Zahl 42 vorhanden.
	 */
	@Test
	public void thinkExceptionTest() {
		robot2.triggerPowerSwitch();
		assertThrows(RobotMagicValueException.class, () -> robot2.think(new int[] { 1, 2, 42 }));
	}

	/**
	 * Hier wird die RobotMagicValueException gepr�ft, ob sie geworfen wird, wenn
	 * die '42' vorhanden ist.
	 *
	 * @throws RobotException
	 */
	@Test
	void think42Test() throws RobotException {
		robot6.triggerPowerSwitch();
		assertThrows(RobotMagicValueException.class, () -> robot6.think(testNumbers42));
	}
	
	/**
	 * Hier wird getestet ob die Exception auch wirklich im Fehlerspeicher des Roboters gespeichert wird
	 */
	@Test
	void blackBoxTest() {
		try {
			robot1.think(testNumbers);
		} catch (RobotException e) {
		}
		assertTrue(robot1.getLastException() instanceof RobotIllegalStateException);
	}

}
