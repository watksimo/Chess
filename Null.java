import java.util.ArrayList;
import java.util.List;

//test c9 commit to github
public class Null implements Piece {

	@Override
	public void moveTo(int[] newPosition, int [] currentPos){
		
		
	}

	@Override
	public void deActivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reActivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getTeam() {
		// TODO Auto-generated method stub
		return false;
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
	
	public String toString() {
		return "Empty Square";
	}

	@Override
	public List<int[]> possibleMoves(int[] currentPos) {
		// TODO Auto-generated method stub
		return null;
	}


}
