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
 * implement controller to get names of parents of a child
 */
public class GetParentController {
	@FXML
	private Label namel;
	@FXML
	private TextField name;
	@FXML
	private TextField info;
	@FXML
	private TextField info1;
	@FXML
	private Button ok;
	@FXML
	private Button back;
	@FXML
	private Label msg;
	
	/**
	 * @param event
	 * define condition that suitable to get parents' names of a child
	 */
	public void okAction(ActionEvent event) {
		int i = AddController.find(name.getText(), AddController.personList);
		int k = findRelation(name.getText(), DefRelation1.relList, "parent");
		if(i != -1) {
			if(k != -1 && AddController.personList.get(i).getAge() < 17 ) {
				int x = findRelation(DefRelation1.relList.get(k).getName1(), DefRelation1.relList, "couple");
				int y = findRelation(DefRelation1.relList.get(k).getName2(), DefRelation1.relList, "couple");
				if(x != -1 && y == -1) {
					info.setText("");
					info1.setText("");
					msg.setText("");
					info.setText(DefRelation1.relList.get(k).getName1() + " , " +
							     DefRelation1.relList.get(k).getName2() + " , " +
							     DefRelation1.relList.get(k).getRelation());
					info1.setText(DefRelation1.relList.get(x).getName1() + " , " +
								  DefRelation1.relList.get(x).getName2() + " , " +
								  DefRelation1.relList.get(x).getRelation());
				}
				else if(y != -1 && x == -1) {
					info.setText("");
					info1.setText("");
					msg.setText("");
					info.setText(DefRelation1.relList.get(k).getName1() + " , " +
							     DefRelation1.relList.get(k).getName2() + " , " +
							     DefRelation1.relList.get(k).getRelation());
					info1.setText(DefRelation1.relList.get(y).getName1() + " , " +
								  DefRelation1.relList.get(y).getName2() + " , " +
								  DefRelation1.relList.get(y).getRelation());
				}
				else {
					info.setText("");
					info1.setText("");
					msg.setText("");
					msg.setText("Not valid relation.");
				}
			}else {
				msg.setText("");
				info.setText("");
				info1.setText("");
				msg.setText("Invalid person.");
			}
		}else {
			msg.setText("");
			info.setText("");
			info1.setText("");
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
	
	
	/**
	 * @param name
	 * @param relList
	 * @param relation
	 * @return integer index of a person listed in the relList that limited by special relation,
	 * if not suitable for conditions or not exist, return -1
	 */
	public static int findRelation(String name, List<Relation> relList, String relation) {
		for(int i=0; i<relList.size(); i++) {
			if((relList.get(i).getName1().equals(name) || relList.get(i).getName2().equals(name)) &&
					relList.get(i).getRelation().equals(relation)) {
				return i;
			}	
	}
		return -1;
	}
	
}

	
