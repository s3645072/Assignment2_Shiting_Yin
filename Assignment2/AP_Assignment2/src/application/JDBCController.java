package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
 
import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shiting Yin
 * connect java with database through JDBC
 *
 */
public class JDBCController {
	@FXML
	private Label msg;
	@FXML
	private Button back;
	@FXML
	private Button people;
	@FXML
	private Label guide;
	@FXML
	private Button relations;
	@FXML
	private TextField info;
	
	Connection connection = null;
	ResultSet rs = null;
	
	String url = "jdbc:mysql://127.0.0.1:3306/mininet_database?serverTimezone=UTC";
	String username = "root";
	String password = "258369";
	
	/**
	 * @param event
	 * Event Listener on Button[#people].onAction
	 * connect java with table "people" in database, and show information to prove it connected successfully 
	 */
	@FXML
	public void peopleAction(ActionEvent event) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =
			DriverManager.getConnection(url, username, password);
			
		// // query from the db
			rs = connection.prepareStatement("select * from people;").executeQuery();
			while(rs.next()){
				info.setText(String.format("Name: %1s, Image: %1s, Status: %1s, Gender: %1s, Age: %1d, State: %1s", 
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
	            System.out.println(String.format("Name: %1s, Image: %1s, Status: %1s, Gender: %1s, Age: %1d, State: %1s", 
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
	            msg.setText("Connet to JDBC successfully :)");
	            connection.setAutoCommit(false);
	        }

	        rs.close();
	        connection.close();
			
		} catch (SQLException e2) {
			msg.setText("Error with SQL");
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 * @param event
	 * Event Listener on Button[#relations].onAction
	 * connect java with table "relations" in database, and show information to prove it connected successfully 
	 */
	@FXML
	public void relationsAction(ActionEvent event) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =
			DriverManager.getConnection(url, username, password);
			
		// // query from the db
			rs = connection.prepareStatement("select * from relations;").executeQuery();
			while(rs.next()){	 
				info.setText(String.format("Name1: %1s, Name2: %1s, Relation: %1s", 
						rs.getString(1), rs.getString(2), rs.getString(3)));				
	            System.out.println(String.format("Name1: %1s, Name2: %1s, Relation: %1s", 
						rs.getString(1), rs.getString(2), rs.getString(3)));
	            msg.setText("Connet to JDBC successfully :)");
	            connection.setAutoCommit(false);
	        }
	        rs.close();
	        connection.close();			
		} catch (SQLException e2) {
			msg.setText("Error with SQL");
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
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
