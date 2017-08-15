/**
 * Abstract Data Type: Stack
 * A collection of objects in reverse chronological order
 * and having the same data type.
 *
 * @author Alberto Fernandez Saucedo
 * @version 1.0
 *
 * Security Note: Design Guidelines
 * Use preconditions and postconditions to document assumptions.
 * Do not trust that a client will use public methods correctly.
 * Avoid ambiguous return values.
 * Prefer throwing exceptions instead of returning values to signal a problem.
 */
public interface StackInterface<T> {

    /**
     * Adds a new entry to the top of the stack.
     * @param newEntry is the new entry.
     */
    public void push(T newEntry);

    /**
     * Removes and returns the stack's top entry.
     * @return newEntry that is on top of stack.
     */
    public T pop();

    /**
     * Retrieves the stack's top entry without changing
     * the stack in any way.
     * @return the stack's top entry. Throws an exception
     *         if the stack is emtpy.
     */
    public T peek();

    /**
     * Detects whether the stack is empty.
     * @return True if the stack is empty.
     */
    public boolean isEmpty();

    /**
     * Removes all entries from the stack.
     */
    public void clear();

} // end StackInterface
