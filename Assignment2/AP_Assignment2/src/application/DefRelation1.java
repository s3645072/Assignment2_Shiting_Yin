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
 * implement defRelation function
 */
public class DefRelation1 {
	@FXML private Button ok;
	@FXML private Button back;
	@FXML private Label name1l;
	@FXML private Label name2l;
	@FXML private Label relationl;
	@FXML private Label msg;
	@FXML private TextField name1;
	@FXML private TextField name2;
	@FXML private TextField relation;
	
	public static ObservableList<Relation> relList = FXCollections.observableArrayList();
	
	/**
	 * @param e
	 * call relate method and handle exception
	 */
	public void ok(ActionEvent e) {
		try {
			applyOk();	
		}catch(NotToBeFriendsException e1) {
			msg.setText("AgeGap cannot greater than 3.");		
		}catch(TooYoungException e2) {
			msg.setText("Too young making friend failed");		
		}catch(NotToBeColleaguesException e3) {
			msg.setText("Child could not to be a colleague.");		
		}catch(NotToBeClassmatesException e4) {
			msg.setText("YoungChild could not to be a classmate.");		
		}catch(NoAvailableException e5) {
			msg.setText("One as couple already exist.");		
		}catch(NotToBeCoupledException e6) {
			msg.setText("Cannot to be couple as a child");		
		}catch(NoParentException e7) {
			msg.setText("There is not matching parents.");			
		}catch(NotFindPersonException e8) {
			msg.setText("Not find this person¡£");
		}catch(IOException e9) {
			e9.printStackTrace();			
		}
	}
	
	
	/**
	 * control limitation for define relation between two person
	 * @throws TooYoungException
	 * @throws NotToBeFriendsException
	 * @throws NotFindPersonException
	 * @throws NotToBeColleaguesException
	 * @throws NotToBeClassmatesException
	 * @throws NotToBeCoupledException
	 * @throws NoAvailableException
	 * @throws NoParentException
	 * @throws IOException
	 */
	public void applyOk() throws TooYoungException, NotToBeFriendsException, NotFindPersonException, 
	NotToBeColleaguesException, NotToBeClassmatesException, NotToBeCoupledException, NoAvailableException,
	NoParentException, IOException {
		String r1 = "friends";
		String r2 = "couple";
		String r3 = "classmates";
		String r4 = "colleagues";
		String r5 = "parent";
		if (name1.getText() != null && name2.getText() != null && relation.getText() != null) {
			Relation r = new Relation(name1.getText(), name2.getText(), relation.getText());
				int i = AddController.find(name1.getText(), AddController.personList);
				int j = AddController.find(name2.getText(), AddController.personList);
				int p = findRel(name1.getText(), relList);
				int q = findRel(name2.getText(), relList);
					if (relation.getText().equals(r1)) {
						if(i!=-1 && j!=-1) {
							if(AddController.personList.get(i).getAge() > 2 && 
									AddController.personList.get(i).getAge() < 17 &&
									AddController.personList.get(j).getAge() > 2 &&
									AddController.personList.get(j).getAge() < 17) {
								int ageGap = Math.abs(AddController.personList.get(i).getAge() - 
										AddController.personList.get(j).getAge());
								if(ageGap < 3) {
									relList.add(r);
									if(p != -1 && relList.get(p).getRelation().equals(r1)) {
										if(name1.getText().equals(relList.get(p).getName1())){
											Relation addR1 = new Relation(relList.get(p).getName2(), name2.getText(), r1); 
											relList.add(addR1);
										}
										else if(name1.getText().equals(relList.get(p).getName2())) {
											Relation addR2 = new Relation(relList.get(p).getName1(), name2.getText(), r1);
											relList.add(addR2);
										}
										else if(name2.getText().equals(relList.get(p).getName1())){
											Relation addR1 = new Relation(relList.get(p).getName2(), name1.getText(), r1); 
											relList.add(addR1);
										}
										else if(name2.getText().equals(relList.get(p).getName2())) {
											Relation addR2 = new Relation(relList.get(p).getName1(), name1.getText(), r1);
											relList.add(addR2);
										}
									}
									Stage primaryStage = new Stage();
									FXMLLoader loader = new FXMLLoader();
									Pane root = loader.load(getClass().getResource("/application/Relation.fxml").openStream());
									Scene scene = new Scene(root);
									scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
									primaryStage.setScene(scene);
									primaryStage.show();
								}else {
									msg.setText("AgeGap cannot greater than 3.");
									throw new NotToBeFriendsException("AgeGap cannot greater than 3.");	
									}
							}else if (AddController.personList.get(i).getAge() > 16 &&
									  AddController.personList.get(j).getAge() > 16) {
								relList.add(r);
								if(p != -1 && relList.get(p).getRelation().equals(r1)) {
									if(name1.getText().equals(relList.get(p).getName1())){
										Relation addR1 = new Relation(relList.get(p).getName2(), name2.getText(), r1); 
										relList.add(addR1);
									}
									else if(name1.getText().equals(relList.get(p).getName2())) {
										Relation addR2 = new Relation(relList.get(p).getName1(), name2.getText(), r1);
										relList.add(addR2);
									}
									else if(name2.getText().equals(relList.get(p).getName1())){
										Relation addR1 = new Relation(relList.get(p).getName2(), name1.getText(), r1); 
										relList.add(addR1);
									}
									else if(name2.getText().equals(relList.get(p).getName2())) {
										Relation addR2 = new Relation(relList.get(p).getName1(), name1.getText(), r1);
										relList.add(addR2);
									}
								}
								Stage primaryStage = new Stage();
								FXMLLoader loader = new FXMLLoader();
								Pane root = loader.load(getClass().getResource("/application/Relation.fxml").openStream());
								Scene scene = new Scene(root);
								scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								primaryStage.setScene(scene);
								primaryStage.show();
							}else {
								msg.setText("Too young cannot making friends.");
								throw new TooYoungException("Too young making friend failed");
							}
						}else {
								msg.setText("Person not exist.");
								throw new NotFindPersonException("There is not this person.");	
								}
						}else if(relation.getText().equals(r4)) {
							if(i!=-1 && j!=-1) {
								if(AddController.personList.get(i).getAge() > 17 &&
										AddController.personList.get(j).getAge() > 17) {
										relList.add(r);
										Stage primaryStage = new Stage();
										FXMLLoader loader = new FXMLLoader();
										Pane root = loader.load(getClass().getResource("/application/Relation.fxml").openStream());
										Scene scene = new Scene(root);
										scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
										primaryStage.setScene(scene);
										primaryStage.show();	
							}else {
								msg.setText("Child could not to be a colleague.");
								throw new NotToBeColleaguesException("Child could not to be a colleague.");	
								}
							}else {
								msg.setText("Person not exist.");
								throw new NotFindPersonException("There is not this person.");	
								}
						}else if(relation.getText().equals(r3)) {
							if(i!=-1 && j!=-1) {
								if(AddController.personList.get(i).getAge() > 2 &&
										AddController.personList.get(j).getAge() > 2) {
										relList.add(r);
										Stage primaryStage = new Stage();
										FXMLLoader loader = new FXMLLoader();
										Pane root = loader.load(getClass().getResource("/application/Relation.fxml").openStream());
										Scene scene = new Scene(root);
										scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
										primaryStage.setScene(scene);
										primaryStage.show();	
								}else {
									msg.setText("YoungChild could not to be a classmate.");
									throw new NotToBeClassmatesException("YoungChild could not to be a classmate.");	
									}
							}else {
								msg.setText("Person not exist.");
								throw new NotFindPersonException("There is not this person.");	
								}
						}else if(relation.getText().equals(r2)) {
							if (i != -1 && j != -1) {
								if(AddController.personList.get(i).getAge() > 17 &&
										AddController.personList.get(j).getAge() > 17) {
									int x = GetParentController.findRelation(name1.getText(), relList, r2);
									int y = GetParentController.findRelation(name2.getText(), relList, r2);
									if((p == -1 && q == -1) || ((p != -1 && x == -1 ) &&
											(q != -1 && y == -1 )) || (p != -1 && x == -1 && q == -1) || 
											(q != -1 && y == -1 && p == -1) ){
										relList.add(r);
										Stage primaryStage = new Stage();
										FXMLLoader loader = new FXMLLoader();
										Pane root = loader.load(getClass().getResource("/application/Relation.fxml").openStream());
										Scene scene = new Scene(root);
										scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
										primaryStage.setScene(scene);
										primaryStage.show();
									}else {
										msg.setText("One as couple already exist.");
										throw new NoAvailableException("One as couple already exist.");
									}
								}else {
									msg.setText("Cannot to be couple as a child");
									throw new NotToBeCoupledException("Cannot to be couple as a child");	
								}
							}else {
								msg.setText("Person not exist.");
								throw new NotFindPersonException("There is not this person.");
							}
						}else if(relation.getText().equals(r5)) {
							if((p!=-1 && q!= -1) && (p == -1 && relList.get(q).getRelation().equals(r2)) ||
									(q == -1 && relList.get(p).getRelation().equals(r2)) ||								
									(p != -1 && q != -1 && (relList.get(p).getRelation().equals(r2) ||
									 relList.get(q).getRelation().equals(r2)))) {
									relList.add(r);
									Stage primaryStage = new Stage();
									FXMLLoader loader = new FXMLLoader();
									Pane root = loader.load(getClass().getResource("/application/Relation.fxml").openStream());
									Scene scene = new Scene(root);
									scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
									primaryStage.setScene(scene);
									primaryStage.show();	
							}else {
								msg.setText("There is not matching parents.");
								throw new NoParentException("There is not matching parents.");	
								}
						}
		}else 
			msg.setText("Block cannot empty.");
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
	 * @param name, pass name that should be found in the relList
	 * @param relList
	 * @return integer value of index for person exist in the relList, if not exist return -1
	 */
	public static int findRel(String name, List<Relation> relList) {
		for (int i=0; i<relList.size(); i++) 
			if (relList.get(i).getName1().equals(name) ||
					relList.get(i).getName2().equals(name)) {
				return i;          
			}
		return -1;			
	}

}
