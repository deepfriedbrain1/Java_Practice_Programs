package Progressions;

/**This class demonstrates a geometric progression
 * The next value is determined by multiplying the
 * previous value by a fixed base called base. 
 *
 * @author Albert
 */
public class GeomProgression extends Progression {
    
    /** Base. */
    protected long base;
    
    // Inherits variables first and current
    
    /* Default constructor setting base 2. */
    GeomProgression(){
        this(2);
    }
    
    /** Parametric constructor providing the base.
     * 
     * @param b base of the progression.
     */
    GeomProgression(long b){
        base = b;
        first = 1;
        current = first;
    }
    
    /** Advances the progression by multiplying the
     *  base with the current value. 
     * 
     * @return next value of the progression
     */
    @Override
    protected long nextValue(){
        current *= base;
        return current;
    }
    
    // Inherits methods firstValue() and printProgression(int).
}
