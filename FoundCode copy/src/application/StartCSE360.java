package application;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.SQLException;

import application.View.DiscussionPageView;
import databasePart1.DatabaseHelper;


public class StartCSE360 extends Application {

	private static final DatabaseHelper databaseHelper = new DatabaseHelper();
	
	public static void main( String[] args )
	{
		 launch(args);
	}
	
	@Override
    public void start(Stage primaryStage) {
        try {
            databaseHelper.connectToDatabase(); 
            if (databaseHelper.isDatabaseEmpty()) {
            	
            	new FirstPage(databaseHelper).show(primaryStage);
            } else {
            	//DiscussionPageView discussionPageView = new DiscussionPageView();
            	//discussionPageView.show(primaryStage);
            	 new SetupLoginSelectionPage(databaseHelper).show(primaryStage);
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
    }
	

}

