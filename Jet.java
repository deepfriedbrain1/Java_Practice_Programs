/**
 * @author Alberto Fernandez Saucedo
 */
public class Jet extends Vehicle
{
    public Jet()
    {
        setGoAlgorithm(new GoByFlyingFast());
    }
}
