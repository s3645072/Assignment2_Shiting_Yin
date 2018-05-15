package application;

public class NotToBeClassmatesException extends Exception {
	
	public NotToBeClassmatesException(String errMsg) {
		super(errMsg);
		System.out.println("Error message is: " + errMsg);
	}

}

