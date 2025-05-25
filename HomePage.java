package QuizApp;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    private JTextField nameField;
    private JButton startButton;

    public HomePage() {
        setTitle("Quiz Master - Welcome");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome to Quiz Master!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(20);

        startButton = new JButton("Start Quiz");
        startButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter your name to start.");
                } else {
                    Quiz quiz = new Quiz(name);
                    quiz.setVisible(true);
                    this.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while starting the quiz: " + ex.getMessage());
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(startButton);

        setLayout(new BorderLayout(10, 10));
        add(welcomeLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
