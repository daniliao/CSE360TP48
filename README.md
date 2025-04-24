# CSE360 Team Project | Wednesday 48

Team Member: 
Mohammed Almakki, 
Matthew Cruz, 
Octavian Englund, 
Ricardo Guerrero, 
Cristian Holguin, 
DANIEL YI-CHIAN LIAO


### Video explains the code: 

https://youtu.be/bRd41rjYCq8


## 1.  As a staff member, I want to view questions and their answers so I can monitor student interactions.

```java

// Question list populated from the ViewModel
ListView<Question> questionList = new ListView<>(viewModel.getQuestionInList());

// Text area to display selected question's answers and replies
TextArea answerBox = new TextArea();
answerBox.setEditable(false);



```





### 2. As a staff member, I want to view nested replies to answers so I can track discussions in detail.

```java

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


```






## New files from team project 3 to team project 4

```
View
└──DiscussionPageView.class
```

```
model
└──Answer.class
└──Answers.class
└──Question.class
└──Questions.class
```

```
viewModel
└── DiscussionPageViewModel.class
```

```
.
├── FoundCode copy
│   ├── bin
│   │   ├── application
│   │   │   ├── AdminHomePage.class
│   │   │   ├── AdminSetupPage.class
│   │   │   ├── FirstPage.class
│   │   │   ├── InvitationPage.class
│   │   │   ├── SetupAccountPage.class
│   │   │   ├── SetupLoginSelectionPage.class
│   │   │   ├── StartCSE360.class
│   │   │   ├── User.class
│   │   │   ├── UserHomePage.class
│   │   │   ├── UserLoginPage.class
│   │   │   ├── View
│   │   │   │   └── DiscussionPageView.class
│   │   │   ├── WelcomeLoginPage.class
│   │   │   ├── model
│   │   │   │   ├── Answer.class
│   │   │   │   ├── Answers.class
│   │   │   │   ├── Question.class
│   │   │   │   └── Questions.class
│   │   │   └── viewModel
│   │   │       └── DiscussionPageViewModel.class
│   │   ├── databasePart1
│   │   │   └── DatabaseHelper.class
│   │   └── module-info.class
│   └── src
│       ├── application
│       │   ├── AdminHomePage.java
│       │   ├── AdminSetupPage.java
│       │   ├── FirstPage.java
│       │   ├── InvitationPage.java
│       │   ├── SetupAccountPage.java
│       │   ├── SetupLoginSelectionPage.java
│       │   ├── StartCSE360.java
│       │   ├── User.java
│       │   ├── UserHomePage.java
│       │   ├── UserLoginPage.java
│       │   ├── View
│       │   │   └── DiscussionPageView.java
│       │   ├── WelcomeLoginPage.java
│       │   ├── model
│       │   │   ├── Answer.java
│       │   │   ├── Answers.java
│       │   │   ├── Question.java
│       │   │   └── Questions.java
│       │   └── viewModel
│       │       └── DiscussionPageViewModel.java
│       ├── databasePart1
│       │   └── DatabaseHelper.java
│       └── module-info.java
├── README.md
├── Vids
│   └── (Show All Questions , Show Unresolved Questions).mp4
├── old code
│   ├── AdminHomePage.java
│   ├── AdminSetupPage.java
│   ├── DatabaseHelper.java
│   ├── FirstPage.java
│   ├── InvitationPage.java
│   ├── SetupAccountPage.java
│   ├── SetupLoginSelectionPage.java
│   ├── StartCSE360.java
│   ├── User.java
│   ├── UserHomePage.java
│   ├── UserLoginPage.java
│   └── WelcomeLoginPage.java
└── old vids
    ├── GMT20250208-022512_Recording_1440x900.mp4
    ├── Logout Functionality Test Cases(demo).mp4
    ├── Logout Functionality code explanation.mp4
    └── Matthew Cruz- screencast test for user roles and temp password.mp4
```

