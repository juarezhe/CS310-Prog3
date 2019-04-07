import data_structures.*;

public class Driver {
	private static BinaryHeapPriorityQueue<Pokemon> priorityQueue;

	public static void main(String[] args) {
		priorityQueue.insert(new Pokemon("bulbasaur"));
		priorityQueue.insert(new Pokemon("charmander"));
		
	}
	
	public static Pokemon generatePokemon() {
		return new Pokemon((int) (Math.random() * (Pokemon.LAST_POKEMON - 1) + 1));
	}

}
