# CodingTest

Exercise A: Threads and Concurrency

Create a Java program that has three threads, respectively A, B and C. Each thread starts at exactly the same time and concurrently increments the value of some global counter (initially set to 0) by exactly 1. Each time a thread increments the value of the counter from old_value to new_value (e.g old_value + 1), it prints new_value onto the console and stores new_value in a collection.

Each thread should continue to run until the value of the global counter reaches 100 at which point, each thread should print its collection of stored values onto the console. Once complete, the output of your program should be 100 numbers (1-100) in chronological order followed by three collections, each with a distinct subset of the numbers printed.

Exercise C: Algorithms

Implement the following class for a directed acyclic graph:

public class DirectedAcyclicGraph {

     /**
      * Add an edge from {@code source} to {@code destination} and return
      * {@code true} if the edge is added as a result of this function. If
      * either {@code source} or {@code destination} does not exist, create
      * them before adding the edge.

      * @param source the name of the source node
      * @param destination the name of the destination edge
      * @return {@code true} if the edge is added as a result of this 
      * method call
      */
     public boolean addEdge(String source, String destination){

     }

}
