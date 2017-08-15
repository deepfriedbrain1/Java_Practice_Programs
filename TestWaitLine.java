/**
 * Test for WaitLine class
 * @author Alberto Fernandez Saucedo
 */
public class TestWaitLine
{

    public static void main(String [] args)
    {
        WaitLine customerLine = new WaitLine();
        customerLine.simulate(20, 0.5, 5);
        customerLine.displayResults();
    }
}
