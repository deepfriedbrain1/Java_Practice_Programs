/**
 * @ Albert
 */
public class TestArrayStack
{
    public static <T> void print(T[] array)
    {
        for(T element : array)
        {
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T arrayMinimum(T[] anArray)
    {

        return null;
    }

    public static <T extends Comparable<? super T>> void arrayMinimum(T[] a, int n)
    {

    }

    public static void main(String [] args)
    {
        ArrayStack stack = new ArrayStack(100);
        System.out.println(stack.isEmpty());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        String[] stringArray = {"apple", "banana", "orange"};
        Character[] charArray = {'e','r','t'};
        Integer[] intArray = {9,8,7,6,5,4,3,2};
        print(stringArray);
        print(charArray);
        print(intArray);
    }
}
