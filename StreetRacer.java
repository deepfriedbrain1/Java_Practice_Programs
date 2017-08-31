
/**
 * @author Alberto Fernandez Saucedo
 */
public class StreetRacer extends Vehicle
{
    public StreetRacer()
    {
        setGoAlgorithm(new GoByDrivingAlgorithm());
    }
}
