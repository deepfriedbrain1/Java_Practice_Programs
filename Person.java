
package funjavaprojects;

/**
 * This class is used with ProcessPersonArray class
 * @author Alberto Fernandez Saucedo
 */
class Person {
    
    // Private Data members
    private int age;
    private String name;
    private char gender;
    private static final String DEFAULT_NAME = "Unknown";
    private static final char DEFAULT_GENDER = 'U'; // U for unidentified 
    private static final int DEFAULT_AGE = 0; 
    
    // Constructors
    public Person(){
        this(DEFAULT_NAME, DEFAULT_GENDER, DEFAULT_AGE);
    }
    
    public Person(String name){
        this(name, DEFAULT_GENDER, DEFAULT_AGE);
    }
    
    public Person(String name, char gender){
        this(name, gender, DEFAULT_AGE);
    }
    
    public Person(String name, char gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
        
    }
    
    // Accessor Methods
    public int getAge(){
        return age;
    }
    
    public char getGender(){
        return gender;
    }
    
    public String getName(){
        return name;
    }
         
    // Mutator Methods
    public void setAge(int age){
        this.age = age;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setGender(char gender){
        this.gender = gender;
    }
    
}
