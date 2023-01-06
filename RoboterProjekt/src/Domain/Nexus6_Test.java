package Domain;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;

import org.junit.jupiter.api.Test;

class Nexus6_Test {
	int[] testNumbers = { 1, 3, 2, 4, 8, 7, 6, 5 };

	/**
	 * Hier wird getestet, ob die statische Methode getNexus() das einzige Nexus6
	 * Objekt zur�ckgibt.
	 */
	@Test
	void getNexusMethodTest() {
		assertTrue(Nexus6.getNexus() instanceof Nexus6);
	}

	/**
	 * Hier wird getestet, ob die Seriennummer stimmt.
	 */
	@Test
	void serialNumberCheck() {
		assertEquals(19281982, Nexus6.getNexus().getId());
	}

	/**
	 * Hier wird gepr�ft, ob die Power-Taste funktioniert bzw. defekt ist.
	 */
	@Test
	void PowerSwitchTest() {
		Nexus6.getNexus().triggerPowerSwitch();
		assertTrue(Nexus6.getNexus().isPowerOn() == false);
	}

	/**
	 * Hier wird gepr�ft, ob das Nexus6 Objekt den richtigen Namen hat.
	 */
	@Test
	void getNameOfNexusObject() {
		assertEquals("Pris", Nexus6.getNexus().getName());
	}

	/**
	 * Hier wird getestet,ob die think-Mtehode eine Exception wirft.
	 */
	@Test
	void thinkExceptionTest() {
		Nexus6.getNexus().triggerPowerSwitch();
		assertThrows(RobotIllegalStateException.class, () -> Nexus6.getNexus().think(testNumbers));
	}

	/**
	 * Hier wird getestet,ob die think-Mtehode eine Exception wirft.
	 */
	@Test
	void speakExceptionTest() {
		Nexus6.getNexus().triggerPowerSwitch();
		assertThrows(RobotIllegalStateException.class, () -> Nexus6.getNexus().speak(testNumbers));
	}
	
	/**
	 * Hier wird getestet ob die Exception auch wirklich im Fehlerspeicher des Roboters gespeichert wird
	 */
	@Test
	void blackBoxTest() {
		try {
			Nexus6.getNexus().think(testNumbers);
		} catch (RobotException e) {
		}
		assertTrue(Nexus6.getNexus().getLastException() instanceof RobotIllegalStateException);
	}

}
