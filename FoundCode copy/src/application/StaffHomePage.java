// Imported From HW4 (Almakki)

package application;

import application.model.Question;
import application.model.Answer;
import application.viewModel.DiscussionPageViewModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * The StaffHomePage class displays a simple UI for staff users to view
 * questions, their corresponding answers, and any nested replies.
 */
public class StaffHomePage {

    // Reference to the ViewModel containing all questions and answers
    private final DiscussionPageViewModel viewModel;

    
     // Constructs a StaffHomePage with a provided ViewModel.

    public StaffHomePage(DiscussionPageViewModel vm) {
        this.viewModel = vm;
    }


   // Initializes and displays the staff interface.

    public void show(Stage primaryStage) {
        // Main layout
        VBox layout = new VBox(10);

        // Page header
        Label title = new Label("Staff View");

        // Question list populated from the ViewModel
        ListView<Question> questionList = new ListView<>(viewModel.getQuestionInList());

        // Text area to display selected question's answers and replies
        TextArea answerBox = new TextArea();
        answerBox.setEditable(false);

        //  when a question is selected, display its answers and replies
        questionList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selectedQuestion) -> {
            if (selectedQuestion != null) {
                // Retrieve answers for the selected question
                List<Answer> answers = viewModel.getQuestionAndAnswer().get(selectedQuestion);
                StringBuilder text = new StringBuilder();

                // Append each answer and its nested replies to the text output
                for (Answer a : answers) {
                    text.append("Answer: ").append(a.getAnswerFromUser()).append("\n");
                    for (Answer reply : a.getReply()) {
                        text.append("   Reply: ").append(reply.getAnswerFromUser()).append("\n");
                    }
                }

                // Display answers and replies in the answer viewer
                answerBox.setText(text.toString());
            }
        });

        // Assemble the UI layout
        layout.getChildren().addAll(title, questionList, answerBox);

        // Configure and display the scene
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Page");
        primaryStage.show();
    }
}
