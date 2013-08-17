import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class jUnitTests {
	
	Board board = new Board();
	
	/**
	 * Tests the movement of pawns and their capabilities to take pieces
	 */
	@Test
	public void testPawn() {
		Null nullPiece = board.nullPiece;
		ArrayList<Piece> expectedWhiteGraveyard = new ArrayList<Piece>();
		ArrayList<Piece> expectedBlackGraveyard = new ArrayList<Piece>();
		Board expectedBoard = new Board();
		
		expectedBoard.Board_State.get(1).add(1, nullPiece);
		expectedBoard.Board_State.get(1).add(4, nullPiece);
		expectedBoard.Board_State.get(1).add(5, nullPiece);
		expectedBoard.Board_State.get(3).add(1, board.whitePawn2);
		expectedBoard.Board_State.get(3).add(5, board.blackPawn7);
		expectedBoard.Board_State.get(6).add(3, nullPiece);
		expectedBoard.Board_State.get(6).add(4, board.whitePawn5);
		expectedBoard.Board_State.get(6).add(6, nullPiece);
		
		
		int[] w5 = {3,4};
		board.movePiece(board.whitePawn5, w5);
		int[] b4 = {4,3};
		board.movePiece(board.blackPawn4, b4);
		int[] w2 = {3,1};
		board.movePiece(board.whitePawn2, w2);
		int[] b7 = {4,6};
		board.movePiece(board.blackPawn7, b7);
		int[] w6 = {3,5};
		board.movePiece(board.whitePawn6, w6);
		int[] w5b = {4,3};
		board.movePiece(board.whitePawn5, w5b);
		expectedBlackGraveyard.add(board.blackPawn4);
		int[] b7b = {3,5};
		board.movePiece(board.blackPawn7, b7b);
		expectedWhiteGraveyard.add(board.whitePawn6);
		int[] w5c = {5,3};
		board.movePiece(board.whitePawn5, w5c);
		int[] w5d = {6,4};
		board.movePiece(board.whitePawn5, w5d);
		expectedBlackGraveyard.add(board.blackPawn5);
		
		assertEquals("Black Graveyard: ", expectedBlackGraveyard, board.blackGraveyard);
		assertEquals("White Graveyard: ", expectedWhiteGraveyard, board.whiteGraveyard);
		assertEquals("Check for Check: ", true, board.checkForCheck(true));
		assertEquals("Board State: ", expectedBoard.Board_State, board.Board_State);
		
		int[] w5e = {7,3};
		board.movePiece(board.whitePawn5, w5e);
		expectedBlackGraveyard.add(board.blackKing);
	}
	
	
}
