import data_structures.*;

public class H_Driver {
	private static PriorityQueue<Pokemon> priorityQueue;
	private static final int LIST_SIZE = 4000000;

	public static void main(String[] args) {
		priorityQueue = new BinaryHeapPriorityQueue<Pokemon>(LIST_SIZE);

		printStuff();
		System.out.println("Contain:" + priorityQueue.contains(new Pokemon(1)));
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		
		addPokemon(9);
		addPokemon(3);
		deleteTest(2);
		//emptyWithRemove();
		printStuff();
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		
		addPokemon(3);
		priorityQueue.clear();
		printStuff();
		System.out.println();
		
		System.out.println("Contain:" + priorityQueue.contains(new Pokemon(1)));
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		bigTest();
	}
	
	public static Pokemon generatePokemon() {
		return new Pokemon((int) (Math.random() * (Pokemon.LAST_POKEMON - 1) + 1));
	}
	
	public static void bigTest() {
		long startTime = System.nanoTime();
		for (int i = 0; i < LIST_SIZE; i++)
			priorityQueue.insert(generatePokemon());
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime for insert: " + totalTime / 1000000);
		
		printStuff();
		System.out.println();
		
		bigDelete(generatePokemon());
		printStuff();
	}
	
	public static void printStuff() {
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
	}

	public static void addPokemon(int n) {
		for (int i = n; i > 0; i--) {
			priorityQueue.insert(new Pokemon(i));
			for (Object curr : priorityQueue) {
				System.out.println(curr.toString());
				// System.out.println(curr);
			}
			System.out.println();
		}
	}

	public static void emptyWithRemove() {
		while (priorityQueue.size() > 0) {
			System.out.println("Remove:\t" + priorityQueue.remove());
			for (Object curr : priorityQueue) {
				System.out.println(curr.toString());
				// System.out.println(curr);
			}
			System.out.println();
		}
	}
	
	public static void deleteTest(int num) {
		System.out.println("Contain:" + priorityQueue.contains(new Pokemon(num)));
		System.out.println("Delete:\t" + priorityQueue.delete(new Pokemon(num)));
		for (Object curr : priorityQueue) {
			System.out.println(curr.toString());
			// System.out.println(curr);
		}
		System.out.println();
	}
	
	public static void bigDelete(Pokemon mon) {
		System.out.println(mon);
		long startTime = System.nanoTime();
		System.out.println("Contain:" + priorityQueue.contains(mon));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime for contains: " + totalTime / 1000000);
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println("Delete:\t" + priorityQueue.delete(mon));
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Runtime for delete: " + totalTime / 1000000);
		System.out.println();
	}
}