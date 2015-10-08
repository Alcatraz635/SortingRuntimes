package sortingRuntimes;

/**
 * @author tylerschumacher
 *
 */
public class BubbleSort extends SortingUtils
{
    protected void invoke()
    {   
        double total;
        long startTime;
        long endTime;
        TableBuilder tb = new TableBuilder();
        System.out.println("\nFinding average runtime for Bubble Sort in nanoseconds...\n");
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
                bSort(x,n);
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
        System.out.println("Average runtime for Bubble Sort is O(n^2)");
    }
    private void bSort(int[] x, int n) 
    {
        boolean swap = true;
        if(n == 1)
        {
            return;
        }
        else
        {
            for(int m = 0; m < n - 1 && swap==true; m++) 
            {
              swap = false;
              for(int i = 0; i < n - 1 - m; i++) 
              {
                if(x[i] > x[i+1]) 
                {
                  int temp = x[i];
                  x[i] = x[i+1];
                  x[i+1] = temp;
                  swap = true;
                }
              }
            }
        }
    }
}
