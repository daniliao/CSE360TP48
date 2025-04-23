//Imported from HW4 (Almakki)

package test;

import application.model.Question;
import application.viewModel.DiscussionPageViewModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Basic JUnit test to verify the view model loads sample data correctly.
 */
public class StaffHomePageTest {

    @Test
    public void testQuestionListPopulation() {
        DiscussionPageViewModel vm = new DiscussionPageViewModel();

        Question q1 = new Question("Is this working?");
        vm.getQuestionInList().add(q1);

        assertFalse(vm.getQuestionInList().isEmpty(), "Question list should not be empty");
        assertEquals("Is this working?", vm.getQuestionInList().get(0).getQuestionFromUser(), "First question should match");
    }
}
