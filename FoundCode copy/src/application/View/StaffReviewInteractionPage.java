package application.View;

import application.viewModel.StaffViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class StaffReviewInteractionPage{
	
	public static void display(Stage stage) {
		StaffViewModel viewModel = new StaffViewModel();
		ObservableList<String> interactions = FXCollections.observableArrayList(viewModel.getFlaggedInteractions());
		
		ListView<String> interactionList = new ListView<>(interactions);
		
		Button markReviewed = new Button("Mark as Reviewed");
		markReviewed.setOnAction(e -> {
			String selected = interactionList.getSelectionModel().getSelectedItem();
			if(selected != null) {
				viewModel.markAsReviewed(selected);
				interactions.remove(selected);
			}
		});
		
		HBox bottomBar = new HBox(markReviewed);
		bottomBar.setSpacing(10);
		BorderPane root = new BorderPane();
		root.setCenter(interactionList);
		root.setBottom(bottomBar);
		
		Scene scene = new Scene(root, 400, 300);
		stage.setTitle("Flagged Interactions");
		stage.setScene(scene);
		stage.show();
		
	}
}