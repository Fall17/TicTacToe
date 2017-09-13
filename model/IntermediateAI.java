// Andrew Marrufo

package model;

import java.awt.Point;
import java.util.Random;

/**
 * This TTT strategy tries to prevent the opponent from winning by checking
 * for a space where the opponent is about to win. If none found, it randomly
 * picks a place to win, which an sometimes be a win even if not really trying.
 * 
 * @author mercer
 */
public class IntermediateAI implements TicTacToeStrategy {

  @Override
  // Precondition: During testing the AI is associated with the 'O', the odd number move.
  public Point desiredMove(TicTacToeGame theGame) {
    char space1 = theGame.getTicTacToeBoard()[0][0];
    char space2 = theGame.getTicTacToeBoard()[0][1];
    char space3 = theGame.getTicTacToeBoard()[0][2];
    char space4 = theGame.getTicTacToeBoard()[1][0];
    char space5 = theGame.getTicTacToeBoard()[1][1];
    char space6 = theGame.getTicTacToeBoard()[1][2];
    char space7 = theGame.getTicTacToeBoard()[2][0];
    char space8 = theGame.getTicTacToeBoard()[2][1];
    char space9 = theGame.getTicTacToeBoard()[2][2];
    
    
    // check if a win is available
    if((space1 == 'O' && space2 == 'O' || space6 == 'O' && space9 == 'O' || space5 == 'O' && space7 == 'O') && space3 == '_') {
    	return new Point(0, 2);
    }
    else if((space1 == 'O' && space3 == 'O' || space5 == 'O' && space8 == 'O') && space2 == '_') {
    	return new Point(0, 1);
    }
    else if((space2 == 'O' && space3 == 'O' || space4 == 'O' && space7 == 'O' || space5 == 'O' && space9 == 'O') && space1 == '_') {
    	return new Point(0, 0);
    }
    else if((space4 == 'O' && space5 == 'O' || space3 == 'O' && space9 == 'O') && space6 == 'O') {
    	return new Point(1, 2);
    }
    else if((space1 == 'O' && space9 == 'O' || space2 == 'O' && space8 == 'O' || space3 == 'O' && space7 == 'O' || space4 == 'O' && space6 == 'O') && space5 == 'O') {
    	return new Point(1, 1);
    }
    else if((space5 == 'O' && space6 == 'O' || space1 == 'O' && space7 == 'O') && space4 == 'O') {
    	return new Point(1, 0);
    }
    else if((space3 == 'O' && space6 == 'O' || space1 == 'O' && space5 == 'O' || space7 == 'O' && space8 == 'O') && space9 == '_') {
    	return new Point(2, 2);
    }
    else if((space2 == 'O' && space5 == 'O' || space7 == 'O' && space9 =='O') && space8 == '_') {
    	return new Point(2, 1);
    }
    else if((space1 == 'O' && space4 == 'O' || space3 == 'O' && space5 == 'O' || space8 == 'O' && space9 == 'O') && space7 == '_') {
    	return new Point(2, 0);
    }
    else{}
    
    // check if blocking a win is available (same as above code, just looks for spaces X can win instead)
    if((space1 == 'X' && space2 == 'X' || space6 == 'X' && space9 == 'X' || space5 == 'X' && space7 == 'X') && space3 == '_') {
    	return new Point(0, 2);
    }
    else if((space1 == 'X' && space3 == 'X' || space5 == 'X' && space8 == 'X') && space2 == '_') {
    	return new Point(0, 1);
    }
    else if((space2 == 'X' && space3 == 'X' || space4 == 'X' && space7 == 'X' || space5 == 'X' && space9 == 'X') && space1 == '_') {
    	return new Point(0, 0);
    }
    else if((space4 == 'X' && space5 == 'X' || space3 == 'X' && space9 == 'X') && space6 == 'X') {
    	return new Point(1, 2);
    }
    else if((space1 == 'X' && space9 == 'X' || space2 == 'X' && space8 == 'X' || space3 == 'X' && space7 == 'X' || space4 == 'X' && space6 == 'X') && space5 == 'X') {
    	return new Point(1, 1);
    }
    else if((space5 == 'X' && space6 == 'X' || space1 == 'X' && space7 == 'X') && space4 == 'X') {
    	return new Point(1, 0);
    }
    else if((space3 == 'X' && space6 == 'X' || space1 == 'X' && space5 == 'X' || space7 == 'X' && space8 == 'X') && space9 == '_') {
    	return new Point(2, 2);
    }
    else if((space2 == 'X' && space5 == 'X' || space7 == 'X' && space9 =='X') && space8 == '_') {
    	return new Point(2, 1);
    }
    else if((space1 == 'X' && space4 == 'X' || space3 == 'X' && space5 == 'X' || space8 == 'X' && space9 == 'X') && space7 == '_') {
    	return new Point(2, 0);
    }
    else{}
    
    
    // if cannot win or block, picks random available space (same code as in RandomAI.java)
    boolean throwException = true;
	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
			if(theGame.getTicTacToeBoard()[i][j] == '_') {
				throwException = false;
			}
		}
	}
	if(throwException) {
		throw new IGotNowhereToGoException("Nowhere to go!");
	}
    Random rand = new Random();
    while(true) {
    	int row = rand.nextInt(3);
    	int column = rand.nextInt(3);
    	if(theGame.getTicTacToeBoard()[row][column] == '_') {
    		return new Point(row, column);
    	}
    }
  }
}