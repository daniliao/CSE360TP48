package application.View;
import java.util.List;
import java.util.stream.Collectors;

import application.model.Message;
import application.model.MessageStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffPage{
	
	public final String staffUsername;
	
	public StaffPage(String staffUsername) {
		this.staffUsername = staffUsername;
	}
	
	public void show(Stage stage) {
		VBox layout = new VBox(10);
		layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
		
		Label prompt = new Label("Message a Reviewer");
		TextField reviewerField = new TextField();
		reviewerField.setPromptText("Enter Reviewer username");
		TextArea messageArea = new TextArea();
		messageArea.setPromptText("Enter Your Message...");
		Button send = new Button("Send");
		
		send.setOnAction(e -> {
			
			String reviewer = reviewerField.getText();
			String message = messageArea.getText();
			
			Message m = new Message(staffUsername, reviewer, message, "Now");
			MessageStore.addMessage(m);
			
			reviewerField.clear();
			messageArea.clear();
		});
		
		layout.getChildren().addAll(prompt, reviewerField, messageArea, send);
		stage.setScene(new Scene(layout, 800, 400));
		stage.setTitle("Staff Messaging Pane");
		stage.show();
		
	}

	public List<Message> getReceivedMessages() {
	    // Retrieve messages where the recipient is the current staff member
	    return MessageStore.getAllMessages().stream()
	            .filter(message -> message.getReceiver().equals(staffUsername))
	            .collect(Collectors.toList());
	}

	public String getStaffUsername() {
		// TODO Auto-generated method stub
		return staffUsername;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return "Staff Messaging Pane";
	}

	
	
}