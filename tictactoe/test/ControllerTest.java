
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.RowGameController;

public class ControllerTest {
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
    //Tests if a player move is reflected in the model
    public void testPlayerMove() {
    	game.move(1, 1);
    	
        assertEquals ("X", game.gameModel.blocksData[1][1].getContents());
        assertEquals (8, game.gameModel.movesLeft);
        
        assertEquals ("X", game.gameView.blocks[1][1].getText());
        assertEquals ("O: Player 2", game.gameView.playerturn.getText());
        //i dont update the player number but that should really be changed as well.
    }
    
    public void testResetButton() {
    	game.move(1, 1);
    	game.resetGame();
    	
     
        assertEquals (9, game.gameModel.movesLeft);
        assertEquals ("Player 1 to play 'X'", game.gameView.playerturn.getText());
        assertEquals ("1", game.gameModel.player);
        assertEquals (null, game.gameModel.getFinalResult());
    }
    
    public void testEndGame() {
    	game.move(0, 0);
    	game.move(1, 1);
    	game.move(0, 1);
    	game.move(2, 1);
    	
    	game.move(0, 2);
    	
    	for(int row = 0;row<3;row++) {
    	    for(int column = 0;column<3;column++) {
    	    	assertEquals (false,game.gameModel.blocksData[row][column].getIsLegalMove() );
    	    }
    	}
       
        assertEquals ("Player 1 Wins", game.gameView.playerturn.getText() );
       
    }
    
    
    }
