package application;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * @author Shiting Yin
 * implement controller to get names of children
 */
public class GetChildrenController {
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
	 * define condition that suitable to get children's names of a adult
	 */
	public void okAction(ActionEvent event) {
		int i = AddController.find(name.getText(), AddController.personList);
		int k = GetParentController.findRelation(name.getText(), DefRelation1.relList, "parent");
		if(i != -1) {
			if(k != -1 && AddController.personList.get(i).getAge() > 16) {
				info.setText("");
				msg.setText("");
				info.setText(DefRelation1.relList.get(k).getName1() + " , " +
						DefRelation1.relList.get(k).getName2() + " , " +
						DefRelation1.relList.get(k).getRelation());
			}
			else {
				msg.setText("");
				info.setText("");
				msg.setText("Invalid person.");
				}
		}else {
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
