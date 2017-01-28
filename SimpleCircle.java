
package simplecircle;

/**
 *
 * @author Albert
 */
public class SimpleCircle {
    
    // radius of the circle
    double radius;
    
    // default constructor
    SimpleCircle()
    {
        radius = 1;
    }
    
    // constructor with one parameter
    SimpleCircle(double newRadius)
    {
        radius = newRadius;
    }
    
    double getArea()
    {
        return radius * radius * Math.PI;
    }
    
    double getPerimeter()
    {
        return 2 * radius * Math.PI;
    }
    
    void setRadius(double newRadius)
    {
        radius = newRadius;
    }
}
