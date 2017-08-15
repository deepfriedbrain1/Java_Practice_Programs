import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Alberto Fernandez Saucedo
 */
public final class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack; // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10_000;


    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1; // indicates an empty stack
        initialized = true;
    } // end constructor

    /**
     * Adds a new entry to the top of the stack.
     * @param newEntry is the new entry.
     */
    public void push(T newEntry)
    {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
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
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    /**
     * Retrieves the stack's top entry without changing
     * the stack in any way.
     * @return the stack's top entry. Throws an exception
     *         if the stack is emtpy.
     */
    public T peek()
    {
        checkInitialization();
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    /**
     * Detects whether the stack is empty.
     * @return True if the stack is empty.
     */
    public boolean isEmpty()
    {
        return (topIndex < 0);
    }

    /**
     * Removes all entries from the stack.
     */
    public void clear()
    {
        for(int i = 0; i < stack.length; i++)
        {
            stack[i] = null;
        }
        topIndex = -1;
    }

    private boolean checkCapacity(int initialCapacity)
    {
        if(initialCapacity <= MAX_CAPACITY)
            return true;
        else
            return false;

    } // end checkCapacity

    private boolean checkInitialization()
    {
        return initialized;
    }

    private void ensureCapacity()
    {
        if(topIndex == stack.length - 1)
        {
            int newLength = 2 * stack.length;

            if(checkCapacity(newLength))
                stack = Arrays.copyOf(stack, newLength);
        }
    } // end ensureCapacity
} // end ArrayStack