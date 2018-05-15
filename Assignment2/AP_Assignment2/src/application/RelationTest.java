package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shiting Yin
 * using JUnit text to check function
 */
class RelationTest {
	
	private Relation rel;
	@BeforeEach
	void setUp() throws Exception {
		 rel = new Relation("Alex Smith", "James White", "friends");
	}

	@Test
	void testGetName1() {
		rel.getName1();
	}

	@Test
	void testGetName2() {
		rel.getName2();
	}

	@Test
	void testGetRelation() {
		rel.getRelation();
	}

}
