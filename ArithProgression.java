
package Progressions;

/** This class defines an arithmetic progression
 *  Inherits fields first and current and
 *  methods firstValue() and printProgression(n)
 *  from Progression class. 
 * 
 * @author Albert
 * 
 */
public class ArithProgression extends Progression {
    
    /** Increment. */
    protected long inc;
    
    // Inherits variables first and current
    
    /** Default constructor setting a unit increment. */
    ArithProgression(){
        this(1);
    }
    
    /** Parametric constructor providing the increment. */
    ArithProgression(long increment){
        inc = increment;
    }
    
    /** Advances the progression by adding the increment to the current value.
     * 
     * @return next value of the progression
     */
    
    @Override
    protected long nextValue(){
        current += inc;
        return current;
    }
    
    // Inherits methods firstValue() and printProgession(int).
    
}
