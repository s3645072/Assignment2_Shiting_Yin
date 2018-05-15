package application;

public class NoSuchAgeException extends Exception {
	
	public NoSuchAgeException(String errMsg) {
		super(errMsg);
		System.out.println("Error message is: " + errMsg);
	}

}

