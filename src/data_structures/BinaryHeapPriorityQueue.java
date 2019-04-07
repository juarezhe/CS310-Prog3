package data_structures;

import java.util.Iterator;

public class BinaryHeapPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

	// Inserts a new object into the priority queue. Returns true if
	// the insertion is successful. If the PQ is full, the insertion
	// is aborted, and the method returns false.
	@Override
	public boolean insert(E object) {
		// TODO Auto-generated method stub
		return false;
	}

	// Removes the object of highest priority that has been in the
	// PQ the longest, and returns it. Returns null if the PQ is empty.
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	// Deletes all instances of the parameter obj from the PQ if found, and
	// returns true. Returns false if no match to the parameter obj is found.
	@Override
	public boolean delete(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	// Returns the object of highest priority that has been in the
	// PQ the longest, but does NOT remove it.
	// Returns null if the PQ is empty.
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	// Returns true if the priority queue contains the specified element
	// false otherwise.
	@Override
	public boolean contains(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	// Returns the number of objects currently in the PQ.
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Returns the PQ to an empty state.
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	// Returns true if the PQ is empty, otherwise false
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	// Returns true if the PQ is full, otherwise false. List based
	// implementations should always return false.
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	// Returns an iterator of the objects in the PQ, in no particular
	// order.
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
