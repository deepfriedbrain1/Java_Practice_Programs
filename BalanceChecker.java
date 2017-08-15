/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class BalanceChecker {

    public static boolean checkBalance(String expression)
    {
        StackInterface<Character> openDelimiterStack = new OurStack<>();

        int characterCount = expression.length();
        boolean isBalanced = true; // Absence of delimiters is balanced
        int index = 0;
        char nextCharacter = ' ';

        while(isBalanced && (index < characterCount))
        {
            nextCharacter = expression.charAt(index);

            switch(nextCharacter)
            {
                case '(':
                case '[':
                case '{':
                    openDelimiterStack.push(nextCharacter);
                    break;

                case ')':
                case ']':
                case '}':
                    if(openDelimiterStack.isEmpty())
                    {
                        isBalanced = false;
                    }
                    else
                    {
                        char openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, nextCharacter);
                    } // end if

                    break;

                default: break; // Ignore unexpected characters
            } // end switch

            index++;
        } // end while

        if(!openDelimiterStack.isEmpty())
            isBalanced = false;

        return isBalanced;
    } // end checkBalance

    /**
     * Check if the given characters, open and close, form a pair
     * of parentheses, brackets, or braces.
     * @return true if characters are paired.
     */
    private static boolean isPaired(char open, char close)
    {
        return  (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');

    } // end isPaired
} // end BalanceChecker
