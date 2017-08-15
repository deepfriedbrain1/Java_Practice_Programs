/**
 * Abstract Data Type: Bag
 * @author Alberto Fernandez Saucedo.
 */

public interface BagInterface <T>
{
    /**
     * Tracks the current number of objects in the bag.
     * @return The number of objects in the bag.
     */
    public int getCurrentSize();

    /**
     * Checks whether the bag is empty.
     * @return True or false according to whether bag is empty.
     */
    public boolean isEmpty();

    /**
     * Adds a given object to the bag.
     * @param object The object to be added to the bag.
     * @return True, if object was added successfully otherwise false.
     */
    public boolean add(T object);

    /**
     *Removes an unspecified object from the bag, if possible.
     * @return Removed object or null if no object
     */
    public T remove();

    /**
     * Removes an occurrence of a particular object from the bag,if possible.
     * @param anEntry object to be removed
     * @return True or false according to whether the removal was successful or not.
     */
    public boolean remove(T anEntry);

    /**
     * Removes the objects in the bag
     */
    public void clear();

    /**
     * Counts the number of times an object occurs in the bag.
     * @param anEntry object to find in the bag
     * @return the number of times anEntry occurs in the bag.
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether the bag contains a particular object.
     * @param anEntry is an object
     * @return True or false according to whether anEntry occurs in the bag.
     */
    public boolean contains(T anEntry);

    /**
     * Looks at all objects in the bag.
     * @return A new array of entries currently in the bag.
     */
    public T[] toArray();
}
