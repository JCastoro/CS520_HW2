package model;


/*
 * Object holds player turn, moves left, final result and a 2d array of RowBlockModels
 * 
 * This is the Model in our MVC Architecture. It holds the data for the game.
 */

public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    //creates empty 2d array of RowBlockModel type
    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    public String player = "1";
    public int movesLeft = 9;

    private String finalResult = null;


    public RowGameModel() {
	super();

	//fills array with RowBlockModel objects
	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
	    	blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }
    

    }
    s
