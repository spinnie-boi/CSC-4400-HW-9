/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Random;
public class Main
{
	public static void main(String[] args) 
	{
	    int length = 1000000;
	    int min = 0;
	    int max = 500;
		int[] ar = RandomizedArray(length, min, max);
		long start = System.currentTimeMillis();
		mergeSort(ar, 0, (length - 1));
		long end = System.currentTimeMillis();
		long timeElapsed = end - start;
		System.out.println("Merge sort took " + timeElapsed + " milliseconds.");
	}
	
	public static int[] RandomizedArray(int size, int start, int end)
	{
	    int[] theArray = new int[size];
	    Random r = new Random();
	    for(int i = 0; i < theArray.length; i++)
	    {
	        theArray[i] = Math.abs(r.nextInt() % end);
	        if(theArray[i] < start)
	        {
	            i--;
	        }
	    }
	    return theArray;
	}
    
    public static void mergeSort(int[] numbers, int i, int k) 
    {
        int j = 0;
      
        if (i < k) 
        {
            j = (i + k) / 2;
            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);
            
            merge(numbers, i, j, k);
        }
    }
    
    public static void merge(int[] numbers, int i, int j, int k) 
    {
        int mergedSize = k - i + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = i;
        int rightPos = j + 1;
        while (leftPos <= j && rightPos <= k) 
        {
            if (numbers[leftPos] <= numbers[rightPos]) 
            {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            }
            else 
            {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }
        while (leftPos <= j) 
        {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }
        while (rightPos <= k) 
        {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }
        for (mergePos = 0; mergePos < mergedSize; mergePos++) 
        {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }
}