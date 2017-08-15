/**
 * @author Alberto Fernandez Saucedo
 */
public class Customer
{
    private int arrivalTime;
    private int transactionTime;
    private int customerNumber;

    public Customer()
    {
        this(0,0,0);
    }

    public Customer(int clock, int transactionTime, int numberOfArrivals)
    {
        this.arrivalTime = clock;
        this.transactionTime = transactionTime;
        this.customerNumber = numberOfArrivals;
    }

    public int getArrivalTime()
    {
        return this.arrivalTime;
    }

    public int getTransactionTime()
    {
        return this.transactionTime;
    }

    public int getCustomerNumber()
    {
        return this.customerNumber;
    }

}
