import java.util.EmptyStackException;

/**
 * Class of stacks whose entries are stored in a chain of nodes.
 * @author Alberto Fernandez Saucedo
 */
public final class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode;
    private int numberOfNodes = 0;

    public LinkedStack()
    {
        topNode = null;
    } // end default constructor

    /**
     * Adds a new entry to the top of the stack.
     * @param newEntry is the new entry.
     */
    public void push(T newEntry)
    {
        Node node = new Node(newEntry, topNode);
        topNode = node;
        numberOfNodes++;
    }

    /**
     * Removes and returns the stack's top entry.
     * @return newEntry that is on top of stack.
     */
    public T pop()
    {
           T top = peek();
           assert topNode != null;
           topNode = topNode.getNextNode();
           return top;
    }

    /**
     * Retrieves the stack's top entry without changing
     * the stack in any way.
     * @return the stack's top entry. Throws an exception
     *         if the stack is empty.
     */
    public T peek()
    {
         if(isEmpty())
             throw new EmptyStackException();
         else
             return topNode.getData();
    }

    /**
     * Detects whether the stack is empty.
     * @return True if the stack is empty.
     */
    public boolean isEmpty()
    {
        if(numberOfNodes == 0)
            return true;
        else
            return false;
    }

    /**
     * Removes all entries from the stack.
     */
    public void clear()
    {
        topNode = null;
    }

    /**
     * Class of stacks whose entries are stored in a chain of nodes.
     */
    private class Node
    {
        private T data; // entry in stack
        private Node next; // link to next node

        private Node()
        {
           this(null, null);
        } // end default constructor

        private Node(T data, Node next)
        {
          this.data = data;
          this.next = next;
        } // end constructor

        public void setData(T data)
        {
            this.data = data;
        }

        public T getData()
        {
            return this.data;
        }

        public void setNextNode(Node next)
        {
            this.next = next;
        }

        public Node getNextNode()
        {
            return this.next;
        }

    } // end Node

    /** test unit for LinkedStack
    public static void main(String [] args)
    {
    LinkedStack linkedStack;
    linkedStack = new LinkedStack();

    linkedStack.push(1);
    linkedStack.push(2);
    linkedStack.push(3);

    System.out.println("Counter: " + linkedStack.numberOfNodes);
    System.out.println(linkedStack.pop());
    System.out.println("Counter: " + linkedStack.numberOfNodes);
    System.out.println(linkedStack.pop());
    System.out.println("Counter: " + linkedStack.numberOfNodes);
    System.out.println(linkedStack.pop());
    System.out.println("Counter: " + linkedStack.numberOfNodes);
    System.out.println(linkedStack.pop());

    linkedStack.push(5);
    linkedStack.push(6);
    linkedStack.push(7);
    System.out.println("Added 5,6,7 : Counter = " + linkedStack.numberOfNodes);
    System.out.println("Running clear...");
    linkedStack.clear();
    System.out.println("Counter = " + linkedStack.numberOfNodes);
    System.out.println("peeking... result: " + linkedStack.peek());

    } // end main test unit
     */

} // end LinkedStack

