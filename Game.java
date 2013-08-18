import java.util.*;

import com.badlogic.gdx.ApplicationListener;

public class Game implements ApplicationListener {
	boolean players_move;
	boolean playing;
	
	
	
	/**
	 * Initialises a new game 
	 */
	public Game() {
		Board board = new Board();

	}
	
	/**
	 * Ends the game
	 */
	private void finishGame() {
		
	}
	
	/**
	 * Ends the game declaring the forfeiting player the loser
	 * 
	 * @param team
	 * 		The team that is forfeiting the match
	 * 				- False means white
	 * 				- True means black
	 */
	private void forfeit(boolean team) {
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
