package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

/**
 * @author Shiting Yin
 * implement controller for display information of a person
 */
public class DisplayController {
	@FXML
	private Label namel;
	@FXML
	private TextField name;
	@FXML
	private TextField info;
	@FXML
	private Button ok;
	@FXML
	private Button back;
	@FXML
	private Label msg;

	/**
	 * @param event
	 * Event Listener on Button[#ok].onAction
	 */
	@FXML
	public void okAction(ActionEvent event) {
		int i = AddController.find(name.getText(), AddController.personList);
		if (i != -1) {
			msg.setText("");
			info.setText("");
			info.setText(AddController.personList.get(i).getName() + " | " +
					AddController.personList.get(i).getImage() + " | " + 
					AddController.personList.get(i).getStatus() + " | " +
					AddController.personList.get(i).getGender() + " | " +
					AddController.personList.get(i).getAge() + " | " +
					AddController.personList.get(i).getState() );
		}
		else {
			msg.setText("");
			info.setText("");
			msg.setText("Person not exist.");
		}
	}

	/**
	 * @param e
	 * Event Listener on Button[#back].onAction
	 * apply action back to main interface
	 */
	@FXML
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
