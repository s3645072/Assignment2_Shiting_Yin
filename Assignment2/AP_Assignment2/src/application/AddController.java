package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Shiting Yin
 * implement controller for add a person
 */
public class AddController {
	@FXML	private TextField name;
	@FXML	private TextField image;
	@FXML	private TextField status;
	@FXML	private TextField gender;
	@FXML	private TextField age;
	@FXML	private TextField state;
	@FXML	private Label msg;
	@FXML	private Button register;
	@FXML	private Button back;
	
	public static ObservableList<Person> personList = FXCollections.observableArrayList();

	/**
	 * @param e
	 * control different limitation for different situation when add a person into persolList
	 */
	public void register(ActionEvent e)  {
		try {
			Integer age1 = Integer.valueOf(age.getText());
			Person p = new Person(name.getText(), image.getText(), status.getText(), gender.getText(), 
					age1, state.getText());
			if (name.getText() != null && age.getText() != null) {
				checkAge(age1);
				checkParent(age1, name.getText());
				personList.add(p);
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/Person.fxml").openStream());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				}
		}catch (NoSuchAgeException e2) {
			msg.setText("Age could not over than 150 or negative");
		}catch (NoParentException e3) {
			msg.setText("There is not matching parents.");
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @param x, pass a integer value of age
	 * @throws NoSuchAgeException, control the limit age range
	 */
	public void checkAge(int x) throws NoSuchAgeException {
		if (x > 150 || x < 0){
		throw new NoSuchAgeException("Age could not over than 150 or negative");
		}
	}
	
	
	/**
	 * @param x, a integer value for person that will be add into personList
	 * @param y, String value of relation for person that will be added
	 * @throws NoParentException
	 */
	public void checkParent(int x, String y) throws NoParentException {
		int p = DefRelation1.findRel(y, DefRelation1.relList);
		String r = "parent";
		if(x < 17) {
			if (p == -1 || (p != -1 && !DefRelation1.relList.get(p).getRelation().equals(r)) ){
					throw new NoParentException("There is not matching parents.");
				}
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
	
	/**
	 * @param name, a String name of person in personList
	 * @param personList
	 * @return integer value of index for person in the personList, if not return -1
	 */
	public static int find(String name, List<Person> personList) {
		for (int i=0; i<personList.size(); i++) 
			if (personList.get(i).getName().equals(name)) {
				return i;          
			}
		return -1;			
	}

}
