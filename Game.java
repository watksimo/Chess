import java.util.*;

public class Game {
	boolean players_move;
	boolean playing;
	
	
	
	/**
	 * Initialises a new game 
	 */
	public Game() {
		Board board = new Board();
		
		int[] goodPos = {2, 0};
		int[] badPos = {5, 3};
		
		System.out.println("Original Position: " + board.findPiece(board.whiteKnight1)[0] + ", " + board.findPiece(board.whiteKnight1)[1]);
		board.movePiece(board.whiteKnight1, goodPos);
		
		System.out.println("New Position: " + board.findPiece(board.whiteKnight1)[0] + ", " + board.findPiece(board.whiteKnight1)[1]);
		
		System.out.println(board.Board_State);
		
		board.movePiece(board.whiteKnight1, badPos);
	}
	
	/**
	 * Ends the game
	 */
	private void finishGame() {
		
	}
	
	/**
	 * Ends the game declaring the forfeiting player the loser
	 * 
	 * @param team
	 * 		The team that is forfeiting the match
	 * 				- False means white
	 * 				- True means black
	 */
	private void forfeit(boolean team) {
		
	}
}
