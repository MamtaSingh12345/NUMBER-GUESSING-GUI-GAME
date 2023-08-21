
package numberguessinggamegui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGuessingGameGUI extends JFrame {
    private int numberToGuess;
    private int attempts;
    private JTextField guessField;
    private JLabel resultLabel;
    private JLabel gifLabel;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game\n");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Generate random number
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;

        // Create components
        
        JLabel titleLabel = new JLabel("Welcome to the Number Guessing Game!");
        JLabel promptLabel = new JLabel("Enter your guess:");
        promptLabel.setBounds(20, 20, 100, 20);
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel();
        gifLabel = new JLabel();


        // Load and resize the GIF
        ImageIcon gifIcon = new ImageIcon("C:\\Users\\mamta\\Downloads\\numberguessing.gif");
        Image resizedGif = gifIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        gifLabel.setIcon(new ImageIcon(resizedGif));

        // Add action listener to the guess button
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(titleLabel);
        panel.add(promptLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultLabel);
        panel.add(gifLabel);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    private void checkGuess() {
        String guessText = guessField.getText();

        if (guessText.isEmpty()) {
            resultLabel.setText("Please enter a number.");
            return;
        }

        int guess = Integer.parseInt(guessText);
        attempts++;

        if (guess < numberToGuess) {
            resultLabel.setText("Too low! Try again.");
        } else if (guess > numberToGuess) {
            resultLabel.setText("Too high! Try again.");
        } else {
            resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
            guessField.setEditable(false);
        }

        guessField.setText("");
        guessField.requestFocus();
    }

    public static void main(String[] args) {
        NumberGuessingGameGUI game = new NumberGuessingGameGUI();
        game.setVisible(true);
    }
}