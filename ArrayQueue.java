import javax.xml.stream.events.Characters;

/**
 * A class that implements a queue of objects by using an array.
 * @author Alberto Fernandez Saucedo
 */
public final class ArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue; // Circular array of queue entries and one unused location

    private int frontIndex;
    private int backIndex;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10_000;

    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayQueue(int initialCapacity)
    {
       checkCapacity(initialCapacity);

       try {
           // The cast is safe because the new array contains null entries
           @SuppressWarnings("unchecked")
           T[] tempQueue = (T[]) new Object[initialCapacity + 1];
           queue = tempQueue;
           frontIndex = 0;
           backIndex = initialCapacity;
           initialized = true;
       }
       catch(OutOfMemoryError e)
       {
           System.out.println("OutOfMemoryError: " + e.getMessage());
       }


    } // end constructor

    /**
     * Checks that initial capacity does not exceed max capacity.
     * @param capacityToCheck initial capacity desired
     * @throws Exception if max capacity is exceeded
     */
    public void checkCapacity(int capacityToCheck)
    {
        try
        {
            if (capacityToCheck > MAX_CAPACITY)
                throw new Exception("Queue exceeds capacity!");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    } // end checkCapacity

    /**
     * Detects if queue was completely initialized, if not program exits
     * @throws Exception if not initialized completely
     */
    public void checkInitialization()
    {
        try
        {
            if (!initialized)
                throw new Exception("Object was not initialized");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Exiting program...");
            System.exit(0);
        }
    } // end checkInitialization

    /**
     * Doubles the size of the array queue if it is full.
     * Precondition: checkInitialization has been called.
     */
    private void ensureCapacity()
    {
        if(frontIndex == ((backIndex + 2) % queue.length)) // if array is full, double size of array
        {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = oldSize * 2;
            checkCapacity(newSize);

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for(int i = 0; i < oldSize - 1; i++)
            {
                queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            } // end if
            frontIndex = 0;
            backIndex = oldSize - 2;
        } // end if
    } // end ensureCapacity

    /**
     * Adds a new entry to the back of this queue.
     * @param newEntry An object to be added.
     */
    public void enqueue(T newEntry)
    {
        checkInitialization();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
        numberOfEntries++;
    }

    /**
     * Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue()
    {
        checkInitialization();
        if(isEmpty())
            throw new EmptyQueueException();
        else
        {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            numberOfEntries--;
            return front;
        }
    }

    /**
     * Retrieves the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront()
    {
        checkInitialization();
        if(isEmpty())
            throw new EmptyQueueException();
        else
            return queue[frontIndex];
    }

    /**
     * Detects whether this queue is empty.
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    } // end isEmpty

    /**
     * Removes all entries from this queue.
     */
    public void clear()
    {
        while(!isEmpty())
        {
            dequeue();
        }
        numberOfEntries = 0;
        frontIndex = 0;
        backIndex = queue.length - 1;
    } // end clear

    /**
     * Tracks the number of entries in this queue.
     * @return The number of entries currently in the queue.
     */
    public int getSize()
    {
        return numberOfEntries;
    }

} // end ArrayQueue

