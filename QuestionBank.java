package QuizApp;
import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
            "Which direction does the sun rise from?",
            new String[]{"North", "South", "East", "West"},
            2)); // East

        questions.add(new Question(
            "What do we use to write on a blackboard?",
            new String[]{"Pen", "Pencil", "Chalk", "Brush"},
            2)); // Chalk

        questions.add(new Question(
            "How many legs does a spider have?",
            new String[]{"Six", "Eight", "Ten", "Four"},
            1)); // Eight

        questions.add(new Question(
            "What color is the sky on a clear day?",
            new String[]{"Green", "Blue", "Red", "Yellow"},
            1)); // Blue

        questions.add(new Question(
            "How many hours are there in a day?",
            new String[]{"12", "18", "24", "30"},
            2)); // 24

        questions.add(new Question(
            "Which animal is known as the king of the jungle?",
            new String[]{"Tiger", "Lion", "Elephant", "Cheetah"},
            1)); // Lion

        questions.add(new Question(
            "Which sense do we use with our nose?",
            new String[]{"Sight", "Taste", "Smell", "Touch"},
            2)); // Smell

        questions.add(new Question(
            "What is ice made of?",
            new String[]{"Salt", "Water", "Air", "Sugar"},
            1)); // Water

        questions.add(new Question(
            "Which object tells us the time?",
            new String[]{"Phone", "Clock", "Book", "Pen"},
            1)); // Clock

        questions.add(new Question(
            "What do you wear on your feet to walk outside?",
            new String[]{"Hat", "Gloves", "Shoes", "Shirt"},
            2)); // Shoes
    }


    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

    public int getSize() {
        return questions.size();
    }
}
