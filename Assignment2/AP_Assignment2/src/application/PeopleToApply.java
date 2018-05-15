package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Shiting Yin
 * read text files and apply them with limitation for 
 * add a person to check whether it is works well
 */
public class PeopleToApply {
	
	@FXML private Label msg;
	@FXML private Button back;
	@FXML private Button ok;
	
	AddController ac = new AddController();
	DefRelation1 dr = new DefRelation1();
	
	/**
	 * @param e
	 * read both people and relation file and apply method that limit add a person to personList
	 */
	public void okAction(ActionEvent e) {
		try {
			BufferedReader relations = new BufferedReader(new FileReader("relations.txt"));
			String next1 = new String();
			next1 = relations.readLine();
			while (next1 != null) {
				String words1[] = next1.split(",");
					if (words1[0] != null && words1[1] != null && words1[2] != null) {
						Relation r = new Relation(words1[0], words1[1], words1[2]);
						DefRelation1.relList.add(r);
					}
					next1 = relations.readLine(); 
			} 
			relations.close();
			
			BufferedReader people = new BufferedReader(new FileReader("people.txt"));
			String next = new String();
			next = people.readLine();
			while (next != null) {
				try {
					String words[] = next.split(",");
					Integer age1 = Integer.valueOf(words[4].trim());
						if (words[0] != null && words[4] != null) {
							ac.checkAge(age1);
							ac.checkParent(age1, words[0]);
							Person p = new Person(words[0], words[1], words[2], words[3], 
									age1, words[5]);
							AddController.personList.add(p);
							Stage primaryStage = new Stage();
							FXMLLoader loader = new FXMLLoader();
							Pane root = loader.load(getClass().getResource("/application/Person.fxml").openStream());
							Scene scene = new Scene(root);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.show();	
						}
				}catch(NoParentException e7) {
					msg.setText("There is not matching parents.");	
				}catch (NoSuchAgeException e8) {
					msg.setText("Age could not over than 150 or negative");
				}
					next = people.readLine(); 
			} 
			people.close();	
		} catch (IOException ioe) {
			msg.setText("File Reading Error!");
		}catch (Exception e9) {
			e9.printStackTrace();
		}
		
	}
	
	/**
	 * @param e
	 * apply action back to main interface
	 */
	public void back(ActionEvent e) {
		try {
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
