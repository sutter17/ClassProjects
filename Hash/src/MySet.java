import java.util.*;

public class MySet {
	private static final int INITIAL_SIZE = 7;

	private List<Integer>[] table;

	private int size;

	public MySet() {
		table = createTable(INITIAL_SIZE);

		size = 0;
	}

	List<Integer>[] createTable(int size) {
		List<Integer>[] result = new List[size];

		for(int i = 0; i < result.length; i++) {
			result[i] = new ArrayList<Integer>();
		}

		return result;
	}

	public boolean add(int value) {
		int entry = value % table.length;

		if(!table[entry].contains(value)) {
			table[entry].add(value);

			size++;

			resizeIfNecessary();

			return true;
		}

		return false;
	}

	public boolean remove(int value) {
		int entry = value % table.length;

		if(!table[entry].contains(value)) {
			return false;
		}

		table[entry].remove((Integer) value);
		size--;

		resizeIfNecessary();

		return true;
	}

	public boolean contains(int value) {
		int entry = value % table.length;

		return table[entry].contains(value);
	}

	private void resizeIfNecessary() {
		if(size > (0.75 * table.length)) {
			//System.out.println("Doubling size");

			// Save old table

			// Reinitialize the hash table (twice the size)

			// Add all elements from the old table into the new table
		}
	}
	
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MySet set = new MySet();

		System.out.println("Contains 7? " + set.contains(7));
		set.add(7);
		System.out.println("Contains 7? " + set.contains(7));
		System.out.println("Size: " + set.size());

		System.out.println("Contains 9? " + set.contains(9));
		set.add(9);
		System.out.println("Contains 9? " + set.contains(9));
		System.out.println("Size: " + set.size());

		System.out.println("Contains 14? " + set.contains(14));
		set.add(14);
		System.out.println("Contains 14? " + set.contains(14));
		System.out.println("Size: " + set.size());

		set.remove(7);
		System.out.println("Contains 7? " + set.contains(7));
		System.out.println("Contains 14? " + set.contains(14));
		System.out.println("Size: " + set.size());

		for(int i = 0; i < 1000; i++) {
			set.add(i * i);
		}
		
		System.out.println("Size: " + set.size());

		for(int i = 0; i < 1000; i++) {
			if(!set.contains(i * i)) {
				System.err.println("Ooops! Does not contain " + (i * i));
			}
		}
	}
}
