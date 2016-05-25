/**
 * @author Bijon
 *
 */


package Cinchapi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Creates a Directed acyclic graph
 *
 */
public class DirectedAcyclicGraph {
	
	public static HashMap<String, LinkedList<String>> adjList; // Store the graph structure - Nodes and list of neighbours

	
	/**
	 * Adds a vertex to the graph if it does not already exist
	 * @param v
	 */
	public void addVertex(String v){
		if(!adjList.containsKey(v))
			adjList.put(v, new LinkedList<String>());
	}

	/**
	 * Initializes the adjacency list of the graph
	 */
	public DirectedAcyclicGraph(){
		adjList = new HashMap<String, LinkedList<String>>();
	}
	
	
	/**
	 * Checks if a path exists from source to destinations
	 * @param source
	 * @param destination
	 * @return true if there is a path from source to destination
	 */
	public boolean hasPath(String source, String destination){
		// Check if source and destination are same
		if(source.equals(destination)){
			return true;
		}
		LinkedList<String> neighbourList = adjList.get(source);
		for (String ngbr : neighbourList) {
			if (hasPath(ngbr, destination))
				return true;
		}
		return false;
	}
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
    	//if source is not already present, add it to the graph 
    	if(!adjList.containsKey(source))
    		addVertex(source);
    	//if destination is not already present, add it to the graph
    	if(!adjList.containsKey(destination))
    		addVertex(destination);
    	
    	LinkedList<String> neighbourList = adjList.get(source);
    	//Check if edge is already present
    	if(neighbourList.contains(destination)){
    		System.out.println("Edge already present in the graph!");
    		return false;
    	}
    	else{
    		//check if adding the edge would result in a cycle or self loop
    		if(hasPath(destination, source)){
    			System.out.println("Adding the edge would result in a cycle in the graph!");
    			return false;
    		}
    		neighbourList.add(destination);
    		adjList.put(source, neighbourList);
    		//prints the graph
    		printGraph();
    		return true;
    	}
    }
    
    /**
     * prints the graph edges
     */
    public void printGraph(){
    	for (String parent : adjList.keySet()) {
    		LinkedList<String> cList = adjList.get(parent);
    		if(!cList.isEmpty()){
    			for (String child : cList) {
    				System.out.print(parent +" -> "+child +" ");
    			}
    		}
		}
    	System.out.println();
    }
    
	public static void main(String[] args) {
		DirectedAcyclicGraph dag = new DirectedAcyclicGraph();
		dag.addVertex("1");
		dag.addVertex("2");
		dag.addVertex("3");
		dag.addVertex("4");
		dag.addVertex("5");
		
		dag.addEdge("1", "2");
		dag.addEdge("1", "3");
		dag.addEdge("1", "4");
		dag.addEdge("1", "5");
		dag.addEdge("2", "4");
		dag.addEdge("4", "4");
		dag.addEdge("4", "5");
		dag.addEdge("3", "5");
		dag.addEdge("5", "1");
		dag.addEdge("3", "1");

	}
}
