
package Progressions;

/**
 * Fibonacci progression.
 *
 * @author Albert
 */
public class FibonacciProgression extends Progression {
    
    /** Previous value. */
    long prev;
    
    // Inherits variables first and current
    
    /** Default constructor setting 0 and 1 as the first two values. */
    FibonacciProgression(){
        this(0, 1);
    }
    
    /** Parametric constructor providing the first
     *  and second values.
     * 
     * @param value1 first value
     * @param value2 second value
     */
    FibonacciProgression(long value1, long value2){
        first = value1;
        prev = value2 - value1; // fictitious value preceding the first
    }
    
    /** Advances the progression by adding the previous value to
     * the current value.
     * 
     * @return next value of the progression
     */
    @Override
    protected long nextValue(){
        long temp = prev;
        prev = current;
        current += temp;
        return current;
    }
    
    // Inherits methods firstValue() and printProgression(int).
}
