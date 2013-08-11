import java.util.ArrayList;
import java.util.List;


public class Bishop implements Piece{

	boolean team;
	boolean firstMove;
	boolean active;
	int preference;
	int pieceNo;
	
	/**
	 * Initialises the piece
	 * 
	 * @param team
	 */
	public Bishop(boolean team, int pieceNo) {
		this.team = team;
		this.firstMove = false;
		this.active = true;
		this.preference = 2;
		this.pieceNo = pieceNo;
	}

	@Override
	public void deActivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reActivate() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String toString = "";
		
		if(!team) {
			toString+="white ";
		} else {
			toString+="black ";
		}
		
		toString+="Bishop";
		
		return toString;
	}

	@Override
	public boolean getTeam() {
		return this.team;
	}

	@Override
	public boolean getFirstMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getActiveState() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPreference() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<int[]> possibleMoves(int[] currentPos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (firstMove ? 1231 : 1237);
		result = prime * result + pieceNo;
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
		Bishop other = (Bishop) obj;
		if (active != other.active)
			return false;
		if (firstMove != other.firstMove)
			return false;
		if (pieceNo != other.pieceNo)
			return false;
		if (preference != other.preference)
			return false;
		if (team != other.team)
			return false;
		return true;
	}
	
	

}
