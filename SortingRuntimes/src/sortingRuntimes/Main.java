/**
 * 
 */
package sortingRuntimes;

import java.util.Scanner;
/**
 * @author tylerschumacher
 *
 */
public class Main
{
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
        String input;
        
        System.out.println("*****************************************************");
        System.out.println("This program tests multiple common sorting algorithms");
        System.out.println("using multiple arrays of size n (1000 - 10000) with");
        System.out.println("30 permutations each and displays the average time");
        System.out.println("complexity of the algorithm. Each sorting algorithm");
        System.out.println("may take upto 2 minutes due to the large number of");
        System.out.println("test cases.");
        System.out.println("*****************************************************");
        
        while(true){
            System.out.println("\nWhich algorithm would you like to test?\n");
            System.out.println("Bubble Sort\nInsertion Sort\nMerge Sort\nQuick Sort\n\nExit (terminate program)\n");
            
            input = sc.nextLine();
            if(input.equalsIgnoreCase("Bubble Sort")){
                BubbleSort bs = new BubbleSort(); 
                bs.invoke();
                bs = null;
            }
            else if(input.equalsIgnoreCase("Insertion Sort")){
                InsertionSort is = new InsertionSort(); 
                is.invoke();
                is = null;
            }
            else if(input.equalsIgnoreCase("Merge Sort")){
                MergeSort ms = new MergeSort(); 
                ms.invoke();
                ms = null;
            }
            else if(input.equalsIgnoreCase("Quick Sort")){
                QuickSort qs = new QuickSort(); 
                qs.invoke();
                qs = null;
            }
            else if(input.equalsIgnoreCase("Exit")){
                System.out.println("Exiting program...");
                sc.close();
                System.exit(0);
            }
        }
    }
}

