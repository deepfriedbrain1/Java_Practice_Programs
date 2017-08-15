
/**
 * @author Alberto Fernandez Saucedo
 */
public final class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>
{
    private Node head;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private static final int MAX_CAPACITY = 2_000_000_000;

    private class Node
    {
        T data;
        String priority;
        Node next;

        public Node()
        {
            this(null);
        }

        public Node(T dataPortion)
        {
            this.data = dataPortion;

        }

        public void linkNode()
        {
            if(head == null)
            {
                this.next = null;
                head = this;
            }

            else
            {
                this.next = head;
                head = this;
            }
        }

    }


    /**
     * Adds a new entry to this priority queue.
     * @param newEntry An object to be added.
     */
    public void add(T newEntry)
    {
        if (size <= MAX_CAPACITY)
        {
            Node node = new Node(newEntry);
            node.linkNode();
            size++;
        }
        else
        {
            System.out.println("Size exceeds capacity " + MAX_CAPACITY);
        }

    }

    /**
     * Removes and returns the entry having the highest priority.
     * @return Either the object having the highest priority or, if
     *         the priority queue is empty before the operation, null.
     */
    public T remove()
    {
        T entry = head.data;
        head = head.next;
        size--;

        return entry;
    }

    /**
     * Retrieves the entry having the highest priority.
     * @return Either the object having the highest priority or, if the
     *         priority queue is empty, null.
     */
    public T peek()
    {
        return head.data;
    }

    /**
     * Detects whether this priority queue is empty.
     * @return True if the priority queue is empty, or false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Gets the size of this priority queue.
     * @return The number of entries currently in the priority queue.
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Removes all entries from this priority queue.
     */
    public void clear()
    {
        head = null;
        size = 0;
    }
} // end PriorityQueue
