/* 
 * Hannah Juarez
 * cssc1481
 */

/*
 * The PriorityQueue ADT may store objects in any order. However,
 * removal of objects from the PQ must follow specific criteria.
 * The object of highest priority that has been in the PQ longest
 * must be the object returned by the remove() method. FIFO return
 * order must be preserved for objects of identical priority.
 * 
 * Ranking of objects by priority is determined by the Comparable<E>
 * interface. All objects inserted into the PQ must implement this
 * interface.
 */

package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryHeapPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

	private class Wrapper<E extends Comparable<E>> implements Comparable<Wrapper<E>> {
		private long number;
		private E data;

		public Wrapper(E obj) {
			this.number = entryNumber++;
			this.data = obj;
		}

		@Override
		public int compareTo(Wrapper<E> o) {
			if (((Comparable<E>) this.data).compareTo(o.data) == 0)
				return (int) (this.number - o.number);
			return ((Comparable<E>) this.data).compareTo(o.data);
		}
	}

	private E[] storage;
	private int currentSize;
	private long modificationCounter, entryNumber;

	// Default constructor
	BinaryHeapPriorityQueue() {
		this(DEFAULT_MAX_CAPACITY);
	}

	// Custom constructor - no checks on requested max size
	@SuppressWarnings("unchecked")
	BinaryHeapPriorityQueue(int requestedMaxSize) {
		this.storage = (E[]) new Comparable[requestedMaxSize];
		this.modificationCounter = this.entryNumber = 0;
		this.currentSize = 0;
	}

	// Inserts a new object into the priority queue. Returns true if
	// the insertion is successful. If the PQ is full, the insertion
	// is aborted, and the method returns false.
	@Override
	public boolean insert(E object) {
		if (this.isFull())
			return false;
		this.storage[++this.currentSize] = (E) new Wrapper(object);
		return true;
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
		return this.currentSize;
	}

	// Returns the PQ to an empty state.
	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	// Returns true if the PQ is empty, otherwise false
	@Override
	public boolean isEmpty() {
		return this.currentSize == 0;
	}

	// Returns true if the PQ is full, otherwise false. List based
	// implementations should always return false.
	@Override
	public boolean isFull() {
		return this.currentSize == this.storage.length;
	}

	// Returns an iterator of the objects in the PQ, in no particular
	// order.
	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	// IteratorHelper class allows for tracking of changes since Iterator creation.
	// Operates in fail-fast mode.
	private class IteratorHelper implements Iterator<E> {
		private int iterIndex;
		private long stateCheck;

		public IteratorHelper() {
			this.iterIndex = 0;
			this.stateCheck = modificationCounter;
		}

		// Returns true if the list has a next item, false if not
		@Override
		public boolean hasNext() {
			if (this.stateCheck != modificationCounter)
				throw new ConcurrentModificationException();
			return this.iterIndex < currentSize;
		}

		// If the list has a next item, that item is returned
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return null;
		}

		// Unsupported operation for fail-fast iterator
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
