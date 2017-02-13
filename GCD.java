package gcd;

/**
 * 
 * @author Alberto Fernandez Saucedo
 * Note: Algorithms have not been fully tested. 
 */
public class GCD {
     
    public static int steps; // counts the number of steps
    
    public static void main(String[] args){
        
        System.out.println(simpleGCD(585,442));
        System.out.println("Steps: " + steps);
        steps = 0;
        
        System.out.println(standardGCD(585,442));
        System.out.println("Steps: " + steps);
        steps = 0;
        
} 
 
// Simple version of Euclid's Algorithm
public static int simpleGCD(int n, int m){
    steps++;
      
      if (n - m == 0){
          return n;
      }
      else if(n > m){
          return simpleGCD(n - m, m);
      }
      else {
          return simpleGCD(n, m - n);
      }
          
      
    }

// Standard version of Euclid's Algorithm
// Note: if (n < m) steps will increase
public static int standardGCD(int n, int m){
    steps++;
    
    if (n % m == 0){
        return m;
    }
    else if (n > m){
        return standardGCD(n % m, m);
    }
    else{
        return standardGCD(m , n);
    }
   
  
    
}

}