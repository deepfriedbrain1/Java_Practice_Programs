
package funjavaprojects;
import java.util.*;

/**
 * ProcessPersonArray
 * @author Alberto Fernandez Saucedo
 */
class ProcessPersonArray {
    
    public static void main(String[] args){
     
        Person[] person_array; // declare the person array
        person_array = new Person[5]; // create the array
        
        String name, inpStr;
        int age;
        char gender;
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < person_array.length; i++){
            
            // read in data values
            System.out.print("Enter name: ");
            name = scanner.next();
            
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            
            System.out.print("Enter gender: ");
            inpStr = scanner.next();
            gender = inpStr.charAt(0);
            
            person_array[i] = new Person();
            
            person_array[i].setName(name);
            person_array[i].setAge(age);
            person_array[i].setGender(gender);
            
        }
        
        float sum = 0, averageAge;
        
        for(int i = 0; i < person_array.length; i++){
           sum += person_array[i].getAge(); 
        }
        
        averageAge = sum / (float) person_array.length;
        
        System.out.println();
        System.out.println("Average age: " + averageAge);
        System.out.println();
        
        Person youngest, 
               oldest;
    
        youngest = oldest = person_array[0];
        
        for(int i = 1; i < person_array.length; i++){
            
            if(person_array[i].getAge() < youngest.getAge()){
                
                youngest = person_array[i];
                
            }else if (person_array[i].getAge() > oldest.getAge()){
                
                oldest = person_array[i];
            }
        }
        
        System.out.println("Oldest: " + oldest.getName() 
                + " is " + oldest.getAge() + " years old.");
        
        System.out.println("Youngest: " + youngest.getName()
                + " is " + youngest.getAge() + " years old.");
        
        System.out.print("Name to search: ");
        String searchName = scanner.next();
        
        int i = 0;
        
        while (i < person_array.length && 
                !person_array[i].getName().equals(searchName)){
            
            i++;   
        }
        
        if (i == person_array.length){
            System.out.println(searchName + " was not in the array");
        
        }else{
            System.out.println("Found " + searchName + " at position " + i);
            
        }
        
        
        
    } 
    
   
    
}
