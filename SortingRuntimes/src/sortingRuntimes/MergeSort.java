/**
 * 
 */
package sortingRuntimes;

/**
 * @author tylerschumacher
 *
 */
public class MergeSort extends SortingUtils
{
    public void invoke()
    {
        double total;
        long startTime;
        long endTime;
        TableBuilder tb = new TableBuilder();
        System.out.println("\nFinding average runtime for Merge Sort in nanoseconds...\n");
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
                mSort(x,0,x.length-1 );
                endTime = System.nanoTime();
                total = total + (endTime - startTime);
            }
            double av = total/30;
            double av2 = av/n;
            double av3 = av/(n*n);
            double av4 = av/(n*Math.log(n));
            tb.addRow(Double.toString(n), Double.toString(round(av,4)) + " ns.",Double.toString(round(av2,4)) + " ns.", Double.toString(round(av3,4)) + " ns.", Double.toString(round(av4,4)) + " ns.");
        }
        System.out.println(tb.toString());
        System.out.println("Average runtime for Merge Sort is O(n log(n))");
    }
    private void mSort(int [] x, int l, int r)
    {
      int m;
      if (r == l)
      {
          return;
      }
      else
      {
        m = (r + l) / 2;
        mSort(x, l, m);
        mSort(x, (m + 1), r);
        merge(x, l, (m+1), r);
      }
    }
    private void merge(int [] x, int l, int m, int r)
      {
        int [] temp = new int[x.length];
        int leftLimit = (m - 1);
        int k = l;
        int length = (r - l + 1);
        while ((l <= leftLimit) && (m <= r))
        {
            if (x[l] <= x[m])
            {
                temp[k++] = x[l++];
                
            }
            else
            {
                temp[k++] = x[m++];
            }
        }
        while (l <= leftLimit)
        {
            temp[k++] = x[l++];
        }
        while (m <= r)
        {
            temp[k++] = x[m++];
        }
        for (int i = 0; i < length; i++)
        {
            x[r] = temp[r];
            r--;
        }
    }
}
