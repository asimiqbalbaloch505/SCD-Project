package QuizApp;

/**
 * Entry point for the Quiz Master application.
 */
public class QuizApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            HomePage home = new HomePage();
            home.setVisible(true);
        });
    }
}
