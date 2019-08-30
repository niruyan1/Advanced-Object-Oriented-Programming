package eecs2030.lab5;

import java.util.Random;

/**
 * A model representing the game of rock, paper, scissors. The model is capable
 * of generating random hands for the computer, and comparing a computer hand to
 * the hand played by another player. The model keeps track of the number of
 * rounds played, the number of rounds won by the player, the number of rounds
 * won by the computer, and the number of rounds that resulted in a draw between
 * the computer and player.
 *
 */
public class RPSModel {

	// DO NOT MAKE THESE FIELDS PRIVATE; THE TESTER NEEDS DIRECT
	// DIRECT ACCESS TO THEM
	String player; // the hand played by the player
	String computer; // the hand played by the computer
	Random rng; // a random number generator
	int roundsPlayed; // the number of rounds played
	int roundsWonByPlayer; // the number of rounds won by the player
	int roundsWonByComputer; // the number of rounds won by the computer
	int roundsDrawn; // the number of rounds that resulted in a draw
	String winner;

	/**
	 * Initializes the model.
	 * 
	 * @param seed
	 *            a seed value to initialize the random number generator used to
	 *            generate hands for the computer
	 */
	public RPSModel(long seed) {
		this.player = "";
		this.computer = "";
		this.rng = new Random(seed);
		this.roundsPlayed = 0;
		this.roundsWonByPlayer = 0;
		this.roundsWonByComputer = 0;
		this.roundsDrawn = 0;
	}

	/**
	 * Play a round of rock, paper, scissors. A hand is randomly drawn for the
	 * computer and compared to the hand played by the player, the result
	 * (player wins, computer wins, hand is drawn) is recorded, and the number
	 * of rounds played is increased by one.
	 * 
	 * @param player
	 *            the hand played by the player; equal to one of RPSUtils.ROCK,
	 *            RPSUtils.PAPER, or RPSUtils.SCISSORS
	 * @throws IllegalArgumentException
	 *             if player is not equal to one of RPSUtils.ROCK,
	 *             RPSUtils.PAPER, or RPSUtils.SCISSORS
	 */
	public void playRound(String player) {
		if (!player.equals(RPSUtils.ROCK) && !player.equals(RPSUtils.PAPER) && !player.equals(RPSUtils.SCISSORS)) {
			throw new IllegalArgumentException();
		} else {
			this.player = player;
			this.roundsPlayed++;
			int x = this.rng.nextInt(3);
			if (x == 0) {
				this.computer = RPSUtils.ROCK;
			} else if (x == 1) {
				this.computer = RPSUtils.PAPER;
			} else {
				this.computer = RPSUtils.SCISSORS;
			}
			if (this.draw()) {
				this.roundsDrawn++;
				winner = RPSUtils.DRAW;
			} else if (this.computerWins()) {
				this.roundsWonByComputer++;
				winner = RPSUtils.COMPUTER;
			} else if (this.playerWins()) {
				this.roundsWonByPlayer++;
				winner = RPSUtils.PLAYER;
			} else {
				winner = "fail";
			}

		}
	}

	/**
	 * Returns the hand most recently played by the computer.
	 * 
	 * @return the hand most recently played by the computer; equal to one of
	 *         RPSUtils.ROCK, RPSUtils.PAPER, or RPSUtils.SCISSORS
	 */
	public String getComputerHand() {
		return this.computer;

	}

	/**
	 * Returns <code>true</code> if the most recently played hand resulted in a
	 * draw and <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if the most recently played hand resulted in a
	 *         draw and <code>false</code> otherwise
	 */
	public boolean draw() {

		return this.computer.equals(this.player);
	}

	/**
	 * Returns <code>true</code> if the most recently played hand resulted in a
	 * win for the computer and <code>false</code> otherwise.
	 * 
	 * @return true if the most recently played hand resulted in a win for the
	 *         computer and false otherwise
	 */
	public boolean computerWins() {
		if (this.computer.equals(RPSUtils.PAPER) && this.player.equals(RPSUtils.ROCK)
				|| this.computer.equals(RPSUtils.SCISSORS) && this.player.equals(RPSUtils.PAPER)
				|| this.computer.equals(RPSUtils.ROCK) && this.player.equals(RPSUtils.SCISSORS)) {

			return true;
		}
		return false;

	}

	/**
	 * Returns <code>true</code> if the most recently played hand resulted in a
	 * win for the player and <code>false</code> otherwise.
	 * 
	 * @return true if the most recently played hand resulted in a win for the
	 *         player and false otherwise
	 */
	public boolean playerWins() {
		if (this.player.equals(RPSUtils.PAPER) && this.computer.equals(RPSUtils.ROCK)
				|| this.player.equals(RPSUtils.SCISSORS) && this.computer.equals(RPSUtils.PAPER)
				|| this.player.equals(RPSUtils.ROCK) && this.computer.equals(RPSUtils.SCISSORS)) {

			return true;
		}
		return false;

	}

	/**
	 * Returns the total number of rounds played.
	 * 
	 * @return the total number of rounds played
	 */
	public int getRoundsPlayed() {
		return this.roundsPlayed;
	}

	/**
	 * Returns the number of rounds won by the player.
	 * 
	 * @return the number of rounds won by the player
	 */
	public int getRoundsWonByPlayer() {
		return this.roundsWonByPlayer;
	}

	/**
	 * Returns the number of rounds won by the computer.
	 * 
	 * @return the number of rounds won by the computer
	 */
	public int getRoundsWonByComputer() {
		return this.roundsWonByComputer;
	}

	/**
	 * Returns the number of rounds played that resulted in draw.
	 * 
	 * @return the number of rounds played that resulted in draw
	 */
	public int getRoundsDrawn() {
		return this.roundsDrawn;
	}

}