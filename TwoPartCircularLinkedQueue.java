/**
 * A class that implements a queue of objects by using a two-part circular chain of linked nodes.
 * @author Alberto Fernandez Saucedo
 */
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
{
    private Node queueNode; // References first node in queue
    private Node freeNode; // References node after back of queue
    private int numberOfEntries = 0;

    public TwoPartCircularLinkedQueue()
    {
        freeNode = new Node(null, null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    }// end default constructor

    private class Node
    {
        private T data; // Queue entry
        private Node next; // Link to next node

        public Node()
        {
            this(null, null);
        }

        public Node(T data, Node nextNode)
        {
            this.data = data;
            this.next = nextNode;
            numberOfEntries++;
        }

        public T getData()
        {
            return this.data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node getNextNode()
        {
            return this.next;
        }

        public void setNextNode(Node nextNode)
        {
            this.next = nextNode;
        }
    } // end Node

    /**
     * Adds a new entry to the back of this queue.
     * @param newEntry An object to be added.
     */
    public void enqueue(T newEntry)
    {
        freeNode.setData(newEntry);
        if(isChainFull())
        {
            // Allocate a new node and insert it after the node that freeNode references
            Node newNode = new Node(null, freeNode.getNextNode());
            freeNode.setNextNode(newNode);
        } // end if
        freeNode = freeNode.getNextNode();
    } // end enqueue

    /**
     * Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue()
    {
        T front = getFront();
        assert !isEmpty();
        queueNode.setData(null);
        queueNode = queueNode.getNextNode();
        numberOfEntries--;

        return front;
    } // end dequeue

    /**
     * Retrieves the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront()
    {
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return queueNode.getData();
        }
    } // end getFront

    /**
     * Detects whether this queue is empty.
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty()
    {
        return queueNode == freeNode;
    }

    /**
     * Removes all entries from this queue.
     */
    public void clear()
    {
        while(!isEmpty())
        {
            queueNode.setData(null);
            queueNode.setNextNode(queueNode.getNextNode());
        }
        numberOfEntries = 0;
    }

    public int getSize()
    {
        return numberOfEntries;
    }

    private boolean isChainFull()
    {
        return queueNode == freeNode.getNextNode();
    }
} // end TwoPartCircularLinkedQueue
