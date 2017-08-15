/**
 * A class that implements a piggy bank by using a bag.
 * @ Alberto Fernandez Saucedo
 */
public class PiggyBank
{
    private BagInterface<Coin> coins;

    public PiggyBank()
    {
        coins = new Bag<>();
    } // end default constructor

    public boolean add(Coin aCoin)
    {
        return coins.add(aCoin);
    } // end add

    public Coin remove()
    {
        return coins.remove();
    } //end remove

    public boolean isEmpty()
    {
        return coins.isEmpty();
    } // end isEmpty
} // end PiggyBank
