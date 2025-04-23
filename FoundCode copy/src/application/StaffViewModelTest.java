package test.application;

import application.viewModel.StaffViewModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StaffViewModelTest {

    @Test
    public void testGetFlaggedInteractions() {
        StaffViewModel viewModel = new StaffViewModel();
        List<String> flagged = viewModel.getFlaggedInteractions();

        assertFalse(flagged.isEmpty(), "Flagged interaction list should not be empty.");

    }

    @Test
    public void testMarkAsReviewed() {
        StaffViewModel viewModel = new StaffViewModel();
        
        // Get the initial list and choose the first item
        List<String> initialList = viewModel.getFlaggedInteractions();
        String toRemove = initialList.get(0);

        // Mark it as reviewed
        viewModel.markAsReviewed(toRemove);

        // Get the updated list
        List<String> updatedList = viewModel.getFlaggedInteractions();

        // Ensure it's no longer in the list
        assertFalse(updatedList.contains(toRemove), "The reviewed interaction should be removed.");
        assertEquals(initialList.size() - 1, updatedList.size(), "List size should decrease by 1.");

        
    }
}
