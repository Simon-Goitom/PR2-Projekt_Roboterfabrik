package Domain;

import Exceptions.RobotException;
import Exceptions.RobotIllegalStateException;
import Domain.Roboter;

public class Nexus6 extends Roboter {
	static Nexus6 nexus = new Nexus6("Pris");

	private Nexus6(String name) {
		super(name);
		super.setId(19281982);

	}

	public static Nexus6 getNexus() {
		return nexus;
	}

	@Override
	public void triggerPowerSwitch() {
		super.setRoboterOn(false);

	}

	@Override
	public int[] think(int[] zahlen) throws RobotException {
		super.getList().add(new RobotIllegalStateException(super.getName()));
		throw new RobotIllegalStateException(super.getName());

	}

	@Override
	public String speak(int[] zahlen) throws RobotException {
		super.getList().add(new RobotIllegalStateException(super.getName()));
		throw new RobotIllegalStateException(super.getName());
	}

}
