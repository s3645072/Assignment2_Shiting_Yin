package application;

public class NotFindPersonException extends Exception {
	
	public NotFindPersonException(String errMsg) {
		super(errMsg);
		System.out.println("Error message is: " + errMsg);
	}

}
