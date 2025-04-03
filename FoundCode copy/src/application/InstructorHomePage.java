package application;

import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.View.DiscussionPageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import databasePart1.*;

public class InstructorHomePage {
	public void show(DatabaseHelper database, Stage primaryStage) {
    	VBox layout = new VBox();
	    layout.setStyle("-fx-alignment: center; -fx-padding: 20;");
	    
	    // Label to display Hello user
	    Label Instructor_Label = new Label("Hello, Instructor.");
	    Instructor_Label.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");


        // Create a new Log Out button
        Button logoutButton = new Button("Log Out");

        // Action for the Log Out button
        logoutButton.setOnAction(a -> {
            // Redirect to the login selection page
            new SetupLoginSelectionPage(new databasePart1.DatabaseHelper()).show(primaryStage);
        });
        
        
        
        ListView<String> userList = fetchUserList(database);


        // Add the new Label and Button to the layout
        layout.getChildren().addAll(Instructor_Label, userList, logoutButton);
	    Scene Instructor_Scene = new Scene(layout, 800, 400);
	    

	    // Set the scene to primary stage
	    primaryStage.setScene(Instructor_Scene);
	    primaryStage.setTitle("Instructor Page");
    	
    }
	
	private ListView<String> fetchUserList(DatabaseHelper database) {
        ListView<String> userList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        
        try {
            ResultSet rs = database.getAllUsers();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String role = rs.getString("role");
                items.add(String.format("Username: %s | Role: %s", userName, role));
            }
            userList.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return userList;
    }
	

}
