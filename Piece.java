import java.util.*;

public interface Piece {
	
	/**
	 * Returns a list of all possible moves that the piece can make
	 * 
	 * @return
	 * 		List of the locations of all possible moves.
	 */
	public List<int[]> possibleMoves(int[] currentPos);
	
	/**
	 * Moves the piece to the new position. If an opposing piece is in the
	 * given position, it will deactivate that piece.
	 * 
	 * @param position
	 * 				The position to which the piece will be moved
	 */
	public void moveTo(int[] position);
	
	/**
	 * Remove the piece from gameplay and send to the graveyard
	 */
	public void deActivate();
	
	/**
	 * Add the piece back into gameplay and remove from the graveyard
	 */
	public void reActivate();
	
	/**
	 * Takes in a piece and returns it's team as a boolean
	 * 		- False = white team
	 * 		- True = black team 
	 * 
	 * @param piece
	 * 		The instance of the piece to check
	 * @return
	 * 		False if on the white team, true if on the black team
	 */
	public boolean getTeam(Piece piece);
	
	/**
	 * Takes in a piece and returns a boolean based on whether it's taken it's
	 * first move
	 * 
	 * @param piece
	 * 		The instance of the piece to check
	 * @return
	 * 		True if piece has moved, false otherwise
	 */
	public boolean getFirstMove(Piece piece);
	
	/**
	 * Takes in a piece and returns a boolean based on whether the piece is 
	 * still active or not
	 * 
	 * @param piece
	 * 		The instance of the piece to check
	 * @return
	 * 		True if the piec eis still in play, false otherwise
	 */
	public boolean getActiveState(Piece piece);
	
	/**
	 * Takes in a piece and returns it's numerical preference
	 * 
	 * @param piece
	 * 		The instance of the piece to check
	 * @return
	 * 		The integer value of the pieces preference
	 */
	public int getPreference(Piece piece);
	
}
