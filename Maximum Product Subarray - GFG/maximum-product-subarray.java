//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long f=0,sum=(long)1,sumneg=Integer.MIN_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum*(long)arr[i];
           // System.out.println("slkum"+sum+"max"+max);
            if(f==1)
            sumneg=sumneg*(long)arr[i];
            max=Math.max(sumneg,Math.max(max,sum));
            
            //System.out.println("num"+arr[i]+"sum"+sum+"max"+max);
            if(sum==0)
            {
                sum=1;
                sumneg=Integer.MIN_VALUE;
                f=0;
            }
            else if(sum<0)
            {
                if(f==0)
                {
                    f=1;
                    sumneg=1;
                    
                    
                }
            }
        }
        return max;
    }
}