import java.util.ArrayList;
import java.util.List;

public class King implements Piece {
	public static List<int[]> moves = new ArrayList<int[]>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (firstMove ? 1231 : 1237);
		result = prime * result + preference;
		result = prime * result + (team ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		King other = (King) obj;
		if (active != other.active)
			return false;
		if (firstMove != other.firstMove)
			return false;
		if (preference != other.preference)
			return false;
		if (team != other.team)
			return false;
		return true;
	}

	boolean team;
	boolean firstMove;
	boolean active;
	int preference;
	boolean isChecked;


	/**
	 * Initialises the piece
	 * 
	 * @param team
	 */
	public King(boolean team) {
		this.team = team;
		this.firstMove = false;
		this.active = true;
		this.preference = 6;
	}

	@Override
	public void moveTo(int[] newPosition, int [] currentPos){
		
		
	}

	@Override
	public void deActivate() {
		active = false;

	}

	@Override
	public void reActivate() {
		active = true;

	}

	public String toString() {
		String toString = "";

		if (!team) {
			toString += "white ";
		} else {
			toString += "black ";
		}

		toString += "King";

		return toString;
	}

	@Override
	public boolean getTeam(Piece piece) {
		return this.team;
	}

	@Override
	public boolean getFirstMove(Piece piece) {
		return this.firstMove;	
	}

	@Override
	public boolean getActiveState(Piece piece) {
		return this.active;
	}

	@Override
	public int getPreference(Piece piece) {
		return this.preference;
	}

	@Override
	public List<int[]> possibleMoves(int[] currentPos) {

		int x = currentPos[0];// current row position
		int y = currentPos[1];// current column position
		
		int[] a = { x + 1, y }; // forward
		int[] b = { x + 1, y + 1 }; // forward right
		int[] c = { x + 1, y - 1 }; // forward left
		int[] d = { x, y + 1 }; // right
		int[] e = { x, y - 1 }; // left
		int[] f = { x - 1, y + 1 }; // Back right
		int[] g = { x - 1, y }; // back
		int[] h = { x - 1, y - 1 }; // back left
		moves.add(a);
		moves.add(b);
		moves.add(c);
		moves.add(d);
		moves.add(e);
		moves.add(g);
		moves.add(h);
		moves.add(f);
		
		if (firstMove) {
			int[] castle = { x, y + 2 };
			moves.add(castle);
		
			if (!firstMove) {
				moves.remove(castle);
			}
		}
			
			
				if (y == 7) {
					removeMoves(null, b, null, d, null, f, null, null);
				}
				if (x == 7) {
					removeMoves(a, b, c, null, null, null, null, null);
				}

				if (y == 0) {
					removeMoves(null,null, c, null, e, null, null, h);
				}
				if (x == 0) {
					removeMoves(null, null, null, null, null, f, g, h);
				}			
		return moves;
		}	
	

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean check) {

		isChecked = check;
	}

	public void checkForCheck(Board board, Piece piece) {

		ArrayList<int[]> checks = new ArrayList<int[]>();

		for (int x = 0; x < checks.size(); x++) {
			if (checks.get(x).equals(board.findPiece(piece))) {
				isChecked = true;
				break;
			} else {
				isChecked = false;
			}
		}
	}

	public ArrayList<int[]> getChecks(Board board) {

		ArrayList<int[]> possibleChecks = new ArrayList<int[]>();
		// for (int x = 0; x<board.
		return null;

	}

	public void removeMoves(int[] a, int[] b, int[] c, int[] d, int[] e,
			int[] f, int[] g, int[] h) {
		if (a == null) {

		}

		else {
			moves.remove(a);
		}
		if (b == null) {

		}

		else {
			moves.remove(b);
		}
		if (c == null) {

		}

		else {
			moves.remove(c);
		}
		if (d == null) {

		}

		else {
			moves.remove(d);
		}
		if (e == null) {

		}

		else {
			moves.remove(e);
		}
		if (f == null) {

		}

		else {
			moves.remove(f);
		}
		if (g == null) {

		}

		else {
			moves.remove(g);
		}
		if (h == null) {

		}

		else {
			moves.remove(h);
		}

	}

}
