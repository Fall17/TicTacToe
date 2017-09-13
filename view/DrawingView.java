package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import model.TicTacToeGame;

public class DrawingView extends BorderPane implements Observer {

	private TicTacToeGame theGame;
	private GridPane pane;
	private Label status;
	private Canvas canvas;
	private Image imageX;
	private Image imageO;
	
	// initializes the game board, the images, and the gridpane
	public DrawingView(TicTacToeGame TicTacToeGame) {
		theGame = TicTacToeGame;
		imageX = new Image("file:images/x.png", false);
		imageO = new Image("file:images/o.png", false);
		initializePane();
	}

	// initializes the gridpane
	private void initializePane() {
		// construct new GridPane
	  	pane = new GridPane();
	  	pane.setHgap(5);
		pane.setVgap(5);
		this.setTop(pane);
		
		// set up label
		status = new Label("Make Move");
		status.setFont(new Font("Arial", 16));
		pane.add(status, 10, 7);	
		
		// set up canvas + eventhandler
		EventHandler<MouseEvent> handleClick = new clickHandler();
		canvas = new Canvas(224, 224);
		canvas.setOnMouseClicked(handleClick);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		// sets up tic-tac-toe board
		gc.setFill(Color.BLACK);
		gc.strokeRect(10, 5, 210, 210);
		gc.strokeRect(10, 5, 70, 70);
		gc.strokeRect(80, 5, 70, 70);
		gc.strokeRect(150, 5, 70, 70);
		gc.strokeRect(10, 75, 70, 70);
		gc.strokeRect(80, 75, 70, 70);
		gc.strokeRect(150, 75, 70, 70);
		gc.strokeRect(10, 145, 70, 70);
		gc.strokeRect(80, 145, 70, 70);
		gc.strokeRect(150, 145, 70, 70);
		this.setCenter(canvas);
	}

	@Override
	public void update(Observable o, Object arg) {
		theGame = (TicTacToeGame) o;
		// checks if new game. if so, resets board
		boolean newGame = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(theGame.getTicTacToeBoard()[i][j] != '_') {
					newGame = false;
				}
			}
		}
		if(newGame) {
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.clearRect(0, 0, 224, 224);
			gc.setFill(Color.BLACK);
			gc.strokeRect(10, 5, 210, 210);
			gc.strokeRect(10, 5, 70, 70);
			gc.strokeRect(80, 5, 70, 70);
			gc.strokeRect(150, 5, 70, 70);
			gc.strokeRect(10, 75, 70, 70);
			gc.strokeRect(80, 75, 70, 70);
			gc.strokeRect(150, 75, 70, 70);
			gc.strokeRect(10, 145, 70, 70);
			gc.strokeRect(80, 145, 70, 70);
			gc.strokeRect(150, 145, 70, 70);
		}
    	// checks if the game is over (checks for wins then a tie)
        if(theGame.didWin('X')) {
        	status.setText("X wins");
        }
        else if(theGame.didWin('O')) {
        	status.setText("O wins");
        }
        else if(theGame.tied()) {
        	status.setText("Tie");
        }
        else {
        	status.setText("Make Move");
        }
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        // checks if any spaces were chosen by the player or computer
        // fill them in if so
        
        if(theGame.getTicTacToeBoard()[0][0] == 'X') {
        	gc.drawImage(imageX, 28, 24);
        }
        else if(theGame.getTicTacToeBoard()[0][0] == 'O') {
        	gc.drawImage(imageO, 28, 24);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[0][1] == 'X') {
        	gc.drawImage(imageX, 98, 24);
        }
        else if(theGame.getTicTacToeBoard()[0][1] == 'O') {
        	gc.drawImage(imageO, 98, 24);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[0][2] == 'X') {
        	gc.drawImage(imageX, 168, 24);
        }
        else if(theGame.getTicTacToeBoard()[0][2] == 'O') {
        	gc.drawImage(imageO, 168, 24);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[1][0] == 'X') {
        	gc.drawImage(imageX, 28, 94);
        }
        else if(theGame.getTicTacToeBoard()[1][0] == 'O') {
        	gc.drawImage(imageO, 28, 94);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[1][1] == 'X') {
        	gc.drawImage(imageX, 98, 94);
        }
        else if(theGame.getTicTacToeBoard()[1][1] == 'O') {
        	gc.drawImage(imageO, 98, 94);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[1][2] == 'X') {
        	gc.drawImage(imageX, 168, 94);
        }
        else if(theGame.getTicTacToeBoard()[1][2] == 'O') {
        	gc.drawImage(imageO, 168, 94);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[2][0] == 'X') {
        	gc.drawImage(imageX, 28, 164);
        }
        else if(theGame.getTicTacToeBoard()[2][0] == 'O') {
        	gc.drawImage(imageO, 28, 164);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[2][1] == 'X') {
        	gc.drawImage(imageX, 98, 164);
        }
        else if(theGame.getTicTacToeBoard()[2][1] == 'O') {
        	gc.drawImage(imageO, 98, 164);
        }
        else {}
        
        if(theGame.getTicTacToeBoard()[2][2] == 'X') {
        	gc.drawImage(imageX, 168, 164);
        }
        else if(theGame.getTicTacToeBoard()[2][2] == 'O') {
        	gc.drawImage(imageO, 168, 164);
        }
        else {}
	}
	
	// handles when the player clicks
	private class clickHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// checks if game is over first
		    if(theGame.didWin('X') || theGame.didWin('O') || theGame.tied()) {
		    	return;
		    }
			double mouseX = event.getSceneX();
			double mouseY = event.getSceneY(); 
			int row;
			int column;
			
			// checks if player clicks any of the spaces
			if(mouseX > 25 && mouseX < 95 && mouseY > 115 && mouseY < 185) {
				row = 0;
				column = 0;
			}
			else if(mouseX > 95 && mouseX < 165 && mouseY > 115 && mouseY < 185) {
				row = 0;
				column = 1;
			}
			else if(mouseX > 165 && mouseX < 235 && mouseY > 115 && mouseY < 185) {
				row = 0;
				column = 2;
			}
			else if(mouseX > 25 && mouseX < 95 && mouseY > 185 && mouseY < 255) {
				row = 1;
				column = 0;
			}
			else if(mouseX > 95 && mouseX < 165 && mouseY > 185 && mouseY < 255) {
				row = 1;
				column = 1;
			}
			else if(mouseX > 165 && mouseX < 235 && mouseY > 185 && mouseY < 255) {
				row = 1;
				column = 2;
			}
			else if(mouseX > 25 && mouseX < 95 && mouseY > 255 && mouseY < 325) {
				row = 2;
				column = 0;
			}
			else if(mouseX > 95 && mouseX < 165 && mouseY > 255 && mouseY < 325) {
				row = 2;
				column = 1;
			}
			else if(mouseX > 165 && mouseX < 235 && mouseY > 255 && mouseY < 325) {
				row = 2;
				column = 2;
			}
			// if mouse is out of bounds
			else {
				return;
			}
			// checks if space is empty
			if(theGame.getTicTacToeBoard()[row][column] != '_') {
			status.setText("Invalid choice");
				return;
			}
			theGame.humanMove(row, column, false);
		}
	}
}
