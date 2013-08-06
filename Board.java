import java.util.*;

public class Board {

	FixedSizeList<FixedSizeList<Piece>> Board_State;
	ArrayList<ArrayList<Piece>> Graveyard;
	
	/**
	 * Initialises board to the default setup.
	 */
	public Board() {
		
		Board_State = new FixedSizeList<FixedSizeList<Piece>>();
		
		for(int a=0; a<8; a++) {
			Board_State.add(a, new FixedSizeList<Piece>());
		}
		
		//Initialise white pieces
		Pawn whitePawn1 = new Pawn(false);
		Pawn whitePawn2 = new Pawn(false);
		Pawn whitePawn3 = new Pawn(false);
		Pawn whitePawn4 = new Pawn(false);
		Pawn whitePawn5 = new Pawn(false);
		Pawn whitePawn6 = new Pawn(false);
		Pawn whitePawn7 = new Pawn(false);
		Pawn whitePawn8 = new Pawn(false);
		Rook whiteRook1 = new Rook(false);
		Knight whiteKnight1 = new Knight(false);
		Bishop whiteBishop1 = new Bishop(false);
		King whiteKing = new King(false);
		Queen whiteQueen = new Queen(false);
		Bishop whiteBishop2 = new Bishop(false);
		Knight whiteKnight2 = new Knight(false);
		Rook whiteRook2 = new Rook(false);
		
		//Add white pieces to row 1
		FixedSizeList<Piece> row = Board_State.get(0);
		row.add(0, whiteRook1);
		row.add(1, whiteKnight1);
		row.add(2, whiteBishop1);
		row.add(3, whiteKing);
		row.add(4, whiteQueen);
		row.add(5, whiteBishop2);
		row.add(6, whiteKnight2);
		row.add(7, whiteRook2);
		
		//Add white pawns to row 2
		row = Board_State.get(1);
		row.add(0, whitePawn1);
		row.add(1, whitePawn2);
		row.add(2, whitePawn3);
		row.add(3, whitePawn4);
		row.add(4, whitePawn5);
		row.add(5, whitePawn6);
		row.add(6, whitePawn7);
		row.add(7, whitePawn8);
		
	
		
		
		//Initialise black pieces
		Pawn blackPawn1 = new Pawn(true);
		Pawn blackPawn2 = new Pawn(true);
		Pawn blackPawn3 = new Pawn(true);
		Pawn blackPawn4 = new Pawn(true);
		Pawn blackPawn5 = new Pawn(true);
		Pawn blackPawn6 = new Pawn(true);
		Pawn blackPawn7 = new Pawn(true);
		Pawn blackPawn8 = new Pawn(true);
		Rook blackRook1 = new Rook(true);
		Knight blackKnight1 = new Knight(true);
		Bishop blackBishop1 = new Bishop(true);
		King blackKing = new King(true);
		Queen blackQueen = new Queen(true);
		Bishop blackBishop2 = new Bishop(true);
		Knight blackKnight2 = new Knight(true);
		Rook blackRook2 = new Rook(true);
				
		//Add black pieces to row 1
		row = Board_State.get(7);
		row.add(0, blackRook1);
		row.add(1, blackKnight1);
		row.add(2, blackBishop1);
		row.add(3, blackKing);
		row.add(4, blackQueen);
		row.add(5, blackBishop2);
		row.add(6, blackKnight2);
		row.add(7, blackRook2);
				
		//Add black pawns to row 2
		row = Board_State.get(6);
		row.add(0, blackPawn1);
		row.add(1, blackPawn2);
		row.add(2, blackPawn3);
		row.add(3, blackPawn4);
		row.add(4, blackPawn5);
		row.add(5, blackPawn6);
		row.add(6, blackPawn7);
		row.add(7, blackPawn8);
		
		//Add null values to all other squares
		
		Null nullPiece = new Null();
		for(int c=2; c<6; c++) {
			row = Board_State.get(c);
			for(int d=0; d<8; d++) {
				row.add(d, nullPiece);
			}
		}
		System.out.println(Board_State);
		
		int[] a = {1,0};
		int[] b = {4,4};
		
		System.out.println(occupiedSpace(a));
		System.out.println(occupiedSpace(b));
		
	}
	
	/**
	 * Initialises board to the given saved state
	 * 
	 * @param savedState
	 * 			The saved board from a previous match
	 */
	public Board(Board savedState) {
		
	}
	
	/**
	 * Check if either team is in 'Check'
	 * 
	 * @param Team
	 * 		The team who is being checked for being in 'Check'.
	 * 				- False is for White
	 * 				- True is for Black
	 * @return
	 * 		True if the team is in 'Check', false otherwise.
	 */
	private boolean checkForCheck(boolean Team) {
		
		
		return true; //Change when implemented
	}
	
	/**
	 * Check if either team is in 'Checkmate'
	 * 
	 * @param Team
	 * 		The team who is being checked for being in 'Checkmate'.
	 * 				- False is for White
	 * 				- True is for Black
	 * @return
	 * 		True if the team is in 'Checkmate', false otherwise.
	 */
	private boolean checkForCheckmate(boolean Team) {
		
		return true; //Change when implemented
	}
	
	/**
	 * Deactivates the piece from play and adds it to the graveyard
	 * 
	 * @param piece
	 * 		Piece to be removed from play
	 */
	private void removePiece(Piece removalPiece) {
		
	}
	
	/**
	 * Reactivates the piece into play and removes it from the graveyard
	 * 
	 * @param piece
	 * 		Piece to be retrieved into play
	 */
	private void retrievePiece(Piece retrievalPiece) {
		
	}
	
	/**
	 * Checks whether a space is currently occupied
	 * 
	 * @param position
	 * 		The position to be checked for occupation
	 * @return
	 * 		True if the space is occupied, false if available
	 */
	private boolean occupiedSpace(int[] position) {
		int x = position[0];
		int y = position[1];
		FixedSizeList<Piece> row = Board_State.get(x);
		Piece onSpace = row.get(y);
		Null nullPiece = new Null();
		
		if(onSpace.getClass() == nullPiece.getClass()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Reset the board to it's default state
	 */
	private void reset() {
		
	}
	
	private List<int[]> allowedMoves(Piece piece) {
		List<int[]> possibleMoves = piece.possibleMoves(findPiece(piece));
		List<int[]> allowableMoves = new ArrayList<int[]>();
		
		for(int i=0; i<possibleMoves.size(); i++) {
			if(!occupiedSpace(possibleMoves.get(i))) {
				allowableMoves.add(possibleMoves.get(i));
			} else {
				int x = possibleMoves.get(i)[0];
				int y = possibleMoves.get(i)[1];
				List<Piece> row = Board_State.get(x);
				Piece onSquare = row.get(y);
				if(piece.getTeam(piece) != onSquare.getTeam(onSquare)) {
					allowableMoves.add(possibleMoves.get(i));
				}
			}
		}
		return allowableMoves;
	}
	
	private void movePiece(Piece piece, int[] newPosition) {
		piece.moveTo(newPosition, findPiece(piece));
	}
	
	public int[] findPiece(Piece piece) {
		for(int i=0; i<8; i++) {
			FixedSizeList row = Board_State.get(i);
			for(int j=0; j<8; j++) {
				if(row.get(j).equals(piece)) {
					int[] pos = {i+1, j+1};
					return pos;
				}
			}
		}
		return null;
	}
	
	public String toString() {
		String toString = "";
		for(int i=0; i<=8; i++) {
			toString += Board_State.get(i).toString();
		}
		return toString;
		
	}
	
}
