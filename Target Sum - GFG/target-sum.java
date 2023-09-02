//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        int S=0;
        for(int j=0;j<N;j++)
        S=S+A[j];
        int dp[][]=new int[N][2*S+1];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        return func(A,N,0,0,target,dp,S);
        
    }
    public static int func(int [] A,int N,int ind,int sum,int target,int dp[][],int S)
    {
        
        if(ind>=N)
        {
            if(sum==target)
            return 1;
            else
            return 0;
        }
        if(dp[ind][sum+S]!=-1)
        return dp[ind][sum+S];
        int plus=0, minus=0;
        plus=func(A,N,ind+1,sum+A[ind],target,dp,S);
        minus=func(A,N,ind+1,sum-A[ind],target,dp,S);
        dp[ind][sum+S]=plus+minus;
        return plus+minus;
        
    }
};