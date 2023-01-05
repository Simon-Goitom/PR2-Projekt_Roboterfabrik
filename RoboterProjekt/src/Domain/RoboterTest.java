package Domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.RobotException;

class RoboterTest {
	
	Roboter robot1 = new C3PO("name1");
	Roboter robot2 = new C3PO("name2");
	Roboter robot3 = new C3PO("name3");
	Roboter robot4 = new R2D2("name4");
	Roboter robot5 = new R2D2("name5");
	Roboter robot6 = new R2D2("name6");
	int[] testNumbers = {1,3,50,4,60,70,6,5};
	int[] unsortedNumbers = {70,60,50,6,5,4,3,1};
	int[] expected = {1,3,4,5,6,50,60,70};
	int[] testNumbers42 = {1,3,2,4,8,7,6,5,42};
	int[] numbSorted1 = new int[] { 165, 80, 70, 36, 25, 2, 1 };
	int[] numbUnsorted1 = new int[] { 1, 2, 25, 36, 70, 80, 165 };
	
	/**
	 * Hier wird geschaut ob die 'richtige' Seriennummer vergeben wird
	 */
	@Test
	void serialNumberTest() {

		assertTrue(robot1.getId() <= 19999);
		assertTrue(robot2.getId() <= 19999);
		assertTrue(robot3.getId() <= 19999);
		assertFalse(robot4.getId() >= 10000);
		assertFalse(robot5.getId() >= 10000);
		assertFalse(robot6.getId() >= 10000);
		assertTrue(robot4.getId() >= 0);
		assertTrue(robot5.getId() <= 9999);

	}
	/**
	 * Hier wird geprüft ob der Roboter richtig spricht
	 * 
	 * @throws RobotException
	 */
	@Test
	void speakTest() throws RobotException {
		robot4.triggerPowerSwitch();
		robot1.triggerPowerSwitch();
		assertEquals("1;3;50;4;60;70;6;5",robot1.speak(testNumbers));
		assertEquals("1,3,50,4,60,70,6,5", robot4.speak(testNumbers));
	}
	/**
	 * Hier wird geprüft ob die Zahlen richtig sortiert werden.
	 * 
	 * @throws RobotException
	 */
	@Test
	void thinkTest() throws RobotException {
		robot6.triggerPowerSwitch();
		robot2.triggerPowerSwitch();
		assertArrayEquals(numbSorted1, robot2.think(numbUnsorted1));
		assertArrayEquals(expected, robot6.think(testNumbers));
		
	}
	/**
	 *	Hier wird geprüft ob der Roboter wieder ausgemacht werden kann.
	 */
	@Test
	void isPowerOn() {
		robot1.triggerPowerSwitch();
		robot1.triggerPowerSwitch();
		
		assertFalse(robot1.isPowerOn());
	}
}
