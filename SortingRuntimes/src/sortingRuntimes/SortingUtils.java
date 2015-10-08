/**
 * 
 */
package sortingRuntimes;

import java.util.Random;
/**
 * @author tylerschumacher
 *
 */
public abstract class SortingUtils
{
    public static int[] createArray(int size)
    {
        int[] x = new int[size];
        int limit = size;
        for(int i = 0; i < limit; i++)
        {
            x[i] = size;
            size = size-1;
        }
 
        return x;
    }
    public static int[] permutation(int[] n)
    {
        if(n.length == 1)
        {
            return n;
        }
        else
        {
            Random generator = new Random();
            int j;
            int temp;
            for(int k =  n.length -1; k >= 2; k--)
            {
                j = generator.nextInt(k);
                temp = n[j];
                n[j] = n[k];
                n[k] = temp;
            }
            return n;
        }
    }
    public static double round(double value, int dPlaces)
    {
        double x = Math.pow(10, dPlaces);
        double y = value * x;
        return Math.round(y)/x;
    }
}
