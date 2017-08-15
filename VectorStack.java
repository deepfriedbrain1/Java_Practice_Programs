import java.util.EmptyStackException;
import java.util.Vector;

/**
 * A class of stacks whose entries are stored in a vector.
 * @author Alberto Fernandez Saucedo
 */
public final class VectorStack<T> implements StackInterface<T>
{
    private Vector<T> stack; // Last element is the top entry in stack
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10_000;

    public VectorStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public VectorStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        stack = new Vector<>(initialCapacity); // Size doubles as needed
        initialized = true;
    } // end constructor

    private boolean checkCapacity(int initialCapacity)
    {
        if(initialCapacity <= MAX_CAPACITY)
            return true;
        else
            return false;
    }

    private boolean checkInitialization()
    {
        return initialized;
    }

    /**
     * Adds a new entry to the top of the stack.
     * @param newEntry is the new entry.
     */
    public void push(T newEntry)
    {
        if(checkInitialization())
            stack.add(newEntry);
    } // end push

    /**
     * Removes and returns the stack's top entry.
     * @return newEntry that is on top of stack.
     */
    public T pop()
    {
        checkInitialization();
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack.remove(stack.size() - 1);
    } // end pop

    /**
     * Retrieves the stack's top entry without changing
     * the stack in any way.
     * @return the stack's top entry. Throws an exception
     *         if the stack is empty.
     */
    public T peek()
    {
        checkInitialization();
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack.lastElement();
    } // end peek

    /**
     * Detects whether the stack is empty.
     * @return True if the stack is empty.
     */
    public boolean isEmpty()
    {
        return stack.isEmpty();
    } // end isEmpty

    /**
     * Removes all entries from the stack.
     */
    public void clear()
    {
        stack.clear();
    } // end clear
} // end VectorStack
