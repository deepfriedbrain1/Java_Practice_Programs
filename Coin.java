/**
 * A class representation of a coin.
 * @ Alberto Fernandez Saucedo
 */
public class Coin {

    private String denom;
    private int value;

    public Coin(String denom, int value)
    {
        this.denom = denom;
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public String getDenom()
    {
        return this.denom;
    }
}
