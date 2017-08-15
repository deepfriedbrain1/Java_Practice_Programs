
/**
 * Selection Sort
 *  - Iterative Selection Sort
 *  - Recursive Selection Sort
 *
 * Insertion Sort
 *  - Iterative Insertion Sort
 *  - Recursive Insertion Sort
 *  - Insertion Sort of Chain of Linked Nodes
 *
 * Shell Sort
 *  - The Java Code
 *
 * @author Alberto Fernandez Saucedo
 */

public class Sorting
{
    /**
     * One way to organize methods that sort an array is to create a class of static methods that perform the
     * various sorts. The methods define a generic type T for the objects in the array.
     * @param anArray an array that can contain objects of any one class
     * @param numberOfEntries the number of entries in the array
     * @param <T> data type that implements Comparable which also allows comparisons of objects of a superclass of T
     */
    public static <T extends Comparable<? super T>> void sort(T[] anArray, int numberOfEntries){}


    ////////////////// Iterative Selection Sort //////////////////////////////////
    /**
     * Sorts the first n objects in an array into ascending order.
     * Uses getIndexOfSmallest and swap methods.
     * @param anArray An array of Comparable objects.
     * @param numberOfEntries An integer > 0
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] anArray, int numberOfEntries)
    {
        for(int index = 0; index < numberOfEntries - 1; index++)
        {
            int indexOfNextSmallest = getIndexOfSmallest(anArray, index, numberOfEntries - 1);
            swap(anArray, index, indexOfNextSmallest);
            // Assertion: anArray[0] <= anArray[1] <= ... <= anArray[2] <= all other a[i]

        } //end for
    }// end selectionSort

    /**
     * Finds the index of the smallest value in portion of anArray.
     * Precondition: a.length > last >= first >= 0.
     * Returns the index of the smallest value among
     * a[first], a[first+1], ..., a[last].
     * @param anArray An array of objects.
     * @param first
     * @param last
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] anArray, int first, int last)
    {
        T min = anArray[first];
        int indexOfMin = first;

        for(int index = first + 1; index <= last; index++)
        {
            if(anArray[index].compareTo(min) < 0)
            {
                min = anArray[index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    } // end getIndexOfSmallest

    /**
     * Swap two elements in the array.
     * @param anArray An array of objects.
     * @param i Index of an element in the array
     * @param j Index of an element in the array.
     */
    private static void swap(Object[] anArray, int i, int j)
    {
        Object temp = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = temp;
    } // end swap

    /////////////// End of Iterative Selection Sort ///////////////////////////////

    /////////////// Recursive Selection Sort //////////////////////////////////////

    public static <T extends Comparable<? super T>> void selectionSort(T[] anArray, int first, int last)
    {
        if(first < last)
        {
            int indexOfNextSmallest = getIndexOfSmallest(anArray, first, last);

            T temp = anArray[first];
            anArray[first] = anArray[indexOfNextSmallest];
            anArray[indexOfNextSmallest] = temp;

            selectionSort(anArray, first + 1, last); // Invoke recursive method

        }
    } // end selectionSort

    ////////////// End of Recursive Selection Sort ////////////////////////////////

    // NOTE: The time efficiency of selection sort
    // Selection sort is O(n^2) regardless of the initial order of the entries in an array.
    // Although the sort requires O(n^2) comparisons, it performs only O(n) swaps.
    // Thus, the selection sort requires little data movement.


    ////////////// Iterative Insertion Sort ////////////////////////////////////////////////

    /*
    An insertion sort of an array partitions the array into two parts.
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] anArray, int first, int last)
    {
        first++;
        for( ; first < last; first++)
        {
           T nextToInsert = anArray[first];
           insertInOrder(nextToInsert, anArray, first, first-1);
        }
    }

    public static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] anArray, int begin, int end)
    {
        int index = end;
        while((index >= begin) && (anEntry.compareTo(anArray[index]) < 0))
        {
            anArray[index+1] = anArray[index];
            index--;
        }
        anArray[index+1] = anEntry;
    }

    ////////////// End of Iterative Insertion Sort /////////////////////////////////////////

    ////////////// Shell Sort //////////////////////////////////////////////////////////////

    public static <T extends Comparable<? super T>> void incrementalInsertSort(T[] anArray, int first, int last, int space)
    {
        for(; first < last; first+=space)
        {
            T nextToInsert = anArray[first];
            int index = first - space;
            while((index >= first) && (nextToInsert.compareTo(anArray[index]) < 0))
            {
                anArray[index + space] = anArray[index];
                index -= space;
            }
            anArray[index + space] = nextToInsert;
        }
    } // end incrementalInsertSort

    public static <T extends Comparable<? super T>> void shellSort(T[] anArray, int first, int last)
    {
        int n = anArray.length;
        int space = n/2;

        while(space > 0)
        {
            int begin = first;
            for( ; begin < first; first = first + space - 1)
            {
                incrementalInsertSort(anArray, begin, last, space);
            }
            space = space/2;
        }
    } // end shellSort

    ///////////// End of Shell Sort ///////////////////////////////////////////////////////////////

    ///////////// Merge Sort //////////////////////////////////////////////////////////////////////

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last)
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Comparable<?>[a.length];
        mergeSort(a, tempArray, first, last);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[]temp, int first, int last)
    {
        if(first < last)
        {
           int mid = (first + last) / 2;
           mergeSort(a, temp, first, mid);
           mergeSort(a, temp, mid+1, last);
           merge(a, temp, first, mid, last);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] temp, int first, int mid, int last)
    {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;
        int index = 0;

        while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2))
        {
            if((Integer)a[beginHalf1] <= (Integer) a[beginHalf2])
            {
                temp[index] = a[beginHalf1];
                beginHalf1++;
            }
            else
            {
                temp[index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }

    }

    public static void main(String[] args)
    {
        Integer[] array = {5,4,0,8,2};
        mergeSort(array, 0, 4);
        for(int element : array)
            System.out.println(element);
    }
} // end Sorting


