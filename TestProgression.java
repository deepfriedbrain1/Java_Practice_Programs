
package Progressions;

/** Test program for the progression classes.
 *
 * @author Alberto Fernandez Saucedo
 */
public class TestProgression {
   public static void main(String[] args){
       
       Progression prog;
       
       // Test ArithProgression
       System.out.println("Arithmetic progression w/ default increment: ");
       prog = new ArithProgression();
       prog.printProgression(10);
       System.out.println("Arithmetic progression w/ increment 5: ");
       prog = new ArithProgression(5);
       prog.printProgression(10);
       
       // Test GeomProgression
       System.out.println("Geometric progression w/ default base: ");
       prog = new GeomProgression();
       prog.printProgression(10);
       System.out.println("Geometric progression w/ base 3: ");
       prog = new GeomProgression(3);
       prog.printProgression(10);
       
       // Test FibonacciProgression
       System.out.println("Fibonacci progression w/ default start values: ");
       prog = new FibonacciProgression();
       prog.printProgression(10);
       System.out.println("Fibonacci progression w/ start values 4 and 6: ");
       prog = new FibonacciProgression(4, 6);
       prog.printProgression(10);
       
       
   }
}
