// Andrew Marrufo

package view;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.TicTacToeGame;

public class TextAreaView extends BorderPane implements Observer {

	// Instance variables include the game board, the gridpane, the textfields
	// where row and column numbers will
	// be entered, the labels to tell which textfields are which, the button to
	// submit your row and column numbers,
	// and the textarea for your board.

	private TicTacToeGame theGame;
	private GridPane pane;
	private TextField rowText;
	private TextField columnText;
	private Label row;
	private Label column;
	private Button status;
	private TextArea board;

	public TextAreaView(TicTacToeGame TicTacToeGame) {
		theGame = TicTacToeGame;
		initializePane();
	}

	// Sets up the pane for a new game
	private void initializePane() {
		// construct new GridPane
		pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		this.setCenter(pane);

		// set up textfields
		rowText = new TextField();
		rowText.setMaxWidth(60);
		pane.add(rowText, 13, 6);
		columnText = new TextField();
		columnText.setMaxWidth(60);
		pane.add(columnText, 13, 7);

		// set up labels
		row = new Label("row");
		column = new Label("column");
		pane.add(row, 14, 6);
		pane.add(column, 14, 7);

		// set up button + eventhandler
		EventHandler<ActionEvent> handleCoordinates = new coordinateHandler();
		status = new Button("Make move");
		status.setOnAction(handleCoordinates);
		pane.add(status, 13, 10);

		// set up textarea for board
		board = new TextArea();
		board.setFont(new Font("Courier New", 32));
		board.setPrefRowCount(3);
		board.setPrefColumnCount(3);
		board.setMinWidth(254);
		board.setMinHeight(180);
		this.setBottom(board);
	}

	// updates the gameboard
	@Override
	public void update(Observable o, Object arg) {
		theGame = (TicTacToeGame) o;
		// checks if the game is over (checks for wins then a tie)
		if (theGame.didWin('X')) {
			status.setText("X wins");
		} else if (theGame.didWin('O')) {
			status.setText("O wins");
		} else if (theGame.tied()) {
			status.setText("Tie");
		} else {
			status.setText("Make move");
		}
		// updates board on screen
		board.setText(theGame.toString());
	}

	// handles button click
	private class coordinateHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// checks if game is over first
			if (theGame.didWin('X') || theGame.didWin('O') || theGame.tied()) {
				return;
			}
			// checks if numbers are invalid/out of bounds
			if (!((rowText.getText().equals("0") || rowText.getText().equals("1")
					|| rowText.getText().equals("2") && (columnText.getText().equals("0")
							|| columnText.getText().equals("1") || columnText.getText().equals("2"))))) {
				status.setText("Invalid choice");
				return;
			}
			int rowInt = Integer.parseInt(rowText.getText());
			int columnInt = Integer.parseInt(columnText.getText());
			// checks if space is empty
			if (theGame.getTicTacToeBoard()[rowInt][columnInt] != '_') {
				status.setText("Invalid choice");
				return;
			}
			theGame.humanMove(rowInt, columnInt, false);
			rowText.clear();
			columnText.clear();
		}
	}
}