package application;

public class NotToBeColleaguesException extends Exception {

		public NotToBeColleaguesException(String errMsg) {
			super(errMsg);
			System.out.println("Error message is: " + errMsg);
		}

	}

