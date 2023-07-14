//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int maxlen=0,sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
            if(sum==0)
            {
            maxlen=Math.max(maxlen,i+1);
            }
            if(hm.containsKey(sum-0))
            {
                maxlen=Math.max(maxlen,i-hm.get(sum-0));
            }
            if(!hm.containsKey(sum))
            {
                hm.put(sum,i);
            }
        }
        return maxlen;
    }
}