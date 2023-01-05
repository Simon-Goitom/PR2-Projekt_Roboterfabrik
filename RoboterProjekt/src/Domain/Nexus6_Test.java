package Domain;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Exceptions.RobotMagicValueException;

import org.junit.jupiter.api.Test;

class Nexus6_Test {
	int[] testNumbers = { 1, 3, 2, 4, 8, 7, 6, 5 };

	@Test
	void getTheNexusObjectTest() {
		assertEquals(Nexus6.nexus,Nexus6.getNexus());
	}
	
	@Test
	void serialNumberCheck() {
		assertEquals(19281982,Nexus6.getNexus().getId());
	}
	
	@Test
	void PowerSwitchTest() {
		Nexus6.getNexus().triggerPowerSwitch();
		assertTrue(Nexus6.getNexus().isPowerOn()==false);
	}
	@Test
	void getNameOfNexusObject() {
		assertEquals("Pris",Nexus6.getNexus().getName());
	}
	@Test
	void thinkExceptionTest() {
		Nexus6.getNexus().triggerPowerSwitch();
		assertThrows(RobotIllegalStateException.class,()->Nexus6.getNexus().think(testNumbers));
	}
	@Test
	void speakExceptionTest() {
		Nexus6.getNexus().triggerPowerSwitch();
		assertThrows(RobotIllegalStateException.class,()->Nexus6.getNexus().speak(testNumbers));
	}
	

}
