import java.util.ArrayList;

/**
 * Implements an array-based min-heap.
 * 
 * @author You!!
 */
public class MyMinHeap {
	private ArrayList<Integer> nodes;

	/**
	 * Initializes a new MyHeap.
	 */
	public MyMinHeap() {
		nodes = new ArrayList<Integer>();
	}
	
	/**
	 * Returns the size of the min-heap.
	 * 
	 * @return The size of the min-heap.
	 */
	public int size() {
		return nodes.size();
	}
	
	/**
	 * Given a position i, return the position of the parent node.
	 * 
	 * @param i Position to check for the parent node.
	 * 
	 * @return Position of the parent node.
	 */
	private int parent(int i) {
		// TODO: complete
		if (i == 0) {
			return 0;
		}
		return (i-1)/2;
	}
	
	/**
	 * Given a position i, return the position of the left child.
	 * 
	 * @param i Position to check for the left child.
	 * 
	 * @return Position of the left child.
	 */
	private int leftChild(int i) {
		// TODO: complete
		return 2*i+1;
	}
	
	/**
	 * Given a position i, return the position of the right child.
	 * 
	 * @param i Position to check for the right child.
	 * 
	 * @return Position of the right child.
	 */
	private int rightChild(int i) {
		// TODO: complete
		return 2*i+2;
	}
	private int smallestChild(int i){
		int r = 2*i+2;
		int l = 2*i+1;
		if(r == size()) {
			return l;
		}
		if(r > size()) {
			return i;
		}
		if(nodes.get(r) < nodes.get(l)){
			return r;
		}else {
			return l;
		}
	}
	private int largestChild(int i){
		int r = 2*i+2;
		int l = 2*i+1;
		if(r == size()) {
			return l;
		}
		if(r > size()) {
			return i;
		}
		if(nodes.get(r) < nodes.get(l)){
			return l;
		}else {
			return r;
		}
	}
	private void correct(int i) {
		if (size() < 2) {
			return;
		}
		int value = nodes.get(i);
		if(value < nodes.get(parent(i))){
			int temp = parent(i);
			swap(i,temp);
			correct(temp);
		}else if(value > nodes.get(largestChild(i))) {
			int temp = smallestChild(i);
			swap(i,temp);
			correct(temp);
		}else {
			return;
		}
	}
	
	/**
	 * Swap elements at positions pos1 and pos2.
	 * 
	 * @param pos1 First position.
	 * @param pos2 Second position (no order implied).
	 */
	private void swap(int pos1, int pos2) {
		int temporary = nodes.get(pos1);
		nodes.set(pos1, nodes.get(pos2));
		nodes.set(pos2, temporary);
	}

	/**
	 * Add value to the min-heap.
	 * 
	 * @param value Value to be added to the min-heap.
	 */
	public void add(int value) {
		// Add to the end of the array
		nodes.add(value);
		// Set current position to the newly added element
		int n = size() - 1;
		// While you are not the root element,
		// and the parent is bigger, swap with the parent
		// then update your current position
		correct(n);
		return;
	}
	
	/**
	 * Remove the smallest value from the min-heap.
	 * 
	 * @return The former smallest value from the min-heap.
	 */
	public int removeMin() {
		// Save the first element
		int result = nodes.get(0);
		// Remove from the end
		swap(0,size()-1);
		nodes.remove(size()-1);
		// If the heap is empty now, you're done
		correct(0);
		// Otherwise, replace the removed element into the first position
		return result;
		// Set current position to the root of the heap
		
		
		// Switch spots with your smallest child as long as the
		// child's position does not go past the end of the heap
		
		
		// Return the original, saved first element
	}
	
	/**
	 * Returns a string representation of the min-heap
	 * in array format.
	 */
	public String toString() {
		return nodes.toString();
	}
	
	public static void main(String[] args) {
		MyMinHeap heap = new MyMinHeap();
		
		heap.add(7);
		heap.add(4);
		heap.add(9);
		heap.add(1);
		heap.add(33);
		heap.add(44);
		heap.add(2);
		
		while(heap.size() > 0) {
			System.out.println(heap.removeMin());
		}
		
	}
}
