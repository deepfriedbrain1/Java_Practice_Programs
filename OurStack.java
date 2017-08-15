
/**
 * @author Alberto Fernandez Saucedo
 */

public final class OurStack<T> implements StackInterface<T> {


    /**
     * Adds a new entry to the top of the stack.
     * @param newEntry is the new entry.
     */
    public void push(T newEntry)
    {

    }

    /**
     * Removes and returns the stack's top entry.
     * @return newEntry that is on top of stack.
     */
    public T pop()
    {
        return null;
    }

    /**
     * Retrieves the stack's top entry without changing
     * the stack in any way.
     * @return the stack's top entry. Throws an exception
     *         if the stack is empty.
     */
    public T peek()
    {
        return null;
    }

    /**
     * Detects whether the stack is empty.
     * @return True if the stack is empty.
     */
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Removes all entries from the stack.
     */
    public void clear()
    {

    }

    public OurStack<Character> convertToPostfix(OurStack<Character> infix)
    {
        OurStack<Character> operatorStack = new OurStack<>();
        OurStack<Character> postfix = new OurStack<>();

        while(!infix.isEmpty())
        {
            char nextCharacter = infix.peek();
            switch(nextCharacter)
            {
                case ('a' | 'z'): // needs modification for variables
                case '^':
                    operatorStack.push(nextCharacter);
                case '+' : case '-': case '*': case '/':
                    while(!operatorStack.isEmpty() && (nextCharacter != '^') )
                    {
                        postfix.push(operatorStack.peek());
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    char topOperator = operatorStack.pop();
                    while(topOperator != '(')
                    {
                        postfix.push(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default: break;
            }
        }
        while(!operatorStack.isEmpty())
        {
            char topOperator = operatorStack.pop();
            postfix.push(topOperator);
        }

        return postfix;
    }
}
