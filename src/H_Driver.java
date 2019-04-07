import data_structures.*;

public class H_Driver {
	private static PriorityQueue<Pokemon> priorityQueue;
	private static final int LIST_SIZE = 15;

	public static void main(String[] args) {
		priorityQueue = new BinaryHeapPriorityQueue<Pokemon>(LIST_SIZE);

		printStuff();
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		addPokemon(9);
		printStuff();
		System.out.println();
		addPokemon(3);
		deleteTest(2);
		//emptyWithRemove();
		printStuff();
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		addPokemon(3);
		priorityQueue.clear();
		printStuff();
		System.out.println("Remove:\t" + priorityQueue.remove());
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
		System.out.println("Delete:\t" + priorityQueue.delete(new Pokemon(num)));
		for (Object curr : priorityQueue) {
			System.out.println(curr.toString());
			// System.out.println(curr);
		}
		System.out.println();
	}
	
	public static void deleteTest(String name) {
		System.out.println("Delete:\t" + priorityQueue.delete(new Pokemon(name)));
		for (Object curr : priorityQueue) {
			System.out.println(curr.toString());
			// System.out.println(curr);
		}
		System.out.println();
	}
}