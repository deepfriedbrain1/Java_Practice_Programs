/**
 * @author Alberto Fernandez Saucedo
 */
public class FormulaOne extends Vehicle
{
    public FormulaOne()
    {
        setGoAlgorithm(new GoByDrivingAlgorithm());
    }
}
