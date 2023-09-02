//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int[N][W+1];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        return func(N,W,val,wt,0,dp);
    }
    public static int func(int N,int W,int val[],int wt[],int ind,int dp[][])
    {
        if(W<=0)
        return 0;
        if(ind>=N)
        return 0;
        if(dp[ind][W]!=-1)
        return dp[ind][W];
        int take=0,notake=0;
        if(W>=wt[ind])
        {
            take=val[ind]+func(N,W-wt[ind],val,wt,ind,dp);
        }
        notake=func(N,W,val,wt,ind+1,dp);
        dp[ind][W]=Math.max(take,notake);
        return dp[ind][W];
    }
}