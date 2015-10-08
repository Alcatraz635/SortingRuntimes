/**
 * 
 */
package sortingRuntimes;


/**
 * @author tylerschumacher
 *
 */

public class QuickSort extends SortingUtils
{
    public void invoke()
    {
        double total;
        long startTime;
        long endTime;
        TableBuilder tb = new TableBuilder();
        System.out.println("\nFinding average runtime for Quick Sort in nanoseconds...\n");
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
                qSort(x,0,x.length-1);
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
        System.out.println("Average runtime for Quick Sort is O(n log(n))");
    }
    private void qSort(int [] x, int l, int r)
    {
      if (l > r)
      {
          return;
      }
      else
      {
        int splitpt = split(x,l,r);
        qSort(x, l, splitpt-1);
        qSort(x, splitpt+1, r);
      }
    }
    private int split(int[] x, int l, int r)
     {
         int split = x[r];
         int i = l-1;
         int temp=0;
         for(int j=l; j<r-1; j++)
         {
             if(x[j]<=split)
             {
                 i++;
                 temp = x[i];
                 x[i] = x[j];
                 x[j] = temp;
             }
         }
         temp = x[i+1];
         x[i+1] = x[r];
         x[r] = temp;
         return (i+1);
    }
}
