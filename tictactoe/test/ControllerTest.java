
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
    
    
    
}
