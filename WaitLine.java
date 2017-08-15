/**
 * @author Alberto Fernandez Saucedo
 */
public class WaitLine
{
    private QueueInterface<Customer> line; // a queue of customers
    private int numberOfArrivals; // number of customers
    private int numberServed; // number of customers actually served
    private int totalTimeWaited; // total time customers have waited

    public WaitLine()
    {
        line = new LinkedQueue<>();
        reset();
    }

    /**
     * Simulates a waiting line with one serving agent.
     * @param duration The number of simulated minutes.
     * @param arrivalProbability A real number between 0 and 1, and the probability that a customer arrives at a given time.
     * @param maxTransactionTime The longest transaction time for a customer.
     */
    public void simulate(int duration, double arrivalProbability, int maxTransactionTime)
    {
        int transactionTimeLeft = 0;

        for(int clock = 0; clock < duration; clock++)
        {
            if(Math.random() < arrivalProbability)
            {
                numberOfArrivals++;
                int transactionTime = (int)(Math.random() * maxTransactionTime + 1);

                Customer nextArrival = new Customer(clock, transactionTime, numberOfArrivals);

                line.enqueue(nextArrival);

                System.out.println("Customer " + numberOfArrivals + " enters line at time " + clock
                + ". Transaction time is " + transactionTime);
            } // end if
            if(transactionTimeLeft > 0)
                transactionTimeLeft--;
            else if(!line.isEmpty())
            {
                Customer nextCustomer = line.dequeue();
                transactionTimeLeft = nextCustomer.getTransactionTime() -1;
                int timeWaited = clock - nextCustomer.getArrivalTime();
                totalTimeWaited += timeWaited;
                numberServed++;

                System.out.println("Customer "+ nextCustomer.getCustomerNumber() + " begins service at time " +
                clock + ". Time waited is " + timeWaited);
            } // end if
        } // end for
    } // end simulate

    public void displayResults()
    {
        System.out.println();
        System.out.println("Number served = " + numberServed);
        System.out.println("Total time waited = " + totalTimeWaited);
        double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
        System.out.println("Average time waited = " + averageTimeWaited);
        int leftInLine = numberOfArrivals - numberServed;
        System.out.println("Number of left in line = " + leftInLine);
    } // end displayResults


    public final void reset()
    {
        line.clear();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
    } // end reset
} // end WaitLine
