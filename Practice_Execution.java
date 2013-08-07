public class Practice_Execution {

	/**
	 * This is just to start the game how it would be in the arcade, do not 
	 * edit
	 */
	public static void main(String[] args) {
		Game game = new Game();
	}
	
	
	/**
	 * Tests the modified add method of FixedSizeList works as intended
	 */
	@SuppressWarnings("unused")
	private static void testFixedList() {
		FixedSizeList<Integer> test = new FixedSizeList<Integer>();
		
		int count = 0;
		for(int i=0; i<8; i++) {
			test.add(i, count);
			count++;
		}
		System.out.println(test);
		
		test.add(7, 1);
		System.out.println(test);
	}

}
