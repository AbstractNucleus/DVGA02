import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Dimension;


public class Program extends JFrame {
	GameBoard board;


	public Program() {
		
		Scoreboard scoreboard = new Scoreboard();

		board = new GameBoard(scoreboard);
		JSplitPane layout = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, board, scoreboard);

		board.setPreferredSize(new Dimension(800, 600));
		scoreboard.setPreferredSize(new Dimension(100, 600));
		scoreboard.setBackground(new Color(25,25,25));
		layout.setDividerSize(0);

		add(layout);

		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
