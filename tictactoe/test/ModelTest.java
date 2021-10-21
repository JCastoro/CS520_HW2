
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.RowGameController;

public class ModelTest {
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
    public void testGetLegalMove_Illegal() {
    	game.move(1, 1);
        assertEquals (false, game.gameModel.blocksData[1][1].getIsLegalMove());
      
    }
    @Test
    public void testGetLegalMove_Legal() {
    	game.move(1, 1);
        assertEquals (true, game.gameModel.blocksData[0][1].getIsLegalMove());
      
    }
    
    
    
}
