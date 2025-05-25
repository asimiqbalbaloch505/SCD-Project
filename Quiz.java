package QuizApp;

import javax.swing.*;
import java.awt.*;

/**
 * Main quiz interface to show questions and collect answers.
 */
public class Quiz extends JFrame {
    private QuestionBank questionBank;
    private int currentIndex = 0;
    private int score = 0;
    private String userName;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private JButton nextButton;

    public Quiz(String userName) {
        this.userName = userName;
        questionBank = new QuestionBank();

        setTitle("Quiz Master - Quiz");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        questionLabel = new JLabel("Question text");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setPreferredSize(new Dimension(550, 50));

        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            buttonGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            try {
                if (isOptionSelected()) {
                    checkAnswer();
                    currentIndex++;
                    if (currentIndex < questionBank.getSize()) {
                        loadQuestion(currentIndex);
                    } else {
                        // Quiz finished - show results
                        ResultPage resultPage = new ResultPage(userName, score, questionBank.getSize());
                        resultPage.setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select an option before proceeding.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred during the quiz: " + ex.getMessage());
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(nextButton);

        setLayout(new BorderLayout(10, 10));
        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadQuestion(currentIndex);
    }

    /**
     * Loads question at given index to the UI.
     * @param index question index
     */
    private void loadQuestion(int index) {
        try {
            Question q = questionBank.getQuestion(index);
            if (q != null) {
                questionLabel.setText("Q" + (index + 1) + ": " + q.getQuestion());
                String[] options = q.getOptions();
                for (int i = 0; i < options.length; i++) {
                    optionButtons[i].setText(options[i]);
                }
                buttonGroup.clearSelection();
            } else {
                throw new IndexOutOfBoundsException("Question not found at index: " + index);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Error loading question: " + e.getMessage());
        }
    }

    /**
     * Checks if any option is selected.
     * @return true if selected
     */
    private boolean isOptionSelected() {
        for (JRadioButton btn : optionButtons) {
            if (btn.isSelected()) return true;
        }
        return false;
    }

    /**
     * Checks selected answer against correct answer.
     */
    private void checkAnswer() {
        Question q = questionBank.getQuestion(currentIndex);
        if (q != null) {
            for (int i = 0; i < optionButtons.length; i++) {
                if (optionButtons[i].isSelected()) {
                    if (i == q.getCorrectAnswerIndex()) {
                        score++;
                    }
                }
            }
        }
    }
}
