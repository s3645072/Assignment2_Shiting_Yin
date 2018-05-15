package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

/**
 * @author Shiting Yin
 * list all of person information in a table
 */
public class PersonController implements Initializable {
	@FXML
	private TableView<Person> table;
	@FXML
	private TableColumn<Person, String> name;
	@FXML
	private TableColumn<Person, String> image;
	@FXML
	private TableColumn<Person, String> status;
	@FXML
	private TableColumn<Person, String> gender;
	@FXML
	private TableColumn<Person, Integer> age;
	@FXML
	private TableColumn<Person, String> state;
	@FXML
	private Button back;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		image.setCellValueFactory(new PropertyValueFactory<Person, String>("image"));
		status.setCellValueFactory(new PropertyValueFactory<Person, String>("status"));
		gender.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
		age.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
		state.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));
		table.setItems(AddController.personList);
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


