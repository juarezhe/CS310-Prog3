/* 
 * Program 3 - binary heap priority queue
 * CS-310
 * 8 April 2019
 * @author Hannah Juarez cssc1481
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

	private class Wrapper<T extends Comparable<T>> implements Comparable<Wrapper<T>> {
		private long number;
		private T data;

		public Wrapper(T obj) {
			this.number = entryNumber++;
			this.data = obj;
		}

		@Override
		public int compareTo(Wrapper<T> o) {
			if (((Comparable<T>) this.data).compareTo(o.data) == 0)
				return (int) (this.number - o.number);
			return ((Comparable<T>) this.data).compareTo(o.data);
		}

		@Override
		public String toString() {
			return this.number + " " + this.data.toString();
		}
	}

	private Wrapper<E>[] storage;
	private int currentSize;
	private long modificationCounter, entryNumber;

	// Default constructor
	public BinaryHeapPriorityQueue() {
		this(DEFAULT_MAX_CAPACITY);
	}

	// Custom constructor - no checks on requested max size
	@SuppressWarnings("unchecked")
	public BinaryHeapPriorityQueue(int requestedMaxSize) {
		this.storage = new Wrapper[requestedMaxSize];
		this.modificationCounter = this.entryNumber = 0;
		this.currentSize = 0;
	}

	private void trickleUp() {
		int newIndex = this.currentSize - 1;
		int parentIndex = (newIndex - 1) / 2;
		Wrapper<E> newValue = this.storage[newIndex];

		while (parentIndex >= 0 && newValue.compareTo(this.storage[parentIndex]) < 0) {
			this.storage[newIndex] = this.storage[parentIndex];
			newIndex = parentIndex;
			this.storage[newIndex] = newValue;
			parentIndex = (parentIndex - 1) / 2;
		}
	}

	private void trickleDown(int startingIndex) {
		int currentIndex = startingIndex;
		int smallestChildIndex = getSmallestChild(currentIndex);
		Wrapper<E> valueToSort = this.storage[currentIndex];

		while (smallestChildIndex != -1 && valueToSort.compareTo(this.storage[smallestChildIndex]) > 0) {
			this.storage[currentIndex] = this.storage[smallestChildIndex];
			currentIndex = smallestChildIndex;
			this.storage[currentIndex] = valueToSort;
			smallestChildIndex = getSmallestChild(currentIndex);
		}
	}

	// Returns the index of the smallest child or -1 if no children
	private int getSmallestChild(int parentIndex) {
		int leftChild = 2 * parentIndex + 1;
		int rightChild = leftChild + 1;

		if (rightChild < this.currentSize) { // two children
			if (this.storage[leftChild].compareTo(storage[rightChild]) < 0)
				return leftChild; // left child is smaller
			return rightChild; // right child is smaller
		}
		if (leftChild < this.currentSize) // one child
			return leftChild;
		return -1; // no children
	}

	// Inserts a new object into the priority queue. Returns true if
	// the insertion is successful. If the PQ is full, the insertion
	// is aborted, and the method returns false.
	@Override
	public boolean insert(E object) {
		if (this.isFull())
			return false;
		this.storage[this.currentSize++] = new Wrapper<E>(object);
		this.modificationCounter++;
		trickleUp();
		return true;
	}

	// Public remove - checks for emptiness before calling private remove for
	// index 0
	@Override
	public E remove() {
		if (this.isEmpty())
			return null;
		return remove(0);
	}

	// Removes the object of highest priority that has been in the
	// PQ the longest, and returns it. Returns null if the PQ is empty.
	private E remove(int index) {
		E itemToReturn = this.storage[index].data;

		this.storage[index] = this.storage[this.currentSize - 1];
		this.modificationCounter++;
		this.currentSize--;
		trickleDown(index);
		return (E) itemToReturn;
	}

	// Public delete - checks for emptiness before calling private
	// delete method starting at index 0
	@Override
	public boolean delete(E obj) {
		if (this.isEmpty())
			return false;
		return delete(obj, 0);
	}

	// Deletes all instances of the parameter obj from the PQ if found, and
	// returns true. Returns false if no match to the parameter obj is found.
	private boolean delete(E obj, int idx) {
		boolean isDeleted = false;
		int compareResults = obj.compareTo(this.storage[idx].data);

		if (compareResults == -1)
			return isDeleted;
		if (compareResults == 0) {
			isDeleted = remove(idx) != null || isDeleted ? true : false;
			isDeleted = delete(obj, idx) || isDeleted ? true : false;
		}
		if (compareResults == 1) {
			int leftChild = 2 * idx + 1;
			int rightChild = leftChild + 1;
			
			if (rightChild < this.currentSize)
				isDeleted = delete(obj, rightChild) || isDeleted ? true : false;
			if (leftChild < this.currentSize)
				isDeleted = delete(obj, leftChild) || isDeleted ? true : false;
		}
		return isDeleted;
	}

	// Returns the object of highest priority that has been in the
	// PQ the longest, but does NOT remove it.
	// Returns null if the PQ is empty.
	@Override
	public E peek() {
		if (this.isEmpty())
			return null;
		return (E) this.storage[0].data;
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
		this.entryNumber = 0;
		this.currentSize = 0;
		this.modificationCounter++;
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
			// return (E) storage[this.iterIndex++].data;
			return (E) storage[this.iterIndex++];
		}

		// Unsupported operation for fail-fast iterator
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
