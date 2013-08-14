import java.util.*;

public class Board {

	FixedSizeList<FixedSizeList<Piece>> Board_State;
	ArrayList<Piece> whiteGraveyard;
	ArrayList<Piece> blackGraveyard;

	// Initialise pieces
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

		for (int a = 0; a < 8; a++) {
			Board_State.add(a, new FixedSizeList<Piece>());
		}

		// Initialise white pieces
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

		// Add white pieces to row 1
		FixedSizeList<Piece> row = Board_State.get(0);
		row.add(0, whiteRook1);
		row.add(1, whiteKnight1);
		row.add(2, whiteBishop1);
		row.add(3, whiteKing);
		row.add(4, whiteQueen);
		row.add(5, whiteBishop2);
		row.add(6, whiteKnight2);
		row.add(7, whiteRook2);

		// Add white pawns to row 2
		row = Board_State.get(1);
		row.add(0, whitePawn1);
		row.add(1, whitePawn2);
		row.add(2, whitePawn3);
		row.add(3, whitePawn4);
		row.add(4, whitePawn5);
		row.add(5, whitePawn6);
		row.add(6, whitePawn7);
		row.add(7, whitePawn8);

		// Initialise black pieces
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

		// Add black pieces to row 1
		row = Board_State.get(7);
		row.add(0, blackRook1);
		row.add(1, blackKnight1);
		row.add(2, blackBishop1);
		row.add(3, blackKing);
		row.add(4, blackQueen);
		row.add(5, blackBishop2);
		row.add(6, blackKnight2);
		row.add(7, blackRook2);

		// Add black pawns to row 2
		row = Board_State.get(6);
		row.add(0, blackPawn1);
		row.add(1, blackPawn2);
		row.add(2, blackPawn3);
		row.add(3, blackPawn4);
		row.add(4, blackPawn5);
		row.add(5, blackPawn6);
		row.add(6, blackPawn7);
		row.add(7, blackPawn8);

		// Add null values to all other squares

		Null nullPiece = new Null();
		for (int c = 2; c < 6; c++) {
			row = Board_State.get(c);
			for (int d = 0; d < 8; d++) {
				row.add(d, nullPiece);
			}
		}
		System.out.println(Board_State);

		/************** white rook and black rook tests ***********************/
		/*
		 * int[] goodmove2 = {3, 0 }; movePiece(whitePawn1, goodmove2); int[]
		 * goodmove3 = { 4, 0 }; movePiece(whitePawn1, goodmove3); int[]
		 * takemove1 = { 5, 0 }; movePiece(whitePawn1, takemove1); int[]
		 * takemove2 = {6, 1 }; movePiece(whitePawn1, takemove2); int[]
		 * takemove40 = {7, 2 }; movePiece(whitePawn1, takemove40);
		 * 
		 * int[] aj = findPiece(blackPawn1);
		 * System.out.println(Arrays.toString(aj));
		 * System.out.println("blackpawn"); System.out.println(Board_State);
		 * int[] goodmov1 = {4, 0 }; movePiece(blackPawn1, goodmov1); int[]
		 * goodmov2 = { 3, 0 }; movePiece(blackPawn1, goodmov2); int[] takemov3
		 * = { 2, 0 }; movePiece(blackPawn1, takemov3); int[] takemov4 = {1, 1
		 * }; movePiece(blackPawn1, takemov4); int[] takemove3 = { 7, 0 };
		 * movePiece(whiteRook1, takemove3); int[] takemove33 = { 6, 0 };
		 * movePiece(whiteRook1, takemove33); int[] takemove4 = { 7, 0 };
		 * movePiece(whiteRook1, takemove4); int[] takemove5 = { 7, 1 };
		 * movePiece(whiteRook1, takemove5);
		 */

