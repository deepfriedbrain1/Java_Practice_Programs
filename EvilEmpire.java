import java.net.*;
/**
 * @author Alberto Fernandez
 */
public class EvilEmpire
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Socket s = new Socket("207.46.131.13", 80);
            System.out.println("Connect!");
        }
        catch(SecurityException se)
        {
            System.out.println("SecurityException: could not connect.");
        }
    }
}
