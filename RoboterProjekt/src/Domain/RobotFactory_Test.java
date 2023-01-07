package Domain;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

import Exceptions.RobotMagicValueException;

class RobotFactory_Test {

	/**
	 * Hier wird geprüft ob der Roboter R2D2 erfolgreich gebaut wird.
	 * 
	 */
	@Test
	void borderR2D2Test() {
		assertEquals("Testunit_R2D2", RoboterFabrik.order(RobotType.R2D2, "Testunit_R2D2").getName());
	}

	/**
	 * Hier wird geprüft ob der Roboter C3PO erfolgreich gebaut wird.
	 * 
	 */
	@Test
	void orderC3POTest() {
		assertEquals("Testunit_C3PO", RoboterFabrik.order(RobotType.C3PO, "Testunit_C3PO").getName());
	}


	/**
	 * Hier wird geprüft ob die RuntimeExceptionException geworfen wird, wenn kein
	 * Name eingegeben wurde.
	 */
	@Test
	void noNameTest() {
		assertThrows(RuntimeException.class, () -> RoboterFabrik.order(RobotType.C3PO, null));
	}
}
