/**
 * Process class for the heap. Contains compareTo method along with priority level and
 * arrival time and time to finish.
 * @author carte
 *
 */
public class Process implements Comparable<Process> {

	private int priorityLevel; // priority level of the process as to compare to other processes.
	private int timeToFinish; // the time for a process to finish
	private int arrivalTime; // current arrival time
	private int timeNotProcessed; // time the process hasn't been updated.
	
	/**
	 * Constructor to initialize fields
	 * @param priorityLevel - int priority level of the process.
	 * @param timeToFinish - int time for the process to finish
	 * @param arrivalTime - arrival time to help break ties.
	 */
	public Process(int priorityLevel, int timeToFinish, int arrivalTime) {
		this.priorityLevel = priorityLevel;
		this.timeToFinish = timeToFinish;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}
	
	@Override
	public int compareTo(Process proc) {
		if (priorityLevel < proc.priorityLevel) {
			return -1;
		}
		if (priorityLevel > proc.priorityLevel) {
			return 1;
		}
		
		if (arrivalTime > proc.arrivalTime) {
			return -1;
		}
		
		if (arrivalTime < proc.arrivalTime) {
			return 1;
		}
		
		return 0;
	}

	/**
	 * reset TimeNotProcessed and decrement timeToFinish
	 */
	public void reduceTimeRemaining() {
		resetTimeNotProcessed();
		timeToFinish--;
	}
	
	/**
	 * increment Time not processed
	 */
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}
	
	// increment priority level
	public void incrementPriorityLevel() {
		priorityLevel++;
	}

	// return true if a process is finished
	public boolean finish() {
		return timeToFinish == 0;
	}

	// resets timeNotProcessed back to 0
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	
	// getter method for arrival time.
	public int getArrivalTime() {
		return arrivalTime;
	}

	// getter method for time remaining.
	public int getTimeRemaining() {
		return timeToFinish;
	}

	// getter method for priority level.
	public int getPriority() {
		return priorityLevel;
	}	
	
	// getter method for timeNotProcessed
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
}
