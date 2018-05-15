package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * implement all of button actions. 
 *
 */
/**
 * @author Shiting Yin
 * implement all of interaction with buttons show on the main interface
 */

public class MainController implements Initializable {
	
	@FXML	private Button readPeo;
	@FXML	private Button readRel;
	@FXML	private Button apply;	
	@FXML	private Button JDBC;
	@FXML	private Button exit;
	@FXML	private ListView listview;	
	@FXML	private TableView<Person> person;
	@FXML	private TableColumn<Person, String> name;
	@FXML	private TableColumn<Person, String> image;
	@FXML	private TableColumn<Person, String> status;
	@FXML	private TableColumn<Person, String> gender;
	@FXML	private TableColumn<Person, Integer> age;
	@FXML	private TableColumn<Person, String> state;
	
	
	/**
	 * implement button peopleFile
	 */
	public void readPeopleAction(ActionEvent e) {
		listview.getItems().clear();
		try {
			BufferedReader people = new BufferedReader(new FileReader("people.txt"));
			String next = people.readLine();
			while (next != null) {
				listview.getItems().add(next);
				next = people.readLine();
			}
			people.close();
		} catch (IOException ioe) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
	
	/**
	 * @param s for pass value with type of String
	 * @return String[] to save the pass String value
	 */
	public String[] breakString(String s) {

		StringTokenizer stoken = new StringTokenizer(s,",");
		String words[] = new String[6];
		
		for(int i=0; i<6; i++) {
			while (stoken.hasMoreTokens()) {
				words[i] = stoken.nextToken();
			}
		}
		return words;
	}
	
	/**
	 * implement button relationFile
	 */
	public void readRelationAction(ActionEvent e) {
		listview.getItems().clear();
		try {
			BufferedReader people = new BufferedReader(new FileReader("relations.txt"));
			String next = people.readLine();
			while (next != null) {
				listview.getItems().add(next);
				next = people.readLine();
			}
			people.close();
		} catch (IOException ioe) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
	
	/**
	 * interact with button TestPeople
	 */
	public void applyAction(ActionEvent e) {
		try {
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/PeopleToApply.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button JDBC
	 */
	public void JDBCAction(ActionEvent e) {
		try {
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/JDBC.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button Add
	 */
	public void addAction(ActionEvent e) {
		try {
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Add.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button select
	 */
	public void select(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Select.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button delete
	 */
	public void delete(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Delete.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button display
	 */
	public void display(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Display.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button getParent
	 */
	public void getParent(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/GetParent.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button getChildren
	 */
	public void getChildren(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/GetChildren.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * interact with button defRelation
	 */
	public void defRelationAction(ActionEvent e) {
		try {
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/DefRelation.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * implement button display
	 */
	public void exitAction(ActionEvent e) {
		listview.getItems().clear();
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
