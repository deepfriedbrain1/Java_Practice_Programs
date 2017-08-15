/**
 * Read-Only Class
 * NOTE: Design guidelines for a read-only class
 * 1. The class should be final.
 * 2. Data fields should be private.
 * 3. Data fields that are mutable objects should be final.
 * 4. The class should not have public set methods.
 *
 * @author Alberto Fernandez
 */
public final class ImmutableName
{
    private String first;
    private String last;

    public ImmutableName(String firstName, String lastName)
    {
        first = firstName;
        last = lastName;
    } // end constructor

    // Added to the class to create a companion class
    public ImmutableName(Name aName)
    {
        first = aName.getFirst();
        last = aName.getLast();
    } // end constructor

    public Name getMutable()
    {
        return new Name(first, last);
    } // end getMutable

    public String getFirst()
    {
        return first;
    }

    public String getLast()
    {
        return last;
    }

    public String getName()
    {
        return toString();
    }

    public String toString()
    {
        return first + " " + last;
    }
} // end ImmutableName
