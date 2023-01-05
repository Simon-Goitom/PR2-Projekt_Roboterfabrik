package Exceptions;

public class RobotIllegalStateException extends RobotException {

	public RobotIllegalStateException(String name) {
		super("Robot turned off", name);

	}

}
