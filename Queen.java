import java.util.ArrayList;
import java.util.List;


public class Queen implements Piece {

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
		Queen other = (Queen) obj;
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
	public Queen(boolean team) {
		this.team = team;
		this.firstMove = false;
		this.active = true;
		this.preference = 5;
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
		
		toString+="Queen";
		
		return toString;
	}

	@Override
	public boolean getTeam() {
		return this.team;
	}

	@Override
	public boolean getFirstMove() {
		return this.firstMove;
	}

	@Override
	public boolean getActiveState() {
		return this.active;
	}

	@Override
	public int getPreference() {
		return this.preference;
	}

	@Override
	public List<int[]> possibleMoves(int[] currentPos) {
		List<int[]> moves = new ArrayList<int[]>();
		int x = currentPos[0];
		int y = currentPos[1];
		//add all moves
		for (int i = 1; i <= 7; i++) {
			int[] upRight = {x+i,y+i};
			int[] upLeft = {x-i,y+i};
			int[] downRight = {x+i,y-i};
			int[] downLeft = {x-i,y-i};
			int[] left = {x-i,y};
			int[] right = {x+i,y};
			int[] up = {x,y+i};
			int[] down = {x,y-i};
			moves.add(upRight);
			moves.add(upLeft);
			moves.add(downRight);
			moves.add(downLeft);
			moves.add(left);
			moves.add(right);
			moves.add(up);
			moves.add(down);
		}
		//remove impossible moves
		//iterate over all moves in moves List
		for (int j=0; j<moves.size();j++) {
			int[] coords = moves.get(j);
			//remove the move if coordinate is out of bounds
			if ((coords[0] < 0) || (coords[0] > 7)) {
				moves.remove(coords);
				j--;
			}
			if ((coords[1] < 0) || (coords[1] > 7)) {
				moves.remove(coords);
				j--;
			}
		}
		return moves;
	}

}
