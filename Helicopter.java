/**
 * @author Alberto Fernandez Saucedo
 */
public class Helicopter extends Vehicle
{
    public Helicopter()
    {
        setGoAlgorithm(new GoByFlying());
    }
}
