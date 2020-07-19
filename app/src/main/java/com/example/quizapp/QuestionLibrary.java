package com.example.quizapp;

public class QuestionLibrary {
    private String mQuestion[] ={
            "In which city is Friends set?",
            " What is the name of Phoebe's alter-ego? ",
            "What's the name of the coffee shop used by the characters?",
             "What instrument does Phoebe Buffay play?",
            "What hangs on Monica's purple door?"
    };

    private  String mchoices[][] = {
            {"Los Angeles","New York city"," Miami"},
            {"Pheobe needy","Monica Bing","Regina Felanghe"},
            {"St.james perk","Central Perk","Daily Grind"},
            {"Drums","Guitar","Flute"},
            {"A key hook","A cat hook","A yellow picture frame"}
    };

    private String mCorrectAnswers[] ={"New York city","Regina Felanghe","Central Perk","Guitar","A yellow picture frame"};

    public String getQuestion(int a){
        String question = mQuestion[a];
           return question;
    }

    public String getChoice1( int a) {
        String choice0 = mchoices[a][0];
        return choice0;
    }
   public String getChoice2(int a) {
        String choice1 = mchoices[a][1];
        return choice1;
   }
   public String getChoice3(int a){
       String choice2 = mchoices[a][2];
       return choice2;

   }
   public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
                return answer;

   }
}
