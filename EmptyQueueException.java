/**
 * @author Alberto Fernandez Saucedo
 */
public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException()
    {
        this("EmptyQueueException: Queue is empty!");
    }

    public EmptyQueueException(String e)
    {
        System.out.println(e);
        System.exit(0);
    }
}
