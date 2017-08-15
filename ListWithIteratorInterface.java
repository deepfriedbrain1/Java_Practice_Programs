import java.util.Iterator;
/**
 * @author Alberto Fernandez Saucedo
 */
public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T>
{
    public Iterator<T> getIterator();

} // end ListWithIteratorInterface
