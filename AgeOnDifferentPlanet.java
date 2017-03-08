
package NavalBook;

import java.util.Scanner;

/**
 * Program calculates the approx. age on other planets. 
 * @author Alberto Fernandez Saucedo
 */
public class AgeOnDifferentPlanet {
        
        // Approx. number of Earth days for each Planet to travel around the sun.
        final private static int MERCURY_DAYS = 88;
        final private static int VENUS_DAYS = 225;
        final private static int JUPITOR_DAYS = 4_380;
        final private static int SATURN_DAYS = 10_767; 
        final private static int EARTH_YEAR_IN_DAYS = 365;
    
        // Method calculates the days of age on other Planets
        private static int findAge(int age, int earthYearInDays, int daysOfPlanet){
            
            int y = (age * earthYearInDays) / daysOfPlanet;
            return y;
            
        }
        
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        int ageOnEarth, 
            ageOnOtherPlanet;
        
        System.out.print("Please enter your current age (e.g., 21): ");
        ageOnEarth = scan.nextInt();
        System.out.println("\n");
        
        System.out.println("\t\t Approximate Number of Earth");
        System.out.println("\t\t Days for This Planet to Travel");
        System.out.println("Planet \t\t around the Sun / Age On Planet");
        System.out.println("------------------------------------------------");
        
        System.out.print("Mercury \t\t ");
        System.out.print(MERCURY_DAYS + " / Age: ");
        ageOnOtherPlanet = findAge(ageOnEarth, EARTH_YEAR_IN_DAYS, MERCURY_DAYS);
        System.out.println(ageOnOtherPlanet);
        
        System.out.print("Venus \t\t\t ");
        System.out.print(VENUS_DAYS + " / Age: ");
        ageOnOtherPlanet = findAge(ageOnEarth, EARTH_YEAR_IN_DAYS, VENUS_DAYS);
        System.out.println(ageOnOtherPlanet);
        
        System.out.print("Jupitor \t\t ");
        System.out.print(JUPITOR_DAYS + " / Age: ");
        ageOnOtherPlanet = findAge(ageOnEarth, EARTH_YEAR_IN_DAYS, JUPITOR_DAYS);
        System.out.println(ageOnOtherPlanet);
        
        System.out.print("Saturn \t\t\t ");
        System.out.print(SATURN_DAYS + " / Age: ");
        ageOnOtherPlanet = findAge(ageOnEarth, EARTH_YEAR_IN_DAYS, SATURN_DAYS);
        System.out.println(ageOnOtherPlanet);
        
     
    }
        
    }


