package QuizApp;

import javax.swing.*;
import java.awt.*;

/**
 * Displays quiz result summary to the user.
 */
public class ResultPage extends JFrame {
    public ResultPage(String userName, int score, int totalQuestions) {
        setTitle("Quiz Master - Result");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel congratsLabel = new JLabel("Thank you for playing, " + userName + "!");
        congratsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        congratsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel scoreLabel = new JLabel("Your Score: " + score + " out of " + totalQuestions);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        setLayout(new GridLayout(3, 1, 10, 10));
        add(congratsLabel);
        add(scoreLabel);
        add(exitButton);
    }
}
