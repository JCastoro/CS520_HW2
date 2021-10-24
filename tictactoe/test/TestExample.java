import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.RowBlockModel;
import controller.RowGameController;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private RowGameController game;

    @Before
    public void setUp() {
	game = new RowGameController();
    }

    @After
    public void tearDown() {
	game = null;
    }

    @Test
    public void testNewGame() {
        assertEquals ("1", game.gameModel.player);
        assertEquals (9, game.gameModel.movesLeft);
        assertEquals ("Player 1 to play 'X'", game.gameView.playerturn.getText());
        //do we need to test if every locaiton is a legal move?
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	RowBlockModel block = new RowBlockModel(null);
    }
    
    
    @Test
    public void testPlayer1Wins() {
    	//keep pre condition in mind as well.
    	game.move(0, 0);//player 1
    	game.move(1, 0);//player 2
    	
    	game.move(0, 1);//player 1
    	game.move(2, 1);//player 2
    	
    	game.move(0, 2);//player 1
    	
    	
    	assertEquals ("Player 1 Wins", game.gameView.playerturn.getText());
    }
    
    @Test
    public void testTie() {
    	//keep pre condition in mind as well.
    	game.move(0, 0);//player 1
    	game.move(0, 1);//player 2
    	
    	game.move(0, 2);//player 1
    	game.move(1, 0);//player 2
    	
    	game.move(1, 1);//player 1
    	game.move(1, 2);//player 2
    	
    	game.move(2, 0);//player 1
    	game.move(2, 1);//player 2
    	
    	game.move(2, 2);//player 1
    	
    	assertEquals ("Game ends in a draw", game.gameView.playerturn.getText());
    }
    
    
    
    
    
}
