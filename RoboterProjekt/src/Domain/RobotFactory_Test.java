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
	 * @throws InputMismatchException : Die wird geworfen, falls kein Name eingegeben wird
	 */
	@Test
	void borderR2D2Test() throws InputMismatchException {
		assertEquals("Testunit_R2D2",
				RobotFactory.bestellen(RobotType.R2D2, "Testunit_R2D2").getName());
	}
	
	/**
	 * Hier wird geprüft ob der Roboter C3PO erfolgreich gebaut wird.
	 * 
	 * @throws InputMismatchException
	 */
	@Test
	void orderC3POTest() throws InputMismatchException {
		assertEquals("Testunit_C3PO",
				RobotFactory.bestellen(RobotType.C3PO, "Testunit_C3PO").getName());
	}
	
	/**
	 * Hier wird geprüft ob die InputMismatchException geworfen wird, wenn kein Name eingegeben wurde.
	 * 
	 * @throws InputMismatchException
	 */
	@Test
	void noNameTest() throws InputMismatchException {
		assertThrows(InputMismatchException.class,
				() -> RobotFactory.bestellen(RobotType.C3PO, null));	
	}
}
