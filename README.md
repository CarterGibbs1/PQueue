# PQueue
This is a project I did for my Data Structures class. 
I implemented a priority queue using a Max Heap. 

The way to run the program is with compiling all java files with:
javac *.java 
Then to run the program, use:
java CPUScheduling <maxProcessTime> <maxPriorityLevel> <timeToIncrementPriority> <simulationTime> <processArrivalRate>
where maxProcessTime is the max amount of time for a process to finish. It is random from 1 - maxProcessTime
maxPriority level is the max priority level for a process. It is random from 1 - maxPriorityLevel. After a bit, to reduce starvation problem, the process's priority level will increase (up to the max).
time to increment priority is how many time slices it takes for a process to increase priority level
simulation time is how long the simulation runs
processArrival rate is the probability for a process to be created. This should be a boolean from 0 exclusive to 1 inclusive.

This assignment recieved a 100% (A).
