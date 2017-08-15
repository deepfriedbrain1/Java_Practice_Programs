import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Alberto Fernandez Saucedo
 */
public class SeparateIterator<T> implements Iterator<T>
{
    private ListInterface<T> list;
    private int nextPosition; // Position of entry last returned by next()
    private boolean wasNextCalled; // Needed by remove

    public SeparateIterator(ListInterface<T> myList)
    {
        list = myList;
        nextPosition = 0;
        wasNextCalled = false;
    } // end constructor

    @Override
    public boolean hasNext()
    {
        return nextPosition < list.getLength();
    } // end hasNext

    @Override
    public T next()
    {
        if(hasNext())
        {
            wasNextCalled = true;
            nextPosition++;
            return list.getEntry(nextPosition);
        }
        else
        {
            throw new NoSuchElementException("Illegal call to next(); iterator is after the end of list.");
        }
    } // end next

    @Override
    public void remove()
    {
        if(wasNextCalled)
        {
            list.remove(nextPosition);
            nextPosition--;

            wasNextCalled = false;
        }
        else
        {
            throw new IllegalStateException("Illegal call to remove(); next() was not called.");
        }
    } // end remove
} // end SeparateIterator
