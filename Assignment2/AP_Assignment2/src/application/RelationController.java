package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author Shiting Yin
 * list all of relation for person in a table
 */
public class RelationController implements Initializable{
	
	@FXML
	private TableView<Relation> relTable;
	@FXML
	private TableColumn<Relation, String> name1;
	@FXML
	private TableColumn<Relation, String> name2;
	@FXML
	private TableColumn<Relation, String> relation;
	@FXML
	private Button back;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name1.setCellValueFactory(new PropertyValueFactory<Relation, String>("name1"));
		name2.setCellValueFactory(new PropertyValueFactory<Relation, String>("name2"));
		relation.setCellValueFactory(new PropertyValueFactory<Relation, String>("relation"));
		relTable.setItems(DefRelation1.relList);
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
