/**
 * 
 */
package sortingRuntimes;

/**
 * @author tylerschumacher
 *
 */
public class InsertionSort extends SortingUtils
{
    public void invoke()
    {
        double total;
        long startTime;
        long endTime;
        TableBuilder tb = new TableBuilder();
        System.out.println("\nFinding average runtime for Insertion Sort in nanoseconds...\n");
        tb.addRow("n","av","av/n", "av/n^2", "av/(nlogn)");
        tb.addRow("-","--","----", "------", "----------");
        for(int n = 1000; n <= 10000; n+=100)
        {
            total = 0;
            int[] x = createArray(n);
            for(int i = 1; i <= 30; i++)
            {
                x = permutation(x);
                startTime = System.nanoTime();
                iSort(x, x.length);
                endTime = System.nanoTime();
                total = total + (endTime - startTime);
            }
            double av = total/30.0;
            double av2 = av/n;
            double av3 = av/(n*n);
            double av4 = av/(n*Math.log(n));
            tb.addRow(Double.toString(n), Double.toString(round(av,4)) + " ns.",Double.toString(round(av2,4)) + " ns.", Double.toString(round(av3,4)) + " ns.", Double.toString(round(av4,4)) + " ns.");
        }
        System.out.println(tb.toString());
        System.out.println("Average runtime for Insertion Sort is O(n^2)");
    }
    private void iSort(int x[], int n) 
    {
        if(n == 1)
        {
            return;
        }
        else
        {
            for (int j = 1; j < n; j++) 
            {
                int k = x[j];
                int i = j-1;
                while ( (i > -1) && ( x[i] > k ) ) 
                {
                    x [i+1] = x [i];
                    i--;
                }
                x[i+1] = k;
            }
        }
    }
}

