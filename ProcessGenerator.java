import java.util.Random;

/**
 * class to create Processes with random priority levels and the time for a process to finish
 * @author carter
 *
 */
public class ProcessGenerator {
	
	double probability; // probability for a new process to generate
	Random randNum; // random num generator
	
	/**
	 * constructor, assigns probability and creates a random number generator
	 * @param probability
	 */
	public ProcessGenerator(double probability) {
		this.probability = probability;
		randNum = new Random();
	}

	/**
	 * creates a new process
	 * @param currentTime - current time in simulation
	 * @param timeToFinish - max time to finish a process of the simulation
	 * @param maxLevel - max priority of the simulation
	 * @return - a new process with random priority level and processtime
	 */
	public Process getNewProcess(int currentTime, int timeToFinish, int maxLevel) {
		return new Process((randNum.nextInt(maxLevel)) + 1, (randNum.nextInt(timeToFinish)) + 1, currentTime);
	}
	
	/**
	 * @returns true/false if the randNum is <= probability
	 */
	public boolean query() {
		return (randNum.nextDouble() <= probability);
	}
	
}
