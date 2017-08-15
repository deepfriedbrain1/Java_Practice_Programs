
/**
 * A class that implements a queue of objects by using a chain of linked nodes.
 * @author Alberto Fernandez Saucedo
 */
public class LinkedQueue<T> implements QueueInterface<T>
{

    private Node head; // References node at front of queue
    private Node tail; // References node at back of queue
    private int numberOfEntries = 0;

    private class Node
    {
        private T data;
        private Node next;
        private Node previous;
        private boolean initialized = false;

        public Node()
        {
            this.data = null;
            this.next = null;
            this.previous = null;
            initialized = true; // Security option
        }

        public T getData()
        {
            return this.data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node getFrontNode()
        {
            return this.next;
        }

        public void setFrontNode(Node nextNode)
        {
            this.next = nextNode;
        }

        public Node getBackNode(){ return this.previous; }

        public void setBackNode(Node backNode)
        {
            this.previous = backNode;
        }

        public boolean isInitialized(){ return this.initialized; }
    }

    /**
     * Adds a new entry to the back of this queue.
     * @param newEntry An object to be added.
     */
    public void enqueue(T newEntry)
    {
        Node node = new Node();
        if(isEmpty())
        {
            head = node;
        }
        else
        {
            tail.setBackNode(node);
            tail = node;
        }
        numberOfEntries++;
    }

    /**
     * Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue()
    {
        assert (head != null);

        if(head == null)
        {
           throw new EmptyQueueException();
        }
        else
        {
           T entry = head.data;
           if(head.next != null)
           {
               head = head.next;
               numberOfEntries--;
               return entry;
           }
           else
           {
               head = null;
               numberOfEntries--;
               return entry;
           }

        }
    }

    /**
     * Retrieves the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront()
    {
        if(head == null)
            throw new EmptyQueueException();
        else
            return head.data;
    }


    /**
     * Detects whether this queue is empty.
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty()
    {
        if(numberOfEntries == 0)
            return true;
        else
            return false;
    }

    /**
     * Removes all entries from this queue.
     */
    public void clear()
    {
        head = null;
        tail = null;
        numberOfEntries = 0;
    }

    /**
     * The number of entries in the queue.
     * @return The number of entries in the queue.
     */
    public int getSize()
    {
        return numberOfEntries;
    }

} // end LinkedQueue
