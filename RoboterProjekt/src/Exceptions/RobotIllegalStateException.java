package Exceptions;

public class RobotIllegalStateException extends RobotException {

	public RobotIllegalStateException(String name) {
		super("Roboter ist aus", name);

	}

}
