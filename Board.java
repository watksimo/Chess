import java.util.*;

public class Board {

	FixedSizeList<FixedSizeList<Piece>> Board_State;
	ArrayList<Piece> whiteGraveyard;
	ArrayList<Piece> blackGraveyard;
	
	//Initialise pieces
	Pawn whitePawn1;
	Pawn whitePawn2;
	Pawn whitePawn3;
	Pawn whitePawn4;
	Pawn whitePawn5;
	Pawn whitePawn6;
	Pawn whitePawn7;
	Pawn whitePawn8;
	Rook whiteRook1;
	Knight whiteKnight1;
	Bishop whiteBishop1;
	King whiteKing;
	Queen whiteQueen;
	Bishop whiteBishop2;
	Knight whiteKnight2;
	Rook whiteRook2;
	
	Pawn blackPawn1;
	Pawn blackPawn2;
	Pawn blackPawn3;
	Pawn blackPawn4;
	Pawn blackPawn5;
	Pawn blackPawn6;
	Pawn blackPawn7;
	Pawn blackPawn8;
	Rook blackRook1;
	Knight blackKnight1;
	Bishop blackBishop1;
	King blackKing;
	Queen blackQueen;
	Bishop blackBishop2;
	Knight blackKnight2;
	Rook blackRook2;
	
	
	/**
	 * Initialises board to the default setup.
	 */
	public Board() {
		
		Board_State = new FixedSizeList<FixedSizeList<Piece>>();
		blackGraveyard = new ArrayList<Piece>();
		whiteGraveyard = new ArrayList<Piece>();
		
		for(int a=0; a<8; a++) {
			Board_State.add(a, new FixedSizeList<Piece>());
		}
		
		//Initialise white pieces
		whitePawn1 = new Pawn(false, 1);
		whitePawn2 = new Pawn(false, 2);
		whitePawn3 = new Pawn(false, 3);
		whitePawn4 = new Pawn(false, 4);
		whitePawn5 = new Pawn(false, 5);
		whitePawn6 = new Pawn(false, 6);
		whitePawn7 = new Pawn(false, 7);
		whitePawn8 = new Pawn(false, 8);
		whiteRook1 = new Rook(false, 1);
		whiteKnight1 = new Knight(false, 1);
		whiteBishop1 = new Bishop(false, 1);
		whiteKing = new King(false);
		whiteQueen = new Queen(false);
		whiteBishop2 = new Bishop(false, 2);
		whiteKnight2 = new Knight(false, 2);
		whiteRook2 = new Rook(false, 2);
		
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
		blackPawn1 = new Pawn(true, 1);
		blackPawn2 = new Pawn(true, 2);
		blackPawn3 = new Pawn(true, 3);
		blackPawn4 = new Pawn(true, 4);
		blackPawn5 = new Pawn(true, 5);
		blackPawn6 = new Pawn(true, 6);
		blackPawn7 = new Pawn(true, 7);
		blackPawn8 = new Pawn(true, 8);
		blackRook1 = new Rook(true, 1);
		blackKnight1 = new Knight(true, 1);
		blackBishop1 = new Bishop(true, 1);
		blackKing = new King(true);
		blackQueen = new Queen(true);
		blackBishop2 = new Bishop(true, 2);
		blackKnight2 = new Knight(true, 2);
		blackRook2 = new Rook(true, 2);
				
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
		int[] goodMove1 = {3,1};
		movePiece(whitePawn2, goodMove1);
		int[] goodMove2 = {4,1};
		movePiece(whitePawn2, goodMove2);
		int[] goodMove3 = {5,1};
		movePiece(whitePawn2, goodMove3);
		int[] goodMove4 = {6,2};
		movePiece(whitePawn2, goodMove4);
		int[] goodMove5 = {7,3};
		movePiece(whitePawn2, goodMove5);
		
		System.out.println(Board_State);
		System.out.println(blackGraveyard);
		System.out.println(checkForCheck(true));
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
		List<Piece> activePieces = findActivePieces();
		List<Piece> activeEnemyPieces = new ArrayList<Piece>();
		List<int[]> enemyMoves = new ArrayList<int[]>();
		
		int[] kingPos;
		kingPos = (Team ? (findPiece(blackKing)) : (findPiece(whiteKing)));
		
		
		for(int i=0; i<activePieces.size(); i++) {
			if(activePieces.get(i).getTeam() != Team) {
				activeEnemyPieces.add(activePieces.get(i));
			}
		}
		
		for(int i=0; i<activeEnemyPieces.size(); i++) {
			List<int[]> pieceMoves = allowedMoves(activeEnemyPieces.get(i));
			for(int j=0; j<pieceMoves.size(); j++) {
				if(!enemyMoves.contains(pieceMoves.get(j))) {
					enemyMoves.add(pieceMoves.get(j));
				}
			}
		}
		try {
			for(int i=0; i<enemyMoves.size(); i++) {
				if((enemyMoves.get(i)[0] == kingPos[0]) && (enemyMoves.get(i)[1] == kingPos[1])) {
					return true;
				}
			}
			return false;
		} catch(NullPointerException e) {
			System.err.println("King has been taken");
			return false;
		}
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
	
	public List<int[]> allowedMoves(Piece piece) {
		int[] currentPos = findPiece(piece);
		List<int[]> possibleMoves = piece.possibleMoves(currentPos);
		List<int[]> allowableMoves = new ArrayList<int[]>();
		
		/*
		 * Checks if possibleMoves spaces are occupied, if occupied by own team
		 * don't allow, if occupied by other team allow.
		 */
		//Used by: knight
		if(piece.getClass() == blackKnight1.getClass()) {
			for(int i=0; i<possibleMoves.size(); i++) {
				//If the space is unoccupied add to list of allowable 
				if(!occupiedSpace(possibleMoves.get(i))) {
					allowableMoves.add(possibleMoves.get(i));
				} else {
					//If the space is occupied check by which team
					int x = possibleMoves.get(i)[0];
					int y = possibleMoves.get(i)[1];
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y);
					//If piece on the space is on opposing team add to allowable
					if(piece.getTeam() != onSquare.getTeam()) {
						allowableMoves.add(possibleMoves.get(i));
					}
				}
			}
		}
		
		//Specifically for pawn
		if(piece.getClass() == blackPawn1.getClass()) {
			for(int i=0; i<possibleMoves.size(); i++) {
				if(occupiedSpace(possibleMoves.get(i))) {
					//If the space is occupied check by which team
					int x = possibleMoves.get(i)[0];
					int y = possibleMoves.get(i)[1];
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y);
					/*If piece on the space is on opposing team add to allowable
					  if diagonal*/
					if((piece.getTeam() != onSquare.getTeam()) && 
							(possibleMoves.get(i)[1] != currentPos[1])) {
						allowableMoves.add(possibleMoves.get(i));
					}
				} else {  //If diagonal squares are empty don't add
					if(possibleMoves.get(i)[1] == currentPos[1]) {
						allowableMoves.add(possibleMoves.get(i));
					}
				}
			}
		}
		return allowableMoves;
	}
	
	public void movePiece(Piece piece, int[] newPosition) {
		int[] oldPos = findPiece(piece);
		int x = newPosition[0];
		int y = newPosition[1];
		
		List<int[]> allowedMoves = allowedMoves(piece);
		
		boolean allowed = false;
		for(int i=0; i<allowedMoves.size(); i++) {
			if(newPosition[0] == allowedMoves.get(i)[0] && newPosition[1] == allowedMoves.get(i)[1]) {
				allowed = true;
			}
		}
		
		if(!allowed) {
			System.err.println("not allowable move");
			return;
		}
		
		/*If space is occupied (can only be by other team due to possibleMoves)
		deactivate the piece, add it to the graveyard and move new piece to 
		that square*/
		if(occupiedSpace(newPosition)) {
			//Remove enemy piece on the newPosition
			Piece onSquare = Board_State.get(x).get(y);
			onSquare.deActivate();
			
			if(onSquare.getTeam()) {
				blackGraveyard.add(onSquare);
			} else {
				whiteGraveyard.add(onSquare);
			}
			Board_State.get(oldPos[0]).add(oldPos[1], new Null());
			Board_State.get(x).add(y, piece);
		} else {
			Board_State.get(oldPos[0]).add(oldPos[1], new Null());
			Board_State.get(x).add(y, piece);
		}
	}
	
	public int[] findPiece(Piece piece) {
		for(int i=0; i<8; i++) {
			FixedSizeList<Piece> row = Board_State.get(i);
			for(int j=0; j<8; j++) {
				if(row.get(j).equals(piece)) {
					int[] pos = {i, j};
					return pos;
				}
			}
		}
		return null;
	}
	
	public List<Piece> findActivePieces() {
		List<Piece> activePieces = new ArrayList<Piece>();
		Null nullPiece = new Null();
		
		for(int i=0; i<8; i++) {
			FixedSizeList<Piece> row = Board_State.get(i);
			for(int j=0; j<8; j++) {
				Piece onSquare = row.get(j);
				if((onSquare.getClass() != nullPiece.getClass()) && 
						onSquare.getActiveState()) {
					activePieces.add(onSquare);
				}
			}
		}
		return activePieces;
	}
	
	
	public String toString() {
		String toString = "";
		for(int i=0; i<=8; i++) {
			toString += Board_State.get(i).toString();
		}
		return toString;
		
	}
	
}
