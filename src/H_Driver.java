import data_structures.*;

public class H_Driver {
	private static PriorityQueue<Pokemon> priorityQueue;
	private static final int LIST_SIZE = 15;

	public static void main(String[] args) {
		priorityQueue = new BinaryHeapPriorityQueue<Pokemon>(LIST_SIZE);

		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		addPokemon(9);
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println();
		addPokemon(3);
		emptyWithRemove();
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		addPokemon(3);
		priorityQueue.clear();
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
		System.out.println("Remove:\t" + priorityQueue.remove());
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
}