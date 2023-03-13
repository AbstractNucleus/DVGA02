import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Dimension;

public class Scoreboard extends JPanel {

    Scores latestScores = new Scores();
    Scores highScores = new Scores();

    JSplitPane layout;

    public Scoreboard() {
        super();

        latestScores.readFile("latest_runs.txt");
        highScores.readFile("highscores.txt");
        highScores.genHighScore();

        JLabel latest = new JLabel("Latest Scores");
        latest.setPreferredSize(new Dimension(100, 20));

        JList list1 = new JList(latestScores);
        list1.setForeground(new Color(255, 255, 255));
        list1.setBackground(new Color(25,25,25));
        list1.setFocusable(false);
        list1.setPreferredSize(new Dimension(100, 180));
        
        JSplitPane latest_pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, latest, list1);
        latest_pane.setDividerSize(0);

        JLabel high = new JLabel("High Scores");
        high.setPreferredSize(new Dimension(100, 20));

        JList list2 = new JList(highScores);
        list2.setForeground(new Color(255, 255, 255));
        list2.setBackground(new Color(25,25,25));
        list2.setFocusable(false);
        list2.setPreferredSize(new Dimension(100, 380));

        JSplitPane high_pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, high, list2);
        high_pane.setDividerSize(0);

	    layout = new JSplitPane(JSplitPane.VERTICAL_SPLIT, latest_pane, high_pane);
        layout.setDividerSize(0);

        add(layout);
    }
}
