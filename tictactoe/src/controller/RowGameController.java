package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import view.RowGameGUI;

/**
 * class holds all of the functions for controller aspect of MVC architecture. The actual Java Swing objects
 * the user will interact with are held in the RowGameGUI file.
 * 
 * 
 * 
 */
public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;

    /**
     * Creates a new game initializing the GUI as well as the underlying game Model.
     * 
     */
    public RowGameController() {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
            	
	        gameModel.blocksData[row][column].setContents("");
	        gameModel.blocksData[row][column].setIsLegalMove(true);
	        gameView.updateBlock(gameModel,row,column);
            }
        }
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(int row, int column) {
    	if(gameModel.blocksData[row][column].getIsLegalMove() == false) {
    		throw new IllegalArgumentException("The move must be legal");
    	}
    	else {//if this location is a legal move
    	
    	gameModel.movesLeft--;
    	gameModel.blocksData[row][column].setIsLegalMove(false);
    	
    	
    	String player1Symbol = "X";
    	String player1Name = "Player 1";
    	String player2Symbol = "O";
    	String player2Name = "Player 2";
    	
	
    	if(gameModel.movesLeft%2 == 1) {//if odd number of moves left its player 1 turn    	
    		gameView.playerturn.setText(player1Symbol + ": " + player1Name);
    		gameModel.blocksData[row][column].setContents("O");
    	} 
    	else{//if even its player 2
    		gameView.playerturn.setText(player2Symbol + ": " + player2Name);
    		gameModel.blocksData[row][column].setContents("X");
    		
    	}
    	
    	gameView.updateBlock(gameModel,row,column);
    	endGameIfWon(row,column);
    	
    	if(gameModel.movesLeft <=0) {
    		
    		//example of type safety
    		gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
    		endGame();
    	}
    	
    	//updating blocks
    	gameView.updateBlock(gameModel,row,column);
	
    }
    }
    
    //checks if the game is won. Could run this starting on turn 5 to save computations.
    public void endGameIfWon(int row, int column) {//is this a bad name??
    	int player1RowCount = 0;
    	int player1ColCount = 0;
    	int player1TopDownDiagonal = 0;
    	int player1DownTopDiagonal = 0;
    	
    	int player2RowCount = 0;
       	int player2ColCount = 0;
    	int player2TopDownDiagonal = 0;
    	int player2DownTopDiagonal = 0;
    	
    	//String movedCellValue = gameModel.blocksData[row][column].getContents();
    	String currCellValue;
    	//assuming we will not be making the board any larger.
    	// better computational implementation would create row, column and diagonals vectors for each player
    		// would add 1 to respective vectors and check if sum was 3, if 3 then we know there is a win.
    	
    	
    	//based on where the move is played you only have to check that row, col and possibly diagonal.
    	//checking column
    	for( int i = 0; i<3; i++) {//checks all blocks in the column that the move was made in
    		currCellValue = gameModel.blocksData[i][column].getContents();
	    	if( currCellValue == "X") {
	    		player1RowCount += 1;
	    	}
	    	else if(currCellValue == "O") {
	    		player2RowCount += 1;
	    	}
    	}    	
    	//checking row
    	for( int i = 0; i<3; i++) {//checks all blocks in the row the move was made in
    		currCellValue = gameModel.blocksData[row][i].getContents();
	    	if( currCellValue == "X") {
	    		player1ColCount += 1;	
	    	}
	    	else if(currCellValue == "O") {
	    		player2ColCount += 1;
	    	}
	    	
    	}
    	
    	//checking diagonals
    	for( int i = 0; i<3; i++) {//topDown Diagonal
    		currCellValue = gameModel.blocksData[i][i].getContents();
    		if( currCellValue == "X") {
    			player1TopDownDiagonal += 1;	
	    	}
	    	else if(currCellValue == "O") {
	    		player2TopDownDiagonal += 1;
	    	}
    		
    	}
    		//bottom left to top right diagonal
    	//else if((row == 2 && column == 0) || (row == 2 && column == 0) || (row == 1 && column == 1) ) {// this is not ideal
    	for( int i = 0,j=2; i<3; i++,j--) {
    		currCellValue = gameModel.blocksData[i][j].getContents();
    		if( currCellValue == "X") {
    			player1DownTopDiagonal += 1;	
	    	}
	    	else if(currCellValue == "O") {
	    		player2DownTopDiagonal += 1;
	    	}	
    	}
    	
    	
    	//updating results
    	
    	if ((player1DownTopDiagonal == 3) || (player1TopDownDiagonal == 3) 
    			|| (player1RowCount == 3) || player1ColCount == 3) {
          	gameModel.setFinalResult("Player 1 Wins");
          	
          	endGame();
          }
          else if ((player2DownTopDiagonal == 3) || (player2TopDownDiagonal == 3) 
      			|| (player2RowCount == 3) || player2ColCount == 3) {
          	gameModel.setFinalResult("Player 2 Wins");
   
          	endGame();
          } 
    	
    	 	
    }
    
    
    
    
    
    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
	for(int row = 0;row<3;row++) {
	    for(int column = 0;column<3;column++) {
	    	gameView.blocks[row][column].setEnabled(false);
	    }
	}
	gameView.playerturn.setText(gameModel.getFinalResult());
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
                gameModel.blocksData[row][column].setIsLegalMove(true);
                gameView.updateBlock(gameModel,row,column);
            }
        }
        	gameModel.player = "1";
        	gameModel.movesLeft = 9;
        	gameModel.setFinalResult(null);
        	gameView.playerturn.setText("Player 1 to play 'X'");
    }
}
