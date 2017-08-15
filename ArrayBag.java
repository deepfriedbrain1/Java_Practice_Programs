/**
 * @ Alberto Fernandez Saucedo
 */
public final class ArrayBag<T> implements BagInterface<T>
{

    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * Create an empty bag whose initial capacity is set to 25.
     */
    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given initial capacity.
     * @param capacity The integer capacity desired.
     */
    public ArrayBag(int capacity)
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0;
    } // end constructor

    /**
     * Tracks the current number of objects in the bag.
     * @return The number of objects in the bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /**
     * Checks whether the bag is empty.
     * @return True or false according to whether bag is empty.
     */
    public boolean isEmpty()
    {
        if(numberOfEntries == 0)
            return true;
        else
            return false;
    }

    /**
     * Adds a given object to the bag.
     * @param object The object to be added to the bag.
     * @return True, if object was added successfully otherwise false.
     */
    public boolean add(T object)
    {
        try
        {
            bag[numberOfEntries] = object;
            numberOfEntries++;
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }

    }

    /**
     *Removes an unspecified object from the bag, if possible.
     * @return Removed object or null if no object
     */
    public T remove()
    {
        if(numberOfEntries == 0)
        {
            return null;
        }
        else
        {
           T object = bag[numberOfEntries - 1];
           bag[numberOfEntries - 1] = null;
           numberOfEntries--;
           return object;
        }
    }

    /**
     * Removes an occurrence of a particular object from the bag,if possible.
     * @param anEntry object to be removed
     * @return True or false according to whether the removal was successful or not.
     */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        for(int i = 0; i < bag.length; i++)
        {
            if(bag[i].equals(anEntry))
            {
                bag[i] = null;
                bag[i] = bag[numberOfEntries];
                bag[numberOfEntries] = null;
                numberOfEntries--;
                result = true;
            }
        }
        return result;
    }

    /**
     * Removes the objects in the bag
     */
    public void clear()
    {
        while(numberOfEntries != 0)
        {
            bag[numberOfEntries] = null;
            numberOfEntries--;
        }
        if(numberOfEntries == 0)
        {
            bag[numberOfEntries] = null;
        }
    }

    /**
     * Counts the number of times an object occurs in the bag.
     * @param anEntry object to find in the bag
     * @return the number of times anEntry occurs in the bag.
     */
    public int getFrequencyOf(T anEntry)
    {
        int freq = 0;
        for(int i = 0; i < bag.length; i++)
        {
            if(bag[i].equals(anEntry))
            {
                freq++;
            }
        }
        return freq;
    }

    /**
     * Tests whether the bag contains a particular object.
     * @param anEntry is an object
     * @return True or false according to whether anEntry occurs in the bag.
     */
    public boolean contains(T anEntry)
    {
        int count = 0;
        count = getFrequencyOf(anEntry);
        if(count > 0)
            return true;
        else
            return false;
    }

    /**
     * Looks at all objects in the bag.
     * @return A new array of entries currently in the bag.
     */
    public T[] toArray()
    {
        T[] tempBag;
        tempBag = (T[]) new Object[numberOfEntries];

        for(int i = 0; i < bag.length; i++)
        {
            tempBag[i] = bag[i];
        }
        return tempBag;
    }
}
