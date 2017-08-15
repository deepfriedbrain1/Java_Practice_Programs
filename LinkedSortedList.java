/**
 * @author Alberto Saucedo
 */
public class LinkedSortedList <T extends Comparable<? super T>> implements SortedListInterface<T>
{

    private Node head;
    private int numberOfEntries;

    public LinkedSortedList()
    {
        head = null;
        numberOfEntries = 0;
    }


    @Override
    public void add(T newEntry) {

    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        return 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T remove(int givenPosition) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return new T[0];
    }

    private class Node
    {
        private T data;
        private Node next;

        public Node(T dataPortion)
        {
            data = dataPortion;
        }

        public T getData()
        {
            return this.data;
        }

        public Node getNextNode()
        {
            return this.next;
        }

        public void setNextNode()
        {
            
        }


    }
}
