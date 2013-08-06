import java.util.ArrayList;
import java.util.List;


public class Rook implements Piece {
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
		Rook other = (Rook) obj;
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
	
	/**
	 * Initialises the piece
	 * 
	 * @param team
	 */
	public Rook(boolean team) {
		this.team = team;
		this.firstMove = false;
		this.active = true;
		this.preference = 3;
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
		
		if(!team) {
			toString+="white ";
		} else {
			toString+="black ";
		}
		
		toString+="Rook";
		
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
		
			int [] castle = {x, y+2};
			
			moves.add(castle);
			
		
		
		if (!firstMove){
				moves.remove(castle);
		}
		return moves;
	}
	public void removeMoves(int[] a, int[] b, int[] c, int[] d) {
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
	}
}


