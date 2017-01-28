
package simplecircle;

/**
 *
 * @author Albert
 */
public class SimpleCircle {
    
    // radius of the circle
    double radius;
    
    // static variable
    static int numOfCircles = 0;
    
    // default constructor
    SimpleCircle()
    {
        radius = 1;
        numOfCircles++;
    }
    
    // constructor with one parameter
    SimpleCircle(double newRadius)
    {
        radius = newRadius;
        numOfCircles++;
    }
    
    // Return numOfCircles
    static int getNumberOfCircles(){
        return numOfCircles;
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
