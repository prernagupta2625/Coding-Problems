//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[N][sum+1];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        return func(coins,N,sum,dp,0);
    }
    public static long func(int coins[],int N,int sum,long dp[][],int ind)
    {
       
       if(sum<0)
       return 0;
        if(ind>=N)
        return 0;
        if(dp[ind][sum]!=-1)
        return dp[ind][sum];
        long take=0,notake=0;
        if(sum>coins[ind])
        take=func(coins,N,sum-coins[ind],dp,ind);
         if(sum==coins[ind])
         take=take+1;
        notake=func(coins,N,sum,dp,ind+1);
        dp[ind][sum]=take+notake;
        return dp[ind][sum];
    }
}