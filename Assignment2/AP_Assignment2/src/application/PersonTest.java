package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shiting Yin
 * using JUnit text to check function
 */
class PersonTest {
	private Person person;

	@BeforeEach
	void setUp() throws Exception {
		person = new Person("Alex Smith", "Alex.jpg", "Study at RMIT", "M", 28, "VIC");
	}

	@Test
	void testSetName() {
		person.setName("James White");		
	}

	@Test
	void testSetImage() {
		person.setImage("James.jpg");		
	}

	@Test
	void testSetStatus() {
		person.setStatus("working at RMIT");		
	}

	@Test
	void testSetGender() {
		person.setGender("M");		
	}

	@Test
	void testSetAgee() {
		person.setAgee(32);	
	}

	@Test
	void testSetState() {
		person.setState("VIC");	
	}

	@Test
	void testGetName() {
		person.getName();		
	}

	@Test
	void testGetImage() {
		person.getImage();		
	}

	@Test
	void testGetGender() {
		person.getGender();		
	}

	@Test
	void testGetStatus() {
		person.getStatus();		
	}

	@Test
	void testGetAge() {
		person.getAge();	
	}

	@Test
	void testGetState() {
		person.getState();		
	}

}
