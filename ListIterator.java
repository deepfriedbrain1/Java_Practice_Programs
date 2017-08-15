/**
 * package java.util;
 * @author Alberto Fernandez Saucedo
 */
public interface ListIterator<T> extends Iterator<T>
{
    @Override
    public boolean hasNext();

    @Override
    public T next();

    @Override
    public void remove();

    public boolean hasPrevious();

    public T previous();

    public int nextIndex();

    public int previousIndex();

    public void add(T newEntry);

    public void set(T newEntry);

} // end ListIterator
