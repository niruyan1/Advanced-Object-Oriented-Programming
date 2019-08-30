package eecs2030.lab5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A controller that mediates the interaction between an RPSModel and an
 * RPSView.
 *
 */
public class RPSController implements ActionListener {

	private RPSModel model;
	private RPSView view;

	/**
	 * Returns the RPSModel used by this controller.
	 * 
	 * @return the model
	 */
	public RPSModel getModel() {
		return this.model;
	}

	/**
	 * Sets the RPSModel used by this controller.
	 * 
	 * @param model
	 *            the model to set
	 */
	public void setModel(RPSModel model) {
		this.model = model;
	}

	/**
	 * Returns the RPSView used by this controller.
	 * 
	 * @return the view
	 */
	public RPSView getView() {
		return this.view;
	}

	/**
	 * Sets the RPSView used by this controller.
	 * 
	 * @param view
	 *            the view to set
	 */
	public void setView(RPSView view) {
		this.view = view;
	}

	/**
	 * Processes an event initiated by a user clicking on a button in an
	 * RPSView.
	 * 
	 * The <code>ActionEvent</code> object has-a string equal to one of
	 * <code>RPSUtils.ROCK</code>, <code>RPSUtils.PAPER</code>, or
	 * <code>RPSUtils.SCISSORS</code> indicating which hand the player has
	 * chosen.
	 * 
	 * This method needs to orchestrate a series of method calls to the model
	 * and view:
	 * 
	 * <ol>
	 * <li>ask the model to play a hand using the player's chosen hand</li>
	 * <li>ask the view to display the player's chosen hand</li>
	 * <li>ask the view to display the computer's chosen hand</li>
	 * <li>ask the model for the winner of the hand</li>
	 * <li>ask the view to display the winner of the hand</li>
	 * <li>ask the model for the number of games won, lost, and drawn by the
	 * player</li>
	 * <li>ask the view to display the number of games won, lost, and drawn by
	 * the player</li>
	 * </ol>
	 * 
	 * @param e
	 *            an action event object received from a button in the RPSView
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String player = e.getActionCommand(); // the hand played by the player
		model.playRound(player);
		view.setPlayerLabel(player);
		view.setComputerLabel(model.getComputerHand());

		this.view.setWinner(this.model.winner);
		view.setRecord(this.model.roundsWonByPlayer, this.model.roundsWonByComputer, this.model.roundsDrawn);

	}

}