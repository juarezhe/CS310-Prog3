import data_structures.*;

public class Driver {
	private static PriorityQueue<Pokemon> priorityQueue;
	private static final int LIST_SIZE = 15;

	public static void main(String[] args) {
		priorityQueue = new BinaryHeapPriorityQueue<Pokemon>(LIST_SIZE);
		
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println();
		addPokemon(9);
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println();
		addPokemon(3);
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println();
		priorityQueue.clear();
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println();
		addPokemon(3);
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println();
	}
	
	public static void addPokemon(int n) {
		for (int i = n; i > 0; i--) {
			priorityQueue.insert(new Pokemon(i));
			for (Object curr : priorityQueue)
				System.out.println(curr.toString());
			System.out.println();
		}
	}

}
