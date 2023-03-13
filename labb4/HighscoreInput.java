import javax.swing.*;
import java.awt.*;


public class HighscoreInput extends JFrame {
    public HighscoreInput(Scoreboard scoreboard, int score) {
        super();
        setPreferredSize(new Dimension(300, 100));
        setLayout(new GridLayout(2, 1));
        add(new JLabel("Enter your name: (3 characters)"));
        JTextField name = new JTextField();
        name.addActionListener(e -> {
            if (name.getText().length() < 3 || name.getText().length() > 3) {
                JOptionPane.showMessageDialog(null, "Please enter 3 characters");
                return;
            }
            String initials = name.getText().substring(0,3).toUpperCase();
            String new_score = initials + ": " + score;

            scoreboard.highScores.addElement(new_score);
            scoreboard.highScores.sortHighscore();
            scoreboard.highScores.writeFile();
            dispose();
        });

        add(name);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            if (name.getText().length() < 3 || name.getText().length() > 3) {
                JOptionPane.showMessageDialog(null, "Please enter 3 characters");
                return;
            }
            String initials = name.getText().substring(0,3);
            String new_score = initials + ": " + score;

            scoreboard.highScores.addElement(new_score);
            scoreboard.highScores.sortHighscore();
            scoreboard.highScores.writeFile();
            dispose();

        });
        add(submit);

        pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
    }
}
