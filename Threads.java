/**
 * @author Bijon
 *
 */
package Cinchapi;

import java.util.ArrayList;


/**
 * Incrementer class which contains a synchronized method to increment the value of global variable
 */
class Incrementer{
	public static int counter = 0;	//Global variable to hold the value of counter
	/**
	 * Synchronized method to increment the value of counter
	 */
	public static void increment(){
		synchronized (Incrementer.class) {
			if(counter < 100){
				++counter;
			}
		}
	} 

	/**
	 * @return value of the global variable counter
	 */
	public static int getCounter(){
		return counter;
	}
}


/**
 * Writing custom threads extending the threads class. run() method is overridden 
 * to increment the value of global counter till 100 and prints the new incremented values in chronological order
 */
class MyThread extends Thread {
	private String name;
	private Incrementer inc;
	public ArrayList<Integer> numberStore = new ArrayList<>();

	/**
	 * Constructor for initializing the thread 
	 * @param name assigns a name to the thread
	 * @param incr instance of the Incrementer class
	 */
	public MyThread(String name, Incrementer incr) {
		this.name = name;
		this.inc = incr;
	}

	// Override the run() method to specify the thread's running behavior
	@Override
	public void run() {
		while(inc.counter<100){
			int old_val = inc.getCounter();	// Gets old value of counter
			inc.increment();	//Increments the value of counter by 1
			int new_val = inc.getCounter();	// Gets the new value of counter
			if(new_val > old_val){
				System.out.println(this.name+" : "+new_val);	//Prints new value chronologically
				this.numberStore.add(new_val);	//Adds number to the collection of the thread
			}
		}
	}

	/**
	 * Method to return the collection of integer for the thread
	 * @return the collection
	 */
	public ArrayList<Integer> getStore(){
		return this.numberStore;
	}
}
public class Threads {
	public static void main(String[] args) {

		Incrementer incr = new Incrementer();
		MyThread threadA = new MyThread("A", incr);
		MyThread threadB = new MyThread("B", incr);
		MyThread threadC = new MyThread("C", incr);
		
		//Threads start execution
		threadA.start();
		threadB.start();
		threadC.start();
		
		//Waits for threads to end
		try{
			threadA.join();
			threadB.join();
			threadC.join();
		}catch(Exception e){
			System.out.println("Interrupted");
		}
		
		//Getting number collection for each thread
		ArrayList<Integer> collectionA = threadA.getStore();
		ArrayList<Integer> collectionB = threadB.getStore();
		ArrayList<Integer> collectionC = threadC.getStore();
		
		//Printing number collection for each thread
		System.out.println("Thread A");
		for (Integer intgr : collectionA) {
			System.out.print(intgr +" ");

		}
		System.out.println();

		System.out.println("Thread B");
		for (Integer intgr : collectionB) {
			System.out.print(intgr +" ");

		}
		System.out.println();

		System.out.println("Thread C");
		for (Integer intgr : collectionC) {
			System.out.print(intgr +" ");

		}
	}
}