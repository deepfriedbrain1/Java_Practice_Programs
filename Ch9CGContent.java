
package funjavaprojects;

/**
 * Chapter 9 Sample Program: Determine the GC-content of a given DNA sequence.
 * @author Alberto Fernandez Saucedo
 */

import java.util.*;

class Ch9CGContent {
    
    public static void main(String [] args){
        
        Scanner scanner = new Scanner(System.in);
        
        String dna;
        
        int gcCount;
        int size;
        char base;
        double result;
        
        while(true){
            System.out.print("Next DNA Sequence: ");
            dna = scanner.next();
            
            if(dna.equalsIgnoreCase("STOP")){
                break;
            }
            
            size = dna.length();
            
            gcCount = 0;
            
            for(int i = 0; i < size; i++){
                
                base = dna.charAt(i);
                
                if(base == 'G' || base == 'C'){
                    gcCount++;
                }
            }
            
            result = gcCount * 100 / size;
            
            System.out.println("GC-Content: " + result + "%");
            System.out.println("");
        }
    }
        
}
