//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        Solution obj=new Solution();
        return obj.cal(price,n,dp);
    }
    public int cal(int price[],int n,int dp[])
    {
        if(n==0)
        return 0;
     if(n==1)
     return price[n-1];
     else if(dp[n-1]!=-1)
     return dp[n-1];
     else
     {
         int val=Integer.MIN_VALUE;
         for(int i=1;i<=n/2;i++)
         {
             val=Math.max(val,cal(price,i,dp)+cal(price,n-i,dp));
             
         }
         val=Math.max(val,price[n-1]);
         dp[n-1]=val;
         return val;
     }
    }
}