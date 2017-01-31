
package Progressions;

/**
 * A class for numeric progressions and used to 
 * illustrate inheritance in Java
 * 
 * @author Alberto Fernandez Saucedo
 * @version 1.0
 */

public class Progression {
    
    /** First value of the progression. */
    protected long first;
    
    /** Current value of the progression. */
    protected long current;
    
    /** Default constructor. */
    Progression(){
        current = first = 0;
    }
    
    /** Resets the progression to the first value.
     * 
     * @return first value 
     */
    protected long firstValue(){
        current = first;
        return current;
    }
    
    /** Advances the progression to the next value
     * 
     * @return next value of the progression
     */
    protected long nextValue(){
        return ++current; // defalut next value
    }
    
    /** Prints the first n values of the progression.
     * 
     * @param n number of values to print
     */
    public void printProgression(int n){
       
        System.out.print(firstValue());
        
        for(int i = 1; i < n; i++)
            System.out.print(" " + nextValue());
        
        System.out.println();
       
    }
}
