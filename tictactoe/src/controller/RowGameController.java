package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import view.RowGameGUI;

public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;

    /**
     * Creates a new game initializing the GUI.
     * 
     * 
     * Houses the functions for every controller aspect i.e buttons
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
    public void move(JButton block) {
	gameModel.movesLeft--;
	String player1Symbol = "X";
	String player1Name = "Player 1";
	String player2Symbol = "O";
	String player2Name = "Player 2";
	
	if(gameModel.movesLeft%2 == 1) {//if odd number of moves left its player 1 turn
	    gameView.playerturn.setText(player1Symbol + ": " + player1Name);
	} else{//if even its player 2
	    gameView.playerturn.setText(player2Symbol + ": " + player2Name);
	}
	
	if(gameModel.player.equals("1")) {
	    // Check whether player 1 won
	    if(block==gameView.blocks[0][0]) {
	    	gameModel.blocksData[0][0].setContents("X");
	    	gameView.updateBlock(gameModel,0,0);
	    	gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
		
		
	    } else if(block==gameView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("X");
		gameView.updateBlock(gameModel,0,1);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("X");
		gameView.updateBlock(gameModel,0,2);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("X");
		gameView.updateBlock(gameModel,1,0);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("X");
		gameView.updateBlock(gameModel,1,1);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("X");
		gameView.updateBlock(gameModel,1,2);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("X");
		gameView.updateBlock(gameModel,2,0);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("X");
		gameView.updateBlock(gameModel,2,1);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("X");
		gameView.updateBlock(gameModel,2,2);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    }
	} else {
	    // Check whether player 2 won
	    if(block==gameView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("O");
		gameView.updateBlock(gameModel,0,0);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("O");
		gameView.updateBlock(gameModel,0,1);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("O");
		gameView.updateBlock(gameModel,0,2);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("O");
		gameView.updateBlock(gameModel,1,0);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("O");
		gameView.updateBlock(gameModel,1,1);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("O");
		gameView.updateBlock(gameModel,1,2);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("O");
		gameView.updateBlock(gameModel,2,0);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("O");
		gameView.updateBlock(gameModel,2,1);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("O");
		gameView.updateBlock(gameModel,2,2);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
		    	gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
		    	gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    }
	}
    }

    
    
    
    
    
    
    
    //checks if the game is won. Could run this starting on turn 5 to save computations.
    public void endGameIfWon(Jbutton block) {//is this a bad name??
    	int player1Count = 0;
    	int player1TopDownDiagonal = 0;
    	int player1DownTopDiagonal = 0;
    	
    	int player2Count = 0;
    	int player2TopDownDiagonal = 0;
    	int player2DownTopDiagonal = 0;
    	
    	
    	//assuming we will not be making the board any larger.
    	// better computational implementation would create row, column and diagonals vectors for each player
    		// would add 1 to respective vectors and check if sum was 3, if 3 then we know there is a win.
    	
    	
    	//based on where the move is played you only have to check that row, col and possibly diagonal.
    	
    	//iterate through each row
    	
    	
    	
    	
    	for (int row = 0; row < 3; row++) {
    	    for (int col = 0; col < 3; col++) {
    	    	//tally the amount of X's
    	    	String currCellValue = gameModel.blocksData[row][col].getContents();
    	    	if( currCellValue == "X") {
    	    		player1Count += 1;	
    	    	}
    	    	else if(currCellValue == "O") {
    	    		player2Count += 1;
    	    	}
    	    	
    	    }
    	}
        if (player1Count == 3) {
        	gameModel.setFinalResult("Player 1 Wins");
        	endGame();
        }
        else if (player2Count == 3) {
        	gameModel.setFinalResult("Plater 2 Wins");
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
        	gameView.playerturn.setText("Player 1 to play 'X'");
    }
}
