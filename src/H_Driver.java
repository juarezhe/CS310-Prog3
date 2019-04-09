import data_structures.*;

public class H_Driver {
	private static PriorityQueue<Pokemon> priorityQueue;
	private static final int LIST_SIZE = 1000000;
	private static long START_TIME, END_TIME;
	private static Pokemon TEST_MON = new Pokemon(1);

	public static void main(String[] args) {
		priorityQueue = new BinaryHeapPriorityQueue<Pokemon>(LIST_SIZE);

		printData();
		System.out.println("Contain:" + priorityQueue.contains(TEST_MON));
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();

		insertSequential(9);
		insertSequential(3);
		printContents();
		emptyWithRemove();
		
		insertSequential(9);
		insertSequential(3);
		deleteTest(new Pokemon(2));
		printContents();
		System.out.println();
		
		printData();
		System.out.println("Contain:" + priorityQueue.contains(TEST_MON));
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();

		insertSequential(3);
		priorityQueue.clear();
		printData();
		System.out.println("Contain:" + priorityQueue.contains(TEST_MON));
		System.out.println("Remove:\t" + priorityQueue.remove());
		System.out.println();
		
		insertRandom(LIST_SIZE + 1);
		printData();
		deleteTest(generatePokemon());
		printData();
	}

	public static void printData() {
		System.out.println("Size:\t" + priorityQueue.size());
		System.out.println("Empty:\t" + priorityQueue.isEmpty());
		System.out.println("Full:\t" + priorityQueue.isFull());
		System.out.println("Peek:\t" + priorityQueue.peek());
	}

	public static void insertSequential(int n) {
		START_TIME = System.nanoTime();
		for (int i = n; i > 0; i--)
			priorityQueue.insert(new Pokemon(i));
		END_TIME = System.nanoTime();
		System.out.println("Insert runtime (each, in ns): " + (END_TIME - START_TIME) / n);
		System.out.println();
	}
	
	public static void insertRandom(int n) {
		START_TIME = System.nanoTime();
		for (int i = n; i > 0; i--)
			priorityQueue.insert(generatePokemon());
		END_TIME = System.nanoTime();
		System.out.println("Insert runtime (each, in ns): " + (END_TIME - START_TIME) / n);
		System.out.println();
	}
	
	public static void printContents() {
		START_TIME = System.nanoTime();
		for (Object curr : priorityQueue) {
			System.out.println(curr);
		}
		END_TIME = System.nanoTime();
		System.out.println("Iterate runtime (in ms): " + (END_TIME - START_TIME) / 1000000);
		System.out.println();
	}
	
	public static void emptyWithRemove() {
		int removeCount = 0;
		START_TIME = System.nanoTime();
		while (priorityQueue.size() > 0) {
			System.out.println("Remove:\t" + priorityQueue.remove());
			removeCount++;
		}
		END_TIME = System.nanoTime();
		System.out.println("Remove runtime (each, in ns): " + (END_TIME - START_TIME) / removeCount);
		System.out.println();
	}

	public static Pokemon generatePokemon() {
		return new Pokemon((int) (Math.random() * (Pokemon.LAST_POKEMON - 1) + 1));
	}

	public static void deleteTest(Pokemon mon) {
		START_TIME = System.nanoTime();
		System.out.println("Contain:" + priorityQueue.contains(mon));
		END_TIME = System.nanoTime();
		System.out.println("Contains runtime (in ms): " + (END_TIME - START_TIME) / 1000000);
		
		START_TIME = System.nanoTime();
		System.out.println("Delete:\t" + priorityQueue.delete(mon));
		END_TIME = System.nanoTime();
		System.out.println("Delete runtime (in ms): " + (END_TIME - START_TIME) / 1000000);
	}
}