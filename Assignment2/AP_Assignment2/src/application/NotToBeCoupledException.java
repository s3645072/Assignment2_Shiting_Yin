package application;

public class NotToBeCoupledException extends Exception {
	
	public NotToBeCoupledException(String errMsg) {
		super(errMsg);
		System.out.println("Error message is: " + errMsg);
	}

}

