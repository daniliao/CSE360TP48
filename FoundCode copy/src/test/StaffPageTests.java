package test;

import static org.junit.Assert.*;

import java.util.List;

import application.View.StaffPage;
import application.model.MessageStore;


import application.model.Answer;
import application.model.Message;
import application.model.Question;
import application.viewModel.DiscussionPageViewModel;
import javafx.collections.transformation.FilteredList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



import org.junit.Test;


/* JavaDoc in next section!
 * Useful doc for my team:
 * 
 * Get Answer & Question objects:
 * ------------------------------------
 * 
 * Get Question: vm.getQuestionInList().get(0);
 * 
 * Get Answer: vm.getQuestionAndAnswer().get(question).get(0);
 * 
 * Get Reply: vm.getQuestionAndAnswer().get(question).get(0).getReply().get(0);
 * 
 * ------------------------------------
 * ------------------------------------
 * 
 * Get Answer & Question in String:
 * 
 * Get question: vm.getQuestionInList().get(0).getQuestionFromUser();
 * 
 * Get answer: vm.getQuestionAndAnswer().get(question).get(0).getAnswerFromUser();
 * 
 * Get reply: vm.getQuestionAndAnswer().get(question).get(0).getReply().get(0).getAnswerFromUser();
 * 
 * 
 * Code walkthrough for get answer in String: 
 * 			   vm.getQuestionAndAnswer()         .get(question)    .get(0)          .getAnswerFromUser();
		       In the getQuestionAndAnswer map,  first question,   first answer,    retrieve answer
   
   To check FilteredList<Question> aList, you need to use and add question into this first: ObservableList<Question> questions = FXCollections.observableArrayList();
		       
		       
 */


/**
 * <p> Title: StaffPageTests </p>
 * 
 * <p> Description: Test class for verifying the behavior of the methods in the 
 * {@link StaffPageTests} class.
 * </p>
 * 
 * <p> Copyright: Matthew Cruz © 2025 </p>

 */

public class StaffPageTests {

	/**********
	 * This method tests CreateOrUpdateQuestion in viewModel by creating a new question 
	 * in the discussion page view model.
     * 
     * It verifies that a question is added to the list by checking its content
     * is as expected.
     * 
	 */
    @Test
    public void testAddMessage() {
        // Create a new message
        Message message = new Message("Staff", "Reviewer", "Test Message", "Now");

        // Add the message to the MessageStore
        MessageStore.addMessage(message);

        // Retrieve the messages from the MessageStore
        Message retrievedMessage = MessageStore.getAllMessages().get(0);

        // Verify that the message content is as expected
        assertEquals("Staff", retrievedMessage.getSender());
        assertEquals("Test Message", retrievedMessage.getContent());
    
}
    
    @Test
    public void testMessageProperties() {
    	StaffPage vm = new StaffPage("Staff");
        Message message = new Message("Reviewer", "Staff", "Test Message", "Now");
        

        // Assert that the sender is as expected
        assertEquals("Sender should be 'Reviewer'", "Reviewer", message.getSender());

        // Assert that the recipient is as expected
        assertEquals("Recipient should be 'Staff'", "Staff", message.getReceiver());

        // Assert that the content is as expected
        assertEquals("Content should be 'Test Message'", "Test Message", message.getContent());

        // Assert that the timestamp is as expected
        assertEquals("Timestamp should be 'Now'", "Now", message.getTimestamp());
    }
    
    @Test
    public void testStaffPageCreation() {
        String staffUsername = "Staff";

        StaffPage staffPage = new StaffPage(staffUsername);

        // Assert that the staffPage instance is not null
        assertNotNull("StaffPage instance should not be null", staffPage);
    
}
    
    @Test
    public void testStaffUsernameAssignment() {
        String expectedUsername = "Staff";

        // Create an instance of StaffPage 
        StaffPage staffPage = new StaffPage(expectedUsername);

        // Retrieve the staff username from the staffPage instance
        String actualUsername = staffPage.getStaffUsername();

        // Assert that the actual username matches the expected username
        assertEquals("Staff username should match the expected value", expectedUsername, actualUsername);
    }
    
    @Test
    public void testStaffPageTitleInitialization() {
        String staffUsername = "StaffMember";

        // Expected title based on the staff username
        String expectedTitle = "Staff Messaging Pane";

        // Create an instance of StaffPage with the hardcoded username
        StaffPage staffPage = new StaffPage(staffUsername);

        // Retrieve the title from the staffPage instance
        String actualTitle = staffPage.getTitle();

        // Assert that the actual title matches the expected title
        assertEquals("The staff page title should match the expected value.", expectedTitle, actualTitle);
    }




}

