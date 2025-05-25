package QuizApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a list of quiz questions.
 */
public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    /**
     * Loads predefined questions into the question bank.
     */
    private void loadQuestions() {
        questions.add(new Question(
            "Which direction does the sun rise from?",
            new String[]{"North", "South", "East", "West"},
            2)); // East

        // ... (other questions unchanged) ...

        questions.add(new Question(
            "What do you wear on your feet to walk outside?",
            new String[]{"Hat", "Gloves", "Shoes", "Shirt"},
            2)); // Shoes
    }

    /**
     * Retrieves the question at the given index.
     * @param index question index
     * @return Question object or null if index invalid
     */
    public Question getQuestion(int index) {
        try {
            if (index >= 0 && index < questions.size()) {
                return questions.get(index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid question index requested: " + index);
        }
        return null;
    }

    public int getSize() {
        return questions.size();
    }
}
