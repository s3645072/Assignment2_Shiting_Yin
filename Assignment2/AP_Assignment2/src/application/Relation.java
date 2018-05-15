package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Shiting Yin
 */
public class Relation {
	
	private final SimpleStringProperty name1;
	private final SimpleStringProperty name2;
	private final SimpleStringProperty relation;
	
	/**
	 * A Class with basic parameters for different relations
	 * @param name1 The String to Relation
	 * @param name2 The String to Relation
	 * @param relation The String to Relation
	 */
	public Relation(String name1, String name2, String relation) {
		this.name1 = new SimpleStringProperty(name1);
		this.name2 = new SimpleStringProperty(name2);
		this.relation = new SimpleStringProperty(relation);		
	}
	
	/**
	 * Get name1 of a relation
	 * @return A type of string name of first person showed in a relation
	 */
	public String getName1() {
		return name1.get();
	}
	/**
	 * Get name2 of a relation
	 * @return A type of string name of second person showed in a relation
	 */
	public String getName2() {
		return name2.get();
	}
	/**
	 * Get relation of a relation
	 * @return A type of string relation showed in a relation
	 */
	public String getRelation() {
		return relation.get();
	}

}
