import java.util.Scanner;
/**
 * @author Alberto Fernandez
 */
public class MaryHadALittleLambGame
{

    private static String noun, anotherNoun, adjective, pastTenseVerb;

    public static void main(String[] args)
    {
        startGame();
        exitGame();

    }

    private static void startGame()
    {
        System.out.println("\n\t Welcome to the Mary Had A Little Lamb Game!");
        Scanner input = new Scanner(System.in);

        System.out.print("\t\tPlease enter a noun: ");
        String word;
        word = input.next();
        setNoun(word);
        System.out.println();

        System.out.print("\t\tPlease enter another noun: ");
        word = input.next();
        setAnotherNoun(word);
        System.out.println();

        System.out.print("\t\tPlease enter an adjective: ");
        word = input.next();
        setAdjective(word);
        System.out.println();

        System.out.print("\t\tPlease enter a past tense verb: ");
        word = input.next();
        setPastTenseVerb(word);
        System.out.println();

        System.out.println("\t\t\tLet the song begin... ");
        System.out.println("\t\t\tMary had a little " + getNoun());
        System.out.println("\t\t\tIts " + getAnotherNoun() + " was " + getAdjective() + " as snow");
        System.out.println("\t\t\tAnd everywhere that Mary " + getPastTenseVerb());
        System.out.println("\t\t\tThe " + getNoun() + " was sure to go");
        System.out.println();
        System.out.println("\t\t\tThanking for playing!");
        exitGame();



    }

    private static void setNoun(String w){ noun = w; }
    private static String getNoun(){ return noun; }
    private static void setAnotherNoun(String w){ anotherNoun = w;}
    private static String getAnotherNoun(){ return anotherNoun; }
    private static void setAdjective(String w){ adjective = w;}
    private static String getAdjective(){ return adjective; }
    private static void setPastTenseVerb(String w){ pastTenseVerb = w;}
    private static String getPastTenseVerb(){ return pastTenseVerb; }

    private static void exitGame()
    {
        System.out.print("\n\tWould you like to exit the game (yes or no)?");
        Scanner scan = new Scanner(System.in);
        String str;
        str = scan.next();
        if(str.equalsIgnoreCase("yes"))
        {
            System.exit(0);
        }
        else if(str.equalsIgnoreCase("no"))
        {
            startGame();
        }
        else
        {
            System.out.println("Invalid, please enter yes or no. ");
            exitGame();
        }
    }

}
