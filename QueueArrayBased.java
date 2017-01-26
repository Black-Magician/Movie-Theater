
// TODO: Auto-generated Javadoc
/**
 * The Class QueueArrayBased.
 *
 * @param <T> the generic type
 */
public class QueueArrayBased<T> 
{
    
    /** The items. */
    protected T [] items;
    
    /** The num items. */
    protected int numItems;
    
    /** The front. */
    protected int front;
    
    /** The rear. */
    protected int rear;
    
    /**
     * Instantiates a new queue array based.
     */
    @SuppressWarnings("unchecked")
	public QueueArrayBased()
    {
        items = (T[]) new Object[3];
        front = 0;
        rear = 0;
        numItems = 0;
    }
    
    /**
     * Size.
     *
     * @return the int
     */
    public int size()
    {
    	return numItems;
    }
    
    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty()
    {
        return (numItems == 0) ;
    }
    
    /**
     * Enqueue.
     *
     * @param newItem the new item
     * @throws QueueException the queue exception
     */
    public void enqueue(T newItem) throws QueueException
    {
        if(numItems == items.length)
        {
             resize();
            }
             //rear = (rear + 1) % items.length;
             //items[rear] = newItem;
    
            items[rear] = newItem;
            rear = (rear + 1)% items.length; //increment rear
            //items[rear] = newItem;
            numItems++;
    
    }
    
    /**
     * Resize.
     */
    protected void resize()
    {
        @SuppressWarnings("unchecked")
		T[] resized = (T[]) new Object[numItems*2];
        for(int i = 0; i < numItems; i++)
        {
        resized[i] = items[front];
        front = (front + 1) % items.length;
       }
       //front = 0;
      // rear = items.length;
       //OR rear = reized.length;
       front = 0;
       rear = numItems;
       items = resized;
    }
        
    
    /**
     * Dequeue.
     *
     * @return the t
     * @throws QueueException the queue exception
     */
    public T dequeue() throws QueueException
    {
        T result = null;
        if (isEmpty())
        {
            throw new QueueException("Queue is empty.");
        }
        else {
            result = items[front];
            items[front] = null;
            front = (front + 1) % items.length;
            numItems--;  
        }
        return result;
    }
    
    /**
     * Dequeue all.
     */
    @SuppressWarnings("unchecked")
	public void dequeueAll()
    {
       items = (T[]) new Object[3];
       front = 0;
       rear = 0;
       numItems = 0;
    }
    
    /**
     * Peek.
     *
     * @return the t
     * @throws QueueException the queue exception
     */
    public T peek() throws QueueException
    {
        T result = null;
        if (isEmpty())
        {
            throw new QueueException("Queue is empty.");
        }
        else {
            result = items[front];
        }
        return result;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() 
    {
        String toString = "";
        int i = front;
        while (i != rear)
        {
        	T itemN = items[i];
            String nack = itemN.toString();
            toString += nack;
            i = (i + 1) % items.length;
        }        
        return toString;
}
}
