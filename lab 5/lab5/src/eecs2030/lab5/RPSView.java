package eecs2030.lab5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class RPSView extends JFrame {

	// DO NOT MAKE THESE FIELDS PRIVATE; THE TESTER NEEDS DIRECT
	// DIRECT ACCESS TO THEM
	JLabel player; // a label describing the hand played by the player
	JLabel computer; // a label describing the hand played by the computer
	JLabel winner; // a label describing who won the last round played
	JLabel record; // a label describing the won-lost-draw record of the rounds
					// played
	JButton rock; // a button that allows the player to play the hand rock
	JButton paper; // a button that allows the player to play the hand paper
	JButton scissors; // a button that allows the player to play the hand
						// scissors

	/**
	 * Initializes a view for the game rock, paper, scissors. The constructor
	 * has been implemented for you.
	 * 
	 * @param listener
	 *            a listener for the button events
	 */
	public RPSView(ActionListener listener) {
		// 1. make the window by invoking the superclass constructor
		super("Rock, paper, scissors");

		// 2. What happens when the frame closes?
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. make and add the controls
		this.makeLabels();
		this.makeButtons(listener);

		// 4. Size the frame
		this.setMinimumSize(new Dimension(400, 400));
		this.pack();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		// 5. Show the view; we'll do this in RPSGame
		// this.setVisible(true);
	}

	/**
	 * Creates the four labels for the view.
	 * 
	 * <p>
	 * <code>this.player</code><br>
	 * This label is for the hand played by the player. It should be initialized
	 * with the text <code>"You picked: "</code>.
	 * 
	 * <p>
	 * <code>this.computer</code><br>
	 * This label is for the hand played by the computer. It should be
	 * initialized with the text <code>"Computer picked: "</code>.
	 * 
	 * <p>
	 * <code>this.winner</code><br>
	 * This label describes who won the last hand. It should be initialized with
	 * the text <code>"No winner yet"</code>.
	 * 
	 * <p>
	 * <code>this.record</code><br>
	 * This label describes the won-lost-draw record of the previously played
	 * hands. It should be initialized with the text
	 * <code>"Games won: 0, Games lost: 0, Games drawn: 0"</code>.
	 * 
	 * <p>
	 * Each label should invoke the method <code>setMaximumSize</code> to set a
	 * maximum size of 400 x 50 (width x height).
	 * 
	 * <p>
	 * Each label should invoke the method <code>setBorder</code> to set a nice
	 * border. See the lab for details.
	 * 
	 */
	private void makeLabels() {
		this.player = new JLabel("You Picked: ");
		this.player.setMaximumSize(new Dimension(400, 50));
		this.player.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		this.computer = new JLabel("Computer picked: ");
		this.computer.setMaximumSize(new Dimension(400, 50));
		this.computer.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		this.winner = new JLabel("No winner yet");
		this.winner.setMaximumSize(new Dimension(400, 50));
		this.winner.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		this.record = new JLabel("Games won: 0, Games lost: 0, Games drawn: 0");
		this.record.setMaximumSize(new Dimension(400, 50));
		this.record.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		this.add(this.player);
		this.add(this.computer);
		this.add(this.winner);
		this.add(this.record);
	}

	/**
	 * Creates the three buttons for the view.
	 * 
	 * <p>
	 * <code>this.rock</code><br>
	 * The first button allows the player to choose the hand rock. It should
	 * have the text equal to <code>RPSUtils.ROCK</code>. It should set the
	 * action command string to <code>RPSUtils.ROCK</code>. It should add the
	 * action listener <code>listener</code>.
	 * 
	 * <p>
	 * <code>this.paper</code><br>
	 * The second button allows the player to choose the hand paper. It should
	 * have the text equal to <code>RPSUtils.PAPER</code>. It should set the
	 * action command string to <code>RPSUtils.PAPER</code>. It should add the
	 * action listener <code>listener</code>.
	 * 
	 * <p>
	 * <code>this.scissors</code><br>
	 * The third button allows the player to choose the hand scissors. It should
	 * have the text equal to <code>RPSUtils.SCISSORS</code>. It should set the
	 * action command string to <code>RPSUtils.SCISSORS</code>. It should add
	 * the action listener <code>listener</code>.
	 * 
	 * <p>
	 * Each button should invoke the method <code>setMaximumSize</code> to set a
	 * maximum size of 400 x 50 (width x height).
	 * 
	 * @param listener
	 */
	private void makeButtons(ActionListener listener) {
		this.rock = new JButton(RPSUtils.ROCK);
		this.rock.setActionCommand(RPSUtils.ROCK);
		this.rock.setMaximumSize(new Dimension(400, 40));
		this.rock.addActionListener(listener);

		this.paper = new JButton(RPSUtils.PAPER);
		this.paper.setActionCommand(RPSUtils.PAPER);
		this.paper.setMaximumSize(new Dimension(400, 40));
		this.paper.addActionListener(listener);

		this.scissors = new JButton(RPSUtils.SCISSORS);
		this.scissors.setActionCommand(RPSUtils.SCISSORS);
		this.scissors.setMaximumSize(new Dimension(400, 40));
		this.scissors.addActionListener(listener);

		this.add(rock);
		this.add(paper);
		this.add(scissors);

	}

	/**
	 * Sets the text of the player label. The text is the string:
	 * 
	 * <p>
	 * <code>"You picked: "</code>
	 * 
	 * <p>
	 * followed by the hand played by the player.
	 * 
	 * @param player
	 *            the hand played by the player; assumed to be equal to one of
	 *            RPSUtils.ROCK, RPSUtils.PAPER, or RPSUtils.SCISSORS
	 */
	public void setPlayerLabel(String player) {
		this.player.setText("You Picked: " + player);
	}

	/**
	 * Sets the text of the computer label. The text is the string:
	 * 
	 * <p>
	 * <code>"Computer picked: "</code>
	 * 
	 * <p>
	 * followed by the hand played by the computer.
	 * 
	 * @param computer
	 *            the hand played by the computer; assumed to be equal to one of
	 *            RPSUtils.ROCK, RPSUtils.PAPER, or RPSUtils.SCISSORS
	 */
	public void setComputerLabel(String computer) {
		this.computer.setText("Computer picked: " + computer);
	}

	/**
	 * Sets the text of the label describing who won the hand. The text is the
	 * string:
	 * 
	 * <p>
	 * <code>"Computer wins"</code>
	 * 
	 * <p>
	 * if the computer won the hand.
	 * 
	 * <p>
	 * The text is the string:
	 * 
	 * <p>
	 * <code>"You win"</code>
	 * 
	 * <p>
	 * if the player won the hand.
	 * 
	 * <p>
	 * The text is the string:
	 * 
	 * <p>
	 * <code>"It's a draw"</code>
	 * 
	 * <p>
	 * if the computer and player played the same hand.
	 * 
	 * @param winner
	 *            the winner of the hand; assumed to be one of
	 *            RPSUtils.COMPUTER, RPSUtils.PLAYER, or RPSUtils.DRAW
	 */
	public void setWinner(String winner) {
		this.winner.setText("Winner is " + winner);

	}

	/**
	 * Sets the text of the label describing the record of hands won, lost, and
	 * drawn by the player. Examples of the text are shown below:
	 * 
	 * <pre>
	 * "Games won: 1, Games lost: 0, Games drawn: 0"
	 * "Games won: 0, Games lost: 1, Games drawn: 0"
	 * "Games won: 0, Games lost: 0, Games drawn: 1"
	 * "Games won: 12, Games lost: 11, Games drawn: 2"
	 * </pre>
	 * 
	 * @param gamesWon
	 *            the number of games won by the player
	 * @param gamesLost
	 *            the number of games lost by the player
	 * @param gamesDrawn
	 *            the number of games that resulted in a draw
	 */
	public void setRecord(int gamesWon, int gamesLost, int gamesDrawn) {
		this.record.setText("Games won: " + gamesWon + " , Games lost: " + gamesLost + ", Games drawn: " + gamesDrawn);

	}

	/**
	 * Used to test the appearance of the view without creating a model,
	 * controller, or game. You can run this main method to see the appearance
	 * of the view (but pressing the buttons won't trigger any events).
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		(new RPSView(null)).setVisible(true);
	}
}