import java.util.ArrayList;

/**
 * Created by Albert on 7/13/2017.
 */
public class Bag<T> implements BagInterface {

    private int bagCount;
    private ArrayList<T> bag;

    public Bag()
    {
        bagCount = 0;
        bag = new ArrayList<T>();
    }

    @Override
    public boolean isEmpty() {
        if(bagCount == 0)
            return true;
        else
            return false;
    }

    @Override
    public int getCurrentSize()
    {
        return bagCount;
    }

    @Override
    public boolean remove(Object anEntry)
    {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public int getFrequencyOf(Object anEntry) {
        return 0;
    }

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean contains(Object anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }
}
