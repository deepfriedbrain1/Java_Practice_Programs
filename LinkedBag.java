
/**
 * @author Alberto Fernandez Saucedo
 */
public final class LinkedBag<T> implements BagInterface<T> {

    private Node head;
    private int numberOfEntries;

    public LinkedBag()
    {
        head = null;
        numberOfEntries = 0;
    }

    private class Node
    {
        private T data;
        private Node next;

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public boolean add(T anEntry)
    {
        Node newNode = new Node(anEntry);
        newNode.next = head;
        head = newNode;
        numberOfEntries++;

        if(head.data.equals(anEntry))
            return true;
        else
            return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }



}
