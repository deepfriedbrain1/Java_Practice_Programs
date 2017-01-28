
package simplecircle;

/**
 *
 * @author Albert
 */
public class TestSimpleCircle {
    
    public static void main(String[] args){
        
        // Create a circle with radius 1
        SimpleCircle circle_1 = new SimpleCircle();
        System.out.println("The area of the circle of radius "
            + circle_1.radius + " is " + circle_1.getArea());
        
        // Create a circle with radius 25
        SimpleCircle circle_2 = new SimpleCircle(25);
        System.out.println("The area of the circle of radius "
            + circle_2.radius + " is " + circle_2.getArea());
        
        // Modify circle radius
        circle_2.radius = 100; // or circle_2.setRadius(100)
        System.out.println("The area of the circle of radius "
            + circle_2.radius + " is " + circle_2.getArea());
    }
}
