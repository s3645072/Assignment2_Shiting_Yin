package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

/**
 * @author Shiting Yin
 */
public class Person {
	
	private final SimpleStringProperty name;
	private final SimpleStringProperty image;
	private final SimpleStringProperty status;
	private final SimpleStringProperty gender;
	private final SimpleIntegerProperty age;
	private final SimpleStringProperty state;
	
	/**
	 * A Class with basic parameters for a person
	 * @param name The string to Person
	 * @param image The string to Person
	 * @param status The string to Person
	 * @param gender The string to Person
	 * @param age The age to Person
	 * @param state The string to Person
	 */
	public Person(String name, String image, String status, String gender, Integer age, String state) {
		this.name = new SimpleStringProperty(name);
		this.image = new SimpleStringProperty(image);
		this.status = new SimpleStringProperty(status);
		this.gender = new SimpleStringProperty(gender);
		this.age = new SimpleIntegerProperty(age);
		this.state = new SimpleStringProperty(state);
		
	}
	
	/**
	 * Set a name of a person
	 * @param name The String to a Person
	 */
	public final void setName(String name) {
		this.name.set(name);
	}
	/**
	 * Set a image of a person
	 * @param image The String to a Person
	 */
	public final void setImage(String image) {
		this.image.set(image);
	}
	/**
	 * Set a status of a person
	 * @param status The String to a Person
	 */
	public final void setStatus(String status) {
		this.status.set(status);
	}
	/**
	 * Set a gender of a person
	 * @param gender The String to a Person
	 */
	public final void setGender(String gender) {
		this.gender.set(gender);
	}
	/**
	 * Set a age of a person
	 * @param age The Integer to a Person
	 */
	public final void setAgee(Integer age) {
		this.age.set(age);
	}
	/**
	 * Set a state of a person
	 * @param state The String to a Person
	 */
	public final void setState(String state) {
		this.state.set(state);
	}
	/**
	 * Get a name of a person
	 * @return A type of string name of a person
	 */
	public final String getName() {
		return name.get();
	}
	/**
	 * Get a image of a person
	 * @return A type of string image of a person
	 */
	public final String getImage() {
		return image.get();
	}
	/**
	 * Get a gender of a person
	 * @return A type of string gender of a person
	 */
	public final String getGender() {
		return gender.get();
	}
	/**
	 * Get a status of a person
	 * @return A type of string status of a person
	 */
	public final String getStatus() {
		return status.get();
	}
	/**
	 * Get age of a person
	 * @return A type of Integer age of a person
	 */
	public final Integer getAge() {
		return age.get();
	}
	/**
	 * Get a state of a person
	 * @return A type of string state of a person
	 */
	public final String getState() {
		return state.get();
	}
	
}
