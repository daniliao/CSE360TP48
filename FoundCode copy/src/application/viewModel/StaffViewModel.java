package application.viewModel;

import java.util.ArrayList;
import java.util.List;

public class StaffViewModel{
	private List<String> flagged = null;
	
	public StaffViewModel(){
		
		flagged = new ArrayList<>();
		//Example flagged data
		flagged.add("Question flagged by users: How do I reset my password?");
		flagged.add("Private feedback flagged as inappropriate");
		flagged.add("Answer downvoted by multiple reviewers: Check logic in asnwer to Q50");
	}
	
	public List<String> getFlaggedInteractions(){
		return new ArrayList<>(flagged);
	}
	
	public void markAsReviewed(String interaction) {
		flagged.remove(interaction);
	}
}