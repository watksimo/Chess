import java.util.ArrayList;


public class FixedSizeList<T> extends ArrayList<T> {

	private final int maxSize = 8;

	public FixedSizeList() {
		super();
	}
	
	public void add(int index, T item) {
		if(size() >= maxSize) {
			remove(index);
		}
		super.add(index, item);
	}
	
}
