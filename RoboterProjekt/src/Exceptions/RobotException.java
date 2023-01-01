package Exceptions;

public class RobotException extends Exception {
	private String robotName;

	public RobotException(String message, String name) {
		super(message);
		this.robotName = name;
		
	}
	public String getRobotName() {
		return robotName;
	}
	
	

}
