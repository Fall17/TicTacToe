// Andrew Marrufo

package model;

import java.awt.Point;
import java.util.Random;

/**
 * This strategy selects the first available move at random.  It is easy to beat
 * 
 * @throws IGotNowhereToGoException whenever asked for a move that is impossible to deliver
 * 
 * @author mercer
 */
public class RandomAI implements TicTacToeStrategy {

  // Find an open spot while ignoring possible wins and stops (block a guaranteed win)
  @Override
  public Point desiredMove(TicTacToeGame theGame) {
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