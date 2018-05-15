package application;

public class NoParentException extends Exception{
	
	public NoParentException(String errMsg) {
		super(errMsg);
		System.out.println("Error message is: " + errMsg);
	}

}

