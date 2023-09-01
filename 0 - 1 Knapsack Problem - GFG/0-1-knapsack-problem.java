//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]=new int[n][W+1];
         for(int i=0;i<n;i++)
         Arrays.fill(dp[i],0);
         
         for(int i=0;i<W+1;i++)
         {
             if(i>=wt[0])
             dp[0][i]=val[0];
             
         }
         for(int i=1;i<n;i++)
         {
             for(int j=0;j<W+1;j++)
             {
                 int take=0,notake=0;
                 if(j>= wt[i])
                 take=val[i]+dp[i-1][j-wt[i]];
                 notake=dp[i-1][j];
                 dp[i][j]=Math.max(take,notake);
             }
         }
         return dp[n-1][W];
         
    } 
}


