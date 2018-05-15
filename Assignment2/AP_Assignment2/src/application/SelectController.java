package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * @author Shiting Yin
 * implement controller for select a person that to check whether a person list in personList
 */
public class SelectController {
	@FXML
	private Label namel;
	@FXML
	private Label msg;
	@FXML
	private TextField name;
	@FXML
	private Button ok;
	@FXML
	private Button back;
	
	public void ok(ActionEvent e)  {
		int i = AddController.find(name.getText(), AddController.personList);
		if (i != -1) {
			msg.setText("Person exist.");
		}
		else
			msg.setText("Person not exist.");
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
