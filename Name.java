/**
 * Used by many classes.
 *
 * @author Alberto Fernandez
 */
public final class Name
{
    private String first;
    private String last;

    public Name(String first, String last)
    {
        this.first = first;
        this.last = last;
    } // end constructor

    public Name(ImmutableName aName)
    {
        first = aName.getFirst();
        last = aName.getLast();
    } // end constructor

    public ImmutableName getImmutable()
    {
        return new ImmutableName(first, last);
    } // end getImmutable

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
        return first + " " + last;
    }

    public void setName(String firstName, String lastName)
    {
        first = firstName;
        last = lastName;
    }

    public void setFirst(String firstName)
    {
        first = firstName;
    }

    public void setLast(String lastName)
    {
        last = lastName;
    }

    public void giveLastNameTo(Name aName)
    {
        aName.setLast(this.getLast());
    }

    public String toString()
    {
        return getName();
    }
}