		// int [] takemove8 = {0,0};
		// movePiece(blackRook1, takemove8);
		/*
		 * int [] takemove9 = {0,1}; movePiece(blackRook1, takemove9); int []
		 * takemove11 = {1,1}; movePiece(blackRook1, takemove11);
		 */
		/************* white and black bishop tests ***********************/
		/*
		 * int [] move1 = {2, 1}; movePiece(whitePawn2, move1); int [] move2 =
		 * {1,1}; movePiece(whiteBishop1, move2); int [] move3 = {6,6};
		 * movePiece(whiteBishop1, move3);
		 * System.out.println(Arrays.toString(findPiece(blackPawn7)));
		 * System.out.println(Board_State);
		 */
		/*int [] move1 = {4,0};
		int [] move2 = {3,0};
		int [] move3 = {2,0};
		int [] move4 = {1,1};*/
		//int [] move5 = {3,0};
		//int [] move6 = {3,7};
		/*movePiece(blackPawn1, move1);
		movePiece(blackPawn1, move2);
		movePiece(blackPawn1, move3);
		movePiece(blackPawn1, move4);*/
	//	movePiece(blackRook1, move5);
		//movePiece(blackRook1, findPiece(whitePawn1));
		
		
	//	int[] move4 = { 5, 4 };
		//movePiece(blackPawn5, move4);

		//int [] move5 = {5,3};
		//movePiece(blackBishop2, move5);
		//int [] takePawn8 = findPiece(whitePawn7);
		//movePiece(blackBishop2, takePawn8);
		/*for (int i=0; i<blackBishop2.possibleMoves(move5).size(); i++){
			System.out.println(Arrays.toString(blackBishop2.possibleMoves(move5).get(i)));
		}*/
		//for (int i=0; i<allowedMoves(blackBishop2).size(); i++){
			//System.out.println(Arrays.toString(allowedMoves(blackBishop2).get(i)));
		//}
	
		/*int [] pos = {2, 0};
		movePiece(blackBishop2, pos);
		movePiece(blackBishop2, findPiece(whitePawn2));
		movePiece(blackBishop2, findPiece(whiteBishop1));
		movePiece(blackBishop2, findPiece(whitePawn4));
		int [] pos1 = {3, 5};
		movePiece(blackBishop2, pos1);
		movePiece(blackBishop2, findPiece(whitePawn8));*/
		System.out.println(Board_State);
		/********************* queen testing *******************/
		// int [] m


