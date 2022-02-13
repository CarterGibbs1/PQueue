
/**
 * Priority Queue implementation using a Max Heap
 * @author carter
 *
 */
public class PQueue {
	
	MaxHeap pq; // max heap
	
	/**
	 * default constructor
	 */
	public PQueue() {
		pq = new MaxHeap();
	}

	/**
	 * enqueue a process onto the priority queue
	 * @param p - process that is going on MaxHeap
	 */
	public void enPQueue(Process p) {
		pq.insert(p);
	}

	/**
	 * dequeue a process off the maxHeap
	 * @return the max process
	 */
	public Process dePQueue() {
		return pq.extractMax();
	}

	/**
	 * Update method to go through every process in heap and increment processtime
	 * and priority level
	 * @param timeToIncrementLevel - amount of time slices in simulation till priority level
	 * is incremented
	 * @param maxLevel - max priority level of the simulation
	 */
	public void update(int timeToIncrementLevel, int maxLevel) {
		for (int i = 0; i < pq.heapSize(); i++) {
			Process p = pq.getIndex(i);
			p.incrementTimeNotProcessed();
			if (p.getTimeNotProcessed() >= timeToIncrementLevel) {
				p.resetTimeNotProcessed();
				if (p.getPriority() < maxLevel) {
					p.incrementPriorityLevel();
					pq.maxHeapifyUp(i);
				}
			}
			
		}
	}
	
	/**
	 * @return true if the priority queue is empty
	 */
	public boolean isEmpty() {
		if (pq.isEmpty()) {
			return true;
		}
		return false;
	}	
}
