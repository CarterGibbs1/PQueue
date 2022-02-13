import java.util.Arrays;

/**
 * Max heap implementation using an array
 * @author carter
 *
 */
public class MaxHeap {
	
	private Process[] maxHeapArray; // MaxHeap
	
	private int count; // # of processes in heap
	private int sizeOfArray; // max size of array, to be expanded if count == sizeOfArray
	
	private final int DEFAULT_SIZE = 10;
	
	/**
	 * Default constructor
	 */
	public MaxHeap() {
		maxHeapArray = new Process[DEFAULT_SIZE];
		sizeOfArray = DEFAULT_SIZE;
		count = 0;
	}
	
	/**
	 * 
	 * @param maxSize - size of the heap
	 */
	public MaxHeap(int size) {
		maxHeapArray = new Process[size];
		sizeOfArray = size;
		count = 0;
	}
	
	/**
	 * method to restructure a maxHeap. Moves the root up the Heap.
	 * @param root - index of child/root.
	 */
	public void maxHeapifyUp(int root) {
		if (root > 0 && maxHeapArray[parent(root)].compareTo(maxHeapArray[root]) < 0) {
			
				Process temp = maxHeapArray[parent(root)];
				maxHeapArray[parent(root)] = maxHeapArray[root];
				maxHeapArray[root] = temp;
				maxHeapifyUp(parent(root));
			
		}
	}
	
	/**
	 * method to restructure a maxHeap. Moves the root down the Heap.
	 * @param root - index of parent/root.
	 */
	public void maxHeapifyDown(int root) {
		int largest = root; // index of largest
		int l = left(root); // left child
		int r = right(root); // right child
		if (l < heapSize() && maxHeapArray[l].compareTo(maxHeapArray[root]) > 0) {
			largest = l;
		}
		if (r < heapSize() && maxHeapArray[r].compareTo(maxHeapArray[largest]) > 0) {
			largest = r;
		}
		if (largest != root) {
			Process temp = maxHeapArray[root];
			maxHeapArray[root] = maxHeapArray[largest];
			maxHeapArray[largest] = temp;
			maxHeapifyDown(largest);
		}
	}
	
	/**
	 * inserts a process into the MaxHeap
	 */
	public void insert(Process element) {
		if (count >= sizeOfArray) { // if array is filled
			expand();
		}
		maxHeapArray[heapSize()] = element;
		maxHeapifyUp(heapSize());
		count++;
	}
	
	/**
	 * expands the heap array
	 */
	private void expand() {
		maxHeapArray = Arrays.copyOf(maxHeapArray, sizeOfArray *= 2);
	}

	/**
	 * method to extract the max process in the MaxHeap
	 * @return - max Process in the MaxHeap
	 */
	public Process extractMax() {
		if (!isEmpty()) {
			Process retVal = maxHeapArray[0];
			maxHeapArray[0] = maxHeapArray[heapSize() - 1];
			if (heapSize() != 1) {
				maxHeapifyDown(0);
			}
			count--;
			return retVal;
		}
		return null;
	}
	
	/**
	 * method to return the index of the parent of a given leaf/index
	 * @param index of leaf/child in MaxHeap
	 * @return index of parent of child in MaxHeap
	 */
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	/**
	 * method to return the index of the left child of a given parent/index
	 * @param index of parent/root in MaxHeap
	 * @return index of left child of parent in MaxHeap
	 */
	private int left(int index) {
		return (2 * index + 1);
	}
	
	/**
	 * method to return the index of the right child of a given parent/index
	 * @param index of parent/root in MaxHeap
	 * @return index of right child of parent in MaxHeap
	 */
	private int right(int index) {
		return (2 * index + 2);
	}
	
	/**
	 * 
	 * @param index of the maxHeap to access 
	 * @return Process at specified index
	 */
	public Process getIndex(int index) {
		if (index >= 0 && index < heapSize()) {
			return maxHeapArray[index];
		}
		return null;
	}
	
	/**
	 * @returns count
	 */
	public int heapSize() {
		return count;
	}
	
	/**
	 * @return if the MaxHeap array is empty
	 */
	public boolean isEmpty() {
		return (heapSize() == 0);
	}
}