		// movePiece(whitePawn5, move6);
		/*
		 * System.out.println(allowedMoves(whiteQueen)); int [] move7 = {2,4};
		 * movePiece(whiteQueen, move7); int [] move8 = {2,5};
		 * movePiece(whiteQueen, move8); int [] move9 = {6,5};
		 * movePiece(whiteQueen, move9); System.out.println(Board_State);
		 * System.out.println(whiteGraveyard);
		 */
		/*
		 * int [] goodmove4 = {6 ,0}; int [] b = findPiece(blackRook1);
		 * System.out.println(Arrays.toString(b)); System.out.println("rook");
		 * movePiece(blackRook1, goodmove4); System.out.println(Board_State);
		 * System.out.println(blackGraveyard); int [] f = findPiece(whiteKing);
		 * System.out.println(Arrays.toString(f)); int[] goodmove5 = {4, 3 };
		 * movePiece(blackPawn4, goodmove5); int[] goodmove1 = {6, 3};
		 * movePiece(blackKing, goodmove1); int [] g = findPiece(blackKing);
		 * System.out.println(Arrays.toString(g)); System.out.println("king");
		 * System.out.println(Board_State);
		 */
		/*
		 * int [] y = {5, 1};
		 * System.out.println(Arrays.toString(findPiece(blackPawn5)));
		 * System.out.println(Arrays.toString(findPiece(blackBishop2)));
		 * movePiece(blackPawn2, y); int [] x = {6,1}; movePiece(blackBishop1,
		 * x); System.out.println(Board_State);
		 */

	}

	/**
	 * Initialises board to the given saved state
	 * 
	 * @param savedState
	 *            The saved board from a previous match
	 */
	public Board(Board savedState) {

	}

	/**
	 * Check if either team is in 'Check'
	 * 
	 * @param Team
	 *            The team who is being checked for being in 'Check'. - False is
	 *            for White - True is for Black
	 * @return True if the team is in 'Check', false otherwise.
	 */
	private boolean checkForCheck(boolean Team) {
		List<Piece> activePieces = findActivePieces();
		List<Piece> activeEnemyPieces = new ArrayList<Piece>();
		List<int[]> enemyMoves = new ArrayList<int[]>();

		int[] kingPos;
		kingPos = (Team ? (findPiece(blackKing)) : (findPiece(whiteKing)));

		for (int i = 0; i < activePieces.size(); i++) {
			if (activePieces.get(i).getTeam() != Team) {
				activeEnemyPieces.add(activePieces.get(i));
			}
		}

		for (int i = 0; i < activeEnemyPieces.size(); i++) {
			List<int[]> pieceMoves = allowedMoves(activeEnemyPieces.get(i));
			for (int j = 0; j < pieceMoves.size(); j++) {
				if (!enemyMoves.contains(pieceMoves.get(j))) {
					enemyMoves.add(pieceMoves.get(j));
				}
			}
		}
		try {
			for (int i = 0; i < enemyMoves.size(); i++) {
				if ((enemyMoves.get(i)[0] == kingPos[0])
						&& (enemyMoves.get(i)[1] == kingPos[1])) {
					return true;
				}
			}
			return false;
		} catch (NullPointerException e) {
			System.err.println("King has been taken");
			return false;
		}
	}

	/**
	 * Check if either team is in 'Checkmate'
	 * 
	 * @param Team
	 *            The team who is being checked for being in 'Checkmate'. -
	 *            False is for White - True is for Black
	 * @return True if the team is in 'Checkmate', false otherwise.
	 */
	private boolean checkForCheckmate(boolean Team) {

		return true; // Change when implemented
	}

	private boolean checkForStaleMate(boolean Team) {

		boolean staleMate = false;
		//check that the king isn't in check, then check all the pieces to see 
		//if they can move anywhere, if they can't then it's a stalemate
		if (!checkForCheck(Team) && !checkMoves(findActivePieces())) {
			staleMate = true;
		}
		return staleMate;
	}
	/**
	 * Deactivates the piece from play and adds it to the graveyard
	 * 
	 * @param piece
	 *            Piece to be removed from play
	 */
	private void removePiece(Piece removalPiece) {

	}

	/**
	 * Reactivates the piece into play and removes it from the graveyard
	 * 
	 * @param piece
	 *            Piece to be retrieved into play
	 */
	private void retrievePiece(Piece retrievalPiece) {

	}

	/**
	 * Checks whether a space is currently occupied
	 * 
	 * @param position
	 *            The position to be checked for occupation
	 * @return True if the space is occupied, false if available
	 */
	private boolean occupiedSpace(int[] position) {
		int x = position[0];
		int y = position[1];
		FixedSizeList<Piece> row = Board_State.get(x);
		Piece onSpace = row.get(y);
		Null nullPiece = new Null();

		if (onSpace.getClass() == nullPiece.getClass()) {
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
		// Used by: knight
		if (piece.getClass() == blackKnight1.getClass()) {
			for (int i = 0; i < possibleMoves.size(); i++) {
				// If the space is unoccupied add to list of allowable
				if (!occupiedSpace(possibleMoves.get(i))) {
					allowableMoves.add(possibleMoves.get(i));
				} else {
					// If the space is occupied check by which team
					int x = possibleMoves.get(i)[0];
					int y = possibleMoves.get(i)[1];
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y);
					
					// If piece on the space is on opposing team add to
					// allowable
					if (piece.getTeam() != onSquare.getTeam()) {
						allowableMoves.add(possibleMoves.get(i));
					}
				}
			}
		}

		// Specifically for pawn
		if (piece.getClass() == blackPawn1.getClass()) {
			for (int i = 0; i < possibleMoves.size(); i++) {
				if (occupiedSpace(possibleMoves.get(i))) {
					// If the space is occupied check by which team
					int x = possibleMoves.get(i)[0];
					int y = possibleMoves.get(i)[1];
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y);
					/*
					 * If piece on the space is on opposing team add to
					 * allowable if diagonal
					 */
					if ((piece.getTeam() != onSquare.getTeam())
							&& (possibleMoves.get(i)[1] != currentPos[1])) {
						allowableMoves.add(possibleMoves.get(i));
					}
				} else { // If diagonal squares are empty don't add
					if (possibleMoves.get(i)[1] == currentPos[1]) {
						allowableMoves.add(possibleMoves.get(i));
					}
				}
			}
		}
		// specifically for rook
		if (piece.getClass() == blackRook1.getClass()) {

			this.removeJumpsRook(possibleMoves, currentPos, piece);

			allowableMoves = new ArrayList<int[]>(this.removeJumpsRook(
					possibleMoves, currentPos, piece));
		}
		/*
		 * for (int i = 0; i < possibleMoves.size(); i++) { // If the space is
		 * unoccupied add to list of allowable if
		 * (!occupiedSpace(possibleMoves.get(i))) {
		 * allowableMoves.add(possibleMoves.get(i));
		 * 
		 * } else {
		 * 
		 * // If the space is occupied check by which team int x =
		 * possibleMoves.get(i)[0]; int y = possibleMoves.get(i)[1]; List<Piece>
		 * row = Board_State.get(x); Piece onSquare = row.get(y); // If piece on
		 * the space is on opposing team add to // allowable if (piece.getTeam()
		 * != onSquare.getTeam()) { allowableMoves.add(possibleMoves.get(i));
		 * 
		 * // for rook
		 * 
		 * } } } }
		 */

		// King
		if (piece.getClass() == whiteKing.getClass()) {

			for (int i = 0; i < possibleMoves.size(); i++) {
				// If the space is unoccupied add to list of allowable
				if (!occupiedSpace(possibleMoves.get(i))) {
					allowableMoves.add(possibleMoves.get(i));
				} else {

					// If the space is occupied check by which team
					int x = possibleMoves.get(i)[0];
					int y = possibleMoves.get(i)[1];
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y);
					// If piece on the space is on opposing team add to
					// allowable
					if (piece.getTeam() != onSquare.getTeam()) {
						allowableMoves.add(possibleMoves.get(i));
					}
				}
			}
		}
		// Bishop
		if (piece.getClass() == whiteBishop1.getClass()) {
			this.removeJumpsBishop(possibleMoves, currentPos, piece);
			allowableMoves = new ArrayList<int[]>(this.removeJumpsBishop(
					possibleMoves, currentPos, piece));
		}
		// Queen
		if (piece.getClass() == whiteQueen.getClass()) {
			this.removeJumpsBishop(possibleMoves, currentPos, piece);
			this.removeJumpsRook(possibleMoves, currentPos, piece);
			allowableMoves = new ArrayList<int[]>();
			allowableMoves.addAll(this.removeJumpsBishop(possibleMoves,
					currentPos, piece));
			allowableMoves.addAll(this.removeJumpsRook(possibleMoves,
					currentPos, piece));
		}

		return allowableMoves;
	}

	public void movePiece(Piece piece, int[] newPosition) {
		int[] oldPos = findPiece(piece);
		int x = newPosition[0];
		int y = newPosition[1];

		List<int[]> allowedMoves = allowedMoves(piece);

		boolean allowed = false;
		for (int i = 0; i < allowedMoves.size(); i++) {

			if (newPosition[0] == allowedMoves.get(i)[0]
					&& newPosition[1] == allowedMoves.get(i)[1]) {
				allowed = true;
			}
		}

		if (!allowed) {
			System.err.println("not allowable move");
			return;
		}

		/*
		 * If space is occupied (can only be by other team due to possibleMoves)
		 * deactivate the piece, add it to the graveyard and move new piece to
		 * that square
		 */
		if (occupiedSpace(newPosition)) {
			// Remove enemy piece on the newPosition
			Piece onSquare = Board_State.get(x).get(y);
			onSquare.deActivate();

			if (onSquare.getTeam()) {
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
		for (int i = 0; i < 8; i++) {
			FixedSizeList<Piece> row = Board_State.get(i);
			for (int j = 0; j < 8; j++) {
				if (row.get(j).equals(piece)) {
					int[] pos = { i, j };
					return pos;
				}
			}
		}
		return null;
	}

	public List<Piece> findActivePieces() {
		List<Piece> activePieces = new ArrayList<Piece>();
		Null nullPiece = new Null();

		for (int i = 0; i < 8; i++) {
			FixedSizeList<Piece> row = Board_State.get(i);
			for (int j = 0; j < 8; j++) {
				Piece onSquare = row.get(j);
				if ((onSquare.getClass() != nullPiece.getClass())
						&& onSquare.getActiveState()) {
					activePieces.add(onSquare);
				}
			}
		}
		return activePieces;
	}

	public String toString() {
		String toString = "";
		for (int i = 0; i <= 8; i++) {
			toString += Board_State.get(i).toString();
		}
		return toString;

	}

	/*
	 * checks directions bishop can move and removes jumps from possible moves
	 */
	private List<int[]> removeJumpsBishop(List<int[]> possibleMoves,
		int[] currentPos, Piece piece) {
		int x = currentPos[0];
		int y = currentPos[1];
		//System.out.println(Arrays.toString(currentPos));
		int xCheck;
		int yCheck;
		List<int[]> possible = new ArrayList<int[]>(possibleMoves);
		


		// remove jumps for moving UP and RIGHT
		for (int i = 1; i <= 7; i++) {
			int[] upRight = { x + i, y + i };
			if ((upRight[0] >= 0) && (upRight[0] <= 7) && (upRight[1] >= 0)
					&& (upRight[1] <= 7)) {
				
				// int g = possibleMoves.get(i)[0];
				// int f = possibleMoves.get(i)[1];
				// if space is not occupied continue
				if (!occupiedSpace(upRight)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x + i);
					Piece onSquare = row.get(y + i);
					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x + i + j))
										&& (yCheck == (y + i + j))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x + i + j))
										&& (yCheck == (y + i + j))) {
									possible.remove(k);
								}
							}
						}
						System.out.println(row);
						System.out.println(onSquare);
						break;
					}
				}
			}
		}

		// remove jumps for moving UP and LEFT
		for (int i = 1; i <= 7; i++) {
			
			int[] upLeft = { x + i, y - i };
			if ((upLeft[0] >= 0) && (upLeft[0] <= 7) && (upLeft[1] >= 0)
					&& (upLeft[1] <= 7)) {
				// if space is not occupied continue
				if (!occupiedSpace(upLeft)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x + i);
					Piece onSquare = row.get(y - i);
					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j))
										&& (yCheck == (y + i + j))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j))
										&& (yCheck == (y + i + j))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}

		// remove jumps for moving DOWN and RIGHT
		for (int i = 1; i <= 7; i++) {
			/**/
			
			int[] downRight = { x - i, y + i };
			if ((downRight[0] >= 0) && (downRight[0] <= 7)
					&& (downRight[1] >= 0) && (downRight[1] <= 7)) {
				// if space is not occupied continue
				if (!occupiedSpace(downRight)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x - i);
					Piece onSquare = row.get(y + i);
					//System.out.println("HUZZAH CUNSE!!");
					// remove possible moves AFTER enemy piece onwards in
					// direction
				
					if (piece.getTeam() != onSquare.getTeam()) {
			
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j))
										&& (yCheck == (y + i + j))) {
									possible.remove(k);
								}
							}
						}
						
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j))
										&& (yCheck == (y + i + j))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}
		
		
		// remove jumps for moving DOWN and LEFT
		for (int i = 1; i <= 7; i++) {
			
			int[] downLeft = { x - i, y - i };
			if ((downLeft[0] >= 0) && (downLeft[0] <= 7) && (downLeft[1] >= 0)
					&& (downLeft[1] <= 7)) {
				// if space is not occupied continue
				if (!occupiedSpace(downLeft)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x - i);
					Piece onSquare = row.get(y - i);
					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j))
										&& (yCheck == (y - i - j))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j))
										&& (yCheck == (y - i - j))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}
		/*
		 * for(int i=0;i<possibleMoves.size();i++) {
		 * System.out.println(Arrays.toString(possible.get(i))); }
		 */
		return possible;

	}

	private List<int[]> removeJumpsRook(List<int[]> possibleMoves,
			int[] currentPos, Piece piece) {
		// System.out.print("this is the piece" + " " + piece);
		int x = currentPos[0];
		int y = currentPos[1];
		int xCheck;
		int yCheck;
		List<int[]> possible = new ArrayList<int[]>(possibleMoves);

		// remove jumps for moving UP
		for (int i = 1; i <= 7; i++) {
			int[] up = { x + i, y };
			if ((up[0] >= 0) && (up[0] <= 7) && (up[1] >= 0) && (up[1] <= 7)) {
				// if space is not occupied continue
				if (!occupiedSpace(up)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x + i);
					Piece onSquare = row.get(y);

					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x + i + j)) && (yCheck == (y))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x + i)) && (yCheck == (y))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}

		// remove jumps for moving LEFT
		for (int i = 1; i <= 7; i++) {
			int[] Left = { x, y - i };
			if ((Left[0] >= 0) && (Left[0] <= 7) && (Left[1] >= 0)
					&& (Left[1] <= 7)) {
				// if space is not occupied continue
				if (!occupiedSpace(Left)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y - i);
					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x) && (yCheck == (y - i - j)))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x) && (yCheck == (y - i - j)))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}

		// remove jumps for moving RIGHT
		for (int i = 1; i <= 7; i++) {
			int[] Right = { x, y + i };
			if ((Right[0] >= 0) && (Right[0] <= 7) && (Right[1] >= 0)
					&& (Right[1] <= 7)) {
				// if space is not occupied continue
				if (!occupiedSpace(Right)) {
					continue;
				} else {
					List<Piece> row = Board_State.get(x);
					Piece onSquare = row.get(y + i);
					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x) && (yCheck == (y + i + j)))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x) && (yCheck == (y + i + j)))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}

		// remove jumps for moving DOWN
		for (int i = 1; i <= 7; i++) {
			int[] down = { x - i, y };
			if ((down[0] >= 0) && (down[0] <= 7) && (down[1] >= 0)
					&& (down[1] <= 7)) {

				// if space is not occupied continue
				if (!occupiedSpace(down)) {

					continue;
				} else {
					List<Piece> row = Board_State.get(x - i);
					Piece onSquare = row.get(y);

					// remove possible moves AFTER enemy piece onwards in
					// direction
					if (piece.getTeam() != onSquare.getTeam()) {
						// System.out.println("I iz checking for team!!!");

						for (int j = 1; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j)) && (yCheck == (y))) {
									possible.remove(k);
								}
							}
						}
						break;
						// remove possible moves FROM ally piece onwards in
						// direction
					} else {
						for (int j = 0; j <= 7; j++) {
							for (int k = 0; k < possible.size(); k++) {
								xCheck = possible.get(k)[0];
								yCheck = possible.get(k)[1];
								if ((xCheck == (x - i - j)) && (yCheck == (y))) {
									possible.remove(k);
								}
							}
						}
						break;
					}
				}
			}
		}
		/*
		 * for(int i=0;i<possibleMoves.size();i++) {
		 * System.out.println(Arrays.toString(possible.get(i))); }
		 */
		return possible;

	}
	public boolean checkMoves(List<Piece> activePieces) {
		boolean canMove = true;
		activePieces = findActivePieces();

		for (int i = 0; i < activePieces.size(); i++) {
			if (allowedMoves(activePieces.get(i)).isEmpty()) {
				canMove = false;
			} else {
				canMove = true;
			}
		}
		return canMove;
	}
}
