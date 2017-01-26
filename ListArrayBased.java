
// TODO: Auto-generated Javadoc
/**
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Incomplete
 * Last update: 09/09/14
 * Submitted:  09/15/14
 * Comment:.
 *
 * @param <T> the generic type
 * @author: Yusef(Joe) Cardona
 * @version: 2014.09.09
 */

// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ListArrayBased<T> {

	/** The max list. */
	private static int MAX_LIST = 3;// fixes programing style error
	
	/** The items. */
	protected T[] items; // an array of list items
	
	/** The num items. */
	protected int numItems; // number of items in list

	/**
	 * Instantiates a new list array based.
	 */
	public ListArrayBased() {
		items = (T[]) new Object[MAX_LIST];
		numItems = 0;
	} // end default constructor

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return (numItems == 0);
	} // end isEmpty

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return numItems;
	} // end size

	/**
	 * Removes the all.
	 */
	public void removeAll() {
		// Creates a new array; marks old array for
		// garbage collection.
		items = (T[]) new Object[MAX_LIST];
		numItems = 0;
	} // end removeAll
		// ======================================================

	/**
		 * Adds the.
		 *
		 * @param index the index
		 * @param item the item
		 * @throws ListIndexOutOfBoundsException the list index out of bounds exception
		 */
		public void add(int index, T item) throws ListIndexOutOfBoundsException {
		if (this.numItems >= items.length)// fixes the implementation error
											// REDONE
		{

			throw new ListException("ListException on add");
		} // end if
		if (index >= 0 && index <= numItems) {
			// make room for new element by shifting all items at
			// positions >= index toward the end of the
			// list (no shift if index == numItems+1)
			for (int pos = numItems - 1; pos >= index; pos--)
			// textbook code modified to eliminate logic error causing
			// ArrayIndexOutOfBoundsException
			{
				items[pos + 1] = items[pos];
			} // end for
				// insert new item
			items[index] = (T) item;
			numItems++;
		} else {
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on add");
		} // end if
	} // end add
		// ======================================================

	/**
		 * Gets the.
		 *
		 * @param index the index
		 * @return the t
		 * @throws ListIndexOutOfBoundsException the list index out of bounds exception
		 */
		public T get(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < numItems) {
			return items[index];
		} else {
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on get");
		} // end if
	} // end get
		// ======================================================

	/**
		 * Removes the.
		 *
		 * @param index the index
		 * @throws ListIndexOutOfBoundsException the list index out of bounds exception
		 */
		public T remove(int index) throws ListIndexOutOfBoundsException
		{
			T removedItem = null;
		if (index >= 0 && index < numItems) {
			// delete item by shifting all items at
			// positions > index toward the beginning of the list
			// (no shift if index == size)
			for (int pos = index + 1; pos < numItems; pos++)
			// textbook code modified to eliminate logic error causing
			// ArrayIndexOutOfBoundsException
			{
				items[pos - 1] = items[pos];

			} // end for
			removedItem = items[numItems - 1];
			items[numItems - 1] = null;// fixes memoryleak error redone again
			numItems--;

		} else {
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on remove index is" + index);
		} // end if
		return removedItem;
	} // end remove
		// ======================================================
		// ======================================================
}
